package blogApplication.repositories;

import blogApplication.entities.Category;
import blogApplication.entities.Post;
import blogApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    @Query("select p from Post p where p.title like :key")
    List<Post> searchByTitle(@Param("key") String title);


    //this is also good method but hibernate has some error in that version later it will be updated
    //this method is also correct
    //List<Post> findByTitleContaining(String title);


}

