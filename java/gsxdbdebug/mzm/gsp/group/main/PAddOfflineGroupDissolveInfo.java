/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GroupInfo;
/*    */ import xtable.Role2groupinfo;
/*    */ 
/*    */ 
/*    */ public class PAddOfflineGroupDissolveInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long groupid;
/*    */   private final String groupName;
/*    */   
/*    */   public PAddOfflineGroupDissolveInfo(long roleid, long groupid, String groupName)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.groupid = groupid;
/* 21 */     this.groupName = groupName;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     GroupInfo xGroupInfo = Role2groupinfo.get(Long.valueOf(this.roleid));
/* 29 */     if ((xGroupInfo != null) && (xGroupInfo.getJoin_same_zone_groupids().containsKey(Long.valueOf(this.groupid))))
/*    */     {
/* 31 */       GroupManager.logger.info(String.format("[group]PAddOfflineGroupDissolveInfo.processImp@role is in group|roleid=%d|groupid=%d|groupName=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), this.groupName }));
/*    */       
/*    */ 
/* 34 */       return false;
/*    */     }
/* 36 */     xGroupInfo.getOffline_group_dissolve_infos().put(Long.valueOf(this.groupid), this.groupName);
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PAddOfflineGroupDissolveInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */