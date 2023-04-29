/*    */ package mzm.gsp.mounts.event;
/*    */ 
/*    */ import mzm.gsp.mounts.main.MultiRoleMountsInfo;
/*    */ 
/*    */ public class MultiRoleMountsChangeArg extends MultiRoleMountsInfo
/*    */ {
/*    */   public final ChangeReason changeReason;
/*    */   
/*    */   public static enum ChangeReason
/*    */   {
/* 11 */     TEAM_INFO_CHANGE, 
/* 12 */     LEADER_MOUNTS_CHANGE, 
/* 13 */     MENBER_OPERATE_MULTI_ROLE_MOUNTS;
/*    */     
/*    */ 
/*    */ 
/*    */     private ChangeReason() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MultiRoleMountsChangeArg(long teamId, int mountsCfgId, java.util.List<Long> roleIds, ChangeReason changeReason)
/*    */   {
/* 24 */     super(teamId, mountsCfgId, roleIds);
/* 25 */     this.changeReason = changeReason;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\event\MultiRoleMountsChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */