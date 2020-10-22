package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_group")
    private String name_group;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "group",
            cascade = CascadeType.PERSIST)
    private List<Student> students;

}
