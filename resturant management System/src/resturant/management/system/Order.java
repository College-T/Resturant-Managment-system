package resturant.management.system;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable, standard_operations {
    private int Id_customer;
    private double price;
    private String Order;
    private final String File_Path = "DataBase/Order.bin";
    public ArrayList<Order> m = new ArrayList<Order>();

    private final filemanagement obj = new filemanagement();

    public Order() {
    }

    public Order(int Id_customer, String Order, int price) {
        this.price = price;
        this.Order = Order;
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
        return Id_customer;
    }

    public void setId(int Id) {
        this.Id_customer = Id;
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
    @Override
    public boolean add() {
        loadFromFile();
        m.add(this);
        return commitFile();
    }

    private int getIndex(int Id) {
        int len = m.size();
        int k = -1;
        for (int i = 0; i < len; i++) {
            if (m.get(i).Id_customer == Id) {
                k = i;
            }
        }
        return k;
    }

    public Order getLastOrder() {
        loadFromFile();
        return m.get(m.size()-1);

    }

    public double allPayments(int Id) {
        loadFromFile();
        double sum = 0;
        for (Order m1 : m) {
            if (m1.getId_customer() == Id) {
                sum += m1.price;
            }
        }
        return sum;
    }
    @Override
    public boolean update(int id, Object s) {
        loadFromFile();
        int index = getIndex(id);
        if (index != -1) {
            m.set(index, (Order) s);
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
    @Override
    public boolean delete(int Id) {
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
