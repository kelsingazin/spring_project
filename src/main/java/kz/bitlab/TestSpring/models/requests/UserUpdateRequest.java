package kz.bitlab.TestSpring.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Assylkhan
 * on 26.03.2020
 * @project TestSpring
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {

    @NotNull
    @NotEmpty
    private String password;

}
