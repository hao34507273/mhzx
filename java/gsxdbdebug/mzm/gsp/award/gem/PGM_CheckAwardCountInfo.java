/*    */ package mzm.gsp.award.gem;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_CheckAwardCountInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int gemCfgId;
/*    */   
/*    */   public PGM_CheckAwardCountInfo(long roleId, int gemCfgId)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.gemCfgId = gemCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     CountInfoCopy snap = AwardGemManager.selectCountInfo(this.gemCfgId);
/* 27 */     if (snap == null)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.roleId, "该奖励ID没有计数信息");
/* 30 */       return false;
/*    */     }
/* 32 */     String res = String.format("当前计数:%d| 当前小环:%d| 是否已奖励:%s| 总共已奖励个数:%d", new Object[] { Integer.valueOf(snap.get_count()), Integer.valueOf(snap.get_curCircle() + 1), Boolean.toString(snap.is_isAwarded()), Integer.valueOf(snap.get_awardNum()) });
/*    */     
/* 34 */     GmManager.getInstance().sendResultToGM(this.roleId, res);
/* 35 */     String date = String.format("开始日期:%s", new Object[] { getStartDate(snap.get_startTime()) });
/* 36 */     GmManager.getInstance().sendResultToGM(this.roleId, date);
/* 37 */     return true;
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
/* 49 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 50 */     String startDate = sdf.format(Long.valueOf(startTime));
/* 51 */     return startDate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gem\PGM_CheckAwardCountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */