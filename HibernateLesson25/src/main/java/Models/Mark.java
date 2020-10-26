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
@Table(name = "marks")

public class Mark {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "point")
    private int mark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private Lesson lesson;

    public Mark(int mark, Student student, Lesson lesson) {
        this.mark = mark;
        this.student = student;
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "mark=" + mark +
                ", student=" + student.getFullName() +
                ", lesson=" + lesson.getName() +
                '}';
    }
}
