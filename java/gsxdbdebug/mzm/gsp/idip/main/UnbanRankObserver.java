/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class UnbanRankObserver extends Observer
/*    */ {
/*    */   private final long roleId;
/*    */   private final int rankType;
/*    */   
/*    */   public UnbanRankObserver(long roleId, int rankType, long intervalSeconds)
/*    */   {
/* 12 */     super(intervalSeconds);
/* 13 */     this.roleId = roleId;
/* 14 */     this.rankType = rankType;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 20 */     IdipManager.removeBanRank(this.roleId, this.rankType);
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\UnbanRankObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */