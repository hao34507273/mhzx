package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ModuleFunSwitchInfo
  extends Bean
{
  public abstract ModuleFunSwitchInfo copy();
  
  public abstract ModuleFunSwitchInfo toData();
  
  public abstract ModuleFunSwitchInfo toBean();
  
  public abstract ModuleFunSwitchInfo toDataIf();
  
  public abstract ModuleFunSwitchInfo toBeanIf();
  
  public abstract List<Integer> getParams();
  
  public abstract List<Integer> getParamsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ModuleFunSwitchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */