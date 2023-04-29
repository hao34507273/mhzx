/*     */ package mzm.gsp.friend.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.blacklist.main.BlacklistInterface;
/*     */ import mzm.gsp.friend.SWarnAddFriendAutoBan;
/*     */ import mzm.gsp.friend.confbean.SFriendConsts;
/*     */ import mzm.gsp.online.main.ForbidInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.ApplyInfoMap;
/*     */ import xtable.Role2friend;
/*     */ 
/*     */ public class PCAppplyAddFriend extends LogicProcedure
/*     */ {
/*     */   private String content;
/*     */   private long applyerId;
/*     */   private long targetRoleId;
/*     */   
/*     */   public PCAppplyAddFriend(long applyerId, long targetRoleId, String content)
/*     */   {
/*  26 */     this.applyerId = applyerId;
/*  27 */     this.targetRoleId = targetRoleId;
/*  28 */     this.content = content;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!RoleInterface.isRoleExist(this.targetRoleId, false)) {
/*  35 */       RoleFriendManager.sendError(this.applyerId, 13, new String[0]);
/*  36 */       return false;
/*     */     }
/*  38 */     String userid = RoleInterface.getUserId(this.applyerId);
/*  39 */     if (ForbidInfoManager.isForbidUserFriend(userid))
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     if (ForbidInfoManager.isForbidFriend(this.applyerId))
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     boolean ret = RoleStatusInterface.checkCanSetStatus(this.applyerId, 180, true);
/*  48 */     if (!ret) {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     lock(Role2friend.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.applyerId), Long.valueOf(this.targetRoleId) }));
/*  53 */     if (BlacklistInterface.isInBlacklist(this.targetRoleId, this.applyerId))
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     if (!RoleFriendManager.meetLevelRequirementToAddFriend(this.applyerId, this.targetRoleId))
/*     */     {
/*  59 */       RoleFriendManager.sendError(this.applyerId, 22, new String[] { String.valueOf(RoleFriendManager.getAddFriendRequiredLevel(this.targetRoleId)) });
/*     */       
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     BlacklistInterface.delBlackRole(this.applyerId, this.targetRoleId);
/*  66 */     RoleFriend applyRoleFriend = RoleFriendManager.getRoleFriend(this.applyerId, true);
/*  67 */     RoleApply applyRoleApply = RoleFriendManager.getRoleApply(this.applyerId, true);
/*  68 */     RoleFriend targetRoleFriend = RoleFriendManager.getRoleFriend(this.targetRoleId, true);
/*  69 */     RoleApply targetRoleApply = RoleFriendManager.getRoleApply(this.targetRoleId, true);
/*     */     
/*     */ 
/*  72 */     checkAndSendAutoBanWarnning(applyRoleApply);
/*     */     
/*  74 */     return RoleFriendManager.applyAddFriend(applyRoleFriend, applyRoleApply, targetRoleFriend, targetRoleApply, this.content);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void checkAndSendAutoBanWarnning(RoleApply roleApply)
/*     */   {
/*  81 */     if (!OpenInterface.getOpenStatus(324))
/*  82 */       return;
/*  83 */     if (RoleInterface.getLevel(this.applyerId) < SFriendConsts.getInstance().minLevelWarnAddFriendAutoBan)
/*  84 */       return;
/*  85 */     ApplyInfoMap xApplyInfoMap = roleApply.getApplyInfoMap();
/*  86 */     if (xApplyInfoMap == null) {
/*  87 */       return;
/*     */     }
/*     */     
/*  90 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  91 */     if (DateTimeUtils.diffDays(now, xApplyInfoMap.getRefusebanchecktime()) >= SFriendConsts.getInstance().refuseBanDetermineDay)
/*     */     {
/*     */ 
/*  94 */       xApplyInfoMap.setRefusebanchecktime(now);
/*  95 */       xApplyInfoMap.getRefusecountmap().clear();
/*     */     }
/*     */     
/*  98 */     Integer refuseCount = (Integer)xApplyInfoMap.getRefusecountmap().get(Long.valueOf(this.targetRoleId));
/*  99 */     if ((refuseCount != null) && (refuseCount.intValue() == SFriendConsts.getInstance().refuseCountWarnAddFriendAutoBan))
/*     */     {
/* 101 */       SWarnAddFriendAutoBan warn = new SWarnAddFriendAutoBan();
/* 102 */       warn.target_role_id = this.targetRoleId;
/* 103 */       OnlineManager.getInstance().send(this.applyerId, warn);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\PCAppplyAddFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */