/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.Role2FriendsCircleInfo;
/*    */ 
/*    */ public class PGM_GetRepairTreadValue extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_GetRepairTreadValue(long roleId)
/*    */   {
/* 12 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*    */     
/* 20 */     xRole2FriendsCircleInfo.setRepair_tread(xRole2FriendsCircleInfo.getRepair_tread());
/*    */     
/* 22 */     GmManager.getInstance().sendResultToGM(this.roleId, "当前的修复状态值" + xRole2FriendsCircleInfo.getRepair_tread());
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PGM_GetRepairTreadValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */