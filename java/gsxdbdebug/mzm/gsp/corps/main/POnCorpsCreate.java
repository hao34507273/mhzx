/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.event.CorpsCreateEventArg;
/*    */ import mzm.gsp.corps.event.CorpsCreateProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnCorpsCreate
/*    */   extends CorpsCreateProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     long corpsId = ((CorpsCreateEventArg)this.arg).getCorpsId();
/*    */     
/* 20 */     xbean.Corps xCorps = xtable.Corps.select(Long.valueOf(corpsId));
/* 21 */     if (xCorps == null)
/*    */     {
/* 23 */       GameServer.logger().error(String.format("[corps]POnCorpsCreate.processImp@ not have this corps!|corpsId=%d", new Object[] { Long.valueOf(corpsId) }));
/*    */       
/* 25 */       return false;
/*    */     }
/* 27 */     for (Iterator i$ = CorpsManager.getCorpsMemberSet(xCorps).iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 29 */       CorpsManager.HandCorpsAppellationNoneRealTime(roleId, HandCorpsAppellation.AppellationHandType.ADD);
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnCorpsCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */