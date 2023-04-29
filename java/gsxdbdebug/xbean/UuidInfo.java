package xbean;

import xdb.Bean;

public abstract interface UuidInfo
  extends Bean
{
  public static final int TYPE_PET = 0;
  public static final int TYPE_ITEM = 1;
  public static final int TYPE_BAITAN_ITEM = 2;
  public static final int TLOG_SEQUENCE = 3;
  public static final int TYPE_MOUNTS = 4;
  public static final int TYPE_HOME_MAID = 5;
  public static final int TYPE_CHATGIFT = 6;
  
  public abstract UuidInfo copy();
  
  public abstract UuidInfo toData();
  
  public abstract UuidInfo toBean();
  
  public abstract UuidInfo toDataIf();
  
  public abstract UuidInfo toBeanIf();
  
  public abstract int getId_type();
  
  public abstract long getTimestamp();
  
  public abstract void setId_type(int paramInt);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\UuidInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */