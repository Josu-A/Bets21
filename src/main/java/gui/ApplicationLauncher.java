package gui;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.UIManager;

import configuration.ConfigXML;
import domain.Event;
import businessLogic.BLFacade;
import businessLogic.BLFactory;
import businessLogic.ExtendedIterator;

public class ApplicationLauncher { 
	
	
	
	public static void main(String[] args) {

		ConfigXML c=ConfigXML.getInstance();
	
		System.out.println(c.getLocale());
		
		Locale.setDefault(new Locale(c.getLocale()));
		
		System.out.println("Locale: "+Locale.getDefault());
		
		MainGUI a=new MainGUI();
		a.setVisible(true);


		try {
			
			BLFacade appFacadeInterface;
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
			appFacadeInterface = BLFactory.createBusinessLogic(c);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdf.parse("17/06/2023");
			ExtendedIterator<Event> i = appFacadeInterface.getEventsIterator(date);
			
			Event e;
			
			System.out.println("____________________");
			System.out.println("ATZETIK AURRERAKA");
			
			i.goLast();
			while (i.hasPrevious()) {
				e = i.previous();
				System.out.println(e.toString());
			}
			
			System.out.println("\n____________________");
			System.out.println("AURRETIK ATZERA");
			
			i.goFirst();
			while (i.hasNext()) {
				e = i.next();
				System.out.println(e.toString());
			}
			
			/*if (c.getDataBaseOpenMode().equals("initialize")) 
				appFacadeInterface.initializeBD();
				*/
			MainGUI.setBussinessLogic(appFacadeInterface);

		

			
		}catch (Exception e) {
			a.jLabelSelectOption.setText("Error: "+e.toString());
			a.jLabelSelectOption.setForeground(Color.RED);	
			
			System.out.println("Error in ApplicationLauncher: "+e.toString());
		}
		//a.pack();


	}

}
