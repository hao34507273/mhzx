/*    */ package mzm.gsp.singlebattle.resourcepoint;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.singlebattle.SSynResourcePointInfo;
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ import xbean.ResourcePoint;
/*    */ import xbean.RoleResourcePointInfo;
/*    */ import xtable.Resource_points;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleid = ((Long)this.arg).longValue();
/* 20 */     long battleid = SingleBattleInterface.getBattleId(roleid, false);
/* 21 */     if (battleid < 0L)
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     ResourcePoint xResourcePoint = Resource_points.get(Long.valueOf(battleid));
/* 26 */     if (xResourcePoint == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     SSynResourcePointInfo sSynResourcePointInfo = new SSynResourcePointInfo();
/* 32 */     for (Map.Entry<Long, RoleResourcePointInfo> entry : xResourcePoint.getRole_resource_point_infos().entrySet())
/*    */     {
/* 34 */       sSynResourcePointInfo.resource_point_infos.put(entry.getKey(), Integer.valueOf(((RoleResourcePointInfo)entry.getValue()).getResource_point()));
/*    */     }
/* 36 */     OnlineManager.getInstance().send(roleid, sSynResourcePointInfo);
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\resourcepoint\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */