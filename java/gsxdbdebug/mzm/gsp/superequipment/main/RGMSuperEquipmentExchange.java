/*    */ package mzm.gsp.superequipment.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RGMSuperEquipmentExchange
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final long uuid;
/*    */   
/*    */   public RGMSuperEquipmentExchange(long gmRoleId, long roleId, long uuid)
/*    */   {
/* 21 */     this.gmRoleId = gmRoleId;
/* 22 */     this.roleId = roleId;
/* 23 */     this.uuid = uuid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 29 */     if (!OpenInterface.getOpenStatus(382)) {
/* 30 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "功能开关未开启");
/* 31 */       return;
/*    */     }
/*    */     
/* 34 */     boolean result = new PTransferSuperEquipment(this.roleId, Collections.singleton(Long.valueOf(this.uuid))).call();
/* 35 */     if (result) {
/* 36 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "交换神兵数据成功");
/*    */     } else {
/* 38 */       SuperEquipmentManager.sendCommonTip(this.gmRoleId, "交换神兵数据失败");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\main\RGMSuperEquipmentExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */