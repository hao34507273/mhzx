/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.npc.confbean.SNpc;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import xbean.WantedInfo;
/*    */ import xtable.Role2wantedinfo;
/*    */ 
/*    */ public class POnOpenChange extends mzm.gsp.open.event.OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     if (((OpenChangeComplexArg)this.arg).getType() != 412)
/*    */     {
/* 17 */       return false;
/*    */     }
/* 19 */     SNpc npc = NpcInterface.getNpc(SPKConsts.getInstance().WANTED_NPC_ID);
/* 20 */     if (npc == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 27 */       for (Long roleId : WantedPageManager.getInstance().getRemovedFromRecords())
/*    */       {
/* 29 */         WantedInfo xWantedInfo = Role2wantedinfo.select(roleId);
/* 30 */         WantedManager.startNPCFightSession(roleId.longValue(), xWantedInfo);
/*    */       }
/* 32 */       ControllerInterface.triggerController(npc.controllerId);
/*    */     }
/*    */     else
/*    */     {
/* 36 */       for (Long roleId : WantedPageManager.getInstance().getRemovedFromRecords())
/*    */       {
/* 38 */         WantedInfo xWantedInfo = Role2wantedinfo.select(roleId);
/* 39 */         WantedManager.stopNPCFightSession(roleId.longValue(), xWantedInfo);
/*    */       }
/* 41 */       ControllerInterface.collectController(npc.controllerId);
/*    */     }
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */