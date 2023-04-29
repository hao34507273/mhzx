/*    */ package mzm.gsp.avatar.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleAvatar;
/*    */ 
/*    */ 
/*    */ public class PSyncAvatarInfoWhenSwitchFaction
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int occupationId;
/*    */   
/*    */   PSyncAvatarInfoWhenSwitchFaction(long roleId, int occupationId)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.occupationId = occupationId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (AvatarManager.isEnable())
/*    */     {
/* 26 */       RoleAvatar xRoleAvatar = AvatarManager.getRoleAvatar(this.roleId, true);
/* 27 */       if (xRoleAvatar == null) {
/* 28 */         return true;
/*    */       }
/*    */       
/* 31 */       int gender = RoleInterface.getGender(this.roleId);
/* 32 */       int defaultAvatarId = AvatarManager.getDefaultAvatarId(this.occupationId, gender);
/* 33 */       xRoleAvatar.get_avatars().put(Integer.valueOf(defaultAvatarId), Integer.valueOf(0));
/* 34 */       AvatarManager.clearUnavailableAvatars(this.roleId, this.occupationId, xRoleAvatar);
/* 35 */       AvatarManager.syncAvatarInfo(this.roleId, xRoleAvatar);
/* 36 */       AvatarManager.info("PSyncAvatarInfoWhenSwitchFaction.processImp@done|roleid=%d|faction=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.occupationId) });
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\PSyncAvatarInfoWhenSwitchFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */