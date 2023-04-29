/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVEFightStartArg;
/*    */ import mzm.gsp.fight.event.PVEFightStartProcedure;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import xbean.FactionPVETmp;
/*    */ 
/*    */ public class POnPVEFightStart extends PVEFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if (((PVEFightStartArg)this.arg).fightReason != FightReason.FACTION_PVE.value) {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     Gang faction = GangInterface.getGangByRoleId(((Long)((PVEFightStartArg)this.arg).roles.get(0)).longValue(), true);
/*    */     
/* 22 */     if (faction == null) {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(faction.getGangId());
/*    */     
/*    */ 
/*    */ 
/* 30 */     xFactionPVETmp.getFights().add(Long.valueOf(((PVEFightStartArg)this.arg).fightid));
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\POnPVEFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */