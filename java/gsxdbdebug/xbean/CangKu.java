package xbean;

import xdb.Bean;

public abstract interface CangKu
  extends Bean
{
  public abstract CangKu copy();
  
  public abstract CangKu toData();
  
  public abstract CangKu toBean();
  
  public abstract CangKu toDataIf();
  
  public abstract CangKu toBeanIf();
  
  public abstract int getLevel();
  
  public abstract long getLevelupendtime();
  
  public abstract int getFulinumtotal();
  
  public abstract int getAvaliablefulinum();
  
  public abstract long getLastupdatefulitime();
  
  public abstract int getLihenum();
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setLevelupendtime(long paramLong);
  
  public abstract void setFulinumtotal(int paramInt);
  
  public abstract void setAvaliablefulinum(int paramInt);
  
  public abstract void setLastupdatefulitime(long paramLong);
  
  public abstract void setLihenum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CangKu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */