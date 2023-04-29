/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CallHelpData;
/*    */ import xbean.GangHelpInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Gang2hunhelp
/*    */ {
/*    */   public static GangHelpInfo get(Long key)
/*    */   {
/* 12 */     return (GangHelpInfo)_Tables_.getInstance().gang2hunhelp.get(key);
/*    */   }
/*    */   
/*    */   public static GangHelpInfo get(Long key, GangHelpInfo value)
/*    */   {
/* 17 */     return (GangHelpInfo)_Tables_.getInstance().gang2hunhelp.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GangHelpInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().gang2hunhelp.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gang2hunhelp.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GangHelpInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gang2hunhelp.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gang2hunhelp.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GangHelpInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gang2hunhelp.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GangHelpInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gang2hunhelp;
/*    */   }
/*    */   
/*    */   public static GangHelpInfo select(Long key)
/*    */   {
/* 52 */     (GangHelpInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public GangHelpInfo get(GangHelpInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, CallHelpData> selectRole2helpdata(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, CallHelpData> get(GangHelpInfo v)
/*    */       {
/* 67 */         return v.getRole2helpdataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gang2hunhelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */