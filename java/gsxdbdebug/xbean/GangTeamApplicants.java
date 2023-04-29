package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface GangTeamApplicants
  extends Bean
{
  public abstract GangTeamApplicants copy();
  
  public abstract GangTeamApplicants toData();
  
  public abstract GangTeamApplicants toBean();
  
  public abstract GangTeamApplicants toDataIf();
  
  public abstract GangTeamApplicants toBeanIf();
  
  public abstract List<Long> getApplicants();
  
  public abstract List<Long> getApplicantsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangTeamApplicants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */