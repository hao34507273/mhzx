/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PCFriendsCircleTryTread
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long activeRoleId;
/*    */   private final long beTrodRoleId;
/*    */   
/*    */   public PCFriendsCircleTryTread(long activeRoleId, long beTrodRoleId)
/*    */   {
/* 16 */     this.activeRoleId = activeRoleId;
/* 17 */     this.beTrodRoleId = beTrodRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!isFriendsCircleAutoTreadSwitchOpen(this.activeRoleId))
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     new PCTreadFriendsCircle(this.activeRoleId, this.beTrodRoleId, GameServerInfoManager.getZoneidFromRoleid(this.beTrodRoleId), true).call();
/*    */     
/*    */ 
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   private boolean isFriendsCircleAutoTreadSwitchOpen(long roleId)
/*    */   {
/* 36 */     if (!OpenInterface.getOpenStatus(556))
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (OpenInterface.isBanPlay(roleId, 556))
/*    */     {
/* 43 */       OpenInterface.sendBanPlayMsg(roleId, 556);
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PCFriendsCircleTryTread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */