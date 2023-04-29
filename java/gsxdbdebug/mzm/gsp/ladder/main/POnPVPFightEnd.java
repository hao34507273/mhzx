/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import hub.FightResult;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossserver.main.RoamedMatchContext;
/*     */ import mzm.gsp.crossserver.main.RoamedRoleMatchMarkingInfo;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.fight.event.PVPFightEndArg;
/*     */ import mzm.gsp.ladder.RoleEndRetInfo;
/*     */ import mzm.gsp.ladder.SMatchFightEndRet;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.ELO;
/*     */ import mzm.gsp.util.ELO.MatchResult;
/*     */ import mzm.gsp.util.ELO.RankResult;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class POnPVPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  31 */     if (!(((PVPFightEndArg)this.arg).context instanceof LadderFightContext)) {
/*  32 */       return false;
/*     */     }
/*  34 */     LadderFightContext ladderFightContext = (LadderFightContext)((PVPFightEndArg)this.arg).context;
/*  35 */     Set<String> allUsers = new HashSet();
/*  36 */     Set<Long> allRoles = new HashSet();
/*     */     
/*  38 */     Map<Long, String> activeMap = new HashMap();
/*  39 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).activeRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  40 */       String userid = RoleInterface.getUserId(roleid);
/*  41 */       activeMap.put(Long.valueOf(roleid), userid);
/*  42 */       allUsers.add(userid);
/*  43 */       allRoles.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/*  46 */     Map<Long, String> passiveMap = new HashMap();
/*  47 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).passiveRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  48 */       String userid = RoleInterface.getUserId(roleid);
/*  49 */       passiveMap.put(Long.valueOf(roleid), userid);
/*  50 */       allUsers.add(userid);
/*  51 */       allRoles.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/*  54 */     long tempRoleid = ((Long)((PVPFightEndArg)this.arg).activeRoleList.get(0)).longValue();
/*  55 */     List<Long> activeRoles = new ArrayList();
/*  56 */     List<Long> passiveRoles = new ArrayList();
/*  57 */     Map<Long, Integer> role2RankingMap = new HashMap();
/*  58 */     RoamedMatchContext roamedMatchContext = (RoamedMatchContext)LadderMatchRomaContextManager.getInstance().getValue(Long.valueOf(tempRoleid));
/*  59 */     if (roamedMatchContext != null) {
/*  60 */       for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : roamedMatchContext.roleMatchMarkingInfos) {
/*  61 */         long roleid = roamedRoleMatchMarkingInfo.getRoleid();
/*  62 */         activeRoles.add(Long.valueOf(roleid));
/*  63 */         allRoles.add(Long.valueOf(roleid));
/*  64 */         allUsers.add(roamedRoleMatchMarkingInfo.getUserid());
/*  65 */         role2RankingMap.put(Long.valueOf(roleid), Integer.valueOf(roamedRoleMatchMarkingInfo.getRanking()));
/*     */       }
/*  67 */       for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : roamedMatchContext.opponentRoleMatchMarkingInfos) {
/*  68 */         long roleid = roamedRoleMatchMarkingInfo.getRoleid();
/*  69 */         passiveRoles.add(Long.valueOf(roleid));
/*  70 */         allRoles.add(Long.valueOf(roleid));
/*  71 */         allUsers.add(roamedRoleMatchMarkingInfo.getUserid());
/*  72 */         role2RankingMap.put(Long.valueOf(roleid), Integer.valueOf(roamedRoleMatchMarkingInfo.getRanking()));
/*     */       }
/*     */     } else {
/*  75 */       GameServer.logger().error(String.format("[Ladder]POnPVPFightEnd.processImp@do not exist matchContex|roleid=%d", new Object[] { Long.valueOf(tempRoleid) }));
/*     */       
/*  77 */       activeRoles.addAll(((PVPFightEndArg)this.arg).activeRoleList);
/*  78 */       passiveRoles.addAll(((PVPFightEndArg)this.arg).passiveRoleList);
/*     */     }
/*     */     
/*  81 */     GameServer.logger().info(String.format("[Ladder]POnPVPFightEnd.processImp@excuted|activeRoles=%s|passiveRoles=%s", new Object[] { activeRoles, passiveRoles }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  86 */     LadderMatchRomaContextManager.getInstance().removeKeys(allRoles);
/*     */     
/*  88 */     lock(xtable.User.getTable(), allUsers);
/*  89 */     lock(xtable.Role2properties.getTable(), allRoles);
/*     */     
/*  91 */     int rankA = ladderFightContext.rankA;
/*  92 */     int rankB = ladderFightContext.rankB;
/*  93 */     Map<Long, Integer> role2RankChangeMap = new HashMap();
/*  94 */     ELO.RankResult rankResultA = null;
/*  95 */     ELO.RankResult rankResultB = null;
/*  96 */     if (((PVPFightEndArg)this.arg).isActiveWin) {
/*  97 */       rankResultA = ELO.getELORankResult(rankA, rankB, LadderManager.getEloK(rankA), ELO.MatchResult.Win);
/*  98 */       rankResultB = ELO.getELORankResult(rankA, rankB, LadderManager.getEloK(rankB), ELO.MatchResult.Win);
/*     */     } else {
/* 100 */       rankResultA = ELO.getELORankResult(rankA, rankB, LadderManager.getEloK(rankA), ELO.MatchResult.Lose);
/* 101 */       rankResultB = ELO.getELORankResult(rankA, rankB, LadderManager.getEloK(rankB), ELO.MatchResult.Lose);
/*     */     }
/* 103 */     int rankAChange = rankResultA.getRankA() - rankA;
/* 104 */     int rankBChange = rankResultB.getRankB() - rankB;
/*     */     Map<Long, Integer> calRankChangeMap;
/* 106 */     if (!OpenInterface.getOpenStatus(237)) {
/* 107 */       for (Map.Entry<Long, Integer> role2RankEntry : role2RankingMap.entrySet()) {
/* 108 */         long roleid = ((Long)role2RankEntry.getKey()).longValue();
/* 109 */         int ranking = ((Integer)role2RankEntry.getValue()).intValue();
/* 110 */         if (activeMap.containsKey(Long.valueOf(roleid))) {
/* 111 */           calRankChange(rankAChange, role2RankChangeMap, roleid, ranking);
/* 112 */         } else if (passiveMap.containsKey(Long.valueOf(roleid))) {
/* 113 */           calRankChange(rankBChange, role2RankChangeMap, roleid, ranking);
/*     */         } else {
/* 115 */           GameServer.logger().error(String.format("[Ladder]POnPVPFightEnd.processImp@do not exist role|roleid=%d|allFightRoles=%s", new Object[] { Long.valueOf(roleid), ((PVPFightEndArg)this.arg).getAllRoles() }));
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 122 */       calRankChangeMap = new HashMap();
/*     */       
/* 124 */       for (Iterator i$ = activeMap.keySet().iterator(); i$.hasNext();) { long activeRoleid = ((Long)i$.next()).longValue();
/* 125 */         if (OpenInterface.getOpenStatus(330))
/*     */         {
/* 127 */           calEloRankChange(activeRoleid, role2RankingMap, rankB, calRankChangeMap, ((PVPFightEndArg)this.arg).isActiveWin);
/*     */         }
/* 129 */         else if (OpenInterface.isGrayValid(activeRoleid)) {
/* 130 */           calEloRankChange(activeRoleid, role2RankingMap, rankB, calRankChangeMap, ((PVPFightEndArg)this.arg).isActiveWin);
/*     */         } else {
/* 132 */           calRankChangeMap.put(Long.valueOf(activeRoleid), Integer.valueOf(rankAChange));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 137 */       for (Iterator i$ = passiveMap.keySet().iterator(); i$.hasNext();) { long passiveRoleid = ((Long)i$.next()).longValue();
/* 138 */         if (OpenInterface.getOpenStatus(330))
/*     */         {
/* 140 */           calEloRankChange(passiveRoleid, role2RankingMap, rankA, calRankChangeMap, !((PVPFightEndArg)this.arg).isActiveWin);
/*     */ 
/*     */         }
/* 143 */         else if (OpenInterface.isGrayValid(passiveRoleid)) {
/* 144 */           calEloRankChange(passiveRoleid, role2RankingMap, rankA, calRankChangeMap, !((PVPFightEndArg)this.arg).isActiveWin);
/*     */         } else {
/* 146 */           calRankChangeMap.put(Long.valueOf(passiveRoleid), Integer.valueOf(rankBChange));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 152 */       for (Map.Entry<Long, Integer> role2RankEntry : role2RankingMap.entrySet()) {
/* 153 */         long roleid = ((Long)role2RankEntry.getKey()).longValue();
/* 154 */         int ranking = ((Integer)role2RankEntry.getValue()).intValue();
/* 155 */         if (calRankChangeMap.containsKey(Long.valueOf(roleid))) {
/* 156 */           calRankChange(((Integer)calRankChangeMap.get(Long.valueOf(roleid))).intValue(), role2RankChangeMap, roleid, ranking);
/*     */         } else {
/* 158 */           GameServer.logger().error(String.format("[Ladder]POnPVPFightEnd.processImp@do not exist role|roleid=%d|allFightRoles=%s", new Object[] { Long.valueOf(roleid), ((PVPFightEndArg)this.arg).getAllRoles() }));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 166 */     Map<Long, Long> role2TokenMap = new HashMap();
/* 167 */     calToken(activeMap, ((PVPFightEndArg)this.arg).isActiveWin, ladderFightContext.role2DisPlayRankMap, role2TokenMap);
/* 168 */     calToken(passiveMap, !((PVPFightEndArg)this.arg).isActiveWin, ladderFightContext.role2DisPlayRankMap, role2TokenMap);
/* 169 */     sendEndFightRet(role2RankChangeMap);
/* 170 */     FightResult fightResult = new FightResult();
/* 171 */     fightResult.fightid = ((PVPFightEndArg)this.arg).fightid;
/* 172 */     fightResult.intervalmilltime = ((PVPFightEndArg)this.arg).timeMills;
/* 173 */     fightResult.starttime = ((PVPFightEndArg)this.arg).startTime;
/* 174 */     fightResult.rounds = ((PVPFightEndArg)this.arg).round;
/* 175 */     fightResult.contextid = ladderFightContext.roamedMatchContext.roamedRoomInstanceid;
/*     */     
/* 177 */     Map<Long, Map<Long, Integer>> childid2LostCharacter = new HashMap();
/* 178 */     SFightTypeCfg sFightTypeCfg = mzm.gsp.fight.main.FightInterface.getFightTypeCfg(((PVPFightEndArg)this.arg).fightCfgType);
/* 179 */     if (sFightTypeCfg != null) {
/* 180 */       for (Map.Entry<Long, List<Long>> role2ChildrenEntry : ((PVPFightEndArg)this.arg).roleChildrenMap.entrySet()) {
/* 181 */         long roleid = ((Long)role2ChildrenEntry.getKey()).longValue();
/* 182 */         List<Long> children = (List)role2ChildrenEntry.getValue();
/* 183 */         child2LostChaMap = (Map)childid2LostCharacter.get(Long.valueOf(roleid));
/* 184 */         if (child2LostChaMap == null) {
/* 185 */           child2LostChaMap = new HashMap();
/* 186 */           childid2LostCharacter.put(Long.valueOf(roleid), child2LostChaMap);
/*     */         }
/* 188 */         for (i$ = children.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/* 189 */           if (((PVPFightEndArg)this.arg).deadChildrens.contains(Long.valueOf(childid))) {
/* 190 */             child2LostChaMap.put(Long.valueOf(childid), Integer.valueOf(sFightTypeCfg.childDeadLostCharacter));
/*     */           } else {
/* 192 */             child2LostChaMap.put(Long.valueOf(childid), Integer.valueOf(sFightTypeCfg.childAliveLostCharater));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     Map<Long, Integer> child2LostChaMap;
/*     */     Iterator i$;
/* 199 */     LadderManager.onReturnOriginalServer(activeMap, activeRoles, ((PVPFightEndArg)this.arg).isActiveWin, role2RankChangeMap, role2TokenMap, ((PVPFightEndArg)this.arg).rolePetMap, childid2LostCharacter, fightResult);
/*     */     
/* 201 */     LadderManager.onReturnOriginalServer(passiveMap, passiveRoles, !((PVPFightEndArg)this.arg).isActiveWin, role2RankChangeMap, role2TokenMap, ((PVPFightEndArg)this.arg).rolePetMap, childid2LostCharacter, fightResult);
/*     */     
/* 203 */     return true;
/*     */   }
/*     */   
/*     */   private void calEloRankChange(long roleid, Map<Long, Integer> role2RankingMap, int teamRank, Map<Long, Integer> calRankChangeMap, boolean win)
/*     */   {
/* 208 */     Integer roleRank = (Integer)role2RankingMap.get(Long.valueOf(roleid));
/* 209 */     if (roleRank == null) {
/* 210 */       GameServer.logger().info(String.format("[Ladder]POnPVPFightEnd.calEloRankChange@roleRank is null|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/* 212 */       return;
/*     */     }
/* 214 */     ELO.RankResult tmpRank = null;
/* 215 */     if (win) {
/* 216 */       tmpRank = ELO.getELORankResult(roleRank.intValue(), teamRank, LadderManager.getEloK(roleRank.intValue()), ELO.MatchResult.Win);
/*     */     } else {
/* 218 */       tmpRank = ELO.getELORankResult(roleRank.intValue(), teamRank, LadderManager.getEloK(roleRank.intValue()), ELO.MatchResult.Lose);
/*     */     }
/* 220 */     int tmpRankChange = tmpRank.getRankA() - roleRank.intValue();
/* 221 */     if (win) {
/* 222 */       tmpRankChange = Math.max(1, tmpRankChange);
/*     */     }
/* 224 */     calRankChangeMap.put(Long.valueOf(roleid), Integer.valueOf(tmpRankChange));
/*     */   }
/*     */   
/*     */   private void calRankChange(int rankChange, Map<Long, Integer> role2RankChangeMap, long roleid, int ranking) {
/* 228 */     int minScore = LadderManager.getMinScore(RoleInterface.getLevel(roleid));
/* 229 */     if (rankChange < 0) {
/* 230 */       if (ranking < minScore) {
/* 231 */         role2RankChangeMap.put(Long.valueOf(roleid), Integer.valueOf(0));
/*     */       }
/* 233 */       else if (ranking + rankChange < minScore) {
/* 234 */         role2RankChangeMap.put(Long.valueOf(roleid), Integer.valueOf(minScore - ranking));
/*     */       } else {
/* 236 */         role2RankChangeMap.put(Long.valueOf(roleid), Integer.valueOf(rankChange));
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/* 241 */       role2RankChangeMap.put(Long.valueOf(roleid), Integer.valueOf(rankChange));
/*     */     }
/*     */   }
/*     */   
/*     */   private void sendEndFightRet(Map<Long, Integer> role2RankChangeMap) {
/* 246 */     SMatchFightEndRet matchFightEndActiveRet = new SMatchFightEndRet();
/* 247 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).activeRoleList.iterator(); i$.hasNext();) { long activeRoleid = ((Long)i$.next()).longValue();
/* 248 */       RoleEndRetInfo roleEndRetInfo = new RoleEndRetInfo();
/* 249 */       roleEndRetInfo.roleid = activeRoleid;
/* 250 */       Integer changeScroe = (Integer)role2RankChangeMap.get(Long.valueOf(activeRoleid));
/* 251 */       if (changeScroe == null) {
/* 252 */         changeScroe = Integer.valueOf(0);
/*     */       }
/* 254 */       roleEndRetInfo.fightscore = changeScroe.intValue();
/* 255 */       matchFightEndActiveRet.teamaendretinfo.add(roleEndRetInfo);
/*     */     }
/* 257 */     if (((PVPFightEndArg)this.arg).isActiveWin) {
/* 258 */       matchFightEndActiveRet.ret = 0;
/*     */     } else {
/* 260 */       matchFightEndActiveRet.ret = 1;
/*     */     }
/*     */     
/* 263 */     OnlineManager.getInstance().sendMultiAtOnce(matchFightEndActiveRet, ((PVPFightEndArg)this.arg).activeRoleList);
/*     */     
/* 265 */     SMatchFightEndRet matchFightEndPassiveRet = new SMatchFightEndRet();
/* 266 */     for (Iterator i$ = ((PVPFightEndArg)this.arg).passiveRoleList.iterator(); i$.hasNext();) { long passiveRoleid = ((Long)i$.next()).longValue();
/* 267 */       RoleEndRetInfo roleEndRetInfo = new RoleEndRetInfo();
/* 268 */       roleEndRetInfo.roleid = passiveRoleid;
/* 269 */       Integer changeScroe = (Integer)role2RankChangeMap.get(Long.valueOf(passiveRoleid));
/* 270 */       if (changeScroe == null) {
/* 271 */         changeScroe = Integer.valueOf(0);
/*     */       }
/* 273 */       roleEndRetInfo.fightscore = changeScroe.intValue();
/* 274 */       matchFightEndPassiveRet.teamaendretinfo.add(roleEndRetInfo);
/*     */     }
/* 276 */     if (((PVPFightEndArg)this.arg).isActiveWin) {
/* 277 */       matchFightEndPassiveRet.ret = 1;
/*     */     } else {
/* 279 */       matchFightEndPassiveRet.ret = 0;
/*     */     }
/*     */     
/* 282 */     OnlineManager.getInstance().sendMultiAtOnce(matchFightEndPassiveRet, ((PVPFightEndArg)this.arg).passiveRoleList);
/*     */   }
/*     */   
/*     */   private void calToken(Map<Long, String> activeMap, boolean isWin, Map<Long, Integer> disPlayRankMap, Map<Long, Long> role2Token)
/*     */   {
/* 287 */     for (Iterator i$ = activeMap.keySet().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 288 */       Integer disPlayRank = (Integer)disPlayRankMap.get(Long.valueOf(roleid));
/* 289 */       if (disPlayRank == null) {
/* 290 */         GameServer.logger().error(String.format("[Ladder]POnPvPFightEnd.calToken@donot has role displayRank|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       }
/*     */       else
/*     */       {
/* 294 */         long token = LadderManager.getToken(roleid, disPlayRank.intValue(), isWin);
/* 295 */         role2Token.put(Long.valueOf(roleid), Long.valueOf(token));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnPVPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */