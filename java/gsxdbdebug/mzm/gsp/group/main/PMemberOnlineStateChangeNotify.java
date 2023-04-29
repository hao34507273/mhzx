/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.group.SMemberOnlineStateChangeBrd;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Group;
/*    */ import xbean.GroupMember;
/*    */ import xtable.Groups;
/*    */ 
/*    */ public class PMemberOnlineStateChangeNotify extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/* 19 */   private final Set<Long> groupids = new HashSet();
/*    */   private final int onlineState;
/*    */   
/*    */   public PMemberOnlineStateChangeNotify(long roleid, Set<Long> createGroupids, Set<Long> joinGroupids, int onlineState)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.groupids.addAll(createGroupids);
/* 26 */     this.groupids.addAll(joinGroupids);
/* 27 */     this.onlineState = onlineState;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     for (Iterator i$ = this.groupids.iterator(); i$.hasNext();) { long groupid = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 36 */       Group xGroup = Groups.select(Long.valueOf(groupid));
/* 37 */       if (xGroup == null)
/*    */       {
/*    */ 
/* 40 */         GroupManager.logger.info(String.format("[group]PMemberOnlineStateChangeNotify.processImp@group not exist|roleid=%d|groupid=%d|onlineState=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(groupid), Integer.valueOf(this.onlineState) }));
/*    */         
/*    */ 
/* 43 */         return false;
/*    */       }
/*    */       
/* 46 */       if (!xGroup.getMemberlist().contains(Long.valueOf(this.roleid)))
/*    */       {
/*    */ 
/* 49 */         GroupManager.logger.info(String.format("[group]PQuitGroupReq.processImp@role is not in group|roleid=%d|groupid=%d|onlineState=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(groupid), Integer.valueOf(this.onlineState) }));
/*    */         
/*    */ 
/* 52 */         return false;
/*    */       }
/*    */       
/* 55 */       ArrayList<Long> concernMemberList = new ArrayList(xGroup.getMemberlist());
/* 56 */       Iterator<Long> iterator = concernMemberList.iterator();
/* 57 */       while (iterator.hasNext())
/*    */       {
/* 59 */         long memberid = ((Long)iterator.next()).longValue();
/* 60 */         if (((GroupMember)xGroup.getGroupmembers().get(Long.valueOf(memberid))).getGroup_info_version() != xGroup.getInfo_version()) {
/* 61 */           iterator.remove();
/*    */         }
/*    */       }
/* 64 */       SMemberOnlineStateChangeBrd protocol = new SMemberOnlineStateChangeBrd();
/* 65 */       protocol.groupid = groupid;
/* 66 */       protocol.memberid = this.roleid;
/* 67 */       protocol.online_state = ((byte)this.onlineState);
/* 68 */       protocol.info_version = xGroup.getInfo_version();
/* 69 */       OnlineManager.getInstance().sendMulti(protocol, concernMemberList);
/*    */     }
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PMemberOnlineStateChangeNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */