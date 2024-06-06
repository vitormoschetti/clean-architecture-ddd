package br.com.cleanarch.cleanarchitectureddd.domain.product.entity;//package br.com.ddd.domain.product.entity;
//
//import br.com.ddd.BaseTeste;
//import br.com.ddd.domain.product.entity.Product;
//import br.com.ddd.domain.shared.entity.exception.DomainException;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//
//import java.math.BigDecimal;
//import java.util.UUID;
//
//public class ProductTest extends BaseTeste {
//
//    @Test
//    @DisplayName("should throw domain exception when id is empty")
//    public void shouldThrowDomainExceptionWhenIdEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new Product("", UUID.randomUUID().toString(), BigDecimal.ONE));
//
//        Assertions.assertEquals("Id is required", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should throw domain exception when name is empty")
//    public void shouldThrowDomainExceptionWhenCustomerIdEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new Product(UUID.randomUUID().toString(), "", BigDecimal.ONE));
//
//        Assertions.assertEquals("Name is required", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should throw domain exception when price is empty")
//    public void shouldThrowDomainExceptionWhenCustomerOrderItemsEmpty() {
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> new Product(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BigDecimal.ZERO));
//
//        Assertions.assertEquals("Price is required", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should throw domain exception when change name is null")
//    public void shouldThrowDomainExceptionWhenChangeNameNull() {
//
//        final var product = this.buildValidProduct();
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> product.changeName(null));
//
//        Assertions.assertEquals("Name is required", exception.getMessage());
//
//    }
//
//    @Test
//    @DisplayName("should throw domain exception when change price is null")
//    public void shouldThrowDomainExceptionWhenChangePriceNull() {
//
//        final var product = this.buildValidProduct();
//
//        final var exception = Assertions.assertThrows(DomainException.class, () -> product.changePrice(new BigDecimal(-10)));
//
//        Assertions.assertEquals("Price is required", exception.getMessage());
//
//    }
//
//}
