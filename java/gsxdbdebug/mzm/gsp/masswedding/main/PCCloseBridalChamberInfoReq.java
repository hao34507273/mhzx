/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCCloseBridalChamberInfoReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCCloseBridalChamberInfoReq(long roleid) {
/* 10 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     xbean.MassWeddingRobSubscribe xMassWeddingRobSubscribe = MassWeddingManager.getMassWeddingRobSubScribe(true);
/* 16 */     MassWeddingManager.unSubScribe(xMassWeddingRobSubscribe, this.roleid);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\PCCloseBridalChamberInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */