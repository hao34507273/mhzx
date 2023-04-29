/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class POnPvPFightEnd extends mzm.gsp.fight.event.PVPFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVPFightEndArg)this.arg).activeAlivedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*  9 */       xdb.Procedure.execute(new PAfterFightTrigger(roleId));
/*    */     }
/* 11 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVPFightEndArg)this.arg).activeEscapedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 12 */       xdb.Procedure.execute(new PAfterFightTrigger(roleId));
/*    */     }
/* 14 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVPFightEndArg)this.arg).passiveAlivedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 15 */       xdb.Procedure.execute(new PAfterFightTrigger(roleId));
/*    */     }
/* 17 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVPFightEndArg)this.arg).passiveEscapedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 18 */       xdb.Procedure.execute(new PAfterFightTrigger(roleId));
/*    */     }
/*    */     
/* 21 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVPFightEndArg)this.arg).activeDeadRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 22 */       xdb.Procedure.execute(new PDiedTrigger(roleId));
/*    */     }
/* 24 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVPFightEndArg)this.arg).passiveDeadRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 25 */       xdb.Procedure.execute(new PDiedTrigger(roleId));
/*    */     }
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\POnPvPFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */