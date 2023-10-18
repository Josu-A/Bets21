import java.util.Date;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import dataAccess.DataAccessReturnMoney;
import domain.Event;
import domain.Mugimendua;
import domain.User;
import test.dataAccess.TestDataAccess;

public class ReturnMoneyDAB2Test {

    static DataAccessReturnMoney sut = new DataAccessReturnMoney();

    static TestDataAccess testDA = new TestDataAccess();

    @Test
    public void test1() {
    	User u = null;
    	try {
    		int expected = 100;
    		
    		u = new User("John", "John", "Smith", "johnsmith", 35, "johnsmith@gmail.com", expected, new LinkedList<>());
    		Event e = new Event(14, "deskribapena", new Date());
    		
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
    public void test2() {
    	User u = null;
    	try {
    		int expected = 100;
    		
    		LinkedList<Mugimendua> mugList = new LinkedList<>();
    		Event e = new Event(16, "deskribapena", new Date());
    		Mugimendua mug = new Mugimendua(20, e, null, "deskribapena");
    		mugList.add(mug);
    		u = new User("John", "John", "Smith", "johnsmith", 35, "johnsmith@gmail.com", expected, mugList);
    		
    		testDA.open();
    		testDA.storeUser(u);
    		testDA.close();
    		
    		sut.open(false);
    		sut.returnMoney(u, e);
    		sut.close();
    		
    		testDA.open();
    		double res = testDA.getUser(u).getDirua();
    		testDA.close();
    		
    		assertEquals(Double.valueOf(expected + 20), (Double) res);
    		
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
    		
    		LinkedList<Mugimendua> mugList = new LinkedList<>();
    		Event e = new Event(16, "deskribapena", new Date());
    		Event e2 = new Event(17, "deskribapena", new Date());
    		Mugimendua mug = new Mugimendua(20, e2, null, "deskribapena");
    		mugList.add(mug);
    		u = new User("John", "John", "Smith", "johnsmith", 35, "johnsmith@gmail.com", expected, mugList);
    		
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
    		boolean expected = false;
    		
    		Event e = null;
    		
    		boolean res = sut.returnMoney(u, e);
    		
    		assertEquals(expected, res);
    		
    	} catch (Exception e) {
    		fail();
    	}
    }
    
    @Test
    public void test5() {
    	User u = null;
    	try {
    		boolean expected = false;
    		
    		u = new User("John", "John", "Smith", "johnsmith", 35, "johnsmith@gmail.com", 100, null);
    		User u2 = new User("Jose", "Jose", "Smith", "josesmith", 35, "josesmith@gmail.com", 100, null);
    		Event e = null;
    		
    		testDA.open();
    		testDA.storeUser(u);
    		testDA.close();
    		
    		assertEquals(expected, sut.returnMoney(u2, e));
    		
    	} catch (Exception e) {
    		fail();
    	} finally {
    		testDA.open();
    		testDA.removeUser(u);
    		testDA.close();
    	}
    }
    
    @Test
    public void test6() {
    	User u = null;
    	try {
    		boolean expected = false;
    		
    		LinkedList<Mugimendua> mugList = new LinkedList<>();
    		Event e = new Event(16, "deskribapena", new Date());
    		Mugimendua mug = new Mugimendua(20, e, null, "deskribapena");
    		mugList.add(mug);
    		u = new User("John", "John", "Smith", "johnsmith", 35, "johnsmith@gmail.com", 100, mugList);
    		Event e2 = null;
    		
    		testDA.open();
    		testDA.storeUser(u);
    		testDA.close();
    		
    		assertEquals(expected, sut.returnMoney(u, e2));
    		
    	} catch (Exception e) {
    		fail();
    	} finally {
    		testDA.open();
    		testDA.removeUser(u);
    		testDA.close();
    	}
    }

}