package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MultiRoleMounts
  extends Bean
{
  public abstract MultiRoleMounts copy();
  
  public abstract MultiRoleMounts toData();
  
  public abstract MultiRoleMounts toBean();
  
  public abstract MultiRoleMounts toDataIf();
  
  public abstract MultiRoleMounts toBeanIf();
  
  public abstract int getMounts_cfg_id();
  
  public abstract List<Long> getRole_ids();
  
  public abstract List<Long> getRole_idsAsData();
  
  public abstract void setMounts_cfg_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MultiRoleMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */