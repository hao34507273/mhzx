/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Jifen;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2jifen
/*    */ {
/*    */   public static Jifen get(Long key)
/*    */   {
/* 12 */     return (Jifen)_Tables_.getInstance().role2jifen.get(key);
/*    */   }
/*    */   
/*    */   public static Jifen get(Long key, Jifen value)
/*    */   {
/* 17 */     return (Jifen)_Tables_.getInstance().role2jifen.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Jifen value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2jifen.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2jifen.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Jifen value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2jifen.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2jifen.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Jifen> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2jifen.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Jifen> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2jifen;
/*    */   }
/*    */   
/*    */   public static Jifen select(Long key)
/*    */   {
/* 52 */     (Jifen)getTable().select(key, new TField()
/*    */     {
/*    */       public Jifen get(Jifen v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Long> selectType2point(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Long> get(Jifen v)
/*    */       {
/* 67 */         return v.getType2pointAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2jifen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */