/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengActivityArg;
/*    */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengActivityProcedure;
/*    */ import mzm.gsp.feisheng.main.FeiShengInterface;
/*    */ import mzm.gsp.role.result.ReleaseStorageExpResult;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleCompleteFeiShengSubActivity
/*    */   extends RoleCompleteFeiShengActivityProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     long roleId = ((RoleCompleteFeiShengActivityArg)this.arg).roleid;
/*    */     
/* 26 */     String userId = RoleInterface.getUserId(roleId);
/* 27 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 29 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*    */     
/* 31 */     int level = RoleInterface.getLevel(roleId);
/* 32 */     if (!FeiShengInterface.checkRoleCanFeiSheng(roleId, level, true))
/*    */     {
/* 34 */       GameServer.logger().error(String.format("[role]POnRoleCompleteFeiShengSubActivity.processImp@ finish activitys but not satisfy the fly condition!|rloeId=%d|roleLevel=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(level) }));
/*    */       
/*    */ 
/*    */ 
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     TLogArg tLogArg = new TLogArg(LogReason.ROLE_ACTIVIEY_FINISH_RELEASE_EXP);
/* 42 */     ReleaseStorageExpResult res = RoleInterface.releaseExp(userId, roleId, tLogArg);
/* 43 */     if (!res.isReleaseSuc())
/*    */     {
/* 45 */       GameServer.logger().error(String.format("[role]POnRoleCompleteFeiShengSubActivity.processImp@ release exp err!|roleId=%d|reason=%s", new Object[] { Long.valueOf(roleId), res.getReason() }));
/*    */       
/*    */ 
/* 48 */       return false;
/*    */     }
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnRoleCompleteFeiShengSubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */