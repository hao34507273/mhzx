/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.BasicPropertiesSystem;
/*    */ import xbean.Properties;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_addPoint
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int point;
/*    */   
/*    */   public PGM_addPoint(long roleId, int point)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.point = point;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */   {
/* 25 */     RoleOutFightObj role = RoleInterface.getRoleOutFightObject(this.roleId);
/* 26 */     Map<Integer, BasicPropertiesSystem> propertysysmap = Role2properties.get(Long.valueOf(this.roleId)).getPropertysysmap();
/*    */     
/* 28 */     for (Integer key : propertysysmap.keySet()) {
/* 29 */       ((BasicPropertiesSystem)propertysysmap.get(key)).setIsautospecialpoint(true);
/* 30 */       ((BasicPropertiesSystem)propertysysmap.get(key)).setPotentialpoint(((BasicPropertiesSystem)propertysysmap.get(key)).getPotentialpoint() + this.point);
/* 31 */       role.autoSpecialPoint((BasicPropertiesSystem)propertysysmap.get(key));
/*    */     }
/* 33 */     role.syncClientRoleProperty();
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGM_addPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */