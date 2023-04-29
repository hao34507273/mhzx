package xbean;

import xdb.Bean;

public abstract interface FighterModelCard
  extends Bean
{
  public abstract FighterModelCard copy();
  
  public abstract FighterModelCard toData();
  
  public abstract FighterModelCard toBean();
  
  public abstract FighterModelCard toDataIf();
  
  public abstract FighterModelCard toBeanIf();
  
  public abstract int getInitclassindex();
  
  public abstract int getInitlevel();
  
  public abstract int getTmpclassindex();
  
  public abstract int getTmplevel();
  
  public abstract void setInitclassindex(int paramInt);
  
  public abstract void setInitlevel(int paramInt);
  
  public abstract void setTmpclassindex(int paramInt);
  
  public abstract void setTmplevel(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FighterModelCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */