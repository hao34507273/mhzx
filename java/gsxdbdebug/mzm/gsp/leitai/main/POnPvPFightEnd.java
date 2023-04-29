/*    */ package mzm.gsp.leitai.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.fight.event.PVPFightEndArg;
/*    */ import mzm.gsp.leitai.event.LeiTaiFightEndEvent;
/*    */ import xbean.LeiTaiBean;
/*    */ 
/*    */ public class POnPvPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     mzm.gsp.fight.main.FightContext fightContext = ((PVPFightEndArg)this.arg).context;
/* 13 */     if ((fightContext instanceof LeiTaiFightContext))
/*    */     {
/* 15 */       LeiTaiBean xLeiTaiBean = xtable.Leitai.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 16 */       xLeiTaiBean.getFightmap().remove(Long.valueOf(((PVPFightEndArg)this.arg).fightid));
/* 17 */       LeiTaiFightEndEvent leiTaiFightEndEvent = new LeiTaiFightEndEvent();
/* 18 */       TriggerEventsManger.getInstance().triggerEvent(leiTaiFightEndEvent, this.arg);
/* 19 */       return true;
/*    */     }
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\main\POnPvPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */