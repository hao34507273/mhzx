/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.SMemberLogoffBro;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CorpsMember;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2corps;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogoff
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 26 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(roleId) }));
/*    */     
/* 28 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/* 29 */     CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(roleId));
/* 30 */     if (xCorpsMember == null)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     long corpsId = xCorpsMember.getCorpsid();
/* 36 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/* 37 */     if (xCorps == null)
/*    */     {
/* 39 */       GameServer.logger().error(String.format("[corps]POnRoleLogin.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(corpsId) }));
/*    */       
/*    */ 
/*    */ 
/* 43 */       return false;
/*    */     }
/* 45 */     CorpsManager.corpsBrocast(xCorps, true, new SMemberLogoffBro(roleId));
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */