/*    */ package xtable;
/*    */ 
/*    */ import xbean.JailStatInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2jailstatinfo
/*    */ {
/*    */   public static JailStatInfo get(Long key)
/*    */   {
/* 12 */     return (JailStatInfo)_Tables_.getInstance().role2jailstatinfo.get(key);
/*    */   }
/*    */   
/*    */   public static JailStatInfo get(Long key, JailStatInfo value)
/*    */   {
/* 17 */     return (JailStatInfo)_Tables_.getInstance().role2jailstatinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, JailStatInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2jailstatinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2jailstatinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, JailStatInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2jailstatinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2jailstatinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, JailStatInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2jailstatinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, JailStatInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2jailstatinfo;
/*    */   }
/*    */   
/*    */   public static JailStatInfo select(Long key)
/*    */   {
/* 52 */     (JailStatInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public JailStatInfo get(JailStatInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectJailcount(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(JailStatInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getJailcount());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2jailstatinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */