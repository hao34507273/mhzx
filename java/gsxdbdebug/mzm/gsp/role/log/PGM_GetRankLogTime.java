/*    */ package mzm.gsp.role.log;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.LogRankData;
/*    */ import xbean.RecordData;
/*    */ import xtable.Logrolerank;
/*    */ 
/*    */ public class PGM_GetRankLogTime
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int logRankType;
/*    */   
/*    */   public PGM_GetRankLogTime(long roleId, int logRankType)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.logRankType = logRankType;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String date = String.format("Tlog日期:%s", new Object[] { getStartDate(getLogTime()) });
/* 29 */     GmManager.getInstance().sendResultToGM(this.roleId, date);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   private long getLogTime()
/*    */   {
/* 35 */     LogRankData xLogRankData = Logrolerank.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 36 */     if (xLogRankData == null)
/*    */     {
/* 38 */       return -1L;
/*    */     }
/* 40 */     RecordData xRecordData = (RecordData)xLogRankData.getType2rankdata().get(Integer.valueOf(this.logRankType));
/* 41 */     if (xRecordData == null)
/*    */     {
/* 43 */       return -1L;
/*    */     }
/* 45 */     return xRecordData.getLastlogtime();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private String getStartDate(long startTime)
/*    */   {
/* 57 */     if (startTime <= 0L)
/*    */     {
/* 59 */       return "whose your dady!";
/*    */     }
/* 61 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 62 */     String startDate = sdf.format(Long.valueOf(startTime));
/* 63 */     return startDate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\log\PGM_GetRankLogTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */