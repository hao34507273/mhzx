/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shitu.event.BaiShiArg;
/*    */ import mzm.gsp.shitu.event.BaiShiProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnBaiShi extends BaiShiProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     long masterRoleId = ((BaiShiArg)this.arg).getMasterRoleId();
/* 19 */     long apprenticeRoleId = ((BaiShiArg)this.arg).getApprenticeRoleId();
/*    */     
/*    */ 
/* 22 */     if (!OpenInterface.getOpenStatus(417))
/*    */     {
/* 24 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 28 */     if (!((BaiShiArg)this.arg).isSuccess())
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     Set<Integer> guideids = GuideManager.getShiTuTaskGuideids();
/* 34 */     if ((guideids == null) || (guideids.isEmpty()))
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 40 */     String masterUserId = RoleInterface.getUserId(masterRoleId);
/* 41 */     String apprenticeUserId = RoleInterface.getUserId(apprenticeRoleId);
/* 42 */     if ((masterUserId == null) || (apprenticeUserId == null))
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     super.lock(xtable.User.getTable(), Arrays.asList(new String[] { masterUserId, apprenticeUserId }));
/*    */     
/*    */ 
/* 49 */     super.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(masterRoleId), Long.valueOf(apprenticeRoleId) }));
/*    */     
/*    */ 
/* 52 */     List<Integer> toMasterRemove = new ArrayList();
/* 53 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/*    */       
/* 55 */       if (GuideManager.isGuided(masterRoleId, guideid))
/*    */       {
/* 57 */         toMasterRemove.add(Integer.valueOf(guideid));
/*    */       }
/*    */       else
/* 60 */         GuideManager.setUnGuidedState(masterRoleId, guideid);
/*    */     }
/* 62 */     guideids.removeAll(toMasterRemove);
/* 63 */     if (guideids.size() > 0)
/*    */     {
/* 65 */       GuideManager.sendCanGuideids(masterRoleId, guideids);
/*    */       
/* 67 */       String logstr = String.format("[guide]POnBaiShi.processImp@send can guideid success roleid=%d|guideids=%s", new Object[] { Long.valueOf(masterRoleId), guideids.toString() });
/*    */       
/* 69 */       GuideManager.logger.info(logstr);
/*    */     }
/*    */     
/*    */ 
/* 73 */     guideids = GuideManager.getShiTuTaskGuideids();
/* 74 */     List<Integer> toApprenticeRemove = new ArrayList();
/* 75 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/*    */       
/* 77 */       if (GuideManager.isGuided(apprenticeRoleId, guideid))
/*    */       {
/* 79 */         toApprenticeRemove.add(Integer.valueOf(guideid));
/*    */       }
/*    */       else
/* 82 */         GuideManager.setUnGuidedState(apprenticeRoleId, guideid);
/*    */     }
/* 84 */     guideids.removeAll(toApprenticeRemove);
/* 85 */     if (guideids.size() > 0)
/*    */     {
/* 87 */       GuideManager.sendCanGuideids(apprenticeRoleId, guideids);
/*    */       
/* 89 */       String logstr = String.format("[guide]POnBaiShi.processImp@send can guideid success roleid=%d|guideids=%s", new Object[] { Long.valueOf(apprenticeRoleId), guideids.toString() });
/*    */       
/* 91 */       GuideManager.logger.info(logstr);
/*    */     }
/* 93 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnBaiShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */