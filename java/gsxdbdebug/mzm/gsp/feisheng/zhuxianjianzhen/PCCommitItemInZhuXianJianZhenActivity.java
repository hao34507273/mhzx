/*     */ package mzm.gsp.feisheng.zhuxianjianzhen;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.feisheng.SCommitItemInZhuXianJianZhenActivityFail;
/*     */ import mzm.gsp.feisheng.SSynZhuXianJianZhenActivityStageInfo;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.server.main.ServerInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FeiShengZhuXianJianZhenInfo;
/*     */ import xbean.RoleFeiShengZhuXianJianZhenInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_zhu_xian_jian_zhen_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCommitItemInZhuXianJianZhenActivity extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCCommitItemInZhuXianJianZhenActivity(long roleid, int activityCfgid)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!ZhuXianJianZhenActivityManager.isFeiShengZhuXianJianZhenActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  42 */       onFail(-1, null);
/*  43 */       return false;
/*     */     }
/*  45 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(this.activityCfgid);
/*  46 */     if (cfg == null)
/*     */     {
/*     */ 
/*  49 */       onFail(-3, null);
/*  50 */       return false;
/*     */     }
/*  52 */     if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*     */     {
/*     */ 
/*  55 */       onFail(-5, null);
/*  56 */       return false;
/*     */     }
/*  58 */     if (!NpcInterface.checkNpcService(cfg.commit_item_npc_id, cfg.commit_item_npc_service_id, this.roleid))
/*     */     {
/*     */ 
/*  61 */       onFail(-4, null);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  67 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  69 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  71 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  73 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  76 */       Map<String, Object> extraInfo = new HashMap();
/*  77 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  78 */       onFail(1, extraInfo);
/*  79 */       return false;
/*     */     }
/*  81 */     if (!mzm.gsp.status.main.RoleStatusInterface.containsStatus(this.roleid, 959))
/*     */     {
/*     */ 
/*  84 */       onFail(-2, null);
/*  85 */       return false;
/*     */     }
/*  87 */     RoleFeiShengZhuXianJianZhenInfo xRoleFeiShengZhuXianJianZhenInfo = Role_fei_sheng_zhu_xian_jian_zhen_infos.get(Long.valueOf(this.roleid));
/*  88 */     if (xRoleFeiShengZhuXianJianZhenInfo == null)
/*     */     {
/*     */ 
/*  91 */       onFail(-6, null);
/*  92 */       return false;
/*     */     }
/*  94 */     FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo = (FeiShengZhuXianJianZhenInfo)xRoleFeiShengZhuXianJianZhenInfo.getFei_sheng_zhu_xian_jian_zhen_infos().get(Integer.valueOf(this.activityCfgid));
/*     */     
/*  96 */     if (xFeiShengZhuXianJianZhenInfo == null)
/*     */     {
/*     */ 
/*  99 */       onFail(-6, null);
/* 100 */       return false;
/*     */     }
/* 102 */     if (xFeiShengZhuXianJianZhenInfo.getStage() != 1)
/*     */     {
/*     */ 
/* 105 */       onFail(4, null);
/* 106 */       return false;
/*     */     }
/* 108 */     int realCommitNum = ZhuXianJianZhenActivityManager.cutAllItem(this.roleid, this.activityCfgid);
/* 109 */     if (realCommitNum <= 0)
/*     */     {
/*     */ 
/* 112 */       onFail(2, null);
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 117 */     xFeiShengZhuXianJianZhenInfo.setCommit_item_num(xFeiShengZhuXianJianZhenInfo.getCommit_item_num() + realCommitNum);
/* 118 */     SSynZhuXianJianZhenActivityStageInfo protocol = new SSynZhuXianJianZhenActivityStageInfo();
/* 119 */     protocol.activity_cfg_id = this.activityCfgid;
/* 120 */     protocol.stage = 1;
/* 121 */     protocol.state = 2;
/* 122 */     protocol.result = 0;
/* 123 */     protocol.commit_item_num = xFeiShengZhuXianJianZhenInfo.getCommit_item_num();
/* 124 */     protocol.kill_monster_num = xFeiShengZhuXianJianZhenInfo.getKill_monster_num();
/* 125 */     protocol.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_collect_item_start_timestamp() / 1000L));
/* 126 */     protocol.stage_kill_monster_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_kill_monster_start_timestamp() / 1000L));
/* 127 */     if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */     {
/* 129 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 130 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */     }
/* 132 */     protocol.daily_try_times = xFeiShengZhuXianJianZhenInfo.getDaily_try_times();
/* 133 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 135 */     StringBuilder sb = new StringBuilder();
/* 136 */     sb.append(String.format("[feisheng]PCCommitItemInZhuXianJianZhenActivity.processImp@commit item in zhu xian jian zhen activity success|roleid=%d|activity_cfg_id=%d|real_commit_num=%d|commit_item_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(realCommitNum), Integer.valueOf(xFeiShengZhuXianJianZhenInfo.getCommit_item_num()) }));
/*     */     
/*     */ 
/* 139 */     FeiShengManager.logger.info(sb.toString());
/*     */     
/* 141 */     if (xFeiShengZhuXianJianZhenInfo.getCommit_item_num() >= cfg.commit_item_num)
/*     */     {
/*     */ 
/* 144 */       ZhuXianJianZhenActivityManager.onCollectItemStageSuccess(this.roleid, this.activityCfgid, xFeiShengZhuXianJianZhenInfo);
/*     */     }
/*     */     
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 152 */     StringBuilder sb = new StringBuilder();
/* 153 */     sb.append(String.format("[feisheng]PCCommitItemInZhuXianJianZhenActivity.processImp@commit item in zhu xian jian zhen activity fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 156 */     if (extraInfo != null)
/*     */     {
/* 158 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 160 */         sb.append("|").append((String)entry.getKey());
/* 161 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 164 */     FeiShengManager.logger.info(sb.toString());
/* 165 */     if (res > 0)
/*     */     {
/* 167 */       SCommitItemInZhuXianJianZhenActivityFail protocol = new SCommitItemInZhuXianJianZhenActivityFail();
/* 168 */       protocol.res = res;
/* 169 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\PCCommitItemInZhuXianJianZhenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */