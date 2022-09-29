package web.vo;

public class Item {
	
	private int itemNo;
	private String name;
	private int price;
	private String info;
	private String imgPath;
	private String imgName;
	
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	
	public Item() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", name=" + name + ", price=" + price + ", info=" + info + ", imgPath="
				+ imgPath + ", imgName=" + imgName + "]";
	}

	
	
}
