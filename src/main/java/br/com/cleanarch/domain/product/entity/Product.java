package br.com.cleanarch.domain.product.entity;//package br.com.ddd.domain.product.entity;
//
//import br.com.ddd.domain.shared.entity.BaseEntity;
//import br.com.ddd.domain.shared.entity.IAggregateRoot;
//import br.com.ddd.domain.shared.entity.exception.DomainException;
//import br.com.ddd.domain.shared.notification.DomainNotification;
//
//import java.math.BigDecimal;
//import java.util.Objects;
//
//public class Product extends BaseEntity implements IAggregateRoot {
//
//    private final String id;
//    private String name;
//    private BigDecimal price;
//
//    public Product(final String id, final String name, final BigDecimal price) {
//        super(new DomainNotification());
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.validate("create");
//    }
//
//    protected void validate(String context) {
//        if (Objects.isNull(this.id) || this.id.isBlank())
//            throw new DomainException("Id is required");
//        if (Objects.isNull(this.name) || this.name.isBlank())
//            throw new DomainException("Name is required");
//        if (Objects.isNull(this.price) || this.price.compareTo(BigDecimal.ZERO) <= 0)
//            throw new DomainException("Price is required");
//    }
//
//    public void changeName(final String name) {
//        this.name = name;
//        this.validate("");
//    }
//
//    public void changePrice(final BigDecimal price) {
//        this.price = price;
//        this.validate("");
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                '}';
//    }
//}
