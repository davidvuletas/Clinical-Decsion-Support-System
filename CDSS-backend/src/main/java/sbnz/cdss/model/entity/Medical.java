package sbnz.cdss.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Medical")
public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "category")
    private CategoryOfMedical category;

    @Column(name = "name")
    private String name;

    @ElementCollection
    private List<String> ingredients;

    public Medical() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryOfMedical getCategory() {
        return category;
    }

    public void setCategory(CategoryOfMedical category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
