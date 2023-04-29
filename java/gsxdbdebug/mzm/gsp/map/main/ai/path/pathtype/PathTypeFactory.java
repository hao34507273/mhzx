/*    */ package mzm.gsp.map.main.ai.path.pathtype;
/*    */ 
/*    */ import mzm.gsp.map.main.ai.path.IPathTypeStrategy;
/*    */ import mzm.gsp.map.main.ai.path.Path;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PathTypeFactory
/*    */ {
/*    */   public static final int PATH_TYPE_NO_MOVE = 0;
/*    */   public static final int PATH_TYPE_REPEAT = 1;
/*    */   public static final int PATH_TYPE_CIRCLE = 2;
/*    */   public static final int PATH_TYPE_ONCE = 3;
/*    */   public static final int PATH_TYPE_RANDOM = 4;
/*    */   public static final int PATH_TYPE_MONSTER_RANDOM_MOVE = 2;
/*    */   
/*    */   public static IPathTypeStrategy createByPathType(int type, Path path)
/*    */   {
/* 40 */     IPathTypeStrategy stargty = null;
/* 41 */     switch (type)
/*    */     {
/*    */     case 3: 
/* 44 */       stargty = new PathTypeOnce(path);
/* 45 */       break;
/*    */     case 1: 
/* 47 */       stargty = new PathTypeRepeat(path);
/* 48 */       break;
/*    */     case 2: 
/* 50 */       stargty = new PathTypeCircle(path);
/* 51 */       break;
/*    */     case 4: 
/* 53 */       stargty = new PathTypeRandom(path);
/* 54 */       break;
/*    */     default: 
/* 56 */       throw new RuntimeException("not support path type,check map editor for npc");
/*    */     }
/* 58 */     return stargty;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ai\path\pathtype\PathTypeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */