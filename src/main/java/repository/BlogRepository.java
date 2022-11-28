package repository;

import model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

// gets access to methods like findAll, findById, save, delete
public interface BlogRepository
        extends JpaRepository<Posts,Long> { }
