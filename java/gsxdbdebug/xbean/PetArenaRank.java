package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface PetArenaRank
  extends Bean
{
  public abstract PetArenaRank copy();
  
  public abstract PetArenaRank toData();
  
  public abstract PetArenaRank toBean();
  
  public abstract PetArenaRank toDataIf();
  
  public abstract PetArenaRank toBeanIf();
  
  public abstract List<PetArenaRankInfo> getRanks();
  
  public abstract List<PetArenaRankInfo> getRanksAsData();
  
  public abstract Map<Long, Integer> getRoles();
  
  public abstract Map<Long, Integer> getRolesAsData();
  
  public abstract Set<Long> getMerged_roles();
  
  public abstract Set<Long> getMerged_rolesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetArenaRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */