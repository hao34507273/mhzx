/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.qmhw.QMHWRankRoleData;
/*    */ import mzm.gsp.qmhw.SQMHWRankRes;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCQMHWRankReq extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int fromNo;
/*    */   private final int toNo;
/*    */   
/*    */   public PCQMHWRankReq(long roleid, int fromno, int tono)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.fromNo = fromno;
/* 20 */     this.toNo = tono;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (QMHWManager.checkInCross(this.roleid)) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     if (this.fromNo < 0) {
/* 30 */       return false;
/*    */     }
/* 32 */     if (this.fromNo > this.toNo) {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     List<QMHWChartObj> qmhwChartObjs = QMHWChart.getInstance().getRankObjs(this.fromNo, this.toNo);
/*    */     
/* 38 */     SQMHWRankRes qmhwRankRes = new SQMHWRankRes();
/*    */     
/* 40 */     for (int i = 0; i < qmhwChartObjs.size(); i++) {
/* 41 */       QMHWChartObj qmhwChartObj = (QMHWChartObj)qmhwChartObjs.get(i);
/* 42 */       long roleid = qmhwChartObj.roleid;
/* 43 */       QMHWRankRoleData qmhwRankRoleData = new QMHWRankRoleData();
/* 44 */       qmhwRankRoleData.rank = (this.fromNo + i);
/* 45 */       qmhwRankRoleData.occupation = RoleInterface.getOccupationId(roleid);
/* 46 */       qmhwRankRoleData.roleid = roleid;
/* 47 */       qmhwRankRoleData.rolename = RoleInterface.getName(roleid);
/* 48 */       qmhwRankRoleData.score = qmhwChartObj.score;
/* 49 */       qmhwRankRes.rankdatas.add(qmhwRankRoleData);
/*    */     }
/*    */     
/* 52 */     OnlineManager.getInstance().send(this.roleid, qmhwRankRes);
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\PCQMHWRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */