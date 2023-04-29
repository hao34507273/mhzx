/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.couple.event.CreateCoupleRideArg;
/*    */ import mzm.gsp.couple.event.CreateCoupleRideProcedure;
/*    */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.map.main.group.MapGroupType;
/*    */ 
/*    */ public class POnCreateCoupleRide extends CreateCoupleRideProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     SFeiJianCfg cfg = ItemInterface.getFeiJianCfg(((CreateCoupleRideArg)this.arg).feijianCfgId);
/* 15 */     if (cfg == null)
/*    */     {
/* 17 */       return false;
/*    */     }
/*    */     
/* 20 */     MapInterface.addMapGroup(MapGroupType.MGT_COUPLE_FLY, ((CreateCoupleRideArg)this.arg).coupleRideid, Arrays.asList(new Long[] { Long.valueOf(((CreateCoupleRideArg)this.arg).roleidA), Long.valueOf(((CreateCoupleRideArg)this.arg).roleidB) }), cfg.velocity);
/*    */     
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnCreateCoupleRide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */