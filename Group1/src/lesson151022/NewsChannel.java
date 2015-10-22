package lesson151022;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import lesson151008.Utils;

public class NewsChannel {

	public static void main(String[] args) {

		final NewsChannel newsChannel = new NewsChannel();

		newsChannel.register(new NewsMaker() {

			@Override
			public String getNews() {
				return "no news";
			}

		});

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Start broadcasting");
				while (true) {
					newsChannel.broadcastNews();
					Utils.pause(3000);
				}
			}
		}).start();
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				String command = scanner.nextLine();
				newsChannel.process(command);
			}
		}

	}
	
	private void process(String command) {
		try {
			Class<?> clazz = Class.forName(command);
			NewsMaker newsMaker = (NewsMaker)clazz.newInstance();
			register(newsMaker);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			System.out.println("Wrong news maker name. Try again.");
		}
	}

	private List<NewsMaker> newsMakers = new CopyOnWriteArrayList<>();

	protected void broadcastNews() {
		for (NewsMaker newsMaker : newsMakers) {
			System.out.println(newsMaker.getNews());
		}
	}


	private void register(NewsMaker newsMaker) {
		newsMakers.add(newsMaker);
	}

}
