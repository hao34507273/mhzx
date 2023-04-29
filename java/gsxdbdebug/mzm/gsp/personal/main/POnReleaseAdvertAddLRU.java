/*   */ package mzm.gsp.personal.main;
/*   */ 
/*   */ import mzm.gsp.personal.event.ReleaseAdvertArg;
/*   */ 
/*   */ public class POnReleaseAdvertAddLRU extends mzm.gsp.personal.event.ReleaseAdvertRunnable
/*   */ {
/*   */   public void process() throws Exception
/*   */   {
/* 9 */     ActiveRoleIdLRU.getInstance().add(((ReleaseAdvertArg)this.arg).roleId);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\POnReleaseAdvertAddLRU.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */