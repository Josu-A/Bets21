import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.User;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMoneyBLBMTest {
	
	@Mock
	DataAccess dataAccess = Mockito.mock(DataAccess.class);
	User mockedUser = Mockito.mock(User.class);
	Event mockedEvent = Mockito.mock(Event.class);
	
	@InjectMocks
	BLFacade sut = new BLFacadeImplementation(dataAccess);

	@Test
	public void test1() {
		try {
			Mockito.doReturn(100).when(mockedUser).getDirua();
			Mockito.doReturn(true).when(dataAccess).getUser(mockedUser);
			Mockito.doReturn(true).when(dataAccess).returnMoney(mockedUser, Mockito.any(Event.class));
		
			Boolean res = sut.returnMoney(mockedUser, Mockito.any(Event.class));
			
			assertEquals(mockedUser, dataAccess.getUser(mockedUser));
			assertEquals(true, res);
			
			ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
			ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
			
			Mockito.verify(dataAccess, Mockito.times(1)).returnMoney(userCaptor.capture(), eventCaptor.capture());
			
			assertEquals(Double.valueOf(100), (Double) userCaptor.getValue().getDirua());
			
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		try {
			Mockito.doReturn(100).when(mockedUser).getDirua();
			Mockito.doReturn(true).when(dataAccess).getUser(mockedUser);
			Mockito.doReturn(true).when(mockedUser).getMugimenduak();
			Mockito.doReturn(true).when(dataAccess).returnMoney(mockedUser, mockedEvent);
		
			Boolean res = sut.returnMoney(mockedUser, mockedEvent);
			
			assertEquals(mockedUser, dataAccess.getUser(mockedUser));
			assertEquals(true, res);
			
			ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
			ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
			
			Mockito.verify(dataAccess, Mockito.times(1)).returnMoney(userCaptor.capture(), eventCaptor.capture());
		} catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		try {
			Mockito.doReturn(100).when(mockedUser).getDirua();
			Mockito.doReturn(true).when(dataAccess).getUser(mockedUser);
			Mockito.doReturn(true).when(mockedUser).getMugimenduak();
			Mockito.doReturn(true).when(dataAccess).returnMoney(mockedUser, Mockito.any(Event.class));
		
			Boolean res = sut.returnMoney(mockedUser, Mockito.any(Event.class));
			
			assertEquals(mockedUser, dataAccess.getUser(mockedUser));
			assertEquals(true, res);
			
			ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
			ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
			
			Mockito.verify(dataAccess, Mockito.times(1)).returnMoney(userCaptor.capture(), eventCaptor.capture());
			
			assertEquals(Double.valueOf(100), (Double) userCaptor.getValue().getDirua());
			
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void test4() {
		try {
			Mockito.doReturn(false).when(dataAccess).returnMoney(Mockito.any(User.class), Mockito.any(Event.class));
			
			assertFalse(dataAccess.returnMoney(null, mockedEvent));
		} catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void test5() {
		try {
			Mockito.doReturn(false).when(dataAccess).returnMoney(Mockito.any(User.class), Mockito.any(Event.class));
			
			assertFalse(dataAccess.returnMoney(mockedUser, mockedEvent));
		} catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void test6() {
		try {
			Event e = null;
			
			Mockito.doReturn(false).when(dataAccess).returnMoney(Mockito.any(User.class), Mockito.any(Event.class));
			
			assertFalse(dataAccess.returnMoney(mockedUser, e));
		} catch(Exception e) {
			fail();
			e.printStackTrace();
		}
	}

}
