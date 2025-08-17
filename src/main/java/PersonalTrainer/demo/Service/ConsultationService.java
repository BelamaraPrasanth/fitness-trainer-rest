package PersonalTrainer.demo.Service;
import PersonalTrainer.demo.Entity.ConsultationEntity;
import PersonalTrainer.demo.Repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
    public class ConsultationService {

        @Autowired
        private ConsultationRepository consultationRepository;

        public ConsultationEntity saveConsultation(ConsultationEntity consultation) {
            return consultationRepository.save(consultation);
        }
    }

