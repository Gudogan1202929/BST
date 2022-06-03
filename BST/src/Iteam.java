import java.util.Date;

public class Iteam implements Comparable<Iteam> {
	private int code;
	private String names;
	private double price;
	private int amount;
	private Date reciveData;
	private Date expairData;

	public Iteam(int code, String names, double price, int amount, Date reciveData, Date expairData) {
		super();
		this.code = code;
		this.names = names;
		this.price = price;
		this.amount = amount;
		this.reciveData = reciveData;
		this.expairData = expairData;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getReciveData() {
		return reciveData;
	}

	public void setReciveData(Date reciveData) {
		this.reciveData = reciveData;
	}

	public Date getExpairData() {
		return expairData;
	}

	public void setExpairData(Date expairData) {
		this.expairData = expairData;
	}

	@Override
	public String toString() {
		return "Iteam [code=" + code + ", names=" + names + ", price=" + price + ", amount=" + amount + ", reciveData="
				+ reciveData + ", expairData=" + expairData + "]";
	}

	@Override
	public int compareTo(Iteam o) {

		if (code > o.code) {
            return 1;
        }
        else if (code == o.code) {
            return 0;
        }
        else {
            return -1;
        }
	}

	}
