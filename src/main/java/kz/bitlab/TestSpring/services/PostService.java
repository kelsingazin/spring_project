package kz.bitlab.TestSpring.services;

import kz.bitlab.TestSpring.models.entities.Post;
import kz.bitlab.TestSpring.models.exceptions.SystemServiceException;

import java.util.List;

/**
 * @author Assylkhan
 * on 28.03.2020
 * @project TestSpring
 */
public interface PostService {

    Post addPost(String title, String description, String username) throws SystemServiceException;

    List<Post> findAll();

    public void deletePost(Long id) throws SystemServiceException;

    Post findById(Long id) throws SystemServiceException;

    Post update(Post post) throws SystemServiceException;

    Post update(Long id, String title, String description) throws SystemServiceException;

}
