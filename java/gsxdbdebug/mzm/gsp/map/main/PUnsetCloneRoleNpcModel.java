/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class PUnsetCloneRoleNpcModel extends LogicProcedure
/*    */ {
/*    */   private final CloneRoleNpcModelType cloneRoleNpcModelType;
/*    */   private final long customKey;
/*    */   private final int npcCfgid;
/*    */   
/*    */   PUnsetCloneRoleNpcModel(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, int npcCfgid)
/*    */   {
/* 13 */     this.cloneRoleNpcModelType = cloneRoleNpcModelType;
/* 14 */     this.customKey = customKey;
/* 15 */     this.npcCfgid = npcCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     return MapManager.unsetCloneRoleNpcModel(this.cloneRoleNpcModelType, this.customKey, this.npcCfgid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PUnsetCloneRoleNpcModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */