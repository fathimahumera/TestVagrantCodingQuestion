import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
This class is used to store the details of User and the list of recent songs for the user
 */
public class RecentPlaylist {

    private Map<String, User> userMap;
    private int capacity;

    RecentPlaylist(int capacity) {
        this.userMap = new HashMap<>();
        this.capacity = capacity;
    }

    void addSong(String userId, String song) {
        User user = userMap.getOrDefault(userId, new User(userId));
        user.addSong(song);
        userMap.put(userId, user);
        if (user.getSongs().size() > capacity) {
            user.getSongs().remove(0);
        }
    }

    List<String> getRecentSongs(String userId) {
        if (!userMap.containsKey(userId)) {
            return new ArrayList<>();
        }
        return userMap.get(userId).getSongs();
    }
}