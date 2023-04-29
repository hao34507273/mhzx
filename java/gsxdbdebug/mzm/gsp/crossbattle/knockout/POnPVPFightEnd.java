/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import hub.ExchangeDataHandlerInfo;
/*     */ import hub.FightResult;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossserver.main.ReturnFromRoamServerHandlerManager;
/*     */ import mzm.gsp.crossserver.main.RoamedKnockOutContext;
/*     */ import mzm.gsp.crossserver.main.RoamedKnockOutRoleInfo;
/*     */ import mzm.gsp.crossserver.main.RoamedKnockOutTeamInfo;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.fight.event.PVPFightEndProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ 
/*     */ public class POnPVPFightEnd extends PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  25 */     if (!(((PVPFightEndArg)this.arg).context instanceof KnockOutFightContext))
/*     */     {
/*  27 */       return false;
/*     */     }
/*     */     
/*  30 */     KnockOutFightContext knockoutFightContext = (KnockOutFightContext)((PVPFightEndArg)this.arg).context;
/*  31 */     Set<String> allUsers = new HashSet();
/*  32 */     Set<Long> allRoles = new HashSet();
/*     */     
/*  34 */     Map<Long, String> activeMap = new HashMap();
/*  35 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).activeRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  37 */       String userid = RoleInterface.getUserId(roleid);
/*  38 */       activeMap.put(Long.valueOf(roleid), userid);
/*  39 */       allUsers.add(userid);
/*  40 */       allRoles.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/*  43 */     Map<Long, String> passiveMap = new HashMap();
/*  44 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).passiveRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  46 */       String userid = RoleInterface.getUserId(roleid);
/*  47 */       passiveMap.put(Long.valueOf(roleid), userid);
/*  48 */       allUsers.add(userid);
/*  49 */       allRoles.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/*  52 */     List<Long> activeRoleIdList = new ArrayList();
/*  53 */     List<Long> passiveRoleIdList = new ArrayList();
/*  54 */     RoamedKnockOutContext roamedKnockoutContext = knockoutFightContext.roamedCrossBattleContext;
/*     */     
/*  56 */     RoamedKnockOutTeamInfo ownCrossBattleTeamInfo = roamedKnockoutContext.crossBattleTeamInfo;
/*  57 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : ownCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/*  59 */       long roleid = roamedRoleCrossBattleInfo.getRoleid();
/*  60 */       activeRoleIdList.add(Long.valueOf(roleid));
/*  61 */       allRoles.add(Long.valueOf(roleid));
/*  62 */       allUsers.add(roamedRoleCrossBattleInfo.getUserid());
/*     */     }
/*     */     
/*  65 */     RoamedKnockOutTeamInfo opponentCrossBattleTeamInfo = roamedKnockoutContext.opponentCrossBattleTeamInfo;
/*  66 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/*  68 */       long roleid = roamedRoleCrossBattleInfo.getRoleid();
/*  69 */       passiveRoleIdList.add(Long.valueOf(roleid));
/*  70 */       allRoles.add(Long.valueOf(roleid));
/*  71 */       allUsers.add(roamedRoleCrossBattleInfo.getUserid());
/*     */     }
/*     */     
/*  74 */     lock(xtable.User.getTable(), allUsers);
/*  75 */     lock(xtable.Role2properties.getTable(), allRoles);
/*     */     
/*  77 */     Map<Long, ExchangeDataHandlerInfo> activeExchangeDateHandlerMap = new HashMap();
/*  78 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : ownCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/*  80 */       long roleid = roamedRoleCrossBattleInfo.getRoleid();
/*  81 */       ExchangeDataHandlerInfo handlerInfo = new ExchangeDataHandlerInfo();
/*  82 */       if (ReturnFromRoamServerHandlerManager.boxData((String)activeMap.get(Long.valueOf(roleid)), roleid, handlerInfo))
/*     */       {
/*  84 */         activeExchangeDateHandlerMap.put(Long.valueOf(roleid), handlerInfo);
/*     */       }
/*     */     }
/*     */     
/*  88 */     Map<Long, ExchangeDataHandlerInfo> passiveExchangeDateHandlerMap = new HashMap();
/*  89 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/*  91 */       long roleid = roamedRoleCrossBattleInfo.getRoleid();
/*  92 */       ExchangeDataHandlerInfo handlerInfo = new ExchangeDataHandlerInfo();
/*  93 */       if (ReturnFromRoamServerHandlerManager.boxData((String)passiveMap.get(Long.valueOf(roleid)), roleid, handlerInfo))
/*     */       {
/*  95 */         passiveExchangeDateHandlerMap.put(Long.valueOf(roleid), handlerInfo);
/*     */       }
/*     */     }
/*     */     
/*  99 */     StringBuilder sBuilder = new StringBuilder();
/* 100 */     sBuilder.append("[crossbattle_knockout]POnPVPFightEnd.processImp@pvp fight end");
/* 101 */     sBuilder.append("|active_role_id_list=").append(activeRoleIdList);
/* 102 */     sBuilder.append("|passive_role_id_list=").append(passiveRoleIdList);
/* 103 */     sBuilder.append("|roamed_cross_battle_context=").append(roamedKnockoutContext);
/* 104 */     sBuilder.append("|is_active_win=").append(((PVPFightEndArg)this.arg).isActiveWin);
/* 105 */     sBuilder.append("|is_force_close=").append(((PVPFightEndArg)this.arg).isForceEnd);
/* 106 */     sBuilder.append("|fight_id=").append(((PVPFightEndArg)this.arg).fightid);
/* 107 */     sBuilder.append("|round=").append(((PVPFightEndArg)this.arg).round);
/*     */     
/* 109 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/* 111 */     CrossBattleMatchRomaContextManager.getInstance().removeKeys(allRoles);
/*     */     
/* 113 */     FightResult fightResult = new FightResult();
/* 114 */     fightResult.fightid = ((PVPFightEndArg)this.arg).fightid;
/* 115 */     fightResult.intervalmilltime = ((PVPFightEndArg)this.arg).timeMills;
/* 116 */     fightResult.starttime = ((PVPFightEndArg)this.arg).startTime;
/* 117 */     fightResult.rounds = ((PVPFightEndArg)this.arg).round;
/* 118 */     fightResult.contextid = roamedKnockoutContext.roamedRoomInstanceid;
/*     */     
/* 120 */     CrossBattleKnockoutManager.onReturnOriginalServer(roamedKnockoutContext, roamedKnockoutContext.crossBattleTeamInfo, roamedKnockoutContext.opponentCrossBattleTeamInfo, ownCrossBattleTeamInfo.getPhysZoneId(), activeMap, activeRoleIdList, activeExchangeDateHandlerMap, ((PVPFightEndArg)this.arg).isActiveWin, fightResult);
/*     */     
/*     */ 
/*     */ 
/* 124 */     CrossBattleKnockoutManager.onReturnOriginalServer(roamedKnockoutContext, roamedKnockoutContext.opponentCrossBattleTeamInfo, roamedKnockoutContext.crossBattleTeamInfo, opponentCrossBattleTeamInfo.getPhysZoneId(), passiveMap, passiveRoleIdList, passiveExchangeDateHandlerMap, !((PVPFightEndArg)this.arg).isActiveWin, fightResult);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 129 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */