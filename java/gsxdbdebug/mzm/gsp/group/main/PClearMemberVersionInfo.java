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
/*    */ public class PClearMemberVersionInfo extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long groupid;
/*    */   
/*    */   public PClearMemberVersionInfo(long roleid, long groupid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.groupid = groupid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     Group xGroup = Groups.get(Long.valueOf(this.groupid));
/* 27 */     if (xGroup == null)
/*    */     {
/*    */ 
/* 30 */       GroupManager.logger.info(String.format("[group]PClearMemberVersionInfo.processImp@group not exist|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */       
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!xGroup.getMemberlist().contains(Long.valueOf(this.roleid)))
/*    */     {
/*    */ 
/* 38 */       GroupManager.logger.info(String.format("[group]PClearMemberVersionInfo.processImp@role is not in group|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */       
/* 40 */       return false;
/*    */     }
/* 42 */     ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(this.roleid))).setGroup_basic_info_version(-1L);
/* 43 */     ((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(this.roleid))).setGroup_info_version(-1L);
/*    */     
/* 45 */     GroupManager.logger.info(String.format("[group]PClearMemberVersionInfo.processImp@updata member version info success|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */     
/*    */ 
/*    */ 
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PClearMemberVersionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */