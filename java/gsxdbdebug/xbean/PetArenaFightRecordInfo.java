package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import xdb.Bean;

public abstract interface PetArenaFightRecordInfo
  extends Bean
{
  public static final int ATTACK = 0;
  public static final int DEFEND = 1;
  
  public abstract PetArenaFightRecordInfo copy();
  
  public abstract PetArenaFightRecordInfo toData();
  
  public abstract PetArenaFightRecordInfo toBean();
  
  public abstract PetArenaFightRecordInfo toDataIf();
  
  public abstract PetArenaFightRecordInfo toBeanIf();
  
  public abstract long getRecordid();
  
  public abstract int getRecord_type();
  
  public abstract int getIs_win();
  
  public abstract int getOld_rank();
  
  public abstract int getNew_rank();
  
  public abstract long getRoleid();
  
  public abstract int getAvatar();
  
  public abstract int getAvatar_frame();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract int getOccupation();
  
  public abstract int getGender();
  
  public abstract long getTime();
  
  public abstract List<PetArenaFightInfo> getActivie_pet_infos();
  
  public abstract List<PetArenaFightInfo> getActivie_pet_infosAsData();
  
  public abstract List<PetArenaFightInfo> getPassive_pet_infos();
  
  public abstract List<PetArenaFightInfo> getPassive_pet_infosAsData();
  
  public abstract void setRecordid(long paramLong);
  
  public abstract void setRecord_type(int paramInt);
  
  public abstract void setIs_win(int paramInt);
  
  public abstract void setOld_rank(int paramInt);
  
  public abstract void setNew_rank(int paramInt);
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setAvatar(int paramInt);
  
  public abstract void setAvatar_frame(int paramInt);
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
  
  public abstract void setOccupation(int paramInt);
  
  public abstract void setGender(int paramInt);
  
  public abstract void setTime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetArenaFightRecordInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */