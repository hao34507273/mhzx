/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ 
/*    */ public class EquipChangeArg
/*    */ {
/*    */   public final long roleId;
/*  8 */   public final Set<Integer> changedWearPos = new java.util.HashSet();
/*    */   
/* 10 */   public EquipChangeArg(long roleId, Set<Integer> changedWearPos) { this.roleId = roleId;
/* 11 */     this.changedWearPos.addAll(changedWearPos);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\EquipChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */