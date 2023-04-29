/*     */ package mzm.gsp.feisheng.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.feisheng.confbean.FeiShengLevelCfg;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengActivityArg;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import xbean.FeiShengInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleFeiShengInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGM_FeiShengOK extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long gmRoleid;
/*     */   private final long roleid;
/*     */   private final int level;
/*     */   
/*     */   public PGM_FeiShengOK(long gmRoleid, long roleid, int level)
/*     */   {
/*  33 */     this.gmRoleid = gmRoleid;
/*  34 */     this.roleid = roleid;
/*  35 */     this.level = level;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     String roleName = RoleInterface.getName(this.roleid);
/*  42 */     if ((roleName == null) || (roleName.isEmpty()))
/*     */     {
/*  44 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("GM指令操作玩家不存在", new Object[0]));
/*  45 */       return false;
/*     */     }
/*  47 */     if (FeiShengLevelCfg.get(this.level) == null)
/*     */     {
/*  49 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("没有%d级飞升活动", new Object[] { Integer.valueOf(this.level) }));
/*  50 */       return false;
/*     */     }
/*  52 */     SFeiShengCfg cfg = SFeiShengCfg.get(FeiShengLevelCfg.get(this.level).activity_cfg_id);
/*  53 */     if (cfg == null)
/*     */     {
/*  55 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("没有%d级飞升活动", new Object[] { Integer.valueOf(this.level) }));
/*  56 */       return false;
/*     */     }
/*  58 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*  60 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("服务器等级不足", new Object[] { Integer.valueOf(this.level) }));
/*  61 */       return false;
/*     */     }
/*  63 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  65 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  67 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  69 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, cfg.activity_cfg_id);
/*     */     
/*  71 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  73 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%s不能参加%d级飞升活动", new Object[] { roleName, Integer.valueOf(this.level) }));
/*  74 */       return false;
/*     */     }
/*  76 */     RoleFeiShengInfo xRoleFeiShengInfo = Role_fei_sheng_infos.get(Long.valueOf(this.roleid));
/*  77 */     if (xRoleFeiShengInfo == null)
/*     */     {
/*  79 */       xRoleFeiShengInfo = Pod.newRoleFeiShengInfo();
/*  80 */       Role_fei_sheng_infos.insert(Long.valueOf(this.roleid), xRoleFeiShengInfo);
/*     */     }
/*  82 */     FeiShengInfo xFeiShengInfo = (FeiShengInfo)xRoleFeiShengInfo.getFei_sheng_infos().get(Integer.valueOf(cfg.activity_cfg_id));
/*  83 */     if (xFeiShengInfo == null)
/*     */     {
/*  85 */       xFeiShengInfo = Pod.newFeiShengInfo();
/*  86 */       xRoleFeiShengInfo.getFei_sheng_infos().put(Integer.valueOf(cfg.activity_cfg_id), xFeiShengInfo);
/*     */     }
/*  88 */     xFeiShengInfo.setIs_activity_complete(true);
/*  89 */     ActivityInterface.addActivityCount(userid, this.roleid, cfg.activity_cfg_id);
/*  90 */     if (TaskInterface.isHaveGraphId(this.roleid, cfg.task_graph_id))
/*     */     {
/*  92 */       TaskInterface.closeActivityGraphWithoutEvent(this.roleid, cfg.task_graph_id);
/*     */     }
/*     */     
/*  95 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.feisheng.event.RoleCompleteFeiShengActivity(), new RoleCompleteFeiShengActivityArg(this.roleid, cfg.activity_cfg_id, cfg.level));
/*     */     
/*     */ 
/*  98 */     ActivityInterface.tlogActivity(userid, this.roleid, RoleInterface.getLevel(this.roleid), GameServerInfoManager.getHostIP(), cfg.activity_cfg_id, ActivityLogStatus.FINISH);
/*     */     
/* 100 */     StringBuilder sb = new StringBuilder();
/* 101 */     sb.append(String.format("[feisheng]PGM_FeiShengOK.processImp@fei sheng activity complete|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(cfg.activity_cfg_id) }));
/*     */     
/* 103 */     FeiShengManager.logger.info(sb.toString());
/* 104 */     if ((!xFeiShengInfo.getHave_get_activity_award()) && (cfg.award_id > 0))
/*     */     {
/* 106 */       mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.award(cfg.award_id, userid, this.roleid, false, true, new AwardReason(mzm.gsp.tlog.LogReason.FEI_SHENG_AWARD, cfg.activity_cfg_id));
/*     */       
/* 108 */       if (awardModel != null)
/*     */       {
/* 110 */         xFeiShengInfo.setHave_get_activity_award(true);
/*     */       }
/*     */     }
/* 113 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%s%d级飞升活动完成", new Object[] { roleName, Integer.valueOf(this.level) }));
/* 114 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\PGM_FeiShengOK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */