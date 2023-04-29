/*     */ package mzm.gsp.chinesevalentine.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity3.confbean.ChineseValentineConstCfg;
/*     */ import mzm.gsp.chinesevalentine.SChineseValentineJoinFailRep;
/*     */ import mzm.gsp.chinesevalentine.SChineseValentineJoinSuccessRep;
/*     */ import mzm.gsp.confirm.main.TeamConfirmInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCChineseValentineJoinReq extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int activityId;
/*     */   
/*     */   public PCChineseValentineJoinReq(long roleId, int activityId)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  35 */     if (this.activityId != ChineseValentineConstCfg.getInstance().activityId) {
/*  36 */       sendError(3);
/*  37 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  41 */     if (!ChineseValentineManager.isOpen(this.roleId)) {
/*  42 */       sendError(3);
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  48 */     if (null == teamId) {
/*  49 */       sendError(-6);
/*  50 */       return false;
/*     */     }
/*  52 */     List<Long> roleIds = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  53 */     Map<Long, String> roleId2Userid = new HashMap();
/*  54 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*  55 */       roleId2Userid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  58 */     lock(User.getTable(), roleId2Userid.values());
/*  59 */     lock(Basic.getTable(), roleIds);
/*     */     
/*     */ 
/*  62 */     if (!RoleStatusInterface.checkCansetStatus(roleIds, 1761, true, true)) {
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/*  68 */     if (null == teamInfo) {
/*  69 */       sendError(6);
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     if (!teamInfo.isLeader(this.roleId)) {
/*  75 */       sendError(7);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (!teamInfo.isAllTeamMemberNormal()) {
/*  81 */       sendError(8);
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     int normalMembersNum = teamInfo.getTeamNormalMembersNum();
/*  87 */     if ((normalMembersNum != roleIds.size()) || (normalMembersNum != 2)) {
/*  88 */       sendError(1);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(roleId2Userid, roleIds, this.activityId);
/*     */     
/*  95 */     if (!joinResult.isCanJoin()) {
/*  96 */       if (joinResult.isActivityNotOpen()) {
/*  97 */         sendError(3);
/*     */       }
/*  99 */       if (joinResult.isRoleLevelWrong()) {
/* 100 */         sendError(2);
/*     */       }
/* 102 */       if (joinResult.isPerSonCountWrong()) {
/* 103 */         sendError(1);
/*     */       }
/* 105 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 109 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/* 110 */       if (ChineseValentineManager.isInGame(tmpRoleId)) {
/* 111 */         sendError(-10);
/* 112 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 117 */     ChineseValentineConfirmContext context = new ChineseValentineConfirmContext(roleIds, this.activityId);
/* 118 */     TeamConfirmInterface.startTeamConfirm(teamId.longValue(), 7, context);
/*     */     
/*     */ 
/* 121 */     SChineseValentineJoinSuccessRep protocol = new SChineseValentineJoinSuccessRep(this.activityId);
/* 122 */     OnlineManager.getInstance().send(this.roleId, protocol);
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   protected void sendError(int code) {
/* 127 */     SChineseValentineJoinFailRep protocol = new SChineseValentineJoinFailRep(code, this.activityId);
/* 128 */     OnlineManager.getInstance().sendAtOnce(this.roleId, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chinesevalentine\main\PCChineseValentineJoinReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */