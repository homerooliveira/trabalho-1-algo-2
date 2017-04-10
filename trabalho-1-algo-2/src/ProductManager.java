import java.util.Objects;

public class ProductManager {

	private ProductHash productHash;

	public ProductManager(){
		productHash = new ProductHash(13);
	}

	public void addProduct(Product product) {
		Objects.requireNonNull(product);
		productHash.add(product);
	}

	public boolean hasProductByCode(int code) {
		return productHash.getByCode(code) != null;
	}

	public Product productByCode(int code){
		return productHash.getByCode(code);
	}

	public Product productByName(String name){
		Objects.requireNonNull(name);
		return productHash.getByName(name);
	}

	public boolean removeProduct(int removeByCode) {
		return productHash.removeProduct(removeByCode);
	}

	public Product cheapestProduct() {
		return productHash.cheapestProduct();
	}

	public Iterable<Product> getProducts() {
		return productHash.getProducts();
	}
}
