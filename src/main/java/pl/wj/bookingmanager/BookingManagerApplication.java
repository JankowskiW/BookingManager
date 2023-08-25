package pl.wj.bookingmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"pl.wj.bookingmanager"})
//@EnableJpaRepositories({"pl.wj.bookingmanager.domain"})
public class BookingManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingManagerApplication.class, args);
    }

}
