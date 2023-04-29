/*     */ package mzm.gsp.feisheng.zhuxianjianzhen;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.feisheng.SSynZhuXianJianZhenActivityStageInfo;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.FeiShengZhuXianJianZhenInfo;
/*     */ import xbean.RoleFeiShengZhuXianJianZhenInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_zhu_xian_jian_zhen_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     long roleid = ((Long)this.arg).longValue();
/*     */     
/*  31 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/*  33 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  35 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*     */     
/*  37 */     if (!RoleStatusInterface.containsStatus(roleid, 959))
/*     */     {
/*  39 */       RoleFeiShengZhuXianJianZhenInfo xRoleFeiShengZhuXianJianZhenInfo = Role_fei_sheng_zhu_xian_jian_zhen_infos.get(Long.valueOf(roleid));
/*  40 */       if (xRoleFeiShengZhuXianJianZhenInfo == null)
/*     */       {
/*  42 */         return false;
/*     */       }
/*  44 */       for (Map.Entry<Integer, FeiShengZhuXianJianZhenInfo> entry : xRoleFeiShengZhuXianJianZhenInfo.getFei_sheng_zhu_xian_jian_zhen_infos().entrySet())
/*     */       {
/*  46 */         int activityCfgid = ((Integer)entry.getKey()).intValue();
/*  47 */         FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo = (FeiShengZhuXianJianZhenInfo)entry.getValue();
/*  48 */         SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/*  49 */         if (cfg != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  55 */           xFeiShengZhuXianJianZhenInfo.setStage(0);
/*  56 */           xFeiShengZhuXianJianZhenInfo.setWorld_id(-1L);
/*  57 */           xFeiShengZhuXianJianZhenInfo.setCommit_item_num(0);
/*  58 */           xFeiShengZhuXianJianZhenInfo.setKill_monster_num(0);
/*  59 */           xFeiShengZhuXianJianZhenInfo.setSession_id(-1L);
/*     */           
/*  61 */           ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid);
/*     */           
/*  63 */           if (!activityJoinResult.isActivityJoinCountMax())
/*     */           {
/*     */ 
/*  66 */             if ((!xFeiShengZhuXianJianZhenInfo.getHave_get_activity_award()) && (cfg.award_id > 0))
/*     */             {
/*  68 */               AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, roleid, false, true, new AwardReason(LogReason.FEI_SHENG_ZHU_XIAN_JIAN_ZHEN_AWARD, activityCfgid));
/*     */               
/*  70 */               if (awardModel != null)
/*     */               {
/*  72 */                 xFeiShengZhuXianJianZhenInfo.setHave_get_activity_award(true);
/*     */               }
/*     */               
/*     */             }
/*     */           }
/*  77 */           else if (activityJoinResult.isCanJoin())
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*  82 */             SSynZhuXianJianZhenActivityStageInfo protocol = new SSynZhuXianJianZhenActivityStageInfo();
/*  83 */             protocol.activity_cfg_id = ((Integer)entry.getKey()).intValue();
/*  84 */             protocol.stage = ((FeiShengZhuXianJianZhenInfo)entry.getValue()).getStage();
/*  85 */             protocol.state = 2;
/*  86 */             protocol.result = 0;
/*  87 */             protocol.commit_item_num = ((FeiShengZhuXianJianZhenInfo)entry.getValue()).getCommit_item_num();
/*  88 */             protocol.kill_monster_num = ((FeiShengZhuXianJianZhenInfo)entry.getValue()).getKill_monster_num();
/*  89 */             protocol.stage_collect_item_start_timestamp = ((int)(((FeiShengZhuXianJianZhenInfo)entry.getValue()).getStage_collect_item_start_timestamp() / 1000L));
/*  90 */             protocol.stage_collect_item_start_timestamp = ((int)(((FeiShengZhuXianJianZhenInfo)entry.getValue()).getStage_kill_monster_start_timestamp() / 1000L));
/*  91 */             long now = DateTimeUtils.getCurrTimeInMillis();
/*  92 */             if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */             {
/*     */ 
/*  95 */               xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/*  96 */               xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */             }
/*  98 */             protocol.daily_try_times = xFeiShengZhuXianJianZhenInfo.getDaily_try_times();
/*  99 */             OnlineManager.getInstance().send(roleid, protocol);
/*     */           }
/*     */         }
/*     */       }
/*     */     } else {
/* 104 */       RoleFeiShengZhuXianJianZhenInfo xRoleFeiShengZhuXianJianZhenInfo = Role_fei_sheng_zhu_xian_jian_zhen_infos.get(Long.valueOf(roleid));
/* 105 */       if (xRoleFeiShengZhuXianJianZhenInfo == null)
/*     */       {
/* 107 */         RoleStatusInterface.unsetStatus(roleid, 959);
/* 108 */         return true;
/*     */       }
/* 110 */       for (Map.Entry<Integer, FeiShengZhuXianJianZhenInfo> entry : xRoleFeiShengZhuXianJianZhenInfo.getFei_sheng_zhu_xian_jian_zhen_infos().entrySet())
/*     */       {
/* 112 */         int activityCfgid = ((Integer)entry.getKey()).intValue();
/* 113 */         FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo = (FeiShengZhuXianJianZhenInfo)entry.getValue();
/* 114 */         SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/* 115 */         if (cfg != null)
/*     */         {
/*     */ 
/*     */ 
/* 119 */           ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid);
/*     */           
/* 121 */           if (activityJoinResult.isActivityJoinCountMax())
/*     */           {
/*     */ 
/* 124 */             if ((!xFeiShengZhuXianJianZhenInfo.getHave_get_activity_award()) && (cfg.award_id > 0))
/*     */             {
/* 126 */               AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, roleid, false, true, new AwardReason(LogReason.FEI_SHENG_ZHU_XIAN_JIAN_ZHEN_AWARD, activityCfgid));
/*     */               
/* 128 */               if (awardModel != null)
/*     */               {
/* 130 */                 xFeiShengZhuXianJianZhenInfo.setHave_get_activity_award(true);
/*     */               }
/*     */               
/*     */             }
/*     */           }
/* 135 */           else if (activityJoinResult.isCanJoin())
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 140 */             SSynZhuXianJianZhenActivityStageInfo protocol = new SSynZhuXianJianZhenActivityStageInfo();
/* 141 */             protocol.activity_cfg_id = activityCfgid;
/* 142 */             protocol.stage = xFeiShengZhuXianJianZhenInfo.getStage();
/* 143 */             protocol.state = 2;
/* 144 */             protocol.result = 0;
/* 145 */             protocol.commit_item_num = xFeiShengZhuXianJianZhenInfo.getCommit_item_num();
/* 146 */             protocol.kill_monster_num = xFeiShengZhuXianJianZhenInfo.getKill_monster_num();
/* 147 */             protocol.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_collect_item_start_timestamp() / 1000L));
/* 148 */             protocol.stage_kill_monster_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_kill_monster_start_timestamp() / 1000L));
/* 149 */             long now = DateTimeUtils.getCurrTimeInMillis();
/* 150 */             if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */             {
/*     */ 
/* 153 */               xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 154 */               xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */             }
/* 156 */             protocol.daily_try_times = xFeiShengZhuXianJianZhenInfo.getDaily_try_times();
/* 157 */             OnlineManager.getInstance().send(roleid, protocol);
/*     */           }
/*     */         } } }
/* 160 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */