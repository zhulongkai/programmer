package com.zlk.web.platform.cutil;

import com.zlk.web.platform.createfile.TakeFileRoot;
import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class FreemarketUtil {
    private final static String PATH_DEBUG = "/spring/template/";
    private final static String PATH_RELEASE = "resources/spring/template/";
    private static String path;
    public final static int TYPE_ENTITY = 0;
    public final static int TYPE_DAO = 1;
    public final static int TYPE_SERVICE = 2;
    public final static int TYPE_CONTROLLER = 3;
    public final static int TYPE_MAPPER = 4;
    private static Configuration configuration;

    static {
            path = PATH_DEBUG;
//            path = PATH_RELEASE;
    }

    public static synchronized Configuration getInstance() {
        if (null == configuration) {
            configuration = new Configuration(Configuration.VERSION_2_3_23);
            try {
                TakeFileRoot takeFileRoot = new TakeFileRoot();
                String fileRoot = takeFileRoot.getProgrammerFileName();
                System.out.println(fileRoot);
                configuration.setDirectoryForTemplateLoading(new File(fileRoot+path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            configuration.setEncoding(Locale.CHINA, "utf-8");
        }
        return configuration;
    }

}
