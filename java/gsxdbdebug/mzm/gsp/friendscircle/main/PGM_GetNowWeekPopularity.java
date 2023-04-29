/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_GetNowWeekPopularity extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetNowWeekPopularity(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     int currentWeekPopularityValue = FriendsCircleManager.getWeekPopularityValue(this.roleId, true);
/*    */     
/* 20 */     GmManager.getInstance().sendResultToGM(this.roleId, "当前周人气值为" + currentWeekPopularityValue);
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PGM_GetNowWeekPopularity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */