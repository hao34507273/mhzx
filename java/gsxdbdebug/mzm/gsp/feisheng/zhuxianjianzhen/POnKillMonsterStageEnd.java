/*     */ package mzm.gsp.feisheng.zhuxianjianzhen;
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
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivity;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivityArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FeiShengZhuXianJianZhenInfo;
/*     */ import xbean.RoleFeiShengZhuXianJianZhenInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_zhu_xian_jian_zhen_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class POnKillMonsterStageEnd
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public POnKillMonsterStageEnd(long roleid, int activityCfgid)
/*     */   {
/*  37 */     this.roleid = roleid;
/*  38 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(this.activityCfgid);
/*  45 */     if (cfg == null)
/*     */     {
/*     */ 
/*  48 */       onFail(-3, null);
/*  49 */       return false;
/*     */     }
/*  51 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  53 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  55 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  57 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  59 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  62 */       Map<String, Object> extraInfo = new HashMap();
/*  63 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  64 */       onFail(1, extraInfo);
/*  65 */       return false;
/*     */     }
/*  67 */     if (!RoleStatusInterface.containsStatus(this.roleid, 959))
/*     */     {
/*     */ 
/*  70 */       onFail(-2, null);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     RoleFeiShengZhuXianJianZhenInfo xRoleFeiShengZhuXianJianZhenInfo = Role_fei_sheng_zhu_xian_jian_zhen_infos.get(Long.valueOf(this.roleid));
/*  75 */     if (xRoleFeiShengZhuXianJianZhenInfo == null)
/*     */     {
/*     */ 
/*  78 */       onFail(-6, null);
/*  79 */       return false;
/*     */     }
/*  81 */     FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo = (FeiShengZhuXianJianZhenInfo)xRoleFeiShengZhuXianJianZhenInfo.getFei_sheng_zhu_xian_jian_zhen_infos().get(Integer.valueOf(this.activityCfgid));
/*     */     
/*  83 */     if (xFeiShengZhuXianJianZhenInfo == null)
/*     */     {
/*     */ 
/*  86 */       onFail(-6, null);
/*  87 */       return false;
/*     */     }
/*  89 */     if (xFeiShengZhuXianJianZhenInfo.getStage() != 2)
/*     */     {
/*     */ 
/*  92 */       onFail(4, null);
/*  93 */       return false;
/*     */     }
/*  95 */     if (xFeiShengZhuXianJianZhenInfo.getKill_monster_num() >= cfg.kill_monster_num)
/*     */     {
/*     */ 
/*  98 */       if ((!xFeiShengZhuXianJianZhenInfo.getHave_get_activity_award()) && (cfg.award_id > 0))
/*     */       {
/* 100 */         AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, this.roleid, false, true, new AwardReason(LogReason.FEI_SHENG_ZHU_XIAN_JIAN_ZHEN_AWARD, this.activityCfgid));
/*     */         
/* 102 */         if (awardModel != null)
/*     */         {
/* 104 */           xFeiShengZhuXianJianZhenInfo.setHave_get_activity_award(true);
/*     */         }
/*     */       }
/*     */       
/* 108 */       ActivityInterface.addActivityCount(userid, this.roleid, this.activityCfgid);
/*     */       
/* 110 */       TriggerEventsManger.getInstance().triggerEvent(new RoleCompleteFeiShengSubActivity(), new RoleCompleteFeiShengSubActivityArg(this.roleid, this.activityCfgid));
/*     */       
/* 112 */       ActivityInterface.tlogActivity(userid, this.roleid, RoleInterface.getLevel(this.roleid), GameServerInfoManager.getHostIP(), this.activityCfgid, ActivityLogStatus.FINISH);
/*     */       
/*     */ 
/* 115 */       ZhuXianJianZhenActivityManager.onKillMonsterStageSuccess(this.roleid, this.activityCfgid, xFeiShengZhuXianJianZhenInfo);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 120 */       ZhuXianJianZhenActivityManager.onKillMonsterStageFail(this.roleid, this.activityCfgid, xFeiShengZhuXianJianZhenInfo);
/*     */     }
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 127 */     StringBuilder sb = new StringBuilder();
/* 128 */     sb.append(String.format("[feisheng]POnKillMonsterStageEnd.processImp@kill monster stage end process fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 131 */     if (extraInfo != null)
/*     */     {
/* 133 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 135 */         sb.append("|").append((String)entry.getKey());
/* 136 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\POnKillMonsterStageEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */