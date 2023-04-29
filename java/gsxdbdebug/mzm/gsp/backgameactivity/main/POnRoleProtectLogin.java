/*    */ package mzm.gsp.backgameactivity.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.event.PlayerLoginProtectProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BackGameActivityInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2backgameactivity;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class POnRoleProtectLogin
/*    */   extends PlayerLoginProtectProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 20 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 23 */     String userId = RoleInterface.getUserId(roleId);
/* 24 */     if (null == userId)
/*    */     {
/* 26 */       GameServer.logger().error(String.format("[backgameactivity]POnRoleLogin.processImp@userId not exist!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*    */       
/* 28 */       return false;
/*    */     }
/* 30 */     Set<Long> roleIdSet = RoleInterface.getRoleSet(userId);
/* 31 */     if ((roleIdSet == null) || (roleIdSet.isEmpty()))
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     lock(Lockeys.get(User.getTable(), userId));
/* 36 */     lock(Basic.getTable(), roleIdSet);
/*    */     
/*    */ 
/* 39 */     BackGameActivityInfo xBackGameActivityInfo = Role2backgameactivity.get(Long.valueOf(roleId));
/* 40 */     if (null == xBackGameActivityInfo)
/*    */     {
/*    */ 
/* 43 */       return false;
/*    */     }
/* 45 */     if (!BackGameActivityManager.isBackGameActivityInfoAvailable(xBackGameActivityInfo))
/*    */     {
/*    */ 
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     int openActivityId = xBackGameActivityInfo.getActivity_id();
/*    */     
/* 53 */     BackGameActivityManager.addPointForCurrentBackGameActivity(roleId, openActivityId);
/*    */     
/*    */ 
/* 56 */     BackGameActivityManager.synBackGameActivityInfoToClient(userId, roleId, roleIdSet, xBackGameActivityInfo);
/*    */     
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\POnRoleProtectLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */