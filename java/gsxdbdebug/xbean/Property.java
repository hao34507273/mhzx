package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface Property
  extends Bean
{
  public static final int FRIENDEFFECT = 0;
  public static final int ENEMYEFFECT = 1;
  
  public abstract Property copy();
  
  public abstract Property toData();
  
  public abstract Property toBean();
  
  public abstract Property toDataIf();
  
  public abstract Property toBeanIf();
  
  public abstract int getPartnercfgid();
  
  public abstract int getHp();
  
  public abstract int getMp();
  
  public abstract List<Integer> getSkills();
  
  public abstract List<Integer> getSkillsAsData();
  
  public abstract List<Integer> getLoves();
  
  public abstract List<Integer> getLovesAsData();
  
  public abstract List<Integer> getLovestoreplace();
  
  public abstract List<Integer> getLovestoreplaceAsData();
  
  public abstract int getFightvalue();
  
  public abstract Map<Integer, Integer> getOwnskills();
  
  public abstract Map<Integer, Integer> getOwnskillsAsData();
  
  public abstract int getYuanlv();
  
  public abstract List<Integer> getSubyuanlv();
  
  public abstract List<Integer> getSubyuanlvAsData();
  
  public abstract void setPartnercfgid(int paramInt);
  
  public abstract void setHp(int paramInt);
  
  public abstract void setMp(int paramInt);
  
  public abstract void setFightvalue(int paramInt);
  
  public abstract void setYuanlv(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */