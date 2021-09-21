package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMenu;
    private String name;

    @ManyToMany (mappedBy = "menuList")
    private List<Warenkorb> warenkorbList ;

    public void addWarenkorb (Warenkorb warenkorb) {
        if (warenkorbList.isEmpty() || warenkorbList == null) warenkorbList = new ArrayList<>();
        warenkorbList.add(warenkorb);
    }
}
