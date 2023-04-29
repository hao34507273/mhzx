/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class PGM_SetTriggerTreasureBoxRate
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int rate;
/*    */   
/*    */   public PGM_SetTriggerTreasureBoxRate(long gmRoleId, int rate)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.rate = rate;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 22 */     if ((this.rate < 0) || (this.rate > 10000))
/*    */     {
/* 24 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "概率范围不对");
/*    */     }
/*    */     
/* 27 */     SFriendsCircleConsts.getInstance().tread_circle_get_treasure_box_probability = this.rate;
/*    */     
/* 29 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "当前触发宝箱的概率是" + SFriendsCircleConsts.getInstance().tread_circle_get_treasure_box_probability);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PGM_SetTriggerTreasureBoxRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */