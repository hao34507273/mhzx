/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ 
/*    */ public class UnbanPlayObserver extends Observer
/*    */ {
/*    */   private final long roleId;
/*    */   private final int playType;
/*    */   
/*    */   public UnbanPlayObserver(long roleId, int playType, long intervalSeconds)
/*    */   {
/* 12 */     super(intervalSeconds);
/* 13 */     this.roleId = roleId;
/* 14 */     this.playType = playType;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 20 */     IdipManager.removeBanPlay(this.roleId, this.playType);
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\UnbanPlayObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */