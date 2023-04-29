/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GroupInfo;
/*    */ import xtable.Role2groupinfo;
/*    */ 
/*    */ 
/*    */ public class PRemoveRoleGroupInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long groupid;
/*    */   
/*    */   public PRemoveRoleGroupInfo(long roleid, long groupid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.groupid = groupid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     GroupInfo xGroupInfo = Role2groupinfo.get(Long.valueOf(this.roleid));
/* 26 */     if ((xGroupInfo == null) || (xGroupInfo.getJoin_same_zone_groupids().remove(Long.valueOf(this.groupid)) == null))
/*    */     {
/* 28 */       GroupManager.logger.error(String.format("[group]PRemoveRoleGroupInfo.processImp@role is not in group|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */       
/* 30 */       return false;
/*    */     }
/* 32 */     GroupManager.logger.info(String.format("[group]PRemoveRoleGroupInfo.processImp@remove role group info success|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PRemoveRoleGroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */