/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xtable.Faction_competition;
/*    */ 
/*    */ 
/*    */ class POneCompetitionStart
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long factionid1;
/*    */   private final long factionid2;
/*    */   
/*    */   POneCompetitionStart(long factionid1, long factionid2)
/*    */   {
/* 22 */     this.factionid1 = factionid1;
/* 23 */     this.factionid2 = factionid2;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     lock(Faction_competition.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2) }));
/*    */     
/* 31 */     Gang gang1 = GangInterface.getGang(this.factionid1, true);
/* 32 */     Gang gang2 = GangInterface.getGang(this.factionid2, true);
/*    */     
/*    */ 
/* 35 */     CompetitionManager.broadcastAgainst(gang1, gang2);
/*    */     
/* 37 */     long world1 = -1L;
/* 38 */     long world2 = -1L;
/*    */     
/* 40 */     if (gang1 != null) {
/* 41 */       FactionCompetitionTmp xTmp1 = CompetitionManager.getXFactionCompetitionTmpIfNotExist(this.factionid1);
/*    */       
/* 43 */       world1 = CompetitionManager.createWorld(SCompetitionConsts.getInstance().PrepareMap);
/* 44 */       xTmp1.setWorld(world1);
/*    */       
/* 46 */       ControllerInterface.triggerWorldController(GangInterface.getGangWorldId(this.factionid1), SCompetitionConsts.getInstance().ControllerIn);
/*    */     }
/*    */     
/* 49 */     if (gang2 != null) {
/* 50 */       FactionCompetitionTmp xTmp2 = CompetitionManager.getXFactionCompetitionTmpIfNotExist(this.factionid2);
/*    */       
/* 52 */       world2 = CompetitionManager.createWorld(SCompetitionConsts.getInstance().PrepareMap);
/* 53 */       xTmp2.setWorld(world2);
/*    */       
/* 55 */       ControllerInterface.triggerWorldController(GangInterface.getGangWorldId(this.factionid2), SCompetitionConsts.getInstance().ControllerIn);
/*    */     }
/*    */     
/*    */ 
/* 59 */     CompetitionManager.logger.info(String.format("POneCompetitionStart.processImp@success|faction1=%d|faction2=%d|create_world1=%d|create_world2=%d", new Object[] { Long.valueOf(this.factionid1), Long.valueOf(this.factionid2), Long.valueOf(world1), Long.valueOf(world2) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POneCompetitionStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */