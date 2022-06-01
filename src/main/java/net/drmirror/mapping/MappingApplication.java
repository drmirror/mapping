package net.drmirror.mapping;

import java.util.List;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@SpringBootApplication
public class MappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
		
		MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoTemplate template = new MongoTemplate(client, "test");
        
		Query q = new Query();
		SimpleDocument d = template.findOne(q, SimpleDocument.class, "data");
		
		long start = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			List<SimpleDocument> result = template.find(q, SimpleDocument.class, "data");
		}
		
		System.out.println("total time: " + (System.currentTimeMillis()-start));
	}

}
