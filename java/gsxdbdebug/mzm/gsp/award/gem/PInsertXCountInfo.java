/*    */ package mzm.gsp.award.gem;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CountInfo;
/*    */ import xbean.Pod;
/*    */ import xtable.Gem2countinfo;
/*    */ 
/*    */ 
/*    */ public class PInsertXCountInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final CountInfoCopy countInfo;
/*    */   
/*    */   public PInsertXCountInfo(CountInfoCopy countInfo)
/*    */   {
/* 16 */     this.countInfo = countInfo;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     long gemKey = this.countInfo.get_gemKey();
/*    */     
/* 24 */     CountInfo xCountInfo = Gem2countinfo.get(Long.valueOf(gemKey));
/* 25 */     if (xCountInfo == null)
/*    */     {
/* 27 */       xCountInfo = Pod.newCountInfo();
/* 28 */       Gem2countinfo.insert(Long.valueOf(gemKey), xCountInfo);
/*    */     }
/* 30 */     fillXCountInfo(xCountInfo, this.countInfo);
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   private void fillXCountInfo(CountInfo xCountInfo, CountInfoCopy countInfo)
/*    */   {
/* 36 */     xCountInfo.setAwardnum(countInfo.get_awardNum());
/* 37 */     xCountInfo.setCount(countInfo.get_count());
/* 38 */     xCountInfo.setIsawarded(countInfo.is_isAwarded());
/* 39 */     xCountInfo.setStarttime(countInfo.get_startTime());
/* 40 */     xCountInfo.setCurcircle(countInfo.get_curCircle());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gem\PInsertXCountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */