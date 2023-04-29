/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ChivalryAddInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2chivalryaddinfo
/*    */ {
/*    */   public static ChivalryAddInfo get(Long key)
/*    */   {
/* 12 */     return (ChivalryAddInfo)_Tables_.getInstance().role2chivalryaddinfo.get(key);
/*    */   }
/*    */   
/*    */   public static ChivalryAddInfo get(Long key, ChivalryAddInfo value)
/*    */   {
/* 17 */     return (ChivalryAddInfo)_Tables_.getInstance().role2chivalryaddinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ChivalryAddInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2chivalryaddinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2chivalryaddinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ChivalryAddInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2chivalryaddinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2chivalryaddinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ChivalryAddInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2chivalryaddinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ChivalryAddInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2chivalryaddinfo;
/*    */   }
/*    */   
/*    */   public static ChivalryAddInfo select(Long key)
/*    */   {
/* 52 */     (ChivalryAddInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public ChivalryAddInfo get(ChivalryAddInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectGaintype2addnumonpveend(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(ChivalryAddInfo v)
/*    */       {
/* 67 */         return v.getGaintype2addnumonpveendAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2chivalryaddinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */