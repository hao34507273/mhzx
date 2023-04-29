/*    */ package mzm.gsp.mourn.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity2.confbean.MournConsts;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     int activityId = MournConsts.getInstance().activityId;
/* 17 */     long roleId = ((RoleLevelUpArg)this.arg).roleId;
/* 18 */     if (!ActivityInterface.isActivityOpen(activityId))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     String userId = RoleInterface.getUserId(roleId);
/* 24 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 26 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/* 27 */     if (!ActivityInterface.isInActivityLevel(userId, roleId, activityId))
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     MournManager.checkAndSynMournInfo(userId, roleId);
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mourn\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */