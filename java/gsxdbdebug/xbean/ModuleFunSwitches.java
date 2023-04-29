package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface ModuleFunSwitches
  extends Bean
{
  public abstract ModuleFunSwitches copy();
  
  public abstract ModuleFunSwitches toData();
  
  public abstract ModuleFunSwitches toBean();
  
  public abstract ModuleFunSwitches toDataIf();
  
  public abstract ModuleFunSwitches toBeanIf();
  
  public abstract Map<Integer, ModuleFunSwitchInfo> getFun_switch_infos();
  
  public abstract Map<Integer, ModuleFunSwitchInfo> getFun_switch_infosAsData();
  
  public abstract Set<Integer> getFun_switch_init_infos();
  
  public abstract Set<Integer> getFun_switch_init_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ModuleFunSwitches.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */