/*    */ package mzm.gsp.award.watchdog;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.AwardTotalData;
/*    */ 
/*    */ public class PCheckRoleTotalAwardExp extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCheckRoleTotalAwardExp(long roleId)
/*    */   {
/* 13 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     AwardTotalData xTotalData = xtable.Role2totaldata.select(Long.valueOf(this.roleId));
/* 20 */     if (xTotalData == null)
/*    */     {
/* 22 */       GmManager.getInstance().sendResultToGM(this.roleId, "今日未获取奖励经验!");
/* 23 */       return false;
/*    */     }
/* 25 */     String res = String.format("当前奖励总数:%d|计数时玩家等级:%d", new Object[] { Long.valueOf(xTotalData.getRoleexp()), Integer.valueOf(xTotalData.getRolestartlv()) });
/* 26 */     GmManager.getInstance().sendResultToGM(this.roleId, res);
/* 27 */     String date = String.format("开始日期:%s", new Object[] { getStartDate(xTotalData.getStarttime()) });
/* 28 */     GmManager.getInstance().sendResultToGM(this.roleId, date);
/* 29 */     return true;
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
/* 41 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 42 */     String startDate = sdf.format(Long.valueOf(startTime));
/* 43 */     return startDate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\watchdog\PCheckRoleTotalAwardExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */