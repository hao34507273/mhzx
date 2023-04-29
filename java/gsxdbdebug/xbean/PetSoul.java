package xbean;

import xdb.Bean;

public abstract interface PetSoul
  extends Bean
{
  public static final int POS_JING = 0;
  public static final int POS_QI = 1;
  public static final int POS_SHEN = 2;
  
  public abstract PetSoul copy();
  
  public abstract PetSoul toData();
  
  public abstract PetSoul toBean();
  
  public abstract PetSoul toDataIf();
  
  public abstract PetSoul toBeanIf();
  
  public abstract int getPos();
  
  public abstract int getLevel();
  
  public abstract int getExp();
  
  public abstract int getPropindex();
  
  public abstract void setPos(int paramInt);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setExp(int paramInt);
  
  public abstract void setPropindex(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetSoul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */