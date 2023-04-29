/*     */ package mzm.gsp.feisheng.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengActivityArg;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivityArg;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivityProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import xbean.FeiShengInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFeiShengInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleCompleteFeiShengSubActivity extends RoleCompleteFeiShengSubActivityProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     long roleid = ((RoleCompleteFeiShengSubActivityArg)this.arg).roleid;
/*  31 */     int subActivityCfgid = ((RoleCompleteFeiShengSubActivityArg)this.arg).subActivityCfgid;
/*     */     
/*  33 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/*  35 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  37 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*  38 */     for (SFeiShengCfg cfg : SFeiShengCfg.getAll().values())
/*     */     {
/*  40 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, cfg.activity_cfg_id);
/*     */       
/*  42 */       if ((activityJoinResult.isCanJoin()) && 
/*     */       
/*     */ 
/*     */ 
/*  46 */         (cfg.sub_activity_cfg_ids.contains(Integer.valueOf(subActivityCfgid))))
/*     */       {
/*     */ 
/*     */ 
/*  50 */         boolean isAllSubActivityComplete = true;
/*  51 */         for (Iterator i$ = cfg.sub_activity_cfg_ids.iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */           
/*  53 */           if (ActivityInterface.getActivityCount(userid, roleid, activityCfgid, true) < 1)
/*     */           {
/*  55 */             isAllSubActivityComplete = false;
/*  56 */             break;
/*     */           }
/*     */         }
/*  59 */         if (isAllSubActivityComplete)
/*     */         {
/*     */ 
/*     */ 
/*  63 */           RoleFeiShengInfo xRoleFeiShengInfo = Role_fei_sheng_infos.get(Long.valueOf(roleid));
/*  64 */           if (xRoleFeiShengInfo == null)
/*     */           {
/*  66 */             xRoleFeiShengInfo = Pod.newRoleFeiShengInfo();
/*  67 */             Role_fei_sheng_infos.insert(Long.valueOf(roleid), xRoleFeiShengInfo);
/*     */           }
/*  69 */           FeiShengInfo xFeiShengInfo = (FeiShengInfo)xRoleFeiShengInfo.getFei_sheng_infos().get(Integer.valueOf(cfg.activity_cfg_id));
/*  70 */           if (xFeiShengInfo == null)
/*     */           {
/*  72 */             xFeiShengInfo = Pod.newFeiShengInfo();
/*  73 */             xRoleFeiShengInfo.getFei_sheng_infos().put(Integer.valueOf(cfg.activity_cfg_id), xFeiShengInfo);
/*     */           }
/*  75 */           xFeiShengInfo.setIs_activity_complete(true);
/*  76 */           ActivityInterface.addActivityCount(userid, roleid, cfg.activity_cfg_id);
/*  77 */           if (TaskInterface.isHaveGraphId(roleid, cfg.task_graph_id))
/*     */           {
/*  79 */             TaskInterface.closeActivityGraphWithoutEvent(roleid, cfg.task_graph_id);
/*     */           }
/*     */           
/*  82 */           TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.feisheng.event.RoleCompleteFeiShengActivity(), new RoleCompleteFeiShengActivityArg(roleid, cfg.activity_cfg_id, cfg.level));
/*     */           
/*     */ 
/*  85 */           ActivityInterface.tlogActivity(userid, roleid, RoleInterface.getLevel(roleid), GameServerInfoManager.getHostIP(), cfg.activity_cfg_id, ActivityLogStatus.FINISH);
/*     */           
/*  87 */           StringBuilder sb = new StringBuilder();
/*  88 */           sb.append(String.format("[feisheng]POnRoleCompleteFeiShengSubActivity.processImp@fei sheng activity complete|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfg.activity_cfg_id) }));
/*     */           
/*     */ 
/*  91 */           FeiShengManager.logger.info(sb.toString());
/*  92 */           if ((!xFeiShengInfo.getHave_get_activity_award()) && (cfg.award_id > 0))
/*     */           {
/*  94 */             mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.award(cfg.award_id, userid, roleid, false, true, new AwardReason(mzm.gsp.tlog.LogReason.FEI_SHENG_AWARD, cfg.activity_cfg_id));
/*     */             
/*  96 */             if (awardModel != null)
/*     */             {
/*  98 */               xFeiShengInfo.setHave_get_activity_award(true); }
/*     */           }
/*     */         }
/*     */       } }
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\POnRoleCompleteFeiShengSubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */