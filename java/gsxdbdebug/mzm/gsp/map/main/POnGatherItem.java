/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.map.confbean.SMapItemCfg;
/*    */ import mzm.gsp.map.event.PlayerGatherItemSuccessProcedure;
/*    */ 
/*    */ public class POnGatherItem extends PlayerGatherItemSuccessProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     int gatherItemCfgId = ((GatherItemEventArg)this.arg).gatherItemCfgId;
/* 14 */     SMapItemCfg cfg = SMapItemCfg.get(gatherItemCfgId);
/* 15 */     if (cfg == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     if (cfg.buffid > 0)
/*    */     {
/* 22 */       BuffInterface.installBuffAsyc(((GatherItemEventArg)this.arg).roleId, cfg.buffid);
/*    */     }
/*    */     
/* 25 */     if (cfg.pveFightCfgid > 0)
/*    */     {
/* 27 */       FightInterface.startPVEFight(((GatherItemEventArg)this.arg).roleId, cfg.pveFightCfgid, new GatherMapItemPVEFightContext(gatherItemCfgId), FightReason.GATHER_MAP_ITEM_FIGHT_PVE);
/*    */     }
/*    */     
/*    */ 
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnGatherItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */