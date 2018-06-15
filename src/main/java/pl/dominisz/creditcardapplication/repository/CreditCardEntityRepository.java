package pl.dominisz.creditcardapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dominisz.creditcardapplication.model.CreditCardEntity;

import java.util.Optional;

@Repository
public interface CreditCardEntityRepository extends JpaRepository<CreditCardEntity, Long> {

    Optional<CreditCardEntity> findByNumber(String number);





}
