/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.gsp.crosscompete.main.EnterContext;
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossCompeteGenRoamTokenFailArg
/*    */   extends GenRoamTokenFailArg
/*    */ {
/*    */   public final EnterContext context;
/*    */   
/*    */   public CrossCompeteGenRoamTokenFailArg(EnterContext context)
/*    */   {
/* 16 */     super(RoamType.CROSS_COMPETE);
/* 17 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\CrossCompeteGenRoamTokenFailArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */