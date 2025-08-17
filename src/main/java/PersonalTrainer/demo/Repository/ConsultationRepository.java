package PersonalTrainer.demo.Repository;

import PersonalTrainer.demo.Entity.ConsultationEntity;

import org.springframework.data.jpa.repository.JpaRepository;

    public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long>
    {
    }


