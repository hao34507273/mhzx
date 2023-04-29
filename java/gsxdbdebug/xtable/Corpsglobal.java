/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.CorpsGlobal;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Corpsglobal
/*    */ {
/*    */   public static CorpsGlobal get(Long key)
/*    */   {
/* 12 */     return (CorpsGlobal)_Tables_.getInstance().corpsglobal.get(key);
/*    */   }
/*    */   
/*    */   public static CorpsGlobal get(Long key, CorpsGlobal value)
/*    */   {
/* 17 */     return (CorpsGlobal)_Tables_.getInstance().corpsglobal.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CorpsGlobal value)
/*    */   {
/* 22 */     _Tables_.getInstance().corpsglobal.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().corpsglobal.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CorpsGlobal value)
/*    */   {
/* 32 */     return _Tables_.getInstance().corpsglobal.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().corpsglobal.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CorpsGlobal> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().corpsglobal.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CorpsGlobal> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().corpsglobal;
/*    */   }
/*    */   
/*    */   public static CorpsGlobal select(Long key)
/*    */   {
/* 52 */     (CorpsGlobal)getTable().select(key, new TField()
/*    */     {
/*    */       public CorpsGlobal get(CorpsGlobal v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectAllcorpsids(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(CorpsGlobal v)
/*    */       {
/* 67 */         return v.getAllcorpsidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Corpsglobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */