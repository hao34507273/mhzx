package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MassExpActivity
  extends Bean
{
  public abstract MassExpActivity copy();
  
  public abstract MassExpActivity toData();
  
  public abstract MassExpActivity toBean();
  
  public abstract MassExpActivity toDataIf();
  
  public abstract MassExpActivity toBeanIf();
  
  public abstract Map<Integer, MassExpInfo> getMass_exp_infos();
  
  public abstract Map<Integer, MassExpInfo> getMass_exp_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassExpActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */