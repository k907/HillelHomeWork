package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "year_admission")
    private int year_admission;

     @Column(name = "group_id")
     private int group_id;

    @ManyToOne (fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn (name="group_id")
    private Group group;

}

