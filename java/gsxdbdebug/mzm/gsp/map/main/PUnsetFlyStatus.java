/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.map.event.FlyLandArg;
/*    */ import mzm.gsp.map.event.FlyLandEvent;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class PUnsetFlyStatus
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final List<Long> roleids;
/*    */   
/*    */   public PUnsetFlyStatus(List<Long> roleids)
/*    */   {
/* 18 */     this.roleids = roleids;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     lock(Role2properties.getTable(), this.roleids);
/* 25 */     RoleStatusInterface.unsetStatus(this.roleids, 2);
/*    */     
/* 27 */     FlyLandArg arg = new FlyLandArg();
/* 28 */     arg.roleList.addAll(this.roleids);
/* 29 */     TriggerEventsManger.getInstance().triggerEvent(new FlyLandEvent(), arg);
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PUnsetFlyStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */