/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ 
/*    */ class PPayOneGang extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gangid;
/*    */   
/*    */   PPayOneGang(long gangid)
/*    */   {
/* 12 */     this.gangid = gangid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(this.gangid));
/* 19 */     if (xGang == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int allPayMoney = GangConfigManager.getInstance().getGangPayment(xGang.getPeriodmoney());
/* 23 */     for (SGangDutyCfg cfg : SGangDutyCfg.getAll().values()) {
/* 24 */       if (cfg.payRate > 0) {
/* 25 */         xbean.GangDutyMembers xMembers = (xbean.GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(cfg.id));
/* 26 */         if (xMembers != null) {
/* 27 */           gold = (int)(cfg.payRate / 10000.0F * allPayMoney);
/* 28 */           dutyName = GangConfigManager.getInstance().getDutyName(xGang.getDesigntitlecaseid(), cfg.id);
/* 29 */           for (i$ = xMembers.getMembers().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */             
/* 31 */             mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new PPayManager(roleid, gold, xGang.getName(), dutyName, this.gangid, xGang.getDisplayid()));
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     int gold;
/*    */     String dutyName;
/*    */     Iterator i$;
/* 39 */     xGang.setPeriodmoney(0);
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PPayOneGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */