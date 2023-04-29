package xbean;

import xdb.Bean;

public abstract interface InteractionInvitationBanRecord
  extends Bean
{
  public abstract InteractionInvitationBanRecord copy();
  
  public abstract InteractionInvitationBanRecord toData();
  
  public abstract InteractionInvitationBanRecord toBean();
  
  public abstract InteractionInvitationBanRecord toDataIf();
  
  public abstract InteractionInvitationBanRecord toBeanIf();
  
  public abstract int getReset_time();
  
  public abstract int getFail_count();
  
  public abstract int getBan_time();
  
  public abstract void setReset_time(int paramInt);
  
  public abstract void setFail_count(int paramInt);
  
  public abstract void setBan_time(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\InteractionInvitationBanRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */