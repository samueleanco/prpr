package refactorings;

public class Messenger {
    private String message;

    public Messenger(String message) {
        this.message = message;
    }

    public void printMessage() {
        String message = getMessage();
        print(message);
    }

    private void print(String message){
        System.out.println(message);
    }

    public String getMessage() {
        if (message.isEmpty()){
            return "no message";
        }
        return message;
    }
}
