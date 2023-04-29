/*    */ package mzm.gsp.friend.event;
/*    */ 
/*    */ public class FriendPointChangeArg
/*    */ {
/*    */   public final long roleid1;
/*    */   public final long roleid2;
/*    */   public final int totalPoint;
/*    */   public final int changePoint;
/*    */   
/*    */   public FriendPointChangeArg(long roleid1, long roleid2, int totalPoint, int changePoint) {
/* 11 */     this.roleid1 = roleid1;
/* 12 */     this.roleid2 = roleid2;
/* 13 */     this.totalPoint = totalPoint;
/* 14 */     this.changePoint = changePoint;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\event\FriendPointChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */