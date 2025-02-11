import java.util.*;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextState current;
    private int historySize;
    private int stateCount;

    public TextEditor(int historySize) {
        this.current = null;
        this.historySize = historySize;
        this.stateCount = 0;
    }

    public void addTextState(String content) {
        TextState newState = new TextState(content);
        if (current != null) {
            newState.prev = current;
            current.next = newState;
        }
        current = newState;
        stateCount++;
        if (stateCount > historySize) {
            removeOldestState();
        }
    }

    private void removeOldestState() {
        TextState temp = current;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        if (temp.next != null) {
            temp.next.prev = null;
        }
        stateCount--;
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo steps.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo steps.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("Editor is empty.");
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addTextState("Hello");
        editor.addTextState("Hello World");
        editor.addTextState("Hello World!");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
