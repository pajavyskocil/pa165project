
export interface Monster {
  id: number;
  name: string;
  height: number;
  weight: number;
  agility: string;
}

export interface Weapon {
  id: number;
  name: string;
  appropriateMonsters: Monster[];
  type: string;
  range: number;
  magazineCapacity: number;

}
