package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface RelatedBoss
  extends Bean
{
  public abstract RelatedBoss copy();
  
  public abstract RelatedBoss toData();
  
  public abstract RelatedBoss toBean();
  
  public abstract RelatedBoss toDataIf();
  
  public abstract RelatedBoss toBeanIf();
  
  public abstract Map<Integer, BossFights> getBoss_fights();
  
  public abstract Map<Integer, BossFights> getBoss_fightsAsData();
  
  public abstract Set<Integer> getRelated_monsters();
  
  public abstract Set<Integer> getRelated_monstersAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RelatedBoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */