/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.gsp.crosscompete.main.EnterContext;
/*    */ 
/*    */ public class CrossCompeteGenRoamTokenSucceedArg extends GenRoamTokenSucceedArg
/*    */ {
/*    */   public final EnterContext context;
/*    */   
/*    */   public CrossCompeteGenRoamTokenSucceedArg(EnterContext context)
/*    */   {
/* 11 */     super(mzm.gsp.crossserver.main.RoamType.CROSS_COMPETE);
/* 12 */     this.context = context;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\CrossCompeteGenRoamTokenSucceedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */