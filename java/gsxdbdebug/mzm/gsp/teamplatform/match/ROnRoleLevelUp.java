/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpRunnable;
/*    */ 
/*    */ public class ROnRoleLevelUp extends RoleLevelUpRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/*  9 */     POnRoleLevelUp proc = new POnRoleLevelUp();
/* 10 */     proc.setArg(this.arg);
/* 11 */     MatchNRTimeTaskManager.getInstance().addTask(proc);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\ROnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */