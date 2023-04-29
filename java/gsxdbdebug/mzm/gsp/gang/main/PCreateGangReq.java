/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.gang.CCreateGangReq;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCreateGangReq
/*     */   extends GangProcedure<CCreateGangReq>
/*     */ {
/*     */   public PCreateGangReq(CCreateGangReq protocol)
/*     */   {
/*  33 */     super(protocol);
/*     */   }
/*     */   
/*     */   protected boolean doProcess(long roleId, CCreateGangReq protocol)
/*     */   {
/*  38 */     if (GameServerInfoManager.isRoamServer()) {
/*  39 */       GangManager.logError("PCreateGangReq.doProcess@roam server cannot create gang|roleid=%d", new Object[] { Long.valueOf(roleId) });
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     String name = protocol.name;
/*  44 */     String purpose = protocol.purpose;
/*     */     
/*     */ 
/*  47 */     String userid = RoleInterface.getUserId(this.roleId);
/*  48 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*  51 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 101, true)) {
/*  52 */       Set<Integer> statusSet = RoleStatusInterface.getStatusSet(roleId);
/*  53 */       GangManager.logError("PCreateGangReq.processImp@role status cannot create|roleid=%d|status_set=%s", new Object[] { Long.valueOf(roleId), statusSet });
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     Role role = RoleInterface.getRole(roleId, true);
/*  61 */     if (role.getLevel() < SGangConst.getInstance().CREATE_NEED_ROLE_LEVEL) {
/*  62 */       return false;
/*     */     }
/*  64 */     if (ServerInterface.getCurrentServerLevel() < SGangConst.getInstance().CREATE_SERVER_LEVEL) {
/*  65 */       return false;
/*     */     }
/*  67 */     if (QingfuInterface.costYuanbao(userid, roleId, SGangConst.getInstance().CREATE_NEED_YUANBAO, CostType.COST_BIND_FIRST_GANG_CREATE, new TLogArg(LogReason.GANG_CREATE_YUANBAO_REM)) != CostResult.Success) {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     long gangId = GangManager.createGang(roleId, name, purpose);
/*  72 */     if (gangId < 0L) {
/*  73 */       if (gangId == -3L) {
/*  74 */         SGangNormalResult result = new SGangNormalResult();
/*  75 */         result.result = 18;
/*  76 */         OnlineManager.getInstance().sendAtOnce(roleId, result);
/*  77 */       } else if (gangId == -4L) {
/*  78 */         SGangNormalResult result = new SGangNormalResult();
/*  79 */         result.result = 31;
/*  80 */         OnlineManager.getInstance().sendAtOnce(roleId, result);
/*  81 */       } else if (gangId == -1L) {
/*  82 */         SGangNormalResult result = new SGangNormalResult();
/*  83 */         result.result = 0;
/*  84 */         OnlineManager.getInstance().sendAtOnce(roleId, result);
/*  85 */       } else if (gangId == -2L) {
/*  86 */         SGangNormalResult result = new SGangNormalResult();
/*  87 */         result.result = 1;
/*  88 */         OnlineManager.getInstance().sendAtOnce(roleId, result);
/*     */       }
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     SGangNormalResult result = new SGangNormalResult();
/*  94 */     result.result = 3;
/*  95 */     OnlineManager.getInstance().send(roleId, result);
/*  96 */     SBulletinInfo bulletinInfo = new SBulletinInfo();
/*  97 */     bulletinInfo.bulletintype = 8;
/*  98 */     bulletinInfo.params.put(Integer.valueOf(8), name);
/*  99 */     bulletinInfo.params.put(Integer.valueOf(9), gangId + "");
/* 100 */     BulletinInterface.sendBulletin(bulletinInfo);
/*     */     
/* 102 */     long displayId = 0L;
/*     */     
/* 104 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/* 105 */     if (xGang != null) {
/* 106 */       displayId = xGang.getDisplayid();
/*     */     }
/* 108 */     StringBuilder tLogStr = new StringBuilder();
/*     */     
/* 110 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(roleId)).append("|").append(roleId).append("|").append(RoleInterface.getLevel(roleId)).append("|").append(gangId).append("|").append(displayId).append("|").append(GangActionLogEnum.CREATE);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 117 */     TLogManager.getInstance().addLog(roleId, "Gang", tLogStr.toString());
/*     */     
/* 119 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCreateGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */