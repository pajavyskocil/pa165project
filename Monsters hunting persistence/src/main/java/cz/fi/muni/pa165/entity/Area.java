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

import cz.fi.muni.pa165.enums.AreaType;

/**
 *   @author Jan Gol <gol.honza@gmail.com>
 */
@Entity

public class Area {
    
    	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Column(nullable = false, unique = true)
	private String name;
        
        @Enumerated
        private AreaType type;
        
        @ManyToMany()
        private Set<Monster> monsters = new HashSet<>();
        
        public Area(){
        }
        
        public Area(String name){
            checkName(name);
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
		checkName(name);
		this.name = name;
	}
        
        public AreaType getType() {
                return type;
        }

        public void setType(AreaType type) {
                this.type = type;
        }
        
        public Set<Monster> getAreas() {
                return monsters;
        }
        
        public void setAreas(Set<Monster> monsters) {
                this.monsters = monsters;
    }
        
        @Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || !(obj instanceof Area)) return false;

		Area area = (Area) obj;

		return getName().equals(area.getName());
                
	}

	@Override
	public int hashCode() {
		int result = getName().hashCode();
		return result;
	}

	private void checkName(String value) {
		if (value == null) {
			throw new IllegalArgumentException("Name can not be null.");
		}
		if (value.isEmpty()) {
			throw new IllegalArgumentException("Name can not be empty.");
		}
	}

}
