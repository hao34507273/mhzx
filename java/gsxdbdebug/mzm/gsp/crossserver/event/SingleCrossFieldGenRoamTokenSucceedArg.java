/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleCrossFieldGenRoamTokenSucceedArg
/*    */   extends GenRoamTokenSucceedArg
/*    */ {
/*    */   private final SingleCrossFieldContext context;
/*    */   
/*    */   public SingleCrossFieldGenRoamTokenSucceedArg(RoamType roamType, SingleCrossFieldContext context)
/*    */   {
/* 16 */     super(roamType);
/* 17 */     this.context = context;
/*    */   }
/*    */   
/*    */   public SingleCrossFieldContext getContext()
/*    */   {
/* 22 */     return this.context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SingleCrossFieldGenRoamTokenSucceedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */