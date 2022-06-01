package net.drmirror.mapping;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BenchApp {

	public static void main(String[] args) throws RunnerException {
		SpringApplication.run(BenchApp.class, args);	

		Options opt = new OptionsBuilder()
				.include("SingleDeserializationBenchmark.*")
				.forks(5)
				.build();
		
		new Runner(opt).run();
	}
	
	

}
