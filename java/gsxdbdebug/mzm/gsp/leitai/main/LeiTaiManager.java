/*     */ package mzm.gsp.leitai.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.leitai.LeiTaiRoleInfo;
/*     */ import mzm.gsp.leitai.SLeiTaiNormalResult;
/*     */ import mzm.gsp.leitai.confbean.SLeiTaiConsts;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import xbean.LeiTaiBean;
/*     */ import xbean.LeiTaiFight;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class LeiTaiManager
/*     */ {
/*  31 */   static final LeiTaiManager instance = new LeiTaiManager();
/*     */   
/*     */   static LeiTaiManager getInstance() {
/*  34 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Long> randomSingle(int count, long exceptRoleid, LeiTaiBean xLeiTaiBean)
/*     */   {
/*  46 */     Set<Long> roleids = new HashSet();
/*  47 */     Set<Long> singleSet = new HashSet();
/*  48 */     MapInterface.getSingleRoleCollectionFromPKZone(singleSet, SLeiTaiConsts.getInstance().LEI_TAI_MAP_ID);
/*  49 */     if (xLeiTaiBean != null) {
/*  50 */       for (Map.Entry<Long, LeiTaiFight> entry : xLeiTaiBean.getFightmap().entrySet()) {
/*  51 */         singleSet.remove(Long.valueOf(((LeiTaiFight)entry.getValue()).getActiveroleid()));
/*  52 */         singleSet.remove(Long.valueOf(((LeiTaiFight)entry.getValue()).getPassiveroleid()));
/*     */       }
/*     */     }
/*     */     
/*  56 */     singleSet.remove(Long.valueOf(exceptRoleid));
/*  57 */     List<Long> fromRoleids = new ArrayList();
/*  58 */     for (Iterator i$ = singleSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  59 */       if (!TeamInterface.isRoleInTeam(roleid, false)) {
/*  60 */         fromRoleids.add(Long.valueOf(roleid));
/*     */       }
/*     */     }
/*  63 */     randomFromList(fromRoleids, roleids, count);
/*  64 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Long> randomTeam(int count, long exceptRoleid, LeiTaiBean xLeiTaiBean)
/*     */   {
/*  76 */     Set<Long> roleids = new HashSet();
/*     */     
/*  78 */     Set<Long> teamSet = new HashSet();
/*  79 */     MapInterface.getTeamCollectionFromPKZone(teamSet, SLeiTaiConsts.getInstance().LEI_TAI_MAP_ID);
/*  80 */     if (xLeiTaiBean != null) {
/*  81 */       for (Map.Entry<Long, LeiTaiFight> entry : xLeiTaiBean.getFightmap().entrySet()) {
/*  82 */         Long activeTeamid = TeamInterface.getTeamidByRoleid(((LeiTaiFight)entry.getValue()).getActiveroleid(), false);
/*  83 */         Long passiveTeamid = TeamInterface.getTeamidByRoleid(((LeiTaiFight)entry.getValue()).getPassiveroleid(), false);
/*  84 */         if (activeTeamid != null) {
/*  85 */           teamSet.remove(activeTeamid);
/*     */         }
/*  87 */         if (passiveTeamid != null) {
/*  88 */           teamSet.remove(passiveTeamid);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  93 */     List<Long> teamleaderids = new ArrayList();
/*  94 */     for (Iterator i$ = teamSet.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*  95 */       long leaderid = TeamInterface.getTeamLeaderByTeamid(teamid, false);
/*  96 */       if ((leaderid > 0L) && (leaderid != exceptRoleid)) {
/*  97 */         teamleaderids.add(Long.valueOf(leaderid));
/*     */       }
/*     */     }
/* 100 */     randomFromList(teamleaderids, roleids, count);
/* 101 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Map.Entry<Long, LeiTaiFight>> randomFight(LeiTaiBean xLeiTaiBean, int count)
/*     */   {
/* 113 */     Set<Map.Entry<Long, LeiTaiFight>> entrySet = new HashSet();
/* 114 */     if (xLeiTaiBean == null) {
/* 115 */       return entrySet;
/*     */     }
/* 117 */     List<Map.Entry<Long, LeiTaiFight>> fightList = new ArrayList();
/* 118 */     for (Map.Entry<Long, LeiTaiFight> entry : xLeiTaiBean.getFightmap().entrySet()) {
/* 119 */       fightList.add(entry);
/*     */     }
/* 121 */     randomFromList(fightList, entrySet, count);
/* 122 */     return entrySet;
/*     */   }
/*     */   
/*     */   private <T> void randomFromList(List<T> fromList, Set<T> toSet, int count) {
/* 126 */     if (fromList.size() <= 0) {
/* 127 */       return;
/*     */     }
/* 129 */     if (fromList.size() <= count) {
/* 130 */       toSet.addAll(fromList);
/* 131 */       return;
/*     */     }
/* 133 */     int size = fromList.size();
/* 134 */     while ((count > 0) && (size > 0)) {
/* 135 */       int random = Xdb.random().nextInt(size);
/* 136 */       toSet.add(fromList.remove(random));
/* 137 */       size = fromList.size();
/* 138 */       count--;
/*     */     }
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
/*     */   void fightOthers(long activeRoleid, boolean activeIsTeam, long passiveRoleid, boolean passiveIsTeam)
/*     */   {
/* 152 */     LeiTaiFightContext leiTaiFightContext = new LeiTaiFightContext(activeRoleid, activeIsTeam, passiveRoleid, passiveIsTeam);
/*     */     
/* 154 */     FightInterface.startPVPFight(activeRoleid, passiveRoleid, leiTaiFightContext, 2, FightReason.LEITAI);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendNormalResult(long roleid, int normalid, String... args)
/*     */   {
/* 165 */     SLeiTaiNormalResult sLeiTaiNormalResult = new SLeiTaiNormalResult();
/* 166 */     sLeiTaiNormalResult.result = normalid;
/* 167 */     for (String arg : args) {
/* 168 */       sLeiTaiNormalResult.args.add(arg);
/*     */     }
/* 170 */     OnlineManager.getInstance().sendAtOnce(roleid, sLeiTaiNormalResult);
/*     */   }
/*     */   
/*     */   static void fillinLeiTaiRoleInfo(Role role, LeiTaiRoleInfo leiTaiRoleInfo) {
/* 174 */     leiTaiRoleInfo.roleid = role.getId();
/* 175 */     leiTaiRoleInfo.gender = role.getGender();
/* 176 */     leiTaiRoleInfo.level = role.getLevel();
/* 177 */     leiTaiRoleInfo.menpai = role.getOccupationId();
/* 178 */     leiTaiRoleInfo.name = role.getName();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\main\LeiTaiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */