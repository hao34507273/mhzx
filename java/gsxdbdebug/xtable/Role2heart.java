/*    */ package xtable;
/*    */ 
/*    */ import xbean.HeartInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2heart
/*    */ {
/*    */   public static HeartInfo get(Long key)
/*    */   {
/* 12 */     return (HeartInfo)_Tables_.getInstance().role2heart.get(key);
/*    */   }
/*    */   
/*    */   public static HeartInfo get(Long key, HeartInfo value)
/*    */   {
/* 17 */     return (HeartInfo)_Tables_.getInstance().role2heart.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, HeartInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2heart.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2heart.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, HeartInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2heart.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2heart.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, HeartInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2heart.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, HeartInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2heart;
/*    */   }
/*    */   
/*    */   public static HeartInfo select(Long key)
/*    */   {
/* 52 */     (HeartInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public HeartInfo get(HeartInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectTriggertime(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(HeartInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getTriggertime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLastchecktime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(HeartInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getLastchecktime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectOtherroleid(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(HeartInfo v)
/*    */       {
/* 89 */         return Long.valueOf(v.getOtherroleid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2heart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */