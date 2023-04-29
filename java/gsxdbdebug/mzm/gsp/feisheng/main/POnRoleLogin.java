/*     */ package mzm.gsp.feisheng.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.feisheng.SSynPlayFeiShengEffectInfo;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import xbean.FeiShengInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFeiShengInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  33 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     long roleid = ((Long)this.arg).longValue();
/*  38 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/*  40 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  42 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*  43 */     for (SFeiShengCfg cfg : SFeiShengCfg.getAll().values())
/*     */     {
/*  45 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, cfg.activity_cfg_id);
/*     */       
/*  47 */       if (!activityJoinResult.isCanJoin())
/*     */       {
/*  49 */         if (TaskInterface.isHaveGraphId(roleid, cfg.task_graph_id))
/*     */         {
/*  51 */           TaskInterface.closeActivityGraphWithoutEvent(roleid, cfg.task_graph_id);
/*     */         }
/*  53 */         if (activityJoinResult.isActivityJoinCountMax())
/*     */         {
/*  55 */           RoleFeiShengInfo xRoleFeiShengInfo = Role_fei_sheng_infos.get(Long.valueOf(roleid));
/*  56 */           if (xRoleFeiShengInfo == null)
/*     */           {
/*  58 */             xRoleFeiShengInfo = Pod.newRoleFeiShengInfo();
/*  59 */             Role_fei_sheng_infos.insert(Long.valueOf(roleid), xRoleFeiShengInfo);
/*     */           }
/*  61 */           FeiShengInfo xFeiShengInfo = (FeiShengInfo)xRoleFeiShengInfo.getFei_sheng_infos().get(Integer.valueOf(cfg.activity_cfg_id));
/*  62 */           if (xFeiShengInfo == null)
/*     */           {
/*  64 */             xFeiShengInfo = Pod.newFeiShengInfo();
/*  65 */             xRoleFeiShengInfo.getFei_sheng_infos().put(Integer.valueOf(cfg.activity_cfg_id), xFeiShengInfo);
/*     */           }
/*  67 */           xFeiShengInfo.setIs_activity_complete(true);
/*  68 */           if ((!xFeiShengInfo.getHave_get_activity_award()) && (cfg.award_id > 0))
/*     */           {
/*  70 */             AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, roleid, false, true, new AwardReason(LogReason.FEI_SHENG_AWARD, cfg.activity_cfg_id));
/*     */             
/*  72 */             if (awardModel != null)
/*     */             {
/*  74 */               xFeiShengInfo.setHave_get_activity_award(true);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/*  80 */         boolean isAllSubActivityComplete = true;
/*  81 */         for (Iterator i$ = cfg.sub_activity_cfg_ids.iterator(); i$.hasNext();) { int subActivityCfgid = ((Integer)i$.next()).intValue();
/*     */           
/*  83 */           if (ActivityInterface.getActivityCount(userid, roleid, subActivityCfgid, true) < 1)
/*     */           {
/*  85 */             isAllSubActivityComplete = false;
/*  86 */             break;
/*     */           }
/*     */         }
/*  89 */         if (isAllSubActivityComplete)
/*     */         {
/*     */ 
/*  92 */           RoleFeiShengInfo xRoleFeiShengInfo = Role_fei_sheng_infos.get(Long.valueOf(roleid));
/*  93 */           if (xRoleFeiShengInfo == null)
/*     */           {
/*  95 */             xRoleFeiShengInfo = Pod.newRoleFeiShengInfo();
/*  96 */             Role_fei_sheng_infos.insert(Long.valueOf(roleid), xRoleFeiShengInfo);
/*     */           }
/*  98 */           FeiShengInfo xFeiShengInfo = (FeiShengInfo)xRoleFeiShengInfo.getFei_sheng_infos().get(Integer.valueOf(cfg.activity_cfg_id));
/*  99 */           if (xFeiShengInfo == null)
/*     */           {
/* 101 */             xFeiShengInfo = Pod.newFeiShengInfo();
/* 102 */             xRoleFeiShengInfo.getFei_sheng_infos().put(Integer.valueOf(cfg.activity_cfg_id), xFeiShengInfo);
/*     */           }
/* 104 */           xFeiShengInfo.setIs_activity_complete(true);
/* 105 */           ActivityInterface.addActivityCount(userid, roleid, cfg.activity_cfg_id);
/* 106 */           if (TaskInterface.isHaveGraphId(roleid, cfg.task_graph_id))
/*     */           {
/* 108 */             TaskInterface.closeActivityGraphWithoutEvent(roleid, cfg.task_graph_id);
/*     */           }
/*     */           
/* 111 */           TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.feisheng.event.RoleCompleteFeiShengActivity(), new mzm.gsp.feisheng.event.RoleCompleteFeiShengActivityArg(roleid, cfg.activity_cfg_id, cfg.level));
/*     */           
/*     */ 
/* 114 */           ActivityInterface.tlogActivity(userid, roleid, RoleInterface.getLevel(roleid), GameServerInfoManager.getHostIP(), cfg.activity_cfg_id, mzm.gsp.activity.main.ActivityLogStatus.FINISH);
/*     */           
/* 116 */           StringBuilder sb = new StringBuilder();
/* 117 */           sb.append(String.format("[feisheng]POnRoleLogin.processImp@fei sheng activity complete|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(cfg.activity_cfg_id) }));
/*     */           
/*     */ 
/* 120 */           FeiShengManager.logger.info(sb.toString());
/* 121 */           if ((!xFeiShengInfo.getHave_get_activity_award()) && (cfg.award_id > 0))
/*     */           {
/* 123 */             AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, roleid, false, true, new AwardReason(LogReason.FEI_SHENG_AWARD, cfg.activity_cfg_id));
/*     */             
/* 125 */             if (awardModel != null)
/*     */             {
/* 127 */               xFeiShengInfo.setHave_get_activity_award(true);
/*     */             }
/*     */             
/*     */           }
/*     */           
/*     */         }
/* 133 */         else if ((mzm.gsp.server.main.ServerInterface.getCurrentServerLevel() < cfg.serverlevel) || (!FeiShengManager.isFeiShengActivitySwitchOpenForRole(roleid, cfg.activity_cfg_id)))
/*     */         {
/*     */ 
/* 136 */           if (TaskInterface.isHaveGraphId(roleid, cfg.task_graph_id))
/*     */           {
/* 138 */             TaskInterface.closeActivityGraphWithoutEvent(roleid, cfg.task_graph_id);
/*     */           }
/*     */           
/*     */         }
/* 142 */         else if (!TaskInterface.isHaveGraphId(roleid, cfg.task_graph_id))
/*     */         {
/* 144 */           TaskInterface.activeGraph(Long.valueOf(roleid), cfg.task_graph_id);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 149 */     SSynPlayFeiShengEffectInfo protocol = new SSynPlayFeiShengEffectInfo();
/* 150 */     RoleFeiShengInfo xRoleFeiShengInfo = Role_fei_sheng_infos.get(Long.valueOf(roleid));
/* 151 */     if (xRoleFeiShengInfo == null)
/*     */     {
/* 153 */       for (SFeiShengCfg cfg : SFeiShengCfg.getAll().values())
/*     */       {
/* 155 */         protocol.effect_info.put(Integer.valueOf(cfg.activity_cfg_id), Integer.valueOf(0));
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/* 160 */       for (SFeiShengCfg cfg : SFeiShengCfg.getAll().values())
/*     */       {
/* 162 */         protocol.effect_info.put(Integer.valueOf(cfg.activity_cfg_id), Integer.valueOf((xRoleFeiShengInfo.getFei_sheng_infos().get(Integer.valueOf(cfg.activity_cfg_id)) != null) && (((FeiShengInfo)xRoleFeiShengInfo.getFei_sheng_infos().get(Integer.valueOf(cfg.activity_cfg_id))).getAlready_play_effect()) ? 1 : 0));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 168 */     OnlineManager.getInstance().send(roleid, protocol);
/* 169 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */