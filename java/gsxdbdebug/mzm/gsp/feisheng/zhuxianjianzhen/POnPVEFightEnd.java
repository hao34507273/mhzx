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
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.feisheng.SSynZhuXianJianZhenActivityStageInfo;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivity;
/*     */ import mzm.gsp.feisheng.event.RoleCompleteFeiShengSubActivityArg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.map.main.MapFightContext;
/*     */ import mzm.gsp.map.main.MapFightContext.EXTRADATA_TYPE;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FeiShengZhuXianJianZhenInfo;
/*     */ import xbean.RoleFeiShengZhuXianJianZhenInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_zhu_xian_jian_zhen_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPVEFightEnd extends PVEFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  40 */     if (((PVEFightEndArg)this.arg).fightReason != FightReason.ZHU_XIAN_JIAN_ZHEN_PVE.value)
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     MapFightContext context = null;
/*  45 */     if ((((PVEFightEndArg)this.arg).context instanceof MapFightContext))
/*     */     {
/*  47 */       context = (MapFightContext)((PVEFightEndArg)this.arg).context;
/*     */     }
/*  49 */     if (context == null)
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     if (!((PVEFightEndArg)this.arg).isPlayerWin)
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     if (context.getExtra(MapFightContext.EXTRADATA_TYPE.ACTIVITY_CFG_ID) == null)
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     int activityCfgid = context.getExtra(MapFightContext.EXTRADATA_TYPE.ACTIVITY_CFG_ID).intValue();
/*  62 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/*  63 */     if (cfg == null)
/*     */     {
/*  65 */       return false;
/*     */     }
/*  67 */     long roleid = ((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue();
/*  68 */     if (!ZhuXianJianZhenActivityManager.isFeiShengZhuXianJianZhenActivitySwitchOpenForRole(roleid, activityCfgid))
/*     */     {
/*     */ 
/*  71 */       onFail(roleid, activityCfgid, -1, null);
/*  72 */       return false;
/*     */     }
/*  74 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  77 */       onFail(roleid, activityCfgid, -5, null);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/*  83 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  85 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*     */     
/*  87 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, activityCfgid);
/*     */     
/*  89 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  92 */       Map<String, Object> extraInfo = new HashMap();
/*  93 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  94 */       onFail(roleid, activityCfgid, 1, extraInfo);
/*  95 */       return false;
/*     */     }
/*  97 */     if (!mzm.gsp.status.main.RoleStatusInterface.containsStatus(roleid, 959))
/*     */     {
/*     */ 
/* 100 */       onFail(roleid, activityCfgid, -2, null);
/* 101 */       return false;
/*     */     }
/* 103 */     RoleFeiShengZhuXianJianZhenInfo xRoleFeiShengZhuXianJianZhenInfo = Role_fei_sheng_zhu_xian_jian_zhen_infos.get(Long.valueOf(roleid));
/* 104 */     if (xRoleFeiShengZhuXianJianZhenInfo == null)
/*     */     {
/*     */ 
/* 107 */       onFail(roleid, activityCfgid, -6, null);
/* 108 */       return false;
/*     */     }
/* 110 */     FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo = (FeiShengZhuXianJianZhenInfo)xRoleFeiShengZhuXianJianZhenInfo.getFei_sheng_zhu_xian_jian_zhen_infos().get(Integer.valueOf(activityCfgid));
/*     */     
/* 112 */     if (xFeiShengZhuXianJianZhenInfo == null)
/*     */     {
/*     */ 
/* 115 */       onFail(roleid, activityCfgid, -6, null);
/* 116 */       return false;
/*     */     }
/* 118 */     if (xFeiShengZhuXianJianZhenInfo.getStage() != 2)
/*     */     {
/*     */ 
/* 121 */       onFail(roleid, activityCfgid, 4, null);
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     xFeiShengZhuXianJianZhenInfo.setKill_monster_num(xFeiShengZhuXianJianZhenInfo.getKill_monster_num() + 1);
/* 126 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 128 */     SSynZhuXianJianZhenActivityStageInfo protocol = new SSynZhuXianJianZhenActivityStageInfo();
/* 129 */     protocol.activity_cfg_id = activityCfgid;
/* 130 */     protocol.stage = 2;
/* 131 */     protocol.state = 2;
/* 132 */     protocol.result = 0;
/* 133 */     protocol.commit_item_num = xFeiShengZhuXianJianZhenInfo.getCommit_item_num();
/* 134 */     protocol.kill_monster_num = xFeiShengZhuXianJianZhenInfo.getKill_monster_num();
/* 135 */     protocol.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_collect_item_start_timestamp() / 1000L));
/* 136 */     protocol.stage_kill_monster_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_kill_monster_start_timestamp() / 1000L));
/* 137 */     if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */     {
/* 139 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 140 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */     }
/* 142 */     protocol.daily_try_times = xFeiShengZhuXianJianZhenInfo.getDaily_try_times();
/* 143 */     OnlineManager.getInstance().send(roleid, protocol);
/* 144 */     StringBuilder sb = new StringBuilder();
/* 145 */     sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@pve fight end process success|roleid=%d|activity_cfg_id=%d|kill_monster_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(xFeiShengZhuXianJianZhenInfo.getKill_monster_num()) }));
/*     */     
/*     */ 
/* 148 */     FeiShengManager.logger.info(sb.toString());
/*     */     
/* 150 */     if (xFeiShengZhuXianJianZhenInfo.getKill_monster_num() >= cfg.kill_monster_num)
/*     */     {
/*     */ 
/* 153 */       if ((!xFeiShengZhuXianJianZhenInfo.getHave_get_activity_award()) && (cfg.award_id > 0))
/*     */       {
/* 155 */         mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(cfg.award_id, userid, roleid, false, true, new AwardReason(LogReason.FEI_SHENG_ZHU_XIAN_JIAN_ZHEN_AWARD, activityCfgid));
/*     */         
/* 157 */         if (awardModel != null)
/*     */         {
/* 159 */           xFeiShengZhuXianJianZhenInfo.setHave_get_activity_award(true);
/*     */         }
/*     */       }
/*     */       
/* 163 */       ActivityInterface.addActivityCount(userid, roleid, activityCfgid);
/*     */       
/* 165 */       TriggerEventsManger.getInstance().triggerEvent(new RoleCompleteFeiShengSubActivity(), new RoleCompleteFeiShengSubActivityArg(roleid, activityCfgid));
/*     */       
/* 167 */       ActivityInterface.tlogActivity(userid, roleid, RoleInterface.getLevel(roleid), GameServerInfoManager.getHostIP(), activityCfgid, ActivityLogStatus.FINISH);
/*     */       
/*     */ 
/* 170 */       ZhuXianJianZhenActivityManager.onKillMonsterStageSuccess(roleid, activityCfgid, xFeiShengZhuXianJianZhenInfo);
/*     */     }
/* 172 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(long roleid, int activityCfgid, int res, Map<String, Object> extraInfo)
/*     */   {
/* 177 */     StringBuilder sb = new StringBuilder();
/* 178 */     sb.append(String.format("[feisheng]POnPVEFightEnd.processImp@pve fight end process fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 181 */     if (extraInfo != null)
/*     */     {
/* 183 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 185 */         sb.append("|").append((String)entry.getKey());
/* 186 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 189 */     FeiShengManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */