/*    */ package mzm.gsp.zoo.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ 
/*    */ public class AnimalStageChangeCallback implements MapCallback<Boolean>
/*    */ {
/*    */   private final long roleid;
/*    */   private final long animalid;
/*    */   private final long worldid;
/*    */   private final int mapCfgid;
/*    */   
/*    */   public AnimalStageChangeCallback(long roleid, long animalid, long worldid, int mapCfgid)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.animalid = animalid;
/* 16 */     this.worldid = worldid;
/* 17 */     this.mapCfgid = mapCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onResult(Boolean result)
/*    */   {
/* 29 */     if (!result.booleanValue())
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     ZooManager.displayAtYard(this.roleid, this.animalid, this.worldid, this.mapCfgid);
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\AnimalStageChangeCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */