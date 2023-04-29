/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.wanted.SNotifyPVPFightTip;
/*    */ 
/*    */ public class POnPVPFightStart
/*    */   extends PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (!(((PVPFightStartArg)this.arg).context instanceof WantedPVPFightContext))
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     List<Long> receivers = new ArrayList();
/* 20 */     receivers.addAll(((PVPFightStartArg)this.arg).activeRoles);
/* 21 */     receivers.addAll(((PVPFightStartArg)this.arg).passiveRoles);
/*    */     
/* 23 */     SNotifyPVPFightTip notifyPVPFightTip = new SNotifyPVPFightTip();
/*    */     
/* 25 */     WantedManager.getRoleNamesOctets(((PVPFightStartArg)this.arg).activeRoles, notifyPVPFightTip.activenamelist, false);
/*    */     
/* 27 */     WantedManager.getRoleNamesOctets(((PVPFightStartArg)this.arg).passiveRoles, notifyPVPFightTip.passivenamelist, true);
/*    */     
/* 29 */     OnlineManager.getInstance().sendMulti(notifyPVPFightTip, receivers);
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */