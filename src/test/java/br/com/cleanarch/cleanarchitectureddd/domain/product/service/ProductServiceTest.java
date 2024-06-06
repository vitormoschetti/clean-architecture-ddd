package br.com.cleanarch.cleanarchitectureddd.domain.product.service;//package br.com.ddd.domain.product.service;
//
//import br.com.ddd.BaseTeste;
//import br.com.ddd.domain.product.service.ProductService;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//public class ProductServiceTest extends BaseTeste {
//
//    @Test
//    @DisplayName("should change the prices of all products")
//    public void shouldChangePricesAllProducts() {
//
//        final var product1 = this.buildProductWith("product 1", new BigDecimal(10));
//        final var product2 = this.buildProductWith("product 2", new BigDecimal(20));
//
//        ProductService.increasePrice(List.of(product1, product2), 50L);
//
//        Assertions.assertEquals(new BigDecimal("15.0"), product1.getPrice());
//        Assertions.assertEquals(new BigDecimal("30.0"), product2.getPrice());
//
//
//    }
//
//}
