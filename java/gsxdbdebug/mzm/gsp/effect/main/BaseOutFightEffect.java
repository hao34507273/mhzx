/*    */ package mzm.gsp.effect.main;
/*    */ 
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ 
/*    */ public abstract class BaseOutFightEffect<T extends IOutFightObject> implements Effect<T>
/*    */ {
/*    */   public static final int WAN = 10000;
/*    */   private int id;
/*    */   private int type;
/*    */   
/*    */   public int getId()
/*    */   {
/* 13 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id)
/*    */   {
/* 18 */     this.id = id;
/*    */   }
/*    */   
/*    */   public int getType()
/*    */   {
/* 23 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(int type)
/*    */   {
/* 28 */     this.type = type;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getScore()
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getScore(int occupation)
/*    */   {
/* 50 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\main\BaseOutFightEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */