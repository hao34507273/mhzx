/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Camp;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Arena
/*    */ {
/*    */   public static xbean.Arena get(Long key)
/*    */   {
/* 12 */     return (xbean.Arena)_Tables_.getInstance().arena.get(key);
/*    */   }
/*    */   
/*    */   public static xbean.Arena get(Long key, xbean.Arena value)
/*    */   {
/* 17 */     return (xbean.Arena)_Tables_.getInstance().arena.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, xbean.Arena value)
/*    */   {
/* 22 */     _Tables_.getInstance().arena.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().arena.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, xbean.Arena value)
/*    */   {
/* 32 */     return _Tables_.getInstance().arena.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().arena.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, xbean.Arena> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().arena.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, xbean.Arena> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().arena;
/*    */   }
/*    */   
/*    */   public static xbean.Arena select(Long key)
/*    */   {
/* 52 */     (xbean.Arena)getTable().select(key, new TField()
/*    */     {
/*    */       public xbean.Arena get(xbean.Arena v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Camp> selectCamps(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Camp> get(xbean.Arena v)
/*    */       {
/* 67 */         return v.getCampsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectFinished(Long key)
/*    */   {
/* 74 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(xbean.Arena v)
/*    */       {
/* 78 */         return Boolean.valueOf(v.getFinished());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Arena.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */