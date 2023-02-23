package io.catalyte.springboot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Orders {
//    @OneToMany(cascade=CascadeType.ALL)//from Java Mockito Template
//    @JsonIgnore
//    private final Set<Products>Products = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @NotNull //Do I need to add not null?
    @JsonFormat(pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @OneToMany(cascade = CascadeType.ALL)
//    //@JoinColumn(name = "order_id",referencedColumnName ="order_id")
    private List<Items> items;     //one Order to Many Items
        //productID
        //quantity
    private BigDecimal orderTotal;

//    @ManyToOne(cascade = CascadeType.REMOVE) //Many orders by One Customer
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long customerId;

    public Orders() {
    }

    public Orders(Date from, BigDecimal bigDecimal){
        this.date = date;
        this.orderTotal = orderTotal;
    }




    public Orders(Long customerId, Date date, BigDecimal orderTotal) {
        this.customerId = customerId;
        this.date = date;
        this.orderTotal = orderTotal;
    }

    public Orders(Date date, List<Items> items, BigDecimal orderTotal) {
        this.date = date;
        this.items = items;
        this.orderTotal = orderTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }


    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders orders)) return false;
        return Objects.equals(id, orders.id) && Objects.equals(date, orders.date) && Objects.equals(items, orders.items) && Objects.equals(orderTotal, orders.orderTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, items, orderTotal);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date=" + date +
                ", items=" + items +
                ", orderTotal=" + orderTotal +
                '}';
    }
}//end class
