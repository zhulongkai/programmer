package com.zlk.web.platform.cutil;

import com.zlk.common.core.entiry.Columns;
import com.zlk.web.platform.message.ColumnInfo;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EntityTask extends AbstractTask {
    private String packageName;
    private String mainClassName;
    protected String childClassName;
    protected String foreignKey;
    protected List<Columns> mainInfos;


    /**
     * 1.单表生成  2.多表时生成子表实体
     */
    public EntityTask(String packageName, String className, List<Columns> infos) {
        this(packageName, className, null, null, infos);
    }

    /**
     * 多表时生成主表实体
     */
    public EntityTask(String packageName, String mainClassName, String childClassName, String foreignKey, List<Columns> mainInfos) {
        this.packageName = packageName;
        this.mainClassName = mainClassName;
        this.childClassName = childClassName;
        this.foreignKey = foreignKey;
        this.mainInfos = mainInfos;
    }

    @Override
    public void run() throws IOException, TemplateException {
        // 生成Entity填充数据
        System.out.println("Generating " + mainClassName + ".java");
        Map<String, String> entityData = new HashMap<>();
        entityData.put("package", packageName + ".entity");
        entityData.put("author", "GreedyStar");
        entityData.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        entityData.put("className", mainClassName);
        if (!StringUtil.isBlank(childClassName)) { // 多表 主表实体
            entityData.put("properties", GeneratorUtil.generateEntityProperties(childClassName, mainInfos, foreignKey));
        }
        // 生成Entity文件
        FileUtil.generateToJava(FreemarketUtil.TYPE_ENTITY, entityData, mainClassName + ".java");
    }

    public static void main(String[] args){
        Columns columns = new Columns();
        columns.initTest();
        List<Columns> list = new ArrayList<>();
        list.add(columns);
        EntityTask entityTask = new EntityTask("com.zlk.common.base.aaa","sss",list);
        try {
            entityTask.run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
