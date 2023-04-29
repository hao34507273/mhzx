package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface ZoneInfo
  extends Bean
{
  public abstract ZoneInfo copy();
  
  public abstract ZoneInfo toData();
  
  public abstract ZoneInfo toBean();
  
  public abstract ZoneInfo toDataIf();
  
  public abstract ZoneInfo toBeanIf();
  
  public abstract Set<Long> getRole_set();
  
  public abstract Set<Long> getRole_setAsData();
  
  public abstract int getEventid();
  
  public abstract void setEventid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ZoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */