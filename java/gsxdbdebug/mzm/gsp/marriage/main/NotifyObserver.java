/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import xbean.MarriageParade;
/*    */ import xbean.MarriageParades;
/*    */ 
/*    */ public abstract class NotifyObserver extends mzm.gsp.timer.main.Observer
/*    */ {
/*    */   protected final int paradeCfgid;
/*    */   protected final long roleid1;
/*    */   protected final long roleid2;
/*    */   protected final long timeMills;
/*    */   
/*    */   public NotifyObserver(long interval, int paradeCfgid, long roleid1, long roleid2, long timeMills)
/*    */   {
/* 15 */     super(interval);
/* 16 */     this.paradeCfgid = paradeCfgid;
/* 17 */     this.roleid1 = roleid1;
/* 18 */     this.roleid2 = roleid2;
/* 19 */     this.timeMills = timeMills;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 24 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 28 */         MarriageParades xMarriageParades = xtable.Marriageparade.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*    */         
/* 30 */         if ((xMarriageParades == null) || (xMarriageParades.getMarriageparades().size() <= 0)) {
/* 31 */           NotifyObserver.this.stopTimer();
/* 32 */           return false;
/*    */         }
/* 34 */         MarriageParade xMarriageParade = (MarriageParade)xMarriageParades.getMarriageparades().get(0);
/* 35 */         if ((xMarriageParade.getRoleid1() != NotifyObserver.this.roleid1) || (xMarriageParade.getRoleid2() != NotifyObserver.this.roleid2) || (NotifyObserver.this.paradeCfgid != xMarriageParade.getLevel()) || (NotifyObserver.this.timeMills != xMarriageParade.getTimemil()))
/*    */         {
/* 37 */           NotifyObserver.this.stopTimer();
/* 38 */           return false;
/*    */         }
/* 40 */         NotifyObserver.this.notifyMsg();
/* 41 */         return true;
/*    */       }
/* 43 */     });
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public abstract void notifyMsg();
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\NotifyObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */