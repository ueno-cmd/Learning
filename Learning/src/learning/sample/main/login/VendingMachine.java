package learning.sample.main.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import learning.sample.main.dto.Juice;

/**
 * VendingMachineクラス
 */
public class VendingMachine {
	//	メンバー変数の定義
	private List<Juice> juices;
	private Map<String, Integer> juiceQuantity;
	private int money;

	//	リスト生成
	public VendingMachine() {
		juices = new ArrayList<>();
		juiceQuantity = new HashMap<>();
	}

	// Juiceインスタンスをリストに追加するメソッド
	public void addJuice(Juice juice) {
		juices.add(juice);
		String flavor = juice.getFlavor();
		juiceQuantity.putIfAbsent(flavor, 0);
		juiceQuantity.put(flavor, juiceQuantity.get(flavor) + 1);
	}

	// 金額と味に合致するJuiceインスタンスを検索して返すメソッド
	public Juice findJuices(String flavor, int price) {
		for (Juice juice : juices) {
			if (juice.getFlavor().equals(flavor) && juice.getPrice() == price) {
				return juice;
			}
		}
		return null; // 見つからない場合はnullを返す
	}

	// 味と金額を各々コンソールに出力
	public void printAll() {
		for (Juice juice : juices) {
			System.out.println("味:" + juice.getFlavor() + "、 金額:" + juice.getPrice() + "円");
		}
	}

	// リストを空にするメソッド
	public void clearList() {
		juices.clear();
	}

	//	金額の操作
	public VendingMachine(int money) {
		this.money = money;
	}

	public int getMoney() {
		return this.money;
	}

	// 金額を削除するメソッド
	public void clearMoney() {
		money = 0;
	}

	// 指定された味のJuiceインスタンスの数を返すメソッド
	public int countJuiceByFlavor(String flavor) {
		return juiceQuantity.getOrDefault(flavor, 0);
	}

	// 自動販売機に入金するメソッド
	public void addMoney(int amount) {
		money += amount;
	}

	public void addMoneyFromInput() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("追加する金額を入力してください: ");

		int addedAmount = scanner.nextInt();

		addMoney(addedAmount);
		System.out.println(getMoney() + "円が追加されました");
	}

}
