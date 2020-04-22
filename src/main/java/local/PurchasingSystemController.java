package local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class PurchasingSystemController {

     @Autowired
     PurchasingSystemRepository purchasingSystemRepository;

@RequestMapping(value = "/purchase",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8")

public void purchase(@RequestBody Purchased purchased)
 {
        System.out.println("##### /purchasingSystem/purchase  called #####");

        PurchasingSystem purchasingSystem = new PurchasingSystem();
        purchasingSystem.setCustomerId(purchased.getCustomerId());
        purchasingSystemRepository.save(purchasingSystem);



        }

@RequestMapping(value = "/cancel",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8")

public void purchaseCancellation(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("##### /purchasingSystem/purchaseCancellation  called #####");
        }

@RequestMapping(value = "/evaluate",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8")

public void evaluation(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("##### /purchasingSystem/evaluation  called #####");
        }
 }
