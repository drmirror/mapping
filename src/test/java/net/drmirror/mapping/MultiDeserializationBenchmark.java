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
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MultiDeserializationBenchmark {

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
	public List<Document> testSimpleDocumentUnmapped() {
		List<Document> result = template.find(query, Document.class, "dataSimpleDocument");
		return result;
		
	}
	
	@Benchmark
	public List<SimpleDocument> testSimpleDocumentMapped() {
		List<SimpleDocument> result = template.find(query, SimpleDocument.class, "dataSimpleDocument");
		return result;
	}
	
	@Benchmark
	public List<Document> testSimpleDocumentStringUnmapped() {
		List<Document> result = template.find(query, Document.class, "dataSimpleDocumentString");
		return result;
	}

	@Benchmark
	public List<SimpleDocumentString> testSimpleDocumentStringMapped() {
		List<SimpleDocumentString> result = template.find(query, SimpleDocumentString.class, "dataSimpleDocumentString");
		return result;
	}
	
	@Benchmark
	public List<Document> testManyFieldsDocumentUnmapped() {
		List<Document> result = template.find(query, Document.class, "dataManyFieldsDocument");
		return result;
	}

	@Benchmark
	public List<ManyFieldsDocument> testManyFieldsDocumentMapped() {
		List<ManyFieldsDocument> result = template.find(query, ManyFieldsDocument.class, "dataManyFieldsDocument");
		return result;
	}
	
	@Benchmark
	public List<Document> testManyFieldsDocumentStringUnmapped() {
		List<Document> result = template.find(query, Document.class, "dataManyFieldsDocumentString");
		return result;
	}

	@Benchmark
	public List<ManyFieldsDocumentString> testManyFieldsDocumentStringMapped() {
		List<ManyFieldsDocumentString> result = template.find(query, ManyFieldsDocumentString.class, "dataManyFieldsDocumentString");
		return result;
	}
	
	@Benchmark
	public List<Document> testManyFieldsDocumentNestedUnmapped() {
		List<Document> result = template.find(query, Document.class, "dataManyFieldsDocumentNested");
		return result;
	}

	@Benchmark
	public List<ManyFieldsDocumentNested> testManyFieldsDocumentNestedMapped() {
		List<ManyFieldsDocumentNested> result = template.find(query, ManyFieldsDocumentNested.class, "dataManyFieldsDocumentNested");
		return result;
	}
	
	@Benchmark
	public List<Document> testArrayDocumentUnmapped() {
		List<Document> result = template.find(query, Document.class, "dataArrayDocument");
		return result;
	}

	@Benchmark
	public List<ArrayDocument> testArrayDocumentMapped() {
		List<ArrayDocument> result = template.find(query, ArrayDocument.class, "dataArrayDocument");
		return result;
	}
	
	@Benchmark
	public List<Document> testArrayDocumentNestedUnmapped() {
		List<Document> result = template.find(query, Document.class, "dataArrayDocumentNested");
		return result;
	}

	@Benchmark
	public List<ArrayDocumentNested> testArrayDocumentNestedMapped() {
		List<ArrayDocumentNested> result = template.find(query, ArrayDocumentNested.class, "dataArrayDocumentNested");
		return result;
	}
	
}
