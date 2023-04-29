/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteConfigManager;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteMatch;
/*    */ import xbean.RoamCrossCompeteFactionTmp;
/*    */ 
/*    */ public class RClose
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final boolean firstTime;
/*    */   
/*    */   public RClose(boolean firstTime)
/*    */   {
/* 23 */     this.firstTime = firstTime;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 29 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 30 */     if (xCompete == null) {
/* 31 */       return;
/*    */     }
/*    */     
/* 34 */     Iterator<Map.Entry<CrossCompeteMatch, CrossCompeteAgainst>> iter = xCompete.getAgainsts().entrySet().iterator();
/*    */     
/* 36 */     while (iter.hasNext()) {
/* 37 */       Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry = (Map.Entry)iter.next();
/* 38 */       CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)entry.getValue();
/*    */       
/* 40 */       if (CrossCompeteConfigManager.isInFirstCompeteTime(xAgainst.getCompete_index()) == this.firstTime)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 45 */         long winFactionid = xAgainst.getWinner();
/*    */         
/*    */ 
/* 48 */         RoamCrossCompeteFactionTmp xWinFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(winFactionid, false);
/*    */         
/*    */ 
/*    */ 
/* 52 */         if (xWinFactionTmp != null)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 57 */           for (Iterator i$ = xWinFactionTmp.getRoles().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */             
/* 59 */             TeamInterface.leaveTeam(roleid);
/*    */             
/* 61 */             new PLeave(roleid, 5).call();
/*    */           }
/*    */           
/* 64 */           CrossCompeteRoamManager.destroyFightWorld(xWinFactionTmp.getWorld());
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\RClose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */