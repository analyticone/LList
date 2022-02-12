import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LListTest
{
	@Test
	void testLListConstructorWithArray()
	{
		LList<Integer> empty = new LList<>();
		assertArrayEquals(empty.toArray(), new LList<Integer>(new Integer[] {}).toArray());

		LList<Integer> one = new LList<>();
		one.add(1);
		assertArrayEquals(one.toArray(), new LList<Integer>(new Integer[] { 1 }).toArray());

		LList<Integer> multiple = new LList<>();
		multiple.add(1);
		multiple.add(2);
		multiple.add(33);
		assertArrayEquals(multiple.toArray(), new LList<Integer>(new Integer[] { 33, 2, 1 }).toArray());
	}

	@Test
	void testAdd()
	{
		LList<Integer> xL = new LList<>();

		Integer[] x = new Integer[1000];
		for (int i = 0; i < x.length; i++)
		{
			xL.add(x.length - i - 1);
			x[i] = i;
		}

		assertArrayEquals(x, xL.toArray());
	}

	@Test
	void testAddToEnd()
	{
		LList<Integer> xL = new LList<>();

		Integer[] x = new Integer[1000];
		for (int i = 0; i < x.length; i++)
		{
			xL.addToEnd(i);
			x[i] = i;
		}

		assertArrayEquals(x, xL.toArray());
	}

	@Test
	void testRemoveFromFront()
	{
		assertEquals(null, new LList<Integer>().removeFromFront());

		assertEquals(1, new LList<Integer>(new Integer[] { 1 }).removeFromFront());
		assertEquals(1, new LList<Integer>(new Integer[] { 1 }).removeFromFront());

		LList<Integer> x = new LList<>(new Integer[] { 1 });
		x.removeFromFront();
		assertEquals(0, x.size());

	}

	@Test
	void testIndexOf()
	{
		// empty
		assertEquals(-1, new LList<Integer>().indexOf(1));
		// first
		assertEquals(0, new LList<Integer>(new Integer[] { 1, 0, 0, 1 }).indexOf(1));
		assertEquals(0, new LList<Integer>(new Integer[] { 1 }).indexOf(1));

		// last
		assertEquals(3, new LList<Integer>(new Integer[] { 1, 0, 0, 9 }).indexOf(9));

		// middle
		assertEquals(2, new LList<Integer>(new Integer[] { 1, 0, 2, 1 }).indexOf(2));

	}

	@Test
	void testSize()
	{
		assertEquals(2, new LList<Integer>(new Integer[] { 1, 0, 0, 1 }).count(1));
		assertEquals(0, new LList<Integer>(new Integer[] { 1, 0, 0, 1 }).count(99));
	}

	@Test
	void testCount()
	{
		assertEquals(2, new LList<Integer>(new Integer[] { 1, 0, 0, 1 }).count(1));
	}

	@Test
	void testDelete()
	{
		assertEquals(null, new LList<>().delete(1));

		LList<Integer> x = new LList<>(new Integer[] { 1 });
		assertEquals(null, x.delete(2));
		assertEquals(1, x.delete(1));
		assertEquals(0, x.size());

		x = new LList<>(new Integer[] { 1, 2, 3, 4 });
		assertEquals(null, x.delete(22));
		assertEquals(4, x.delete(4));
		assertEquals(3, x.size());

		assertEquals(3, x.delete(3));
		assertEquals(2, x.size());

		assertEquals(2, x.delete(2));
		assertEquals(1, x.size());

		assertEquals(1, x.delete(1));
		assertEquals(0, x.size());
	}

	@Test
	void testInsertAt()
	{
		assertFalse(new LList<>(new Integer[] { 1 }).insertAt(2, 2));
		assertFalse(new LList<>(new Integer[] {   }).insertAt(2, 2));
		
		LList<Integer> x = new LList<>(new Integer[] { 1 });
		assertTrue(x.insertAt(0, 0));
		assertArrayEquals(new Integer[] {0,  1}, x.toArray());
		assertEquals(2, x.size());

		assertTrue(x.insertAt(0, -1));
		assertArrayEquals(new Integer[] {-1, 0,  1}, x.toArray());
		assertEquals(3, x.size());

		assertTrue(x.insertAt(2, 11));
		assertArrayEquals(new Integer[] {-1, 0,  11, 1}, x.toArray());
		assertEquals(4, x.size());
		
		assertTrue(x.insertAt(1, -11));
		assertArrayEquals(new Integer[] {-1, -11, 0, 11, 1}, x.toArray());
		assertEquals(5, x.size());	
	}

	@Test
	void testToArray()
	{
		Integer[] x = new Integer[] { 1 };
		assertArrayEquals("single element array", x, new LList<Integer>(x).toArray());

		Integer[] x1 = new Integer[] {};
		assertArrayEquals("zero element array", x1, new LList<Integer>(x1).toArray());

		Integer[] x2 = new Integer[] { 1, 2, 3 };
		assertArrayEquals("zero element array", x2, new LList<Integer>(x2).toArray());
	}

	@Test
	void testReplace()
	{
		assertFalse(new LList<>().replace(1, 2));

		LList<Integer> x = new LList<>(new Integer[] { 1 });
		assertFalse(x.replace(99, 1));
		assertTrue(x.replace(1, 2));
		assertArrayEquals(new Integer[] { 2 }, x.toArray());

		x = new LList<>(new Integer[] { 1, 2, 3 });
		assertFalse(x.replace(99, 1));
		assertTrue(x.replace(3, 99));
		assertArrayEquals(new Integer[] { 1, 2, 99 }, x.toArray());

		assertTrue(x.replace(99, 3));
		assertArrayEquals(new Integer[] { 1, 2, 3 }, x.toArray());

	}

	@Test
	void testReplaceAll()
	{
		assertFalse(new LList<>().replaceAll(1, 2));

		LList<Integer> x = new LList<>(new Integer[] { 1 });
		assertFalse(x.replaceAll(99, 1));
		assertTrue(x.replaceAll(1, 2));
		assertArrayEquals(new Integer[] { 2 }, x.toArray());

		x = new LList<>(new Integer[] { 3, 3, 3 });
		assertFalse(x.replaceAll(99, 1));
		assertTrue(x.replaceAll(3, 99));
		assertArrayEquals(new Integer[] { 99, 99, 99 }, x.toArray());

		assertTrue(x.replaceAll(99, 3));
		assertArrayEquals(new Integer[] { 3, 3, 3 }, x.toArray());
	}

	@Test
	void testReverse()
	{
		LList<Integer> x = new LList<>(new Integer[] { 1, 2, 3 });
		assertArrayEquals(x.toArray(), x.reverse().reverse().toArray());

		x = new LList<>();
		assertArrayEquals(x.toArray(), x.reverse().reverse().toArray());

		x = new LList<>(new Integer[] { 1 });
		assertArrayEquals(x.toArray(), x.reverse().reverse().toArray());
	}

	@Test
	void testToString()
	{
		Integer[] x = {};
		assertEquals(Arrays.toString(x), new LList<Integer>(x).toString());

		Integer[] y = { 1 };
		assertEquals(Arrays.toString(y), new LList<Integer>(y).toString());

		Integer[] z = { 1, 2, 3 };
		assertEquals(Arrays.toString(z), new LList<Integer>(z).toString());
	}

}
