package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SuperEquipmentCostBean
  extends Bean
{
  public abstract SuperEquipmentCostBean copy();
  
  public abstract SuperEquipmentCostBean toData();
  
  public abstract SuperEquipmentCostBean toBean();
  
  public abstract SuperEquipmentCostBean toDataIf();
  
  public abstract SuperEquipmentCostBean toBeanIf();
  
  public abstract Map<Integer, Integer> getStage_cost_map();
  
  public abstract Map<Integer, Integer> getStage_cost_mapAsData();
  
  public abstract Map<Integer, Integer> getLevel_cost_map();
  
  public abstract Map<Integer, Integer> getLevel_cost_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SuperEquipmentCostBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */