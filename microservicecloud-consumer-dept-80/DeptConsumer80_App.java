import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;


/**
 *      这个微服务不注册到注册中心eureka中
 *      作为消费端，能够从注册中心中发现服务，从而调用这些服务就够了
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.puruan.*"})
@RibbonClient(name = "ribbon-consumer", configuration = MySelfRule.class)
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
