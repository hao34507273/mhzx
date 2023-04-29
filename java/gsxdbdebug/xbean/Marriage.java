package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Marriage
  extends Bean
{
  public static final int KEY_FORCE_DIVORCE_TIME_SEC = 1;
  public static final int KEY_FORCE_DIVORCE_ROLE = 2;
  public static final int KEY_FORCE_DIVORCE_SILVER = 3;
  public static final int VALUE_FORCE_DIVORCE_ROLE_A = 1;
  public static final int VALUE_FORCE_DIVORCE_ROLE_B = 2;
  
  public abstract Marriage copy();
  
  public abstract Marriage toData();
  
  public abstract Marriage toBean();
  
  public abstract Marriage toDataIf();
  
  public abstract Marriage toBeanIf();
  
  public abstract long getRoleida();
  
  public abstract long getRoleidb();
  
  public abstract Map<Long, MarriageFriendInfo> getFriendainfos();
  
  public abstract Map<Long, MarriageFriendInfo> getFriendainfosAsData();
  
  public abstract Map<Long, MarriageFriendInfo> getFriendbinfos();
  
  public abstract Map<Long, MarriageFriendInfo> getFriendbinfosAsData();
  
  public abstract long getMarrytime();
  
  public abstract int getLevel();
  
  public abstract int getMarriagetitle();
  
  public abstract Map<Integer, Integer> getParammap();
  
  public abstract Map<Integer, Integer> getParammapAsData();
  
  public abstract int getPrepare_pregnant_score();
  
  public abstract long getChild_belong_role_id();
  
  public abstract int getGive_birth_score();
  
  public abstract long getGive_birth_score_enough_time();
  
  public abstract void setRoleida(long paramLong);
  
  public abstract void setRoleidb(long paramLong);
  
  public abstract void setMarrytime(long paramLong);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setMarriagetitle(int paramInt);
  
  public abstract void setPrepare_pregnant_score(int paramInt);
  
  public abstract void setChild_belong_role_id(long paramLong);
  
  public abstract void setGive_birth_score(int paramInt);
  
  public abstract void setGive_birth_score_enough_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Marriage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */