/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.couple.event.DissolveCoupleRideArg;
/*    */ import mzm.gsp.couple.event.DissolveCoupleRideProcedure;
/*    */ import mzm.gsp.map.main.group.MapGroupType;
/*    */ 
/*    */ public class POnDissolveCoupleRide extends DissolveCoupleRideProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     List<Long> roleids = Arrays.asList(new Long[] { Long.valueOf(((DissolveCoupleRideArg)this.arg).roleidA), Long.valueOf(((DissolveCoupleRideArg)this.arg).roleidB) });
/*    */     
/* 15 */     MapInterface.removeMapGroup(MapGroupType.MGT_COUPLE_FLY, ((DissolveCoupleRideArg)this.arg).coupleRideid, roleids);
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnDissolveCoupleRide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */