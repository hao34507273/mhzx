/*    */ package mzm.gsp.handin.event;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.handin.main.HandinContext;
/*    */ 
/*    */ public class HandinItemArg
/*    */ {
/*    */   public final HandinContext handinContext;
/*    */   public final Map<Integer, Integer> itemMap;
/*    */   public final long roleId;
/*    */   
/*    */   public HandinItemArg(HandinContext handinContext, Map<Integer, Integer> itemMap, long roleId)
/*    */   {
/* 14 */     this.handinContext = handinContext;
/* 15 */     this.itemMap = itemMap;
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\handin\event\HandinItemArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */