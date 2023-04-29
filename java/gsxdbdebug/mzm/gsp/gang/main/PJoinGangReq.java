/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.gang.CJoinGangReq;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import xbean.GangMember;
/*     */ import xbean.GangMemoryBean;
/*     */ import xbean.RoleApplyGang;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ public class PJoinGangReq
/*     */   extends GangProcedure<CJoinGangReq>
/*     */ {
/*     */   public PJoinGangReq(CJoinGangReq req)
/*     */   {
/*  25 */     super(req);
/*     */   }
/*     */   
/*     */   protected boolean doProcess(long roleId, CJoinGangReq protocol)
/*     */   {
/*  30 */     long inviter = protocol.inviterid;
/*  31 */     long gangId = protocol.gangid;
/*     */     
/*     */ 
/*  34 */     if (inviter > 0L) {
/*  35 */       lock(Role2gangmember.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(inviter) }));
/*     */     } else {
/*  37 */       lock(Role2gangmember.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     }
/*     */     
/*     */ 
/*  41 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 103, true)) {
/*  42 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(roleId);
/*  43 */       GangManager.logError("PJoinGangReq.processImp@role status cannot join|roleid=%d|status_set=%s", new Object[] { Long.valueOf(roleId), statusSet });
/*     */       
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     Role role = RoleInterface.getRole(roleId, true);
/*  51 */     if (role.getLevel() < SGangConst.getInstance().OPEN_LEVEL) {
/*  52 */       return false;
/*     */     }
/*  54 */     int avatarid = AvatarInterface.getCurrentAvatar(roleId, true);
/*  55 */     int avatarFrame = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, true);
/*  56 */     int fightValue = RoleInterface.getRoleMFValue(roleId);
/*     */     
/*     */ 
/*  59 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/*  60 */     if (xGangMember != null) {
/*  61 */       long oldGangId = xGangMember.getGangid();
/*  62 */       xbean.Gang xOldGang = xtable.Gang.select(Long.valueOf(oldGangId));
/*  63 */       if ((xOldGang != null) && (GangManager.isInGang(xOldGang, roleId))) {
/*  64 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  69 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/*  70 */     if (xGang == null) {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (inviter > 0L)
/*     */     {
/*  76 */       GangMember xInviter = Role2gangmember.get(Long.valueOf(inviter));
/*  77 */       if (xInviter != null) {
/*  78 */         if (xInviter.getGangid() != gangId) {
/*  79 */           return false;
/*     */         }
/*  81 */         SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xInviter);
/*     */         
/*  83 */         if (dutyCfg.isCanMgeApplyList) {
/*  84 */           boolean addRes = GangManager.addToGang(role, avatarid, avatarFrame, fightValue, xGangMember, gangId, xGang, inviter);
/*     */           
/*  86 */           if (!addRes) {
/*  87 */             GangManager.logError("PJoinGangReq.doProcess@addtogang fail!|roleid=%d|inviter=%d|gangid=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(inviter), Long.valueOf(gangId) });
/*     */             
/*     */ 
/*  90 */             return false;
/*     */           }
/*  92 */           GangManager.logInfo("PJoinGangReq.doProcess@addtogang succeed!|roleid=%d|inviter=%d|gangid=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(inviter), Long.valueOf(gangId) });
/*     */           
/*     */ 
/*  95 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 101 */     GangMemoryBean xGangMemory = GangManager.getAndCreateXGangMemory(gangId);
/*     */     
/* 103 */     RoleApplyGang xApplyGang = GangManager.getAndCreateXRoleApplyGang(roleId);
/*     */     
/* 105 */     boolean ret = GangManager.addApplyRelationAndBroadcast(gangId, xGang, xGangMemory, roleId, xApplyGang, inviter);
/*     */     
/* 107 */     if (ret) {
/* 108 */       SGangNormalResult result = new SGangNormalResult();
/* 109 */       result.result = 13;
/* 110 */       OnlineManager.getInstance().send(roleId, result);
/*     */     }
/*     */     else {
/* 113 */       SGangNormalResult result = new SGangNormalResult();
/* 114 */       result.result = 9;
/* 115 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/*     */     }
/*     */     
/* 118 */     GangManager.logInfo("PJoinGangReq.doProcess@addtogang success!|roleid=%d|gangid=%d|inviter=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(gangId), Long.valueOf(inviter) });
/*     */     
/*     */ 
/*     */ 
/* 122 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PJoinGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */