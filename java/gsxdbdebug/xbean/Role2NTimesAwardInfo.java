package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Role2NTimesAwardInfo
  extends Bean
{
  public abstract Role2NTimesAwardInfo copy();
  
  public abstract Role2NTimesAwardInfo toData();
  
  public abstract Role2NTimesAwardInfo toBean();
  
  public abstract Role2NTimesAwardInfo toDataIf();
  
  public abstract Role2NTimesAwardInfo toBeanIf();
  
  public abstract Map<Integer, IdipNTimesAwardInfo> getN_times_award_role_map();
  
  public abstract Map<Integer, IdipNTimesAwardInfo> getN_times_award_role_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2NTimesAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */