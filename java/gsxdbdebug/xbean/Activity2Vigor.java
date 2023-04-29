package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Activity2Vigor
  extends Bean
{
  public abstract Activity2Vigor copy();
  
  public abstract Activity2Vigor toData();
  
  public abstract Activity2Vigor toBean();
  
  public abstract Activity2Vigor toDataIf();
  
  public abstract Activity2Vigor toBeanIf();
  
  public abstract Map<Integer, RoleVigorHistory> getAwardvigorhistorymap();
  
  public abstract Map<Integer, RoleVigorHistory> getAwardvigorhistorymapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Activity2Vigor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */