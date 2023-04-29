/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.confbean.SJiuXiaoActivityInfoCfg;
/*    */ import mzm.gsp.activity.confbean.SJueZhanJiuXiaoConsts;
/*    */ import mzm.gsp.activity.event.ActivityPauseArg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.JiuXiaoActivityBean;
/*    */ import xbean.JiuXiaoActivityInfo;
/*    */ 
/*    */ public class POnActivityPause extends mzm.gsp.activity.event.ActivityPauseProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     SJiuXiaoActivityInfoCfg jiuXiaoActivityInfoCfg = SJiuXiaoActivityInfoCfg.get(((ActivityPauseArg)this.arg).activityid);
/* 19 */     if (jiuXiaoActivityInfoCfg == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     JiuXiaoActivityBean xjiuXiaoActivityBean = xtable.Jiuxiaotable.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 23 */     Iterator i$; if (xjiuXiaoActivityBean != null) {
/* 24 */       JiuXiaoActivityInfo xJiuXiaoActivityInfo = (JiuXiaoActivityInfo)xjiuXiaoActivityBean.getActivityinfomap().get(Integer.valueOf(((ActivityPauseArg)this.arg).activityid));
/*    */       
/* 26 */       if (xJiuXiaoActivityInfo == null) {
/* 27 */         return false;
/*    */       }
/* 29 */       long worldid = xJiuXiaoActivityInfo.getWorldid();
/* 30 */       List<Long> allRoleList = MapInterface.getRoleList(worldid);
/* 31 */       for (i$ = allRoleList.iterator(); i$.hasNext();) { final long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 33 */         NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */         {
/*    */           protected boolean processImp() throws Exception
/*    */           {
/* 37 */             mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleid, 19);
/* 38 */             MapInterface.transferToScene(roleid, SJueZhanJiuXiaoConsts.getInstance().outMapid);
/* 39 */             return true;
/*    */           }
/*    */         });
/*    */       }
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\POnActivityPause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */