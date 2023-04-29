package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ZooInfo
  extends Bean
{
  public abstract ZooInfo copy();
  
  public abstract ZooInfo toData();
  
  public abstract ZooInfo toBean();
  
  public abstract ZooInfo toDataIf();
  
  public abstract ZooInfo toBeanIf();
  
  public abstract List<Long> getAnimals();
  
  public abstract List<Long> getAnimalsAsData();
  
  public abstract long getClean_check_time();
  
  public abstract void setClean_check_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ZooInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */