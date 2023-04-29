/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum BackupResult
/*    */ {
/*  8 */   Success(0, "success"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 13 */   ParamInvalid(-1, "param invlaid"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 18 */   CfgNotFound(-2, "cfg not exist"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 23 */   DateExpire(-3, "date expire"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 28 */   CurPointRaceNotEnd(-4, "cur point race not end"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 33 */   AlreadyBackup(-5, "already backuped"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 38 */   OtherException(-6, "other exception"), 
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 43 */   RoamServerBan(-7, "roam server ban");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final int code;
/*    */   
/*    */ 
/*    */   public final String desc;
/*    */   
/*    */ 
/*    */ 
/*    */   private BackupResult(int code, String desc)
/*    */   {
/* 57 */     this.code = code;
/* 58 */     this.desc = desc;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\BackupResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */