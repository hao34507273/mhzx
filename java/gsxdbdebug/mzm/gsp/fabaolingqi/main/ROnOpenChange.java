/*    */ package mzm.gsp.fabaolingqi.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FabaoArtifactRecords;
/*    */ import xbean.FabaoArtifactSessionInfo;
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 20 */     if (((OpenChangeComplexArg)this.arg).getType() != 358)
/*    */       return;
/*    */     Iterator i$;
/* 23 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 25 */       int openLevel = SFabaoArtifactConsts.getInstance().OPEN_LEVEL;
/* 26 */       Set<Long> roleIds = OnlineManager.getInstance().getOnlineHigherRoleidSet(openLevel - 1);
/* 27 */       for (i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 28 */         Role.addRoleProcedure(roleId, new POnSwitchOpen(roleId));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private class POnSwitchOpen extends LogicProcedure
/*    */   {
/*    */     private long roleId;
/*    */     
/*    */     POnSwitchOpen(long roleId) {
/* 38 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 44 */       FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(this.roleId, true);
/* 45 */       if (xRecords == null) {
/* 46 */         return false;
/*    */       }
/* 48 */       FabaoArtifactManager.removeExpiredArtifacts(this.roleId, xRecords);
/* 49 */       FabaoArtifactProtocols.syncArtifactInformation(this.roleId, xRecords);
/*    */       
/* 51 */       FabaoArtifactSessionInfo xSessionInfo = FabaoArtifactManager.getOrCreateSessionInfo(this.roleId);
/* 52 */       FabaoArtifactExpireSession.startSessions(this.roleId, xRecords, xSessionInfo);
/*    */       
/* 54 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */