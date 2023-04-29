package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface DropInfo
  extends Bean
{
  public abstract DropInfo copy();
  
  public abstract DropInfo toData();
  
  public abstract DropInfo toBean();
  
  public abstract DropInfo toDataIf();
  
  public abstract DropInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getDropcounts();
  
  public abstract Map<Integer, Integer> getDropcountsAsData();
  
  public abstract long getStarttime();
  
  public abstract void setStarttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DropInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */