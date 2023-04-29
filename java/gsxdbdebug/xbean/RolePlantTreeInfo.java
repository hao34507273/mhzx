package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RolePlantTreeInfo
  extends Bean
{
  public abstract RolePlantTreeInfo copy();
  
  public abstract RolePlantTreeInfo toData();
  
  public abstract RolePlantTreeInfo toBean();
  
  public abstract RolePlantTreeInfo toDataIf();
  
  public abstract RolePlantTreeInfo toBeanIf();
  
  public abstract Map<Integer, PlantTreeInfo> getPlant_tree_infos();
  
  public abstract Map<Integer, PlantTreeInfo> getPlant_tree_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolePlantTreeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */