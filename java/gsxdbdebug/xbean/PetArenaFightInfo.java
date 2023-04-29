package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface PetArenaFightInfo
  extends Bean
{
  public abstract PetArenaFightInfo copy();
  
  public abstract PetArenaFightInfo toData();
  
  public abstract PetArenaFightInfo toBean();
  
  public abstract PetArenaFightInfo toDataIf();
  
  public abstract PetArenaFightInfo toBeanIf();
  
  public abstract long getPetid();
  
  public abstract int getPosition();
  
  public abstract int getPet_cfgid();
  
  public abstract int getMonster_cfgid();
  
  public abstract int getDamage();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract void setPetid(long paramLong);
  
  public abstract void setPosition(int paramInt);
  
  public abstract void setPet_cfgid(int paramInt);
  
  public abstract void setMonster_cfgid(int paramInt);
  
  public abstract void setDamage(int paramInt);
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetArenaFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */