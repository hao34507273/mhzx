/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerOfflineRunnable;
/*    */ 
/*    */ public class ROnRoleLogoff extends PlayerOfflineRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/*  9 */     POnRoleLogoff proc = new POnRoleLogoff();
/* 10 */     proc.setArg(this.arg);
/* 11 */     MatchNRTimeTaskManager.getInstance().addTask(proc);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\ROnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */