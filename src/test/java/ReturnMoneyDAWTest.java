import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import dataAccess.DataAccess;
import domain.Event;
import domain.Mugimendua;
import domain.User;
import test.dataAccess.TestDataAccess;

public class ReturnMoneyDAWTest {

    static DataAccess sut = new DataAccess();

    static TestDataAccess testDA = new TestDataAccess();

    @Test
    public void test1() {
    	try {
    		boolean expected = false;
    		
    		User u = null;
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    		Date d = sdf.parse("01/01/2023");
    		Event ev = new Event("Test event", d);
        
    		assertEquals(sut.returnMoney(u, ev), expected);
    	} catch (Exception e) {
    		fail();
    	}
    }

    @Test
    public void test2() {
    	User u = null;
    	try {
    		int expected = 100;
    		
    		u = new User("John", "John", "Smith", "johnsmith", 35, "johnsmith@gmail.com", expected, new LinkedList<>());
    		Event e = null;
    		
    		testDA.open();
    		testDA.storeUser(u);
    		testDA.close();
    		
    		sut.returnMoney(u, e);
    		
    		testDA.open();
    		double res = testDA.getUser(u).getDirua();
    		testDA.close();
    		
    		assertEquals((Double) res, Double.valueOf(expected));
    		
    	} catch (Exception e) {
    		fail();
    	} finally {
    		testDA.open();
    		testDA.removeUser(u);
    		testDA.close();
    	}
    }

    @Test
    public void test3() {
    	User u = null;
    	try {
    		int expected = 100;
    		
    		LinkedList<Mugimendua> mug = new LinkedList<>();
    		mug.add(null);
    		u = new User("John", "John", "Smith", "johnsmith", 35, "johnsmith@gmail.com", expected, mug);
    		Event e = null;
    		
    		testDA.open();
    		testDA.storeUser(u);
    		testDA.close();
    		
    		sut.returnMoney(u, e);
    		
    		testDA.open();
    		double res = testDA.getUser(u).getDirua();
    		testDA.close();
    		
    		assertEquals((Double) res, Double.valueOf(expected));
    		
    	} catch (Exception e) {
    		fail();
    	} finally {
    		testDA.open();
    		testDA.removeUser(u);
    		testDA.close();
    	}
    }

    @Test
    public void test4() {
    	User u = null;
    	try {
    		int expected = 100;
    		
    		LinkedList<Mugimendua> mugList = new LinkedList<>();
    		Event e = new Event(1, "deskribapena", new Date());
    		Event e2 = new Event(2, "deskribapena", new Date());
    		Mugimendua mug = new Mugimendua(20, e, null, "deskribapena");
    		mugList.add(mug);
    		u = new User("John", "John", "Smith", "johnsmith", 35, "johnsmith@gmail.com", expected, mugList);
    		
    		testDA.open();
    		testDA.storeUser(u);
    		testDA.close();
    		
    		sut.returnMoney(u, e2);
    		
    		testDA.open();
    		double res = testDA.getUser(u).getDirua();
    		testDA.close();
    		
    		assertEquals((Double) res, Double.valueOf(expected));
    		
    	} catch (Exception e) {
    		fail();
    	} finally {
    		testDA.open();
    		testDA.removeUser(u);
    		testDA.close();
    	}
    }
    
    @Test
    public void test5() {
    	User u = null;
    	try {
    		int expected = 110;
    		
    		LinkedList<Mugimendua> mugList = new LinkedList<>();
    		Event e = new Event(1, "deskribapena", new Date());
    		Mugimendua mug = new Mugimendua(10, e, null, "deskribapena");
    		mugList.add(mug);
    		u = new User("John", "John", "Smith", "johnsmith", 35, "johnsmith@gmail.com", 100, mugList);
    		
    		testDA.open();
    		testDA.storeUser(u);
    		testDA.close();
    		
    		sut.open(false);
    		sut.returnMoney(u, e);
    		sut.close();
    		
    		testDA.open();
    		double res = testDA.getUser(u).getDirua();
    		testDA.close();
    		assertEquals(Double.valueOf(expected), (Double) res);
    		
    	} catch (Exception e) {
    		fail();
    	} finally {
    		testDA.open();
    		testDA.removeUser(u);
    		testDA.close();
    	}
    }

}