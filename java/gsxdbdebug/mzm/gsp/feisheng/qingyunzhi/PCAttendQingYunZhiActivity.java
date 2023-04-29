/*     */ package mzm.gsp.feisheng.qingyunzhi;
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
/*     */ import mzm.gsp.feisheng.SAttendQingYunZhiActivityFail;
/*     */ import mzm.gsp.feisheng.SAttendQingYunZhiActivitySuccess;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengQingYunZhiActivityCfg;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivity;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivityArg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingyunzhi.main.QingInterface;
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
/*     */ public class PCAttendQingYunZhiActivity
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCAttendQingYunZhiActivity(long roleid, int activityCfgid)
/*     */   {
/*  42 */     this.roleid = roleid;
/*  43 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (!QingYunZhiActivityManager.isFeiShengQingYunZhiActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  52 */       onFail(-1, null);
/*  53 */       return false;
/*     */     }
/*  55 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 956, true))
/*     */     {
/*     */ 
/*     */ 
/*  59 */       onFail(-2, null);
/*  60 */       return false;
/*     */     }
/*  62 */     SFeiShengQingYunZhiActivityCfg cfg = SFeiShengQingYunZhiActivityCfg.get(this.activityCfgid);
/*  63 */     if (cfg == null)
/*     */     {
/*     */ 
/*  66 */       onFail(-3, null);
/*  67 */       return false;
/*     */     }
/*  69 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  72 */       onFail(-5, null);
/*  73 */       return false;
/*     */     }
/*  75 */     if (!NpcInterface.checkNpcService(cfg.npc_id, cfg.npc_service_id, this.roleid))
/*     */     {
/*     */ 
/*  78 */       onFail(-4, null);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  84 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  86 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  88 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  90 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  93 */       Map<String, Object> extraInfo = new HashMap();
/*  94 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  95 */       onFail(1, extraInfo);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     if (!QingInterface.isPassed(this.roleid, cfg.challenge_type, cfg.chapter_id, cfg.section_id, true))
/*     */     {
/*     */ 
/* 102 */       onFail(2, null);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     if (cfg.award_id > 0)
/*     */     {
/* 108 */       AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, this.roleid, false, true, new AwardReason(LogReason.FEI_SHENG_QING_YUN_ZHI_AWARD, this.activityCfgid));
/*     */       
/* 110 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 113 */         onFail(3, null);
/* 114 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 119 */     ActivityInterface.addActivityCount(userid, this.roleid, this.activityCfgid);
/*     */     
/* 121 */     TriggerEventsManger.getInstance().triggerEvent(new RoleCompleteFeiShengSubActivity(), new RoleCompleteFeiShengSubActivityArg(this.roleid, this.activityCfgid));
/*     */     
/*     */ 
/* 124 */     ActivityInterface.tlogActivity(userid, this.roleid, RoleInterface.getLevel(this.roleid), GameServerInfoManager.getHostIP(), this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/* 127 */     SAttendQingYunZhiActivitySuccess protocol = new SAttendQingYunZhiActivitySuccess();
/* 128 */     protocol.activity_cfg_id = this.activityCfgid;
/* 129 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 131 */     StringBuilder sb = new StringBuilder();
/* 132 */     sb.append(String.format("[feisheng]PCAttendQingYunZhiActivity.processImp@attend qing yun zhi activity success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/* 135 */     FeiShengManager.logger.info(sb.toString());
/* 136 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 141 */     StringBuilder sb = new StringBuilder();
/* 142 */     sb.append(String.format("[feisheng]PCAttendQingYunZhiActivity.processImp@attend qing yun zhi activity fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 145 */     if (extraInfo != null)
/*     */     {
/* 147 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 149 */         sb.append("|").append((String)entry.getKey());
/* 150 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 153 */     FeiShengManager.logger.info(sb.toString());
/* 154 */     if (res > 0)
/*     */     {
/* 156 */       SAttendQingYunZhiActivityFail protocol = new SAttendQingYunZhiActivityFail();
/* 157 */       protocol.res = res;
/* 158 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\qingyunzhi\PCAttendQingYunZhiActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */