/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Role2FriendsCircleInfo;
/*    */ 
/*    */ public class PGM_SetRepairTreadValue extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int repairTreadValue;
/*    */   
/*    */   public PGM_SetRepairTreadValue(long roleId, int repairTreadValue)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.repairTreadValue = repairTreadValue;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*    */     
/* 23 */     xRole2FriendsCircleInfo.setRepair_tread(this.repairTreadValue);
/*    */     
/* 25 */     GmManager.getInstance().sendResultToGM(this.roleId, "当前的修复状态值" + this.repairTreadValue);
/*    */     
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PGM_SetRepairTreadValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */