/*    */ package mzm.gsp.instance.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.instance.main.AwardContext;
/*    */ 
/*    */ public class BoxAwardArg
/*    */ {
/* 11 */   public final List<Long> roleids = new ArrayList();
/* 12 */   public final Map<Long, List<Integer>> roleidsToAwardItems = new HashMap();
/*    */   public final AwardContext awardContext;
/*    */   
/*    */   public BoxAwardArg(List<Long> roleids, Map<Long, List<Integer>> roleRewards, AwardContext awardContext) {
/* 16 */     this.roleids.addAll(roleids);
/* 17 */     this.roleidsToAwardItems.putAll(roleRewards);
/* 18 */     this.awardContext = awardContext;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\event\BoxAwardArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */