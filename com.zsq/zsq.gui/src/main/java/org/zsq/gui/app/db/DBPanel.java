package org.zsq.gui.app.db;

import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

import org.zsq.gui.app.entity.DBConfig;

/**
 * 管控DB
 * @author Administrator
 */

public class DBPanel extends JPanel  {
	
	private static final long serialVersionUID = 1L;

	@Setter @Getter
	DBMenuBar bar;
	
	@Getter
	List<DBConfig> configs;
	
	public DBPanel() {
		
		bar = new DBMenuBar();
		add(bar);
	}
	
	
}
