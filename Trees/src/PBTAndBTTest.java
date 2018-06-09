import ParentBinaryTree.BT;
import ParentBinaryTree.PBT;
import org.junit.Assert;
import org.junit.Test;

public class PBTAndBTTest {

    @Test
    public void testAddAndSize() {
        PBT<Integer> pbt = new PBT<>();
        PBT<Integer> bt = new BT<>();
        for (int i = 0; i < 50; i++) {
            pbt.add(i);
            bt.add(i);
        }
        Assert.assertEquals(50,pbt.size());
        Assert.assertEquals(50,bt.size());
    }

    @Test
    public void testContains() {
        PBT<Integer> pbt = new PBT<>();
        PBT<Integer> bt = new BT<>();
        for (int i = 0; i < 50; i++) {
            pbt.add(i);
            bt.add(i);
        }
        for (int i = 0; i < 100; i++) {
            if (i < 50) {
                Assert.assertTrue(pbt.contains(i));
                Assert.assertTrue(bt.contains(i));
            } else {
                Assert.assertFalse(pbt.contains(i));
                Assert.assertFalse(bt.contains(i));
            }
        }
    }

    @Test
    public void testRemoveAndContains() {
        PBT<Integer> pbt = new PBT<>();
        PBT<Integer> bt = new BT<>();
        for (int i = 0; i < 100; i++) {
            pbt.add(i);
            bt.add(i);
        }
        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(pbt.contains(i));
            Assert.assertTrue(bt.contains(i));
            pbt.remove(i);
            bt.remove(i);
            Assert.assertFalse(pbt.contains(i));
            Assert.assertFalse(bt.contains(i));
        }
    }

    @Test
    public void toStringTest() {
    }

    @Test
    public void printSibling() {

    }
}
//----PBT------
//    @Override
//    public String toString() {
//        return "PBT{" +
//                "root=" + root +
//                '}';
//    }

//--------PBTNode-----
//        @Override
//        public String toString() {
//            return "PBTNode{" +
//                    "value=" + value +
//                    ", parent=" + parent +
//                    ", left=" + left +
//                    ", right=" + right +
//                    ", subSize=" + subSize +
//                    '}';
//        }