package Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Warenkorb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "warenkorb_menu",
            joinColumns = @JoinColumn(name = "warenkorb_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private List<Menu> menuList;

    public void addMenu(Menu menu) {
        if (menuList.isEmpty() || menuList == null ) menuList = new ArrayList<>();
        menuList.add(menu);
        menu.addWarenkorb(this);
    }
}
