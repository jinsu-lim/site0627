/*
 * 고객이 선택한 상품을 저장할 수 있는 DTO, VO 정의
 */

package shop;

public class Cart {
	private String name;
	private int ea;
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
