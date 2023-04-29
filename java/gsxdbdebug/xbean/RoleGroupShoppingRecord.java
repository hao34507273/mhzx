package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface RoleGroupShoppingRecord
  extends Bean
{
  public abstract RoleGroupShoppingRecord copy();
  
  public abstract RoleGroupShoppingRecord toData();
  
  public abstract RoleGroupShoppingRecord toBean();
  
  public abstract RoleGroupShoppingRecord toDataIf();
  
  public abstract RoleGroupShoppingRecord toBeanIf();
  
  public abstract Map<Integer, Integer> getBought_num_map();
  
  public abstract Map<Integer, Integer> getBought_num_mapAsData();
  
  public abstract List<Long> getParticipating_groups();
  
  public abstract List<Long> getParticipating_groupsAsData();
  
  public abstract List<Long> getParticipated_groups();
  
  public abstract List<Long> getParticipated_groupsAsData();
  
  public abstract Map<Long, Integer> getUsed_bind_yuanbao_map();
  
  public abstract Map<Long, Integer> getUsed_bind_yuanbao_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGroupShoppingRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */