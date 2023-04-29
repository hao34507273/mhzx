package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AllLottoInfo
  extends Bean
{
  public abstract AllLottoInfo copy();
  
  public abstract AllLottoInfo toData();
  
  public abstract AllLottoInfo toBean();
  
  public abstract AllLottoInfo toDataIf();
  
  public abstract AllLottoInfo toBeanIf();
  
  public abstract Map<Integer, AllLottoTurnInfo> getTurn_infos();
  
  public abstract Map<Integer, AllLottoTurnInfo> getTurn_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AllLottoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */