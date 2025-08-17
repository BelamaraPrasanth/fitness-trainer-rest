package PersonalTrainer.demo.Controller;
import PersonalTrainer.demo.Entity.ConsultationEntity;
import PersonalTrainer.demo.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    @CrossOrigin(origins = "http://localhost:5173") // or "*" if you're testing
    @RestController
    @RequestMapping("/api/consultations")
    public class ConsultationController {

        @Autowired
        private ConsultationService consultationService;

        @PostMapping
        public ConsultationEntity createConsultation(@RequestBody ConsultationEntity consultation) {
            return consultationService.saveConsultation(consultation);
        }
    }


