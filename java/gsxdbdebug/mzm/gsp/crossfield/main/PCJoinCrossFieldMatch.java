/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.crossfield.SJoinCrossFieldMatchFail;
/*     */ import mzm.gsp.crossfield.SJoinCrossFieldMatchSuccess;
/*     */ import mzm.gsp.crossfield.SSynCrossFieldMatchInfo;
/*     */ import mzm.gsp.crossfield.confbean.SCrossFieldCfg;
/*     */ import mzm.gsp.crossfield.confbean.SCrossFieldConsts;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCJoinCrossFieldMatch
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCJoinCrossFieldMatch(long roleid, int activityCfgid)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!CrossFieldManager.isCrossFieldSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  47 */       onFail(-1, null);
/*  48 */       return false;
/*     */     }
/*  50 */     SCrossFieldCfg cfg = SCrossFieldCfg.get(this.activityCfgid);
/*  51 */     if (cfg == null)
/*     */     {
/*     */ 
/*  54 */       onFail(-3, null);
/*  55 */       return false;
/*     */     }
/*  57 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1584, true))
/*     */     {
/*     */ 
/*  60 */       onFail(-2, null);
/*  61 */       return false;
/*     */     }
/*  63 */     if (!NpcInterface.checkNpcService(SCrossFieldConsts.getInstance().NPC_ID, SCrossFieldConsts.getInstance().ATTEND_ACTIVITY_NPC_SERVICE_ID, this.roleid))
/*     */     {
/*     */ 
/*     */ 
/*  67 */       onFail(-4, null);
/*  68 */       return false;
/*     */     }
/*  70 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  72 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  74 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*  75 */     if (TeamInterface.isRoleInTeam(this.roleid, true))
/*     */     {
/*     */ 
/*  78 */       onFail(2, null);
/*  79 */       return false;
/*     */     }
/*  81 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  83 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  86 */       Map<String, Object> extraInfo = new HashMap();
/*  87 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  88 */       onFail(1, extraInfo);
/*  89 */       return false;
/*     */     }
/*  91 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  92 */     int currentSeason = CrossFieldManager.getCurrentSeason(now);
/*  93 */     if (currentSeason <= 0)
/*     */     {
/*     */ 
/*  96 */       onFail(8, null);
/*  97 */       return false;
/*     */     }
/*  99 */     if ((CrossFieldManager.getRoleActiveLeaveFieldTimestamp(this.roleid) > 0L) && (now - CrossFieldManager.getRoleActiveLeaveFieldTimestamp(this.roleid) < SCrossFieldConsts.getInstance().ACTIVE_LEAVE_FIELD_PUNISH_DURATION_IN_SECOND * 1000L))
/*     */     {
/*     */ 
/*     */ 
/* 103 */       onFail(7, null);
/* 104 */       return false;
/*     */     }
/* 106 */     if ((RoleStatusInterface.containsStatus(this.roleid, 40)) || (RoleStatusInterface.containsStatus(this.roleid, 1581)))
/*     */     {
/*     */ 
/*     */ 
/* 110 */       onFail(3, null);
/* 111 */       return false;
/*     */     }
/* 113 */     if (!CrossFieldManager.setMatchStatus(this.roleid, true))
/*     */     {
/*     */ 
/* 116 */       onFail(-2, null);
/* 117 */       return false;
/*     */     }
/* 119 */     long contextid = CrossServerInterface.joinSingleCrossFieldMatch(CrossFieldManager.createCrossFieldRoamRoleInfo(this.roleid, currentSeason), this.activityCfgid);
/*     */     
/* 121 */     if (contextid < 0L)
/*     */     {
/*     */ 
/* 124 */       onFail(4, null);
/* 125 */       return false;
/*     */     }
/* 127 */     RoleSingleCrossFieldContextManager.getInstance().addContextid(this.roleid, contextid);
/*     */     
/* 129 */     SJoinCrossFieldMatchSuccess sJoinCrossFieldMatchSuccess = new SJoinCrossFieldMatchSuccess();
/* 130 */     sJoinCrossFieldMatchSuccess.activity_cfg_id = this.activityCfgid;
/* 131 */     OnlineManager.getInstance().send(this.roleid, sJoinCrossFieldMatchSuccess);
/*     */     
/* 133 */     SSynCrossFieldMatchInfo sSynCrossFieldMatchInfo = new SSynCrossFieldMatchInfo();
/* 134 */     sSynCrossFieldMatchInfo.activity_cfg_id = this.activityCfgid;
/* 135 */     sSynCrossFieldMatchInfo.process = 0;
/* 136 */     OnlineManager.getInstance().send(this.roleid, sSynCrossFieldMatchInfo);
/*     */     
/* 138 */     CrossFieldManager.logger.info(String.format("[crossfield]PCJoinCrossFieldMatch.processImp@join cross field match success|roleid=%d|activity_cfg_id=%d|season=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(currentSeason) }));
/*     */     
/*     */ 
/* 141 */     CrossFieldTLogManager.addMatchTLog(this.roleid, 1, this.activityCfgid, contextid, -1L);
/*     */     
/* 143 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 148 */     StringBuilder sb = new StringBuilder();
/* 149 */     sb.append(String.format("[crossfield]PCJoinCrossFieldMatch.processImp@join cross field match fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 152 */     if (extraInfo != null)
/*     */     {
/* 154 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 156 */         sb.append("|").append((String)entry.getKey());
/* 157 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 160 */     CrossFieldManager.logger.info(sb.toString());
/* 161 */     if (res > 0)
/*     */     {
/* 163 */       SJoinCrossFieldMatchFail protocol = new SJoinCrossFieldMatchFail();
/* 164 */       protocol.res = res;
/* 165 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\PCJoinCrossFieldMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */