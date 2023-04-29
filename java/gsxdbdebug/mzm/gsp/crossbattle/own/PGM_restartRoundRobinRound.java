/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_restartRoundRobinRound
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int activityCfgid;
/*    */   private final int roundIndex;
/*    */   private final int restartLevel;
/*    */   private final String timestampString;
/*    */   
/*    */   public PGM_restartRoundRobinRound(long gmRoleid, int activityCfgid, int roundIndex, int restartLevel, String timestampString)
/*    */   {
/* 24 */     this.gmRoleid = gmRoleid;
/* 25 */     this.activityCfgid = activityCfgid;
/* 26 */     this.roundIndex = roundIndex;
/* 27 */     this.restartLevel = restartLevel;
/* 28 */     this.timestampString = timestampString;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (this.timestampString.length() != 14)
/*    */     {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, "date format error(yyyymmddhhMMss).");
/*    */     }
/* 38 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 39 */     calendar.set(1, Integer.valueOf(this.timestampString.substring(0, 4)).intValue());
/* 40 */     calendar.set(2, Integer.valueOf(this.timestampString.substring(4, 6)).intValue() - 1);
/* 41 */     calendar.set(5, Integer.valueOf(this.timestampString.substring(6, 8)).intValue());
/* 42 */     calendar.set(11, Integer.valueOf(this.timestampString.substring(8, 10)).intValue());
/* 43 */     calendar.set(12, Integer.valueOf(this.timestampString.substring(10, 12)).intValue());
/* 44 */     calendar.set(13, Integer.valueOf(this.timestampString.substring(12, 14)).intValue());
/* 45 */     calendar.set(14, 0);
/* 46 */     long timestamp = calendar.getTimeInMillis();
/* 47 */     RestartResult result = CrossBattleOwnManager.restartRoundRobinRoundByIdip(this.activityCfgid, this.roundIndex, this.restartLevel, timestamp);
/*    */     
/* 49 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("重开循环赛轮次|%s", new Object[] { result.desc }));
/* 50 */     return result == RestartResult.Success;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PGM_restartRoundRobinRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */