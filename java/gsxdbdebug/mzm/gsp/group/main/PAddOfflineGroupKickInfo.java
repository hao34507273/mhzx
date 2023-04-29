/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GroupInfo;
/*    */ import xtable.Role2groupinfo;
/*    */ 
/*    */ 
/*    */ public class PAddOfflineGroupKickInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long masterid;
/*    */   private final long memberid;
/*    */   private final long groupid;
/*    */   
/*    */   public PAddOfflineGroupKickInfo(long masterid, long memberid, long groupid)
/*    */   {
/* 19 */     this.masterid = masterid;
/* 20 */     this.memberid = memberid;
/* 21 */     this.groupid = groupid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     GroupInfo xGroupInfo = Role2groupinfo.get(Long.valueOf(this.memberid));
/* 29 */     if ((xGroupInfo != null) && (xGroupInfo.getJoin_same_zone_groupids().containsKey(Long.valueOf(this.groupid))))
/*    */     {
/* 31 */       GroupManager.logger.info(String.format("[group]PAddOfflineGroupKickInfo.processImp@member is in group|masterid=%d|memberid=%d|groupid=%d", new Object[] { Long.valueOf(this.masterid), Long.valueOf(this.memberid), Long.valueOf(this.groupid) }));
/*    */       
/*    */ 
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (xGroupInfo.getOffline_group_join_infos().containsKey(Long.valueOf(this.groupid)))
/*    */     {
/* 39 */       xGroupInfo.getOffline_group_join_infos().remove(Long.valueOf(this.groupid));
/*    */     }
/*    */     else
/*    */     {
/* 43 */       xGroupInfo.getOffline_group_kick_infos().put(Long.valueOf(this.groupid), Long.valueOf(this.masterid));
/*    */     }
/*    */     
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PAddOfflineGroupKickInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */