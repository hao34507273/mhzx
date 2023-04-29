/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Group;
/*    */ import xbean.GroupMember;
/*    */ import xtable.Groups;
/*    */ 
/*    */ public class PUpdateMemberVersionInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long groupid;
/*    */   private final long groupBasicInfoVersion;
/*    */   private final long groupInfoVersion;
/*    */   
/*    */   public PUpdateMemberVersionInfo(long roleid, long groupid, long groupBasicInfoVersion, long groupInfoVersion)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.groupid = groupid;
/* 23 */     this.groupBasicInfoVersion = groupBasicInfoVersion;
/* 24 */     this.groupInfoVersion = groupInfoVersion;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     Group xGroup = Groups.get(Long.valueOf(this.groupid));
/* 32 */     if (xGroup == null)
/*    */     {
/*    */ 
/* 35 */       GroupManager.logger.info(String.format("[group]PUpdateMemberVersionInfo.processImp@group not exist|roleid=%d|groupid=%d|groupBasicInfoVersion=%d|groupInfoVersion=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Long.valueOf(this.groupBasicInfoVersion), Long.valueOf(this.groupInfoVersion) }));
/*    */       
/*    */ 
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (!xGroup.getMemberlist().contains(Long.valueOf(this.roleid)))
/*    */     {
/*    */ 
/* 44 */       GroupManager.logger.info(String.format("[group]PUpdateMemberVersionInfo.processImp@role is not in group|roleid=%d|groupid=%d|groupBasicInfoVersion=%d|groupInfoVersion=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Long.valueOf(this.groupBasicInfoVersion), Long.valueOf(this.groupInfoVersion) }));
/*    */       
/*    */ 
/* 47 */       return false;
/*    */     }
/* 49 */     if (this.groupBasicInfoVersion > 0L)
/* 50 */       ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(this.roleid))).setGroup_basic_info_version(this.groupBasicInfoVersion);
/* 51 */     if (this.groupInfoVersion > 0L) {
/* 52 */       ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(this.roleid))).setGroup_info_version(this.groupInfoVersion);
/*    */     }
/* 54 */     GroupManager.logger.info(String.format("[group]PUpdateMemberVersionInfo.processImp@updata member version info success|roleid=%d|groupid=%d|groupBasicInfoVersion=%d|groupInfoVersion=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Long.valueOf(this.groupBasicInfoVersion), Long.valueOf(this.groupInfoVersion) }));
/*    */     
/*    */ 
/*    */ 
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PUpdateMemberVersionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */