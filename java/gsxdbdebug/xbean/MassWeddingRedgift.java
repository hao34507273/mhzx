package xbean;

import xdb.Bean;

public abstract interface MassWeddingRedgift
  extends Bean
{
  public static final int NO = 0;
  public static final int YES = 1;
  
  public abstract MassWeddingRedgift copy();
  
  public abstract MassWeddingRedgift toData();
  
  public abstract MassWeddingRedgift toBean();
  
  public abstract MassWeddingRedgift toDataIf();
  
  public abstract MassWeddingRedgift toBeanIf();
  
  public abstract int getRedgiftcfgid();
  
  public abstract int getTaken();
  
  public abstract void setRedgiftcfgid(int paramInt);
  
  public abstract void setTaken(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassWeddingRedgift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */