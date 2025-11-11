import org.apache.flink.cdc.connectors.base.options.StartupOptions;
import org.apache.flink.cdc.connectors.base.source.jdbc.JdbcIncrementalSource;
import org.apache.flink.cdc.connectors.oracle.source.OracleSourceBuilder;
import org.apache.flink.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Properties;

public class OracleParallelSourceExample {

    public static void main(String[] args) throws Exception {
        Properties debeziumProperties = new Properties();
        debeziumProperties.setProperty("log.mining.strategy", "online_catalog");

        JdbcIncrementalSource<String> oracleChangeEventSource =
                new OracleSourceBuilder()
                        .hostname("10.169.140.212")
                        .port(14174)
                        .databaseList("hlddb")
                        .schemaList("flinkuser")
                        .tableList("FLINKUSER.T_ORDER_PAY_INFO_1")
                        .username("flinkuser")
                        .password("Fdsx_TUHC6")
                        .deserializer(new JsonDebeziumDeserializationSchema())
                        .includeSchemaChanges(true) // output the schema changes as well
                        .startupOptions(StartupOptions.initial())
                        .debeziumProperties(debeziumProperties)
                        .splitSize(2)
                        .build();

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // enable checkpoint
        env.enableCheckpointing(3000L);
        // set the source parallelism to 4
        env.fromSource(
                        oracleChangeEventSource,
                        WatermarkStrategy.noWatermarks(),
                        "OracleParallelSource")
                .setParallelism(4)
                .print()
                .setParallelism(1);
        env.execute("Print Oracle Snapshot + RedoLog");
    }
}