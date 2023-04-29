/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.map.CGetMonsterLocationReq;
/*    */ import mzm.gsp.map.main.message.MMH_GetMonsterReq;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGetMonsterReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final CGetMonsterLocationReq req;
/*    */   
/*    */   public PGetMonsterReq(CGetMonsterLocationReq req)
/*    */   {
/* 15 */     this.roleId = Role.getRoleId(req);
/* 16 */     this.req = req;
/* 17 */     Role.addRoleProcedure(this.roleId, this);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!MapManager.canDoAction(this.roleId, 160))
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     MMH_GetMonsterReq handler = new MMH_GetMonsterReq(this.roleId, this.req.targetmapid, this.req.monstercfgid);
/* 29 */     handler.execute();
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PGetMonsterReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */