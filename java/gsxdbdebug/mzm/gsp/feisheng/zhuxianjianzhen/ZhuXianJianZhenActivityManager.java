/*     */ package mzm.gsp.feisheng.zhuxianjianzhen;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.feisheng.SSynZhuXianJianZhenActivityStageInfo;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg;
/*     */ import mzm.gsp.feisheng.main.FeiShengManager;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FeiShengZhuXianJianZhenInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZhuXianJianZhenActivityManager
/*     */ {
/*     */   public static void init()
/*     */   {
/*  30 */     ActivityInterface.registerActivityByLogicType(88, new FeiShengZhuXianJianZhenActivityHandler());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFeiShengZhuXianJianZhenActivitySwitchOpenForRole(long roleid, int activityCfgid)
/*     */   {
/*  42 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/*  43 */     if (cfg == null)
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/*  53 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/*  54 */       return false;
/*     */     }
/*  56 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int cutAllItem(long roleid, int activityCfgid)
/*     */   {
/*  70 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/*  71 */     if (cfg == null)
/*     */     {
/*  73 */       return 0;
/*     */     }
/*  75 */     int realCommitNum = 0;
/*  76 */     while (ItemInterface.removeItemById(roleid, cfg.commit_item_cfg_id, 1, new TLogArg(LogReason.FEI_SHENG_ZHU_XIAN_JIAN_ZHEN_COST_ITEM, activityCfgid)))
/*     */     {
/*     */ 
/*  79 */       realCommitNum++;
/*     */     }
/*  81 */     return realCommitNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onCollectItemStageStart(long roleid, int activityCfgid, FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo)
/*     */   {
/*  94 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/*  95 */     if (cfg == null)
/*     */     {
/*     */ 
/*  98 */       return;
/*     */     }
/*     */     
/* 101 */     long worldid = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(cfg.activity_map_cfg_id) }));
/*     */     
/* 103 */     TeamInterface.registerJoinTeam(worldid, new ZhuXianJianZhenJoinTeamCheckHandler());
/*     */     
/* 105 */     ControllerInterface.triggerOrReSpawn(worldid, cfg.commit_item_npc_controller_id);
/* 106 */     ControllerInterface.triggerWorldControllerWithMaxSpawnNum(worldid, cfg.item_controller_id, cfg.item_refresh_num);
/*     */     
/* 108 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 109 */     xFeiShengZhuXianJianZhenInfo.setStage(1);
/* 110 */     xFeiShengZhuXianJianZhenInfo.setWorld_id(worldid);
/* 111 */     xFeiShengZhuXianJianZhenInfo.setCommit_item_num(0);
/* 112 */     xFeiShengZhuXianJianZhenInfo.setKill_monster_num(0);
/* 113 */     xFeiShengZhuXianJianZhenInfo.setSession_id(new StageSession(cfg.collect_item_tips_duration_in_second + cfg.collect_item_duration_in_second, roleid, activityCfgid, 1).getSessionId());
/*     */     
/*     */ 
/* 116 */     xFeiShengZhuXianJianZhenInfo.setStage_collect_item_start_timestamp(now);
/* 117 */     xFeiShengZhuXianJianZhenInfo.setStage_kill_monster_start_timestamp(-1L);
/* 118 */     xFeiShengZhuXianJianZhenInfo.setDaily_try_times(xFeiShengZhuXianJianZhenInfo.getDaily_try_times() + 1);
/* 119 */     xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */     
/* 121 */     MapInterface.forceTransferToScene(roleid, worldid, cfg.activity_map_cfg_id, cfg.activity_map_transfer_x, cfg.activity_map_transfer_y);
/*     */     
/*     */ 
/* 124 */     SSynZhuXianJianZhenActivityStageInfo protocol = new SSynZhuXianJianZhenActivityStageInfo();
/* 125 */     protocol.activity_cfg_id = activityCfgid;
/* 126 */     protocol.stage = 1;
/* 127 */     protocol.state = 1;
/* 128 */     protocol.result = 0;
/* 129 */     protocol.commit_item_num = xFeiShengZhuXianJianZhenInfo.getCommit_item_num();
/* 130 */     protocol.kill_monster_num = xFeiShengZhuXianJianZhenInfo.getKill_monster_num();
/* 131 */     protocol.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_collect_item_start_timestamp() / 1000L));
/* 132 */     protocol.stage_kill_monster_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_kill_monster_start_timestamp() / 1000L));
/* 133 */     if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */     {
/* 135 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 136 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */     }
/* 138 */     protocol.daily_try_times = xFeiShengZhuXianJianZhenInfo.getDaily_try_times();
/* 139 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */     
/* 141 */     StringBuilder sb = new StringBuilder();
/* 142 */     sb.append(String.format("[feisheng]ZhuXianJianZhenActivityManager.onCollectItemStageStart@collect item stage start|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid) }));
/*     */     
/*     */ 
/* 145 */     FeiShengManager.logger.info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onCollectItemStageSuccess(long roleid, int activityCfgid, FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo)
/*     */   {
/* 158 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/* 159 */     if (cfg == null)
/*     */     {
/*     */ 
/* 162 */       return;
/*     */     }
/*     */     
/* 165 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 166 */     SSynZhuXianJianZhenActivityStageInfo protocol_end = new SSynZhuXianJianZhenActivityStageInfo();
/* 167 */     protocol_end.activity_cfg_id = activityCfgid;
/* 168 */     protocol_end.stage = 1;
/* 169 */     protocol_end.state = 3;
/* 170 */     protocol_end.result = 1;
/* 171 */     protocol_end.commit_item_num = xFeiShengZhuXianJianZhenInfo.getCommit_item_num();
/* 172 */     protocol_end.kill_monster_num = xFeiShengZhuXianJianZhenInfo.getKill_monster_num();
/* 173 */     protocol_end.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_collect_item_start_timestamp() / 1000L));
/* 174 */     protocol_end.stage_kill_monster_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_kill_monster_start_timestamp() / 1000L));
/* 175 */     if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */     {
/* 177 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 178 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */     }
/* 180 */     protocol_end.daily_try_times = xFeiShengZhuXianJianZhenInfo.getDaily_try_times();
/* 181 */     OnlineManager.getInstance().send(roleid, protocol_end);
/*     */     
/* 183 */     Session.removeSession(xFeiShengZhuXianJianZhenInfo.getSession_id(), roleid);
/* 184 */     xFeiShengZhuXianJianZhenInfo.setSession_id(new DelaySession(cfg.collect_item_success_effect_duration, roleid, activityCfgid, 1).getSessionId());
/*     */     
/*     */ 
/*     */ 
/* 188 */     ControllerInterface.collectWorldController(xFeiShengZhuXianJianZhenInfo.getWorld_id(), cfg.commit_item_npc_controller_id);
/*     */     
/* 190 */     ControllerInterface.collectWorldController(xFeiShengZhuXianJianZhenInfo.getWorld_id(), cfg.item_controller_id);
/*     */     
/* 192 */     StringBuilder sb = new StringBuilder();
/* 193 */     sb.append(String.format("[feisheng]ZhuXianJianZhenActivityManager.onCollectItemStageSuccess@collect item stage success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid) }));
/*     */     
/*     */ 
/* 196 */     FeiShengManager.logger.info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onCollectItemStageFail(long roleid, int activityCfgid, FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo)
/*     */   {
/* 209 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/* 210 */     if (cfg == null)
/*     */     {
/*     */ 
/* 213 */       return;
/*     */     }
/* 215 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 217 */     SSynZhuXianJianZhenActivityStageInfo protocol_end = new SSynZhuXianJianZhenActivityStageInfo();
/* 218 */     protocol_end.activity_cfg_id = activityCfgid;
/* 219 */     protocol_end.stage = 1;
/* 220 */     protocol_end.state = 3;
/* 221 */     protocol_end.result = 2;
/* 222 */     protocol_end.commit_item_num = xFeiShengZhuXianJianZhenInfo.getCommit_item_num();
/* 223 */     protocol_end.kill_monster_num = xFeiShengZhuXianJianZhenInfo.getKill_monster_num();
/* 224 */     protocol_end.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_collect_item_start_timestamp() / 1000L));
/* 225 */     protocol_end.stage_kill_monster_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_kill_monster_start_timestamp() / 1000L));
/* 226 */     if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */     {
/* 228 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 229 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */     }
/* 231 */     protocol_end.daily_try_times = xFeiShengZhuXianJianZhenInfo.getDaily_try_times();
/* 232 */     OnlineManager.getInstance().send(roleid, protocol_end);
/*     */     
/* 234 */     cutAllItem(roleid, activityCfgid);
/*     */     
/* 236 */     xFeiShengZhuXianJianZhenInfo.setStage(0);
/* 237 */     Session.removeSession(xFeiShengZhuXianJianZhenInfo.getSession_id(), roleid);
/* 238 */     xFeiShengZhuXianJianZhenInfo.setSession_id(-1L);
/* 239 */     long worldid = xFeiShengZhuXianJianZhenInfo.getWorld_id();
/* 240 */     xFeiShengZhuXianJianZhenInfo.setWorld_id(-1L);
/*     */     
/* 242 */     RoleStatusInterface.unsetStatus(roleid, 959);
/*     */     
/* 244 */     MapInterface.forceTransferAllRole(MapInterface.getAllSingleRoleAndTeamLeaderInWorld(worldid), MapInterface.getBigWorldid(), cfg.out_map_cfg_id, cfg.out_map_transfer_x, cfg.out_map_transfer_y);
/*     */     
/*     */ 
/* 247 */     destroyWorld(worldid, activityCfgid);
/*     */     
/* 249 */     StringBuilder sb = new StringBuilder();
/* 250 */     sb.append(String.format("[feisheng]ZhuXianJianZhenActivityManager.onCollectItemStageFail@collect item stage fail|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid) }));
/*     */     
/*     */ 
/* 253 */     FeiShengManager.logger.info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onKillMonsterStageStart(long roleid, int activityCfgid, FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo)
/*     */   {
/* 266 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/* 267 */     if (cfg == null)
/*     */     {
/*     */ 
/* 270 */       return;
/*     */     }
/*     */     
/* 273 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 274 */     xFeiShengZhuXianJianZhenInfo.setStage(2);
/* 275 */     xFeiShengZhuXianJianZhenInfo.setStage_kill_monster_start_timestamp(now);
/* 276 */     Session.removeSession(xFeiShengZhuXianJianZhenInfo.getSession_id(), roleid);
/* 277 */     xFeiShengZhuXianJianZhenInfo.setSession_id(new StageSession(cfg.kill_monster_tips_duration_in_second + cfg.kill_monster_duration_in_second, roleid, activityCfgid, 2).getSessionId());
/*     */     
/*     */ 
/*     */ 
/* 281 */     ControllerInterface.triggerOrReSpawn(xFeiShengZhuXianJianZhenInfo.getWorld_id(), cfg.monster_controller_id);
/*     */     
/* 283 */     ZhuXianJianZhenVisibleMonsterFightHandlerManager.getInstance().registerHandler(xFeiShengZhuXianJianZhenInfo.getWorld_id(), activityCfgid);
/*     */     
/*     */ 
/* 286 */     SSynZhuXianJianZhenActivityStageInfo protocol_start = new SSynZhuXianJianZhenActivityStageInfo();
/* 287 */     protocol_start.activity_cfg_id = activityCfgid;
/* 288 */     protocol_start.stage = 2;
/* 289 */     protocol_start.state = 1;
/* 290 */     protocol_start.result = 0;
/* 291 */     protocol_start.commit_item_num = xFeiShengZhuXianJianZhenInfo.getCommit_item_num();
/* 292 */     protocol_start.kill_monster_num = xFeiShengZhuXianJianZhenInfo.getKill_monster_num();
/* 293 */     protocol_start.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_collect_item_start_timestamp() / 1000L));
/* 294 */     protocol_start.stage_kill_monster_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_kill_monster_start_timestamp() / 1000L));
/* 295 */     if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */     {
/* 297 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 298 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */     }
/* 300 */     protocol_start.daily_try_times = xFeiShengZhuXianJianZhenInfo.getDaily_try_times();
/* 301 */     OnlineManager.getInstance().send(roleid, protocol_start);
/*     */     
/* 303 */     StringBuilder sb = new StringBuilder();
/* 304 */     sb.append(String.format("[feisheng]ZhuXianJianZhenActivityManager.onCollectItemStageSuccess@kill monster stage start|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid) }));
/*     */     
/*     */ 
/* 307 */     FeiShengManager.logger.info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onKillMonsterStageSuccess(long roleid, int activityCfgid, FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo)
/*     */   {
/* 320 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/* 321 */     if (cfg == null)
/*     */     {
/*     */ 
/* 324 */       return;
/*     */     }
/* 326 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 328 */     SSynZhuXianJianZhenActivityStageInfo protocol = new SSynZhuXianJianZhenActivityStageInfo();
/* 329 */     protocol.activity_cfg_id = activityCfgid;
/* 330 */     protocol.stage = 2;
/* 331 */     protocol.state = 3;
/* 332 */     protocol.result = 1;
/* 333 */     protocol.commit_item_num = xFeiShengZhuXianJianZhenInfo.getCommit_item_num();
/* 334 */     protocol.kill_monster_num = xFeiShengZhuXianJianZhenInfo.getKill_monster_num();
/* 335 */     protocol.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_collect_item_start_timestamp() / 1000L));
/* 336 */     protocol.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_kill_monster_start_timestamp() / 1000L));
/* 337 */     if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */     {
/* 339 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 340 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */     }
/* 342 */     protocol.daily_try_times = xFeiShengZhuXianJianZhenInfo.getDaily_try_times();
/* 343 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */     
/* 345 */     cutAllItem(roleid, activityCfgid);
/*     */     
/* 347 */     xFeiShengZhuXianJianZhenInfo.setStage(0);
/* 348 */     Session.removeSession(xFeiShengZhuXianJianZhenInfo.getSession_id(), roleid);
/* 349 */     xFeiShengZhuXianJianZhenInfo.setSession_id(new DelaySession(cfg.kill_monster_success_effect_duration + cfg.delay_leave_interval, roleid, activityCfgid, 2).getSessionId());
/*     */     
/*     */ 
/* 352 */     ControllerInterface.collectWorldController(xFeiShengZhuXianJianZhenInfo.getWorld_id(), cfg.monster_controller_id);
/*     */     
/* 354 */     TeamInterface.unRegisterJoinTeam(xFeiShengZhuXianJianZhenInfo.getWorld_id());
/*     */     
/* 356 */     StringBuilder sb = new StringBuilder();
/* 357 */     sb.append(String.format("[feisheng]ZhuXianJianZhenActivityManager.onKillMonsterStageSuccess@kill monster stage success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid) }));
/*     */     
/*     */ 
/* 360 */     FeiShengManager.logger.info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onKillMonsterStageFail(long roleid, int activityCfgid, FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo)
/*     */   {
/* 373 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/* 374 */     if (cfg == null)
/*     */     {
/*     */ 
/* 377 */       return;
/*     */     }
/* 379 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 381 */     SSynZhuXianJianZhenActivityStageInfo protocol = new SSynZhuXianJianZhenActivityStageInfo();
/* 382 */     protocol.activity_cfg_id = activityCfgid;
/* 383 */     protocol.stage = 2;
/* 384 */     protocol.state = 3;
/* 385 */     protocol.result = 2;
/* 386 */     protocol.commit_item_num = xFeiShengZhuXianJianZhenInfo.getCommit_item_num();
/* 387 */     protocol.kill_monster_num = xFeiShengZhuXianJianZhenInfo.getKill_monster_num();
/* 388 */     protocol.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_collect_item_start_timestamp() / 1000L));
/* 389 */     protocol.stage_collect_item_start_timestamp = ((int)(xFeiShengZhuXianJianZhenInfo.getStage_kill_monster_start_timestamp() / 1000L));
/* 390 */     if (DateTimeUtils.needDailyReset(xFeiShengZhuXianJianZhenInfo.getDaily_try_times_timestamp(), now, 0))
/*     */     {
/* 392 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times(0);
/* 393 */       xFeiShengZhuXianJianZhenInfo.setDaily_try_times_timestamp(now);
/*     */     }
/* 395 */     protocol.daily_try_times = xFeiShengZhuXianJianZhenInfo.getDaily_try_times();
/* 396 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */     
/* 398 */     cutAllItem(roleid, activityCfgid);
/*     */     
/* 400 */     xFeiShengZhuXianJianZhenInfo.setStage(0);
/* 401 */     Session.removeSession(xFeiShengZhuXianJianZhenInfo.getSession_id(), roleid);
/* 402 */     xFeiShengZhuXianJianZhenInfo.setSession_id(-1L);
/* 403 */     long worldid = xFeiShengZhuXianJianZhenInfo.getWorld_id();
/* 404 */     xFeiShengZhuXianJianZhenInfo.setWorld_id(-1L);
/*     */     
/* 406 */     RoleStatusInterface.unsetStatus(roleid, 959);
/*     */     
/* 408 */     MapInterface.forceTransferAllRole(MapInterface.getAllSingleRoleAndTeamLeaderInWorld(worldid), MapInterface.getBigWorldid(), cfg.out_map_cfg_id, cfg.out_map_transfer_x, cfg.out_map_transfer_y);
/*     */     
/*     */ 
/* 411 */     destroyWorld(worldid, activityCfgid);
/*     */     
/* 413 */     StringBuilder sb = new StringBuilder();
/* 414 */     sb.append(String.format("[feisheng]ZhuXianJianZhenActivityManager.onKillMonsterStageFail@kill monster stage fail|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid) }));
/*     */     
/*     */ 
/* 417 */     FeiShengManager.logger.info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onLeaveActivityMap(long roleid, int activityCfgid, FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo)
/*     */   {
/* 430 */     long worldid = xFeiShengZhuXianJianZhenInfo.getWorld_id();
/* 431 */     if (worldid < 0L)
/*     */     {
/* 433 */       return;
/*     */     }
/* 435 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/* 436 */     if (cfg == null)
/*     */     {
/*     */ 
/* 439 */       return;
/*     */     }
/*     */     
/* 442 */     cutAllItem(roleid, activityCfgid);
/*     */     
/* 444 */     xFeiShengZhuXianJianZhenInfo.setStage(0);
/* 445 */     Session.removeSession(xFeiShengZhuXianJianZhenInfo.getSession_id(), roleid);
/* 446 */     xFeiShengZhuXianJianZhenInfo.setSession_id(-1L);
/* 447 */     xFeiShengZhuXianJianZhenInfo.setWorld_id(-1L);
/*     */     
/* 449 */     RoleStatusInterface.unsetStatus(roleid, 959);
/*     */     
/* 451 */     MapInterface.forceTransferAllRole(MapInterface.getAllSingleRoleAndTeamLeaderInWorld(worldid), MapInterface.getBigWorldid(), cfg.out_map_cfg_id, cfg.out_map_transfer_x, cfg.out_map_transfer_y);
/*     */     
/*     */ 
/* 454 */     destroyWorld(worldid, activityCfgid);
/*     */     
/* 456 */     StringBuilder sb = new StringBuilder();
/* 457 */     sb.append(String.format("[feisheng]ZhuXianJianZhenActivityManager.onLeaveActivityMap@leave activity map|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(activityCfgid) }));
/*     */     
/*     */ 
/* 460 */     FeiShengManager.logger.info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void destroyWorld(long worldid, int activityCfgid)
/*     */   {
/* 471 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(activityCfgid);
/* 472 */     if (cfg == null)
/*     */     {
/*     */ 
/* 475 */       return;
/*     */     }
/*     */     
/* 478 */     ControllerInterface.collectWorldController(worldid, cfg.commit_item_npc_controller_id);
/* 479 */     ControllerInterface.collectWorldController(worldid, cfg.item_controller_id);
/* 480 */     ControllerInterface.collectWorldController(worldid, cfg.monster_controller_id);
/*     */     
/* 482 */     TeamInterface.unRegisterJoinTeam(worldid);
/*     */     
/* 484 */     ZhuXianJianZhenVisibleMonsterFightHandlerManager.getInstance().unregisterHandler(worldid);
/*     */     
/* 486 */     MapInterface.destroyWorld(worldid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\ZhuXianJianZhenActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */