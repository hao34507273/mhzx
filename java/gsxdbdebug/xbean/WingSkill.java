package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface WingSkill
  extends Bean
{
  public abstract WingSkill copy();
  
  public abstract WingSkill toData();
  
  public abstract WingSkill toBean();
  
  public abstract WingSkill toDataIf();
  
  public abstract WingSkill toBeanIf();
  
  public abstract int getMainskillid();
  
  public abstract List<Integer> getSubskillids();
  
  public abstract List<Integer> getSubskillidsAsData();
  
  public abstract void setMainskillid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WingSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */