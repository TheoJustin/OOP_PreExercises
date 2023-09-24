public class Event {
    private String name;
    private String type;
    private String message;
    private int effects;

    public Event(String name, String type, String message, int effects) {
        this.name = name;
        this.type = type;
        this.message = message;
        this.effects = effects;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public int getEffects() {
        return effects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setEffects(int effects) {
        this.effects = effects;
    }
}
