/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xio.Protocol;
/*    */ 
/*    */ public class PGetRankReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int type;
/*    */   private int from;
/*    */   private int to;
/*    */   
/*    */   public PGetRankReq(long roleId, int type, int from, int to)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.type = type;
/* 19 */     this.from = from;
/* 20 */     this.to = to;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     Protocol protocol1 = ChartDataCache.getInstance().getRankListProtocol(this.roleId, this.type, this.from - 1, this.to - 1);
/* 26 */     if (protocol1 == null) {
/* 27 */       return false;
/*    */     }
/* 29 */     OnlineManager.getInstance().send(this.roleId, protocol1);
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\PGetRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */