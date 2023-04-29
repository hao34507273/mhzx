package xbean;

import xdb.Bean;

public abstract interface PetFightFormationInfo
  extends Bean
{
  public abstract PetFightFormationInfo copy();
  
  public abstract PetFightFormationInfo toData();
  
  public abstract PetFightFormationInfo toBean();
  
  public abstract PetFightFormationInfo toDataIf();
  
  public abstract PetFightFormationInfo toBeanIf();
  
  public abstract int getLevel();
  
  public abstract int getExp();
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setExp(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetFightFormationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */