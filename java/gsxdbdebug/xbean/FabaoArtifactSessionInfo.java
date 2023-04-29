package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FabaoArtifactSessionInfo
  extends Bean
{
  public abstract FabaoArtifactSessionInfo copy();
  
  public abstract FabaoArtifactSessionInfo toData();
  
  public abstract FabaoArtifactSessionInfo toBean();
  
  public abstract FabaoArtifactSessionInfo toDataIf();
  
  public abstract FabaoArtifactSessionInfo toBeanIf();
  
  public abstract Map<Integer, Long> getSessions();
  
  public abstract Map<Integer, Long> getSessionsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FabaoArtifactSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */