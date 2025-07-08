import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSong {
    @Test
    void run(){
        Song testSong = new Song("hello", "Adele", 123);
        List<Song> mysongs = new ArrayList<>();
        mysongs.add(testSong);
        mysongs.add(new Song("apple", "Charlie XCX", 149));
        Collections.sort(mysongs);
        assertEquals(mysongs.getLast(),testSong);
    }
}
