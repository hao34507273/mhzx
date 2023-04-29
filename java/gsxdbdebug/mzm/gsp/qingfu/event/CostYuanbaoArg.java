/*    */ package mzm.gsp.qingfu.event;
/*    */ 
/*    */ 
/*    */ public class CostYuanbaoArg
/*    */ {
/*    */   public final String userid;
/*    */   public final long roleid;
/*    */   public final String billno;
/*    */   public final long oldTotalCost;
/*    */   public final long cost;
/*    */   public final long oldTotalCostBind;
/*    */   public final long costBind;
/*    */   
/*    */   public CostYuanbaoArg(String userid, long roleid, String billno, long oldTotalCost, long cost, long oldTotalCostBind, long costBind)
/*    */   {
/* 16 */     this.userid = userid;
/* 17 */     this.roleid = roleid;
/* 18 */     this.billno = billno;
/* 19 */     this.oldTotalCost = oldTotalCost;
/* 20 */     this.cost = cost;
/* 21 */     this.oldTotalCostBind = oldTotalCostBind;
/* 22 */     this.costBind = costBind;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\event\CostYuanbaoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */