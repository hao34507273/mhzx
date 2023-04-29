/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.event.PVEFightStartArg;
/*    */ import mzm.gsp.fight.event.PVEFightStartProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnPVEFightStart
/*    */   extends PVEFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     Set<Integer> guideids = GuideManager.getGuideIdsByInFightid(((PVEFightStartArg)this.arg).fightCfgID);
/* 17 */     if ((guideids == null) || (guideids.isEmpty()))
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     List<Integer> toremove = new ArrayList();
/* 22 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int gid = ((Integer)i$.next()).intValue();
/*    */       
/* 24 */       if (GuideManager.isGuided(((Long)((PVEFightStartArg)this.arg).roles.get(0)).longValue(), gid))
/*    */       {
/* 26 */         toremove.add(Integer.valueOf(gid));
/*    */       }
/*    */       else
/* 29 */         GuideManager.setUnGuidedState(((Long)((PVEFightStartArg)this.arg).roles.get(0)).longValue(), gid);
/*    */     }
/* 31 */     guideids.removeAll(toremove);
/* 32 */     if (guideids.size() > 0)
/*    */     {
/* 34 */       GuideManager.sendCanGuideids(((Long)((PVEFightStartArg)this.arg).roles.get(0)).longValue(), guideids);
/* 35 */       String logstr = String.format("[guide]POnPVEFightStart.processImp@send can guideid success roleid=%d|fightid=%d|guideids=%s", new Object[] { ((PVEFightStartArg)this.arg).roles.get(0), Integer.valueOf(((PVEFightStartArg)this.arg).fightCfgID), guideids.toString() });
/* 36 */       GuideManager.logger.info(logstr);
/*    */     }
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnPVEFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */