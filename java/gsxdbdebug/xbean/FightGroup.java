package xbean;

import java.util.Map;
import java.util.Set;
import mzm.gsp.fight.main.GroupAI;
import xdb.Bean;

public abstract interface FightGroup
  extends Bean
{
  public abstract FightGroup copy();
  
  public abstract FightGroup toData();
  
  public abstract FightGroup toBean();
  
  public abstract FightGroup toDataIf();
  
  public abstract FightGroup toBeanIf();
  
  public abstract int getType();
  
  public abstract Map<Integer, Fighter> getMembers();
  
  public abstract Map<Integer, Integer> getExtra();
  
  public abstract Map<Integer, Integer> getExtraAsData();
  
  public abstract Set<mzm.gsp.fight.main.Fighter> getLeavefighters();
  
  public abstract GroupAI getGroupai();
  
  public abstract void setType(int paramInt);
  
  public abstract void setGroupai(GroupAI paramGroupAI);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */