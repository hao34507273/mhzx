/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.ModelId2DyeId;
/*    */ import xbean.WingModel;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2wingmodel
/*    */ {
/*    */   public static WingModel get(Long key)
/*    */   {
/* 12 */     return (WingModel)_Tables_.getInstance().role2wingmodel.get(key);
/*    */   }
/*    */   
/*    */   public static WingModel get(Long key, WingModel value)
/*    */   {
/* 17 */     return (WingModel)_Tables_.getInstance().role2wingmodel.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WingModel value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2wingmodel.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2wingmodel.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WingModel value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2wingmodel.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2wingmodel.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, WingModel> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2wingmodel.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WingModel> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2wingmodel;
/*    */   }
/*    */   
/*    */   public static WingModel select(Long key)
/*    */   {
/* 52 */     (WingModel)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public WingModel get(WingModel v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<ModelId2DyeId> selectModels(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<ModelId2DyeId> get(WingModel v)
/*    */       {
/* 67 */         return v.getModelsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2wingmodel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */