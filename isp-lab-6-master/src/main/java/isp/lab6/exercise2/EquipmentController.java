package isp.lab6.exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;
import java.util.Map;

public class EquipmentController {

    List <Equipment> equipmentList = new ArrayList<>();
    /**
     * Add new equipment to the list of equipments
     *
     * @param equipment - equipment to be added
     */
    public void addEquipment(final Equipment equipment) {
        equipmentList.add(equipment);
    }

    /**
     * Get current list of equipments
     *
     * @return list of equipments
     */
    public List<Equipment> getEquipments() {
        return this.equipmentList;
    }

    /**
     * Get number of equipments
     *
     * @return number of equipments
     */
    public int getNumberOfEquipments() {
        return this.equipmentList.size();
    }

    /**
     * Group equipments by owner
     *
     * @return a dictionary where the key is the owner and value is represented by list of equipments he owns
     */
    public Map<String, List<Equipment>> getEquipmentsGroupedByOwner() {
        Map<String, List<Equipment>> ownerMap= new HashMap<>();
        List <Equipment> equipmentList=new ArrayList<>();
        equipmentList.addAll(this.equipmentList);
        Collections.sort(equipmentList, new Sortbyowner());
        String owner = equipmentList.get(0).getOwner();
        List <Equipment> equipmentPerOwner=new ArrayList<>();
        for (Equipment s: equipmentList){
            if (s.getOwner().equals(owner)){
                equipmentPerOwner.add(s);
            }
            else{
                List <Equipment> equipmentPerOwner1=new ArrayList<>();
                equipmentPerOwner1.addAll(equipmentPerOwner);
                ownerMap.put(owner, equipmentPerOwner1);
                owner=s.getOwner();
                equipmentPerOwner.clear();
                equipmentPerOwner.add(s);                         
            }                               
        }
        ownerMap.put(owner, equipmentPerOwner);
        return ownerMap;
    }

    /**
     * Remove a particular equipment from equipments list by serial number
     * @param serialNumber - unique serial number
     * @return deleted equipment instance or null if not found
     */
    public Equipment removeEquipmentBySerialNumber(final String serialNumber) {
        Equipment equipment = null;
        for (Equipment s: this.equipmentList){
            if (s.getSerialNumber().equals(serialNumber)){
                equipment=s;
                this.equipmentList.remove(s);
            }
        }
        return equipment;
    }
}

class Sortbyowner implements Comparator<Equipment> {
    // Used for sorting in ascending order of
    // name
    @Override
    public int compare(Equipment a, Equipment b)
    {
        return a.getOwner().compareTo(b.getOwner());
    }
}
