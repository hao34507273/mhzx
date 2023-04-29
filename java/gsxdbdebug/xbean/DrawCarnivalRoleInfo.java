package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface DrawCarnivalRoleInfo
  extends Bean
{
  public abstract DrawCarnivalRoleInfo copy();
  
  public abstract DrawCarnivalRoleInfo toData();
  
  public abstract DrawCarnivalRoleInfo toBean();
  
  public abstract DrawCarnivalRoleInfo toDataIf();
  
  public abstract DrawCarnivalRoleInfo toBeanIf();
  
  public abstract Map<Integer, DrawCarnivalRoleActivityInfo> getActivity_id2role_info();
  
  public abstract Map<Integer, DrawCarnivalRoleActivityInfo> getActivity_id2role_infoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DrawCarnivalRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */