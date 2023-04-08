
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecentPlaylistTest {

    private RecentPlaylist store;

    @BeforeEach
    void setUp() {
        store = new RecentPlaylist(3);
    }

    @Test
    void testAddSong() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        store.addSong("user1", "S4");

        List<String> actual = store.getRecentSongs("user1");
        List<String> expected = Arrays.asList("S2", "S3", "S4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetRecentSongs() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");

        List<String> actual = store.getRecentSongs("user1");
        List<String> expected = Arrays.asList("S1", "S2", "S3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetRecentSongsForNonexistentUser() {
        List<String> actual = store.getRecentSongs("user1");

        Assertions.assertTrue(actual.isEmpty());
    }

    @Test
    void testAddSongExceedingCapacity() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        store.addSong("user1", "S4");
        store.addSong("user1", "S5");

        List<String> actual = store.getRecentSongs("user1");
        List<String> expected = Arrays.asList("S3", "S4", "S5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testAddSongForMultipleUsers() {
        store.addSong("user1", "S1");
        store.addSong("user2", "S2");
        store.addSong("user1", "S3");
        store.addSong("user2", "S4");

        List<String> actual1 = store.getRecentSongs("user1");
        List<String> expected1 = Arrays.asList("S1", "S3");

        List<String> actual2 = store.getRecentSongs("user2");
        List<String> expected2 = Arrays.asList("S2", "S4");

        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }
}
