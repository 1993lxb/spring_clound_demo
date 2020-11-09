package cn.itcast.order.controller;

import cn.itcast.order.entity.Product;
import cn.itcast.order.feign.ProductFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;

//    @RequestMapping(value = "/buy1/{id}",method = RequestMethod.GET)
//    public Product findById1(@PathVariable Long id){
//
//     List<ServiceInstance> instances=  discoveryClient.getInstances("service-product");
//
//        ServiceInstance instance=instances.get(0);
//        Product product=restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/1",Product.class);
//
//        return product;
//    }

    /**
     *
     * 基于ribbon的形式调用远程微服务
     * 1，使用@LoadBalanced声明RestTemplete
     * 2,使用服务名称替换ip地址
     *
     */

//    @RequestMapping(value = "/buy1/{id}",method = RequestMethod.GET)
//    public Product findById1(@PathVariable Long id){
//
//        Product product=restTemplate.getForObject("http://service-product/product/1",Product.class);
//
//        return product;
//    }
//
//    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
//    public Product findById(@PathVariable Long id){
//
//        Product product=restTemplate.getForObject("http://127.0.0.1:9001/product/1",Product.class);
//
//        return product;
//    }

//    @Autowired
//    private ProductFeignClient productFeignClient;
//
//        @RequestMapping(value = "/buy1/{id}",method = RequestMethod.GET)
//    public Product findById1(@PathVariable Long id){
//
//        Product product=productFeignClient.findById(id);
//
//        return product;
//    }


    @Autowired
    private ProductFeignClient productFeignClient;

    @RequestMapping(value = "/buy1/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "orderFallBack")
    public Product findById1(@PathVariable Long id){

        Product product=productFeignClient.findById(id);

        return product;
    }




    //降级方法
    public Product orderFallBack(Long id) {
        Product product = new Product();
        product.setId(-1l);
        product.setProductName("熔断:触发降级方法");
        return product;
    }


            @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String findById2(@PathVariable Long id){



        return "订单微服务";
    }
}
