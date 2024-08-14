package learning.sample.main;

import learning.sample.main.dto.Juice;
import learning.sample.main.login.VendingMachine;

/**
 * 学習用 Javaロジック実行メインクラス
 */
public class LearningMainApplication {
	/**
	 * メイン処理
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 課題1
		sample01();
		sample02();
		sample03();
		sample04();
		sample05();
	}

	/**
	 * ジュースクラスの作成
	 * 
	 * <p>
	 * 1. Juiceクラスをdtoパッケージに作成してください。Juiceクラスには、金額と味を設定できるようにしてください。<br>
	 * 2.作ったクラスで、下記のインスタンスを作成し、味と金額をコンソールに出力してください。<br>
	 * <li>インスタンス１】味：コーラ、金額：110円
	 * <li>インスタンス２】味：レッドブル、金額：220円
	 * </p>
	 */
	public static void sample01() {
		System.out.println("-----[sample01]-----");
		//		インスタンス作成
		Juice juice1 = new Juice("コーラ", 110);
		Juice juice2 = new Juice("レッドブル", 220);

		//		コンソールに出力
		System.out.println("味:" + juice1.getFlavor() + "、" + "金額:" + juice1.getPrice() + "円");
		System.out.println("味:" + juice2.getFlavor() + "、" + "金額:" + juice2.getPrice() + "円");
	}

	/**
	 * 自動販売機の作成
	 * 
	 * <p>
	 * 1. Juiceクラスを出力するVendingMachineクラスをloginパッケージに作成してください。<br>
	 * VendingMachineクラスは、Jucieクラスのインスタンスを複数保持できるようにしてください。<br>
	 * VendingMachineクラスには、金額と味を指定することで、条件に合致するJucieクラスのインスタンスを一つ返却する機能を用意してください。<br>
	 * 2. 作ったクラスで、下記のインスタンスを作成し、処理を実行してください。<br>
	 * VendingMachineクラスに下記のJucieインスタンスを保持させてください。<br>
	 * <p>
	 * Jucieインスタンス
	 * </p>
	 * <li>1: 味：コーラ、金額：110円
	 * <li>2: 味：ファンタグレープ、金額：110円
	 * <li>3: 味：ミネラルウォータ、金額：100円
	 * <li>4: 味：レッドブル、金額：220円
	 * <li>5: 味：モンスター、金額：220円 <br>
	 * 3. 実行する処理 各Jucieインスタンスを取得して、味と金額を各々コンソールに出力してください。<br>
	 * 取得したJucieインスタンスは、VendingMachineから削除してください。
	 * </p>
	 */
	public static void sample02() {
		System.out.println("-----[sample02]-----");
		VendingMachine vm = new VendingMachine();

		vm.addJuice(new Juice("コーラ", 110));
		vm.addJuice(new Juice("ファンタグレープ", 110));
		vm.addJuice(new Juice("ミネラルウォーター", 100));
		vm.addJuice(new Juice("レッドブル", 220));
		vm.addJuice(new Juice("モンスター", 220));

		Juice foundJuice = vm.findJuices("コーラ", 110);
		if (foundJuice != null) {
			System.out.println("-----検索結果-----");
			System.out.println("味: " + foundJuice.getFlavor() + ", 金額: " + foundJuice.getPrice() + "円");
		} else {
			System.out.println("No matching juice found.");
		}

		// リスト内のジュースを出力
		System.out.println("-----味と金額を各々コンソールに出力-----");
		vm.printAll();

		// リストを空にする
		vm.clearList();
	}

	/**
	 * 売り上げ管理機能追加
	 * 
	 * <p>
	 * 1. VendingMachineクラスに以下の機能を追加してください。<br>
	 * 投入した金額を加算して保持するようにしてください。<br>
	 * 金額を出力処理を作成してください。<br>
	 * 金額を出力したら保持している金額は削除してください。<br>
	 * 2. 作った機能で処理を実行してください。<br>
	 * sample02と同じ処理を行い、最終的な加算金額を出力、コンソールに出力してください。
	 * </p>
	 */
	public static void sample03() {
		System.out.println("-----[sample03]-----");
		VendingMachine vm = new VendingMachine(2000);
		System.out.println(vm.getMoney() + "円");
	}

	/**
	 * ジュース在庫管理機能
	 * 
	 * <p>
	 * 1. VendingMachineクラスに以下の機能を追加してください。<br>
	 * 同じ味のJuiceインスタンスを複数保持できるようにしてください。<br>
	 * 保持した味のJucieインスタンスの味ごとの数を確認できるようにしてください。<br>
	 * 2. 作った機能で処理を実行してください。<br>
	 * 下記のJucieインスタンスを保持してください。<br>
	 * <li>コーラ：３
	 * <li>ファンタグレープ：２
	 * <li>ミネラルウォータ：１１
	 * <li>レッドブル：５
	 * <li>モンスター：１ <br >
	 * 保持したジュースの数を出力、コンソールに出力してください。
	 * </p>
	 */
	public static void sample04() {
		System.out.println("-----[sample04]-----");
		VendingMachine vm = new VendingMachine();
		// JuiceインスタンスをVendingMachineに追加
		vm.addJuice(new Juice("コーラ", 110));
		vm.addJuice(new Juice("コーラ", 110));
		vm.addJuice(new Juice("ファンタグレープ", 110));
		vm.addJuice(new Juice("ミネラルウォーター", 100));
		vm.addJuice(new Juice("レッドブル", 220));
		vm.addJuice(new Juice("モンスター", 220));
		vm.addJuice(new Juice("コーラ", 110)); // コーラの数を増やす

		// 各味のJuiceインスタンスの数を表示
		System.out.println("コーラの数: " + vm.countJuiceByFlavor("コーラ"));
		System.out.println("ファンタグレープの数: " + vm.countJuiceByFlavor("ファンタグレープ"));
		System.out.println("ミネラルウォーターの数: " + vm.countJuiceByFlavor("ミネラルウォーター"));
		System.out.println("レッドブルの数: " + vm.countJuiceByFlavor("レッドブル"));
		System.out.println("モンスターの数: " + vm.countJuiceByFlavor("モンスター"));
	}

	/**
	 * 不足機能検討と実装
	 * 
	 * <p>
	 * sample04 までに作った機能を駆使して、自動販売機として足りないものを想像して、実装してください。<br>
	 * ⇒設定された金額2000円
	 * ⇒購入すると金額が減っていく、商品の在庫も減っていく
	 * ⇒金額がなくなるまたは商品がなくなるとエラーが起こる
	 * ⇒売上を記録する（投入された金額）
	 * 完成した自動販売機機能で好きなようにロジックを組んでください。
	 * </p>
	 */
	public static void sample05() {
		System.out.println("-----[sample05]-----");
		// TODO
	}
}
