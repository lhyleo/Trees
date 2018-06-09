import ExtraCredit.VideoLibrary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class VideoLibraryTest {

    private VideoLibrary vl;

    @Before
    public void setUp() {
        this.vl = new VideoLibrary();
        List<String> actors = new ArrayList<>();
        actors.add("Actor one");
        actors.add("Actor two");
        List<String> directors = new ArrayList<>();
        directors.add("Director one");
        directors.add("Director two");
        vl.add("movie1", "Movie one", 2017, "Director one", "Actor one");
        vl.add("movie2", "Movie two", 2018, "Director two", actors);
        vl.add("movie3", "Movie three", 2016, directors, actors);
    }
    @Test
    public void directorTestAndAdd() {

        try {
            vl.add("movie1", "Movie one", 2017, "Director one", "Actor one");
            Assert.fail("Alias existed");
        } catch (IllegalArgumentException ex) {
            //do nth, its ok
        }
        List<String> actual = vl.getDirectorsMovie("Director one");
        String[] director1 = actual.toArray(new String[actual.size()]);
        Assert.assertEquals("",director1, new String[] {"Movie one", "Movie three"});
        actual = vl.getDirectorsMovie("Director two");
        String[] director2 = actual.toArray(new String[actual.size()]);
        Assert.assertEquals("",director2, new String[] {"Movie two", "Movie three"});
    }

    @Test
    public void testUsedMovie() {
        try {
            vl.usingMovie("movie4");
            Assert.fail("Alias DNE");
        } catch (IllegalArgumentException ex) {
            //do nth, its ok
        }
        vl.usingMovie("movie1");
        vl.usingMovie("movie1");
        vl.usingMovie("movie1");
        vl.usingMovie("movie1");
        vl.usingMovie("movie2");
        Assert.assertEquals(vl.getMostUsedMovie(),"movie1");
        vl.usingMovie("movie2");
        vl.usingMovie("movie2");
        vl.usingMovie("movie2");
        vl.usingMovie("movie2");
        Assert.assertEquals(vl.getMostUsedMovie(),"movie2");
    }

}
