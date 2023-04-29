/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ public class ChildrenMess extends Mess
/*    */ {
/*    */   public ChildrenMess(int target, int hitRate)
/*    */   {
/* 12 */     super(target, hitRate);
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 16 */     List<Class<?>> allClazz = new LinkedList();
/* 17 */     Class<?> superClass = DateTimeUtils.class;
/* 18 */     while (superClass != null) {
/* 19 */       allClazz.add(superClass);
/* 20 */       superClass = superClass.getSuperclass();
/* 21 */       if (FighterEffect.class.equals(superClass)) {
/*    */         break;
/*    */       }
/*    */     }
/*    */     
/* 26 */     for (Class<?> clazz : allClazz) {
/* 27 */       System.out.println(clazz.getName());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ChildrenMess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */