package businessLogic;

import domain.Event;
import domain.Mugimendua;
import domain.Question;
import domain.User;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BLFacadeImplementationModelAdapter extends AbstractTableModel {
	private User us;
	private final List<Mugimendua> movements;
	private String[] colNames = new String[] {"Event", "Question", "Event date", "Bet (€)"};
	
	public BLFacadeImplementationModelAdapter(BLFacade f, User u) {
		this.us = f.getUser(u);
		this.movements = us.getMugimenduak();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Event ev;
		Question q;
		Mugimendua move = movements.get(rowIndex);
		if (move == null) {
			return "";
		}
		switch(columnIndex) {
			case 0:
				ev = move.getGertaera();
				return ev != null ? ev.getDescription() : "";
			case 1:
				q = move.getGaldera();
				return q != null ? q.getQuestion() : "";
			case 2:
				ev = move.getGertaera();
				return ev != null ? ev.getEventDate() : "";
			case 3:
				ev = move.getGertaera();
				if (ev != null) {
					String desc = ev.getDescription();
					if (desc != null && !desc.equals("")) {
						return move.getDiruKop();
					}
				}
				return "";
			default:
				return null;
		}
	}
	
	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}
	
	@Override
	public int getRowCount() {
		return this.movements.size();
	}
}
