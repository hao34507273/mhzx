/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.crossserver.top.SingleCrossFieldTopChartObj;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReportRoleSingleCrossFieldRankInfoDoneArg
/*    */ {
/*    */   private final int retcode;
/*    */   private final long rankid;
/*    */   private final SingleCrossFieldTopChartObj chartObj;
/*    */   private final Octets context;
/*    */   
/*    */   public ReportRoleSingleCrossFieldRankInfoDoneArg(int retcode, long rankid, SingleCrossFieldTopChartObj chartObj, Octets context)
/*    */   {
/* 21 */     this.retcode = retcode;
/* 22 */     this.rankid = rankid;
/* 23 */     this.chartObj = chartObj;
/* 24 */     this.context = context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isSucceed()
/*    */   {
/* 34 */     return this.retcode == 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isTimeout()
/*    */   {
/* 44 */     return this.retcode == 8;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRetCode()
/*    */   {
/* 54 */     return this.retcode;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRankid()
/*    */   {
/* 64 */     return this.rankid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SingleCrossFieldTopChartObj getChartObj()
/*    */   {
/* 74 */     return this.chartObj;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Octets getContext()
/*    */   {
/* 84 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportRoleSingleCrossFieldRankInfoDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */