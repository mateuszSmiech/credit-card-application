package pl.dominisz.creditcardapplication;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardEntityRepository extends JpaRepository<CreditCardEntity, Long> {

    Optional<CreditCardEntity> findByNumber(String number);

}
