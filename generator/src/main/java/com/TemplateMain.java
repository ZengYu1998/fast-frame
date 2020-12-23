package com;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * <pre>
 * 对象功能 模板生成类
 * 开发人员：曾煜
 * 创建时间：2020/8/11 18:12
 * </pre>
 **/
public class TemplateMain {
    public static void main(String[] args) throws Exception {
        createTemple();
    }



    private static void createTemple() throws Exception{
        Properties pro=getConfig();
        String author=pro.getProperty("author");
        boolean fileOverride= Boolean.parseBoolean(pro.getProperty("fileOverride"));
        boolean openSwagger2=Boolean.parseBoolean(pro.getProperty("openSwagger2"));
        String url=pro.getProperty("url");
        String driverName=pro.getProperty("driverName");
        String userName=pro.getProperty("userName");
        String password=pro.getProperty("password");
        boolean openLombok=Boolean.parseBoolean(pro.getProperty("openLombok"));
        boolean restController=Boolean.parseBoolean(pro.getProperty("restController"));
        String parent=pro.getProperty("parent");
        String MapperName=pro.getProperty("MapperName");
        boolean logicDelete=Boolean.parseBoolean(pro.getProperty("logicDelete"));
        String logicDeleteFieldName=pro.getProperty("logicDeleteFieldName");
        boolean createTimeAuto=Boolean.parseBoolean(pro.getProperty("createTimeAuto"));
        String createTimeFieldName=pro.getProperty("createTimeFieldName");
        boolean updateTimeAuto=Boolean.parseBoolean(pro.getProperty("updateTimeAuto"));
        String updateTimeFieldName=pro.getProperty("updateTimeFieldName");

        //项目目录
        String projectPath = System.getProperty("user.dir")+"/generator";
        //全局策略
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true)   //支持AR模式
                .setAuthor(author)              //作者
                .setOutputDir(projectPath + "/src/main/java") //生成路径
                .setFileOverride(fileOverride)      //是否覆盖文件
                .setIdType(IdType.ASSIGN_UUID)     //主键策略
                .setOpen(false)              //是否打开输出目录
                .setSwagger2(openSwagger2)          //开启swagger2
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setMapperName("%s"+MapperName);


        //数据源配置
        DataSourceConfig dbConfig = new DataSourceConfig();
        dbConfig.setDbType(DbType.MYSQL);
        dbConfig.setUrl(url);
        // dsc.setSchemaName("public");
        dbConfig.setDriverName(driverName);
        dbConfig.setUsername(userName);
        dbConfig.setPassword(password);


        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true);//全局大写命名
        //下划线转驼峰
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //生成Rest控制器
        strategyConfig.setRestControllerStyle(restController);
        //设置Lombok
        strategyConfig.setEntityLombokModel(openLombok);
        //设置逻辑删除
        if(logicDelete)
            strategyConfig.setLogicDeleteFieldName(logicDeleteFieldName);
        //设置自动填充配置
        List<TableFill> tableFill=new ArrayList<>();
        if(createTimeAuto){
            tableFill.add(new TableFill(createTimeFieldName, FieldFill.INSERT));
        }
        if(updateTimeAuto)
            tableFill.add(new TableFill(updateTimeFieldName, FieldFill.INSERT_UPDATE));

        if(tableFill.size()!=0)
            strategyConfig.setTableFillList(tableFill);
        //乐观锁配置
        //strategyConfig.setVersionFieldName("version");

        //strategyConfig.setInclude(new String[] { "user_info" });  //只生成指定的表

        String templatePath = "/templates/mapper.xml.vm";

        //包名
        PackageConfig packageConfig=new PackageConfig();
        //设置父包
        packageConfig.setParent(parent);
        packageConfig.setMapper(MapperName.toLowerCase());
        packageConfig.setXml(null);

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        cfg.setFileOutConfigList(focList);

        //整合配置
        AutoGenerator autoGenerator=new AutoGenerator();
        autoGenerator.setCfg(cfg);
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dbConfig);
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setPackageInfo(packageConfig);

        //执行
        autoGenerator.execute();
        deleteDir(new File(projectPath+"/src/main/java/"+parent.replaceAll("\\.","/")+"/null"));
    }

    /**
     * 获取配置
     * @return 配置类
     * @throws Exception 读取配置失败
     */
    private static Properties getConfig() throws Exception{
        ClassLoader classLoader = TemplateMain.class.getClassLoader();
        URL resourceUrl = classLoader.getResource("config.properties");
        String path = resourceUrl.getPath();
        path= path.replaceAll("%20"," ");
        File file=new File(path);
        Properties pro = new Properties();
        pro.load(new FileInputStream(file));
        return pro;
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean true 删除成功 false 删除失败
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

}
