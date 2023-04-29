package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface LoginInfo
  extends Bean
{
  public abstract LoginInfo copy();
  
  public abstract LoginInfo toData();
  
  public abstract LoginInfo toBean();
  
  public abstract LoginInfo toDataIf();
  
  public abstract LoginInfo toBeanIf();
  
  public abstract long getLast_time();
  
  public abstract Set<Integer> getSortids();
  
  public abstract Set<Integer> getSortidsAsData();
  
  public abstract Set<Integer> getUnreceivedsortids();
  
  public abstract Set<Integer> getUnreceivedsortidsAsData();
  
  public abstract void setLast_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LoginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */