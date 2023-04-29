/*    */ package mzm.gsp.tlog;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SnsFlowArg
/*    */ {
/*    */   public SNSTYPE type;
/*    */   
/*    */ 
/*    */ 
/*    */   public int subtype;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SnsFlowArg() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SnsFlowArg(SNSTYPE type, int subtype)
/*    */   {
/* 24 */     this.type = type;
/* 25 */     this.subtype = subtype;
/*    */   }
/*    */   
/* 28 */   public SNSTYPE getType() { return this.type; }
/*    */   
/*    */   public void setType(SNSTYPE type)
/*    */   {
/* 32 */     this.type = type;
/*    */   }
/*    */   
/*    */   public int getSubtype() {
/* 36 */     return this.subtype;
/*    */   }
/*    */   
/*    */   public void setSubtype(int subtype) {
/* 40 */     this.subtype = subtype;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\tlog\SnsFlowArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */