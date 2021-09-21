package DAO;

import Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface MenuRepository extends JpaRepository<Menu,Long> {
}

