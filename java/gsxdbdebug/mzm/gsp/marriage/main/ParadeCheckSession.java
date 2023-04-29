/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.MarriageParade;
/*    */ import xbean.MarriageParades;
/*    */ 
/*    */ class ParadeCheckSession extends Session
/*    */ {
/*    */   private final long roleid1;
/*    */   
/*    */   public ParadeCheckSession(long interval, long paradeMil, long roleid1)
/*    */   {
/* 14 */     super(interval, paradeMil);
/* 15 */     this.roleid1 = roleid1;
/*    */   }
/*    */   
/*    */   public long getParadeMil() {
/* 19 */     return getOwerId();
/*    */   }
/*    */   
/*    */   public long getRoleid1() {
/* 23 */     return this.roleid1;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 32 */         long roleid1 = ParadeCheckSession.this.getRoleid1();
/* 33 */         long paradeMil = ParadeCheckSession.this.getParadeMil();
/* 34 */         MarriageParades marriageParades = xtable.Marriageparade.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* 35 */         if ((marriageParades == null) || (marriageParades.getMarriageparades().size() <= 0)) {
/* 36 */           return false;
/*    */         }
/* 38 */         MarriageParade xMarriageParade = (MarriageParade)marriageParades.getMarriageparades().get(0);
/* 39 */         if (((xMarriageParade.getRoleid1() != roleid1) && (xMarriageParade.getRoleid2() != roleid1)) || (xMarriageParade.getTimemil() != paradeMil))
/*    */         {
/* 41 */           return false;
/*    */         }
/* 43 */         mzm.gsp.GameServer.logger().info(String.format("[Marriage]ParadeCheckSession.onTimeOut@marriage parade force stop|maradeParade=%s", new Object[] { xMarriageParade.toString() }));
/*    */         
/*    */ 
/*    */ 
/* 47 */         MarriageManager.stopAndDoNextTurn(marriageParades, xMarriageParade);
/* 48 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\ParadeCheckSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */