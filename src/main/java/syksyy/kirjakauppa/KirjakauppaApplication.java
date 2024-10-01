package syksyy.kirjakauppa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import syksyy.kirjakauppa.domain.Book;
import syksyy.kirjakauppa.domain.BookRepository;
import syksyy.kirjakauppa.domain.Category;
import syksyy.kirjakauppa.domain.CategoryRepository;
import syksyy.kirjakauppa.domain.UserRepository;

@SpringBootApplication
public class KirjakauppaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		return (args) -> {

			Category category1 = new Category("Romance");
			Category category2 = new Category("Novel");
			Category category3 = new Category("Crime");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			Book book1 = new Book("Kasvoton kuolema", "Hennig Mankell", 2000, "000-0-000000-00-0", 12.0, category3);
			Book book2 = new Book("Riian verikoirat", "Hennig Mankell", 2000, "111-1-111111-11-1", 13.0, category2);
			bookRepository.save(book1);
			bookRepository.save(book2);		

		};

	}

}
