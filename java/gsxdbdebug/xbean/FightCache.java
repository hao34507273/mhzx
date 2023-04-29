package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FightCache
  extends Bean
{
  public abstract FightCache copy();
  
  public abstract FightCache toData();
  
  public abstract FightCache toBean();
  
  public abstract FightCache toDataIf();
  
  public abstract FightCache toBeanIf();
  
  public abstract int getRole_default_skill();
  
  public abstract Map<Long, Integer> getPet_default_skills();
  
  public abstract Map<Long, Integer> getPet_default_skillsAsData();
  
  public abstract Map<Long, Integer> getChild_default_skills();
  
  public abstract Map<Long, Integer> getChild_default_skillsAsData();
  
  public abstract boolean getIsauto();
  
  public abstract void setRole_default_skill(int paramInt);
  
  public abstract void setIsauto(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */