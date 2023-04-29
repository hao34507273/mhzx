/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class DeleteDoudouResult
/*    */ {
/*  9 */   private int point = 0;
/* 10 */   private Map<Integer, Integer> delete_type_2_count = new HashMap();
/* 11 */   private Map<Integer, Integer> delete_monsterid_2_count = new HashMap();
/*    */   
/*    */   public int getPoint()
/*    */   {
/* 15 */     return this.point;
/*    */   }
/*    */   
/*    */   public Map<Integer, Integer> getDelete_type_2_count()
/*    */   {
/* 20 */     return this.delete_type_2_count;
/*    */   }
/*    */   
/*    */   public void setDelete_type_2_count(Map<Integer, Integer> delete_type_2_count)
/*    */   {
/* 25 */     if (delete_type_2_count != null)
/*    */     {
/* 27 */       this.delete_type_2_count.putAll(delete_type_2_count);
/*    */     }
/*    */   }
/*    */   
/*    */   public void setPoint(int point)
/*    */   {
/* 33 */     this.point = point;
/*    */   }
/*    */   
/*    */   public Map<Integer, Integer> getDelete_monsterid_2_count()
/*    */   {
/* 38 */     return this.delete_monsterid_2_count;
/*    */   }
/*    */   
/*    */   public void setDelete_monsterid_2_count(Map<Integer, Integer> delete_monsterid_2_count)
/*    */   {
/* 43 */     this.delete_monsterid_2_count = delete_monsterid_2_count;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\DeleteDoudouResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */