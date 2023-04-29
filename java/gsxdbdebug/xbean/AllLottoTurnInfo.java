package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface AllLottoTurnInfo
  extends Bean
{
  public abstract AllLottoTurnInfo copy();
  
  public abstract AllLottoTurnInfo toData();
  
  public abstract AllLottoTurnInfo toBean();
  
  public abstract AllLottoTurnInfo toDataIf();
  
  public abstract AllLottoTurnInfo toBeanIf();
  
  public abstract List<AllLottoAwardRoleInfo> getAward_role_infos();
  
  public abstract List<AllLottoAwardRoleInfo> getAward_role_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AllLottoTurnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */