/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FinishOneGuajiEventArg
/*    */ {
/*    */   private final List<Long> roleIds;
/*    */   
/*    */   public FinishOneGuajiEventArg(List<Long> roleIds)
/*    */   {
/* 18 */     this.roleIds = roleIds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Long> getFightRoleIds()
/*    */   {
/* 28 */     return new ArrayList(this.roleIds);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\FinishOneGuajiEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */