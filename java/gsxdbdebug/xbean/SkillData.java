package xbean;

import xdb.Bean;

public abstract interface SkillData
  extends Bean
{
  public abstract SkillData copy();
  
  public abstract SkillData toData();
  
  public abstract SkillData toBean();
  
  public abstract SkillData toDataIf();
  
  public abstract SkillData toBeanIf();
  
  public abstract int getUseround();
  
  public abstract int getUsecount();
  
  public abstract void setUseround(int paramInt);
  
  public abstract void setUsecount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */