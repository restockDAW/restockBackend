/*
 * 
 * $author
 */
package restock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * The Class ReStockApplication.
 */
@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = { "restock.*"})
public class ReStockApplication{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(ReStockApplication.class, args);
	}
	
	private static Class<ReStockApplication> applicationClass = ReStockApplication.class;

	/**
	 * Configure.
	 *
	 * @param application the application
	 * @return the spring application builder
	 */
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}


	
}
