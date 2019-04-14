package alejandro.lajusticia.recommendation;

import alejandro.lajusticia.recommendation.view.application.exception.WrongViewFormatException;
import alejandro.lajusticia.recommendation.view.domain.service.ViewService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class RecommendationApplication implements CommandLineRunner {

	private final ViewService viewService;

	public RecommendationApplication(final ViewService viewService) {
		this.viewService = viewService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RecommendationApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Path dataSetPath = Paths.get("src/main/resources/21B_tag_views_dataset.csv");

		try {
			Files.lines(dataSetPath)
					.forEach(view -> {
						try {
							viewService.processView(view);
						} catch (WrongViewFormatException e) {
							System.out.println("Error on view: " + view);
							e.printStackTrace();
						}
					});
		} catch (IOException e) {
			System.out.println("Error getting data from fixed data set");
			e.printStackTrace();
		}

	}
}
