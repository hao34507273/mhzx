package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface VoipRoom
  extends Bean
{
  public static final int ROOM_STATE_CREATING = 1;
  public static final int ROOM_STATE_CREATED = 2;
  public static final int ROOM_STATE_PROTECT = 3;
  public static final int ROOM_STATE_CLOSING = 4;
  public static final int ROOM_STATE_CLOSED = 5;
  
  public abstract VoipRoom copy();
  
  public abstract VoipRoom toData();
  
  public abstract VoipRoom toBean();
  
  public abstract VoipRoom toDataIf();
  
  public abstract VoipRoom toBeanIf();
  
  public abstract int getRoom_state();
  
  public abstract long getRoom_id();
  
  public abstract Map<Long, VoipRoomUserAccess> getMembers();
  
  public abstract List<Long> getPending_list();
  
  public abstract List<Long> getPending_listAsData();
  
  public abstract long getCreater_id();
  
  public abstract long getClose_sessionid();
  
  public abstract int getTry_close_times();
  
  public abstract void setRoom_state(int paramInt);
  
  public abstract void setRoom_id(long paramLong);
  
  public abstract void setCreater_id(long paramLong);
  
  public abstract void setClose_sessionid(long paramLong);
  
  public abstract void setTry_close_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\VoipRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */