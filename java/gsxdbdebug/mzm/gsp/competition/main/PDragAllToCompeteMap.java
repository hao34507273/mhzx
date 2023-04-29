/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.gang.main.Gang;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Competition;
/*     */ import xbean.CompetitionAgainst;
/*     */ import xbean.FactionCompetition;
/*     */ import xbean.FactionCompetitionTmp;
/*     */ import xtable.Faction_competition_tmp;
/*     */ 
/*     */ class PDragAllToCompeteMap extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long factionid1;
/*     */   private final long factionid2;
/*     */   
/*     */   PDragAllToCompeteMap(long factionid1, long factionid2)
/*     */   {
/*  26 */     this.factionid1 = factionid1;
/*  27 */     this.factionid2 = factionid2;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     long factionDisplayid1 = -1L;
/*  33 */     long factionDisplayid2 = -1L;
/*  34 */     Gang tlogFaction = null;
/*     */     
/*     */ 
/*  37 */     Gang faction1 = GangInterface.getGang(this.factionid1, false);
/*  38 */     Gang faction2 = GangInterface.getGang(this.factionid2, false);
/*     */     
/*  40 */     if (faction1 != null) {
/*  41 */       factionDisplayid1 = faction1.getDisplayid();
/*  42 */       tlogFaction = faction1;
/*     */     }
/*  44 */     if (faction2 != null) {
/*  45 */       factionDisplayid2 = faction2.getDisplayid();
/*  46 */       if (tlogFaction == null) {
/*  47 */         tlogFaction = faction2;
/*     */       }
/*     */     }
/*     */     
/*  51 */     String tlogUserid = null;
/*  52 */     if (tlogFaction != null) {
/*  53 */       long tlogLeader = tlogFaction.getBangZhuId();
/*     */       
/*  55 */       tlogUserid = RoleInterface.getUserId(tlogLeader);
/*     */     }
/*     */     
/*     */ 
/*  59 */     lock(Faction_competition_tmp.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*     */     
/*  61 */     FactionCompetitionTmp xFCTmp1 = CompetitionManager.getXFactionCompetitionTmpIfNotExist(this.factionid1);
/*  62 */     FactionCompetitionTmp xFCTmp2 = CompetitionManager.getXFactionCompetitionTmpIfNotExist(this.factionid2);
/*     */     
/*  64 */     long oldWorld1 = xFCTmp1.getWorld();
/*  65 */     long oldWorld2 = xFCTmp2.getWorld();
/*     */     
/*     */ 
/*  68 */     long newWorld = CompetitionManager.createFightWorld();
/*     */     
/*     */ 
/*  71 */     List<Long> roles1 = MapInterface.getRoleList(oldWorld1);
/*  72 */     if ((roles1 != null) && (!roles1.isEmpty()))
/*     */     {
/*  74 */       FactionCompetition xFactionCompetition1 = CompetitionManager.getXFactionCompetitionIfNotExist(this.factionid1);
/*  75 */       xFactionCompetition1.setParticipated(true);
/*     */       
/*  77 */       CompetitionManager.saveParticipateRoles(xFactionCompetition1, roles1);
/*     */       
/*  79 */       MapInterface.dragAllRoleToTargetWorld(oldWorld1, newWorld, SCompetitionConsts.getInstance().FightMap, SCompetitionConsts.getInstance().Faction1EnterX, SCompetitionConsts.getInstance().Faction1EnterY);
/*     */     }
/*     */     
/*  82 */     List<Long> roles2 = MapInterface.getRoleList(oldWorld2);
/*  83 */     if ((roles2 != null) && (!roles2.isEmpty()))
/*     */     {
/*  85 */       FactionCompetition xFactionCompetition2 = CompetitionManager.getXFactionCompetitionIfNotExist(this.factionid2);
/*  86 */       xFactionCompetition2.setParticipated(true);
/*     */       
/*  88 */       CompetitionManager.saveParticipateRoles(xFactionCompetition2, roles2);
/*     */       
/*  90 */       MapInterface.dragAllRoleToTargetWorld(oldWorld2, newWorld, SCompetitionConsts.getInstance().FightMap, SCompetitionConsts.getInstance().Faction2EnterX, SCompetitionConsts.getInstance().Faction2EnterY);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  95 */     CompetitionManager.destroyWorld(oldWorld1);
/*  96 */     CompetitionManager.destroyWorld(oldWorld2);
/*     */     
/*  98 */     xFCTmp1.setWorld(newWorld);
/*  99 */     xFCTmp2.setWorld(newWorld);
/*     */     
/*     */ 
/* 102 */     CompetitionManager.logger.info(String.format("PDragAllToCompeteMap.processImp@drag all role to compete map|faction1=%d|faction2=%d|oldworld1=%d|oldworld2=%d|newworld=%d", new Object[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2), Long.valueOf(oldWorld1), Long.valueOf(oldWorld2), Long.valueOf(newWorld) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 112 */     int count1 = 0;
/* 113 */     int count2 = 0;
/* 114 */     if (xFCTmp1 != null) {
/* 115 */       count1 = xFCTmp1.getPlayer_num();
/*     */     }
/* 117 */     if (xFCTmp2 != null) {
/* 118 */       count2 = xFCTmp2.getPlayer_num();
/*     */     }
/*     */     
/* 121 */     if (tlogUserid != null) {
/* 122 */       TLogManager.getInstance().addLog(tlogUserid, "CompetitionParticipate", new Object[] { Long.valueOf(this.factionid1), Integer.valueOf(count1), Long.valueOf(this.factionid2), Integer.valueOf(count2), Long.valueOf(factionDisplayid1), Long.valueOf(factionDisplayid2) });
/*     */     }
/*     */     
/*     */ 
/* 126 */     if (OpenInterface.getOpenStatus(219))
/*     */     {
/* 128 */       Competition xCompetition = CompetitionManager.getXCompetition(true);
/*     */       
/* 130 */       CompetitionAgainst xAgainst = CompetitionManager.getXAgainst(xCompetition, this.factionid1, this.factionid2);
/*     */       
/*     */ 
/* 133 */       CompetitionManager.checkRecallMercenary(xAgainst, xFCTmp1, xFCTmp2, this.factionid1, factionDisplayid1, this.factionid2, factionDisplayid2, tlogUserid);
/*     */     }
/*     */     
/*     */ 
/* 137 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PDragAllToCompeteMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */