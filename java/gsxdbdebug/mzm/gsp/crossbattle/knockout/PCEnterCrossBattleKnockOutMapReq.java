/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xio.Protocol;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCEnterCrossBattleKnockOutMapReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int knockOutType;
/*     */   private int nowActivityCfgId;
/*     */   
/*     */   public PCEnterCrossBattleKnockOutMapReq(long roleId, int nowActivityCfgId, int knockOutType)
/*     */   {
/*  35 */     this.roleId = roleId;
/*  36 */     this.knockOutType = knockOutType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     this.nowActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*  43 */     if (!CrossBattleKnockoutManager.isCrossBattleKnockOutSwitchOpen(this.roleId, this.nowActivityCfgId, this.knockOutType))
/*     */     {
/*  45 */       onEnterCrossBattleKnockOutMapFailed(25);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.nowActivityCfgId);
/*  50 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  52 */       onEnterCrossBattleKnockOutMapFailed(12);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/*  57 */     if (knockOutCfg == null)
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(this.knockOutType);
/*  63 */     if (knockOutHandler == null)
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  69 */     if (teamId == null)
/*     */     {
/*  71 */       onEnterCrossBattleKnockOutMapFailed(14);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     List<Long> teamRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  76 */     List<String> teamRoleUserIdList = new ArrayList();
/*  77 */     for (Iterator i$ = teamRoleIdList.iterator(); i$.hasNext();) { long teamRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  79 */       String userId = mzm.gsp.role.main.RoleInterface.getUserId(teamRoleId);
/*  80 */       if (userId == null)
/*     */       {
/*  82 */         return false;
/*     */       }
/*  84 */       teamRoleUserIdList.add(userId);
/*     */     }
/*     */     
/*  87 */     lock(User.getTable(), teamRoleUserIdList);
/*  88 */     lock(xtable.Role2properties.getTable(), teamRoleIdList);
/*     */     
/*  90 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1560, true, true))
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (!TeamInterface.isAllTeamMemberNormal(teamId.longValue(), false))
/*     */     {
/*  97 */       onEnterCrossBattleKnockOutMapFailed(35);
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     long corpsId = mzm.gsp.corps.main.CorpsInterface.getRoleCorpsId(this.roleId, true);
/* 102 */     int fightZoneId = CrossBattleKnockoutManager.getFightZone(corpsId, this.nowActivityCfgId, this.knockOutType);
/* 103 */     if (fightZoneId < 0)
/*     */     {
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     if (((Long)teamRoleIdList.get(0)).longValue() != this.roleId)
/*     */     {
/* 110 */       onEnterCrossBattleKnockOutMapFailed(34);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(this.nowActivityCfgId);
/* 115 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = xtable.Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/* 116 */     if (xCrossBattleKnockoutActivityInfo == null)
/*     */     {
/* 118 */       onEnterCrossBattleKnockOutMapFailed(4);
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */     
/* 124 */     if (xCrossBattleKnockoutInfo == null)
/*     */     {
/* 126 */       onEnterCrossBattleKnockOutMapFailed(36);
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(fightZoneId));
/* 131 */     if (xFightZoneInfo == null)
/*     */     {
/* 133 */       onEnterCrossBattleKnockOutMapFailed(5);
/* 134 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 138 */     if (teamRoleIdList.size() < knockOutCfg.need_team_member_num)
/*     */     {
/* 140 */       Map<String, Object> extraMap = new HashMap();
/* 141 */       extraMap.put("need_number", Integer.valueOf(knockOutCfg.need_team_member_num));
/* 142 */       extraMap.put("number", Integer.valueOf(teamRoleIdList.size()));
/*     */       
/* 144 */       onEnterCrossBattleKnockOutMapFailed(13, extraMap);
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     Pair<Integer, Boolean> nowFinalStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.knockOutType);
/* 149 */     if (nowFinalStagePair == null)
/*     */     {
/* 151 */       onEnterCrossBattleKnockOutMapFailed(23);
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     int nowMaxFightIndexId = CrossBattleKnockoutManager.getMaxFightIndexId(knockOutCfg.need_team_size, ((Integer)nowFinalStagePair.first).intValue(), knockOutCfg.fight_times_every_stage);
/*     */     
/* 157 */     if (nowMaxFightIndexId < 0)
/*     */     {
/* 159 */       onEnterCrossBattleKnockOutMapFailed(29);
/* 160 */       return false;
/*     */     }
/*     */     
/* 163 */     FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(nowFinalStagePair.first);
/* 164 */     if (xFightStageInfo == null)
/*     */     {
/* 166 */       return false;
/*     */     }
/*     */     
/* 169 */     FightAgainstInfo xGoalFightAgainstInfo = null;
/* 170 */     int nowFightIndexId = 0;
/* 171 */     for (Map.Entry<Integer, FightAgainstInfo> entry : xFightStageInfo.getFight_against_info_map().entrySet())
/*     */     {
/* 173 */       nowFightIndexId = ((Integer)entry.getKey()).intValue();
/* 174 */       FightAgainstInfo xFightAgainstInfo = (FightAgainstInfo)entry.getValue();
/* 175 */       if ((xFightAgainstInfo.getA_corps_id() == corpsId) || (xFightAgainstInfo.getB_corps_id() == corpsId))
/*     */       {
/* 177 */         xGoalFightAgainstInfo = xFightAgainstInfo;
/* 178 */         break;
/*     */       }
/*     */     }
/*     */     
/* 182 */     if (xGoalFightAgainstInfo == null)
/*     */     {
/* 184 */       return false;
/*     */     }
/*     */     
/* 187 */     if ((xGoalFightAgainstInfo.getCal_fight_result() == FightResultEnum.A_BYE_WIN.fightResult) || (xGoalFightAgainstInfo.getCal_fight_result() == FightResultEnum.B_BYE_WIN.fightResult))
/*     */     {
/*     */ 
/* 190 */       onEnterCrossBattleKnockOutMapFailed(30);
/* 191 */       return false;
/*     */     }
/*     */     
/* 194 */     long corpsIdA = xGoalFightAgainstInfo.getA_corps_id();
/* 195 */     long corpsIdB = xGoalFightAgainstInfo.getB_corps_id();
/* 196 */     Pair<Long, Pair<Integer, Integer>> winCorpsIdPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), corpsIdA, corpsIdB, ((Integer)nowFinalStagePair.first).intValue() - 1, nowFightIndexId, knockOutCfg.fight_times_every_stage);
/*     */     
/*     */ 
/*     */ 
/* 200 */     if ((winCorpsIdPair != null) && (((Long)winCorpsIdPair.first).longValue() != -1L))
/*     */     {
/* 202 */       if (((Long)winCorpsIdPair.first).longValue() == corpsId)
/*     */       {
/* 204 */         onEnterCrossBattleKnockOutMapFailed(30);
/* 205 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 209 */       onEnterCrossBattleKnockOutMapFailed(31);
/* 210 */       return false;
/*     */     }
/*     */     
/* 213 */     List<Long> signUpRoleList = mzm.gsp.crossbattle.own.CrossBattleOwnInterface.getCrossBattleRegisterRoleList(corpsId, this.nowActivityCfgId, true);
/*     */     
/*     */ 
/*     */ 
/* 217 */     boolean isRoleSameWithSignUp = true;
/* 218 */     for (Iterator i$ = teamRoleIdList.iterator(); i$.hasNext();) { long teamRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 220 */       if (!signUpRoleList.contains(Long.valueOf(teamRoleId)))
/*     */       {
/* 222 */         isRoleSameWithSignUp = false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 227 */     if (!isRoleSameWithSignUp)
/*     */     {
/* 229 */       onEnterCrossBattleKnockOutMapFailed(15);
/* 230 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 234 */     Long worldId = CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldId();
/* 235 */     if (worldId == null)
/*     */     {
/* 237 */       onEnterCrossBattleKnockOutMapFailed(16);
/* 238 */       return false;
/*     */     }
/*     */     
/* 241 */     Long enterPrepareWorldEndTime = CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldLastEnterTime();
/* 242 */     if (enterPrepareWorldEndTime == null)
/*     */     {
/* 244 */       onEnterCrossBattleKnockOutMapFailed(17);
/* 245 */       return false;
/*     */     }
/*     */     
/* 248 */     long currentTimeMillis = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 249 */     long leftPrepareTime = enterPrepareWorldEndTime.longValue() - currentTimeMillis;
/* 250 */     if (leftPrepareTime < 0L)
/*     */     {
/* 252 */       Map<String, Object> extraMap = new HashMap();
/* 253 */       extraMap.put("current_time_millis", Long.valueOf(currentTimeMillis));
/* 254 */       extraMap.put("enter_prepare_world_end_time", enterPrepareWorldEndTime);
/* 255 */       extraMap.put("left_prepare_time", Long.valueOf(leftPrepareTime));
/*     */       
/* 257 */       onEnterCrossBattleKnockOutMapFailed(1, extraMap);
/* 258 */       return false;
/*     */     }
/* 260 */     if (!RoleStatusInterface.setStatus(teamRoleIdList, 1551, true))
/*     */     {
/*     */ 
/* 263 */       onEnterCrossBattleKnockOutMapFailed(32);
/* 264 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 268 */     MapInterface.transferAllRole(teamRoleIdList, worldId.longValue(), knockOutCfg.prepare_map_cfg_id);
/*     */     
/*     */ 
/* 271 */     Protocol protocol = knockOutHandler.getEnterPrepareWorldProtocol((int)(leftPrepareTime / 1000L));
/*     */     
/* 273 */     OnlineManager.getInstance().sendMulti(protocol, teamRoleIdList);
/*     */     
/* 275 */     StringBuilder sb = new StringBuilder();
/* 276 */     sb.append("[crossbattle_knockout]PCEnterCrossBattleKnockOutMapReq.processImp");
/* 277 */     sb.append("|role_id=").append(this.roleId);
/* 278 */     sb.append("|activity_cfg_id=").append(this.nowActivityCfgId);
/* 279 */     sb.append("|knockout_type=").append(this.knockOutType);
/*     */     
/* 281 */     GameServer.logger().info(sb.toString());
/*     */     
/* 283 */     return true;
/*     */   }
/*     */   
/*     */   private void onEnterCrossBattleKnockOutMapFailed(int ret)
/*     */   {
/* 288 */     onEnterCrossBattleKnockOutMapFailed(ret, null);
/*     */   }
/*     */   
/*     */   private void onEnterCrossBattleKnockOutMapFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 293 */     StringBuilder sb = new StringBuilder();
/* 294 */     sb.append("[crossbattle_knockout]PCEnterCrossBattleKnockOutMapReq.processImp@enter knockout map error");
/* 295 */     sb.append("|ret=").append(ret);
/* 296 */     sb.append("|role_id=").append(this.roleId);
/* 297 */     sb.append("|activity_cfg_id=").append(this.nowActivityCfgId);
/* 298 */     sb.append("|knockout_type=").append(this.knockOutType);
/*     */     
/* 300 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 302 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 304 */         sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 308 */     GameServer.logger().error(sb.toString());
/*     */     
/* 310 */     Protocol normalResProtocol = CrossBattleKnockoutManager.getNormalRes(this.knockOutType, ret);
/*     */     
/* 312 */     OnlineManager.getInstance().sendAtOnce(this.roleId, normalResProtocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PCEnterCrossBattleKnockOutMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */