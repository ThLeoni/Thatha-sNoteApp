// BY THAÍS LEONI

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private List<Note> notes;
    private Scanner scanner;

    public Main() {
        notes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void CreateNote() {
        System.out.print("Type the title of the note: ");
        String title = scanner.nextLine();

        System.out.print("Type the content of the note: ");
        String content = scanner.nextLine();

        Note newNote = new Note(title, content);
        notes.add(newNote);
        System.out.println("Success!");
    }
    public void Listnotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            System.out.println("notes available:");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i).getTitle());
            }
        }
    }
    public void showNotes(int index) {
        if (index >= 0 && index < notes.size()) {
            Note note = notes.get(index);
            System.out.println("Title: " + note.getTitle());
            System.out.println("Content: " + note.getContent());
        } else {
            System.out.println("Note not found.");
        }
    }
    static class Note {
        private String title;
        private String content;

        public Note(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        Scanner scanner = new Scanner(System.in);

        boolean loading = true;
        while (loading) {
            System.out.println("❤❤❤ Thatha's notes App ❤❤❤");
            System.out.println("1. Create new note");
            System.out.println("2. list notes");
            System.out.println("3. display notes");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> app.CreateNote();
                case 2 -> app.Listnotes();
                case 3 -> {
                    System.out.print("Type the note number: ");
                    int number = scanner.nextInt();
                    app.showNotes(number - 1);
                }
                case 0 -> {
                    loading = false;
                    System.out.println("Bye.");
                }

            }
            System.out.println();

            if (option > 3){
                System.out.println("Invalid option. Try again..");
            }
        }

        scanner.close();
    }
}

