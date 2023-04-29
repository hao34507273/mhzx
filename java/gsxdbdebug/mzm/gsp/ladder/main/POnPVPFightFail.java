/*     */ package mzm.gsp.ladder.main;
/*     */ 
/*     */ import hub.FightResult;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.main.RoamedMatchContext;
/*     */ import mzm.gsp.crossserver.main.RoamedRoleMatchMarkingInfo;
/*     */ import mzm.gsp.fight.event.PVPFightFailArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class POnPVPFightFail extends mzm.gsp.fight.event.PVPFightFailProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     if (!(((PVPFightFailArg)this.arg).context instanceof LadderFightContext)) {
/*  25 */       return false;
/*     */     }
/*  27 */     Set<String> allUsers = new HashSet();
/*  28 */     Set<Long> allRoles = new HashSet();
/*     */     
/*  30 */     int activeZoneid = 0;
/*  31 */     Map<Long, String> activeMap = new HashMap();
/*  32 */     for (Iterator i$ = ((PVPFightFailArg)this.arg).activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  33 */       String userid = RoleInterface.getUserId(roleid);
/*  34 */       activeMap.put(Long.valueOf(roleid), userid);
/*  35 */       if (activeZoneid == 0) {
/*  36 */         activeZoneid = GameServerInfoManager.getZoneidFromUserid(userid);
/*     */       }
/*  38 */       allUsers.add(userid);
/*  39 */       allRoles.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/*  42 */     int passiveZoneid = 0;
/*  43 */     Map<Long, String> passiveMap = new HashMap();
/*  44 */     for (Iterator i$ = ((PVPFightFailArg)this.arg).passiveRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  45 */       String userid = RoleInterface.getUserId(roleid);
/*  46 */       passiveMap.put(Long.valueOf(roleid), userid);
/*  47 */       if (passiveZoneid == 0) {
/*  48 */         passiveZoneid = GameServerInfoManager.getZoneidFromUserid(userid);
/*     */       }
/*  50 */       allUsers.add(userid);
/*  51 */       allRoles.add(Long.valueOf(roleid));
/*     */     }
/*     */     
/*  54 */     long tempRoleid = ((Long)((PVPFightFailArg)this.arg).activeRoles.get(0)).longValue();
/*  55 */     List<Long> activeRoles = new ArrayList();
/*  56 */     List<Long> passiveRoles = new ArrayList();
/*  57 */     RoamedMatchContext roamedMatchContext = (RoamedMatchContext)LadderMatchRomaContextManager.getInstance().getValue(Long.valueOf(tempRoleid));
/*  58 */     if (roamedMatchContext != null) {
/*  59 */       for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : roamedMatchContext.roleMatchMarkingInfos) {
/*  60 */         long roleid = roamedRoleMatchMarkingInfo.getRoleid();
/*  61 */         activeRoles.add(Long.valueOf(roleid));
/*  62 */         allRoles.add(Long.valueOf(roleid));
/*  63 */         allUsers.add(roamedRoleMatchMarkingInfo.getUserid());
/*     */       }
/*  65 */       for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : roamedMatchContext.opponentRoleMatchMarkingInfos) {
/*  66 */         long roleid = roamedRoleMatchMarkingInfo.getRoleid();
/*  67 */         passiveRoles.add(Long.valueOf(roleid));
/*  68 */         allRoles.add(Long.valueOf(roleid));
/*  69 */         allUsers.add(roamedRoleMatchMarkingInfo.getUserid());
/*     */       }
/*     */     } else {
/*  72 */       GameServer.logger().error(String.format("[Ladder]POnPVPFightFail.processImp@do not exist matchContex|roleid=%d", new Object[] { Long.valueOf(tempRoleid) }));
/*     */       
/*  74 */       activeRoles.addAll(((PVPFightFailArg)this.arg).activeRoles);
/*  75 */       passiveRoles.addAll(((PVPFightFailArg)this.arg).passiveRoles);
/*     */     }
/*  77 */     GameServer.logger().info(String.format("[Ladder]POnPVPFightFail.processImp@excuted|activeRoles=%s|passiveRoles=%s", new Object[] { activeRoles, passiveRoles }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  82 */     LadderMatchRomaContextManager.getInstance().removeKeys(allRoles);
/*     */     
/*  84 */     lock(xtable.User.getTable(), allUsers);
/*  85 */     lock(xtable.Role2properties.getTable(), allRoles);
/*     */     
/*     */ 
/*  88 */     LadderManager.onReturnOriginalServer(activeMap, activeRoles, false, new HashMap(1), Collections.EMPTY_MAP, new HashMap(1), new HashMap(1), new FightResult());
/*     */     
/*     */ 
/*  91 */     LadderManager.onReturnOriginalServer(passiveMap, passiveRoles, false, new HashMap(1), Collections.EMPTY_MAP, new HashMap(1), new HashMap(1), new FightResult());
/*     */     
/*     */ 
/*  94 */     GameServer.logger().error(String.format("[Ladder]POnPVPFightFail.processImp@start pvp fight failed|activeRoles=%s|passiveRoles=%s", new Object[] { collectionToString(((PVPFightFailArg)this.arg).activeRoles), collectionToString(((PVPFightFailArg)this.arg).passiveRoles) }));
/*     */     
/*     */ 
/*     */ 
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   String collectionToString(List<Long> actives) {
/* 102 */     StringBuilder stringBuilder = new StringBuilder();
/* 103 */     for (int i = 0; i < actives.size(); i++) {
/* 104 */       long roleid = ((Long)actives.get(i)).longValue();
/* 105 */       stringBuilder.append(roleid);
/* 106 */       if (i < actives.size() - 1) {
/* 107 */         stringBuilder.append(",");
/*     */       }
/*     */     }
/* 110 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnPVPFightFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */