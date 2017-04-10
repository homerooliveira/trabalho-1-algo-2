import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	private static ProductManager productManager;
	private static Scanner scanner;

	public static void main(String[] args) {
		productManager = new ProductManager();
		scanner = new Scanner(System.in);
		short choice = 0;
		do {
			System.out.println("Menu \n1-Cadastar produto\n2-Bucar produto pelo código" +
					"\n3-Buscar produto pelo nome\n4-Remover produto pelo código" +
					"\n5-Produto mais barato\n6-Exibir todos os produtos" +
					"\n0-Sair");
			System.out.println("Dígite a escolha :");
			try{
				choice = scanner.nextShort();
			}catch (InputMismatchException e){
				System.out.println("Somente números");
			}

			menu(choice);

		}while (choice != 0);
	}

	private static void menu(short choice) {
		switch (choice){
            case 1:
				addProduct();
                break;
            case 2:
				getProductByCode();
                break;
            case 3:
				getProductByName();
                break;
            case 4:
				removeByCode();
                break;
            case 5:
				cheapestProduct();
                break;
            case 6:
				listProducts();
				break;
        }
	}

	private static void listProducts() {
		for (Product product : productManager.getProducts()) {
            System.out.println(product);
        }
	}

	private static void cheapestProduct() {
		Product cheapestProduct = productManager.cheapestProduct();
		if (cheapestProduct != null) {
            System.out.println(cheapestProduct);
        }
	}

	private static void removeByCode() {
		int removeByCode = digitCodeForProduct(scanner);
		boolean removeProduct = productManager.removeProduct(removeByCode);
		if (removeProduct){
            System.out.println("Removido com sucesso");
		} else {
            System.out.println("Código inválido");
        }
	}

	private static void getProductByName() {
		System.out.println("Dígite o nome do produto");
		String name = scanner.next();
		Product productByName = productManager.productByName(name);
		if (productByName != null) {
            System.out.println(productByName);
        }
	}

	private static void getProductByCode() {
		int searchByCode = digitCodeForProduct(scanner);
		Product productByCode = productManager.productByCode(searchByCode);
		if (productByCode != null){
            System.out.println(productByCode);
        }
	}

	private static void addProduct() {
		int code = digitCodeForProduct(scanner);
		if (!(productManager.hasProductByCode(code)) && code >= 0){
            System.out.println("Dígite o nome do produto");
            String name = scanner.next();
            System.out.println("Dígite o setor do produto");
            short sector = scanner.nextShort();
            System.out.println("Dígite o preço do produto");
            BigDecimal price = scanner.nextBigDecimal();
            Product product = new Product(code, name, sector, price);
            productManager.addProduct(product);
            System.out.println("Criado e adicionado com sucesso");
        } else {
            System.out.println("Já existe um produto com este código ou o código inserido foi menor que zero");
        }
	}

	private static int digitCodeForProduct(Scanner scanner){
		System.out.println("Dígite o código do produto");
		return scanner.nextInt();
	}
}
