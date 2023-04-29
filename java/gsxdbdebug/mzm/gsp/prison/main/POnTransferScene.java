/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import xbean.PrisonInfo;
/*    */ 
/*    */ public class POnTransferScene extends mzm.gsp.map.event.PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*    */     Iterator i$;
/*    */     Iterator i$;
/* 15 */     if (((MapTransferArg)this.arg).newMapCfgId == SPKConsts.getInstance().PRISON_MAP_ID)
/*    */     {
/*    */ 
/* 18 */       lock(xtable.Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/*    */       
/*    */ 
/* 21 */       for (i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 23 */         MapInterface.setLimitPolygonMovementStatus(roleId, true, null);
/* 24 */         if (PrisonInterface.isRoleInJail(roleId))
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 29 */           PrisonInfo xPrisonInfo = xtable.Role2prisoninfo.get(Long.valueOf(roleId));
/* 30 */           if (xPrisonInfo != null)
/*    */           {
/*    */ 
/*    */ 
/*    */ 
/* 35 */             xPrisonInfo.setEnterjailtimestamp(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */             
/* 37 */             int buffId = mzm.gsp.role.main.RoleInterface.getGender(roleId) == 2 ? SPKConsts.getInstance().FEMALE_PRISON_BUFF_ID : SPKConsts.getInstance().MALE_PRISON_BUFF_ID;
/*    */             
/*    */ 
/* 40 */             if (!mzm.gsp.buff.main.BuffInterface.isContainBuff(roleId, buffId))
/*    */             {
/* 42 */               mzm.gsp.buff.main.BuffInterface.installBuff(roleId, buffId); }
/*    */           }
/*    */         }
/*    */       }
/* 46 */     } else if (((MapTransferArg)this.arg).oldMapCfgId == SPKConsts.getInstance().PRISON_MAP_ID)
/*    */     {
/*    */ 
/* 49 */       lock(xtable.Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/* 50 */       for (i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 52 */         MapInterface.setLimitPolygonMovementStatus(roleId, false, null);
/*    */       }
/*    */     }
/*    */     
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */