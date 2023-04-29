package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface NoneRealTimeSnsRoles
  extends Bean
{
  public abstract NoneRealTimeSnsRoles copy();
  
  public abstract NoneRealTimeSnsRoles toData();
  
  public abstract NoneRealTimeSnsRoles toBean();
  
  public abstract NoneRealTimeSnsRoles toDataIf();
  
  public abstract NoneRealTimeSnsRoles toBeanIf();
  
  public abstract long getSavetime();
  
  public abstract List<Long> getRoleids();
  
  public abstract List<Long> getRoleidsAsData();
  
  public abstract void setSavetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimeSnsRoles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */