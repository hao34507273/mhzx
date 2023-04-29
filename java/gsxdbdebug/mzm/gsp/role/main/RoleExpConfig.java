/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ class RoleExpConfig
/*    */ {
/*  9 */   private Map<Integer, Integer> expMap = new HashMap();
/*    */   
/*    */   public void addMap(Integer level, Integer exp)
/*    */   {
/* 13 */     this.expMap.put(level, exp);
/*    */   }
/*    */   
/*    */   public int getExpByLevel(int level)
/*    */   {
/* 18 */     Integer exp = (Integer)this.expMap.get(Integer.valueOf(level));
/* 19 */     return exp == null ? 0 : exp.intValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleExpConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */