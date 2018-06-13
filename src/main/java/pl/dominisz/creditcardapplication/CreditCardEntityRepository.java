package pl.dominisz.creditcardapplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardEntityRepository extends JpaRepository<CreditCardEntity, Long> {

    Optional<CreditCardEntity> findByNumber(String number);

}
