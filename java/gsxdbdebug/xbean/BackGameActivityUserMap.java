package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BackGameActivityUserMap
  extends Bean
{
  public abstract BackGameActivityUserMap copy();
  
  public abstract BackGameActivityUserMap toData();
  
  public abstract BackGameActivityUserMap toBean();
  
  public abstract BackGameActivityUserMap toDataIf();
  
  public abstract BackGameActivityUserMap toBeanIf();
  
  public abstract Map<Integer, BackGameActivityUserInfo> getActivityid2userinfo();
  
  public abstract Map<Integer, BackGameActivityUserInfo> getActivityid2userinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BackGameActivityUserMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */