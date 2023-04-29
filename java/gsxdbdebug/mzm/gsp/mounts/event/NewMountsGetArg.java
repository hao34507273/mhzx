/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ 
/*    */ public class NewMountsGetArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int mountsCfgId;
/*    */   public final int newMountsRank;
/*    */   
/*    */   public NewMountsGetArg(long roleId, int mountsCfgId, int newMountsRank)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.mountsCfgId = mountsCfgId;
/* 15 */     this.newMountsRank = newMountsRank;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\NewMountsGetArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */