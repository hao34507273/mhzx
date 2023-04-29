/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossserver.main.MatchActivityContext;
/*    */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MatchStartArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long leaderid;
/*    */   private final List<RoleMatchMarkingInfo> roleMatchMarkingInfos;
/*    */   private final MatchActivityContext activityContext;
/*    */   private final long createTime;
/*    */   
/*    */   public MatchStartArg(long contextid, long leaderid, List<RoleMatchMarkingInfo> roleMatchMarkingInfos, MatchActivityContext activityContext, long createTime)
/*    */   {
/* 19 */     this.contextid = contextid;
/* 20 */     this.leaderid = leaderid;
/* 21 */     this.roleMatchMarkingInfos = roleMatchMarkingInfos;
/* 22 */     this.activityContext = activityContext;
/* 23 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getContextid()
/*    */   {
/* 33 */     return this.contextid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderid()
/*    */   {
/* 43 */     return this.leaderid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<RoleMatchMarkingInfo> getRoleMatchMarkingInfos()
/*    */   {
/* 53 */     return this.roleMatchMarkingInfos;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public MatchActivityContext getActivityContext()
/*    */   {
/* 63 */     return this.activityContext;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getMatchStartTime()
/*    */   {
/* 73 */     return this.createTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\MatchStartArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */