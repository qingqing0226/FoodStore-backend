package se.salt.FoodStore.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping("/api/sections")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @GetMapping
    ResponseEntity listSections() {
        return ResponseEntity.ok(sectionService.listAll());
    }

    @PostMapping
    ResponseEntity createSection(@RequestBody Section section) {
        Section created = sectionService.createSection(section);
        return ResponseEntity.created(URI.create("/api/sections/")).body(created);
    }


}
