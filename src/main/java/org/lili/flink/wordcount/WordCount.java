package org.lili.flink.wordcount;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.utils.ParameterTool;


public class WordCount {

    public WordCount() {
    }

    public static void main(String[] args) throws Exception {
        ParameterTool params = ParameterTool.fromArgs(args);
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().setGlobalJobParameters(params);
        Object text;
        if (params.has("input")) {
            text = env.readTextFile(params.get("input"));
        } else {
            System.out.println("Executing WordCount example with default input data set.");
            System.out.println("Use -- input to specify file input.");
            text = WordCountData.getDefaultTextLineDataset(env);
        }

        AggregateOperator counts = ((DataSet) text).flatMap(new WordCountTokenizer()).groupBy(new int[]{0}).sum(1);
        if (params.has("output")) {
            counts.writeAsCsv(params.get("output"), "\n", " ");
            env.execute();
        } else {
            System.out.println("Printing result to stdout. Use --output to specify output path.");
            counts.print();
        }

    }
}