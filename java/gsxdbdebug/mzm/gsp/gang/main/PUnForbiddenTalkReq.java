/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SSyncMemberInfoChange;
/*    */ import mzm.gsp.gang.SSyncUnForbiddenTalk;
/*    */ import mzm.gsp.gang.SUnForbiddenTalkRes;
/*    */ import mzm.gsp.gang.cache.GangCacheManager;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PUnForbiddenTalkReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long targetRoleid;
/*    */   
/*    */   public PUnForbiddenTalkReq(long roleId, long targetRoleid)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.targetRoleid = targetRoleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     GangMember xGangMember = Role2gangmember.select(Long.valueOf(this.roleId));
/* 30 */     if (xGangMember == null) {
/* 31 */       return false;
/*    */     }
/* 33 */     long gangId = xGangMember.getGangid();
/*    */     
/* 35 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangId));
/* 36 */     if (xGang == null) {
/* 37 */       return false;
/*    */     }
/* 39 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/* 40 */       return false;
/*    */     }
/* 42 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/* 43 */     if (!dutyCfg.isCanForbidden) {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     GangMember xTarget = Role2gangmember.get(Long.valueOf(this.targetRoleid));
/* 48 */     if (xTarget == null) {
/* 49 */       return false;
/*    */     }
/* 51 */     if (xTarget.getGangid() != gangId) {
/* 52 */       return false;
/*    */     }
/* 54 */     if (!GangManager.isInGang(xGang, this.targetRoleid)) {
/* 55 */       return false;
/*    */     }
/* 57 */     SGangDutyCfg targetDuty = GangManager.getDutyCfg(xTarget);
/* 58 */     if (targetDuty.dutyLevel <= dutyCfg.dutyLevel) {
/* 59 */       return false;
/*    */     }
/* 61 */     if (xTarget.getForbiddentalkend() < DateTimeUtils.getCurrTimeInMillis()) {
/* 62 */       return false;
/*    */     }
/* 64 */     xTarget.setForbiddentalkend(0L);
/*    */     
/* 66 */     SUnForbiddenTalkRes res = new SUnForbiddenTalkRes();
/* 67 */     res.roleid = this.targetRoleid;
/* 68 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 70 */     SSyncUnForbiddenTalk sSyncUnForbiddenTalk = new SSyncUnForbiddenTalk();
/* 71 */     sSyncUnForbiddenTalk.managerid = this.roleId;
/* 72 */     sSyncUnForbiddenTalk.roleid = this.targetRoleid;
/* 73 */     GangManager.broadcast(xGang, sSyncUnForbiddenTalk);
/*    */     
/* 75 */     SSyncMemberInfoChange sSyncMemberInfoChange = new SSyncMemberInfoChange();
/* 76 */     GangManager.fillGangMemberInfo(this.targetRoleid, xTarget, sSyncMemberInfoChange.memberinfo);
/* 77 */     GangManager.broadcast(xGang, sSyncMemberInfoChange);
/*    */     
/* 79 */     GangManager.logInfo("PUnForbiddenTalkReq.processImp@gang unforbidden talk succeed|operaterid=%d|gangid=%d|gang_memberid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(gangId), Long.valueOf(this.targetRoleid) });
/*    */     
/*    */ 
/* 82 */     GangCacheManager.setMemberForbidTalkEndTime(gangId, this.targetRoleid, 0L);
/*    */     
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PUnForbiddenTalkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */