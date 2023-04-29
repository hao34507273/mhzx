/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.corps.confbean.CorpsConsts;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2createcorpsconf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CreateCorpsConfirmSession
/*    */   extends Session
/*    */ {
/*    */   CreateCorpsConfirmSession(long leaderId)
/*    */   {
/* 18 */     super(CorpsConsts.getInstance().CREATE_CONFIRM_INTERVAL, leaderId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 24 */     new PCreateCorpsConfirmTimeOut(super.getOwerId()).execute();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   class PCreateCorpsConfirmTimeOut
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */ 
/*    */ 
/*    */     public PCreateCorpsConfirmTimeOut(long roleId)
/*    */     {
/* 39 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 45 */       Role2createcorpsconf.remove(Long.valueOf(this.roleId));
/* 46 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\CreateCorpsConfirmSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */