package dasniko.quarkus.funqy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String first;
    private String last;
}
