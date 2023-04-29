package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RoundRobinRoundInfo
  extends Bean
{
  public abstract RoundRobinRoundInfo copy();
  
  public abstract RoundRobinRoundInfo toData();
  
  public abstract RoundRobinRoundInfo toBean();
  
  public abstract RoundRobinRoundInfo toDataIf();
  
  public abstract RoundRobinRoundInfo toBeanIf();
  
  public abstract int getStage();
  
  public abstract List<RoundRobinFightInfo> getFight_infos();
  
  public abstract List<RoundRobinFightInfo> getFight_infosAsData();
  
  public abstract void setStage(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoundRobinRoundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */