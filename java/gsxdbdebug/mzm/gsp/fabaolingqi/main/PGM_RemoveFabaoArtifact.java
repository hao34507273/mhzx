/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RemoveFabaoArtifact
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long gmRoleId;
/*    */   private final int artifactItemId;
/*    */   private final int itemNumber;
/*    */   
/*    */   public PGM_RemoveFabaoArtifact(long roleId, long gmRoleId, int artifactItemId, int itemNumber)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.gmRoleId = gmRoleId;
/* 20 */     this.artifactItemId = artifactItemId;
/* 21 */     this.itemNumber = itemNumber;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     FabaoArtifactRemoveResult result = FabaoArtifactInterface.removeArtifactWithItem(this.roleId, this.artifactItemId, this.itemNumber);
/*    */     
/* 29 */     switch (result)
/*    */     {
/*    */ 
/*    */     case REMOVED: 
/*    */     case DURATION_CUT: 
/*    */     case UPGRADE_EXP_CUT: 
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("Success(%d): %s", new Object[] { Integer.valueOf(result.code), result.description }));
/*    */       
/* 37 */       return true;
/*    */     }
/*    */     
/*    */     
/* 41 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("Fail(%d): %s", new Object[] { Integer.valueOf(result.code), result.description }));
/*    */     
/* 43 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\PGM_RemoveFabaoArtifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */