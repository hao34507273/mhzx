/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVEFightStartArg;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.wanted.SNotifyPVEFightTip;
/*    */ import xbean.WantedInfo;
/*    */ 
/*    */ public class POnPVEFightStart extends mzm.gsp.fight.event.PVEFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if ((((PVEFightStartArg)this.arg).fightReason != FightReason.WANTED_FIGHT_PVE.value) || (!(((PVEFightStartArg)this.arg).context instanceof WantedPVEFightContext)))
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     lock(xtable.Basic.getTable(), ((PVEFightStartArg)this.arg).roles);
/* 19 */     WantedPVEFightContext wantedPVEFightContext = (WantedPVEFightContext)((PVEFightStartArg)this.arg).context;
/* 20 */     WantedInfo xWantedInfo = xtable.Role2wantedinfo.get(Long.valueOf(wantedPVEFightContext.wantedRoleId));
/* 21 */     if (xWantedInfo == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 27 */     SNotifyPVEFightTip notifyPVEFightTip = new SNotifyPVEFightTip();
/* 28 */     notifyPVEFightTip.wantedidset.addAll(WantedManager.getWantedRoleIds(((PVEFightStartArg)this.arg).roles));
/* 29 */     notifyPVEFightTip.fightcount = (xWantedInfo.getNpcfightcount() + 1);
/* 30 */     OnlineManager.getInstance().sendMulti(notifyPVEFightTip, ((PVEFightStartArg)this.arg).roles);
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\POnPVEFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */