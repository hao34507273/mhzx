package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface OcpBigBossRoleList
  extends Bean
{
  public abstract OcpBigBossRoleList copy();
  
  public abstract OcpBigBossRoleList toData();
  
  public abstract OcpBigBossRoleList toBean();
  
  public abstract OcpBigBossRoleList toDataIf();
  
  public abstract OcpBigBossRoleList toBeanIf();
  
  public abstract List<RoleBossBean> getRolelist();
  
  public abstract List<RoleBossBean> getRolelistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OcpBigBossRoleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */