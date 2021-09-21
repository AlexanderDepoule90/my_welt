package RestController;

import DAO.MenuRepository;
import DAO.WarenkorbRepository;
import Entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/myservice")
public class Controller {
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    WarenkorbRepository warenkorbRepository;
    @GetMapping(path = "/helloworld" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Menu> helloWorld() {
        return menuRepository.findAll();
    }
}
