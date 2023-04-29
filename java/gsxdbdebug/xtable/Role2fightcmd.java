/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.FightCommand;
/*    */ import xbean.FightCommandInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2fightcmd
/*    */ {
/*    */   public static FightCommand get(Long key)
/*    */   {
/* 12 */     return (FightCommand)_Tables_.getInstance().role2fightcmd.get(key);
/*    */   }
/*    */   
/*    */   public static FightCommand get(Long key, FightCommand value)
/*    */   {
/* 17 */     return (FightCommand)_Tables_.getInstance().role2fightcmd.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FightCommand value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2fightcmd.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2fightcmd.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FightCommand value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2fightcmd.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2fightcmd.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FightCommand> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2fightcmd.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FightCommand> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2fightcmd;
/*    */   }
/*    */   
/*    */   public static FightCommand select(Long key)
/*    */   {
/* 52 */     (FightCommand)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public FightCommand get(FightCommand v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<FightCommandInfo> selectCommandfriendlist(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<FightCommandInfo> get(FightCommand v)
/*    */       {
/* 67 */         return v.getCommandfriendlistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<FightCommandInfo> selectCommandenermylist(Long key)
/*    */   {
/* 74 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<FightCommandInfo> get(FightCommand v)
/*    */       {
/* 78 */         return v.getCommandenermylistAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2fightcmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */