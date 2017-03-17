package zsq.triankg.core.util.hibernate.genarate;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;

/**
 * HIBERNATE 帮助类
 * <p>
 * @作者:       zhuyy
 * <p>
 * @日期:       2014-4-14
 * <p>
 * @负责人:     zhuyy
 * <p>
 * @负责小组:   commons
 * <p>
 * <p>
 */
public class HibernateToolsUtil
{
    public static String SL = "\tprivate static final long serialVersionUID = {0}L;";

    /**
     * 文件转码, 不遍历子目录
     * @param files 
     * @param from 原始编码
     * @param to 转换编码
     * @param path 转码后文件存放位置
     */
    public static void fileChangeEncoding(Collection<File> files, String from, String to,
        String path) throws IOException
    {
        if (files == null)
        {
            return;
        }

        File template = FileUtils.getTempDirectory();
        template = new File(template, "/changeEncoding");
        if(template.exists()) FileUtils.cleanDirectory(template);
        System.out.println("[系统缓存目录]:" + template);
        System.out.println("执行转码------------------");
        for (Iterator<File> iterator = files.iterator(); iterator.hasNext();)
        {
            File fromFile = (File)iterator.next();
            System.out.println("当前文件：" + fromFile);
            if (fromFile.getName().contains("Home.java"))
            {
                continue;
            }
            File toFile = new File(template, fromFile.getName());
            FileUtils.writeLines(toFile, to, FileUtils.readLines(fromFile, from), null);
        }
        FileUtils.copyDirectory(template, new File(path));
        System.out.println("转码结束------------------");
    }

    /**
     * HIBERNATE TOOLS 不支持 LIST 需要修改源码 , 但是在最新的4.× 版本中修改失败, 还是直接通过一个转换工具全部替换掉
     * @param files
     * @param encoding 文件编码
     * @param toPath 转换后文件放置路径
     */
    public static void changeToList(Collection<File> files, String encoding, String toPath)
        throws IOException
    {
        if (files == null)
        {
            return;
        }

        Random r = new Random(Long.MAX_VALUE);
        File template = FileUtils.getTempDirectory();
        template = new File(template, "/changeToList");
        if(template.exists()) FileUtils.cleanDirectory(template);
        System.out.println("[系统缓存目录]:" + template);
        System.out.println("执行替换SET------------------");
        for (Iterator<File> iterator = files.iterator(); iterator.hasNext();)
        {
            File fromFile = (File)iterator.next();
            if (fromFile.getName().contains("Home.java"))
            {
                continue;
            }
            System.out.println("当前文件：" + fromFile);
            File toFile = new File(template, fromFile.getName());
            List<String> lines = FileUtils.readLines(fromFile);
            // i 下标,j 记录序列号行，c 记录定义class下标 行
            int i = 0, j = 0;
            // 标识是否是人员扩展
            for (String line : lines)
            {
                /*
                 * 不处理内部类情况 
                 */
                if (line.contains(" class "))
                {
                    j = i + 1;
                }

                if (i == j && i != 0)
                {
                    if (line.contains("{"))
                    {
                        j = i + 1;
                    }
                }
                line = replaceSet(line);
                lines.set(i, line);
                i++;

            }
            /****************************************************************/
            // 填充序列号, 一些自定义处理
            lines.add(j, MessageFormat.format(SL, String.valueOf(r.nextLong())));

            /****************************************************************/
            FileUtils.writeLines(toFile, encoding, lines, null);
        }
        FileUtils.copyDirectory(template, new File(toPath));
        System.out.println("替换SET结束------------------");
    }

    public static String replaceSet(String line)
    {
    	System.out.println("----------------------"+line);
        line = line.replaceAll("\\.Set;$", ".List;");
        line = line.replaceAll("\\bSet<", "List<");
        line = line.replaceAll("\\.HashSet;$", ".ArrayList;");
        line = line.replaceAll("\\bHashSet<", "ArrayList<");
        
        // replace byte
        line = line.replaceAll("\\bbyte\\b", "Boolean");
        line = line.replaceAll("\\bByte\\b", "Boolean");
        System.out.println("---------------------- END "+line);
        return line;
    }

    /**
     * 转移文件, 将源文件地址中以HOME 结尾的文件全部转移到目标目录, 并且使用指定后缀
     * @param filePath 源文件目录
     * @param toPath 目标文件目录
     * @param string 原始文件结尾
     * @param string2 改变结尾
     * @param encoding 文件编码
     */
    public static void moveDaoFile(String filePath, String toPath, String string, String string2,
        String encoding,String packagepath) throws IOException
    {
        Collection<File> files = FileUtils.listFiles(new File(filePath), new String[]{"java"},
            false);
        if (files == null)
        {
            return;
        }

        File template = FileUtils.getTempDirectory();
        template = new File(template, "/changeDaoName");
        template.mkdir();
        if(template.exists()) FileUtils.cleanDirectory(template);
        System.out.println("[系统缓存目录]:" + template);
        System.out.println("执行转换名称------------------");
        for (Iterator<File> iterator = files.iterator(); iterator.hasNext();)
        {
            File fromFile = (File)iterator.next();
            String fileName = fromFile.getName();
            if (!fileName.endsWith("Home.java"))
            {
                continue;
            }
            System.out.println("当前文件：" + fromFile);
            List<String> lines = FileUtils.readLines(fromFile);
            int i = 0;
            for (String line : lines)
            {
                if (line.contains("package"))
                {
                    lines.set(i, "package "+packagepath+";");
                    continue;
                }
                i++;
            }

            File toFile = new File(template, fromFile.getName().replaceAll("Home.java", "Dao.java"));
            String toFileName = toFile.getName();
            File s = new File(toPath,toFileName);
            System.out.println("s ========================== " + s.exists());
            if(s.exists()){
                continue;
            }
            /****************************************************************/
            FileUtils.writeLines(toFile, encoding, lines, null);
            
        }
        FileUtils.copyDirectory(template, new File(toPath));
        System.out.println("转换名称结束------------------");
    }

}
