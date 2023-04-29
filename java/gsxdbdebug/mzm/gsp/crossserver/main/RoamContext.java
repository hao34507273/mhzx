package mzm.gsp.crossserver.main;

import com.goldhuman.Common.Octets;
import java.util.List;

public abstract interface RoamContext
{
  public abstract RoamType getRoamType();
  
  public abstract int getRoamZoneid();
  
  public abstract List<RoamRoleInfo> getRoamRoleInfos();
  
  public abstract boolean addToken(long paramLong, Octets paramOctets);
  
  public abstract boolean isGenTokenDone();
  
  public abstract long getRoamRoomInstanceid();
  
  public abstract boolean setRoamed(long paramLong);
  
  public abstract boolean isRoamDone();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */