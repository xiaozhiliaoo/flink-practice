# 问题

数据中台Flink部署模型：部署K8S，十几个集群，集群隔离，资源隔离，fashion部署模式，状态存储：使用rocksdb持久化。

source (mysql,ticdc)和sink是什么？

flink和spring结合？无

beam想法好，但是不一定适用于工程。

flink灵活性强于kafka stream/jet, 项目里面不够解耦。flink中rpc达到类似效果。

实际使用有状态的操作有哪些？积攒数据批量插入。

JOIN算子(双流JOIN无案例，可能会丢失数据，使用外部存储进行JOIN)。

事件时间处理案例有哪些？以及设置水位线这种复杂例子？迟到事件的处理例子？

source有哪些？sink有哪些？source sink之外的算子阶段，会读取外部存储吗？

apache beam使用多吗？统一批处理和流处理

分布式计算，并行计算，遗传算法（迭代算法）等复杂计算用flink or spark？

5T文件计数 Spark是怎么计算的？MR是怎么计算的？

ETL工具。直接挂Kafka消费者也没区别。

Kappa架构。流批一体，批到底是啥？

异步IO：mysql，可以用，也可以不用