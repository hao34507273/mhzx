/*    */ package mzm.gsp.singletask.level;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.LevelTaskInfo;
/*    */ import xbean.Pod;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2leveltask;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleId = ((RoleLevelUpArg)this.arg).roleId;
/*    */     
/* 19 */     String userid = RoleInterface.getUserId(roleId);
/* 20 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 22 */     LevelTaskInfo xLvInfo = Role2leveltask.get(Long.valueOf(roleId));
/* 23 */     if (xLvInfo == null)
/*    */     {
/* 25 */       xLvInfo = Pod.newLevelTaskInfo();
/* 26 */       Role2leveltask.insert(Long.valueOf(roleId), xLvInfo);
/*    */     }
/*    */     
/* 29 */     LevelTaskManager.checkCanActiveGraph(roleId, userid, xLvInfo);
/*    */     
/* 31 */     LevelTaskManager.checkRoleGraphValid(xLvInfo, roleId, userid);
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\level\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */