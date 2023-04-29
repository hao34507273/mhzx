package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface NotNotifyMarriage
  extends Bean
{
  public abstract NotNotifyMarriage copy();
  
  public abstract NotNotifyMarriage toData();
  
  public abstract NotNotifyMarriage toBean();
  
  public abstract NotNotifyMarriage toDataIf();
  
  public abstract NotNotifyMarriage toBeanIf();
  
  public abstract Set<Long> getMarriageids();
  
  public abstract Set<Long> getMarriageidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NotNotifyMarriage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */