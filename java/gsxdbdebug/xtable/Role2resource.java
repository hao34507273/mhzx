/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Reason2Resource;
/*    */ import xbean.ResourceId2Num;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2resource
/*    */ {
/*    */   public static Reason2Resource get(Long key)
/*    */   {
/* 12 */     return (Reason2Resource)_Tables_.getInstance().role2resource.get(key);
/*    */   }
/*    */   
/*    */   public static Reason2Resource get(Long key, Reason2Resource value)
/*    */   {
/* 17 */     return (Reason2Resource)_Tables_.getInstance().role2resource.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Reason2Resource value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2resource.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2resource.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Reason2Resource value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2resource.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2resource.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Reason2Resource> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2resource.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Reason2Resource> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2resource;
/*    */   }
/*    */   
/*    */   public static Reason2Resource select(Long key)
/*    */   {
/* 52 */     (Reason2Resource)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Reason2Resource get(Reason2Resource v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ResourceId2Num> selectReason2item(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ResourceId2Num> get(Reason2Resource v)
/*    */       {
/* 67 */         return v.getReason2itemAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectItemupdatetime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(Reason2Resource v)
/*    */       {
/* 78 */         return Long.valueOf(v.getItemupdatetime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2resource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */