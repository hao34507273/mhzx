/*    */ package mzm.gsp.role.log;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.multirank.NoneRealMFVRankManager;
/*    */ import mzm.gsp.role.multirank.RoleMultiFightValueChart;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RecordData;
/*    */ import xbean.RoleRankData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PMFVRank
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long curTime;
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     int endNo = LogRankManager.getCfgTopNum();
/* 25 */     if (endNo <= 0)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     List<RoleMultiFightValueChart> roleMFVCharts = NoneRealMFVRankManager.getInstance().getRankObjs(0, endNo - 1);
/* 30 */     if ((roleMFVCharts == null) || (roleMFVCharts.size() == 0))
/*    */     {
/* 32 */       return false;
/*    */     }
/* 34 */     this.curTime = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 36 */     RecordData xRecordData = LogRankManager.getXRecordDataIfAbsent(2, this.curTime);
/* 37 */     Map<Long, RoleRankData> rankDatas = xRecordData.getRankdatas();
/* 38 */     for (int i = 0; i < roleMFVCharts.size(); i++)
/*    */     {
/* 40 */       handleEachRankData(rankDatas, (RoleMultiFightValueChart)roleMFVCharts.get(i));
/*    */     }
/* 42 */     if (DateTimeUtils.needDailyReset(xRecordData.getLastlogtime(), this.curTime, 0))
/*    */     {
/* 44 */       new PTLogXTypeRankData(2).execute();
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void handleEachRankData(Map<Long, RoleRankData> rankDatas, RoleMultiFightValueChart roleMfv)
/*    */   {
/* 57 */     long roleId = roleMfv.getRoleid();
/* 58 */     int rankValue = roleMfv.getFightValue();
/*    */     
/* 60 */     LogRankManager.refreshLogRankdata(rankDatas, roleId, rankValue, this.curTime);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\log\PMFVRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */