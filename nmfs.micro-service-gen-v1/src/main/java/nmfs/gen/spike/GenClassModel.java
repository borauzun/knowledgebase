package nmfs.gen.spike;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenClassModel {

    private String className;
    private String packageName;
    private List<GenPropertyModel> propertyModelList;

}

