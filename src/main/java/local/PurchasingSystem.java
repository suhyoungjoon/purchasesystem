package local;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="PurchasingSystem_table")
public class PurchasingSystem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer movieId;
    private String movieName;
    private Integer startNo;
    private Integer customerId;

    @PostPersist
    public void onPostPersist(){
        Purchased purchased = new Purchased();
        BeanUtils.copyProperties(this, purchased);
        purchased.publish();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        local.external.PaymentSystem paymentSystem = new local.external.PaymentSystem();
        // mappings goes here
        Application.applicationContext.getBean(local.external.PaymentSystemService.class)
            .payment(paymentSystem);


        Canceled canceled = new Canceled();
        BeanUtils.copyProperties(this, canceled);
        canceled.publish();


        Rated rated = new Rated();
        BeanUtils.copyProperties(this, rated);
        rated.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public Integer getStartNo() {
        return startNo;
    }

    public void setStartNo(Integer startNo) {
        this.startNo = startNo;
    }
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }




}
