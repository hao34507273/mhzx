/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnlineTreasureBoxTimeOut
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int activityRate;
/*    */   
/*    */   POnlineTreasureBoxTimeOut(int activityRate)
/*    */   {
/* 16 */     this.activityRate = activityRate;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxFunOpen()) {
/* 22 */       return false;
/*    */     }
/* 24 */     OnlineTreasureBoxManager.onTreasureBoxStartWithRate(this.activityRate);
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\POnlineTreasureBoxTimeOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */