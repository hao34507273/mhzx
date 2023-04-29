package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface SurpriseScheduleInfo
  extends Bean
{
  public abstract SurpriseScheduleInfo copy();
  
  public abstract SurpriseScheduleInfo toData();
  
  public abstract SurpriseScheduleInfo toBean();
  
  public abstract SurpriseScheduleInfo toDataIf();
  
  public abstract SurpriseScheduleInfo toBeanIf();
  
  public abstract Set<Integer> getOpenedgraphids();
  
  public abstract Set<Integer> getOpenedgraphidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SurpriseScheduleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */