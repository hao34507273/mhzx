package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface RoleMergeCompensationInfo
  extends Bean
{
  public abstract RoleMergeCompensationInfo copy();
  
  public abstract RoleMergeCompensationInfo toData();
  
  public abstract RoleMergeCompensationInfo toBean();
  
  public abstract RoleMergeCompensationInfo toDataIf();
  
  public abstract RoleMergeCompensationInfo toBeanIf();
  
  public abstract Set<Long> getHave_got_compensation_merge_system_timestamps();
  
  public abstract Set<Long> getHave_got_compensation_merge_system_timestampsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleMergeCompensationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */