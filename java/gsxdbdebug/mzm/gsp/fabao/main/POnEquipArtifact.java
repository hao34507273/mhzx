/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import mzm.gsp.fabaolingqi.event.EquipArtifactArg;
/*    */ import xbean.RoleFabaoSysInfo;
/*    */ 
/*    */ public class POnEquipArtifact extends mzm.gsp.fabaolingqi.event.EquipArtifactEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     if (((EquipArtifactArg)this.arg).isEquipping)
/*    */     {
/* 12 */       RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.getRoleFabaoSysInfo(((EquipArtifactArg)this.arg).roleId, true);
/*    */       
/* 14 */       if ((xRoleFabaoSysInfo != null) && (xRoleFabaoSysInfo.getDisfabaotype() > 0))
/*    */       {
/* 16 */         FabaoManager.onFaBaoDisplayChange(((EquipArtifactArg)this.arg).roleId, xRoleFabaoSysInfo, 0, 0);
/*    */       }
/*    */     }
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\POnEquipArtifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */