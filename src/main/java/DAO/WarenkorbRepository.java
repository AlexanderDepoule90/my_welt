package DAO;

import Entity.Warenkorb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface WarenkorbRepository extends JpaRepository<Warenkorb,Long> {
}
