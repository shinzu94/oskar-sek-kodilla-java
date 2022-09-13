package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Product product = new Product("Bread");
        Item item = new Item(product, BigDecimal.valueOf(5.20), 5, BigDecimal.valueOf(26));

        Invoice invoice = new Invoice();
        invoice.setNumber("1/2022");
        invoice.setItems(List.of(item));

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int itemId = item.getId();
        int productId = product.getId();

        //Then
        assertNotEquals(0, invoiceId);
        assertNotEquals(0, itemId);
        assertNotEquals(0, productId);

        //CleanUp
        try {
            invoiceDao.deleteById(invoiceId);
            productDao.deleteById(productId);
        } catch (Exception e) {
            //do nothing
        }
    }
}