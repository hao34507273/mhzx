package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AllBanGraphBean
  extends Bean
{
  public abstract AllBanGraphBean copy();
  
  public abstract AllBanGraphBean toData();
  
  public abstract AllBanGraphBean toBean();
  
  public abstract AllBanGraphBean toDataIf();
  
  public abstract AllBanGraphBean toBeanIf();
  
  public abstract Map<Integer, BanGraphBean> getBangraphs();
  
  public abstract Map<Integer, BanGraphBean> getBangraphsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AllBanGraphBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */