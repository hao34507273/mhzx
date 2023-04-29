/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.shitu.event.MasterRecommendArg;
/*    */ import mzm.gsp.shitu.event.MasterRecommendProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnMasterRecommend
/*    */   extends MasterRecommendProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleid = ((MasterRecommendArg)this.arg).getApprenticeRoleId();
/*    */     
/*    */ 
/* 20 */     if (!OpenInterface.getOpenStatus(418))
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 26 */     if (((MasterRecommendArg)this.arg).isSuccess())
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     Set<Integer> guideids = GuideManager.getShiTuBaiShiGuideids();
/* 32 */     if ((guideids == null) || (guideids.isEmpty()))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     List<Integer> toremove = new ArrayList();
/* 37 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/*    */       
/* 39 */       if (GuideManager.isGuided(roleid, guideid))
/*    */       {
/* 41 */         toremove.add(Integer.valueOf(guideid));
/*    */       }
/*    */       else
/* 44 */         GuideManager.setUnGuidedState(roleid, guideid);
/*    */     }
/* 46 */     guideids.removeAll(toremove);
/* 47 */     if (guideids.size() > 0)
/*    */     {
/* 49 */       GuideManager.sendCanGuideids(roleid, guideids);
/*    */       
/* 51 */       String logstr = String.format("[guide]POnMasterRecommend.processImp@send can guideid success roleid=%d|guideids=%s", new Object[] { Long.valueOf(roleid), guideids.toString() });
/*    */       
/*    */ 
/* 54 */       GuideManager.logger.info(logstr);
/*    */     }
/*    */     
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnMasterRecommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */