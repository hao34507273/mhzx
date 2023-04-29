package mzm.gsp.crossserver.main;

import com.goldhuman.Common.Marshal.OctetsStream;
import com.goldhuman.Common.Octets;

public abstract interface RoamRoleXtableDataHandler<K>
{
  public abstract void boxData(K paramK, OctetsStream paramOctetsStream)
    throws Exception;
  
  public abstract void unboxData(K paramK, Octets paramOctets)
    throws Exception;
  
  public abstract void cleanData(K paramK)
    throws Exception;
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamRoleXtableDataHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */