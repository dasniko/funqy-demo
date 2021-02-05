package dasniko.quarkus.funqy;

import java.util.List;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class Family {
    private Person mom;
    private Person dad;
    private List<String> kids;

    public Person getMom() {
        return mom;
    }

    public void setMom(Person mom) {
        this.mom = mom;
    }

    public Person getDad() {
        return dad;
    }

    public void setDad(Person dad) {
        this.dad = dad;
    }

    public List<String> getKids() {
        return kids;
    }

    public void setKids(List<String> kids) {
        this.kids = kids;
    }
}
