/*    */ package mzm.gsp.wing.event;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.wing.main2.WingChangeReasonEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WingPropertyChangedArg
/*    */ {
/*    */   private final long roleid;
/*    */   private final WingChangeReasonEnum changeReasonEnum;
/*    */   
/*    */   public WingPropertyChangedArg(long roleid, Map<Integer, Integer> oldProMap, Map<Integer, Integer> newProMap)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.changeReasonEnum = WingChangeReasonEnum.NORMAL;
/*    */   }
/*    */   
/*    */   public WingPropertyChangedArg(long roleId)
/*    */   {
/* 29 */     this.roleid = roleId;
/* 30 */     this.changeReasonEnum = WingChangeReasonEnum.NORMAL;
/*    */   }
/*    */   
/*    */   public WingPropertyChangedArg(long roleId, WingChangeReasonEnum changeReasonEnum)
/*    */   {
/* 35 */     this.roleid = roleId;
/* 36 */     this.changeReasonEnum = changeReasonEnum;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleid()
/*    */   {
/* 46 */     return this.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public WingChangeReasonEnum getWingChangeReason()
/*    */   {
/* 56 */     return this.changeReasonEnum;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\event\WingPropertyChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */