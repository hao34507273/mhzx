/*    */ package mzm.gsp.relatedboss.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVEFightStartArg;
/*    */ import mzm.gsp.fight.event.PVEFightStartProcedure;
/*    */ import mzm.gsp.map.main.MapVisibleMonsterFightContext;
/*    */ import xbean.RelatedBoss;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnPVEFightStart
/*    */   extends PVEFightStartProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!(((PVEFightStartArg)this.arg).context instanceof MapVisibleMonsterFightContext))
/*    */     {
/*    */ 
/*    */ 
/* 21 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 25 */     MapVisibleMonsterFightContext context = (MapVisibleMonsterFightContext)((PVEFightStartArg)this.arg).context;
/* 26 */     long world = context.worldId;
/*    */     
/* 28 */     if (RelatedBossConfigManager.isBoss(context.monsterCfgId)) {
/* 29 */       RelatedBoss xBoss = RelatedBossManager.getXRelatedBossIfNotExist(world);
/* 30 */       RelatedBossManager.addBossFight(xBoss, context.monsterCfgId, ((PVEFightStartArg)this.arg).fightid);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\relatedboss\main\POnPVEFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */