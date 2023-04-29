package xbean;

import xdb.Bean;

public abstract interface PetArenaFightAward
  extends Bean
{
  public abstract PetArenaFightAward copy();
  
  public abstract PetArenaFightAward toData();
  
  public abstract PetArenaFightAward toBean();
  
  public abstract PetArenaFightAward toDataIf();
  
  public abstract PetArenaFightAward toBeanIf();
  
  public abstract int getAwardid();
  
  public abstract int getModify_cfgid();
  
  public abstract int getPoint();
  
  public abstract void setAwardid(int paramInt);
  
  public abstract void setModify_cfgid(int paramInt);
  
  public abstract void setPoint(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetArenaFightAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */