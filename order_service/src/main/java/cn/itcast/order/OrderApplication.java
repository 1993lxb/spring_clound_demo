package cn.itcast.order;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan("cn.itcast.order.entity")
@EnableCircuitBreaker  //开启熔断器
@EnableFeignClients
@EnableHystrixDashboard
public class OrderApplication {


//    @LoadBalanced
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}

