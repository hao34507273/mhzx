/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum FabaoArtifactRemoveResult
/*    */ {
/*  9 */   REMOVED(0, "removed"), 
/*    */   
/*    */ 
/* 12 */   UPGRADE_EXP_CUT(1, "upgrade exp cut"), 
/*    */   
/*    */ 
/* 15 */   DURATION_CUT(2, "duration cut"), 
/*    */   
/*    */ 
/* 18 */   UNKNOWN(-1, "unknown"), 
/*    */   
/*    */ 
/* 21 */   INVALID_ARTIFACT_ITEM(-2, "invalid fabao artifact item"), 
/*    */   
/*    */ 
/* 24 */   ROLE_ARTIFACT_NOT_FOUND(-3, "role not found or role not own the fabao artifact");
/*    */   
/*    */ 
/*    */   public final int code;
/*    */   public final String description;
/*    */   
/*    */   private FabaoArtifactRemoveResult(int code, String description)
/*    */   {
/* 32 */     this.code = code;
/* 33 */     this.description = description;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\FabaoArtifactRemoveResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */