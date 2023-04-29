/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.ZhenfaBean;
/*    */ import xbean.ZhenfaInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2zhenfa
/*    */ {
/*    */   public static ZhenfaInfo get(Long key)
/*    */   {
/* 12 */     return (ZhenfaInfo)_Tables_.getInstance().role2zhenfa.get(key);
/*    */   }
/*    */   
/*    */   public static ZhenfaInfo get(Long key, ZhenfaInfo value)
/*    */   {
/* 17 */     return (ZhenfaInfo)_Tables_.getInstance().role2zhenfa.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ZhenfaInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2zhenfa.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2zhenfa.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ZhenfaInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2zhenfa.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2zhenfa.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ZhenfaInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2zhenfa.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ZhenfaInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2zhenfa;
/*    */   }
/*    */   
/*    */   public static ZhenfaInfo select(Long key)
/*    */   {
/* 52 */     (ZhenfaInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ZhenfaInfo get(ZhenfaInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<ZhenfaBean> selectZhenfas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<ZhenfaBean> get(ZhenfaInfo v)
/*    */       {
/* 67 */         return v.getZhenfasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2zhenfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */