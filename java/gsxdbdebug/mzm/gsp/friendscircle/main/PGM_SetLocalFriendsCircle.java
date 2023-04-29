/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Role2FriendsCircleInfo;
/*    */ 
/*    */ public class PGM_SetLocalFriendsCircle
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int type;
/*    */   private final int value;
/*    */   
/*    */   public PGM_SetLocalFriendsCircle(long roleId, int type, int value)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.type = type;
/* 17 */     this.value = value;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*    */     
/* 25 */     if (this.type == 1)
/*    */     {
/* 27 */       xRole2FriendsCircleInfo.setTreasure_box_num(this.value);
/*    */     }
/* 29 */     else if (this.type == 2)
/*    */     {
/* 31 */       xRole2FriendsCircleInfo.setTotal_popularity_value(this.value);
/*    */     }
/* 33 */     else if (this.type == 3)
/*    */     {
/* 35 */       xRole2FriendsCircleInfo.setCurrent_week_popularity_value(this.value);
/*    */     }
/* 37 */     else if (this.type == 4)
/*    */     {
/* 39 */       xRole2FriendsCircleInfo.setReceive_gift_num(this.value);
/*    */     }
/*    */     
/* 42 */     new PGM_GetLocalFriendsCircle(this.roleId).call();
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PGM_SetLocalFriendsCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */