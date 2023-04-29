/*    */ package mzm.gsp.award.gem;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CountInfo;
/*    */ import xtable.Gem2countinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PInitGemCacheCountInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gemKey;
/*    */   
/*    */   public PInitGemCacheCountInfo(long gemKey)
/*    */   {
/* 18 */     this.gemKey = gemKey;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     CountInfo xCountInfo = Gem2countinfo.get(Long.valueOf(this.gemKey));
/* 26 */     if (xCountInfo == null)
/*    */     {
/*    */ 
/* 29 */       return false;
/*    */     }
/* 31 */     AwardGemManager.initCountInfo(this.gemKey, xCountInfo.getCount(), xCountInfo.getAwardnum(), xCountInfo.getStarttime(), xCountInfo.getIsawarded(), xCountInfo.getCurcircle());
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gem\PInitGemCacheCountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */