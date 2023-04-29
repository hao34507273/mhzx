/*     */ package mzm.gsp.homeland.mysteryvisitor;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.homeland.SAttendMysteryVisitorFail;
/*     */ import mzm.gsp.homeland.SAttendMysteryVisitorSuccess;
/*     */ import mzm.gsp.homeland.confbean.MysteryVisitorConsts;
/*     */ import mzm.gsp.homeland.confbean.SMysteryVisitorTaskCfg;
/*     */ import mzm.gsp.homeland.confbean.STaskMysteryVisitorCfg;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorDisappear;
/*     */ import mzm.gsp.homeland.event.MysteryVisitorDisappearArg;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleMysteryVisitorInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_mystery_visitor_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnTaskStateChange extends TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     if ((SMysteryVisitorTaskCfg.get(((TaskEventArg)this.arg).graphId) == null) || (((TaskEventArg)this.arg).taskState != 8) || (!((TaskEventArg)this.arg).isToEnd))
/*     */     {
/*     */ 
/*  40 */       return false;
/*     */     }
/*  42 */     long roleid = ((TaskEventArg)this.arg).roleId;
/*  43 */     STaskMysteryVisitorCfg cfg = STaskMysteryVisitorCfg.get(SMysteryVisitorTaskCfg.get(((TaskEventArg)this.arg).graphId).mystery_visitor_cfg_id);
/*  44 */     if (cfg == null)
/*     */     {
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!MysteryVisitorManager.isMysteryVisitorSwitchOpenForRole(roleid))
/*     */     {
/*     */ 
/*  53 */       onFail(roleid, cfg.id, -1, null);
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     String userid = RoleInterface.getUserId(roleid);
/*  58 */     long partnerid = MarriageInterface.getMarriedRoleid(roleid, false);
/*  59 */     if (partnerid < 0L)
/*     */     {
/*     */ 
/*  62 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/*  64 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*  65 */       if (MarriageInterface.getMarriedRoleid(roleid, true) >= 0L)
/*     */       {
/*     */ 
/*  68 */         onFail(roleid, cfg.id, 5, null);
/*  69 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  74 */       long marriageid = MarriageInterface.getMarriedId(roleid, false);
/*  75 */       if (marriageid < 0L)
/*     */       {
/*     */ 
/*  78 */         onFail(roleid, cfg.id, 5, null);
/*  79 */         return false;
/*     */       }
/*  81 */       String partnerUserid = RoleInterface.getUserId(partnerid);
/*     */       
/*  83 */       lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserid }));
/*     */       
/*  85 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid), Long.valueOf(partnerid) }));
/*     */       
/*  87 */       lock(xtable.Marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(marriageid) }));
/*  88 */       if ((MarriageInterface.getMarriedRoleid(roleid, true) != partnerid) || (MarriageInterface.getMarriedId(roleid, true) != marriageid))
/*     */       {
/*     */ 
/*     */ 
/*  92 */         onFail(roleid, cfg.id, 5, null);
/*  93 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  97 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/*  99 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/* 102 */       Map<String, Object> extraInfo = new HashMap();
/* 103 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 104 */       onFail(roleid, cfg.id, 1, extraInfo);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     int courdyardAestheticsDegree = HomelandInterface.getCourtYardBeautiful(roleid);
/* 109 */     if (courdyardAestheticsDegree < 0)
/*     */     {
/*     */ 
/* 112 */       onFail(roleid, cfg.id, 4, null);
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     RoleMysteryVisitorInfo xRoleMysteryVisitorInfo = Role_mystery_visitor_infos.get(Long.valueOf(roleid));
/* 117 */     if (xRoleMysteryVisitorInfo == null)
/*     */     {
/*     */ 
/* 120 */       return false;
/*     */     }
/* 122 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() <= 0)
/*     */     {
/*     */ 
/* 125 */       onFail(roleid, cfg.id, 3, null);
/* 126 */       return false;
/*     */     }
/* 128 */     if (xRoleMysteryVisitorInfo.getMystery_visitor_cfg_id() != cfg.id)
/*     */     {
/*     */ 
/* 131 */       onFail(roleid, cfg.id, -4, null);
/* 132 */       return false;
/*     */     }
/* 134 */     if (cfg.award_id > 0)
/*     */     {
/* 136 */       AwardReason awardReason = new AwardReason(LogReason.MYSTERY_VISITOR_AWARD, cfg.award_id);
/* 137 */       AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, roleid, false, true, awardReason);
/* 138 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 141 */         onFail(roleid, cfg.id, 2, null);
/* 142 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 146 */     xRoleMysteryVisitorInfo.setMystery_visitor_cfg_id(-1);
/* 147 */     ActivityInterface.addActivityCount(userid, roleid, MysteryVisitorConsts.getInstance().ACTIVITY_CFG_ID);
/* 148 */     TriggerEventsManger.getInstance().triggerEvent(new MysteryVisitorDisappear(), new MysteryVisitorDisappearArg(roleid));
/*     */     
/* 150 */     SAttendMysteryVisitorSuccess protocol = new SAttendMysteryVisitorSuccess();
/* 151 */     protocol.mystery_visitor_cfg_id = cfg.id;
/* 152 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */     
/* 154 */     StringBuilder sb = new StringBuilder();
/* 155 */     sb.append(String.format("[mysteryvisitor]POnTaskStateChange.processImp@task state change process success|roleid=%d|mystery_visitor_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfg.id) }));
/*     */     
/*     */ 
/* 158 */     MysteryVisitorManager.logger.info(sb.toString());
/* 159 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(long roleid, int mysteryVisitorCfgid, int res, Map<String, Object> extraInfo)
/*     */   {
/* 164 */     StringBuilder sb = new StringBuilder();
/* 165 */     sb.append(String.format("[mysteryvisitor]POnTaskStateChange.processImp@task state change process fail|roleid=%d|mystery_visitor_cfg_id=%d|res=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(mysteryVisitorCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 168 */     if (extraInfo != null)
/*     */     {
/* 170 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 172 */         sb.append("|").append((String)entry.getKey());
/* 173 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 176 */     MysteryVisitorManager.logger.info(sb.toString());
/* 177 */     if (res > 0)
/*     */     {
/* 179 */       SAttendMysteryVisitorFail protocol = new SAttendMysteryVisitorFail();
/* 180 */       protocol.res = res;
/* 181 */       OnlineManager.getInstance().send(roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */