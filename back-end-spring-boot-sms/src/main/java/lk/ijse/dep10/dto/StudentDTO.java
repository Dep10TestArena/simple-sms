package lk.ijse.dep10.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO implements Serializable {
    private int id;
    @NotBlank(message = "Name can't be empty")
    private String name;
    @NotBlank(message = "Address can't be empty")
    private String address;
}
