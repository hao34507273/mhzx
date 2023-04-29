package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface FightCorpsInfo
  extends Bean
{
  public abstract FightCorpsInfo copy();
  
  public abstract FightCorpsInfo toData();
  
  public abstract FightCorpsInfo toBean();
  
  public abstract FightCorpsInfo toDataIf();
  
  public abstract FightCorpsInfo toBeanIf();
  
  public abstract long getCorps_id();
  
  public abstract int getCorps_zone_id();
  
  public abstract String getCorps_name();
  
  public abstract Octets getCorps_nameOctets();
  
  public abstract int getCorps_badge_id();
  
  public abstract void setCorps_id(long paramLong);
  
  public abstract void setCorps_zone_id(int paramInt);
  
  public abstract void setCorps_name(String paramString);
  
  public abstract void setCorps_nameOctets(Octets paramOctets);
  
  public abstract void setCorps_badge_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */