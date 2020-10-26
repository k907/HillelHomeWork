package Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String name;
    private String chief;

    @OneToMany(mappedBy = "department",  cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Teacher> teachers;

    public Department(String name, String chief) {
        this.name = name;
        this.chief = chief;
    }

    public void addTeacher(Teacher teacher) {
        teacher.setDepartment(this);
        teachers.add(teacher);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", chief='" + chief + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
