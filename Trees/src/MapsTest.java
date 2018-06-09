import Maps.Maps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapsTest {

    private List<String> words1;
    private List<String> words2;
    private List<String> words3;
    private Integer pageNo_1;
    private Integer pageNo_2;
    private Integer pageNo_3;
    private Map<Integer,List<String>> map;
    private List<String> resultWord;

    @Before
    public void setUp() {
        this.words1 = new ArrayList<>();
        this.words2 = new ArrayList<>();
        this.words3 = new ArrayList<>();
        this.resultWord = new ArrayList<>();
        words1.add("methods");
        words1.add("abstract");

        words2.add("methods");
        words2.add("field");
        words2.add("types");

        words3.add("methods");
        words3.add("field");
        resultWord.add("");
        this.pageNo_1 = 1;
        this.pageNo_2 = 2;
        this.pageNo_3 = 3;
        this.map = new HashMap<>();
        this.map.put(pageNo_1,words1);
        this.map.put(pageNo_2,words2);
        this.map.put(pageNo_3,words3);
    }

    @Test
    public void reverseMap() {
        Map<String, List<Integer>> reversed = Maps.reverseMap(map);
        int[] array = reversed.get("methods").stream().mapToInt(i->i).toArray();
        Assert.assertArrayEquals(array, new int[] {1, 2, 3});
        array = reversed.get("abstract").stream().mapToInt(i->i).toArray();
        Assert.assertArrayEquals(array, new int[] {1});
        array = reversed.get("field").stream().mapToInt(i->i).toArray();
        Assert.assertArrayEquals(array, new int[] {2, 3});
        array = reversed.get("types").stream().mapToInt(i->i).toArray();
        Assert.assertArrayEquals(array, new int[] {2});
    }
}