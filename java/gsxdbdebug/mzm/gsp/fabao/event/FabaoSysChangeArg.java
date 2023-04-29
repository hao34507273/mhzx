/*    */ package mzm.gsp.fabao.event;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class FabaoSysChangeArg
/*    */ {
/*    */   public final long roleid;
/* 11 */   public final Set<Integer> changedFabaoTypePos = new java.util.HashSet();
/* 12 */   public final Map<Integer, List<Integer>> changedLongjingTypeToPos = new HashMap();
/*    */   
/*    */   public FabaoSysChangeArg(long roleid, Set<Integer> changedFabaoTypePos) {
/* 15 */     this.roleid = roleid;
/* 16 */     this.changedFabaoTypePos.addAll(changedFabaoTypePos);
/*    */   }
/*    */   
/*    */   public FabaoSysChangeArg(long roleid, Map<Integer, List<Integer>> changedLongjingTypeToPos) {
/* 20 */     this.roleid = roleid;
/* 21 */     this.changedLongjingTypeToPos.putAll(changedLongjingTypeToPos);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\event\FabaoSysChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */