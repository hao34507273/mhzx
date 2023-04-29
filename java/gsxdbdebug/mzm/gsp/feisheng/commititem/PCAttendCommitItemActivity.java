/*     */ package mzm.gsp.feisheng.commititem;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.feisheng.SAttendCommitItemActivityFail;
/*     */ import mzm.gsp.feisheng.SAttendCommitItemActivitySuccess;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengCommitItemActivityCfg;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivity;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivityArg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCAttendCommitItemActivity
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCAttendCommitItemActivity(long roleid, int activityCfgid)
/*     */   {
/*  41 */     this.roleid = roleid;
/*  42 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!CommitItemActivityManager.isFeiShengCommitItemActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  51 */       onFail(-1, null);
/*  52 */       return false;
/*     */     }
/*  54 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 951, true))
/*     */     {
/*     */ 
/*     */ 
/*  58 */       onFail(-2, null);
/*  59 */       return false;
/*     */     }
/*  61 */     SFeiShengCommitItemActivityCfg cfg = SFeiShengCommitItemActivityCfg.get(this.activityCfgid);
/*  62 */     if (cfg == null)
/*     */     {
/*     */ 
/*  65 */       onFail(-3, null);
/*  66 */       return false;
/*     */     }
/*  68 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  71 */       onFail(-5, null);
/*  72 */       return false;
/*     */     }
/*  74 */     if (!NpcInterface.checkNpcService(cfg.npc_id, cfg.npc_service_id, this.roleid))
/*     */     {
/*     */ 
/*  77 */       onFail(-4, null);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  83 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  85 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  87 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  89 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  92 */       Map<String, Object> extraInfo = new HashMap();
/*  93 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  94 */       onFail(1, extraInfo);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (!CommitItemActivityManager.cutAllNeedItem(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/* 101 */       onFail(2, null);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     if (cfg.award_id > 0)
/*     */     {
/* 107 */       AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, this.roleid, false, true, new AwardReason(LogReason.FEI_SHENG_COMMIT_ITEM_AWARD, this.activityCfgid));
/*     */       
/* 109 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 112 */         onFail(3, null);
/* 113 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 118 */     ActivityInterface.addActivityCount(userid, this.roleid, this.activityCfgid);
/*     */     
/* 120 */     TriggerEventsManger.getInstance().triggerEvent(new RoleCompleteFeiShengSubActivity(), new RoleCompleteFeiShengSubActivityArg(this.roleid, this.activityCfgid));
/*     */     
/*     */ 
/* 123 */     ActivityInterface.tlogActivity(userid, this.roleid, RoleInterface.getLevel(this.roleid), GameServerInfoManager.getHostIP(), this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/* 126 */     SAttendCommitItemActivitySuccess protocol = new SAttendCommitItemActivitySuccess();
/* 127 */     protocol.activity_cfg_id = this.activityCfgid;
/* 128 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 130 */     StringBuilder sb = new StringBuilder();
/* 131 */     sb.append(String.format("[feisheng]PCAttendCommitItemActivity.processImp@attend commit item activity success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/* 134 */     FeiShengManager.logger.info(sb.toString());
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 140 */     StringBuilder sb = new StringBuilder();
/* 141 */     sb.append(String.format("[feisheng]PCAttendCommitItemActivity.processImp@attend commit item activity fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 144 */     if (extraInfo != null)
/*     */     {
/* 146 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 148 */         sb.append("|").append((String)entry.getKey());
/* 149 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 152 */     FeiShengManager.logger.info(sb.toString());
/* 153 */     if (res > 0)
/*     */     {
/* 155 */       SAttendCommitItemActivityFail protocol = new SAttendCommitItemActivityFail();
/* 156 */       protocol.activity_cfg_id = this.activityCfgid;
/* 157 */       protocol.res = res;
/* 158 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\commititem\PCAttendCommitItemActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */