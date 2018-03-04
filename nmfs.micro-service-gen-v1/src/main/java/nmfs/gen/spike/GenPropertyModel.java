package nmfs.gen.spike;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenPropertyModel {

    private String propertyName;
    private String propertyType;
    // private validation rules ? different class type ?
    // private mandatory rules ?

}
