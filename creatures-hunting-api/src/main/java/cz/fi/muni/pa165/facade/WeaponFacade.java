package cz.fi.muni.pa165.facade;

import cz.fi.muni.pa165.dto.MonsterDTO;
import cz.fi.muni.pa165.dto.WeaponCreateDTO;
import cz.fi.muni.pa165.dto.WeaponDTO;
import cz.fi.muni.pa165.enums.WeaponType;

import java.util.List;

/**
 * Facade interface for WeaponDTO entities.
 *
 * @author Pavel Vyskocil <vyskocilpavel@muni.cz>
 */
public interface WeaponFacade {

    Long createWeapon(WeaponCreateDTO weapon);

    void deleteWeapon(WeaponDTO weapon);

    WeaponDTO findById(Long id);

    WeaponDTO findByName(String name);

    List<WeaponDTO> getAll();

    List<WeaponDTO> getAllForType(WeaponType type);

    void addAppropriateMonster(Long weaponId, Long monsterId);

    void removeAppropriateMonster(Long weaponId, Long monsterId);

    List<WeaponDTO> getTheMostEffectiveWeapon();
    
}
