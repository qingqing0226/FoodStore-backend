package se.salt.FoodStore.section;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface JpaSectionRepository extends CrudRepository<Section, Long> {
    @Query(value = "SELECT s from Section s where s.name = :name")
    Section findByName(@Param("name") String name);
}
