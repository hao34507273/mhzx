/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ 
/*    */ public class ROnRoleLogin extends PlayerLoginRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/*  9 */     POnRoleLogin proc = new POnRoleLogin();
/* 10 */     proc.setArg(this.arg);
/* 11 */     MatchNRTimeTaskManager.getInstance().addTask(proc);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */