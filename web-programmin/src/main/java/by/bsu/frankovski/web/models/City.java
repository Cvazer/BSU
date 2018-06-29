package by.bsu.frankovski.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "T_CITY")
public class City {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private @Column(name = "NAME") String name;
    private @ManyToOne Country country;
}
