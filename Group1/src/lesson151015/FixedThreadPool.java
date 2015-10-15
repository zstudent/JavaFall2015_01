package lesson151015;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(Runtime
				.getRuntime().availableProcessors() / 2);

	}

}
