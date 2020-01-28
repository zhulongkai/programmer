package com.zlk.web.platform.cutil;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class FileUtil {

    private final static String PATH_DEBUG = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath().replace("\\", "/") + "/";
    private final static String PATH_RELEASE = "code/";
    private static String path;

    static {
        path = PATH_DEBUG;
    }

    /**
     * @param type 使用模板类型
     * @param data 填充数据
     * @param fileName 输出文件名
     * @throws IOException
     * @throws TemplateException
     */
    public static void generateToJava(int type, Object data, String fileName) throws IOException, TemplateException {
        Template tpl = getTemplate(type); // 获取模板文件
        // 填充数据
        StringWriter writer = new StringWriter();
        tpl.process(data, writer);
        writer.flush();
        // 写入文件
        FileOutputStream fos = new FileOutputStream(path + fileName);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw, 1024);
        tpl.process(data, bw);
        fos.close();
    }
    /**
     * 获取模板
     * @param type 模板类型
     * @return
     * @throws IOException
     */
    private static Template getTemplate(int type) throws IOException {
        switch (type) {
            case FreemarketUtil.TYPE_ENTITY:
                return FreemarketUtil.getInstance().getTemplate("code.ftl");
            case FreemarketUtil.TYPE_DAO:
                return FreemarketUtil.getInstance().getTemplate("Dao.ftl");
            case FreemarketUtil.TYPE_SERVICE:
                return FreemarketUtil.getInstance().getTemplate("Service.ftl");
            case FreemarketUtil.TYPE_CONTROLLER:
                return FreemarketUtil.getInstance().getTemplate("Controller.ftl");
            case FreemarketUtil.TYPE_MAPPER:
                return FreemarketUtil.getInstance().getTemplate("Mapper.ftl");
            default:
                return null;
        }
    }
}
