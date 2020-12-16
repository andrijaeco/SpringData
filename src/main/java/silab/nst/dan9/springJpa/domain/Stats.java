package silab.nst.dan9.springJpa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stats")
public class Stats {

    @Id
    @Column(name = "tableName")
    String key;
    @Column(name = "numberOfEntities")
    Long value;

    public Stats() {
    }

    public Stats(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return key.equals(stats.key) &&
                value.equals(stats.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Stats{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
