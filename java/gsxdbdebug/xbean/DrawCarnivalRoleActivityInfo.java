package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface DrawCarnivalRoleActivityInfo
  extends Bean
{
  public abstract DrawCarnivalRoleActivityInfo copy();
  
  public abstract DrawCarnivalRoleActivityInfo toData();
  
  public abstract DrawCarnivalRoleActivityInfo toBean();
  
  public abstract DrawCarnivalRoleActivityInfo toDataIf();
  
  public abstract DrawCarnivalRoleActivityInfo toBeanIf();
  
  public abstract long getInit_point_count();
  
  public abstract Map<Integer, DrawCarnivalRoleFreePassInfo> getFree_pass_type_id2info();
  
  public abstract Map<Integer, DrawCarnivalRoleFreePassInfo> getFree_pass_type_id2infoAsData();
  
  public abstract int getGet_next_big_award_draw_count();
  
  public abstract void setInit_point_count(long paramLong);
  
  public abstract void setGet_next_big_award_draw_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DrawCarnivalRoleActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */