package cz.fi.muni.pa165.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import cz.fi.muni.pa165.enums.WeaponType;

/**
 *   @author Pavel Vyskocil <vyskocilpavel@muni.cz>
 */
@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(nullable=false, unique=true)
    private String name;

    @Enumerated
    private WeaponType type;

    @ManyToMany()
    private Set<Monster> appropriateMonsters = new HashSet<>();

    private Integer range;

    private Integer magazineCapacity;

    public Weapon (String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name can not be null.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can not be empty.");
        }
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public Set<Monster> getAppropriateMonsters() {
        return appropriateMonsters;
    }

    public void setAppropriateMonsters(Set<Monster> appropriateMonsters) {
        this.appropriateMonsters = appropriateMonsters;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getMagazineCapacity() {
        return magazineCapacity;
    }

    public void setMagazineCapacity(Integer magazineCapacity) {
        this.magazineCapacity = magazineCapacity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Weapon)) return false;

        Weapon weapon = (Weapon) o;

        if (!getName().equals(weapon.getName())) return false;
        if (getType() != weapon.getType()) return false;
        if (getRange() != null ? !getRange().equals(weapon.getRange()) : weapon.getRange() != null) return false;
        return getMagazineCapacity() != null ? getMagazineCapacity().equals(weapon.getMagazineCapacity()) : weapon.getMagazineCapacity()== null;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + (getRange() != null ? getRange().hashCode() : 0);
        result = 31 * result + (getMagazineCapacity() != null ? getMagazineCapacity().hashCode() : 0);
        return result;
    }
}
