package lk.ijse.dep10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student implements SuperEntity {
    private int id;
    private String name;
    private String address;


}
