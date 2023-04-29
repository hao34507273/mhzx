package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface GangMemoryBean
  extends Bean
{
  public abstract GangMemoryBean copy();
  
  public abstract GangMemoryBean toData();
  
  public abstract GangMemoryBean toBean();
  
  public abstract GangMemoryBean toDataIf();
  
  public abstract GangMemoryBean toBeanIf();
  
  public abstract List<GangApply> getApplylist();
  
  public abstract List<GangApply> getApplylistAsData();
  
  public abstract long getGangworldid();
  
  public abstract Map<Long, GangTeamApplicants> getTeamapplicants();
  
  public abstract Map<Long, GangTeamApplicants> getTeamapplicantsAsData();
  
  public abstract void setGangworldid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangMemoryBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */