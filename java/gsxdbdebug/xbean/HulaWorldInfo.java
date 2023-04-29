package xbean;

import java.util.List;
import java.util.Set;
import xdb.Bean;

public abstract interface HulaWorldInfo
  extends Bean
{
  public abstract HulaWorldInfo copy();
  
  public abstract HulaWorldInfo toData();
  
  public abstract HulaWorldInfo toBean();
  
  public abstract HulaWorldInfo toDataIf();
  
  public abstract HulaWorldInfo toBeanIf();
  
  public abstract List<HulaMonsterInfo> getMonsters();
  
  public abstract List<HulaMonsterInfo> getMonstersAsData();
  
  public abstract Set<Long> getRoleids();
  
  public abstract Set<Long> getRoleidsAsData();
  
  public abstract int getMaxseq();
  
  public abstract void setMaxseq(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HulaWorldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */