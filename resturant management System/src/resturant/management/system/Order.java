package resturant.management.system;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private int Id;
    private double price;
    private String Order;
    private final String File_Path = "DataBase/Order.bin";
    private int Id_customer;
    public ArrayList<Order> m = new ArrayList<Order>();

    private final filemanagement obj = new filemanagement();

    public Order() {
    }

    public Order(int Id, String Order, int price, int Id_customer) {
        this.price = price;
        this.Order = Order;
        this.Id = Id;
        this.Id_customer = Id_customer;
    }

    public void setId_customer(int Id_customer)
    {
        this.Id_customer = Id_customer;
    }
    
    public int getId_customer()
    {
        return Id_customer;
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

    public void loadFromFile() {
        try {
            m = (ArrayList< Order>) (Object) obj.read(File_Path);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean commitFile() {
        return obj.write(File_Path, m);
    }

    public boolean add() {
        loadFromFile();
        m.add(this);
        return commitFile();
    }

    private int getIndex(int Id) {
        int len = m.size();
        int k = -1;
        for (int i = 0; i < len; i++) {
            if (m.get(i).Id == Id) {
                k = m.get(i).Id;
            }
        }
        if (k != -1) {
            return k;
        }

        return -1;
    }

    public Order getLastOrder(int Id) {
        loadFromFile();
        int index = getIndex(this.Id);
        return m.get(index);

    }

    public double allPayments(int Id) {
        loadFromFile();
        double sum = 0;
        for (Order m1 : m) {
            if (m1.Id == Id) {
                sum += m1.price;
            }
        }
        return sum;
    }

    public boolean updateOrder() {
        loadFromFile();
        int index = getIndex(Id);
        if (index != -1) {
            m.set(index, this);
        } else {
            return false;
        }

        return commitFile();

    }

    public ArrayList<Order> customerProfile(int Id) {
        loadFromFile();
        ArrayList<Order> k = new ArrayList<Order>();
        for (Order m1 : m) {
            if (m1.getId() == Id) {
                k.add(m1);
            }
        }

        return k;

    }

    public boolean deleteOrder(int Id) {
        loadFromFile();
        int index = getIndex(Id);
        if (index != -1) {
            m.remove(index);
        } else {
            return false;
        }
        return commitFile();
    }

}
