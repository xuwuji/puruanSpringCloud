import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 自定义的负载均衡算法
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        // Ribbon默认是轮询
        return new RoundRobinRule();
    }
}
