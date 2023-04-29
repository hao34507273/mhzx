package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MassExpInfo
  extends Bean
{
  public abstract MassExpInfo copy();
  
  public abstract MassExpInfo toData();
  
  public abstract MassExpInfo toBean();
  
  public abstract MassExpInfo toDataIf();
  
  public abstract MassExpInfo toBeanIf();
  
  public abstract int getStatus();
  
  public abstract int getCur_index();
  
  public abstract long getStart_time();
  
  public abstract Map<Integer, FillGridInfo> getCosts();
  
  public abstract Map<Integer, FillGridInfo> getCostsAsData();
  
  public abstract long getEnd_time();
  
  public abstract void setStatus(int paramInt);
  
  public abstract void setCur_index(int paramInt);
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setEnd_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */