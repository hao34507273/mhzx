/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ 
/*    */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     lock(xtable.Basic.getTable(), ((PVEFightEndArg)this.arg).roleList);
/*    */     
/*    */ 
/* 12 */     for (java.util.Iterator i$ = ((PVEFightEndArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 14 */       xbean.Role2ChangeModelCardInfo xRole2ChangeModelCardInfo = xtable.Role2changemodelcard.get(Long.valueOf(roleId));
/* 15 */       ChangeModelCardManager.checkActivatedInFight(xRole2ChangeModelCardInfo);
/*    */     }
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */