/*    */ package mzm.gsp.fashiondress.event;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class ThemeFashionDressPropertyChangeArg
/*    */ {
/*    */   public final long roleId;
/*  9 */   public final Set<Integer> themeFashionDressTypeSet = new HashSet();
/*    */   
/*    */   public ThemeFashionDressPropertyChangeArg(long roleId, Set<Integer> themeFashionDressTypeSet)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.themeFashionDressTypeSet.addAll(themeFashionDressTypeSet);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\event\ThemeFashionDressPropertyChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */