/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.map.main.message.MMH_AddCloneRoleNpc;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CloneRoleNPCModel;
/*    */ 
/*    */ class PAddCloneRoleNpc
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final CloneRoleNpcModelType cloneRoleNpcModelType;
/*    */   private final long customKey;
/*    */   private final int npcCfgid;
/*    */   private final long worldid;
/*    */   
/*    */   PAddCloneRoleNpc(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, int npcCfgid, long worldid)
/*    */   {
/* 18 */     this.cloneRoleNpcModelType = cloneRoleNpcModelType;
/* 19 */     this.customKey = customKey;
/* 20 */     this.npcCfgid = npcCfgid;
/* 21 */     this.worldid = worldid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     CloneRoleNPCModel xCloneRoleNPCModel = MapManager.getXCloneRoleNPCModel(this.cloneRoleNpcModelType, this.customKey, this.npcCfgid, true);
/*    */     
/* 29 */     if (xCloneRoleNPCModel == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     Octets npcModelData = MapObjectManager.getInstance().boxNpcModel(this.npcCfgid, xCloneRoleNPCModel);
/* 35 */     new MMH_AddCloneRoleNpc(this.worldid, this.npcCfgid, npcModelData).execute();
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PAddCloneRoleNpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */