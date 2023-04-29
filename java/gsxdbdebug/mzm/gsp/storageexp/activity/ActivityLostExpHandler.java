package mzm.gsp.storageexp.activity;

public abstract interface ActivityLostExpHandler
{
  public abstract int getCanGetStorageExpValue(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int getAllStorageExpValue(long paramLong, int paramInt);
  
  public abstract String getActivityCHNName();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\ActivityLostExpHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */