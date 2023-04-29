/*    */ package mzm.gsp.interactivetask.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.interactivetask.confbean.SInteractiveTaskTypeCfg;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.map.event.PlayerTransferSceneProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2interactivetask;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTransferScene
/*    */   extends PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     SInteractiveTaskTypeCfg sNew = InteractiveTaskManager.getSInteractiveTaskTypeCfg(((MapTransferArg)this.arg).newMapCfgId);
/* 22 */     SInteractiveTaskTypeCfg sOld = InteractiveTaskManager.getSInteractiveTaskTypeCfg(((MapTransferArg)this.arg).oldMapCfgId);
/* 23 */     Iterator i$; if ((sNew == null) && (sOld != null))
/*    */     {
/* 25 */       Lockeys.lock(Role2interactivetask.getTable(), ((MapTransferArg)this.arg).roleList);
/*    */       
/* 27 */       RoleStatusInterface.unsetStatus(((MapTransferArg)this.arg).roleList, 650);
/*    */ 
/*    */     }
/* 30 */     else if ((sNew != null) && (sOld == null))
/*    */     {
/* 32 */       Lockeys.lock(Role2interactivetask.getTable(), ((MapTransferArg)this.arg).roleList);
/* 33 */       boolean ret = RoleStatusInterface.setStatus(((MapTransferArg)this.arg).roleList, 650, false);
/* 34 */       if (ret)
/*    */       {
/* 36 */         for (i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */           
/* 38 */           InteractiveTaskManager.synTaskInfo(roleid, sNew.id);
/* 39 */           TeamInterface.forceTmpLeaveTeam(roleid);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */