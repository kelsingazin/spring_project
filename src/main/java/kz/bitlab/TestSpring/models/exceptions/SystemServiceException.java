package kz.bitlab.TestSpring.models.exceptions;

import kz.bitlab.TestSpring.models.errors.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SystemServiceException extends RuntimeException {
    private String message;
    private ErrorCode errorCode;
}
