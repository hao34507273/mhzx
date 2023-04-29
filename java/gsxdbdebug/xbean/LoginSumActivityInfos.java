package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LoginSumActivityInfos
  extends Bean
{
  public abstract LoginSumActivityInfos copy();
  
  public abstract LoginSumActivityInfos toData();
  
  public abstract LoginSumActivityInfos toBean();
  
  public abstract LoginSumActivityInfos toDataIf();
  
  public abstract LoginSumActivityInfos toBeanIf();
  
  public abstract Map<Integer, LoginSumInfo> getLogin_sum_infos();
  
  public abstract Map<Integer, LoginSumInfo> getLogin_sum_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LoginSumActivityInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */