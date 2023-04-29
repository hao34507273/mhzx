/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ public class AnimalStageChangeArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long animalid;
/*    */   public final int oldStage;
/*    */   public final int newStage;
/*    */   
/*    */   public AnimalStageChangeArg(long roleid, long animalid, int oldStage, int newStage)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.animalid = animalid;
/* 14 */     this.oldStage = oldStage;
/* 15 */     this.newStage = newStage;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\AnimalStageChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */