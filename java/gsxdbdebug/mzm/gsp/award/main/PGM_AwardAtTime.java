/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_AwardAtTime
/*    */   extends PGM_AwardToRolesXTime
/*    */ {
/*    */   private final String awardTimeStr;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public PGM_AwardAtTime(long roleId, int awardId, int modifyId, int count, String awardTimeStr)
/*    */   {
/* 16 */     super(roleId, awardId, modifyId, count);
/* 17 */     this.awardTimeStr = awardTimeStr;
/*    */   }
/*    */   
/*    */ 
/*    */   String getAwardTimeStr()
/*    */   {
/* 23 */     return this.awardTimeStr;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PGM_AwardAtTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */