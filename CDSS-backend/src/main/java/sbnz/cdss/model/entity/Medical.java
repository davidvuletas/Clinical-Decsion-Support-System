package sbnz.cdss.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medical medical = (Medical) o;
        return Objects.equals(id, medical.id) &&
                category == medical.category &&
                Objects.equals(name, medical.name) &&
                Objects.equals(ingredients, medical.ingredients);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, category, name, ingredients);
    }
}
