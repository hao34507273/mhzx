/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.CorpsCacheBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Corpscache
/*    */ {
/*    */   public static CorpsCacheBean get(Long key)
/*    */   {
/* 12 */     return (CorpsCacheBean)_Tables_.getInstance().corpscache.get(key);
/*    */   }
/*    */   
/*    */   public static CorpsCacheBean get(Long key, CorpsCacheBean value)
/*    */   {
/* 17 */     return (CorpsCacheBean)_Tables_.getInstance().corpscache.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CorpsCacheBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().corpscache.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().corpscache.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CorpsCacheBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().corpscache.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().corpscache.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CorpsCacheBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().corpscache.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CorpsCacheBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().corpscache;
/*    */   }
/*    */   
/*    */   public static CorpsCacheBean select(Long key)
/*    */   {
/* 52 */     (CorpsCacheBean)getTable().select(key, new TField()
/*    */     {
/*    */       public CorpsCacheBean get(CorpsCacheBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectInvitedroleinfo(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(CorpsCacheBean v)
/*    */       {
/* 67 */         return v.getInvitedroleinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Corpscache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */