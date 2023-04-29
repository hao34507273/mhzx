/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.event.PlayerRealDeleteProcedure;
/*    */ import xbean.GroupInfo;
/*    */ 
/*    */ public class POnPlayerRealDelete extends PlayerRealDeleteProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 16 */     GroupInfo xGroupInfo = xtable.Role2groupinfo.get(Long.valueOf(roleid));
/* 17 */     if (xGroupInfo == null)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     for (Iterator i$ = xGroupInfo.getCreate_same_zone_groupids().keySet().iterator(); i$.hasNext();) { long groupid = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 24 */       GroupAsynTaskManager.getInstance().addTask(new PDissolveGroupOnRoleRealDelete(roleid, groupid));
/*    */     }
/* 26 */     for (Iterator i$ = xGroupInfo.getJoin_same_zone_groupids().keySet().iterator(); i$.hasNext();) { long groupid = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 29 */       GroupAsynTaskManager.getInstance().addTask(new PQuitGroupOnRoleRealDetele(roleid, groupid));
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\POnPlayerRealDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */