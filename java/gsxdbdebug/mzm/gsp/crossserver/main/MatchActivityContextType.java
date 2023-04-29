/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum MatchActivityContextType
/*    */ {
/* 11 */   LADDER(0);
/*    */   
/*    */   public final int typeid;
/*    */   
/*    */   private MatchActivityContextType(int typeid)
/*    */   {
/* 17 */     this.typeid = typeid;
/*    */   }
/*    */   
/*    */   public static void check()
/*    */   {
/* 22 */     Set<Integer> typeids = new HashSet();
/* 23 */     for (MatchActivityContextType type : values())
/*    */     {
/* 25 */       if (!typeids.add(Integer.valueOf(type.typeid)))
/*    */       {
/* 27 */         throw new RuntimeException(String.format("[crossserver]match activity context type duplicate|typeid=%d|typename=%s", new Object[] { Integer.valueOf(type.typeid), type.toString() }));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\MatchActivityContextType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */