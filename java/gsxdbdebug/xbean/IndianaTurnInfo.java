package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface IndianaTurnInfo
  extends Bean
{
  public abstract IndianaTurnInfo copy();
  
  public abstract IndianaTurnInfo toData();
  
  public abstract IndianaTurnInfo toBean();
  
  public abstract IndianaTurnInfo toDataIf();
  
  public abstract IndianaTurnInfo toBeanIf();
  
  public abstract Map<Integer, IndianaAwardInfo> getAward_infos();
  
  public abstract Map<Integer, IndianaAwardInfo> getAward_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IndianaTurnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */