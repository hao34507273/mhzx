/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class POnPvPFightStart extends mzm.gsp.fight.event.PVPFightStartProcedure {
/*    */   protected boolean processImp() throws Exception {
/*  7 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVPFightStartArg)this.arg).activeRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  8 */       xdb.Procedure.execute(new PSelfObserveEnd(roleid));
/*    */     }
/* 10 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVPFightStartArg)this.arg).passiveRoles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 11 */       xdb.Procedure.execute(new PSelfObserveEnd(roleid));
/*    */     }
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnPvPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */