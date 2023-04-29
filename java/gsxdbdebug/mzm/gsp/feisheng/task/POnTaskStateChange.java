/*     */ package mzm.gsp.feisheng.task;
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
/*     */ import mzm.gsp.feisheng.SAttendTaskActivityFail;
/*     */ import mzm.gsp.feisheng.SAttendTaskActivitySuccess;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengTaskActivityCfg;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengTaskActivityGraphidCfg;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivity;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivityArg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnTaskStateChange
/*     */   extends TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if ((SFeiShengTaskActivityGraphidCfg.get(((TaskEventArg)this.arg).graphId) == null) || (((TaskEventArg)this.arg).taskState != 8) || (!((TaskEventArg)this.arg).isToEnd))
/*     */     {
/*     */ 
/*  40 */       return false;
/*     */     }
/*  42 */     long roleid = ((TaskEventArg)this.arg).roleId;
/*  43 */     SFeiShengTaskActivityCfg cfg = SFeiShengTaskActivityCfg.get(SFeiShengTaskActivityGraphidCfg.get(((TaskEventArg)this.arg).graphId).activity_cfg_id);
/*  44 */     if (cfg == null)
/*     */     {
/*     */ 
/*  47 */       return false;
/*     */     }
/*  49 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/*  51 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  53 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*     */     
/*  55 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, cfg.activity_cfg_id);
/*     */     
/*  57 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  60 */       Map<String, Object> extraInfo = new HashMap();
/*  61 */       extraInfo.put("activity_cfg_id", Integer.valueOf(cfg.activity_cfg_id));
/*  62 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  63 */       onFail(1, extraInfo, roleid, cfg.activity_cfg_id);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     if (cfg.award_id > 0)
/*     */     {
/*  69 */       AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, roleid, false, true, new AwardReason(LogReason.FEI_SHENG_TASK_AWARD, cfg.activity_cfg_id));
/*     */       
/*  71 */       if (awardModel == null)
/*     */       {
/*     */ 
/*  74 */         onFail(3, null, roleid, cfg.activity_cfg_id);
/*  75 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  79 */     ActivityInterface.addActivityCount(userid, roleid, cfg.activity_cfg_id);
/*     */     
/*  81 */     TriggerEventsManger.getInstance().triggerEvent(new RoleCompleteFeiShengSubActivity(), new RoleCompleteFeiShengSubActivityArg(roleid, cfg.activity_cfg_id));
/*     */     
/*     */ 
/*  84 */     ActivityInterface.tlogActivity(userid, roleid, RoleInterface.getLevel(roleid), GameServerInfoManager.getHostIP(), cfg.activity_cfg_id, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/*  87 */     SAttendTaskActivitySuccess protocol = new SAttendTaskActivitySuccess();
/*  88 */     protocol.activity_cfg_id = cfg.activity_cfg_id;
/*  89 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */     
/*  91 */     StringBuilder sb = new StringBuilder();
/*  92 */     sb.append(String.format("[feisheng]POnTaskStateChange.processImp@task state change process success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfg.activity_cfg_id) }));
/*     */     
/*     */ 
/*  95 */     FeiShengManager.logger.info(sb.toString());
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo, long roleid, int activityCfgid)
/*     */   {
/* 101 */     StringBuilder sb = new StringBuilder();
/* 102 */     sb.append(String.format("[feisheng]POnTaskStateChange.processImp@task state change process fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 105 */     if (extraInfo != null)
/*     */     {
/* 107 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 109 */         sb.append("|").append((String)entry.getKey());
/* 110 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 113 */     FeiShengManager.logger.info(sb.toString());
/* 114 */     if (res > 0)
/*     */     {
/* 116 */       SAttendTaskActivityFail protocol = new SAttendTaskActivityFail();
/* 117 */       protocol.res = res;
/* 118 */       OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\task\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */