package dasniko.quarkus.funqy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Family {
    private Person mom;
    private Person dad;
    private List<String> kids;
}
