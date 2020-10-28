package cn.itcast.product.controller;


import cn.itcast.product.entity.Product;
import cn.itcast.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    @Value("${spring.cloud.client.ip-address}")
    private String address;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        Product product=productService.findById(id);
        product.setProductName("访问的地址+端口是:"+address+":"+port);
        return product;
    }
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String  save(@RequestBody Product product){
        productService.save(product);

        return "保存成功!继续操作，hello您好！";
    }

}
