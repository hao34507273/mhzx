package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface WingInfo
  extends Bean
{
  public abstract WingInfo copy();
  
  public abstract WingInfo toData();
  
  public abstract WingInfo toBean();
  
  public abstract WingInfo toDataIf();
  
  public abstract WingInfo toBeanIf();
  
  public abstract int getExp();
  
  public abstract int getLevel();
  
  public abstract int getPhase();
  
  public abstract List<WingProperty> getPropertylist();
  
  public abstract List<WingProperty> getPropertylistAsData();
  
  public abstract List<WingSkill> getSkilllist();
  
  public abstract List<WingSkill> getSkilllistAsData();
  
  public abstract int getCurmodelid();
  
  public abstract void setExp(int paramInt);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setPhase(int paramInt);
  
  public abstract void setCurmodelid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */