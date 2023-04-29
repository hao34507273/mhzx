/*    */ package mzm.gsp.friendscircle.event;
/*    */ 
/*    */ 
/*    */ public class FriendsCirclePopularityAddArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int addPopularity;
/*    */   
/*    */   public final int nowTotalPopularity;
/*    */   
/*    */   public final int nowWeekPopularity;
/*    */   
/*    */ 
/*    */   public FriendsCirclePopularityAddArg(long roleId, int addPopularity, int nowTotalPopularity, int nowWeekPopularity)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.addPopularity = addPopularity;
/* 19 */     this.nowTotalPopularity = nowTotalPopularity;
/* 20 */     this.nowWeekPopularity = nowWeekPopularity;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\event\FriendsCirclePopularityAddArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */