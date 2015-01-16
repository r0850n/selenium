import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vaadin.ui.Table;

import components.Tabela;


public class TabelaTest {

	
	private Tabela tab;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tab=new Tabela();
		tab.getTable();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Table tableWithLogs = null;
		tab.setTable(tableWithLogs);
		
		tab.getTable();
		assertNull(null, tableWithLogs);
	}

}
