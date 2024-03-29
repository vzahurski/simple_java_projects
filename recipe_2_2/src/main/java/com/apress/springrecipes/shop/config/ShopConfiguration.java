package com.apress.springrecipes.shop.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.apress.springrecipes.shop.Battery;
import com.apress.springrecipes.shop.Disc;
import com.apress.springrecipes.shop.Product;

@Configuration
public class ShopConfiguration {
    @Bean
    public Product aaa() { // здесь создаем экземпляры Battery, возвращаем объект родительского класса Product
        Battery p1 = new Battery("AAA", 2.5);
        p1.setRechargeable(true);
        return p1;
    }
    @Bean
    public Product cdrw() { // здесь создаем экземпляры Disc, возвращаем объект родительского класса Product
        Disc p2 = new Disc("CD-RW", 1.5);
        p2.setCapacity(700);
        return p2;
    }
}
