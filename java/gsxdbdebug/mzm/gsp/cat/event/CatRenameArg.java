/*    */ package mzm.gsp.cat.event;
/*    */ 
/*    */ public class CatRenameArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long catid;
/*    */   public final String oldName;
/*    */   public final String newName;
/*    */   
/*    */   public CatRenameArg(long roleid, long catid, String oldName, String newName)
/*    */   {
/* 12 */     this.roleid = roleid;
/* 13 */     this.catid = catid;
/* 14 */     this.oldName = oldName;
/* 15 */     this.newName = newName;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\event\CatRenameArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */