/*    */ package mzm.gsp.avatar.frame;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RemoveAvatarFrame
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int avatarFrameItemId;
/*    */   
/*    */   public PGM_RemoveAvatarFrame(long gmRoleId, long roleId, int avatarFrameItemId)
/*    */   {
/* 17 */     this.gmRoleId = gmRoleId;
/* 18 */     this.roleId = roleId;
/* 19 */     this.avatarFrameItemId = avatarFrameItemId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int cutDuration = AvatarFrameInterface.removeAvatarFrameByItem(this.roleId, this.avatarFrameItemId);
/* 26 */     if (cutDuration < 0)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("根据道具%d移除角色%d的头像框失败, 参数无效或是该角色没有对应的头像框", new Object[] { Integer.valueOf(this.avatarFrameItemId), Long.valueOf(this.roleId) }));
/*    */       
/* 30 */       return false;
/*    */     }
/* 32 */     if (cutDuration == 0)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("根据道具移除角色%d的头像框成功", new Object[] { Integer.valueOf(this.avatarFrameItemId), Long.valueOf(this.roleId) }));
/*    */       
/* 36 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 40 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("根据道具%d扣除角色%d的头像框使用时间成功 (%d小时)", new Object[] { Integer.valueOf(this.avatarFrameItemId), Long.valueOf(this.roleId), Integer.valueOf(cutDuration) }));
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\PGM_RemoveAvatarFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */