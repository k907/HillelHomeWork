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
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departments_id")
    private Department department;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Lesson> lessons;

    public Teacher(String fullName, Department department, List<Lesson> lessons) {
        this.fullName = fullName;
        this.department = department;
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson) {
        lesson.setTeacher(this);
        lessons.add(lesson);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "fullName='" + fullName + '\'' +
                ", department=" + department.getName() +
                '}';
    }
}
