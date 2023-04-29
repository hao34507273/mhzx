package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface MateInfo
  extends Bean
{
  public abstract MateInfo copy();
  
  public abstract MateInfo toData();
  
  public abstract MateInfo toBean();
  
  public abstract MateInfo toDataIf();
  
  public abstract MateInfo toBeanIf();
  
  public abstract String getRole_name();
  
  public abstract Octets getRole_nameOctets();
  
  public abstract int getAnimal_cfgid();
  
  public abstract long getMate_time();
  
  public abstract void setRole_name(String paramString);
  
  public abstract void setRole_nameOctets(Octets paramOctets);
  
  public abstract void setAnimal_cfgid(int paramInt);
  
  public abstract void setMate_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */