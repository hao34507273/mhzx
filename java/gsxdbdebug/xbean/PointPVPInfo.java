package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface PointPVPInfo
  extends Bean
{
  public abstract PointPVPInfo copy();
  
  public abstract PointPVPInfo toData();
  
  public abstract PointPVPInfo toBean();
  
  public abstract PointPVPInfo toDataIf();
  
  public abstract PointPVPInfo toBeanIf();
  
  public abstract int getActivity_cfgid();
  
  public abstract int getZone();
  
  public abstract int getTime_point_cfgid();
  
  public abstract long getStart_time();
  
  public abstract Set<Long> getFights();
  
  public abstract Set<Long> getFightsAsData();
  
  public abstract boolean getFinish();
  
  public abstract void setActivity_cfgid(int paramInt);
  
  public abstract void setZone(int paramInt);
  
  public abstract void setTime_point_cfgid(int paramInt);
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setFinish(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PointPVPInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */