package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface AdulthoodInfo
  extends Bean
{
  public abstract AdulthoodInfo copy();
  
  public abstract AdulthoodInfo toData();
  
  public abstract AdulthoodInfo toBean();
  
  public abstract AdulthoodInfo toDataIf();
  
  public abstract AdulthoodInfo toBeanIf();
  
  public abstract int getOccupation();
  
  public abstract Map<Integer, Integer> getAptitudeinitmap();
  
  public abstract Map<Integer, Integer> getAptitudeinitmapAsData();
  
  public abstract Map<Integer, Integer> getAptitudechangemap();
  
  public abstract Map<Integer, Integer> getAptitudechangemapAsData();
  
  public abstract int getUseaptitudeitemcount();
  
  public abstract int getUsegrowthitemcount();
  
  public abstract Map<Integer, Integer> getOccupationskill2value();
  
  public abstract Map<Integer, Integer> getOccupationskill2valueAsData();
  
  public abstract List<Integer> getFightskills();
  
  public abstract List<Integer> getFightskillsAsData();
  
  public abstract List<Integer> getSkillbookskills();
  
  public abstract List<Integer> getSkillbookskillsAsData();
  
  public abstract int getSpecialskillid();
  
  public abstract Map<Integer, Integer> getBasepropset();
  
  public abstract Map<Integer, Integer> getBasepropsetAsData();
  
  public abstract Map<Integer, Integer> getBasepropmap();
  
  public abstract Map<Integer, Integer> getBasepropmapAsData();
  
  public abstract int getPotentialpoint();
  
  public abstract int getHp();
  
  public abstract int getMp();
  
  public abstract float getGrow();
  
  public abstract int getUnlockskillposnum();
  
  public abstract int getModelcfgid();
  
  public abstract int getCharacter();
  
  public abstract Map<Integer, Item> getEquipitem();
  
  public abstract Map<Integer, Item> getEquipitemAsData();
  
  public abstract Map<Integer, Item> getEquippetitem();
  
  public abstract Map<Integer, Item> getEquippetitemAsData();
  
  public abstract void setOccupation(int paramInt);
  
  public abstract void setUseaptitudeitemcount(int paramInt);
  
  public abstract void setUsegrowthitemcount(int paramInt);
  
  public abstract void setSpecialskillid(int paramInt);
  
  public abstract void setPotentialpoint(int paramInt);
  
  public abstract void setHp(int paramInt);
  
  public abstract void setMp(int paramInt);
  
  public abstract void setGrow(float paramFloat);
  
  public abstract void setUnlockskillposnum(int paramInt);
  
  public abstract void setModelcfgid(int paramInt);
  
  public abstract void setCharacter(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AdulthoodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */