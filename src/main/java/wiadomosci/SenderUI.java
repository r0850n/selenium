package wiadomosci;

import com.vaadin.Application;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Window;

import components.Sender;

@SuppressWarnings({ "serial" })
public class SenderUI extends Application {

	public static final String PERSISTENCE_UNIT = "robert.Vaadinjpa";
	
     /*public SenderUI(Sender sender){
    	 
	init( sender);
      }*/
	

	public void init() {
		
		// TODO Auto-generated method stub
		setMainWindow(new AutoCrudViews());
	

	}

	static class AutoCrudViews extends Window {

		public AutoCrudViews() {

			Sender sender= new Sender();

			final AbsoluteLayout horizontalSplitPanel = new AbsoluteLayout();

			horizontalSplitPanel.addComponent(sender);

			setContent(horizontalSplitPanel);

		};
	}

	

	
}
