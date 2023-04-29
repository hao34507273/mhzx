/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Properties;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class PMGM_setfightvalue
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int value;
/*    */   
/*    */   public PMGM_setfightvalue(long roleId, int value)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.value = value;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 23 */     xProperties.setLevel(this.value);
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PMGM_setfightvalue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */