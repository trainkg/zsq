package org.zsq.gui.app;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class Application {
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					new MainFrame();		
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
