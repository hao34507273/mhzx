/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossserver.main.RoamRoleInfo;
/*    */ import mzm.gsp.crossserver.main.RoamType;
/*    */ import mzm.gsp.crossserver.main.SingleCrossFieldContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SingleCrossFieldRoamRoleDataSucceedArg
/*    */   extends RoamRoleDataSucceedArg
/*    */ {
/*    */   private final SingleCrossFieldContext context;
/*    */   
/*    */   public SingleCrossFieldRoamRoleDataSucceedArg(RoamType roamType, SingleCrossFieldContext context)
/*    */   {
/* 19 */     super(roamType);
/* 20 */     this.context = context;
/*    */   }
/*    */   
/*    */   public SingleCrossFieldContext getContext()
/*    */   {
/* 25 */     return this.context;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<RoamRoleInfo> getRoamRoleInfos()
/*    */   {
/* 31 */     return this.context.getRoamRoleInfos();
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRoamZoneid()
/*    */   {
/* 37 */     return this.context.getRoamZoneid();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\SingleCrossFieldRoamRoleDataSucceedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */