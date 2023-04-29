package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface PetFightTeamInfo
  extends Bean
{
  public abstract PetFightTeamInfo copy();
  
  public abstract PetFightTeamInfo toData();
  
  public abstract PetFightTeamInfo toBean();
  
  public abstract PetFightTeamInfo toDataIf();
  
  public abstract PetFightTeamInfo toBeanIf();
  
  public abstract int getFormation_id();
  
  public abstract Map<Integer, Long> getPosition2pet();
  
  public abstract Map<Integer, Long> getPosition2petAsData();
  
  public abstract void setFormation_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetFightTeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */