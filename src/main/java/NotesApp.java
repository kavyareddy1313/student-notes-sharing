import static spark.Spark.*;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

class Note {
    int id;
    String userName;
    String title;
    String content;
    String category;
    boolean pinned;
    String timestamp;
}

public class NotesApp {

    static Map<Integer, Note> notes = new HashMap<>();
    static int counter = 1;
    static Gson gson = new Gson();

    public static void main(String[] args) {

        port(4567);
        staticFiles.location("/public");

        // 🔥 FORCE UTF-8 FOR ALL RESPONSES
        before((req, res) -> {
            res.type("application/json; charset=UTF-8");
            res.header("Content-Encoding", "UTF-8");
        });

        // Get notes
        get("/notes", (req, res) -> {
            String q = req.queryParams("q");

            return gson.toJson(
                notes.values().stream()
                    .filter(n -> q == null ||
                        n.title.toLowerCase().contains(q.toLowerCase()) ||
                        n.content.toLowerCase().contains(q.toLowerCase()) ||
                        n.userName.toLowerCase().contains(q.toLowerCase()))
                    .sorted((a,b) -> Boolean.compare(b.pinned, a.pinned))
                    .collect(Collectors.toList())
            );
        });

        // Add note
        post("/notes", (req, res) -> {
            Note note = gson.fromJson(req.body(), Note.class);
            note.id = counter++;
            note.timestamp = LocalDateTime.now().toString();
            notes.put(note.id, note);
            return gson.toJson(note);
        });

        // Delete note
        delete("/notes/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            notes.remove(id);
            return "{\"status\":\"deleted\"}";
        });

        // Edit note
        put("/notes/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Note existing = notes.get(id);
            Note updated = gson.fromJson(req.body(), Note.class);

            if (existing != null) {
                existing.content = updated.content;
            }
            return "{\"status\":\"updated\"}";
        });

        // Pin / Unpin
        put("/notes/:id/pin", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Note n = notes.get(id);
            if (n != null) n.pinned = !n.pinned;
            return "{\"status\":\"pin toggled\"}";
        });
    }
}
