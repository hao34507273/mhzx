/*    */ package mzm.gsp.singlebattle.antiafk;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ROnRoleLogin
/*    */   extends PlayerLoginRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 15 */     final long roleid = ((Long)this.arg).longValue();
/* 16 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 21 */         return AntiAFKManager.startAFKDetect(roleid);
/*    */       }
/*    */     }.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\antiafk\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */