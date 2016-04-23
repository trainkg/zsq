package org.zsq.gui.app.gen.pojo;

import java.io.File;
import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.zsq.gui.app.db.ddl.TableDDLInfo;
import org.zsq.gui.app.gen.GenContext;
import org.zsq.gui.app.gen.GenGlobalConfig;
import org.zsq.gui.app.gen.SwitchPath;

import zsq.triankg.core.ZsqException;

/**
 * 
 * 
 * @author peculiar.1@163.com
 * @version $ID: PojoPath.java, V1.0.0 2016年4月23日 下午2:05:55 $
 */
@Getter
@Setter
@AllArgsConstructor
public class PojoPath implements SwitchPath {
	
	private GenContext genContext;
	private TableDDLInfo tableInfo;
	
	@Override
	public File getPath() {
		String schema 			= tableInfo.getSchema();
		String tableName 		= tableInfo.getTableName();
		GenGlobalConfig config	= genContext.getConfig();
		File fileDir = config.getManager().getJavaBasePathFile(tableInfo);
		File pojoFile = new File(fileDir, "");
		if(!pojoFile.exists()){
			try {
				pojoFile.createNewFile();
			} catch (IOException e) {
				throw new ZsqException(e);
			}
		}
		return pojoFile;
	}

}
