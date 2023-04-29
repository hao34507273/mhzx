/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import xbean.GroupInfo;
/*    */ import xtable.Role2groupinfo;
/*    */ 
/*    */ public class POnRoleLogoff
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 17 */     GroupInfo xGroupInfo = Role2groupinfo.get(Long.valueOf(roleid));
/* 18 */     if (xGroupInfo == null)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     for (Iterator i$ = xGroupInfo.getCreate_same_zone_groupids().keySet().iterator(); i$.hasNext();) { long groupid = ((Long)i$.next()).longValue();
/*    */       
/* 24 */       GroupAsynTaskManager.getInstance().addTask(new PClearMemberVersionInfo(roleid, groupid));
/*    */     }
/* 26 */     for (Iterator i$ = xGroupInfo.getJoin_same_zone_groupids().keySet().iterator(); i$.hasNext();) { long groupid = ((Long)i$.next()).longValue();
/*    */       
/* 28 */       GroupAsynTaskManager.getInstance().addTask(new PClearMemberVersionInfo(roleid, groupid));
/*    */     }
/* 30 */     GroupAsynTaskManager.getInstance().addTask(new PMemberOnlineStateChangeNotify(roleid, xGroupInfo.getCreate_same_zone_groupids().keySet(), xGroupInfo.getJoin_same_zone_groupids().keySet(), 2));
/*    */     
/*    */ 
/*    */ 
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */