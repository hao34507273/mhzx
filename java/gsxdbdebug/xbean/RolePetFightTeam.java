package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RolePetFightTeam
  extends Bean
{
  public abstract RolePetFightTeam copy();
  
  public abstract RolePetFightTeam toData();
  
  public abstract RolePetFightTeam toBean();
  
  public abstract RolePetFightTeam toDataIf();
  
  public abstract RolePetFightTeam toBeanIf();
  
  public abstract int getDefense_team();
  
  public abstract Map<Integer, PetFightTeamInfo> getTeam_info();
  
  public abstract Map<Integer, PetFightTeamInfo> getTeam_infoAsData();
  
  public abstract void setDefense_team(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolePetFightTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */