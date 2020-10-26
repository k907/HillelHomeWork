package Models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "year_admission")
    private int yearAdmission;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", nullable = false)
    private Group studentGroup;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Mark> marks;

    public Student(String fullName, int yearAdmission, Group studentGroup) {
        this.fullName = fullName;
        this.yearAdmission = yearAdmission;
        this.studentGroup = studentGroup;
    }

    public void addMark(Mark mark) {
        mark.setStudent(this);
        marks.add(mark);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", full_name='" + fullName + '\'' +
                ", year_admission=" + yearAdmission +
                ", full_name='" + fullName + '\'' +
                ", name_group='" + studentGroup.getNameGroup() + '\'' +
                ", marks='" + marks + '\'' +
                '}';
    }
}

