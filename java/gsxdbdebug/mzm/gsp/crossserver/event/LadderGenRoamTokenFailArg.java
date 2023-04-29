/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossserver.main.MatchActivityContext;
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ import mzm.gsp.crossserver.main.RoleMatchMarkingInfo;
/*    */ 
/*    */ 
/*    */ public class LadderGenRoamTokenFailArg
/*    */   extends GenRoamTokenFailArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long leaderid;
/*    */   private final List<RoleMatchMarkingInfo> roleMatchMarkingInfos;
/*    */   private final MatchActivityContext activityContext;
/*    */   private final long createTime;
/*    */   
/*    */   public LadderGenRoamTokenFailArg(RoamType roamType, long contextid, long leaderid, List<RoleMatchMarkingInfo> roleMatchMarkingInfos, MatchActivityContext activityContext, long createTime)
/*    */   {
/* 20 */     super(roamType);
/*    */     
/* 22 */     this.contextid = contextid;
/* 23 */     this.leaderid = leaderid;
/* 24 */     this.roleMatchMarkingInfos = roleMatchMarkingInfos;
/* 25 */     this.activityContext = activityContext;
/* 26 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getContextid()
/*    */   {
/* 36 */     return this.contextid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderid()
/*    */   {
/* 46 */     return this.leaderid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<RoleMatchMarkingInfo> getRoleMatchMarkingInfos()
/*    */   {
/* 56 */     return this.roleMatchMarkingInfos;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public MatchActivityContext getActivityContext()
/*    */   {
/* 66 */     return this.activityContext;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getMatchStartTime()
/*    */   {
/* 76 */     return this.createTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\LadderGenRoamTokenFailArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */