package mu.mcb.reward;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Brume
 */
@SpringBootApplication
@EnableFeignClients
@EntityScan(basePackages = {"mu.mcb.reward.entity"})
public class RewardApplication {
    public static void main(String[] args)
	{
        SpringApplication.run(RewardApplication.class, args);
    }

}
