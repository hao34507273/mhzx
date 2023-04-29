/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.WantedInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2wantedinfo
/*    */ {
/*    */   public static WantedInfo get(Long key)
/*    */   {
/* 12 */     return (WantedInfo)_Tables_.getInstance().role2wantedinfo.get(key);
/*    */   }
/*    */   
/*    */   public static WantedInfo get(Long key, WantedInfo value)
/*    */   {
/* 17 */     return (WantedInfo)_Tables_.getInstance().role2wantedinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WantedInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2wantedinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2wantedinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WantedInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2wantedinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2wantedinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, WantedInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2wantedinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WantedInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2wantedinfo;
/*    */   }
/*    */   
/*    */   public static WantedInfo select(Long key)
/*    */   {
/* 52 */     (WantedInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public WantedInfo get(WantedInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectRoleid2count(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(WantedInfo v)
/*    */       {
/* 67 */         return v.getRoleid2countAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectNpcfightcount(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(WantedInfo v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getNpcfightcount());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectStarttimestamp(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(WantedInfo v)
/*    */       {
/* 89 */         return Long.valueOf(v.getStarttimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSessionid(Long key)
/*    */   {
/* 96 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(WantedInfo v)
/*    */       {
/* :0 */         return Long.valueOf(v.getSessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2wantedinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */