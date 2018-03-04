package nmfs.gen.spike;

import java.util.List;

public class ModelGenerator {

    public String generate(GenClassModel classModel)
    {
        String retVal=getClassTemplate();
        String packageName=classModel.getPackageName();
        String className=classModel.getClassName();
        String properties=prepProperties(classModel.getPropertyModelList());

        retVal=retVal.replace("#####PACKAGENAME#####",packageName);
        retVal=retVal.replace("#####CLASSNAME#####",className);
        retVal=retVal.replace("#####PROPERTIES#####",properties);

        return retVal;
    }
    private String prepProperties(List<GenPropertyModel> propertyList)
    {
        String retVal="";
        for(GenPropertyModel p:propertyList)
        {
            retVal+="\tprivate "+p.getPropertyType()+" "+p.getPropertyName()+";\n";
        }

        return retVal;
    }


    private String getClassTemplate()
    {
        String template=
                "package #####PACKAGENAME#####;\n" +
                        "\n" +
                        "import lombok.AllArgsConstructor;\n" +
                        "import lombok.Builder;\n" +
                        "import lombok.Data;\n" +
                        "import lombok.NoArgsConstructor;\n" +
                        "\n" +
                        "@Builder\n" +
                        "@Data\n" +
                        "@AllArgsConstructor\n" +
                        "@NoArgsConstructor\n" +
                        "public class #####CLASSNAME##### {\n" +
                        "\n" +
                        "#####PROPERTIES#####"+
                        "\t\n" +
                        "}\n";
        return template;
    }

}
