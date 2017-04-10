import java.math.BigDecimal;
import java.util.Objects;

public class Product {

	private int code;

	private String name;

	private int sector;

	private BigDecimal price;

	public Product(int code, String name, int sector, BigDecimal price) {
		this.code = code;
		this.name = name;
		this.sector = sector;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public int getSector() {
		return sector;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return code == product.code &&
				sector == product.sector &&
				Objects.equals(name, product.name) &&
				Objects.equals(price, product.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, name, sector, price);
	}

	@Override
	public String toString() {
		return this.name + "  R$:" + price.toString();
	}
}
