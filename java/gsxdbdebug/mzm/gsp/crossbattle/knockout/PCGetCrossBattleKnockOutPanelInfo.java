/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext;
/*     */ import mzm.gsp.crossbattle.GetKnockOutContext_CheckPanelReq;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xio.Protocol;
/*     */ import xtable.Cross_battle_knockout;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetCrossBattleKnockOutPanelInfo extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int knockoutType;
/*     */   private int nowActivityCfgId;
/*     */   
/*     */   public PCGetCrossBattleKnockOutPanelInfo(long roleId, int knockoutType)
/*     */   {
/*  43 */     this.roleId = roleId;
/*  44 */     this.knockoutType = knockoutType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     this.nowActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*  51 */     if (!CrossBattleKnockoutManager.isCrossBattleKnockOutSwitchOpen(this.roleId, this.nowActivityCfgId, this.knockoutType))
/*     */     {
/*  53 */       onGetCrossBattleKnockoutPanelInfo(25);
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     long corpsId = CorpsInterface.getRoleCorpsId(this.roleId, true);
/*  58 */     if (corpsId < 0L)
/*     */     {
/*  60 */       onGetCrossBattleKnockoutPanelInfo(18);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1558, true, true))
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     int ownFightZoneId = CrossBattleKnockoutManager.getFightZone(corpsId, this.nowActivityCfgId, this.knockoutType);
/*  70 */     if (ownFightZoneId <= 0)
/*     */     {
/*  72 */       onGetCrossBattleKnockoutPanelInfo(19);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.nowActivityCfgId);
/*  77 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  79 */       onGetCrossBattleKnockoutPanelInfo(12);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockoutType));
/*  84 */     if (knockOutCfg == null)
/*     */     {
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.nowActivityCfgId);
/*  90 */     Pair<Integer, Boolean> pair = CrossBattleKnockoutInterface.getNowFightStage(this.knockoutType);
/*  91 */     if (pair == null)
/*     */     {
/*  93 */       onGetCrossBattleKnockoutPanelInfo(23);
/*  94 */       return false;
/*     */     }
/*     */     
/*  97 */     boolean isNeedRefresh = ((Boolean)pair.second).booleanValue();
/*     */     
/*  99 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/*     */     
/* 101 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = null;
/* 102 */     if (xCrossBattleKnockoutActivityInfo != null)
/*     */     {
/* 104 */       xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockoutType));
/*     */     }
/*     */     
/* 107 */     FightZoneInfo xFightZoneInfo = null;
/* 108 */     if (xCrossBattleKnockoutInfo != null)
/*     */     {
/* 110 */       xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(ownFightZoneId));
/*     */     }
/*     */     
/* 113 */     if ((xCrossBattleKnockoutActivityInfo == null) || (xCrossBattleKnockoutInfo == null) || (xFightZoneInfo == null) || (isNeedRefresh))
/*     */     {
/*     */ 
/* 116 */       GetKnockOutContext_CheckPanelReq context = new GetKnockOutContext_CheckPanelReq(this.roleId);
/* 117 */       OctetsStream octetsStream = new OctetsStream();
/* 118 */       octetsStream.marshal(context);
/*     */       
/* 120 */       GetKnockOutContext getKnockOutContext = new GetKnockOutContext();
/* 121 */       getKnockOutContext.oper_type = 0;
/* 122 */       getKnockOutContext.content = octetsStream;
/*     */       
/* 124 */       Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.knockoutType);
/* 125 */       if (nowFightStagePair == null)
/*     */       {
/* 127 */         onGetCrossBattleKnockoutPanelInfo(23);
/* 128 */         return false;
/*     */       }
/*     */       
/* 131 */       int nowKnockOutStage = ((Integer)nowFightStagePair.first).intValue();
/* 132 */       return mzm.gsp.grc.main.GrcInterface.getCrossBattleKnockOutInfo(this.nowActivityCfgId, this.knockoutType, ownFightZoneId, nowKnockOutStage, knockOutCfg.need_team_size, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 137 */     new PNotifyCrossBattleKnockOutPanelInfo(this.roleId, this.knockoutType).execute();
/*     */     
/* 139 */     return true;
/*     */   }
/*     */   
/*     */   private void onGetCrossBattleKnockoutPanelInfo(int ret)
/*     */   {
/* 144 */     onGetCrossBattleKnockOutPanelInfo(ret, null);
/*     */   }
/*     */   
/*     */   private void onGetCrossBattleKnockOutPanelInfo(int ret, Map<String, Object> extraMap)
/*     */   {
/* 149 */     StringBuilder sb = new StringBuilder();
/* 150 */     sb.append("[crossbattle_selection]PCGetCrossBattleSelectionPanelInfo.processImp");
/* 151 */     sb.append("|ret=").append(ret);
/* 152 */     sb.append("|role_id=").append(this.roleId);
/*     */     
/* 154 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 156 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 158 */         sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 162 */     GameServer.logger().error(sb.toString());
/*     */     
/* 164 */     Protocol normalRes = CrossBattleKnockoutManager.getNormalRes(this.knockoutType, ret);
/*     */     
/* 166 */     OnlineManager.getInstance().sendAtOnce(this.roleId, normalRes);
/*     */   }
/*     */   
/*     */   public static class PNotifyCrossBattleKnockOutPanelInfo
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     private final int knockOutType;
/*     */     
/*     */     public PNotifyCrossBattleKnockOutPanelInfo(long roleId, int knockOutType)
/*     */     {
/* 177 */       this.roleId = roleId;
/* 178 */       this.knockOutType = knockOutType;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 184 */       Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/* 185 */       Set<String> userIdSet = new HashSet();
/* 186 */       Set<Long> roleIdSet = new HashSet();
/* 187 */       roleIdSet.add(Long.valueOf(this.roleId));
/*     */       
/* 189 */       String userId = RoleInterface.getUserId(this.roleId);
/* 190 */       if (userId == null)
/*     */       {
/* 192 */         onNotifyCrossBattleSelectionPanelInfo(11);
/* 193 */         return false;
/*     */       }
/* 195 */       userIdSet.add(userId);
/*     */       
/* 197 */       if (teamId != null)
/*     */       {
/* 199 */         List<Long> teamRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 200 */         List<String> teamRoleUserIdList = new ArrayList();
/* 201 */         for (Iterator i$ = teamRoleIdList.iterator(); i$.hasNext();) { long teamRoleId = ((Long)i$.next()).longValue();
/*     */           
/* 203 */           String teamUserId = RoleInterface.getUserId(teamRoleId);
/* 204 */           if (teamUserId == null)
/*     */           {
/* 206 */             onNotifyCrossBattleSelectionPanelInfo(11);
/* 207 */             return false;
/*     */           }
/* 209 */           teamRoleUserIdList.add(teamUserId);
/*     */         }
/* 211 */         userIdSet.addAll(teamRoleUserIdList);
/* 212 */         roleIdSet.addAll(teamRoleIdList);
/*     */       }
/*     */       
/* 215 */       lock(User.getTable(), userIdSet);
/* 216 */       lock(xtable.Role2properties.getTable(), roleIdSet);
/*     */       
/* 218 */       boolean teamStatus = true;
/* 219 */       if (teamId != null)
/*     */       {
/* 221 */         if (!TeamInterface.isAllTeamMemberNormal(teamId.longValue(), true))
/*     */         {
/* 223 */           teamStatus = false;
/*     */         }
/*     */       }
/* 226 */       int nowActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*     */       
/* 228 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(nowActivityCfgId);
/* 229 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 231 */         onNotifyCrossBattleSelectionPanelInfo(12);
/* 232 */         return false;
/*     */       }
/*     */       
/* 235 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 236 */       if (knockOutCfg == null)
/*     */       {
/* 238 */         return false;
/*     */       }
/*     */       
/* 241 */       long corpsId = CorpsInterface.getRoleCorpsId(this.roleId, true);
/* 242 */       if (corpsId < 0L)
/*     */       {
/* 244 */         onNotifyCrossBattleSelectionPanelInfo(18);
/* 245 */         return false;
/*     */       }
/*     */       
/* 248 */       CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(corpsId, true);
/* 249 */       if (corpsInfo == null)
/*     */       {
/* 251 */         return false;
/*     */       }
/*     */       
/* 254 */       int ownFightZoneId = CrossBattleKnockoutManager.getFightZone(corpsId, nowActivityCfgId, this.knockOutType);
/* 255 */       if (ownFightZoneId < 0)
/*     */       {
/* 257 */         onNotifyCrossBattleSelectionPanelInfo(19);
/* 258 */         return false;
/*     */       }
/*     */       
/* 261 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(nowActivityCfgId);
/*     */       
/* 263 */       CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/* 264 */       if (xCrossBattleKnockoutActivityInfo == null)
/*     */       {
/* 266 */         onNotifyCrossBattleSelectionPanelInfo(4);
/* 267 */         return false;
/*     */       }
/*     */       
/* 270 */       CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */       
/* 272 */       if (xCrossBattleKnockoutInfo == null)
/*     */       {
/* 274 */         return false;
/*     */       }
/*     */       
/* 277 */       FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(ownFightZoneId));
/* 278 */       if (xFightZoneInfo == null)
/*     */       {
/* 280 */         onNotifyCrossBattleSelectionPanelInfo(5);
/* 281 */         return false;
/*     */       }
/*     */       
/* 284 */       byte isFiveRoleTeam = 0;
/* 285 */       byte isInOneCorps = 0;
/* 286 */       byte isCanTakePartInKnockOut = 0;
/* 287 */       byte isRoleSameWithSignUp = 0;
/*     */       
/* 289 */       isFiveRoleTeam = (byte)((roleIdSet.size() >= knockOutCfg.need_team_member_num) && (teamId != null) ? 1 : 0);
/* 290 */       if ((teamId != null) && (isFiveRoleTeam == 1))
/*     */       {
/* 292 */         isFiveRoleTeam = teamStatus ? 1 : 0;
/*     */       }
/*     */       
/* 295 */       if (corpsId > 0L)
/*     */       {
/* 297 */         Set<Long> allMemberRoleIdList = corpsInfo.getAllMemberIds();
/* 298 */         if (allMemberRoleIdList.containsAll(roleIdSet))
/*     */         {
/* 300 */           isInOneCorps = 1;
/*     */         }
/*     */         else
/*     */         {
/* 304 */           isInOneCorps = 0;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 309 */         isInOneCorps = 0;
/*     */       }
/*     */       
/* 312 */       Map<Long, FightCorpsInfo> xFightCorpsInfoMap = xFightZoneInfo.getFight_corps_info_map();
/*     */       
/* 314 */       FightCorpsInfo xFightCorpsInfo = (FightCorpsInfo)xFightCorpsInfoMap.get(Long.valueOf(corpsId));
/* 315 */       if (xFightCorpsInfo == null)
/*     */       {
/*     */ 
/* 318 */         isCanTakePartInKnockOut = 0;
/* 319 */         isRoleSameWithSignUp = 0;
/*     */       }
/*     */       else
/*     */       {
/* 323 */         isRoleSameWithSignUp = 1;
/*     */         
/* 325 */         List<Long> corpsSignUpRoleIdList = mzm.gsp.crossbattle.own.CrossBattleOwnInterface.getCrossBattleRegisterRoleList(corpsId, nowActivityCfgId, true);
/*     */         
/* 327 */         for (Iterator i$ = roleIdSet.iterator(); i$.hasNext();) { long teamRoleId = ((Long)i$.next()).longValue();
/*     */           
/* 329 */           if (!corpsSignUpRoleIdList.contains(Long.valueOf(teamRoleId)))
/*     */           {
/* 331 */             isRoleSameWithSignUp = 0;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 336 */         boolean isCorpsIdCanTakePartInSelection = CrossBattleKnockoutManager.isCanTakePartInKnockOut(corpsId, xFightZoneInfo, this.knockOutType);
/*     */         
/*     */ 
/* 339 */         boolean isTeamCanTakePartInSelection = (isCorpsIdCanTakePartInSelection) && (isRoleSameWithSignUp == 1);
/* 340 */         isCanTakePartInKnockOut = (byte)(isTeamCanTakePartInSelection ? 1 : 0);
/*     */       }
/*     */       
/* 343 */       Protocol sGetPanelInfoProtocol = getCrossBattleKnockPanelInfo(this.knockOutType, isFiveRoleTeam, isInOneCorps, isCanTakePartInKnockOut, isRoleSameWithSignUp);
/*     */       
/*     */ 
/* 346 */       OnlineManager.getInstance().send(this.roleId, sGetPanelInfoProtocol);
/*     */       
/* 348 */       StringBuilder sb = new StringBuilder();
/* 349 */       sb.append("[crossbattle]PCGetCrossBattleSelectionPanelInfo.processImp@success");
/* 350 */       sb.append("|role_id=").append(this.roleId);
/*     */       
/* 352 */       GameServer.logger().info(sb.toString());
/*     */       
/* 354 */       return true;
/*     */     }
/*     */     
/*     */     private void onNotifyCrossBattleSelectionPanelInfo(int ret)
/*     */     {
/* 359 */       onNotifyCrossBattleSelectionPanelInfo(ret, null);
/*     */     }
/*     */     
/*     */     private void onNotifyCrossBattleSelectionPanelInfo(int ret, Map<String, Object> extraMap)
/*     */     {
/* 364 */       StringBuilder sb = new StringBuilder();
/* 365 */       sb.append("[crossbattle_selection]PCGetCrossBattleKnockoutPanelInfo.processImp");
/* 366 */       sb.append("|role_id=").append(this.roleId);
/* 367 */       sb.append("|ret=").append(ret);
/*     */       
/* 369 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 371 */         for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */         {
/* 373 */           sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */         }
/*     */       }
/*     */       
/* 377 */       GameServer.logger().error(sb.toString());
/*     */       
/* 379 */       Protocol normalRes = CrossBattleKnockoutManager.getNormalRes(this.knockOutType, ret);
/*     */       
/* 381 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalRes);
/*     */     }
/*     */     
/*     */ 
/*     */     private Protocol getCrossBattleKnockPanelInfo(int knockType, byte isFiveRoleTeam, byte isInOneCorps, byte isCanTakePartIn, byte isSameWithSignUp)
/*     */     {
/* 387 */       switch (knockType)
/*     */       {
/*     */       case 1: 
/* 390 */         return new mzm.gsp.crossbattle.SCrossBattleSelectionPanelInfo(isFiveRoleTeam, isInOneCorps, isCanTakePartIn, isSameWithSignUp);
/*     */       
/*     */       case 2: 
/* 393 */         return new mzm.gsp.crossbattle.SCrossBattleFinalPanelInfo(isFiveRoleTeam, isInOneCorps, isCanTakePartIn, isSameWithSignUp);
/*     */       }
/*     */       
/* 396 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PCGetCrossBattleKnockOutPanelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */