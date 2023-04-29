package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GangHelpInfo
  extends Bean
{
  public abstract GangHelpInfo copy();
  
  public abstract GangHelpInfo toData();
  
  public abstract GangHelpInfo toBean();
  
  public abstract GangHelpInfo toDataIf();
  
  public abstract GangHelpInfo toBeanIf();
  
  public abstract Map<Long, CallHelpData> getRole2helpdata();
  
  public abstract Map<Long, CallHelpData> getRole2helpdataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangHelpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */