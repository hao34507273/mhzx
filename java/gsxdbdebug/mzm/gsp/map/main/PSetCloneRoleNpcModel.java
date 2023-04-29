/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class PSetCloneRoleNpcModel
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final CloneRoleNpcModelType cloneRoleNpcModelType;
/*    */   private final long customKey;
/*    */   private final long roleid;
/*    */   private final int npcCfgid;
/*    */   private final int appellationCfgid;
/*    */   
/*    */   PSetCloneRoleNpcModel(CloneRoleNpcModelType cloneRoleNpcModelType, long customKey, long roleid, int npcCfgid, int appellationCfgid)
/*    */   {
/* 16 */     this.cloneRoleNpcModelType = cloneRoleNpcModelType;
/* 17 */     this.customKey = customKey;
/* 18 */     this.roleid = roleid;
/* 19 */     this.npcCfgid = npcCfgid;
/* 20 */     this.appellationCfgid = appellationCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     MapManager.setCloneRoleNpcModel(this.cloneRoleNpcModelType, this.customKey, this.roleid, this.npcCfgid, this.appellationCfgid);
/*    */     
/*    */ 
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PSetCloneRoleNpcModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */