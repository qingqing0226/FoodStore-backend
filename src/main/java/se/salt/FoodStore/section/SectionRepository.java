package se.salt.FoodStore.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SectionRepository {
    @Autowired
    private JpaSectionRepository jpaSectionRepository;

    public List<Section> listAll() {
        return Streamable.of(jpaSectionRepository.findAll()).toList();
    }

    public Section save(Section section) {
        return jpaSectionRepository.save(section);
    }

    public Section findByName(String name) {
        return jpaSectionRepository.findByName(name);
    }
}
