package xbean;

import xdb.Bean;

public abstract interface IdCounter
  extends Bean
{
  public abstract IdCounter copy();
  
  public abstract IdCounter toData();
  
  public abstract IdCounter toBean();
  
  public abstract IdCounter toDataIf();
  
  public abstract IdCounter toBeanIf();
  
  public abstract int getDropcount();
  
  public abstract int getUnhitcount();
  
  public abstract int getHistorydropcount();
  
  public abstract long getModifytime();
  
  public abstract void setDropcount(int paramInt);
  
  public abstract void setUnhitcount(int paramInt);
  
  public abstract void setHistorydropcount(int paramInt);
  
  public abstract void setModifytime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IdCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */