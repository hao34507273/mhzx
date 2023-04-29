/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.event.CorpsNameChangeEventArg;
/*    */ import mzm.gsp.corps.event.CorpsNameChangeProcedure;
/*    */ 
/*    */ public class POnCorpsNameChange extends CorpsNameChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long corpsId = ((CorpsNameChangeEventArg)this.arg).getCorpsId();
/*    */     
/* 14 */     xbean.Corps xCorps = xtable.Corps.select(Long.valueOf(corpsId));
/* 15 */     if (xCorps == null)
/*    */     {
/* 17 */       GameServer.logger().error(String.format("[corps]POnCorpsCreate.processImp@ not have this corps!|corpsId=%d", new Object[] { Long.valueOf(corpsId) }));
/*    */       
/* 19 */       return false;
/*    */     }
/* 21 */     for (Iterator i$ = CorpsManager.getCorpsMemberSet(xCorps).iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 23 */       CorpsManager.HandCorpsAppellationNoneRealTime(roleId, HandCorpsAppellation.AppellationHandType.CHANGE_ARGS);
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnCorpsNameChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */