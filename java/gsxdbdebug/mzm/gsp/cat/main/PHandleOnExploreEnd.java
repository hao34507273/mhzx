/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*    */ import mzm.gsp.cat.event.CatExploreEnd;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CatInfo;
/*    */ import xdb.Lockeys;
/*    */ 
/*    */ public class PHandleOnExploreEnd extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long catid;
/*    */   
/*    */   public PHandleOnExploreEnd(long roleid, long catid)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.catid = catid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     lock(Lockeys.get(xtable.Basic.getTable(), Long.valueOf(this.roleid)));
/* 28 */     lock(Lockeys.get(xtable.Catexploreobservers.getTable(), Long.valueOf(this.catid)));
/*    */     
/* 30 */     CatInfo xCatInfo = CatManager.getHomelandCat(this.roleid, true);
/* 31 */     if (xCatInfo == null)
/*    */     {
/* 33 */       GameServer.logger().error(String.format("[cat]PHandleOnExploreEnd.processImp@cat is null|roleid=%d|catid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.catid) }));
/*    */       
/* 35 */       return false;
/*    */     }
/* 37 */     if (xCatInfo.getId() != this.catid)
/*    */     {
/* 39 */       GameServer.logger().error(String.format("[cat]PHandleOnExploreEnd.processImp@logic error|roleid=%d|catid=%d|homeland_catid=%d|cat_level_cfgid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.catid), Long.valueOf(xCatInfo.getId()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()) }));
/*    */       
/*    */ 
/*    */ 
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (xCatInfo.getState() != 2)
/*    */     {
/* 48 */       GameServer.logger().error(String.format("[cat]PHandleOnExploreEnd.processImp@state not match|roleid=%d|catid=%d|state=%d|cat_level_cfgid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.catid), Integer.valueOf(xCatInfo.getState()), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 53 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 57 */     CatManager.cancelExploreObserver(this.catid);
/*    */     
/*    */ 
/* 60 */     if (!CatManager.restStateAndSendMail(this.roleid, xCatInfo))
/*    */     {
/* 62 */       GameServer.logger().error(String.format("[cat]PHandleOnExploreEnd.processImp@rest state and send mail failed|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|state=%d|mail_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.catid), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(xCatInfo.getState()), Integer.valueOf(SCatCfgConsts.getInstance().CAT_EXPLORE_END_MAIL_CFG_ID) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 67 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 71 */     CatExploreEnd catExploreEndEvent = new CatExploreEnd();
/* 72 */     TriggerEventsManger.getInstance().triggerEvent(catExploreEndEvent, new mzm.gsp.cat.event.CatExploreEndArg(this.roleid, this.catid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*    */     
/*    */ 
/* 75 */     GameServer.logger().info(String.format("[cat]PHandleOnExploreEnd.processImp@hand explore end success|roleid=%d|catid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.catid) }));
/*    */     
/*    */ 
/* 78 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PHandleOnExploreEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */