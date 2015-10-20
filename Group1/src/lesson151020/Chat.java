package lesson151020;

public interface Chat {

	void received(SocketHandler socketHandler, String line);

	void register(SocketHandler client);

}
