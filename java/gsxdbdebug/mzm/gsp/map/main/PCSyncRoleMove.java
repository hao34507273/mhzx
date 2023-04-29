/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.Location;
/*    */ import mzm.gsp.map.main.message.MMH_PlayerMove;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PCSyncRoleMove
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int mapCfgid;
/*    */   private final List<Location> keyPathList;
/*    */   
/*    */   public PCSyncRoleMove(long roleid, int mapCfgid, List<Location> keyPathList)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.mapCfgid = mapCfgid;
/* 20 */     this.keyPathList = keyPathList;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!MapManager.canDoAction(this.roleid, 167))
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     new MMH_PlayerMove(this.roleid, this.mapCfgid, this.keyPathList).execute();
/*    */     
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PCSyncRoleMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */