/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.multioccupation.event.ActivateNewOccupArg;
/*    */ 
/*    */ public class POnRoleActivateNewOccup extends mzm.gsp.multioccupation.event.ActivateNewOccupProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((ActivateNewOccupArg)this.arg).roleid;
/* 14 */     Set<Integer> guideids = GuideManager.getTransferOcpGuideids();
/* 15 */     if ((guideids == null) || (guideids.isEmpty()))
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     List<Integer> toremove = new ArrayList();
/* 20 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/*    */       
/* 22 */       if (GuideManager.isGuided(roleid, guideid))
/*    */       {
/* 24 */         toremove.add(Integer.valueOf(guideid));
/*    */       }
/*    */       else
/* 27 */         GuideManager.setUnGuidedState(roleid, guideid);
/*    */     }
/* 29 */     guideids.removeAll(toremove);
/* 30 */     if (guideids.size() > 0)
/*    */     {
/* 32 */       GuideManager.sendCanGuideids(roleid, guideids);
/*    */       
/* 34 */       String logstr = String.format("[guide]POnRoleActivateNewOccup.processImp@send can guideid success roleid=%d|guideids=%s", new Object[] { Long.valueOf(roleid), guideids.toString() });
/*    */       
/*    */ 
/* 37 */       GuideManager.logger.info(logstr);
/*    */     }
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnRoleActivateNewOccup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */