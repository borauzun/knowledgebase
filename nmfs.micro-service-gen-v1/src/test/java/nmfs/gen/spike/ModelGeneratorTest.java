package nmfs.gen.spike;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ModelGeneratorTest {
    @Test
    public void generate() {

        GenClassModel classModel=new GenClassModel();
        classModel.setClassName("Person");
        classModel.setPackageName("nmfs.ms.model");

        List<GenPropertyModel> listOfProperties=new ArrayList<GenPropertyModel>();
        listOfProperties.add(GenPropertyModel.builder().propertyName("name").propertyType("String").build());
        listOfProperties.add(GenPropertyModel.builder().propertyName("lastName").propertyType("String").build());
        listOfProperties.add(GenPropertyModel.builder().propertyName("age").propertyType("int").build());

        classModel.setPropertyModelList(listOfProperties);

        ModelGenerator gen=new ModelGenerator();
        System.out.println(gen.generate(classModel));

    }
}
