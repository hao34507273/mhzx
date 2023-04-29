/*    */ package mzm.gsp.award.drop;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.DropInfo;
/*    */ 
/*    */ public class PGM_CheckRoleDropInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_CheckRoleDropInfo(long roleId)
/*    */   {
/* 13 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     DropInfo xDropInfo = xtable.Role2drop.get(Long.valueOf(this.roleId));
/* 21 */     if (xDropInfo == null)
/*    */     {
/* 23 */       GmManager.getInstance().sendResultToGM(this.roleId, "o(*￣︶￣*)o 今儿个啥也木有获得啊~");
/* 24 */       return false;
/*    */     }
/* 26 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 27 */     if (!mzm.gsp.util.DateTimeUtils.isInSameDay(curTime, xDropInfo.getStarttime()))
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.roleId, "o(*￣︶￣*)o 今儿个啥也木有获得啊~");
/*    */     }
/*    */     else
/*    */     {
/* 33 */       String res = String.format("已获取奖励物品:%s", new Object[] { xDropInfo.getDropcounts().toString() });
/* 34 */       GmManager.getInstance().sendResultToGM(this.roleId, res);
/*    */     }
/* 36 */     String date = String.format("开始日期:%s", new Object[] { getStartDate(xDropInfo.getStarttime()) });
/* 37 */     GmManager.getInstance().sendResultToGM(this.roleId, date);
/* 38 */     return true;
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
/* 50 */     if (startTime <= 0L)
/*    */     {
/* 52 */       return "whose your dady!";
/*    */     }
/* 54 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 55 */     String startDate = sdf.format(Long.valueOf(startTime));
/* 56 */     return startDate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\drop\PGM_CheckRoleDropInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */