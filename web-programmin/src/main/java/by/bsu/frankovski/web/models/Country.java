package by.bsu.frankovski.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "T_COUNTRY")
public class Country {
//    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private @Column(name = "NAME") String name;
    private @Id @Column(name = "A2_CODE") String a2Code;
    @JoinTable(
            name = "T_COUNTRY_CITY",
            joinColumns = {@JoinColumn(name = "A2_CODE")},
            inverseJoinColumns = {@JoinColumn(name = "COUNTRY")}
            )
    @OneToMany(cascade = CascadeType.ALL)
    private List<City> cities;
}
