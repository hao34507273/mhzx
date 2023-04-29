/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetMaxTreadGetPopularityDay extends LogicProcedure
/*    */ {
/*    */   private final int value;
/*    */   private final long gmRoleId;
/*    */   
/*    */   public PGM_SetMaxTreadGetPopularityDay(int value, long gmRoleId)
/*    */   {
/* 14 */     this.value = value;
/* 15 */     this.gmRoleId = gmRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     SFriendsCircleConsts.getInstance().max_get_popularity_by_tread = this.value;
/*    */     
/* 23 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "当前每人每天只能通过踩一踩获得 " + this.value + "的人气值");
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PGM_SetMaxTreadGetPopularityDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */