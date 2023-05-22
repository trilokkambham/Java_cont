import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductService {
    List<Product> products=new ArrayList<>();
    ProductDB db=new ProductDB();

    public ProductService() throws SQLException {
    }


    public void addproduct(Product p){

        //products.add(p);

        db.save(p);
    }
    public List<Product> printproduct(){

        return db.getAll();
    }
    public Product getproduct(String name){
        /*for(Product p: products){
            if(p.getName().equals(name)){
                return p;
            }
        }*/
        return db.getproductbyname(name);
    }
    public List<Product> getproductsbytext(String text){
        String str=text.toLowerCase();
        List<Product> prod=new ArrayList<>();

        for(Product o:prod){
            String name=o.getName().toLowerCase(Locale.ROOT);
            String place=o.getPlace().toLowerCase(Locale.ROOT);
            if(name.contains(str) || place.contains(str)){
                prod.add(o);
            }
        }
        return prod;
    }
    public List<Product> getproductsinplace(String text){
        String str1=text.toLowerCase(Locale.ROOT);
        List<Product> prods=new ArrayList<>();

        for(Product o:products){
            String p1=o.getPlace().toLowerCase(Locale.ROOT);
            if(p1.equals(str1)){
                prods.add(o);
            }
        }
        return prods;
    }

    public List<Product> getproductsoutofwarranty(int year){

        List<Product> produs=new ArrayList<>();
        for(Product o:products){
            if(o.getWarranty()<=year){
                produs.add(o);
            }
        }
        return produs;
    }
}
