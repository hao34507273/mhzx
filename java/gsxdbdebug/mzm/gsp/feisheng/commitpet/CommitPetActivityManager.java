/*    */ package mzm.gsp.feisheng.commitpet;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengCommitPetActivityCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommitPetActivityManager
/*    */ {
/*    */   public static void init()
/*    */   {
/* 19 */     ActivityInterface.registerActivityByLogicType(86, new FeiShengCommitPetActivityHandler());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isFeiShengCommitPetActivitySwitchOpenForRole(long roleid, int activityCfgid)
/*    */   {
/* 31 */     SFeiShengCommitPetActivityCfg cfg = SFeiShengCommitPetActivityCfg.get(activityCfgid);
/* 32 */     if (cfg == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*    */     {
/* 42 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 43 */       return false;
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean cutAllNeedPet(long roleid, int activityCfgid)
/*    */   {
/* 58 */     SFeiShengCommitPetActivityCfg cfg = SFeiShengCommitPetActivityCfg.get(activityCfgid);
/* 59 */     if (cfg == null)
/*    */     {
/*    */ 
/* 62 */       return false;
/*    */     }
/* 64 */     for (Map.Entry<Integer, Integer> entry : cfg.need_pets.entrySet())
/*    */     {
/* 66 */       if (!PetInterface.removePetInBag(roleid, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue()))
/*    */       {
/* 68 */         return false;
/*    */       }
/*    */     }
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\commitpet\CommitPetActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */