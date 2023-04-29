package xbean;

import xdb.Bean;

public abstract interface InvitedRole
  extends Bean
{
  public abstract InvitedRole copy();
  
  public abstract InvitedRole toData();
  
  public abstract InvitedRole toBean();
  
  public abstract InvitedRole toDataIf();
  
  public abstract InvitedRole toBeanIf();
  
  public abstract boolean getNotified();
  
  public abstract boolean getSendgift();
  
  public abstract boolean getSendgiftnotified();
  
  public abstract int getGiftcfgid();
  
  public abstract long getSendgifttimemil();
  
  public abstract void setNotified(boolean paramBoolean);
  
  public abstract void setSendgift(boolean paramBoolean);
  
  public abstract void setSendgiftnotified(boolean paramBoolean);
  
  public abstract void setGiftcfgid(int paramInt);
  
  public abstract void setSendgifttimemil(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\InvitedRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */