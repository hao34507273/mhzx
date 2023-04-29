/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class ROnRoleLogin extends PlayerLoginRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 12 */     new POnRoleLogin(roleid).call();
/*    */     
/* 14 */     new PHandItemHide(roleid).call();
/*    */   }
/*    */   
/*    */   private static class PHandItemHide extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     
/*    */     public PHandItemHide(long roleid)
/*    */     {
/* 23 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 29 */       ItemHideManager.onRoleLogin(this.roleid);
/* 30 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */