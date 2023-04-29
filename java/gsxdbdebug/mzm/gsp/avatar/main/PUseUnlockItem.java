/*     */ package mzm.gsp.avatar.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.avatar.event.OwnedAvatarCountChangedArg.Reason;
/*     */ import mzm.gsp.item.confbean.SAvatarUnlockCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleAvatar;
/*     */ import xbean.RoleAvatarSessionInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseUnlockItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final List<Integer> itemKeys;
/*     */   
/*     */   public PUseUnlockItem(long roleId, List<Integer> itemKeys)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.itemKeys = itemKeys;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (this.itemKeys.size() == 0)
/*  37 */       return false;
/*  38 */     if (!AvatarManager.isEnable())
/*  39 */       return false;
/*  40 */     if (!AvatarManager.checkRoleLevel(this.roleId))
/*  41 */       return false;
/*  42 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1751, false)) {
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     int avatarId = 0;
/*  47 */     boolean hasItemCanUnlockForever = false;
/*  48 */     for (Integer itemKey : this.itemKeys)
/*     */     {
/*  50 */       BasicItem item = ItemInterface.getItem(this.roleId, itemKey.intValue());
/*  51 */       if (item == null)
/*     */       {
/*  53 */         AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 2);
/*  54 */         AvatarManager.info("PUseUnlockItem.processImp@no item|roleid=%d|item_key=%d", new Object[] { Long.valueOf(this.roleId), itemKey });
/*  55 */         return false;
/*     */       }
/*  57 */       int itemId = item.getCfgId();
/*  58 */       SAvatarUnlockCfg unlockCfg = SAvatarUnlockCfg.get(itemId);
/*  59 */       if (unlockCfg == null)
/*     */       {
/*  61 */         AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 0);
/*  62 */         AvatarManager.info("PUseUnlockItem.processImp@invalid item|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemId) });
/*  63 */         return false;
/*     */       }
/*  65 */       if (unlockCfg.duration == 0)
/*     */       {
/*  67 */         hasItemCanUnlockForever = true;
/*     */       }
/*  69 */       if (avatarId == 0)
/*     */       {
/*  71 */         avatarId = unlockCfg.avatarId;
/*     */       }
/*  73 */       else if (avatarId != unlockCfg.avatarId)
/*     */       {
/*  75 */         AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 4);
/*  76 */         AvatarManager.info("PUseUnlockItem.processImp@items related to different avatar|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  77 */         return false;
/*     */       }
/*     */     }
/*  80 */     if ((hasItemCanUnlockForever) && (this.itemKeys.size() > 1))
/*     */     {
/*  82 */       AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 5);
/*  83 */       AvatarManager.info("PUseUnlockItem.processImp@multiple items with one can unlock forever|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     if (!AvatarManager.canUseAvatar(this.roleId, avatarId))
/*     */     {
/*  90 */       AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 3);
/*  91 */       AvatarManager.info("PUseUnlockItem.processImp()@cannot use|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(avatarId) });
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (hasItemCanUnlockForever)
/*     */     {
/*  97 */       return useUnlockForeverItem(avatarId, ((Integer)this.itemKeys.get(0)).intValue());
/*     */     }
/*     */     
/*     */ 
/* 101 */     return useMultipleUnlockItem(avatarId, this.itemKeys);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean useUnlockForeverItem(int avatarId, int itemKey)
/*     */   {
/* 110 */     RoleAvatar xRoleAvatar = AvatarManager.getOrCreateRoleAvatar(this.roleId);
/* 111 */     RoleAvatarSessionInfo xSessionInfo = AvatarManager.getOrCreateRoleAvatarSessionInfo(this.roleId);
/* 112 */     Integer currentExpireTime = (Integer)xRoleAvatar.get_avatars().get(Integer.valueOf(avatarId));
/* 113 */     if (currentExpireTime != null)
/*     */     {
/* 115 */       if (currentExpireTime.intValue() == 0)
/*     */       {
/*     */ 
/* 118 */         AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 1);
/* 119 */         AvatarManager.info("PUseUnlockItem.useUnlockForeverItem()@already unlocked|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(avatarId) });
/*     */         
/* 121 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 126 */       AvatarManager.notifyExtendedAvatars(this.roleId, avatarId, 0);
/* 127 */       AvatarManager.tlogExtendAvatar(this.roleId, avatarId, 0);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 133 */       AvatarManager.triggerOwnedAvatarCountChangedEvent(this.roleId, OwnedAvatarCountChangedArg.Reason.AVATAR_UNLOCKED);
/* 134 */       AvatarManager.notifyNewAvatar(this.roleId, avatarId, 0);
/* 135 */       AvatarManager.tlogUnlockAvatar(this.roleId, avatarId, 0);
/*     */     }
/* 137 */     xRoleAvatar.get_avatars().put(Integer.valueOf(avatarId), Integer.valueOf(0));
/*     */     
/*     */ 
/* 140 */     if (!ItemInterface.removeItemByGrid(this.roleId, 340600000, itemKey, 1, new TLogArg(LogReason.UNLOCK_AVATAR)))
/*     */     {
/* 142 */       AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 2);
/* 143 */       AvatarManager.info("PUseUnlockItem.processImp()@no item|role_id=%d|item_key=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemKey) });
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     if (currentExpireTime != null)
/*     */     {
/* 149 */       AvatarExpireSession.stopSession(this.roleId, avatarId, xSessionInfo);
/*     */     }
/* 151 */     AvatarManager.info("PUseUnlockItem.useUnlockForeverItem()@success|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(avatarId) });
/* 152 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean useMultipleUnlockItem(int avatarId, List<Integer> itemKeys)
/*     */   {
/* 161 */     RoleAvatar xRoleAvatar = AvatarManager.getOrCreateRoleAvatar(this.roleId);
/* 162 */     Integer currentExpireTime = (Integer)xRoleAvatar.get_avatars().get(Integer.valueOf(avatarId));
/* 163 */     if ((currentExpireTime != null) && (currentExpireTime.intValue() == 0))
/*     */     {
/*     */ 
/* 166 */       AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 1);
/* 167 */       AvatarManager.info("PUseUnlockItem.processImp()@already unlocked|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(avatarId) });
/* 168 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 172 */     int durationInHours = 0;
/* 173 */     for (Integer itemKey : itemKeys)
/*     */     {
/* 175 */       BasicItem item = ItemInterface.getItem(this.roleId, itemKey.intValue());
/* 176 */       if (item == null)
/*     */       {
/* 178 */         AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 2);
/* 179 */         AvatarManager.info("PUseUnlockItem.useMultipleUnlockItem()@no item|roleid=%d|item_key=%d", new Object[] { Long.valueOf(this.roleId), itemKey });
/* 180 */         return false;
/*     */       }
/* 182 */       int itemId = item.getCfgId();
/* 183 */       SAvatarUnlockCfg unlockCfg = SAvatarUnlockCfg.get(itemId);
/* 184 */       if (unlockCfg == null)
/*     */       {
/* 186 */         AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 0);
/* 187 */         AvatarManager.info("PUseUnlockItem.useMultipleUnlockItem()@invalid item|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemId) });
/*     */         
/* 189 */         return false;
/*     */       }
/* 191 */       durationInHours += unlockCfg.duration * item.getNumber();
/*     */     }
/*     */     
/*     */     int expireTime;
/* 195 */     if (currentExpireTime != null)
/*     */     {
/*     */ 
/* 198 */       int expireTime = currentExpireTime.intValue() + (int)(durationInHours * 3600L);
/* 199 */       AvatarManager.notifyExtendedAvatars(this.roleId, avatarId, expireTime);
/* 200 */       AvatarManager.tlogExtendAvatar(this.roleId, avatarId, expireTime);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 205 */       int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 206 */       expireTime = now + (int)(durationInHours * 3600L);
/* 207 */       AvatarManager.triggerOwnedAvatarCountChangedEvent(this.roleId, OwnedAvatarCountChangedArg.Reason.AVATAR_UNLOCKED);
/* 208 */       AvatarManager.notifyNewAvatar(this.roleId, avatarId, expireTime);
/* 209 */       AvatarManager.tlogUnlockAvatar(this.roleId, avatarId, expireTime);
/*     */     }
/* 211 */     xRoleAvatar.get_avatars().put(Integer.valueOf(avatarId), Integer.valueOf(expireTime));
/*     */     
/*     */ 
/* 214 */     for (Integer itemKey : itemKeys)
/*     */     {
/* 216 */       if (!ItemInterface.removeItemByGrid(this.roleId, 340600000, itemKey.intValue(), new TLogArg(LogReason.UNLOCK_AVATAR)))
/*     */       {
/* 218 */         AvatarManager.sendUseUnlockItemFailAtOnce(this.roleId, 2);
/* 219 */         AvatarManager.info("PUseUnlockItem.useMultipleUnlockItem()@no item|role_id=%d|item_key=%d", new Object[] { Long.valueOf(this.roleId), itemKey });
/* 220 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 224 */     AvatarExpireSession.startSession(this.roleId, avatarId, expireTime);
/* 225 */     AvatarManager.info("PUseUnlockItem.useMultipleUnlockItem()@success|roleid=%d|avatar_cfgid=%d|expire_time=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(avatarId), Integer.valueOf(expireTime) });
/*     */     
/* 227 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\PUseUnlockItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */