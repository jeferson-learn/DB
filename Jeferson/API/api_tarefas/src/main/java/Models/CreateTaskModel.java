package Models;

public class CreateTaskModel {

    private String title;
    private String description;
    private boolean done;

    public CreateTaskModel() {
        title = "API 5";
        description = "Tarefas do api 5";
        done = true;
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
