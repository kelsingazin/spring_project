package kz.bitlab.TestSpring.services;

import kz.bitlab.TestSpring.models.entities.Post;
import kz.bitlab.TestSpring.models.exceptions.SystemServiceException;

/**
 * @author Assylkhan
 * on 28.03.2020
 * @project TestSpring
 */
public interface PostService {

    Post addPost(String title, String description, Long userId) throws SystemServiceException;

}
