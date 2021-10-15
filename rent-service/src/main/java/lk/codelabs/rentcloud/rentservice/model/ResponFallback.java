package lk.codelabs.rentcloud.rentservice.model;

public class ResponFallback implements Response {
    String text;

    public ResponFallback() {
    }

    public ResponFallback(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
