/*    */ package mzm.gsp.fashiondress.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FashionDressModelChange extends mzm.event.BasicEvent<FashionDressModelArg>
/*    */ {
/*  7 */   private static EventManager<FashionDressModelArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FashionDressModelArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnRoleFashionDressModelChange());
/* 16 */     manager.register(new mzm.gsp.team.main.POnRoleFashionDressModelChange());
/* 17 */     manager.register(new mzm.gsp.corps.main.POnRoleFashionDressModelChange());
/* 18 */     manager.register(new mzm.gsp.shitu.main.POnRoleFashionDressModelChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\event\FashionDressModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */