/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.XiaoHuiKuaiPaoActivityInfo;
/*    */ import xbean.XiaoHuiKuaiPaoInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2xiaohuikuaipaoactivityinfo
/*    */ {
/*    */   public static XiaoHuiKuaiPaoActivityInfo get(Long key)
/*    */   {
/* 12 */     return (XiaoHuiKuaiPaoActivityInfo)_Tables_.getInstance().role2xiaohuikuaipaoactivityinfo.get(key);
/*    */   }
/*    */   
/*    */   public static XiaoHuiKuaiPaoActivityInfo get(Long key, XiaoHuiKuaiPaoActivityInfo value)
/*    */   {
/* 17 */     return (XiaoHuiKuaiPaoActivityInfo)_Tables_.getInstance().role2xiaohuikuaipaoactivityinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, XiaoHuiKuaiPaoActivityInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2xiaohuikuaipaoactivityinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2xiaohuikuaipaoactivityinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, XiaoHuiKuaiPaoActivityInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2xiaohuikuaipaoactivityinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2xiaohuikuaipaoactivityinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, XiaoHuiKuaiPaoActivityInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2xiaohuikuaipaoactivityinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, XiaoHuiKuaiPaoActivityInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2xiaohuikuaipaoactivityinfo;
/*    */   }
/*    */   
/*    */   public static XiaoHuiKuaiPaoActivityInfo select(Long key)
/*    */   {
/* 52 */     (XiaoHuiKuaiPaoActivityInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public XiaoHuiKuaiPaoActivityInfo get(XiaoHuiKuaiPaoActivityInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, XiaoHuiKuaiPaoInfo> selectActivityid2xiaohuikuaipaoinfo(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, XiaoHuiKuaiPaoInfo> get(XiaoHuiKuaiPaoActivityInfo v)
/*    */       {
/* 67 */         return v.getActivityid2xiaohuikuaipaoinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2xiaohuikuaipaoactivityinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */