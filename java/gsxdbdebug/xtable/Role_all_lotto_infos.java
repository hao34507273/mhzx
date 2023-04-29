/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleAllLottoActivityInfo;
/*    */ import xbean.RoleAllLottoInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_all_lotto_infos
/*    */ {
/*    */   public static RoleAllLottoInfo get(Long key)
/*    */   {
/* 12 */     return (RoleAllLottoInfo)_Tables_.getInstance().role_all_lotto_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleAllLottoInfo get(Long key, RoleAllLottoInfo value)
/*    */   {
/* 17 */     return (RoleAllLottoInfo)_Tables_.getInstance().role_all_lotto_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleAllLottoInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_all_lotto_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_all_lotto_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleAllLottoInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_all_lotto_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_all_lotto_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleAllLottoInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_all_lotto_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleAllLottoInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_all_lotto_infos;
/*    */   }
/*    */   
/*    */   public static RoleAllLottoInfo select(Long key)
/*    */   {
/* 52 */     (RoleAllLottoInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleAllLottoInfo get(RoleAllLottoInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleAllLottoActivityInfo> selectActivity_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleAllLottoActivityInfo> get(RoleAllLottoInfo v)
/*    */       {
/* 67 */         return v.getActivity_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_all_lotto_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */