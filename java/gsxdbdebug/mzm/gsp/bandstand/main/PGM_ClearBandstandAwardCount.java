/*    */ package mzm.gsp.bandstand.main;
/*    */ 
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.BandstandInfo;
/*    */ 
/*    */ public class PGM_ClearBandstandAwardCount extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_ClearBandstandAwardCount(long roleId)
/*    */   {
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     BandstandInfo xBandstandInfo = BandstandManager.getBandstandInfo(this.roleId);
/* 21 */     for (Map.Entry<Integer, Integer> entry : xBandstandInfo.getActivityid2todayawardcount().entrySet())
/*    */     {
/* 23 */       entry.setValue(Integer.valueOf(0));
/*    */     }
/*    */     
/* 26 */     GmManager.getInstance().sendResultToGM(this.roleId, "次数清除成功");
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\PGM_ClearBandstandAwardCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */