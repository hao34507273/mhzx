/*    */ package xtable;
/*    */ 
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Notice
/*    */ {
/*    */   public static xbean.Notice get(Long key)
/*    */   {
/* 12 */     return (xbean.Notice)_Tables_.getInstance().notice.get(key);
/*    */   }
/*    */   
/*    */   public static xbean.Notice get(Long key, xbean.Notice value)
/*    */   {
/* 17 */     return (xbean.Notice)_Tables_.getInstance().notice.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, xbean.Notice value)
/*    */   {
/* 22 */     _Tables_.getInstance().notice.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().notice.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, xbean.Notice value)
/*    */   {
/* 32 */     return _Tables_.getInstance().notice.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().notice.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, xbean.Notice> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().notice.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, xbean.Notice> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().notice;
/*    */   }
/*    */   
/*    */   public static xbean.Notice select(Long key)
/*    */   {
/* 52 */     (xbean.Notice)getTable().select(key, new TField()
/*    */     {
/*    */       public xbean.Notice get(xbean.Notice v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static String selectTitle(Long key)
/*    */   {
/* 63 */     (String)getTable().select(key, new TField()
/*    */     {
/*    */       public String get(xbean.Notice v)
/*    */       {
/* 67 */         return v.getTitle();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static String selectContent(Long key)
/*    */   {
/* 74 */     (String)getTable().select(key, new TField()
/*    */     {
/*    */       public String get(xbean.Notice v)
/*    */       {
/* 78 */         return v.getContent();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTimestamp(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(xbean.Notice v)
/*    */       {
/* 89 */         return Long.valueOf(v.getTimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Notice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */