/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import mzm.gsp.qmhw.SQMHWSelfRankRes;
/*    */ import xbean.RoleQMHWScore;
/*    */ 
/*    */ public class PCQMHWSelfRankReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCQMHWSelfRankReq(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     if (QMHWManager.checkInCross(this.roleid)) {
/* 18 */       return false;
/*    */     }
/* 20 */     int rank = QMHWChart.getInstance().getRank(Long.valueOf(this.roleid));
/*    */     
/* 22 */     RoleQMHWScore xScore = QMHWManager.getXQMHWRoleCreateIfNotExist(this.roleid);
/*    */     
/* 24 */     SQMHWSelfRankRes qmhwSelfRankRes = new SQMHWSelfRankRes();
/* 25 */     qmhwSelfRankRes.rank = rank;
/* 26 */     qmhwSelfRankRes.score = xScore.getScore();
/* 27 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, qmhwSelfRankRes);
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\PCQMHWSelfRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */