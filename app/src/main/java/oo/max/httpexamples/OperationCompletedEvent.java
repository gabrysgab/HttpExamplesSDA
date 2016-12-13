package oo.max.httpexamples;

public class OperationCompletedEvent {

    private final String result;

    public OperationCompletedEvent(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

}