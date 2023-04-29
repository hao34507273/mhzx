/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ 
/*    */ public class POnJoinGang extends mzm.gsp.gang.event.JoinGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Set<Integer> guideids = GuideManager.getJoinGangGuideids();
/* 14 */     if ((guideids == null) || (guideids.isEmpty()))
/*    */     {
/* 16 */       return false;
/*    */     }
/* 18 */     List<Integer> toremove = new ArrayList();
/* 19 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/*    */       
/* 21 */       if (GuideManager.isGuided(((GangArg)this.arg).roleId, guideid))
/*    */       {
/* 23 */         toremove.add(Integer.valueOf(guideid));
/*    */       }
/*    */       else
/* 26 */         GuideManager.setUnGuidedState(((GangArg)this.arg).roleId, guideid);
/*    */     }
/* 28 */     guideids.removeAll(toremove);
/* 29 */     if (guideids.size() > 0)
/*    */     {
/* 31 */       GuideManager.sendCanGuideids(((GangArg)this.arg).roleId, guideids);
/*    */       
/* 33 */       String logstr = String.format("[guide]POnJoinGang.processImp@send can guideid success roleid=%d|guideids=%s", new Object[] { Long.valueOf(((GangArg)this.arg).roleId), guideids.toString() });
/* 34 */       GuideManager.logger.info(logstr);
/*    */     }
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */