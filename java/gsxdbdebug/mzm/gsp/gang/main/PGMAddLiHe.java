/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMAddLiHe
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int addNum;
/*    */   
/*    */   public PGMAddLiHe(long roleId, int addNum)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.addNum = addNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     GangInterface.addLiHeByRole(this.roleId, this.addNum);
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGMAddLiHe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */