/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.JiuXiaoActivityInfo;
/*    */ 
/*    */ public class DelayTranforSession extends Session
/*    */ {
/*    */   private Collection<Long> allRoleList;
/*    */   private int activityid;
/*    */   
/*    */   public DelayTranforSession(long interval, int mapid, Collection<Long> allroleList, int activityid)
/*    */   {
/* 16 */     super(interval, mapid);
/* 17 */     this.allRoleList = allroleList;
/* 18 */     this.activityid = activityid;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 23 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 27 */         int mapid = (int)DelayTranforSession.this.getOwerId();
/* 28 */         Iterator i$; xbean.JiuXiaoActivityBean xJiuxActivityBean; Iterator i$; if (MapInterface.isWorldMap(mapid)) {
/* 29 */           for (i$ = DelayTranforSession.this.allRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 30 */             int roleMapid = MapInterface.getRoleMapId(roleid);
/* 31 */             if (roleMapid != mapid)
/* 32 */               MapInterface.transferToScene(roleid, mapid);
/*    */           }
/*    */         } else {
/* 35 */           xJiuxActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*    */           
/* 37 */           if (xJiuxActivityBean != null) {
/* 38 */             for (i$ = DelayTranforSession.this.allRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 39 */               long worldid = MapInterface.getRoleWorldInstanceId(roleid);
/* 40 */               JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xJiuxActivityBean.getActivityinfomap().get(Integer.valueOf(DelayTranforSession.this.activityid));
/*    */               
/* 42 */               if (xJiuXiaoActivityInfo == null) {
/* 43 */                 return false;
/*    */               }
/* 45 */               if (worldid == xJiuXiaoActivityInfo.getWorldid()) {
/* 46 */                 int roleMapid = MapInterface.getRoleMapId(roleid);
/* 47 */                 if (roleMapid != mapid) {
/* 48 */                   MapInterface.transferToScene(roleid, xJiuXiaoActivityInfo.getWorldid(), (int)DelayTranforSession.this.getOwerId());
/*    */                 }
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/* 54 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\DelayTranforSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */