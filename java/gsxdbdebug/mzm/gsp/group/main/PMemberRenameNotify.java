/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.group.SMemberRenameBrd;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Group;
/*    */ import xbean.GroupMember;
/*    */ import xtable.Groups;
/*    */ 
/*    */ public class PMemberRenameNotify extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/* 19 */   private final Set<Long> groupids = new java.util.HashSet();
/*    */   
/*    */   private final String roleName;
/*    */   
/*    */   public PMemberRenameNotify(long roleid, Set<Long> createGroupids, Set<Long> joinGroupids, String roleName)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.groupids.addAll(createGroupids);
/* 27 */     this.groupids.addAll(joinGroupids);
/* 28 */     this.roleName = roleName;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     for (Iterator i$ = this.groupids.iterator(); i$.hasNext();) { long groupid = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 37 */       Group xGroup = Groups.select(Long.valueOf(groupid));
/* 38 */       if (xGroup == null)
/*    */       {
/*    */ 
/* 41 */         GroupManager.logger.info(String.format("[group]PMemberRenameNotify.processImp@group not exist|roleid=%d|groupid=%d|roleName=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(groupid), this.roleName }));
/*    */         
/*    */ 
/* 44 */         return false;
/*    */       }
/*    */       
/* 47 */       if (!xGroup.getMemberlist().contains(Long.valueOf(this.roleid)))
/*    */       {
/*    */ 
/* 50 */         GroupManager.logger.info(String.format("[group]PQuitGroupReq.processImp@role is not in group|roleid=%d|groupid=%d|roleName=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(groupid), this.roleName }));
/*    */         
/*    */ 
/* 53 */         return false;
/*    */       }
/*    */       
/* 56 */       ArrayList<Long> concernMemberList = new ArrayList(xGroup.getMemberlist());
/* 57 */       Iterator<Long> iterator = concernMemberList.iterator();
/* 58 */       while (iterator.hasNext())
/*    */       {
/* 60 */         long memberid = ((Long)iterator.next()).longValue();
/* 61 */         if (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_info_version() != xGroup.getInfo_version()) {
/* 62 */           iterator.remove();
/*    */         }
/*    */       }
/* 65 */       SMemberRenameBrd protocol = new SMemberRenameBrd();
/* 66 */       protocol.groupid = groupid;
/* 67 */       protocol.memberid = this.roleid;
/* 68 */       protocol.name.setString(this.roleName, "UTF-8");
/* 69 */       protocol.info_version = xGroup.getInfo_version();
/* 70 */       OnlineManager.getInstance().sendMulti(protocol, concernMemberList);
/*    */     }
/*    */     
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PMemberRenameNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */