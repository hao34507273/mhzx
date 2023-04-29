/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.item.SSynEquiptipRes;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.DayPerfectRingCout;
/*    */ import xbean.Equipstate;
/*    */ import xtable.Role2dayperfectringcount;
/*    */ import xtable.Role2equipstate;
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginSynEquipState
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     DayPerfectRingCout xDayPerfectRingCout = Role2dayperfectringcount.get((Long)this.arg);
/* 19 */     if (xDayPerfectRingCout == null)
/*    */     {
/* 21 */       ItemManager.sendSSynMoshouExchangeCountRes(((Long)this.arg).longValue(), 0);
/*    */     }
/*    */     else
/*    */     {
/* 25 */       ItemManager.sendSSynMoshouExchangeCountRes(((Long)this.arg).longValue(), xDayPerfectRingCout.getExchangecount());
/*    */     }
/* 27 */     Equipstate equipstate = Role2equipstate.get((Long)this.arg);
/* 28 */     if ((equipstate != null) && (equipstate.getState() != 0))
/*    */     {
/* 30 */       SSynEquiptipRes re = new SSynEquiptipRes();
/* 31 */       re.state = equipstate.getState();
/* 32 */       OnlineManager.getInstance().send(((Long)this.arg).longValue(), re);
/*    */     }
/*    */     
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginSynEquipState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */