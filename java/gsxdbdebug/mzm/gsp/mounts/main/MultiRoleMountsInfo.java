/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MultiRoleMountsInfo
/*    */ {
/*    */   public final long teamId;
/*    */   public final int mountsCfgId;
/*    */   public final List<Long> roleIds;
/*    */   
/*    */   protected MultiRoleMountsInfo(long teamId, int mountsCfgId, List<Long> roleIds)
/*    */   {
/* 24 */     this.teamId = teamId;
/* 25 */     this.mountsCfgId = mountsCfgId;
/* 26 */     this.roleIds = roleIds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeader()
/*    */   {
/* 34 */     return ((Long)this.roleIds.get(0)).longValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\MultiRoleMountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */