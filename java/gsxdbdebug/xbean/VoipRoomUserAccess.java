package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import xdb.Bean;

public abstract interface VoipRoomUserAccess
  extends Bean
{
  public static final int ROLE_STATE_JOINING = 1;
  public static final int ROLE_STATE_JOINED = 2;
  public static final int ROLE_STATE_ONLINE = 3;
  public static final int ROLE_STATE_PROTECT = 4;
  public static final int ROLE_STATE_EXITING = 5;
  public static final int ROLE_STATE_EXITED = 6;
  
  public abstract VoipRoomUserAccess copy();
  
  public abstract VoipRoomUserAccess toData();
  
  public abstract VoipRoomUserAccess toBean();
  
  public abstract VoipRoomUserAccess toDataIf();
  
  public abstract VoipRoomUserAccess toBeanIf();
  
  public abstract int getRole_state();
  
  public abstract Octets getOpen_id();
  
  public abstract int getMember_id();
  
  public abstract long getRoom_key();
  
  public abstract long getExtra_data();
  
  public abstract List<Octets> getAccess_ip_list();
  
  public abstract int getTry_exit_times();
  
  public abstract void setRole_state(int paramInt);
  
  public abstract void setOpen_id(Octets paramOctets);
  
  public abstract void setMember_id(int paramInt);
  
  public abstract void setRoom_key(long paramLong);
  
  public abstract void setExtra_data(long paramLong);
  
  public abstract void setTry_exit_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\VoipRoomUserAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */