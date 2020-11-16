package Labeling;

/**
 *
 * @author martellocauda
 */
public class Label { //ABSTRACT??

    private AccessLevel accessLevel;
    private Category category;

    public Label() {
        this.accessLevel = new AccessLevel();
        this.category = new Category();
    }

    public Label(AccessLevel accessLevel, Category category) {
        this.accessLevel = accessLevel;
        this.category = category;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
}
