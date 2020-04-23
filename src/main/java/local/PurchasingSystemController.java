package local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 @RequestMapping(value = "api/purchasing")
 public class PurchasingSystemController {

     @Autowired
     PurchasingSystemRepository purchasingSystemRepository;

     @RequestMapping(value = "/purchase",
             method = RequestMethod.POST,
             produces = "application/json;charset=UTF-8")

     public void purchase(@RequestBody Purchased purchased) {
         System.out.println("##### /purchasingSystem/purchase  called #####");

         PurchasingSystem purchasingSystem = new PurchasingSystem();
         purchasingSystem.setCustomerId(purchased.getCustomerId());
         purchasingSystem.setId(purchased.getId());
         purchasingSystem.setMovieId(purchased.getMovieId());
         purchasingSystem.setMovieName(purchased.getMovieName());
         purchasingSystem.setStartNo(0);
         purchasingSystemRepository.save(purchasingSystem);


     }

     @RequestMapping(value = "/cancel",
             method = RequestMethod.POST,
             produces = "application/json;charset=UTF-8")

     public void purchaseCancellation(@RequestBody Canceled canceled) {
         System.out.println("##### /purchasingSystem/canceled  called #####");

         PurchasingSystem purchasingSystem = new PurchasingSystem();
         purchasingSystem.setCustomerId(canceled.getCustomerId());
         purchasingSystem.setId(canceled.getId());
         purchasingSystem.setMovieId(canceled.getMovieId());
         purchasingSystem.setMovieName(canceled.getMovieName());
         purchasingSystem.setStartNo(0);
         purchasingSystemRepository.save(purchasingSystem);


     }

     @RequestMapping(value = "/evaluate",
             method = RequestMethod.POST,
             produces = "application/json;charset=UTF-8")

     public void evaluation(@RequestBody Rated rated) {
         System.out.println("##### /purchasingSystem/evaluate  called #####");

         PurchasingSystem purchasingSystem = new PurchasingSystem();
         purchasingSystem.setCustomerId(rated.getCustomerId());
         purchasingSystem.setId(rated.getId());
         purchasingSystem.setMovieId(rated.getMovieId());
         purchasingSystem.setMovieName(rated.getMovieName());
         purchasingSystem.setStartNo(rated.getStartNo());
         purchasingSystemRepository.save(purchasingSystem);
     }
 }