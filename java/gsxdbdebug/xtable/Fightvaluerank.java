/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.FightValueRank;
/*    */ import xbean.RoleFightValueBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Fightvaluerank
/*    */ {
/*    */   public static FightValueRank get(Long key)
/*    */   {
/* 12 */     return (FightValueRank)_Tables_.getInstance().fightvaluerank.get(key);
/*    */   }
/*    */   
/*    */   public static FightValueRank get(Long key, FightValueRank value)
/*    */   {
/* 17 */     return (FightValueRank)_Tables_.getInstance().fightvaluerank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FightValueRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().fightvaluerank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().fightvaluerank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FightValueRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().fightvaluerank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().fightvaluerank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FightValueRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().fightvaluerank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FightValueRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().fightvaluerank;
/*    */   }
/*    */   
/*    */   public static FightValueRank select(Long key)
/*    */   {
/* 52 */     (FightValueRank)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public FightValueRank get(FightValueRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<RoleFightValueBean> selectRolerankdatas(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<RoleFightValueBean> get(FightValueRank v)
/*    */       {
/* 67 */         return v.getRolerankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Fightvaluerank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */