package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class extends BaseModel  {
    private String name;
    private int teacher_id;
    private int semester;
    private int year;
}

