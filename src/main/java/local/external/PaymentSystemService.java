
package local.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by uengine on 2018. 11. 21..
 */

@FeignClient(name="payment", url="http://localhost:8083")
public interface PaymentSystemService {

    @RequestMapping(method= RequestMethod.GET, path="/paymentSystems")
    public void payment(@RequestBody PaymentSystem paymentSystem);

}