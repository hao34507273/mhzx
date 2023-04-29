package xbean;

import xdb.Bean;

public abstract interface MarriageFriendInfo
  extends Bean
{
  public abstract MarriageFriendInfo copy();
  
  public abstract MarriageFriendInfo toData();
  
  public abstract MarriageFriendInfo toBean();
  
  public abstract MarriageFriendInfo toDataIf();
  
  public abstract MarriageFriendInfo toBeanIf();
  
  public abstract int getGiftid();
  
  public abstract boolean getIsnotified();
  
  public abstract void setGiftid(int paramInt);
  
  public abstract void setIsnotified(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarriageFriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */