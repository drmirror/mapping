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
public class SingleDeserializationBenchmark {

	private MongoClient client;
	private MongoTemplate template;
	private Query query;
	
	@Setup(Level.Trial)
	public void setup() {
		client = MongoClients.create("mongodb://localhost:27017");
		template = new MongoTemplate(client, "test");
		query = new Query();
	}
	
	@Benchmark
	public Document testSimpleDocumentUnmapped() {
		Document result = template.findOne(query, Document.class, "dataSimpleDocument");
		return result;
		
	}
	
	@Benchmark
	public SimpleDocument testSimpleDocumentMapped() {
		SimpleDocument result = template.findOne(query, SimpleDocument.class, "dataSimpleDocument");
		return result;
	}
	
	@Benchmark
	public Document testSimpleDocumentStringUnmapped() {
		Document result = template.findOne(query, Document.class, "dataSimpleDocumentString");
		return result;
	}

	@Benchmark
	public SimpleDocumentString testSimpleDocumentStringMapped() {
		SimpleDocumentString result = template.findOne(query, SimpleDocumentString.class, "dataSimpleDocumentString");
		return result;
	}
	
	@Benchmark
	public Document testManyFieldsDocumentUnmapped() {
		Document result = template.findOne(query, Document.class, "dataManyFieldsDocument");
		return result;
	}

	@Benchmark
	public ManyFieldsDocument testManyFieldsDocumentMapped() {
		ManyFieldsDocument result = template.findOne(query, ManyFieldsDocument.class, "dataManyFieldsDocument");
		return result;
	}
	
	@Benchmark
	public Document testManyFieldsDocumentStringUnmapped() {
		Document result = template.findOne(query, Document.class, "dataManyFieldsDocumentString");
		return result;
	}

	@Benchmark
	public ManyFieldsDocumentString testManyFieldsDocumentStringMapped() {
		ManyFieldsDocumentString result = template.findOne(query, ManyFieldsDocumentString.class, "dataManyFieldsDocumentString");
		return result;
	}
	
	@Benchmark
	public Document testManyFieldsDocumentNestedUnmapped() {
		Document result = template.findOne(query, Document.class, "dataManyFieldsDocumentNested");
		return result;
	}

	@Benchmark
	public ManyFieldsDocumentNested testManyFieldsDocumentNestedMapped() {
		ManyFieldsDocumentNested result = template.findOne(query, ManyFieldsDocumentNested.class, "dataManyFieldsDocumentNested");
		return result;
	}
	
	@Benchmark
	public Document testArrayDocumentUnmapped() {
		Document result = template.findOne(query, Document.class, "dataArrayDocument");
		return result;
	}

	@Benchmark
	public ArrayDocument testArrayDocumentMapped() {
		ArrayDocument result = template.findOne(query, ArrayDocument.class, "dataArrayDocument");
		return result;
	}
	
	@Benchmark
	public Document testArrayDocumentNestedUnmapped() {
		Document result = template.findOne(query, Document.class, "dataArrayDocumentNested");
		return result;
	}

	@Benchmark
	public ArrayDocumentNested testArrayDocumentNestedMapped() {
		ArrayDocumentNested result = template.findOne(query, ArrayDocumentNested.class, "dataArrayDocumentNested");
		return result;
	}
	
}
