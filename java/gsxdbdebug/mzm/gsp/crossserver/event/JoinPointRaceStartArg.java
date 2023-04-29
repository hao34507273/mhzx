/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.point.RolePointRaceMarkingInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoinPointRaceStartArg
/*    */ {
/*    */   private final long contextid;
/*    */   private final long corpsid;
/*    */   private final long leaderid;
/*    */   private final List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos;
/*    */   private final long createTime;
/*    */   
/*    */   public JoinPointRaceStartArg(long contextid, long corpsid, long leaderid, List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos, long createTime)
/*    */   {
/* 18 */     this.contextid = contextid;
/* 19 */     this.corpsid = corpsid;
/* 20 */     this.leaderid = leaderid;
/* 21 */     this.rolePointRaceMarkingInfos = rolePointRaceMarkingInfos;
/* 22 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getContextid()
/*    */   {
/* 32 */     return this.contextid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCorpsid()
/*    */   {
/* 42 */     return this.corpsid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeaderid()
/*    */   {
/* 52 */     return this.leaderid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<RolePointRaceMarkingInfo> getRolePointRaceMarkingInfos()
/*    */   {
/* 62 */     return this.rolePointRaceMarkingInfos;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCreateTime()
/*    */   {
/* 72 */     return this.createTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\JoinPointRaceStartArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */