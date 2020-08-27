package Models;

public class EditTaskModel {

    private String title;
    private String description;
    private boolean done;

    public EditTaskModel() {
        title = "API 1";
        description = "Tarefas do api 1 atualizado";
        done = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
