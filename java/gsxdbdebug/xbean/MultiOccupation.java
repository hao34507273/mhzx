package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MultiOccupation
  extends Bean
{
  public abstract MultiOccupation copy();
  
  public abstract MultiOccupation toData();
  
  public abstract MultiOccupation toBean();
  
  public abstract MultiOccupation toDataIf();
  
  public abstract MultiOccupation toBeanIf();
  
  public abstract List<Integer> getOccupations();
  
  public abstract List<Integer> getOccupationsAsData();
  
  public abstract long getActivate_time();
  
  public abstract long getSwitch_time();
  
  public abstract void setActivate_time(long paramLong);
  
  public abstract void setSwitch_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MultiOccupation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */