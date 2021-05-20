
package adtbag;

import org.junit.Test;
import static org.junit.Assert.*;


public class BagLinkedObjectsTest {
    
    public BagLinkedObjectsTest() {
    }

    @Test
    public void testGetCurrentSize() {
        // AAA format
        
        // Arrange - setup all the variables need to test, included expected results
        BagLinkedObjects<String> bag = new BagLinkedObjects<>();
        bag.add("test");
        int expectedCurrentSize = 1;
        
        // Act - call the code we're testing - get actual results
        int actualCurrentSize = bag.getCurrentSize();
        
        // Assert - did we get what we expected?
        assertEquals(expectedCurrentSize, actualCurrentSize);
    }

    @Test
    public void testIsEmptyNotEmpty() {
        // AAA format
        
        // Arrange - setup all the variables need to test, included expected results
        BagLinkedObjects<String> bag = new BagLinkedObjects<>();
        bag.add("test");
        
        // Act - call the code we're testing - get actual results
        boolean actualIsEmtpy = bag.isEmpty();
        
        // Assert - did we get what we expected?
        assertFalse(actualIsEmtpy);
    }
    
    @Test
    public void testIsEmptyIsEmpty() {
        // AAA format
        
        // Arrange - setup all the variables need to test, included expected results
        BagLinkedObjects<String> bag = new BagLinkedObjects<>();
        
        // Act - call the code we're testing - get actual results
        boolean actualIsEmtpy = bag.isEmpty();
        
        // Assert - did we get what we expected?
        assertTrue(actualIsEmtpy);
    }

    @Test
    public void testAdd() {
        // AAA format
        
        // Arrange - setup all the variables need to test, included expected results
        BagLinkedObjects<String> bag = new BagLinkedObjects<>();   
        String expectedValue = "test";
        int expectedCurrentSize = 1;
        
        // Act - call the code we're testing - get actual results
        boolean addResult = bag.add("test");
        int actualCurrentSize = bag.getCurrentSize();
        Object[] result = bag.toArray();
        
        // Assert - did we get what we expected?
        assertTrue(addResult);
        assertEquals(expectedCurrentSize, actualCurrentSize);
        assertEquals(expectedValue, result[0]);
    }

    @Test
    public void testRemove_0args() {
        fail();
    }

    @Test
    public void testRemove_GenericType() {
        fail();
    }

    @Test
    public void testClear() {
        fail();
    }

    @Test
    public void testGetFrequencyOf() {
        fail();
    }

    @Test
    public void testContains() {
        fail();
    }

    @Test
    public void testToArray() {
        fail();
    }
    
}
