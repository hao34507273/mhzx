/*     */ package mzm.gsp.treasurehunt.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.MapItemGatherContext;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.treasurehunt.SAttendTreasureHuntSuccess;
/*     */ import mzm.gsp.treasurehunt.SLeaveTreasureHuntSuccess;
/*     */ import mzm.gsp.treasurehunt.SNotifyReduceTreasureHuntTime;
/*     */ import mzm.gsp.treasurehunt.SNotifyTreasureHuntProcess;
/*     */ import mzm.gsp.treasurehunt.SNotifyTreasureHuntSuccess;
/*     */ import mzm.gsp.treasurehunt.confbean.ChapterEffect;
/*     */ import mzm.gsp.treasurehunt.confbean.STreasureHuntCfg;
/*     */ import mzm.gsp.treasurehunt.confbean.STreasureHuntChapterCfg;
/*     */ import mzm.gsp.treasurehunt.confbean.STreasureHuntChapterEffectCfg;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2TreasureHuntInfo;
/*     */ import xbean.Role2TreasureHuntWorldInfo;
/*     */ import xbean.RoleTreasureHuntActivityInfo;
/*     */ import xdb.Lockey;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2treasurehunt;
/*     */ import xtable.Role2treasurehuntworld;
/*     */ 
/*     */ public class TreasureHuntMapItemHandler implements mzm.gsp.map.main.MapItemGatherHandler
/*     */ {
/*     */   public Set<Lockey> collectLocks(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  45 */     Set<Lockey> lockeys = new java.util.HashSet();
/*  46 */     lockeys.add(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(roleid)));
/*     */     
/*  48 */     return lockeys;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean gatherCheck(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onGather(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, int itemCfgid, int itemNum, MapItemGatherContext context)
/*     */   {
/*  62 */     Role2TreasureHuntWorldInfo xRole2TreasureHuntWorldInfo = Role2treasurehuntworld.get(Long.valueOf(roleid));
/*  63 */     if (xRole2TreasureHuntWorldInfo == null)
/*     */     {
/*  65 */       onFail(-1, roleid, mapCfgid, mapItemCfgid);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (worldid != xRole2TreasureHuntWorldInfo.getWorld_id())
/*     */     {
/*  71 */       onFail(-2, roleid, mapCfgid, mapItemCfgid);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     int nowChapterCfgId = xRole2TreasureHuntWorldInfo.getChapter_cfg_id();
/*  76 */     STreasureHuntChapterCfg sTreasureHuntChapterCfg = STreasureHuntChapterCfg.get(nowChapterCfgId);
/*  77 */     if (sTreasureHuntChapterCfg == null)
/*     */     {
/*  79 */       onFail(-3, roleid, mapCfgid, mapItemCfgid);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     STreasureHuntChapterEffectCfg sTreasureHuntChapterEffectCfg = STreasureHuntChapterEffectCfg.get(sTreasureHuntChapterCfg.class_id);
/*  84 */     if (sTreasureHuntChapterEffectCfg == null)
/*     */     {
/*  86 */       onFail(-4, roleid, mapCfgid, mapItemCfgid);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     TreasureHuntSceneSession session = (TreasureHuntSceneSession)Session.getSession(xRole2TreasureHuntWorldInfo.getSession_id());
/*  91 */     if (session == null)
/*     */     {
/*  93 */       onFail(-5, roleid, mapCfgid, mapItemCfgid);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     int activityCfgId = session.getActivityCfgId();
/*     */     
/*  99 */     STreasureHuntCfg sTreasureHuntCfg = STreasureHuntCfg.get(activityCfgId);
/* 100 */     if (sTreasureHuntCfg == null)
/*     */     {
/* 102 */       onFail(-6, roleid, mapCfgid, mapItemCfgid);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     int aleardyTriggerSize = xRole2TreasureHuntWorldInfo.getProcess();
/*     */     
/*     */ 
/* 109 */     List<Integer> randomEffectList = new ArrayList();
/* 110 */     for (Map.Entry<Integer, ChapterEffect> chapterEffectEntry : sTreasureHuntChapterEffectCfg.treasure_hunt_effect_cfg_map.entrySet())
/*     */     {
/* 112 */       ChapterEffect chapterEffect = (ChapterEffect)chapterEffectEntry.getValue();
/* 113 */       int effectCfgId = ((Integer)chapterEffectEntry.getKey()).intValue();
/*     */       
/* 115 */       if ((aleardyTriggerSize >= sTreasureHuntChapterCfg.guarantee_num) || (chapterEffect.map_item_id_effect_type != 3))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */         Integer oldValue = (Integer)xRole2TreasureHuntWorldInfo.getTrigger_effect_map().get(Integer.valueOf(effectCfgId));
/*     */         
/* 123 */         for (int index = oldValue == null ? 0 : oldValue.intValue(); 
/* 124 */             index < chapterEffect.item_num; index++)
/*     */         {
/* 126 */           randomEffectList.add(Integer.valueOf(effectCfgId));
/*     */         }
/*     */       }
/*     */     }
/* 130 */     int randomSize = randomEffectList.size();
/*     */     
/* 132 */     int randomResult = Xdb.random().nextInt(randomSize);
/*     */     
/* 134 */     int randomEffectCfgId = ((Integer)randomEffectList.get(randomResult)).intValue();
/*     */     
/* 136 */     ChapterEffect chapterEffect = (ChapterEffect)sTreasureHuntChapterEffectCfg.treasure_hunt_effect_cfg_map.get(Integer.valueOf(randomEffectCfgId));
/* 137 */     if (chapterEffect == null)
/*     */     {
/* 139 */       onFail(-7, roleid, mapCfgid, mapItemCfgid);
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     Integer oldTriggerEffectNum = (Integer)xRole2TreasureHuntWorldInfo.getTrigger_effect_map().get(Integer.valueOf(randomEffectCfgId));
/* 144 */     xRole2TreasureHuntWorldInfo.getTrigger_effect_map().put(Integer.valueOf(randomEffectCfgId), Integer.valueOf(oldTriggerEffectNum == null ? 1 : 1 + oldTriggerEffectNum.intValue()));
/*     */     
/*     */ 
/* 147 */     xRole2TreasureHuntWorldInfo.setProcess(aleardyTriggerSize + 1);
/* 148 */     SNotifyTreasureHuntProcess sNotifyTreasureHuntProcess = new SNotifyTreasureHuntProcess();
/* 149 */     sNotifyTreasureHuntProcess.process = (aleardyTriggerSize + 1);
/* 150 */     sNotifyTreasureHuntProcess.total = sTreasureHuntChapterCfg.map_item_num;
/*     */     
/* 152 */     OnlineManager.getInstance().send(roleid, sNotifyTreasureHuntProcess);
/*     */     
/*     */ 
/* 155 */     if (chapterEffect.map_item_id_effect_type == 1)
/*     */     {
/* 157 */       mzm.gsp.buff.main.BuffInterface.installBuff(roleid, chapterEffect.map_item_id_effect_parameter_1);
/*     */       
/* 159 */       xRole2TreasureHuntWorldInfo.getTrigger_buff_set().add(Integer.valueOf(chapterEffect.map_item_id_effect_parameter_1));
/*     */     }
/* 161 */     else if (chapterEffect.map_item_id_effect_type == 4)
/*     */     {
/* 163 */       FightInterface.startPVEFight(roleid, chapterEffect.map_item_id_effect_parameter_1, new TreasureHuntFightContext(), 30, FightReason.TREASURE_HUNT_PVE);
/*     */ 
/*     */     }
/* 166 */     else if (chapterEffect.map_item_id_effect_type == 2)
/*     */     {
/* 168 */       long leftTime = session.getLeftMillis() / 1000;
/*     */       
/* 170 */       leftTime -= chapterEffect.map_item_id_effect_parameter_1;
/*     */       
/* 172 */       session.stopTimer();
/*     */       
/* 174 */       TreasureHuntSceneSession newSession = new TreasureHuntSceneSession(leftTime > 0L ? leftTime : 0L, session.getOwerId(), session.getWroldId(), session.getActivityCfgId(), session.getChapterCfgId());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 179 */       xRole2TreasureHuntWorldInfo.setSession_id(newSession.getSessionId());
/*     */       
/* 181 */       SNotifyReduceTreasureHuntTime sNotifyReduceTreasureHuntTime = new SNotifyReduceTreasureHuntTime();
/* 182 */       sNotifyReduceTreasureHuntTime.reduce_seconds = chapterEffect.map_item_id_effect_parameter_1;
/* 183 */       sNotifyReduceTreasureHuntTime.left_seconds = ((int)leftTime);
/*     */       
/* 185 */       OnlineManager.getInstance().send(roleid, sNotifyReduceTreasureHuntTime);
/*     */     }
/* 187 */     else if (chapterEffect.map_item_id_effect_type == 3)
/*     */     {
/* 189 */       SNotifyTreasureHuntSuccess sNotifyTreasureHuntSuccess = new SNotifyTreasureHuntSuccess();
/* 190 */       sNotifyTreasureHuntSuccess.effect_id = sTreasureHuntChapterCfg.pass_chapter_effect_id;
/*     */       
/* 192 */       OnlineManager.getInstance().send(roleid, sNotifyTreasureHuntSuccess);
/*     */       
/* 194 */       Role2TreasureHuntInfo xRole2TreasureHuntInfo = Role2treasurehunt.get(Long.valueOf(roleid));
/* 195 */       if (xRole2TreasureHuntInfo == null)
/*     */       {
/* 197 */         xRole2TreasureHuntInfo = Pod.newRole2TreasureHuntInfo();
/* 198 */         Role2treasurehunt.add(Long.valueOf(roleid), xRole2TreasureHuntInfo);
/*     */       }
/*     */       
/* 201 */       RoleTreasureHuntActivityInfo xRoleTreasureHuntActivityInfo = (RoleTreasureHuntActivityInfo)xRole2TreasureHuntInfo.getTreasure_hunt_activity_map().get(Integer.valueOf(session.getActivityCfgId()));
/*     */       
/* 203 */       if (xRoleTreasureHuntActivityInfo == null)
/*     */       {
/* 205 */         xRoleTreasureHuntActivityInfo = Pod.newRoleTreasureHuntActivityInfo();
/* 206 */         xRole2TreasureHuntInfo.getTreasure_hunt_activity_map().put(Integer.valueOf(session.getActivityCfgId()), xRoleTreasureHuntActivityInfo);
/*     */       }
/*     */       
/*     */ 
/* 210 */       int chapterCfgId = xRole2TreasureHuntWorldInfo.getChapter_cfg_id();
/*     */       
/* 212 */       boolean isFirstPass = xRoleTreasureHuntActivityInfo.getAwarded_chapter_id_set().add(Integer.valueOf(chapterCfgId));
/* 213 */       if (isFirstPass)
/*     */       {
/* 215 */         AwardInterface.award(sTreasureHuntChapterCfg.pass_chapter_award_id, userid, roleid, false, true, new AwardReason(LogReason.TREASURE_HUNT_AWARD, sTreasureHuntChapterCfg.pass_chapter_award_id));
/*     */         
/*     */ 
/* 218 */         mzm.gsp.activity.main.ActivityInterface.addActivityCount(userid, roleid, activityCfgId);
/*     */       }
/*     */       
/* 221 */       int nowProcess = xRoleTreasureHuntActivityInfo.getAwarded_chapter_id_set().size();
/*     */       
/* 223 */       if (nowProcess >= sTreasureHuntCfg.chapter_id_list.size())
/*     */       {
/* 225 */         RoleStatusInterface.unsetStatus(roleid, 2191);
/*     */         
/* 227 */         MapInterface.forceTransferToScene(roleid, sTreasureHuntCfg.out_map_cfg_id, sTreasureHuntCfg.out_position_x, sTreasureHuntCfg.out_position_y, null);
/*     */         
/*     */ 
/* 230 */         TreasureHuntManager.onLeaveTreasureHunt(roleid, xRole2TreasureHuntWorldInfo.getTrigger_buff_set());
/*     */         
/* 232 */         TeamInterface.unRegisterJoinTeam(xRole2TreasureHuntWorldInfo.getWorld_id());
/*     */         
/* 234 */         MapInterface.destroyWorld(xRole2TreasureHuntWorldInfo.getWorld_id());
/* 235 */         session.stopTimer();
/* 236 */         Role2treasurehuntworld.remove(Long.valueOf(roleid));
/*     */         
/* 238 */         if ((sTreasureHuntCfg.all_pass_chapter_award_id > 0) && (isFirstPass))
/*     */         {
/* 240 */           AwardInterface.award(sTreasureHuntCfg.all_pass_chapter_award_id, userid, roleid, false, true, new AwardReason(LogReason.TREASURE_HUNT_AWARD, sTreasureHuntCfg.all_pass_chapter_award_id));
/*     */         }
/*     */         
/*     */ 
/* 244 */         SLeaveTreasureHuntSuccess sLeaveTreasureHuntSuccess = new SLeaveTreasureHuntSuccess();
/* 245 */         sLeaveTreasureHuntSuccess.activity_cfg_id = activityCfgId;
/*     */         
/* 247 */         OnlineManager.getInstance().send(roleid, sLeaveTreasureHuntSuccess);
/*     */         
/* 249 */         return true;
/*     */       }
/*     */       
/* 252 */       int nextChapterCfgId = ((Integer)sTreasureHuntCfg.chapter_id_list.get(nowProcess)).intValue();
/* 253 */       STreasureHuntChapterCfg sNewTreasureHuntChapterCfg = STreasureHuntChapterCfg.get(nextChapterCfgId);
/* 254 */       if (sNewTreasureHuntChapterCfg == null)
/*     */       {
/* 256 */         onFail(-8, roleid, mapCfgid, mapItemCfgid);
/* 257 */         return false;
/*     */       }
/*     */       
/* 260 */       xRole2TreasureHuntWorldInfo.setChapter_cfg_id(nextChapterCfgId);
/* 261 */       xRole2TreasureHuntWorldInfo.getTrigger_effect_map().clear();
/* 262 */       xRole2TreasureHuntWorldInfo.setProcess(0);
/* 263 */       session.stopTimer();
/*     */       
/* 265 */       TreasureHuntSceneSession newSession = new TreasureHuntSceneSession(sNewTreasureHuntChapterCfg.treasure_hunt_time * 60L, session.getOwerId(), session.getWroldId(), session.getActivityCfgId(), nextChapterCfgId);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 272 */       xRole2TreasureHuntWorldInfo.setSession_id(newSession.getSessionId());
/*     */       
/* 274 */       MapInterface.transferToScene(roleid, xRole2TreasureHuntWorldInfo.getWorld_id(), sNewTreasureHuntChapterCfg.map_cfg_id);
/*     */       
/*     */ 
/* 277 */       SAttendTreasureHuntSuccess sAttendTreasureSuccess = new SAttendTreasureHuntSuccess();
/* 278 */       sAttendTreasureSuccess.activity_cfg_id = activityCfgId;
/* 279 */       sAttendTreasureSuccess.left_seconds = ((int)(sNewTreasureHuntChapterCfg.treasure_hunt_time * 60L));
/* 280 */       sAttendTreasureSuccess.total = sNewTreasureHuntChapterCfg.map_item_num;
/* 281 */       sAttendTreasureSuccess.chapter_cfg_id = nextChapterCfgId;
/*     */       
/* 283 */       OnlineManager.getInstance().send(roleid, sAttendTreasureSuccess);
/*     */     }
/* 285 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int ret, long roleId, int mapCfgId, int mapItemCfgId)
/*     */   {
/* 290 */     StringBuilder sBuilder = new StringBuilder();
/* 291 */     sBuilder.append("[treasure_hunt]TreasureHuntMapItemHandler.onGather@gather item failed");
/* 292 */     sBuilder.append("|ret=").append(ret);
/* 293 */     sBuilder.append("|role_id=").append(roleId);
/* 294 */     sBuilder.append("|map_cfg_id=").append(mapCfgId);
/* 295 */     sBuilder.append("|map_item_cfg_id=").append(mapItemCfgId);
/*     */     
/* 297 */     GameServer.logger().error(sBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\main\TreasureHuntMapItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */