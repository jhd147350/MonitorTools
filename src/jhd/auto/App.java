package jhd.auto;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class App extends ApplicationWindow {

	/**
	 * Create the application window.
	 */
	public App() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(4, true);
		container.setLayout(gridLayout);

		initMailGroup(container);
		initRemedyTSGroup(container);
		initRemedyIaaSGroup(container);
		initBlueboxSensuGroup(container);
		// 添加状态栏
		Composite statusComposite = (Composite) getStatusLineManager().getControl();
		final Composite composite = new Composite(statusComposite, SWT.LEFT_TO_RIGHT);
		RowLayout rl = new RowLayout(SWT.HORIZONTAL);
		rl.marginHeight = 1;
		composite.setLayout(rl);
		Label label = new Label(composite, SWT.NONE);
		label.setText("当前登录用户...");
		
		Label separator = new Label(composite, SWT.SEPARATOR);
		
		composite.pack();
		statusComposite.pack();

		// 自适应布局
		container.pack();
		parent.pack();

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * 
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * 
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * 
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();

		return statusLineManager;
		// return null;//暂时用不到状态栏
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			App window = new App();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * 
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("New Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	private void initMailGroup(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		group.setText("Mail");
		group.setToolTipText("mail listen");
		RowLayout rl_group = new RowLayout(SWT.VERTICAL);
		rl_group.center = true;
		group.setLayout(rl_group);

		ListViewer listViewer = new ListViewer(group, SWT.NONE);
		List<String> datas = new ArrayList<String>();
		datas.add("jia.haodong@21vianet.com1");
		datas.add("jia.haodong@21vianet.com2");
		datas.add("jia.haodong@21vianet.com3");
		datas.add("jia.haodong@21vianet.com4");
		datas.add("jia.haodong@21vianet.com5");
		datas.add("jia.haodong@21vianet.com6");

		listViewer.setContentProvider(new ContentProvider());
		listViewer.setLabelProvider(new LabelProvider());
		listViewer.setInput(datas);

		Button start = new Button(group, SWT.TOGGLE | SWT.CENTER);
		start.setText("start");
	}

	private void initRemedyTSGroup(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText("Remedy TS");
		group.setToolTipText("Remedy TS listen");
		group.setLayout(new RowLayout(SWT.VERTICAL));
	}

	private void initRemedyIaaSGroup(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText("Remedy IaaS");
		group.setToolTipText("Remedy IaaS listen");
		group.setLayout(new RowLayout(SWT.VERTICAL));
	}

	private void initBlueboxSensuGroup(Composite parent) {
		Group group = new Group(parent, SWT.NONE);
		group.setText("Bluebox Sensu");
		group.setToolTipText("Bluebox Sensu listen");
		group.setLayout(new RowLayout(SWT.VERTICAL));
	}

	static class ContentProvider implements IStructuredContentProvider {

		@Override
		public Object[] getElements(Object element) {
			return ((List) element).toArray();
		}
	}

	static class LabelProvider implements ILabelProvider {

		@Override
		public void addListener(ILabelProviderListener arg0) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public boolean isLabelProperty(Object arg0, String arg1) {
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener arg0) {
		}

		@Override
		public Image getImage(Object arg0) {
			return null;
		}

		@Override
		public String getText(Object arg0) {
			return (String) arg0;
		}

	}
}
