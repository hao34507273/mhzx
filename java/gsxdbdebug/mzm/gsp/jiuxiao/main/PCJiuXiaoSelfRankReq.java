/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import mzm.gsp.jiuxiao.SJiuXiaoSelfRankRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.JiuXiaoBean;
/*    */ import xbean.JiuXiaoFloorBean;
/*    */ 
/*    */ public class PCJiuXiaoSelfRankReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int rankType;
/*    */   
/*    */   public PCJiuXiaoSelfRankReq(int rankType, long roleid)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.rankType = rankType;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     if (JiuXiaoManager.checkInCross(this.roleid)) {
/* 22 */       return false;
/*    */     }
/* 24 */     JiuXiaoChart jiuXiaoChart = JiuXiaoRankManager.getInstance().getJiuXiaoChart(this.rankType);
/* 25 */     if (jiuXiaoChart == null) {
/* 26 */       mzm.gsp.GameServer.logger().error(String.format("[JiuXiao]PCJiuXiaoSelfRankReq.processImp@jiuxiao rank not exist|rankType=%d", new Object[] { Integer.valueOf(this.rankType) }));
/*    */       
/*    */ 
/* 29 */       return false;
/*    */     }
/* 31 */     int rank = jiuXiaoChart.getRank(Long.valueOf(this.roleid));
/* 32 */     JiuXiaoRankObj jiuXiaoRankObj = (JiuXiaoRankObj)jiuXiaoChart.getRankObj(rank);
/* 33 */     if (rank >= 0) {
/* 34 */       rank++;
/*    */     }
/*    */     
/* 37 */     SJiuXiaoSelfRankRes sJiuXiaoSelfRankRes = new SJiuXiaoSelfRankRes();
/* 38 */     sJiuXiaoSelfRankRes.ranktype = this.rankType;
/* 39 */     sJiuXiaoSelfRankRes.rank = rank;
/* 40 */     if (jiuXiaoRankObj != null) {
/* 41 */       sJiuXiaoSelfRankRes.layer = jiuXiaoRankObj.getLayer();
/* 42 */       sJiuXiaoSelfRankRes.time = jiuXiaoRankObj.getSec();
/*    */     } else {
/* 44 */       JiuXiaoBean xjiuXiaoBean = xtable.Role2jiuxiao.get(Long.valueOf(this.roleid));
/* 45 */       if (xjiuXiaoBean != null) {
/* 46 */         int activityid = JiuXiaoCfgManager.getActivityidByRankType(this.rankType);
/* 47 */         int floor = JiuXiaoCfgManager.getMaxFloorByActivityid(activityid);
/* 48 */         mzm.gsp.activity.confbean.SJueZhanJiuXiaoCfg jueZhanJiuXiaoCfg = JiuXiaoCfgManager.getJiuXiaoCfg(activityid, floor);
/* 49 */         if (jueZhanJiuXiaoCfg != null) {
/* 50 */           JiuXiaoFloorBean xJiuXiaoFloorBean = (JiuXiaoFloorBean)xjiuXiaoBean.getFloormap().get(Integer.valueOf(jueZhanJiuXiaoCfg.id));
/* 51 */           if (xJiuXiaoFloorBean != null) {
/* 52 */             sJiuXiaoSelfRankRes.time = xJiuXiaoFloorBean.getTimesec();
/* 53 */             sJiuXiaoSelfRankRes.layer = floor;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 58 */     OnlineManager.getInstance().send(this.roleid, sJiuXiaoSelfRankRes);
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\PCJiuXiaoSelfRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */