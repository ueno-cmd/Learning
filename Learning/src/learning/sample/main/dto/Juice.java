package learning.sample.main.dto;

/**
 *Juiceクラス 
 *dtoとは：Data Transfer Object（データの受け渡し専用のクラス）
 */
public class Juice {
//	メンバー変数の定義
	private String flavor;
	private int price;
	
//	コンストラクタ
	public Juice(String flavor, int price) {
		this.flavor = flavor;
		this.price = price;
	}
	
	public String getFlavor() {
		return this.flavor;
	}
	
	public int getPrice() {
		return this.price;
	}
	

}
