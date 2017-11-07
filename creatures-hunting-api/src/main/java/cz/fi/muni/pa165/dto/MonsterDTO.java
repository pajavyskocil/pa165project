package cz.fi.muni.pa165.dto;

import cz.fi.muni.pa165.enums.MonsterAgility;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO class for Monster entity
 *
 * @author Vojtech Sassmann &lt;vojtech.sassmann@gmail.com&gt;
 */
public class MonsterDTO {

	private Long id;
	private String name;
	private List<AreaDTO> areas = new ArrayList<>();
	private List<WeaponDTO> appropriateWeapons = new ArrayList<>();
	private Double height;
	private Double weight;
	private MonsterAgility agility;

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

	public List<AreaDTO> getAreas() {
		return areas;
	}

	public void setAreas(List<AreaDTO> areas) {
		this.areas = areas;
	}

	public List<WeaponDTO> getAppropriateWeapons() {
		return appropriateWeapons;
	}

	public void setAppropriateWeapons(List<WeaponDTO> appropriateWeapons) {
		this.appropriateWeapons = appropriateWeapons;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public MonsterAgility getAgility() {
		return agility;
	}

	public void setAgility(MonsterAgility agility) {
		this.agility = agility;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MonsterDTO that = (MonsterDTO) o;

		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (areas != null ? !areas.equals(that.areas) : that.areas != null) return false;
		if (appropriateWeapons != null ? !appropriateWeapons.equals(that.appropriateWeapons) : that.appropriateWeapons != null)
			return false;
		if (height != null ? !height.equals(that.height) : that.height != null) return false;
		if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
		return agility == that.agility;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (areas != null ? areas.hashCode() : 0);
		result = 31 * result + (appropriateWeapons != null ? appropriateWeapons.hashCode() : 0);
		result = 31 * result + (height != null ? height.hashCode() : 0);
		result = 31 * result + (weight != null ? weight.hashCode() : 0);
		result = 31 * result + (agility != null ? agility.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "MonsterDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", areas=" + areas +
				", appropriateWeapons=" + appropriateWeapons +
				", height=" + height +
				", weight=" + weight +
				", agility=" + agility +
				'}';
	}
}
