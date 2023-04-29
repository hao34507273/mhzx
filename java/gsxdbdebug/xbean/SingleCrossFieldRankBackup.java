package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SingleCrossFieldRankBackup
  extends Bean
{
  public abstract SingleCrossFieldRankBackup copy();
  
  public abstract SingleCrossFieldRankBackup toData();
  
  public abstract SingleCrossFieldRankBackup toBean();
  
  public abstract SingleCrossFieldRankBackup toDataIf();
  
  public abstract SingleCrossFieldRankBackup toBeanIf();
  
  public abstract Map<Integer, SingleCrossFieldSeasonRankBackup> getBackups();
  
  public abstract Map<Integer, SingleCrossFieldSeasonRankBackup> getBackupsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleCrossFieldRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */