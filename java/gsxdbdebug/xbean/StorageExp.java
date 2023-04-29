package xbean;

import xdb.Bean;

public abstract interface StorageExp
  extends Bean
{
  public abstract StorageExp copy();
  
  public abstract StorageExp toData();
  
  public abstract StorageExp toBean();
  
  public abstract StorageExp toDataIf();
  
  public abstract StorageExp toBeanIf();
  
  public abstract long getStorageexp();
  
  public abstract long getNeedupdatestorageexp();
  
  public abstract long getLastupdate();
  
  public abstract void setStorageexp(long paramLong);
  
  public abstract void setNeedupdatestorageexp(long paramLong);
  
  public abstract void setLastupdate(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\StorageExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */