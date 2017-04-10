import java.math.BigDecimal;

public class ProductHash {

    private LinkedList<Product>[] products;

    public ProductHash(int capacity){
        products = new LinkedList[capacity];
    }

    public void add(Product product){
        int hashValue = hashValue(product.getCode());
        if (products[hashValue] == null) {
            products[hashValue] = new LinkedList<>();
            products[hashValue].add(product);
        }else {
            products[hashValue].add(product);
        }
    }

    public Product getByCode(int code){
        int hashValue = hashValue(code);
        LinkedList<Product> productsList = products[hashValue];
        Product productByCode = null;
        if (productsList != null){
            for (Product product : productsList) {
                if (product.getCode() == code){
                    productByCode = product;
                    break;
                }
            }
        }
        return productByCode;
    }

    public Product getByName(String name){
        Product productByName = null;
        for (Product product : getProducts()) {
            if (product.getName().equals(name)){
                productByName = product;
                break;
            }
        }
        return productByName;
    }

    public boolean removeProduct(int code){
        int hashValue = hashValue(code);
        if (products[hashValue] != null){
            for (Product product : products[hashValue]) {
                if (product.getCode() == code) {
                    return products[hashValue].remove(product);
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public Product cheapestProduct(){
        Product productByName = null;
        BigDecimal cheap = BigDecimal.valueOf(Double.MAX_VALUE);
        for (Product product : getProducts()) {
            if (product.getPrice().doubleValue() < cheap.doubleValue()){
                productByName = product;
                cheap = product.getPrice();
                break;
            }
        }
        return productByName;
    }

    public Iterable<Product> getProducts(){
        LinkedList<Product> productsList = new LinkedList<>();
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                productsList.addAll(products[i]);
            }
        }
        return productsList;
    }

    private int hashValue(int code){
        return code % products.length;
    }
 }
