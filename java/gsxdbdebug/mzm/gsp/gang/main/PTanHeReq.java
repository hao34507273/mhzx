/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gang.CTanHeReq;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.SSyncTanHe;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.GangMember;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PTanHeReq
/*     */   extends GangProcedure<CTanHeReq>
/*     */ {
/*     */   public PTanHeReq(CTanHeReq protocol)
/*     */   {
/*  22 */     super(protocol);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean doProcess(long roleId, CTanHeReq protocol)
/*     */   {
/*  28 */     GangMember xGangMember = GangManager.getXGangMember(roleId, false);
/*  29 */     if (xGangMember == null) {
/*  30 */       return false;
/*     */     }
/*  32 */     long gangId = xGangMember.getGangid();
/*  33 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/*  34 */     if (xGang == null) {
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(xGang.getBangzhuid()) }));
/*     */     
/*     */ 
/*  42 */     xGang = GangManager.getXGang(gangId, true);
/*     */     
/*  44 */     if (roleId == xGang.getBangzhuid()) {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if (!GangManager.isInGang(xGang, roleId)) {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     xGangMember = GangManager.getXGangMember(roleId, true);
/*     */     
/*  54 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/*  55 */     if (!dutyCfg.isCanTanHe) {
/*  56 */       return false;
/*     */     }
/*  58 */     if (xGang.getTanheroleid() > 0L) {
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     if (OnlineManager.getInstance().isOnline(xGang.getBangzhuid())) {
/*  64 */       GangManager.sendNormalResult(roleId, 33, new Object[0]);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     long offlineTimeStamp = RoleInterface.getLastLogoffTime(xGang.getBangzhuid());
/*  69 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  70 */     if (GangManager.getDiffDay(offlineTimeStamp, now) < SGangConst.getInstance().TANHE_OFFLINE_D) {
/*  71 */       GangManager.sendNormalResult(roleId, 33, new Object[0]);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     xGang.setTanheroleid(roleId);
/*     */     
/*     */ 
/*  78 */     String userid = RoleInterface.getUserId(roleId);
/*     */     
/*  80 */     long interval = SGangConst.getInstance().TANHE_WAIT_TIME_D * 24 * 60 * 60 * 1000;
/*  81 */     xGang.setTanheendtime(now + interval);
/*  82 */     new GangTanHeObserver(gangId, interval);
/*  83 */     SSyncTanHe sSyncTanHe = new SSyncTanHe();
/*  84 */     sSyncTanHe.roleid = roleId;
/*  85 */     GangManager.broadcast(xGang, sSyncTanHe);
/*  86 */     SGangNormalResult result = new SGangNormalResult();
/*  87 */     result.result = 21;
/*  88 */     OnlineManager.getInstance().send(roleId, result);
/*     */     
/*  90 */     StringBuilder tLogStr = new StringBuilder();
/*  91 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(userid).append("|").append(roleId).append("|").append(xGang.getBangzhuid()).append("|").append(gangId).append("|").append(xGangMember.getDuty()).append("|").append(GangTanheLogEnum.START).append("|").append(xGang.getDisplayid());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */     TLogManager.getInstance().addLog(roleId, "GangTanHe", tLogStr.toString());
/*     */     
/* 101 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PTanHeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */