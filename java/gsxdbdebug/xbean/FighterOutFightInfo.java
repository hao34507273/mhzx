package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FighterOutFightInfo
  extends Bean
{
  public abstract FighterOutFightInfo copy();
  
  public abstract FighterOutFightInfo toData();
  
  public abstract FighterOutFightInfo toBean();
  
  public abstract FighterOutFightInfo toDataIf();
  
  public abstract FighterOutFightInfo toBeanIf();
  
  public abstract int getOcp();
  
  public abstract int getGender();
  
  public abstract Map<Integer, Integer> getSkills();
  
  public abstract Map<Integer, Integer> getSkillsAsData();
  
  public abstract void setOcp(int paramInt);
  
  public abstract void setGender(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FighterOutFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */