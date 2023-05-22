import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    Connection conn=null;
    public ProductDB() throws SQLException {
        conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Product_management","postgres","****");
    }

    public void save(Product p) {
        String query="insert into Products (name,type,place,warranty) values (?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getName());
            st.setString(2, p.getType());
            st.setString(3, p.getPlace());
            st.setInt(4, p.getWarranty());
            st.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<Product> getAll(){
        List<Product> products=new ArrayList<>();
        String query="select name, type, place , warranty from Products";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                products.add(p);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getproductbyname(String name1){
        String query="Select name, type, place, warranty from Products where Products.name=?";
        Product p1=new Product();
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                p1.setName(rs.getString(1));
                p1.setType(rs.getString(2));
                p1.setPlace(rs.getString(3));
                p1.setWarranty(rs.getInt(4));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return p1;
    }
}
