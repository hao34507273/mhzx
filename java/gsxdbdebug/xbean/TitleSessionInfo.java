package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface TitleSessionInfo
  extends Bean
{
  public abstract TitleSessionInfo copy();
  
  public abstract TitleSessionInfo toData();
  
  public abstract TitleSessionInfo toBean();
  
  public abstract TitleSessionInfo toDataIf();
  
  public abstract TitleSessionInfo toBeanIf();
  
  public abstract Map<Integer, Long> getAppsession();
  
  public abstract Map<Integer, Long> getAppsessionAsData();
  
  public abstract Map<Integer, Long> getTitlesession();
  
  public abstract Map<Integer, Long> getTitlesessionAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TitleSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */