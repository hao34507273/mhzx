/*    */ package mzm.gsp.avatar.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleAvatar;
/*    */ 
/*    */ public class PSyncAvatarInfoWhenSwitchGender
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int gender;
/*    */   
/*    */   PSyncAvatarInfoWhenSwitchGender(long paramLong, int paramInt)
/*    */   {
/* 16 */     this.roleId = paramLong;
/* 17 */     this.gender = paramInt;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (AvatarManager.isEnable())
/*    */     {
/* 25 */       RoleAvatar localRoleAvatar = AvatarManager.getRoleAvatar(this.roleId, true);
/* 26 */       if (localRoleAvatar == null) {
/* 27 */         return true;
/*    */       }
/* 29 */       int i = RoleInterface.getOccupationId(this.roleId);
/* 30 */       int j = AvatarManager.getDefaultAvatarId(i, this.gender);
/* 31 */       localRoleAvatar.get_avatars().put(Integer.valueOf(j), Integer.valueOf(0));
/* 32 */       AvatarManager.clearUnavailableAvatars(this.roleId, i, localRoleAvatar);
/* 33 */       AvatarManager.syncAvatarInfo(this.roleId, localRoleAvatar);
/* 34 */       AvatarManager.info("PSyncAvatarInfoWhenSwitchGender.processImp@done|roleid=%d|gender=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.gender) });
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\PSyncAvatarInfoWhenSwitchGender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */