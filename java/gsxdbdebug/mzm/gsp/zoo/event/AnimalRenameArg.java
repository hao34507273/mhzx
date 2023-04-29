/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ public class AnimalRenameArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long animalid;
/*    */   public final String oldName;
/*    */   public final String name;
/*    */   
/*    */   public AnimalRenameArg(long roleid, long animalid, String oldName, String name)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.animalid = animalid;
/* 14 */     this.oldName = oldName;
/* 15 */     this.name = name;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\AnimalRenameArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */