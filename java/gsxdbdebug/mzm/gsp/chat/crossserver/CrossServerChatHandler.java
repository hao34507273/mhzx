package mzm.gsp.chat.crossserver;

import java.util.List;
import java.util.Map;

public abstract interface CrossServerChatHandler
{
  public abstract boolean isForbiddenTalkInRoamServer(long paramLong);
  
  public abstract List<Long> getReceiveRoleListByRoleidInRoamServer(long paramLong);
  
  public abstract Map<CrossServerChatExtraInfoType, Integer> getExtraInfoInRoamServer(long paramLong);
  
  public abstract List<Integer> getDestServerZoneid(long paramLong);
  
  public abstract List<Long> getReceiveRoleByOrgKeyListInRoamServer(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\crossserver\CrossServerChatHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */