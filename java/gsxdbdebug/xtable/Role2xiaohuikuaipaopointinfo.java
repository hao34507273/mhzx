/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.XiaoHuiKuaiPaoPointInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2xiaohuikuaipaopointinfo
/*    */ {
/*    */   public static XiaoHuiKuaiPaoPointInfo get(Long key)
/*    */   {
/* 12 */     return (XiaoHuiKuaiPaoPointInfo)_Tables_.getInstance().role2xiaohuikuaipaopointinfo.get(key);
/*    */   }
/*    */   
/*    */   public static XiaoHuiKuaiPaoPointInfo get(Long key, XiaoHuiKuaiPaoPointInfo value)
/*    */   {
/* 17 */     return (XiaoHuiKuaiPaoPointInfo)_Tables_.getInstance().role2xiaohuikuaipaopointinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, XiaoHuiKuaiPaoPointInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2xiaohuikuaipaopointinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2xiaohuikuaipaopointinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, XiaoHuiKuaiPaoPointInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2xiaohuikuaipaopointinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2xiaohuikuaipaopointinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, XiaoHuiKuaiPaoPointInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2xiaohuikuaipaopointinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, XiaoHuiKuaiPaoPointInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2xiaohuikuaipaopointinfo;
/*    */   }
/*    */   
/*    */   public static XiaoHuiKuaiPaoPointInfo select(Long key)
/*    */   {
/* 52 */     (XiaoHuiKuaiPaoPointInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public XiaoHuiKuaiPaoPointInfo get(XiaoHuiKuaiPaoPointInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectCfgid2count(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(XiaoHuiKuaiPaoPointInfo v)
/*    */       {
/* 67 */         return v.getCfgid2countAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2xiaohuikuaipaopointinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */