package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface InteractionInvitationBanRecords
  extends Bean
{
  public abstract InteractionInvitationBanRecords copy();
  
  public abstract InteractionInvitationBanRecords toData();
  
  public abstract InteractionInvitationBanRecords toBean();
  
  public abstract InteractionInvitationBanRecords toDataIf();
  
  public abstract InteractionInvitationBanRecords toBeanIf();
  
  public abstract Map<Long, InteractionInvitationBanRecord> getRecords();
  
  public abstract Map<Long, InteractionInvitationBanRecord> getRecordsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\InteractionInvitationBanRecords.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */