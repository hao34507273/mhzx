package xbean;

import xdb.Bean;

public abstract interface PetSkill
  extends Bean
{
  public static final int SKILL_FROM_SELF = 0;
  public static final int SKILL_FROM_BOOK = 1;
  
  public abstract PetSkill copy();
  
  public abstract PetSkill toData();
  
  public abstract PetSkill toBean();
  
  public abstract PetSkill toDataIf();
  
  public abstract PetSkill toBeanIf();
  
  public abstract int getSkillid();
  
  public abstract int getSkillfrom();
  
  public abstract void setSkillid(int paramInt);
  
  public abstract void setSkillfrom(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */