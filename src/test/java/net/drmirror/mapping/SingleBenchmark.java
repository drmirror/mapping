package net.drmirror.mapping;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bson.Document;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SingleBenchmark {

	private MongoClient client;
	private MongoTemplate template;
	private Query query;
	
	@Setup(Level.Trial)
	public void setup() {
		client = MongoClients.create("mongodb://localhost:27017");
		template = new MongoTemplate(client, "test");
		query = new Query();
	}
	
//	@Benchmark
//	public Document testSingleDocumentUnmapped() {
//		Document result = template.findOne(query, org.bson.Document.class, "dataSimpleDocument");
//		return result;
//	}
//
//	@Benchmark
//	public SimpleDocument testSingleDocumentMapped() {
//		SimpleDocument result = template.findOne(query, SimpleDocument.class, "dataSimpleDocument");
//		return result;
//	}

	@Benchmark
	public Document testArrayDocumentUnmapped() {
		Document result = template.findOne(query, org.bson.Document.class, "dataArrayDocument");
		return result;
	}

	@Benchmark
	public ArrayDocument testArrayDocumentMapped() {
		ArrayDocument result = template.findOne(query, ArrayDocument.class, "dataArrayDocument");
		return result;
	}

}
