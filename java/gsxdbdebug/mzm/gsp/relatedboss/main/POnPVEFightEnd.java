/*    */ package mzm.gsp.relatedboss.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.fight.event.PVEFightEndProcedure;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.map.main.MapVisibleMonsterFightContext;
/*    */ import mzm.gsp.relatedboss.confbean.SMapMonsterRelatedCfg;
/*    */ import xbean.BossFights;
/*    */ import xbean.RelatedBoss;
/*    */ 
/*    */ public class POnPVEFightEnd extends PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     if (!(((PVEFightEndArg)this.arg).context instanceof MapVisibleMonsterFightContext)) {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     MapVisibleMonsterFightContext context = (MapVisibleMonsterFightContext)((PVEFightEndArg)this.arg).context;
/* 27 */     long world = context.worldId;
/*    */     
/* 29 */     RelatedBoss xBoss = null;
/*    */     
/* 31 */     if (RelatedBossConfigManager.isBoss(context.monsterCfgId))
/*    */     {
/*    */ 
/* 34 */       xBoss = RelatedBossManager.getXRelatedBoss(world, true);
/* 35 */       if (xBoss == null) {
/* 36 */         RelatedBossManager.logError("POnPVEFightEnd.processImp@no xdb related boss|world=%d|fightcfgid=%d|roles=%s", new Object[] { Long.valueOf(world), Integer.valueOf(((PVEFightEndArg)this.arg).fightCfgID), ((PVEFightEndArg)this.arg).roleList });
/*    */         
/*    */ 
/* 39 */         return false;
/*    */       }
/* 41 */       RelatedBossManager.removeBossFight(xBoss, context.monsterCfgId, ((PVEFightEndArg)this.arg).fightid); }
/*    */     Map<Integer, List<Integer>> monster2Buff;
/*    */     Iterator i$;
/* 44 */     if ((RelatedBossConfigManager.isRelatedMapMonster(context.monsterCfgId)) && 
/* 45 */       (((PVEFightEndArg)this.arg).isPlayerWin) && (!((PVEFightEndArg)this.arg).isForceEnd)) {
/* 46 */       if (xBoss == null)
/*    */       {
/* 48 */         xBoss = RelatedBossManager.getXRelatedBossIfNotExist(world);
/*    */       }
/* 50 */       if (xBoss == null) {
/* 51 */         RelatedBossManager.logError("POnPVEFightEnd.processImp@no xdb related boss|world=%d|fightcfgid=%d|roles=%s", new Object[] { Long.valueOf(world), Integer.valueOf(((PVEFightEndArg)this.arg).fightCfgID), ((PVEFightEndArg)this.arg).roleList });
/*    */         
/*    */ 
/* 54 */         return false;
/*    */       }
/*    */       
/* 57 */       boolean ret = RelatedBossManager.addRelatedMapMonster(xBoss, context.monsterCfgId);
/*    */       
/* 59 */       if (ret) {
/* 60 */         SMapMonsterRelatedCfg monsterCfg = SMapMonsterRelatedCfg.get(context.monsterCfgId);
/* 61 */         monster2Buff = new HashMap();
/* 62 */         monster2Buff.put(Integer.valueOf(monsterCfg.dstMonsterid), Arrays.asList(new Integer[] { Integer.valueOf(monsterCfg.fightBuffid) }));
/*    */         
/* 64 */         for (i$ = monsterCfg.bossList.iterator(); i$.hasNext();) { int bossid = ((Integer)i$.next()).intValue();
/* 65 */           BossFights xFights = (BossFights)xBoss.getBoss_fights().get(Integer.valueOf(bossid));
/* 66 */           if (xFights != null)
/*    */           {
/*    */ 
/* 69 */             for (i$ = xFights.getFights().iterator(); i$.hasNext();) { long bossFightid = ((Long)i$.next()).longValue();
/*    */               
/* 71 */               FightInterface.addMonsterNextRoundBuffInFight(bossFightid, monster2Buff);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */     Iterator i$;
/*    */     
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\relatedboss\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */