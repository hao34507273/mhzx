/*    */ package mzm.gsp.shitu.event;
/*    */ 
/*    */ import java.util.Collection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MasterRecommendArg
/*    */ {
/*    */   private final long apprenticeRoleId;
/*    */   private final Collection<Long> recommendMasterRoleIdList;
/*    */   private final boolean isSuccess;
/*    */   
/*    */   public MasterRecommendArg(long apprenticeRoleId, Collection<Long> recommendMasterRoleIdList, boolean isSuccess)
/*    */   {
/* 18 */     this.apprenticeRoleId = apprenticeRoleId;
/* 19 */     this.recommendMasterRoleIdList = recommendMasterRoleIdList;
/* 20 */     this.isSuccess = isSuccess;
/*    */   }
/*    */   
/*    */   public long getApprenticeRoleId()
/*    */   {
/* 25 */     return this.apprenticeRoleId;
/*    */   }
/*    */   
/*    */   public Collection<Long> getRecommendMasterRoleIdList()
/*    */   {
/* 30 */     return this.recommendMasterRoleIdList;
/*    */   }
/*    */   
/*    */   public boolean isSuccess()
/*    */   {
/* 35 */     return this.isSuccess;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\event\MasterRecommendArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */