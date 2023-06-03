package com.mongopoc.mongodbpoc;

import com.mongopoc.mongodbpoc.category.Category;
import com.mongopoc.mongodbpoc.category.CategoryRepository;
import com.mongopoc.mongodbpoc.product.Product;
import com.mongopoc.mongodbpoc.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.data.mongodb.UncategorizedMongoDbException;

@SpringBootApplication
public class MongodbPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbPocApplication.class, args);
	}

	// @Bean
	public CommandLineRunner commandLineRunner(ProductRepository repository,
											   CategoryRepository categoryRepository) {
		return args -> {
			var category = Category.builder()
					.name("cat 1")
					.description("cat 1")
					.build();

			var category2 = Category.builder()
					.name("cat 2")
					.description("cat 2")
					.build();
			categoryRepository.insert(category);
			categoryRepository.insert(category2);
			var product = Product.builder()
					.name("iPhone")
					.description("Smart phone")
					.build();
			// repository.insert(product);
		};
	}
}
