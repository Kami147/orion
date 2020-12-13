package git.littledraily.orion.api.module;

public enum Category {
    CLIENT("Client"),
    MISC("Miscellaneous"),
    MOVEMENT("Movement"),
    COMBAT("Combat"),
    RENDER("Render"),
    PHI("Phi");

    private String categoryName;

    private Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }
}