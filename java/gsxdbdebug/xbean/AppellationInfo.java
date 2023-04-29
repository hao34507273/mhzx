package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface AppellationInfo
  extends Bean
{
  public abstract AppellationInfo copy();
  
  public abstract AppellationInfo toData();
  
  public abstract AppellationInfo toBean();
  
  public abstract AppellationInfo toDataIf();
  
  public abstract AppellationInfo toBeanIf();
  
  public abstract int getAppellationid();
  
  public abstract int getIspropertyactive();
  
  public abstract List<String> getAppargs();
  
  public abstract List<String> getAppargsAsData();
  
  public abstract long getTimeout();
  
  public abstract void setAppellationid(int paramInt);
  
  public abstract void setIspropertyactive(int paramInt);
  
  public abstract void setTimeout(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AppellationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */