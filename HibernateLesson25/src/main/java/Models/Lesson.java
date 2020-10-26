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
@Table(name = "classes")
public class Lesson {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    private String name;
    private int semester;
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "lesson",  cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Mark> marks;

    public Lesson(String name, int semester, int year, Teacher teacher, List<Mark> marks) {
        this.name = name;
        this.semester = semester;
        this.year = year;
        this.teacher = teacher;
        this.marks = marks;
    }

    public void addMark ( Mark mark ) {
        mark.setLesson(this);
        marks.add(mark);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", semester=" + semester +
                ", year=" + year +
                ", teacher=" + teacher.getFullName() +
                '}';
    }
}
