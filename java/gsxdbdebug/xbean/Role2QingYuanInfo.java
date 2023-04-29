package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface Role2QingYuanInfo
  extends Bean
{
  public abstract Role2QingYuanInfo copy();
  
  public abstract Role2QingYuanInfo toData();
  
  public abstract Role2QingYuanInfo toBean();
  
  public abstract Role2QingYuanInfo toDataIf();
  
  public abstract Role2QingYuanInfo toBeanIf();
  
  public abstract List<Long> getQing_yuan_role_list();
  
  public abstract List<Long> getQing_yuan_role_listAsData();
  
  public abstract Map<Long, QingYuanRoleInfo> getQing_yuan_map_info();
  
  public abstract Map<Long, QingYuanRoleInfo> getQing_yuan_map_infoAsData();
  
  public abstract Set<Integer> getAleardy_used_appellation_cfg_id_set();
  
  public abstract Set<Integer> getAleardy_used_appellation_cfg_id_setAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2QingYuanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */