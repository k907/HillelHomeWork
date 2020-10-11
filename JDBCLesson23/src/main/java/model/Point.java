package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point extends BaseModel {
    private int student_id;
    private int class_id;
    private int point;
}
