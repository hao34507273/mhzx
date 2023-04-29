package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MainSubSkill
  extends Bean
{
  public abstract MainSubSkill copy();
  
  public abstract MainSubSkill toData();
  
  public abstract MainSubSkill toBean();
  
  public abstract MainSubSkill toDataIf();
  
  public abstract MainSubSkill toBeanIf();
  
  public abstract int getMainskillid();
  
  public abstract Map<Integer, Integer> getSubindex2subskillid();
  
  public abstract Map<Integer, Integer> getSubindex2subskillidAsData();
  
  public abstract void setMainskillid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MainSubSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */