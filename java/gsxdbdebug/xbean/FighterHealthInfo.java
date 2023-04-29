package xbean;

import xdb.Bean;

public abstract interface FighterHealthInfo
  extends Bean
{
  public abstract FighterHealthInfo copy();
  
  public abstract FighterHealthInfo toData();
  
  public abstract FighterHealthInfo toBean();
  
  public abstract FighterHealthInfo toDataIf();
  
  public abstract FighterHealthInfo toBeanIf();
  
  public abstract int getHp();
  
  public abstract int getMp();
  
  public abstract float getAnger();
  
  public abstract void setHp(int paramInt);
  
  public abstract void setMp(int paramInt);
  
  public abstract void setAnger(float paramFloat);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FighterHealthInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */