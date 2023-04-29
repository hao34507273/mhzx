package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface GlobalSurpriseScheduleInfo
  extends Bean
{
  public abstract GlobalSurpriseScheduleInfo copy();
  
  public abstract GlobalSurpriseScheduleInfo toData();
  
  public abstract GlobalSurpriseScheduleInfo toBean();
  
  public abstract GlobalSurpriseScheduleInfo toDataIf();
  
  public abstract GlobalSurpriseScheduleInfo toBeanIf();
  
  public abstract Map<Integer, DaySessionInfo> getSessioninfos();
  
  public abstract Map<Integer, DaySessionInfo> getSessioninfosAsData();
  
  public abstract Set<Integer> getOpenedgraphids();
  
  public abstract Set<Integer> getOpenedgraphidsAsData();
  
  public abstract int getEffectserverlevel();
  
  public abstract void setEffectserverlevel(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GlobalSurpriseScheduleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */