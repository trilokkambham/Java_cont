import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProductService service=new ProductService();

        /*service.addproduct(new Product("Asus Vivobook","Laptop","Black Table",2022));
        service.addproduct(new Product("Macbook Air","Laptop","Brown Table",2024));
        service.addproduct(new Product("iMac","PC","Black Table",2023));
        service.addproduct(new Product("Dell Mouse","Mouse","White Table",2021));*/
        //getting all the products from service
        List<Product> products=service.printproduct();
        //printing all products that we got from service using enhanced for loop
        for(Product p: products){
            System.out.println(p);
        }
        System.out.println("***************");
        //getting a single product from the services
        Product p= service.getproduct("iMac");
        System.out.println(p);

        System.out.println("***************");
        //getting the multiple products with test
        List<Product> prod=service.getproductsbytext("Black");
        for(Product o: prod){
            System.out.println(o);
        }

        System.out.println("***************");
        //getting the products which are at same place
        System.out.println("All products at Black Table");
        List<Product> prods=service.getproductsinplace("Black Table");
        for(Product o: prods){
            System.out.println(o);
        }

        System.out.println("***************");
        //getting the products which are out of warranty
        System.out.println("All products which are out of warranty");
        List<Product> produs=service.getproductsoutofwarranty(2022);
        for(Product o: produs){
            System.out.println(o);
        }
    }
}
