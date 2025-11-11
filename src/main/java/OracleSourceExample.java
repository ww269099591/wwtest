import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.cdc.debezium.JsonDebeziumDeserializationSchema;
import org.apache.flink.cdc.connectors.oracle.OracleSource;

public class OracleSourceExample {
  public static void main(String[] args) throws Exception {
     SourceFunction<String> sourceFunction = OracleSource.<String>builder()
             .hostname("192.168.140.81")
             .port(14174)
             .database("hlddb") // monitor XE database
             .schemaList("flinkuser") // monitor inventory schema
             .tableList("flinkuser.T_ORDER_PAY_INFO_1") // monitor products table
             .username("flinkuser")
             .password("Fdsx_TUHC6")
             .deserializer(new JsonDebeziumDeserializationSchema()) // converts SourceRecord to JSON String
             .build();

     StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

     env
        .addSource(sourceFunction)
        .print().setParallelism(1); // use parallelism 1 for sink to keep message ordering   
     
     env.execute();
  }
}