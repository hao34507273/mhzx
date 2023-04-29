/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import xbean.JiuXiaoActivityBean;
/*    */ import xbean.JiuXiaoActivityInfo;
/*    */ 
/*    */ public class PCLeaveJiuXiaoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCLeaveJiuXiaoReq(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     JiuXiaoActivityBean xJiuxActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 25 */     Iterator i$; if (xJiuxActivityBean != null) {
/* 26 */       long worldid = MapInterface.getRoleWorldInstanceId(this.roleid);
/* 27 */       if (isInJiuXiaoWorld(xJiuxActivityBean, worldid)) {
/* 28 */         List<Long> allroles = new ArrayList();
/* 29 */         List<Long> normalRoles = mzm.gsp.team.main.TeamInterface.getNormalRoleList(this.roleid);
/* 30 */         if ((normalRoles != null) && (normalRoles.size() > 0) && (normalRoles.contains(Long.valueOf(this.roleid)))) {
/* 31 */           if (this.roleid != ((Long)normalRoles.get(0)).longValue()) {
/* 32 */             return false;
/*    */           }
/* 34 */           allroles.addAll(normalRoles);
/*    */         }
/*    */         else {
/* 37 */           allroles.add(Long.valueOf(this.roleid));
/*    */         }
/* 39 */         lock(xtable.Role2jiuxiao.getTable(), allroles);
/* 40 */         mzm.gsp.status.main.RoleStatusInterface.unsetStatus(allroles, 19);
/* 41 */         for (i$ = allroles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 42 */           MapInterface.transferToScene(roleid, SJueZhanJiuXiaoConsts.getInstance().outMapid);
/*    */         }
/*    */       }
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   private boolean isInJiuXiaoWorld(JiuXiaoActivityBean xJiuxActivityBean, long worldid) {
/* 50 */     for (JiuXiaoActivityInfo xJiuXiaoActivityInfo : xJiuxActivityBean.getActivityinfomap().values()) {
/* 51 */       if (xJiuXiaoActivityInfo.getWorldid() == worldid) {
/* 52 */         return true;
/*    */       }
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\PCLeaveJiuXiaoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */