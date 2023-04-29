/*    */ package mzm.gsp.award.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PTreasureHandle
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final Map<Integer, Integer> itemMap;
/*    */   private final TLogArg itemLogArg;
/*    */   
/*    */   public PTreasureHandle(long roleId, Map<Integer, Integer> itemMap, TLogArg itemLogArg)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.itemMap = itemMap;
/* 19 */     this.itemLogArg = itemLogArg;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     this.itemLogArg.logReason.gainPreciousItem(this.roleId, this.itemMap);
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\main\PTreasureHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */