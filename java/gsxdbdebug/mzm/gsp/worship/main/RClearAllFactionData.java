/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.FactionWorshipInfo;
/*    */ import xtable.Faction2worship;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RClearAllFactionData
/*    */   extends LogicRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     Collection<Long> allGangIds = GangInterface.getAllGangIdSet();
/* 22 */     for (Iterator i$ = allGangIds.iterator(); i$.hasNext();) { final long factionId = ((Long)i$.next()).longValue();
/*    */       
/* 24 */       new LogicProcedure()
/*    */       {
/*    */ 
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 30 */           FactionWorshipInfo xFactionData = Faction2worship.get(Long.valueOf(factionId));
/* 31 */           if (xFactionData == null)
/*    */           {
/* 33 */             return false;
/*    */           }
/* 35 */           xFactionData.getWorshipdata().clear();
/* 36 */           xFactionData.getWorshiprecord().clear();
/* 37 */           return true;
/*    */         }
/*    */       }.call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\RClearAllFactionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */