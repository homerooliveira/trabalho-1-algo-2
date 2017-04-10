import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by homerooliveira on 07/04/17.
 */
class LinkedListTest {
    LinkedList<Integer> nums;

    @BeforeEach
    void setUp() {
        nums = new LinkedList<>();
    }

    @Test
    void shoulbReturnNumberOne() {
        nums.add(1);
        assertEquals(Integer.valueOf(1), nums.get(0));
    }

    @Test
    void soulbReturnNumberTwo(){
        nums.add(1);
        nums.add(2);
        nums.add(5);
        assertEquals(Integer.valueOf(5), nums.get(2));
    }
}