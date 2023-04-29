package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface IndianaAwardRoleInfo
  extends Bean
{
  public abstract IndianaAwardRoleInfo copy();
  
  public abstract IndianaAwardRoleInfo toData();
  
  public abstract IndianaAwardRoleInfo toBean();
  
  public abstract IndianaAwardRoleInfo toDataIf();
  
  public abstract IndianaAwardRoleInfo toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract String getRole_name();
  
  public abstract Octets getRole_nameOctets();
  
  public abstract int getAward_state();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setRole_name(String paramString);
  
  public abstract void setRole_nameOctets(Octets paramOctets);
  
  public abstract void setAward_state(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IndianaAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */