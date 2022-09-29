package web.vo;

public class Camping {
	private int campingNo;
	private String name;
	private String info;
	private int price;
	private String address;
	private String imgPath;
	private String imgName;
	
	public Camping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCampingNo() {
		return campingNo;
	}

	public void setCampingNo(int campingNo) {
		this.campingNo = campingNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImgPath() {
		return imgPath;
	}

	@Override
	public String toString() {
		return "Camping [campingNo=" + campingNo + ", name=" + name + ", info=" + info + ", price=" + price
				+ ", address=" + address + ", imgPath=" + imgPath + ", imgName=" + imgName + "]";
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

}