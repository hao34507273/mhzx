/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import hub.FightResult;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossserver.main.RoamedKnockOutContext;
/*     */ import mzm.gsp.crossserver.main.RoamedKnockOutRoleInfo;
/*     */ import mzm.gsp.crossserver.main.RoamedKnockOutTeamInfo;
/*     */ import mzm.gsp.fight.event.PVPFightFailArg;
/*     */ import mzm.gsp.fight.event.PVPFightFailProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class POnPVPFightFail extends PVPFightFailProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     if (!(((PVPFightFailArg)this.arg).context instanceof KnockOutFightContext))
/*     */     {
/*  26 */       return false;
/*     */     }
/*     */     
/*  29 */     if (!mzm.gsp.GameServerInfoManager.isRoamServer())
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     Set<String> allUsers = new HashSet();
/*  35 */     Set<Long> allRoles = new HashSet();
/*     */     
/*  37 */     Map<Long, String> activeMap = new HashMap();
/*  38 */     for (Iterator i$ = ((PVPFightFailArg)this.arg).activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  40 */       String userid = RoleInterface.getUserId(roleid);
/*  41 */       activeMap.put(Long.valueOf(roleid), userid);
/*  42 */       allUsers.add(userid);
/*  43 */       allRoles.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/*  46 */     Map<Long, String> passiveMap = new HashMap();
/*  47 */     for (Iterator i$ = ((PVPFightFailArg)this.arg).passiveRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*  49 */       String userid = RoleInterface.getUserId(roleid);
/*  50 */       passiveMap.put(Long.valueOf(roleid), userid);
/*  51 */       allUsers.add(userid);
/*  52 */       allRoles.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/*  55 */     List<Long> activeRoles = new ArrayList();
/*  56 */     List<Long> passiveRoles = new ArrayList();
/*  57 */     RoamedKnockOutContext roamedMatchContext = ((KnockOutFightContext)((PVPFightFailArg)this.arg).context).roamedCrossBattleContext;
/*  58 */     for (RoamedKnockOutRoleInfo roamedRoleMatchMarkingInfo : roamedMatchContext.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/*  60 */       long roleid = roamedRoleMatchMarkingInfo.getRoleid();
/*  61 */       activeRoles.add(Long.valueOf(roleid));
/*  62 */       allRoles.add(Long.valueOf(roleid));
/*  63 */       allUsers.add(roamedRoleMatchMarkingInfo.getUserid());
/*     */     }
/*  65 */     for (RoamedKnockOutRoleInfo roamedRoleMatchMarkingInfo : roamedMatchContext.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/*  67 */       long roleid = roamedRoleMatchMarkingInfo.getRoleid();
/*  68 */       passiveRoles.add(Long.valueOf(roleid));
/*  69 */       allRoles.add(Long.valueOf(roleid));
/*  70 */       allUsers.add(roamedRoleMatchMarkingInfo.getUserid());
/*     */     }
/*     */     
/*  73 */     GameServer.logger().info(String.format("[crossbattle_knockout]POnPVPFightFail.processImp@excuted|activeRoles=%s|passiveRoles=%s", new Object[] { activeRoles, passiveRoles }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  78 */     CrossBattleMatchRomaContextManager.getInstance().removeKeys(allRoles);
/*     */     
/*  80 */     lock(xtable.User.getTable(), allUsers);
/*  81 */     lock(xtable.Role2properties.getTable(), allRoles);
/*     */     
/*  83 */     Map<Long, hub.ExchangeDataHandlerInfo> activeExchangeDateHandlerMap = new HashMap();
/*     */     
/*  85 */     Map<Long, hub.ExchangeDataHandlerInfo> passiveExchangeDateHandlerMap = new HashMap();
/*     */     
/*     */ 
/*  88 */     CrossBattleKnockoutManager.onReturnOriginalServer(roamedMatchContext, roamedMatchContext.crossBattleTeamInfo, roamedMatchContext.opponentCrossBattleTeamInfo, roamedMatchContext.crossBattleTeamInfo.getPhysZoneId(), activeMap, activeRoles, activeExchangeDateHandlerMap, false, new FightResult());
/*     */     
/*     */ 
/*     */ 
/*  92 */     CrossBattleKnockoutManager.onReturnOriginalServer(roamedMatchContext, roamedMatchContext.opponentCrossBattleTeamInfo, roamedMatchContext.crossBattleTeamInfo, roamedMatchContext.opponentCrossBattleTeamInfo.getPhysZoneId(), passiveMap, passiveRoles, passiveExchangeDateHandlerMap, false, new FightResult());
/*     */     
/*     */ 
/*     */ 
/*  96 */     StringBuilder sBuilder = new StringBuilder();
/*  97 */     sBuilder.append("[crossbattle_knockout]POnPVPFightFail.processImp@pvp fight fail");
/*  98 */     sBuilder.append("|active_role_id_list=").append(activeRoles);
/*  99 */     sBuilder.append("|passive_role_id_list=").append(passiveRoles);
/* 100 */     sBuilder.append("|roamed_cross_battle_context=").append(roamedMatchContext);
/*     */     
/* 102 */     GameServer.logger().info(sBuilder.toString());
/* 103 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnPVPFightFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */