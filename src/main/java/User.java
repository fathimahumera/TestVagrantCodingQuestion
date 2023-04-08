import java.util.ArrayList;
import java.util.List;

/*
This class is used to store the details of User and the list of recent songs for the user
 */
public class User {

    private String userId;
    private List<String> songs;

    User(String userId) {
        this.userId = userId;
        this.songs = new ArrayList<>();
    }

    String getUserId() {
        return userId;
    }

    List<String> getSongs() {
        return songs;
    }

    void addSong(String song) {
        songs.add(song);
    }
}
