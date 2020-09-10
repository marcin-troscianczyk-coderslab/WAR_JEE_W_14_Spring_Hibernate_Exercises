package pl.coderslab.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Category;

public interface SpringDataCategoryRepository extends JpaRepository<Category, Long> {
}
