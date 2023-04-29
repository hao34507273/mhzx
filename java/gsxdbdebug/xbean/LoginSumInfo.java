package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface LoginSumInfo
  extends Bean
{
  public abstract LoginSumInfo copy();
  
  public abstract LoginSumInfo toData();
  
  public abstract LoginSumInfo toBean();
  
  public abstract LoginSumInfo toDataIf();
  
  public abstract LoginSumInfo toBeanIf();
  
  public abstract long getLast_time();
  
  public abstract int getLogin_days();
  
  public abstract Set<Integer> getSortids();
  
  public abstract Set<Integer> getSortidsAsData();
  
  public abstract void setLast_time(long paramLong);
  
  public abstract void setLogin_days(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LoginSumInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */