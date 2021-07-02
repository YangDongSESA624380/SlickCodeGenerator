
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

public class MyMethod implements TemplateMethodModelEx {
    @Override
    public String exec(List args) throws TemplateModelException {
        SimpleSequence arg0 = (SimpleSequence) args.get(0);
        List<String> list = arg0.toList();
        System.out.println(list);
        return "123456";
    }
}
