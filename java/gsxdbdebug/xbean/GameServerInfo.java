package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface GameServerInfo
  extends Bean
{
  public abstract GameServerInfo copy();
  
  public abstract GameServerInfo toData();
  
  public abstract GameServerInfo toBean();
  
  public abstract GameServerInfo toDataIf();
  
  public abstract GameServerInfo toBeanIf();
  
  public abstract List<String> getZoneids();
  
  public abstract List<String> getZoneidsAsData();
  
  public abstract int getDb_version();
  
  public abstract long getTime_offset();
  
  public abstract String getGsxdb_jar_md5();
  
  public abstract Octets getGsxdb_jar_md5Octets();
  
  public abstract DisableProtocolInfo getDisable_protocol_info();
  
  public abstract Map<Integer, ModuleFunSwitches> getModule_fun_switches();
  
  public abstract Map<Integer, ModuleFunSwitches> getModule_fun_switchesAsData();
  
  public abstract long getOpen_server_timestamp();
  
  public abstract int getCreate_role_num();
  
  public abstract void setDb_version(int paramInt);
  
  public abstract void setTime_offset(long paramLong);
  
  public abstract void setGsxdb_jar_md5(String paramString);
  
  public abstract void setGsxdb_jar_md5Octets(Octets paramOctets);
  
  public abstract void setOpen_server_timestamp(long paramLong);
  
  public abstract void setCreate_role_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GameServerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */