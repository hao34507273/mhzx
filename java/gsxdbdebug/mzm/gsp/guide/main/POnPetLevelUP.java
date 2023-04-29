/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PlayerPetLevelUpProcedure;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnPetLevelUP extends PlayerPetLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long roleid = ((PetEventArg)this.arg).roleId;
/* 17 */     long petid = ((PetEventArg)this.arg).petId;
/* 18 */     int level = PetInterface.getPetInfo(roleid, petid).petlevel;
/* 19 */     Set<Integer> guideids = GuideManager.getGuideIdsByPetLevel(level);
/* 20 */     if ((guideids == null) || (guideids.isEmpty()))
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     List<Integer> toremove = new ArrayList();
/* 25 */     for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/*    */       
/* 27 */       if (GuideManager.isGuided(((PetEventArg)this.arg).roleId, guideid))
/*    */       {
/* 29 */         toremove.add(Integer.valueOf(guideid));
/*    */       }
/*    */       else
/* 32 */         GuideManager.setUnGuidedState(roleid, guideid);
/*    */     }
/* 34 */     guideids.removeAll(toremove);
/* 35 */     if (guideids.size() > 0)
/*    */     {
/* 37 */       GuideManager.sendCanGuideids(roleid, guideids);
/* 38 */       String logstr = String.format("[guide]POnPetLevelUP.processImp@send can guideid success roleid=%d|petlevel=%d|guideids=%s", new Object[] { Long.valueOf(((PetEventArg)this.arg).roleId), Integer.valueOf(level), guideids.toString() });
/* 39 */       GuideManager.logger.info(logstr);
/*    */     }
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnPetLevelUP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */