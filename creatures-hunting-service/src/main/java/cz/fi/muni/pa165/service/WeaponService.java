package cz.fi.muni.pa165.service;

import cz.fi.muni.pa165.entity.Monster;
import cz.fi.muni.pa165.entity.Weapon;
import cz.fi.muni.pa165.enums.WeaponType;

import java.util.List;

/**
 * Service interface for managing Weapon enities.
 *
 * @author Pavel Vyskocil <vyskocilpavel@muni.cz>
 */
public interface WeaponService {

    void createWeapon(Weapon weapon);

    void deleteWeapon(Weapon weapon);

    Weapon findById(Long id);

    Weapon findByName(String name);

    List<Weapon> getAllWeapons();

    List<Weapon> getAllForType(WeaponType type);

    void addAppropriateMonster(Long weaponId, Long monsterId);

    void removeAppropriateMonster(Long weaponId, Long monsterId);

    List<Weapon> getTheMostEffectiveWeapon();
}
