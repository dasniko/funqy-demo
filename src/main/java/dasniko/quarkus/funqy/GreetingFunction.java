package dasniko.quarkus.funqy;

import io.quarkus.funqy.Funq;

import javax.inject.Inject;
import java.util.Map;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class GreetingFunction {

    @Inject
    GreetingService service;

    @Funq
    public Greeting hello(Map<String, String> params) {
        return service.greet(params.get("name"));
    }

    @Funq
    public String greeting(Person person) {
        return String.format("Hello %s %s!", person.getFirst(), person.getLast());
    }

    @Funq("family")
    public String greetFamily(Family family) {
        return String.format("Hello Mom, %s %s and Dad, %s %s!",
                family.getMom().getFirst(), family.getMom().getLast(),
                family.getDad().getFirst(), family.getDad().getLast());
    }

    @Funq("kids")
    public String greedKids(Family family) {
        return String.format("Hello %s!", String.join(", ", family.getKids()));
    }

    @Funq
    public Family jsonFamily(Family family) {
        return family;
    }
}
