package howardedu.sycs363.spring15.lab3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IntegerArrayListTest {
	
    private IntegerArrayList defaultTestList;
    private IntegerArrayList singleParamTestList;
	
    /**
     * Print statement before all test.
     */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("-------------------------------");
        System.out.println("IntegerArrayList test class!!");
        System.out.println("-------------------------------\n");
	}
	
	/**
	 * Before each test reinitialize the array list.
	 */
	@Before
	public void setUp() {
		defaultTestList = new IntegerArrayList();
	}
	
    /**
     * Create an IntegerArrayList using the single parameter constructor.
     */
    @Test
    public void shouldCreateListWithSize() {
        singleParamTestList = new IntegerArrayList(3);
        assertTrue("FAILURE - new list not empty",
                singleParamTestList.isEmpty());
    }

    /**
     * Adds a single element to the list.
     */
    @Test
    public void shouldAddElement() {
        defaultTestList.add(1);
        assertEquals("FAILURE - correct element not inserted",
                1, defaultTestList.get(0));
    }

    /**
     * Adds multiple elements to the list.
     */
    @Test
    public void shouldAddElements() {
        defaultTestList.add(1);
        defaultTestList.add(2);
        assertEquals("FAILURE - correct elements not inserted",
                1, defaultTestList.get(0));
        assertEquals("FAILURE - correct elements not inserted",
                2, defaultTestList.get(1));
    }

    /**
     * Adds an element in nonsequential order using the overloaded add method.
     *     Resulting in 0s being between the last element and the newly inserted
     *     element.
     */
    @Test
    public void shouldAddNonSequentialElement() {
        defaultTestList.add(1);
        defaultTestList.add(2);
        defaultTestList.add(3);

        defaultTestList.add(6, 4);

        for (int i = 4; i < 6; i++) {
            assertEquals("FAILURE - element not inserted correctly",
                    0, defaultTestList.get(i));
        }

        assertEquals("FAILURE - element not inserted correctly",
                4, defaultTestList.get(6));
    }

    /**
     * Replaces an element at the given index.
     */
    @Test
    public void shouldReplaceElement() {
        defaultTestList.add(1);
        defaultTestList.add(0, 2);

        assertEquals("FAILURE - element not replaced", 2,
                defaultTestList.get(0));
    }

    /**
     * Removes element at given index.
     */
    @Test
    public void shouldRemoveElement() {
        defaultTestList.add(1);
        defaultTestList.remove(0);
        assertTrue("FAILURE - element not removed",
                defaultTestList.isEmpty());
    }

    /**
     * Adds an element above the specified array list size.
     */
    @Test
    public void shouldIncreaseListSize() {
        singleParamTestList = new IntegerArrayList(2);
    	singleParamTestList.add(1);
    	singleParamTestList.add(2);
        singleParamTestList.add(3);

        assertEquals("FAILURE - array size not increased", 3,
                singleParamTestList.get(2));
    }
    
    /**
     * Print statement after all test.
     */
	@AfterClass
	public static void tearDown() throws Exception {
        System.out.println("-------------------------------");
        System.out.println("Tests finished!");
        System.out.println("-------------------------------");
	}
	

}