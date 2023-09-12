/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author GG
 */
public class Orders {
    private int order_id;
    private int customer_id;
    private int order_status;
    private String order_date;
    private String requied_date;
    private String shipped_date;
    private int store_id;
    private int staff_id;
    private int status;

    public Orders() {
    }

    public Orders(int order_id, int customer_id, int order_status, String order_date, String requied_date, String shipped_date, int store_id, int staff_id, int status) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_status = order_status;
        this.order_date = order_date;
        this.requied_date = requied_date;
        this.shipped_date = shipped_date;
        this.store_id = store_id;
        this.staff_id = staff_id;
        this.status = status;
    }

    public Orders(int customer_id, int order_status, String order_date, String requied_date, String shipped_date, int store_id, int staff_id, int status) {
        this.customer_id = customer_id;
        this.order_status = order_status;
        this.order_date = order_date;
        this.requied_date = requied_date;
        this.shipped_date = shipped_date;
        this.store_id = store_id;
        this.staff_id = staff_id;
        this.status = status;
    }
    

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getRequied_date() {
        return requied_date;
    }

    public void setRequied_date(String requied_date) {
        this.requied_date = requied_date;
    }

    public String getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(String shipped_date) {
        this.shipped_date = shipped_date;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orders{" + "order_id=" + order_id + ", customer_id=" + customer_id + ", order_status=" + order_status + ", order_date=" + order_date + ", requied_date=" + requied_date + ", shipped_date=" + shipped_date + ", store_id=" + store_id + ", staff_id=" + staff_id + ", status=" + status + '}'+"\n";
    }
    
    
}
