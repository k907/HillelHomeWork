package Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student_groups")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name_group")
    private String nameGroup;

    @OneToMany(mappedBy = "studentGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Student> students;

    public Group(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name_group='" + nameGroup + '\'' +
                ", students=" + students +
                '}';
    }
}
