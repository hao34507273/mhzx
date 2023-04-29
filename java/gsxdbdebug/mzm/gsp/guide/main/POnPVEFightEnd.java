/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     Set<Integer> tobeguideids = GuideManager.getGuideIdsByInFightid(((PVEFightEndArg)this.arg).fightCfgID);
/* 15 */     Iterator i$; if ((tobeguideids != null) && (tobeguideids.size() > 0))
/*    */     {
/* 17 */       List<Integer> toremove1 = new ArrayList();
/* 18 */       for (Iterator i$ = tobeguideids.iterator(); i$.hasNext();) { int gid = ((Integer)i$.next()).intValue();
/*    */         
/* 20 */         if (GuideManager.isGuided(((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue(), gid))
/*    */         {
/* 22 */           toremove1.add(Integer.valueOf(gid));
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 27 */       tobeguideids.removeAll(toremove1);
/* 28 */       for (i$ = tobeguideids.iterator(); i$.hasNext();) { int g = ((Integer)i$.next()).intValue();
/*    */         
/* 30 */         new PSetGuidedState(((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue(), g).execute();
/*    */       }
/*    */     }
/*    */     
/* 34 */     Set<Integer> guideids = GuideManager.getGuideIdsByEndFightid(((PVEFightEndArg)this.arg).fightCfgID);
/* 35 */     if ((guideids == null) || (guideids.isEmpty()))
/*    */     {
/* 37 */       return true;
/*    */     }
/* 39 */     List<Integer> toremove = new ArrayList();
/* 40 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int gid = ((Integer)i$.next()).intValue();
/*    */       
/* 42 */       if (GuideManager.isGuided(((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue(), gid))
/*    */       {
/* 44 */         toremove.add(Integer.valueOf(gid));
/*    */       }
/*    */       else
/*    */       {
/* 48 */         GuideManager.setUnGuidedState(((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue(), gid); }
/*    */     }
/* 50 */     guideids.removeAll(toremove);
/* 51 */     if (guideids.size() > 0)
/*    */     {
/* 53 */       GuideManager.sendCanGuideids(((Long)((PVEFightEndArg)this.arg).roleList.get(0)).longValue(), guideids);
/* 54 */       String logstr = String.format("[guide]POnPVEFightEnd.processImp@send can guideid success roleid=%d|fightid=%d|guideids=%s", new Object[] { ((PVEFightEndArg)this.arg).roleList.get(0), Integer.valueOf(((PVEFightEndArg)this.arg).fightCfgID), guideids.toString() });
/* 55 */       GuideManager.logger.info(logstr);
/*    */     }
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */