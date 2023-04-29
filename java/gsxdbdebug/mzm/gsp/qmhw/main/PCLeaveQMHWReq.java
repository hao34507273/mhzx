/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.QMHWActivity;
/*    */ import xtable.Role2qmhw;
/*    */ 
/*    */ public class PCLeaveQMHWReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCLeaveQMHWReq(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 25 */     QMHWActivity xQMHWActivity = xtable.Qmhw.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 26 */     Iterator i$; if (xQMHWActivity != null) {
/* 27 */       long worldid = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 28 */       if (worldid == xQMHWActivity.getWorldid()) {
/* 29 */         List<Long> allroles = new ArrayList();
/* 30 */         List<Long> normalRoles = mzm.gsp.team.main.TeamInterface.getNormalRoleList(this.roleid);
/* 31 */         if ((normalRoles != null) && (normalRoles.size() > 0) && (normalRoles.contains(Long.valueOf(this.roleid)))) {
/* 32 */           if (this.roleid != ((Long)normalRoles.get(0)).longValue()) {
/* 33 */             GameServer.logger().info(String.format("[QMHW]PCLeaveQMHWReq.processImp@role is in team but not leader|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */             
/*    */ 
/*    */ 
/* 37 */             return false;
/*    */           }
/* 39 */           allroles.addAll(normalRoles);
/*    */         }
/*    */         else {
/* 42 */           allroles.add(Long.valueOf(this.roleid));
/*    */         }
/* 44 */         lock(Role2qmhw.getTable(), allroles);
/* 45 */         mzm.gsp.status.main.RoleStatusInterface.unsetStatus(allroles, 31);
/* 46 */         for (i$ = allroles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 47 */           MapInterface.transferToScene(roleid, SQMHWCfgConsts.getInstance().OUT_MAP_ID);
/*    */         }
/*    */       }
/*    */     }
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\PCLeaveQMHWReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */