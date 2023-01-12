package se.salt.FoodStore.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> listAll() {
        return sectionRepository.listAll();
    }

    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    public Section findByName(String name) {
        return sectionRepository.findByName(name);
    }
}
