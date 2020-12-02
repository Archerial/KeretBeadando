package uni.eszterhazy.beadando.model;

public class LanguageKnowledge {
    private String language;
    private String level;
    private int id;

    public LanguageKnowledge() {
    }

    public LanguageKnowledge(String language, String level) {
        this.language = language;
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LanguageKnowledge{" +
                "language='" + language + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
