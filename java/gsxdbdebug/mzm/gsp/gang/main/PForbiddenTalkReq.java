/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.gang.SForbiddenTalkRes;
/*     */ import mzm.gsp.gang.SGangNormalResult;
/*     */ import mzm.gsp.gang.SSyncForbiddenTalk;
/*     */ import mzm.gsp.gang.SSyncMemberInfoChange;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.GangMember;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ public class PForbiddenTalkReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long targetRoleid;
/*     */   
/*     */   public PForbiddenTalkReq(long roleId, long targetRoleid)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.targetRoleid = targetRoleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleid) }));
/*     */     
/*  34 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/*  35 */     if (xGangMember == null) {
/*  36 */       return false;
/*     */     }
/*  38 */     GangMember xTarget = Role2gangmember.get(Long.valueOf(this.targetRoleid));
/*  39 */     if (xTarget == null) {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     long gangid = xGangMember.getGangid();
/*     */     
/*  45 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangid));
/*  46 */     if (xGang == null) {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/*  50 */       return false;
/*     */     }
/*  52 */     if (!GangManager.isInGang(xGang, this.targetRoleid)) {
/*  53 */       return false;
/*     */     }
/*  55 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/*  56 */     if (!dutyCfg.isCanForbidden) {
/*  57 */       return false;
/*     */     }
/*  59 */     if (xGang.getForbiddentalkcount() >= SGangConst.getInstance().FORBIDDEN_TALK_COUNT_PER_DAY) {
/*  60 */       SGangNormalResult sGangNormalResult = new SGangNormalResult();
/*  61 */       sGangNormalResult.result = 22;
/*  62 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGangNormalResult);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  67 */     if (xTarget.getForbiddentalkend() > curTime) {
/*  68 */       return false;
/*     */     }
/*  70 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.GANG_FORIBD_TALK_REM);
/*  71 */     if (!mzm.gsp.role.main.RoleInterface.cutVigor(this.roleId, SGangConst.getInstance().FORBIDDEN_TALK_COST_VIGOR, logArg)) {
/*  72 */       return false;
/*     */     }
/*  74 */     long interval = TimeUnit.HOURS.toMillis(SGangConst.getInstance().FORBIDDEN_TALK_TIME_H);
/*  75 */     long forbidEndTime = curTime + interval;
/*  76 */     xTarget.setForbiddentalkend(forbidEndTime);
/*     */     
/*  78 */     new ForbidTalkObserver(interval, this.targetRoleid);
/*     */     
/*  80 */     SSyncForbiddenTalk sSyncForbiddenTalk = new SSyncForbiddenTalk();
/*  81 */     sSyncForbiddenTalk.roleid = this.targetRoleid;
/*  82 */     sSyncForbiddenTalk.managerid = this.roleId;
/*  83 */     GangManager.broadcast(xGang, sSyncForbiddenTalk);
/*     */     
/*  85 */     SSyncMemberInfoChange sSyncMemberInfoChange = new SSyncMemberInfoChange();
/*  86 */     GangManager.fillGangMemberInfo(this.targetRoleid, xTarget, sSyncMemberInfoChange.memberinfo);
/*  87 */     GangManager.broadcast(xGang, sSyncMemberInfoChange);
/*     */     
/*  89 */     xGang.setForbiddentalkcount(xGang.getForbiddentalkcount() + 1);
/*  90 */     SForbiddenTalkRes res = new SForbiddenTalkRes();
/*  91 */     res.costvigor = SGangConst.getInstance().FORBIDDEN_TALK_COST_VIGOR;
/*  92 */     res.lefttime = (SGangConst.getInstance().FORBIDDEN_TALK_COUNT_PER_DAY - xGang.getForbiddentalkcount());
/*  93 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/*  95 */     GangManager.logInfo("PForbiddenTalkReq.processImp@gang forbidden talk success|roleid=%d|gangid=%d|targetroleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(gangid), Long.valueOf(this.targetRoleid) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 100 */     mzm.gsp.gang.cache.GangCacheManager.setMemberForbidTalkEndTime(gangid, this.targetRoleid, forbidEndTime);
/*     */     
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PForbiddenTalkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */