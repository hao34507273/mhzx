/*    */ package mzm.gsp.luckybag.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapItemGatherContext;
/*    */ 
/*    */ public class LuckyBagGatherContext
/*    */   implements MapItemGatherContext
/*    */ {
/*    */   public final int instanceid;
/*    */   public final boolean useYuanbao;
/*    */   public final long clientYuanbao;
/*    */   public final boolean multiple;
/*    */   
/*    */   public LuckyBagGatherContext(int instanceid, boolean useYuanbao, long clientYuanbao, boolean multiple)
/*    */   {
/* 15 */     this.instanceid = instanceid;
/* 16 */     this.useYuanbao = useYuanbao;
/* 17 */     this.clientYuanbao = clientYuanbao;
/* 18 */     this.multiple = multiple;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\main\LuckyBagGatherContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */