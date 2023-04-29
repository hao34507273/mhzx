package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface WingContent
  extends Bean
{
  public abstract WingContent copy();
  
  public abstract WingContent toData();
  
  public abstract WingContent toBean();
  
  public abstract WingContent toDataIf();
  
  public abstract WingContent toBeanIf();
  
  public abstract int getCfgid();
  
  public abstract int getColorid();
  
  public abstract List<Integer> getReproids();
  
  public abstract List<Integer> getReproidsAsData();
  
  public abstract List<Integer> getReskillids();
  
  public abstract List<Integer> getReskillidsAsData();
  
  public abstract List<Integer> getProids();
  
  public abstract List<Integer> getProidsAsData();
  
  public abstract List<Integer> getSkills();
  
  public abstract List<Integer> getSkillsAsData();
  
  public abstract Map<Integer, Integer> getTarget_skills();
  
  public abstract Map<Integer, Integer> getTarget_skillsAsData();
  
  public abstract int getGuarantee_times();
  
  public abstract void setCfgid(int paramInt);
  
  public abstract void setColorid(int paramInt);
  
  public abstract void setGuarantee_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WingContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */