package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface AllLottoAwardRoleInfo
  extends Bean
{
  public abstract AllLottoAwardRoleInfo copy();
  
  public abstract AllLottoAwardRoleInfo toData();
  
  public abstract AllLottoAwardRoleInfo toBean();
  
  public abstract AllLottoAwardRoleInfo toDataIf();
  
  public abstract AllLottoAwardRoleInfo toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract String getRole_name();
  
  public abstract Octets getRole_nameOctets();
  
  public abstract int getOccupation();
  
  public abstract int getGender();
  
  public abstract int getLevel();
  
  public abstract int getAvatarid();
  
  public abstract int getAvatar_frameid();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setRole_name(String paramString);
  
  public abstract void setRole_nameOctets(Octets paramOctets);
  
  public abstract void setOccupation(int paramInt);
  
  public abstract void setGender(int paramInt);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setAvatarid(int paramInt);
  
  public abstract void setAvatar_frameid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AllLottoAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */