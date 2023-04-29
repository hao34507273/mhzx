/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnUserCostYuanbaoForAccumTotalCostActivity extends LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   private final long oldAccumTotalCost;
/*    */   
/*    */   public POnUserCostYuanbaoForAccumTotalCostActivity(String userid, long roleid, long oldAccumTotalCost)
/*    */   {
/* 13 */     this.userid = userid;
/* 14 */     this.roleid = roleid;
/* 15 */     this.oldAccumTotalCost = oldAccumTotalCost;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     return AccumTotalCostActivityManager.onCostInfoChanged(this.userid, this.roleid, this.oldAccumTotalCost);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnUserCostYuanbaoForAccumTotalCostActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */