/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.JailProtectInfo;
/*    */ import xtable.Role2jailprotect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JailProtectSession
/*    */   extends Session
/*    */ {
/*    */   public JailProtectSession(long interval, long roleId)
/*    */   {
/* 22 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     new JailProtectProc().execute();
/*    */   }
/*    */   
/*    */   class JailProtectProc extends LogicProcedure
/*    */   {
/*    */     JailProtectProc() {}
/*    */     
/*    */     protected boolean processImp() throws Exception {
/* 36 */       long roleId = JailProtectSession.this.getOwerId();
/*    */       
/* 38 */       JailProtectInfo xJailProtectInfo = Role2jailprotect.get(Long.valueOf(roleId));
/* 39 */       long jailProtectLeftTime = PrisonInterface.getRoleJailProtectTimeLeft(xJailProtectInfo);
/* 40 */       if (jailProtectLeftTime > 0L)
/*    */       {
/* 42 */         return false;
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 47 */       if (RoleStatusInterface.containsStatus(roleId, 1662, true))
/*    */       {
/* 49 */         RoleStatusInterface.unsetStatus(roleId, 1662);
/*    */       }
/*    */       
/* 52 */       Role2jailprotect.remove(Long.valueOf(roleId));
/*    */       
/* 54 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\JailProtectSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */