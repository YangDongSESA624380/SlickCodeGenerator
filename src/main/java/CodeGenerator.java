import org.apache.commons.lang.StringUtils;
import org.jeecgframework.codegenerate.generate.impl.CodeGenerateOne;
import org.jeecgframework.codegenerate.generate.pojo.TableVo;

import java.util.Scanner;

/**
 * jeecg-boot代码生成器
 * 功能说明： 一键生成增删改查所有代码（包括：controller、service、dao、mapper、entity、vue）
 * 自定义模板： 模板位置在/src/main/resources/jeecg/code-template
 *
 * @author scott
 */
public class CodeGenerator {

    /**
     * 代码生成器使用说明（单表模型）
     * <p>
     * [1]、全局配置文件
     * src/main/resources/jeecg/jeecg_config.properties 	： 代码生成器基础配置文件（项目路径、根业务包路径）
     * src/main/resources/jeecg/jeecg_database.properties 	：代码生成器数据库配置文件（独立的数据源配置）
     * <p>
     * [3]、页面使用说明：
     * 1. 页面生成路径： src/main/java/{业务包根路径}/{子业务包}/vue/
     * 2. 使用方法，手工复制到webstorm项目下面
     * 3. 配置访问菜单
     */
    public static void main(String[] args) {
        System.out.println("----jeecg--------- Code------------- Generation -----[单表模型]------- 生成中。。。");

//    	/**[2]、表配置参数 */
        TableVo table = new TableVo();
        //表名
        String tabName = scanner("请输入表名");
        table.setTableName(tabName);
        //表主键策略（IdType.AUTO  IdType.UUID）
        table.setPrimaryKeyPolicy("IdType.UUID");
        //子业务包名
        table.setEntityPackage("camel");
        //实体类名
        table.setEntityName(scanner("请输入实例类名"));
        //功能描述
        table.setFtlDescription("请输入功能描述:");
        new CodeGenerateOne(table).generateCodeFile();
        System.out.println("----jeecg--------- Code------------- Generation -----[单表模型]------- 生成完成。。。");
    }
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new RuntimeException("请输入正确的" + tip + "！");
    }
}