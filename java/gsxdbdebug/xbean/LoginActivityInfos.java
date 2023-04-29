package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LoginActivityInfos
  extends Bean
{
  public abstract LoginActivityInfos copy();
  
  public abstract LoginActivityInfos toData();
  
  public abstract LoginActivityInfos toBean();
  
  public abstract LoginActivityInfos toDataIf();
  
  public abstract LoginActivityInfos toBeanIf();
  
  public abstract Map<Integer, LoginInfo> getLogin_infos();
  
  public abstract Map<Integer, LoginInfo> getLogin_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LoginActivityInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */