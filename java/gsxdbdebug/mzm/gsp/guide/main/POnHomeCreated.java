/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.homeland.event.CreateHomeArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnHomeCreated extends mzm.gsp.homeland.event.CreateHomeEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleid = ((CreateHomeArg)this.arg).ownerRoleId;
/* 15 */     Set<Integer> guideids = GuideManager.getCreateHomeGuideids();
/* 16 */     if ((guideids == null) || (guideids.isEmpty()))
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     List<Integer> toremove = new ArrayList();
/* 21 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/*    */       
/* 23 */       if (GuideManager.isGuided(roleid, guideid))
/*    */       {
/* 25 */         toremove.add(Integer.valueOf(guideid));
/*    */       }
/*    */       else
/* 28 */         GuideManager.setUnGuidedState(roleid, guideid);
/*    */     }
/* 30 */     guideids.removeAll(toremove);
/* 31 */     if (guideids.size() > 0)
/*    */     {
/* 33 */       GuideManager.sendCanGuideids(roleid, guideids);
/*    */       
/* 35 */       String logstr = String.format("[guide]POnHomeCreated.processImp@send can guideid success roleid=%d|guideids=%s", new Object[] { Long.valueOf(roleid), guideids.toString() });
/*    */       
/* 37 */       GuideManager.logger.info(logstr);
/*    */     }
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnHomeCreated.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */