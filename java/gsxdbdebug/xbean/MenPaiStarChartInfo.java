package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface MenPaiStarChartInfo
  extends Bean
{
  public abstract MenPaiStarChartInfo copy();
  
  public abstract MenPaiStarChartInfo toData();
  
  public abstract MenPaiStarChartInfo toBean();
  
  public abstract MenPaiStarChartInfo toDataIf();
  
  public abstract MenPaiStarChartInfo toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract String getRole_name();
  
  public abstract Octets getRole_nameOctets();
  
  public abstract int getPoint();
  
  public abstract int getOccupationid();
  
  public abstract long getUpdate_point_time();
  
  public abstract int getStatus();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setRole_name(String paramString);
  
  public abstract void setRole_nameOctets(Octets paramOctets);
  
  public abstract void setPoint(int paramInt);
  
  public abstract void setOccupationid(int paramInt);
  
  public abstract void setUpdate_point_time(long paramLong);
  
  public abstract void setStatus(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MenPaiStarChartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */