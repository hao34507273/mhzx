package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface RoleTreasureHuntActivityInfo
  extends Bean
{
  public abstract RoleTreasureHuntActivityInfo copy();
  
  public abstract RoleTreasureHuntActivityInfo toData();
  
  public abstract RoleTreasureHuntActivityInfo toBean();
  
  public abstract RoleTreasureHuntActivityInfo toDataIf();
  
  public abstract RoleTreasureHuntActivityInfo toBeanIf();
  
  public abstract Set<Integer> getAwarded_chapter_id_set();
  
  public abstract Set<Integer> getAwarded_chapter_id_setAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleTreasureHuntActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */