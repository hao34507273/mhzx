/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.task.main.TaskEventArg;
/*    */ 
/*    */ public class POnTaskStateChange extends mzm.gsp.task.event.TaskStateChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (((TaskEventArg)this.arg).taskState != 8) {
/* 14 */       return false;
/*    */     }
/* 16 */     Set<Integer> guideids = GuideManager.getGuideIdsByTaskid(((TaskEventArg)this.arg).taskId);
/* 17 */     if ((guideids == null) || (guideids.isEmpty())) {
/* 18 */       return false;
/*    */     }
/* 20 */     GuideManager.filterMenpaiGuide(((TaskEventArg)this.arg).roleId, guideids);
/* 21 */     List<Integer> toremove = new ArrayList();
/* 22 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/* 23 */       if (GuideManager.isGuided(((TaskEventArg)this.arg).roleId, guideid)) {
/* 24 */         toremove.add(Integer.valueOf(guideid));
/*    */       }
/*    */       else
/* 27 */         GuideManager.setUnGuidedState(((TaskEventArg)this.arg).roleId, guideid);
/*    */     }
/* 29 */     guideids.removeAll(toremove);
/* 30 */     if (guideids.size() > 0) {
/* 31 */       GuideManager.sendCanGuideids(((TaskEventArg)this.arg).roleId, guideids);
/* 32 */       String logstr = String.format("[guide]POnTaskStateChange.processImp@send can guideid success roleid=%d|taskid=%d|guideids=%s", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), Integer.valueOf(((TaskEventArg)this.arg).taskId), guideids.toString() });
/* 33 */       GuideManager.logger.info(logstr);
/*    */     }
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnTaskStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */