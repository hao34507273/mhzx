/*     */ package mzm.gsp.avatar.frame;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.avatar.SUseAvatarFrameUnlockItemFail;
/*     */ import mzm.gsp.avatar.SUseAvatarFrameUnlockItemSuccess;
/*     */ import mzm.gsp.avatar.confbean.SAvatarFrameCfg;
/*     */ import mzm.gsp.avatar.event.OwnedAvatarFrameCountChangedArg.Reason;
/*     */ import mzm.gsp.item.confbean.SAvatarFrameItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleAvatarFrame;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseAvatarFrameUnlockItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long itemUUID;
/*     */   
/*     */   public PUseAvatarFrameUnlockItem(long roleId, long itemUUID)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.itemUUID = itemUUID;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (AvatarFrameManager.isNotEnabled())
/*  39 */       return false;
/*  40 */     if (AvatarFrameManager.inStatusCannotDoRelatedActions(this.roleId))
/*  41 */       return false;
/*  42 */     if (AvatarFrameManager.notMeetRequiredLevel(this.roleId)) {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.itemUUID);
/*  47 */     if (basicItem == null)
/*     */     {
/*  49 */       AvatarFrameLogger.error("PUseAvatarFrameUnlockItem.processImp()@item not exists|roleid=%d|item_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.itemUUID) });
/*     */       
/*  51 */       return false;
/*     */     }
/*  53 */     SAvatarFrameItemCfg itemCfg = SAvatarFrameItemCfg.get(basicItem.getCfgId());
/*  54 */     if (itemCfg == null)
/*     */     {
/*  56 */       AvatarFrameLogger.error("PUseAvatarFrameUnlockItem.processImp()@invalid item|roleid=%d|item_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.itemUUID) });
/*     */       
/*  58 */       return false;
/*     */     }
/*  60 */     int avatarFrameId = itemCfg.avatarFrameId;
/*  61 */     SAvatarFrameCfg cfg = SAvatarFrameCfg.get(avatarFrameId);
/*  62 */     if (cfg == null) {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if ((cfg.genderLimit != 0) && (RoleInterface.getGender(this.roleId) != cfg.genderLimit))
/*     */     {
/*  68 */       notifyFail(2);
/*  69 */       AvatarFrameLogger.error("PUseAvatarFrameUnlockItem.processImp()@gender not matched|roleid=%d|avatar_frame_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfg.id) });
/*     */       
/*     */ 
/*  72 */       return false;
/*     */     }
/*  74 */     if ((cfg.factionLimit != 0) && (RoleInterface.getOccupationId(this.roleId) != cfg.factionLimit))
/*     */     {
/*  76 */       notifyFail(1);
/*  77 */       AvatarFrameLogger.error("PUseAvatarFrameUnlockItem.processImp()@occupation not matched|roleid=%d|avatar_frame_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfg.id) });
/*     */       
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     RoleAvatarFrame xRoleAvatarFrame = AvatarFrameManager.getOrCreateRoleAvatarFrame(this.roleId);
/*     */     
/*     */ 
/*  85 */     Integer currentExpireTime = (Integer)xRoleAvatarFrame.getAvatar_frames().get(Integer.valueOf(avatarFrameId));
/*  86 */     if ((currentExpireTime != null) && (currentExpireTime.intValue() == 0))
/*     */     {
/*  88 */       notifyFail(3);
/*  89 */       AvatarFrameLogger.error("PUseAvatarFrameUnlockItem.processImp()@unlocked forever|roleid=%d|avatar_frame_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfg.id) });
/*     */       
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     if (!ItemInterface.removeItemByUuid(this.roleId, this.itemUUID, 1, new TLogArg(LogReason.UNLOCK_AVATAR_FRAME)))
/*     */     {
/*  97 */       AvatarFrameLogger.error("PUseAvatarFrameUnlockItem.processImp()@remove item failed|roleid=%d|item_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.itemUUID) });
/*     */       
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     int durationSeconds = (int)(itemCfg.duration * 3600L);
/* 103 */     if (durationSeconds == 0)
/*     */     {
/*     */ 
/* 106 */       xRoleAvatarFrame.getAvatar_frames().put(Integer.valueOf(avatarFrameId), Integer.valueOf(0));
/* 107 */       if (currentExpireTime == null)
/*     */       {
/*     */ 
/* 110 */         notifySuccess(avatarFrameId, 0, true);
/* 111 */         AvatarFrameManager.triggerOwnedAvatarFrameCountChanged(this.roleId, OwnedAvatarFrameCountChangedArg.Reason.AVATAR_FRAME_UNLOCKED);
/*     */         
/* 113 */         AvatarFrameLogger.unlockAvatarFrame(this.roleId, avatarFrameId, 0);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 118 */         notifySuccess(avatarFrameId, 0, false);
/* 119 */         AvatarFrameLogger.extendAvatarFrame(this.roleId, avatarFrameId, 0);
/*     */       }
/* 121 */       Map<Integer, Long> xSessionMap = AvatarFrameManager.getRoleAvatarFrameSessionMap(this.roleId, true);
/* 122 */       if (xSessionMap != null)
/* 123 */         AvatarFrameExpireManager.stopSession(xSessionMap, this.roleId, avatarFrameId);
/* 124 */       AvatarFrameLogger.info("PUseAvatarFrameUnlockItem.processImp()@success with forever item|roleid=%d|avatar_frame_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(avatarFrameId) });
/*     */       
/* 126 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     int expireTime;
/*     */     
/* 132 */     if (currentExpireTime == null)
/*     */     {
/*     */ 
/* 135 */       int expireTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + durationSeconds;
/* 136 */       notifySuccess(avatarFrameId, expireTime, true);
/* 137 */       AvatarFrameManager.triggerOwnedAvatarFrameCountChanged(this.roleId, OwnedAvatarFrameCountChangedArg.Reason.AVATAR_FRAME_UNLOCKED);
/*     */       
/* 139 */       AvatarFrameLogger.unlockAvatarFrame(this.roleId, avatarFrameId, expireTime);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 144 */       expireTime = currentExpireTime.intValue() + durationSeconds;
/* 145 */       notifySuccess(avatarFrameId, expireTime, false);
/* 146 */       AvatarFrameLogger.extendAvatarFrame(this.roleId, avatarFrameId, expireTime);
/*     */     }
/* 148 */     xRoleAvatarFrame.getAvatar_frames().put(Integer.valueOf(avatarFrameId), Integer.valueOf(expireTime));
/* 149 */     Map<Integer, Long> xSessionMap = AvatarFrameManager.getOrCreateRoleAvatarFrameSessionMap(this.roleId);
/* 150 */     AvatarFrameExpireManager.startSession(xSessionMap, this.roleId, avatarFrameId, expireTime);
/* 151 */     AvatarFrameLogger.info("PUseAvatarFrameUnlockItem.processImp()@success|roleid=%d|avatar_frame_cfgid=%d|expire_time=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(avatarFrameId), Integer.valueOf(expireTime) });
/*     */     
/* 153 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void notifySuccess(int avatarFrameId, int expireTime, boolean isNew)
/*     */   {
/* 159 */     SUseAvatarFrameUnlockItemSuccess protocol = new SUseAvatarFrameUnlockItemSuccess();
/* 160 */     protocol.avatar_frame_id = avatarFrameId;
/* 161 */     protocol.expire_time = expireTime;
/* 162 */     protocol.is_new = (isNew ? 1 : 0);
/* 163 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */   }
/*     */   
/*     */   private void notifyFail(int retcode)
/*     */   {
/* 168 */     SUseAvatarFrameUnlockItemFail protocol = new SUseAvatarFrameUnlockItemFail();
/* 169 */     protocol.retcode = retcode;
/* 170 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\PUseAvatarFrameUnlockItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */