/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.competition.event.PickUpTreasure;
/*    */ import mzm.gsp.competition.event.PickUpTreasureArg;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.itembulletin.main.ItemBulletinInterface;
/*    */ import mzm.gsp.map.event.PlayerGatherItemSuccessProcedure;
/*    */ import mzm.gsp.map.main.GatherItemEventArg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xbean.RoleCompetition;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Faction_competition_tmp;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnGatherItem extends PlayerGatherItemSuccessProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     if (((GatherItemEventArg)this.arg).mapId != SCompetitionConsts.getInstance().FightMap) {
/* 26 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 30 */     String userId = RoleInterface.getUserId(((GatherItemEventArg)this.arg).roleId);
/* 31 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 33 */     Gang faction = GangInterface.getGangByRoleId(((GatherItemEventArg)this.arg).roleId, true);
/* 34 */     FactionCompetitionTmp xFCTmp = null;
/*    */     
/* 36 */     if (faction != null)
/*    */     {
/* 38 */       xFCTmp = Faction_competition_tmp.get(Long.valueOf(faction.getGangId()));
/*    */     }
/*    */     
/* 41 */     RoleCompetition xRC = CompetitionManager.getXRoleCompetitionIfNotExist(((GatherItemEventArg)this.arg).roleId);
/* 42 */     xRC.setAwarded_final(true);
/*    */     
/*    */ 
/* 45 */     if (TeamInterface.isRoleInTeam(((GatherItemEventArg)this.arg).roleId, true))
/*    */     {
/* 47 */       TeamInterface.leaveTeamNoneRealTime(((GatherItemEventArg)this.arg).roleId);
/*    */ 
/*    */ 
/*    */     }
/* 51 */     else if (xFCTmp != null) {
/* 52 */       CompetitionManager.leave(userId, ((GatherItemEventArg)this.arg).roleId, faction, xFCTmp);
/*    */     }
/*    */     else {
/* 55 */       MapInterface.forceTransferWhenFault(((GatherItemEventArg)this.arg).roleId);
/*    */     }
/*    */     
/*    */ 
/* 59 */     if (ItemBulletinInterface.needBulletin(((GatherItemEventArg)this.arg).itemid)) {
/* 60 */       CompetitionItemHandler.getInstance().gainPreciousItem(((GatherItemEventArg)this.arg).roleId, ((GatherItemEventArg)this.arg).itemid, ((GatherItemEventArg)this.arg).itemNum);
/*    */     }
/*    */     
/* 63 */     CompetitionManager.logInfo("POnGatherItem.process@get treasure|roleid=%d|worldid=%d|mapid=%d|itemid=%d", new Object[] { Long.valueOf(((GatherItemEventArg)this.arg).roleId), Long.valueOf(((GatherItemEventArg)this.arg).worldId), Integer.valueOf(((GatherItemEventArg)this.arg).mapId), Integer.valueOf(((GatherItemEventArg)this.arg).itemid) });
/*    */     
/*    */ 
/*    */ 
/* 67 */     PickUpTreasureArg treasureArg = new PickUpTreasureArg(((GatherItemEventArg)this.arg).roleId, ((GatherItemEventArg)this.arg).gatherItemCfgId);
/* 68 */     TriggerEventsManger.getInstance().triggerEvent(new PickUpTreasure(), treasureArg);
/*    */     
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnGatherItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */