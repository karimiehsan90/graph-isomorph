package ir.ac.sbu.project;

import ir.ac.sbu.project.entity.Edge;
import ir.ac.sbu.project.entity.Node;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.graphframes.GraphFrame;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("a"));
        nodes.add(new Node("b"));
        nodes.add(new Node("c"));
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge("a", "b"));
        edges.add(new Edge("b", "c"));
        SparkSession sparkSession = SparkSession.builder().appName("mapred").master("local").getOrCreate();
        JavaSparkContext javaSparkContext = JavaSparkContext.fromSparkContext(sparkSession.sparkContext());
        JavaRDD<Node> nodesRDD = javaSparkContext.parallelize(nodes, 1);
        JavaRDD<Edge> edgesRDD = javaSparkContext.parallelize(edges, 1);
        Dataset<Row> nodesDF = sparkSession.createDataFrame(nodesRDD, Node.class);
        Dataset<Row> edgesDF = sparkSession.createDataFrame(edgesRDD, Edge.class);
        GraphFrame graphFrame = GraphFrame.apply(nodesDF, edgesDF);
        Dataset<Row> rowDataset = graphFrame.find("(s)-[e]->(d); (d)-[e1]->(d2)").select("d2");
        rowDataset.show(false);
    }
}
