/*    */ package mzm.gsp.task.condition;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.pet.main.Pet;
/*    */ import mzm.gsp.pet.main.PetBag;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import mzm.gsp.task.confbean.STask;
/*    */ import mzm.gsp.task.confbean.STaskConpetCon;
/*    */ import xbean.ConBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Con_Pet_10
/*    */   extends AbsCondition
/*    */ {
/*    */   public Con_Pet_10(int conId, int conType, int sTaskId)
/*    */   {
/* 25 */     super(conId, conType, sTaskId);
/*    */   }
/*    */   
/*    */   STaskConpetCon getConpetCon()
/*    */   {
/* 30 */     return STaskConpetCon.get(getConId());
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isComplete(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params, int graphId)
/*    */   {
/* 36 */     STaskConpetCon conPet = getConpetCon();
/* 37 */     PetBag petBag = PetInterface.getPetBag(roleId, false);
/* 38 */     int num = petBag.countPetByCfgId(conPet.petId);
/* 39 */     if (num < conPet.petCount)
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     Pet fightPet = PetInterface.getFightPet(roleId, false);
/* 44 */     if ((fightPet != null) && (fightPet.getCfgId() == conPet.petId))
/*    */     {
/* 46 */       num--;
/*    */     }
/* 48 */     Pet showPet = PetInterface.getShowPet(roleId, false);
/* 49 */     if ((showPet != null) && (showPet.getCfgId() == conPet.petId))
/*    */     {
/* 51 */       num--;
/*    */     }
/* 53 */     if (num < conPet.petCount)
/*    */     {
/* 55 */       return false;
/*    */     }
/* 57 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getType()
/*    */   {
/* 63 */     return 10;
/*    */   }
/*    */   
/*    */ 
/*    */   public void checkCfg()
/*    */   {
/* 69 */     STaskConpetCon conPet = getConpetCon();
/* 70 */     if (!PetInterface.isPetCfgExist(conPet.petId))
/*    */     {
/* 72 */       throw new RuntimeException("任务配置宠物Id出错,TaskId:" + getSTask().id + ",petId:" + conPet.petId + " 宠物条件");
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isVisiable(long roleId, Map<Integer, ConBean> conMap, Map<Integer, Object> params)
/*    */   {
/* 79 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\condition\Con_Pet_10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */