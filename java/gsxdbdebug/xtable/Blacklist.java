/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Blacklist
/*    */ {
/*    */   public static xbean.Blacklist get(Long key)
/*    */   {
/* 12 */     return (xbean.Blacklist)_Tables_.getInstance().blacklist.get(key);
/*    */   }
/*    */   
/*    */   public static xbean.Blacklist get(Long key, xbean.Blacklist value)
/*    */   {
/* 17 */     return (xbean.Blacklist)_Tables_.getInstance().blacklist.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, xbean.Blacklist value)
/*    */   {
/* 22 */     _Tables_.getInstance().blacklist.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().blacklist.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, xbean.Blacklist value)
/*    */   {
/* 32 */     return _Tables_.getInstance().blacklist.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().blacklist.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, xbean.Blacklist> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().blacklist.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, xbean.Blacklist> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().blacklist;
/*    */   }
/*    */   
/*    */   public static xbean.Blacklist select(Long key)
/*    */   {
/* 52 */     (xbean.Blacklist)getTable().select(key, new TField()
/*    */     {
/*    */       public xbean.Blacklist get(xbean.Blacklist v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<Long> selectList(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new TField()
/*    */     {
/*    */       public List<Long> get(xbean.Blacklist v)
/*    */       {
/* 67 */         return v.getListAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Blacklist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */