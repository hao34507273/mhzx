package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FriendTotalInfo
  extends Bean
{
  public abstract FriendTotalInfo copy();
  
  public abstract FriendTotalInfo toData();
  
  public abstract FriendTotalInfo toBean();
  
  public abstract FriendTotalInfo toDataIf();
  
  public abstract FriendTotalInfo toBeanIf();
  
  public abstract Map<Long, FriendInfo> getFriendinfomap();
  
  public abstract Map<Long, FriendInfo> getFriendinfomapAsData();
  
  public abstract long getCleardatatime();
  
  public abstract void setCleardatatime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FriendTotalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */