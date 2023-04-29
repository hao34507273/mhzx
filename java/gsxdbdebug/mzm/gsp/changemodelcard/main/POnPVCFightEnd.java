/*    */ package mzm.gsp.changemodelcard.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVCFightEndArg;
/*    */ 
/*    */ public class POnPVCFightEnd extends mzm.gsp.fight.event.PVCFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     lock(xtable.Basic.getTable(), ((PVCFightEndArg)this.arg).activeRoleList);
/*    */     
/*    */ 
/* 12 */     for (java.util.Iterator i$ = ((PVCFightEndArg)this.arg).activeRoleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 14 */       xbean.Role2ChangeModelCardInfo xRole2ChangeModelCardInfo = xtable.Role2changemodelcard.get(Long.valueOf(roleId));
/* 15 */       ChangeModelCardManager.checkActivatedInFight(xRole2ChangeModelCardInfo);
/*    */     }
/*    */     
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\POnPVCFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */