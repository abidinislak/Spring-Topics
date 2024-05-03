package relience.controlerr;


import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import relience.MessageRepo;

@RestController
public class Homecontroller {



    private final MessageRepo messageRepo;

    public Homecontroller(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/getall")
    @RateLimiter(name = "abidin")
    public ResponseEntity<String> getAll(){

        var result=messageRepo.findAll();


        return ResponseEntity.ok("""
                This is regular response ... Anakra  \n""");
    }
}
