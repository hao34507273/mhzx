/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.PositionWithCfgid;
/*    */ 
/*    */ public class PlayerPlayExpressionActionArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final int action;
/*    */   public final PositionWithCfgid pos;
/*    */   
/*    */   public PlayerPlayExpressionActionArg(long roleid, int action, PositionWithCfgid pos)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.action = action;
/* 15 */     this.pos = pos;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\PlayerPlayExpressionActionArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */