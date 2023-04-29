/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.map.SExpressionPlayRes;
/*    */ import mzm.gsp.map.event.PlayerPlayExpressionAction;
/*    */ import mzm.gsp.map.event.PlayerPlayExpressionActionArg;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.PositionWithCfgid;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_ExpressionPlay
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final int action;
/*    */   
/*    */   public MMH_ExpressionPlay(long roleid, int action)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.action = action;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 27 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 28 */     if (role == null)
/*    */     {
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     if (!role.isCanExpressionPlay())
/*    */     {
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     role.stopMove();
/*    */     
/* 40 */     Collection<Long> roleids = role.getPlayersInMyView(false);
/* 41 */     SExpressionPlayRes res = new SExpressionPlayRes();
/* 42 */     res.roleid = this.roleid;
/* 43 */     res.actionenum = this.action;
/* 44 */     MapProtocolSendQueue.getInstance().sendMulti(roleids, res);
/*    */     
/*    */ 
/* 47 */     PositionWithCfgid pos = role.getPositionWithExtraInfo();
/* 48 */     PlayerPlayExpressionActionArg arg = new PlayerPlayExpressionActionArg(this.roleid, this.action, pos);
/* 49 */     TriggerEventsManger.getInstance().triggerEventAtOnce(new PlayerPlayExpressionAction(), arg);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_ExpressionPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */