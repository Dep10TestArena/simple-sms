package lk.ijse.dep10.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO implements Serializable {
    private int id;
    private String name;
    private String address;
}
