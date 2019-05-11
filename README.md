# mpdemo
>springboot整合mybatis-plus实现逆向工程以及数据增删改成基本功能

MyBatis-Plus 的代码生成器，通过 AutoGenerator 可以快速生成 Entity、Mapper、Mapper XML、Service、Controller 等各个模块的代码，极大的提升了开发效率。

#### 核心配置
```$xslt
public class CodeGenerator {

    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        /**
         * 全局配置
         */
        GlobalConfig globalConfig = new GlobalConfig();
        //生成文件的输出目录
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        //Author设置作者
        globalConfig.setAuthor("姜飞祥");
        //是否覆盖文件
        globalConfig.setFileOverride(true);
        //生成后打开文件
        globalConfig.setOpen(false);
        mpg.setGlobalConfig(globalConfig);

        /**
         * 数据源配置
          */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 数据库类型,默认MYSQL
        dataSourceConfig.setDbType(DbType.MYSQL);
        //自定义数据类型转换
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mp?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("1234");
        mpg.setDataSource(dataSourceConfig);

        /**
         * 包配置
         */
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent("com.jiangfeixiang.mpdemo");
        mpg.setPackageInfo(pc);

        /**
         * 模板配置
         */


        /**
         * 自定义配置
         */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"+ pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //设置命名格式
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //实体是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        //设置自定义继承的Entity类全称，带包名
        //strategy.setSuperEntityClass("com.jiangfeixiang.mpdemo.BaseEntity");
        //设置自定义继承的Controller类全称，带包名
        //strategy.setSuperControllerClass("com.jiangfeixiang.mpdemo.BaseController");
        //设置自定义基础的Entity类，公共字段
        strategy.setSuperEntityColumns("id");
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //表名前缀
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}

```