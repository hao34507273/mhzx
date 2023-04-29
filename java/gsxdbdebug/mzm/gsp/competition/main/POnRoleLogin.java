/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.Competition;
/*    */ import xbean.CompetitionAgainst;
/*    */ import xbean.FactionCompetition;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Faction_competition;
/*    */ import xtable.Faction_competition_tmp;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 24 */     Gang selfFaction = GangInterface.getGangByRoleId(roleid, false);
/*    */     
/* 26 */     if (selfFaction != null)
/*    */     {
/*    */ 
/*    */ 
/* 30 */       FactionCompetitionTmp xSelfFCTmp = Faction_competition_tmp.select(Long.valueOf(selfFaction.getGangId()));
/* 31 */       if (xSelfFCTmp != null)
/*    */       {
/*    */ 
/*    */ 
/* 35 */         long world = MapInterface.getRoleWorldInstanceId(roleid);
/* 36 */         if (world == xSelfFCTmp.getWorld())
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 41 */           FactionCompetition xSelfFC = Faction_competition.select(Long.valueOf(selfFaction.getGangId()));
/* 42 */           Competition xCompetition = CompetitionManager.getXCompetition(false);
/* 43 */           long selfFactionid = selfFaction.getGangId();
/* 44 */           long oppoFactionid = xSelfFC.getOpponent();
/* 45 */           CompetitionAgainst xAgainst = CompetitionManager.getXAgainst(xCompetition, selfFactionid, oppoFactionid);
/*    */           
/*    */ 
/* 48 */           String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/* 49 */           lock(Lockeys.get(User.getTable(), userid));
/*    */           
/*    */ 
/* 52 */           lock(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*    */           
/* 54 */           if ((xAgainst == null) || (xAgainst.getFinished()))
/*    */           {
/* 56 */             selfFaction = GangInterface.getGang(selfFactionid, true);
/*    */             
/* 58 */             CompetitionManager.leave(userid, roleid, selfFaction, xSelfFCTmp);
/*    */           }
/*    */           else {
/* 61 */             int stage = mzm.gsp.activity.main.ActivityInterface.getActivityStage(SCompetitionConsts.getInstance().Activityid);
/*    */             
/* 63 */             CompetitionManager.syncStage(roleid, stage);
/*    */             
/* 65 */             CompetitionManager.syncRoleCompetition(roleid);
/*    */             
/* 67 */             if (CompetitionManager.isCompeteStage(stage))
/*    */             {
/*    */ 
/* 70 */               lock(Faction_competition.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(selfFactionid), Long.valueOf(oppoFactionid) }));
/* 71 */               Gang oppoFaction = GangInterface.getGang(oppoFactionid, true);
/* 72 */               FactionCompetition xOppoFC = Faction_competition.get(Long.valueOf(oppoFactionid));
/* 73 */               FactionCompetitionTmp xOppoFCTmp = CompetitionManager.getXFactionCompetitionTmpIfNotExist(oppoFactionid);
/*    */               
/*    */ 
/* 76 */               CompetitionManager.syncAgainst(roleid, selfFaction, xSelfFC, xSelfFCTmp, oppoFaction, xOppoFC, xOppoFCTmp);
/*    */               
/*    */ 
/* 79 */               CompetitionManager.setFactionTitle(roleid, selfFaction);
/*    */             }
/*    */             else
/*    */             {
/* 83 */               CompetitionManager.syncFactionPlayerNumber(roleid, selfFactionid, xSelfFCTmp);
/*    */             }
/*    */           }
/*    */           
/* 87 */           return true;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 92 */     CompetitionManager.clearActivityStatus(roleid);
/*    */     
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */