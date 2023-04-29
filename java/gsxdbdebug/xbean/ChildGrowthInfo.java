package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ChildGrowthInfo
  extends Bean
{
  public abstract ChildGrowthInfo copy();
  
  public abstract ChildGrowthInfo toData();
  
  public abstract ChildGrowthInfo toBean();
  
  public abstract ChildGrowthInfo toDataIf();
  
  public abstract ChildGrowthInfo toBeanIf();
  
  public abstract int getGrow_type();
  
  public abstract long getGrow_time();
  
  public abstract Map<Integer, Integer> getInt_parameter_map();
  
  public abstract Map<Integer, Integer> getInt_parameter_mapAsData();
  
  public abstract Map<Integer, String> getString_parameter_map();
  
  public abstract Map<Integer, String> getString_parameter_mapAsData();
  
  public abstract void setGrow_type(int paramInt);
  
  public abstract void setGrow_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChildGrowthInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */