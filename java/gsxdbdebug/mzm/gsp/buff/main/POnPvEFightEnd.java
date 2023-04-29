/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class POnPvEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVEFightEndArg)this.arg).alivedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*  9 */       xdb.Procedure.execute(new PAfterFightTrigger(roleId));
/*    */     }
/* 11 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVEFightEndArg)this.arg).escapedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 12 */       xdb.Procedure.execute(new PAfterFightTrigger(roleId));
/*    */     }
/* 14 */     for (Iterator i$ = ((mzm.gsp.fight.event.PVEFightEndArg)this.arg).diedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 15 */       xdb.Procedure.execute(new PDiedTrigger(roleId));
/*    */     }
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */