package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleAllLottoInfo
  extends Bean
{
  public abstract RoleAllLottoInfo copy();
  
  public abstract RoleAllLottoInfo toData();
  
  public abstract RoleAllLottoInfo toBean();
  
  public abstract RoleAllLottoInfo toDataIf();
  
  public abstract RoleAllLottoInfo toBeanIf();
  
  public abstract Map<Integer, RoleAllLottoActivityInfo> getActivity_infos();
  
  public abstract Map<Integer, RoleAllLottoActivityInfo> getActivity_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleAllLottoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */