/*    */ package mzm.gsp.instance.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FinishMultiInstanceArg
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */ 
/*    */   private final int instanceDisType;
/*    */   
/*    */   private final boolean isFirstTime;
/*    */   
/*    */ 
/*    */   public FinishMultiInstanceArg(long roleid, int instanceDisType, boolean isFirstTime)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.instanceDisType = instanceDisType;
/* 19 */     this.isFirstTime = isFirstTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleid()
/*    */   {
/* 29 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getInstanceDisType()
/*    */   {
/* 39 */     return this.instanceDisType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isNormalInstance()
/*    */   {
/* 49 */     return this.instanceDisType == 1;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isEliteInstance()
/*    */   {
/* 59 */     return this.instanceDisType == 2;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isHeroInstance()
/*    */   {
/* 69 */     return this.instanceDisType == 3;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isNightmareInstance()
/*    */   {
/* 79 */     return this.instanceDisType == 4;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isActivityInstance()
/*    */   {
/* 89 */     return this.instanceDisType == 5;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isFirstTimeFinish()
/*    */   {
/* 99 */     return this.isFirstTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\event\FinishMultiInstanceArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */