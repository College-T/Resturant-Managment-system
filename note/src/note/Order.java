
package note;
import java.io.Serializable;
import java.util.ArrayList;

public class Order  implements Serializable{
    private double price;
    private String Order;
    private final String File_Path = "Order.bin";
    private int Id;
    public ArrayList<Order> m = new ArrayList<Order>();
    
    private filemanagement obj = new filemanagement();

    public Order() {
    }

    public Order(int price, String Order, int Id) {
        this.price = price;
        this.Order = Order;
        this.Id = Id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrder() {
        return Order;
    }

    public void setOrder(String Order) {
        this.Order = Order;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public void loadFromFile()
    {
        try{
            m = (ArrayList < Order >)(Object) obj.read(File_Path);
//            for(Order k :m)
//            {
//                System.out.println(k.getId()+" "+k.getOrder());
//            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public boolean commitFile()
    {
        return obj.write(File_Path, m);
    }
    public  boolean  add()
    {
        loadFromFile();
        m.add(this);
       return commitFile();
    }
private int getIndex(int Idcustomer)
    {
        int len = m.size();
        int k=-1;
        for(int i = 0; i < len; i++)
        {
            if(m.get(i).Id == Idcustomer)k=i ;
        }
        
            return k;
        

       
    }
    public Order getLastOrder(int Idustomer)
    {
        loadFromFile();
        int index= getIndex(Idustomer);
        return m.get(index);
        
    }
    public double allPayments(int Idcustomer)
    {
        loadFromFile();
        double sum=0;
        for (Order m1 : m) {
            if (m1.Id == Idcustomer) {
                sum += m1.price;
            }
        }
        return sum;
    }
    
    public ArrayList<Order> customerProfile (int idcustomer)
    {
        loadFromFile();
        ArrayList<Order> k=new ArrayList<Order>();
        for(Order m1:m)
        {
            if(m1.getId()==idcustomer)
            {
                k.add(m1);
            }
        }
        
            return k;
        
      
    }
    public boolean deleteOrder (int Id)
    {
        loadFromFile();
        int index =getIndex(Id);
        if(index!=-1)
        m.remove(index);
        else
            return false;
        return commitFile();
    }

    
    
}