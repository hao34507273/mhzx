/*    */ package mzm.gsp.avatar.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.avatar.confbean.SAvatarCfg;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.RoleAvatar;
/*    */ 
/*    */ public class PGMUnlockAvatar extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int avatarId;
/*    */   
/*    */   public PGMUnlockAvatar(long gmRoleId, long roleId, int avatarId)
/*    */   {
/* 18 */     this.gmRoleId = gmRoleId;
/* 19 */     this.roleId = roleId;
/* 20 */     this.avatarId = avatarId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!AvatarManager.isEnable())
/* 27 */       return false;
/* 28 */     if (GameServerInfoManager.isRoamServer()) {
/* 29 */       return false;
/*    */     }
/* 31 */     SAvatarCfg avatarCfg = SAvatarCfg.get(this.avatarId);
/* 32 */     if (avatarCfg == null) {
/* 33 */       return false;
/*    */     }
/* 35 */     if (!AvatarManager.canUseAvatar(this.roleId, this.avatarId))
/*    */     {
/* 37 */       sendTipAtOnce("解锁失败，门派或性别条件不符");
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     RoleAvatar xRoleAvatar = AvatarManager.getRoleAvatar(this.roleId, true);
/* 42 */     if (xRoleAvatar == null) {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     Integer currentExpireTime = (Integer)xRoleAvatar.get_avatars().get(Integer.valueOf(this.avatarId));
/*    */     int expireTime;
/* 48 */     int expireTime; if (currentExpireTime != null)
/*    */     {
/* 50 */       if (currentExpireTime.intValue() == 0)
/*    */       {
/* 52 */         sendTipAtOnce("头像已解锁");
/* 53 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 57 */       expireTime = currentExpireTime.intValue() + 3600;
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 62 */       expireTime = AvatarManager.getAvatarExpireTimeFromNow(this.avatarId);
/*    */     }
/* 64 */     xRoleAvatar.get_avatars().put(Integer.valueOf(this.avatarId), Integer.valueOf(expireTime));
/* 65 */     sendTipAtOnce("解锁或延长使用期限成功 (1小时)");
/* 66 */     return true;
/*    */   }
/*    */   
/*    */   private void sendTipAtOnce(String message)
/*    */   {
/* 71 */     SGMMessageTipRes protocol = new SGMMessageTipRes();
/* 72 */     protocol.result = Integer.MAX_VALUE;
/* 73 */     protocol.args.add(message);
/* 74 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleId, protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\PGMUnlockAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */