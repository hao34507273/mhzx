/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangMember;
/*     */ import xbean.RoleApplyGang;
/*     */ import xtable.Gangmemory;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ public class PConfirmApplyJoinGangReq extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long targetId;
/*     */   
/*     */   public PConfirmApplyJoinGangReq(long roleId, long targetId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.targetId = targetId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     lock(Role2gangmember.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.targetId) }));
/*     */     
/*  34 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/*  35 */     if (xGangMember == null) {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/*  40 */     if (!dutyCfg.isCanMgeApplyList) {
/*  41 */       if (GangManager.logger.isDebugEnabled()) {
/*  42 */         GangManager.logDebug("PConfirmApplyJoinGangReq.processImp@can not mgeapply!|roleid=%d|targetid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetId) });
/*     */       }
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     GangMember xTargetMember = Role2gangmember.get(Long.valueOf(this.targetId));
/*  48 */     Set<Long> gangIdSet = new java.util.HashSet();
/*  49 */     long gangId = xGangMember.getGangid();
/*  50 */     gangIdSet.add(Long.valueOf(gangId));
/*  51 */     if (xTargetMember != null) {
/*  52 */       gangIdSet.add(Long.valueOf(xTargetMember.getGangid()));
/*     */     }
/*     */     
/*     */ 
/*  56 */     lock(xtable.Gang.getTable(), gangIdSet);
/*  57 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  58 */     if (xGang == null) {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (xTargetMember != null) {
/*  67 */       long oldGangId = xTargetMember.getGangid();
/*  68 */       xbean.Gang xOldGang = xtable.Gang.get(Long.valueOf(oldGangId));
/*  69 */       if ((xOldGang != null) && (GangManager.isInGang(xOldGang, this.targetId))) {
/*  70 */         SGangNormalResult result = new SGangNormalResult();
/*  71 */         result.result = 8;
/*  72 */         OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*  73 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  78 */     xbean.GangMemoryBean xGangMemory = Gangmemory.get(Long.valueOf(gangId));
/*     */     
/*  80 */     RoleApplyGang xTargetApplyGang = GangManager.getXRoleApplyGang(this.targetId, true);
/*     */     
/*  82 */     boolean ret = GangManager.removeApplyRelationAndBroadcast(this.targetId, xTargetApplyGang, gangId, xGang, xGangMemory);
/*     */     
/*  84 */     if (!ret) {
/*  85 */       SGangNormalResult result = new SGangNormalResult();
/*  86 */       result.result = 8;
/*  87 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/*  88 */       GangManager.logInfo("PConfirmApplyJoinGangReq.processImp@already in gang!|gangid=%d|roleid=%d|targetid=%d", new Object[] { Long.valueOf(gangId), Long.valueOf(this.roleId), Long.valueOf(this.targetId) });
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     mzm.gsp.role.main.Role targetRole = RoleInterface.getRole(this.targetId, true);
/*  94 */     int targetAvatarid = AvatarInterface.getCurrentAvatar(this.targetId, true);
/*  95 */     int targetAvatarFrame = AvatarFrameInterface.getCurrentAvatarFrameId(this.targetId, true);
/*  96 */     int targetFightValue = RoleInterface.getRoleMFValue(this.targetId);
/*  97 */     boolean addRes = GangManager.addToGang(targetRole, targetAvatarid, targetAvatarFrame, targetFightValue, xTargetMember, gangId, xGang, this.roleId);
/*     */     
/*  99 */     if (!addRes) {
/* 100 */       if (GangManager.logger.isDebugEnabled()) {
/* 101 */         GangManager.logDebug("PConfirmApplyJoinGangReq.processImp@addtogang fail!|gangid=%d|roleid=%d|targetid=%d", new Object[] { Long.valueOf(gangId), Long.valueOf(this.roleId), Long.valueOf(this.targetId) });
/*     */       }
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 107 */     GangManager.logInfo("PConfirmApplyJoinGangReq.processImp@addtogang success!|gangid=%d|roleid=%d|targetid=%d", new Object[] { Long.valueOf(gangId), Long.valueOf(this.roleId), Long.valueOf(this.targetId) });
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PConfirmApplyJoinGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */