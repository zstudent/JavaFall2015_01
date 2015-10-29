package lesson151029;

public class CasCounter {

	private SimulateCompareAnsSwap value;

	public int getValue() {
		return value.get();
	}

	public int increment() {
		int v;
		do {
			v = value.get();  // 5
			// someone else did something  6
		} while (v != value.compareAndSwap(v, v + 1));
		return v + 1;
	}

}
