package kz.bitlab.TestSpring.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Assylkhan
 * on 28.03.2020
 * @project TestSpring
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPostRequest {

    private String title;
    private String description;
    private Long userId;
    private MultipartFile file;

}
