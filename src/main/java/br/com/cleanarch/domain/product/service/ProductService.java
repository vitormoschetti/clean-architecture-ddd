package br.com.cleanarch.domain.product.service;

import br.com.cleanarch.domain.product.entity.Product;
import br.com.cleanarch.domain.shared.service.IService;

import java.math.BigDecimal;
import java.util.List;

public class ProductService implements IService {

    public static Product createProduct(String name, BigDecimal price) {
        final var product = new Product();
        product.create(name, price);
        return product;
    }

    public static void increasePrice(final List<Product> products, final Long percentage) {

        final var decimalPercentage = new BigDecimal(percentage).divide(new BigDecimal(100));

        products.forEach(product -> product.changePrice((product.getPrice().multiply(decimalPercentage)).add(product.getPrice())));

    }
}
