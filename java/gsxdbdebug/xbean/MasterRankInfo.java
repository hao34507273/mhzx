package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MasterRankInfo
  extends Bean
{
  public abstract MasterRankInfo copy();
  
  public abstract MasterRankInfo toData();
  
  public abstract MasterRankInfo toBean();
  
  public abstract MasterRankInfo toDataIf();
  
  public abstract MasterRankInfo toBeanIf();
  
  public abstract List<RoleMasterRankInfo> getRolemasterrankdatas();
  
  public abstract List<RoleMasterRankInfo> getRolemasterrankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MasterRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */