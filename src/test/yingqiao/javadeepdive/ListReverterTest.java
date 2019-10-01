package yingqiao.javadeepdive;

import mockit.Mocked;
import org.junit.Test;

import java.util.ArrayList;

public class ListReverterTest {
    @Mocked
    ListReverter listReverter;

    @Test
    public void revertTest(){
//        listReverter = new ListReverter();
        listReverter.revert(new ArrayList<>());
    }
}
