package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LoginSignActivityInfos
  extends Bean
{
  public abstract LoginSignActivityInfos copy();
  
  public abstract LoginSignActivityInfos toData();
  
  public abstract LoginSignActivityInfos toBean();
  
  public abstract LoginSignActivityInfos toDataIf();
  
  public abstract LoginSignActivityInfos toBeanIf();
  
  public abstract Map<Integer, LoginSignInfo> getLogin_sign_infos();
  
  public abstract Map<Integer, LoginSignInfo> getLogin_sign_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LoginSignActivityInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */