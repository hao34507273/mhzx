/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Properties;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class PGM_SetSilver extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long value;
/*    */   
/*    */   public PGM_SetSilver(long roleId, long value)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.value = value;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 22 */     xProperties.setSilver(this.value);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGM_SetSilver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */