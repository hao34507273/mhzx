package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface UserQQVipInfo
  extends Bean
{
  public abstract UserQQVipInfo copy();
  
  public abstract UserQQVipInfo toData();
  
  public abstract UserQQVipInfo toBean();
  
  public abstract UserQQVipInfo toDataIf();
  
  public abstract UserQQVipInfo toBeanIf();
  
  public abstract Map<Integer, QQVipInfo> getVipinfos();
  
  public abstract Map<Integer, QQVipInfo> getVipinfosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\UserQQVipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */