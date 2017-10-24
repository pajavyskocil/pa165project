package cz.fi.muni.pa165.dao;

import cz.fi.muni.pa165.entity.Weapon;
import cz.fi.muni.pa165.enums.WeaponType;

import java.util.List;

public interface WeaponDao {

	/**
	 *
	 * @param weapon Weapon for create.
	 */
	void create(Weapon weapon);

	/**
	 *
	 * @param weapon Weapon for delete.
	 */
	void delete(Weapon weapon);

	/**
	 *
	 * @param weapon Weapon for update.
	 */
	void update(Weapon weapon);

	/**
	 * This method return Weapon by Id.
	 * @param id Id of Weapon
	 * @return Weapon
	 */
	Weapon getById(Long id);

	/**
	 * This method return Weapon by Name
	 * @param name Name of Weapon
	 * @return Weapon
	 */
	Weapon getByName(String name);

	/**
	 * This methot return List of all Weapons
	 * @return List of Weapons.
	 */
	List<Weapon> getAll();

	/**
	 * This method return List of all Weapons for WeaponType
	 * @param type WeaponType
	 * @return List of Weapons
	 */
	List<Weapon> getAllForType(WeaponType type);

}
