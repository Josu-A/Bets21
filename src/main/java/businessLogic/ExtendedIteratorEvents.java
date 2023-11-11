package businessLogic;

import java.util.NoSuchElementException;

import domain.Event;

public class ExtendedIteratorEvents implements ExtendedIterator<Event> {
	
	private Event[] events;
	private int current;
	
	public ExtendedIteratorEvents(Event[] events) {
		this.events = events;
		this.current = 0;
	}

	@Override
	public boolean hasNext() {
		return this.events.length != 0 && this.current < this.events.length;
	}

	@Override
	public Event next() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}
		return this.events[this.current++];
	}

	@Override
	public Event previous() {
		if (!this.hasPrevious()) {
			throw new NoSuchElementException();
		}
		return this.events[this.current--];
	}

	@Override
	public boolean hasPrevious() {
		return this.events.length != 0 && this.current > -1;
	}

	@Override
	public void goFirst() {
		this.current = 0;
	}

	@Override
	public void goLast() {
		this.current = this.events.length > 0 ? this.events.length - 1 : 0;
	}

}
