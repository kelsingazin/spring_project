package kz.bitlab.TestSpring.models.exceptions;

import kz.bitlab.TestSpring.models.errors.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Assylkhan
 * on 26.03.2020
 * @project TestSpring
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SystemServiceException extends RuntimeException {
    private String message;
    private ErrorCode errorCode;
}
