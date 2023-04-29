/*    */ package mzm.gsp.avatar.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RemoveAvatar
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int avatarItemId;
/*    */   
/*    */   public PGM_RemoveAvatar(long gmRoleId, long roleId, int avatarItemId)
/*    */   {
/* 18 */     this.gmRoleId = gmRoleId;
/* 19 */     this.roleId = roleId;
/* 20 */     this.avatarItemId = avatarItemId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     int cutDuration = AvatarInterface.removeAvatarByItem(this.roleId, this.avatarItemId);
/* 27 */     if (cutDuration < 0)
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("根据道具%d移除角色%d的头像失败, 参数无效或是该角色没有对应的头像", new Object[] { Integer.valueOf(this.avatarItemId), Long.valueOf(this.roleId) }));
/*    */       
/* 31 */       return false;
/*    */     }
/* 33 */     if (cutDuration == 0)
/*    */     {
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("根据道具移除角色%d的头像成功", new Object[] { Integer.valueOf(this.avatarItemId), Long.valueOf(this.roleId) }));
/*    */       
/* 37 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 41 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("根据道具%d扣除角色%d的头像使用时间成功 (%d小时)", new Object[] { Integer.valueOf(this.avatarItemId), Long.valueOf(this.roleId), Integer.valueOf(cutDuration) }));
/*    */     
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\PGM_RemoveAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */