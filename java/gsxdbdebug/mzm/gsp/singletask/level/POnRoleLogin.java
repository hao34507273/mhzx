/*    */ package mzm.gsp.singletask.level;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.LevelTaskInfo;
/*    */ import xbean.Pod;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2leveltask;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 20 */     String userid = RoleInterface.getUserId(roleId);
/* 21 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 23 */     LevelTaskInfo xLvInfo = Role2leveltask.get(Long.valueOf(roleId));
/* 24 */     if (xLvInfo == null)
/*    */     {
/* 26 */       xLvInfo = Pod.newLevelTaskInfo();
/* 27 */       Role2leveltask.insert(Long.valueOf(roleId), xLvInfo);
/*    */     }
/*    */     
/* 30 */     LevelTaskManager.checkCanActiveGraph(roleId, userid, xLvInfo);
/*    */     
/* 32 */     LevelTaskManager.checkRoleGraphValid(xLvInfo, roleId, userid);
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\level\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */