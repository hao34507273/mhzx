/*    */ package mzm.gsp.crossbattle.bet;
/*    */ 
/*    */ import mzm.gsp.crossbattle.SSynBetTimes;
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleCrossBattleBetTimesInfo;
/*    */ import xtable.Role_cross_battle_bet_times_infos;
/*    */ 
/*    */ 
/*    */ public class ROnRoleLogin
/*    */   extends PlayerLoginRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 17 */     new PReportRoleBetRankInfo(((Long)this.arg).longValue()).call();
/* 18 */     new PSynBetTimes(((Long)this.arg).longValue()).call();
/*    */   }
/*    */   
/*    */   class PSynBetTimes extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     
/*    */     PSynBetTimes(long roleid)
/*    */     {
/* 27 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 33 */       SSynBetTimes protocol = new SSynBetTimes();
/* 34 */       protocol.times = 0;
/*    */       
/* 36 */       long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/*    */       
/* 38 */       RoleCrossBattleBetTimesInfo xRoleCrossBattleBetTimesInfo = Role_cross_battle_bet_times_infos.get(Long.valueOf(this.roleid));
/* 39 */       if (xRoleCrossBattleBetTimesInfo != null)
/*    */       {
/* 41 */         if (DateTimeUtils.needDailyReset(xRoleCrossBattleBetTimesInfo.getTimestamp(), currTimeInMillis, 0))
/*    */         {
/* 43 */           xRoleCrossBattleBetTimesInfo.setTimes(0);
/* 44 */           xRoleCrossBattleBetTimesInfo.setTimestamp(currTimeInMillis);
/*    */         }
/* 46 */         protocol.times = xRoleCrossBattleBetTimesInfo.getTimes();
/*    */       }
/* 48 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */