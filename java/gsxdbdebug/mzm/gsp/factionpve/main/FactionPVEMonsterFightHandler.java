/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightParam;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.IMonsterFightHandler;
/*    */ import mzm.gsp.map.main.MapFightContext;
/*    */ import mzm.gsp.map.main.MapVisibleMonsterFightContext;
/*    */ import mzm.gsp.monster.main.MonsterInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.relatedboss.main.RelatedBossInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class FactionPVEMonsterFightHandler
/*    */   implements IMonsterFightHandler
/*    */ {
/* 24 */   private static final FactionPVEMonsterFightHandler instance = new FactionPVEMonsterFightHandler();
/*    */   
/*    */   static FactionPVEMonsterFightHandler getInstance() {
/* 27 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int startFight(long roleId, int fightId, MapFightContext context)
/*    */   {
/* 35 */     if (!OpenInterface.getOpenStatus(334)) {
/* 36 */       FactionPVEManager.logError("FactionPVEMonsterFightHandler.startFight@not open|roleid=%d|fightcfgid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(fightId), Long.valueOf(context.worldId), Integer.valueOf(context.mapId) });
/*    */       
/*    */ 
/* 39 */       return 11;
/*    */     }
/*    */     
/* 42 */     int monsterCfgid = FightInterface.getFightFirstMonsterid(fightId);
/*    */     
/* 44 */     int categoryid = MonsterInterface.getMonsterCategoryId(monsterCfgid);
/* 45 */     if (categoryid != SFactionPVEConsts.getInstance().FightTypeID) {
/* 46 */       return 0;
/*    */     }
/*    */     
/*    */ 
/* 50 */     if (!ActivityInterface.isActivityOpen(SFactionPVEConsts.getInstance().Activityid)) {
/* 51 */       return 11;
/*    */     }
/*    */     
/*    */ 
/* 55 */     long selfFactionid = GangInterface.getGangId(roleId);
/* 56 */     if (selfFactionid <= 0L) {
/* 57 */       return 12;
/*    */     }
/*    */     
/* 60 */     FightParam param = new FightParam();
/*    */     
/* 62 */     if ((context instanceof MapVisibleMonsterFightContext)) {
/* 63 */       MapVisibleMonsterFightContext monsterContext = (MapVisibleMonsterFightContext)context;
/*    */       
/* 65 */       RelatedBossInterface.fillFightParam(param, monsterContext);
/*    */     }
/*    */     
/* 68 */     FightInterface.startPVEFight(roleId, fightId, context, 18, FightReason.FACTION_PVE, param);
/*    */     
/*    */ 
/*    */ 
/* 72 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\FactionPVEMonsterFightHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */