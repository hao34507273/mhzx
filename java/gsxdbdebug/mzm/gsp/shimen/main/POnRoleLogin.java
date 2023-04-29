/*    */ package mzm.gsp.shimen.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (!ShimenManager.isShimenSwitchOpenForRole(((Long)this.arg).longValue(), false))
/*    */     {
/* 15 */       int ocp = RoleInterface.getOccupationId(((Long)this.arg).longValue());
/* 16 */       int graphid = ShimenManager.getShimenGraphIdByMenpai(ocp);
/* 17 */       if (TaskInterface.isHaveGraphId(((Long)this.arg).longValue(), graphid))
/*    */       {
/*    */ 
/* 20 */         String userid = RoleInterface.getUserId(((Long)this.arg).longValue());
/* 21 */         lock(Lockeys.get(User.getTable(), userid));
/* 22 */         TaskInterface.closeActivityGraphWithoutEvent(((Long)this.arg).longValue(), graphid);
/*    */       }
/* 24 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */