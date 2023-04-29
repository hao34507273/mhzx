/*    */ package mzm.gsp.children.fashion;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.homeland.main.HomelandInterface;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleId = ((Long)this.arg).longValue();
/* 18 */     String userId = RoleInterface.getUserId(roleId);
/*    */     
/* 20 */     long marriedRoleId = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(roleId, false);
/* 21 */     if (marriedRoleId > 0L)
/*    */     {
/* 23 */       String marriedUserId = RoleInterface.getUserId(marriedRoleId);
/* 24 */       lock(User.getTable(), Arrays.asList(new String[] { userId, marriedUserId }));
/* 25 */       lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(marriedRoleId) }));
/*    */     }
/*    */     else
/*    */     {
/* 29 */       lock(Lockeys.get(User.getTable(), userId));
/* 30 */       lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(roleId)));
/*    */     }
/*    */     
/* 33 */     if ((marriedRoleId > 0L) && (OnlineManager.getInstance().isOnline(marriedRoleId)))
/*    */     {
/* 35 */       return true;
/*    */     }
/*    */     
/* 38 */     if (HomelandInterface.getHomeWorldIdByRoleId(roleId, true) != -1L)
/*    */     {
/* 40 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 44 */     FashionManager.cancelFashionObserver(roleId);
/* 45 */     if (marriedRoleId > 0L)
/*    */     {
/* 47 */       FashionManager.cancelFashionObserver(marriedRoleId);
/*    */     }
/*    */     
/* 50 */     GameServer.logger().info(String.format("[childfashion]POnRoleLogoff.processImp@cancel observer success|roleid=%d|married_roleid=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(marriedRoleId) }));
/*    */     
/*    */ 
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fashion\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */