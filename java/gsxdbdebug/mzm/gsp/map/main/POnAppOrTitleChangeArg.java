/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.message.MMH_OnRoleAppearanceChanged;
/*    */ import mzm.gsp.title.event.AppOrTitleChangeProcedure;
/*    */ import mzm.gsp.title.main.ActiveInfo;
/*    */ import mzm.gsp.title.main.AppOrTitleChangeArg;
/*    */ import mzm.gsp.title.main.TitleChangeReasonEnum;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ 
/*    */ public class POnAppOrTitleChangeArg
/*    */   extends AppOrTitleChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     if (((AppOrTitleChangeArg)this.arg).changeReason == TitleChangeReasonEnum.CHANGE_OCCUPATION)
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     long roleid = ((AppOrTitleChangeArg)this.arg).roleId;
/* 23 */     Map<Integer, Object> changeProps = new HashMap();
/* 24 */     if (((AppOrTitleChangeArg)this.arg).changeType == 0)
/*    */     {
/* 26 */       ActiveInfo appellation = TitleInterface.getActiveAppellationId(roleid);
/* 27 */       if ((appellation != null) && (appellation.getActiveId() > 0))
/*    */       {
/* 29 */         Integer appId = Integer.valueOf(appellation.getActiveId());
/* 30 */         String appText = appellation.getName();
/* 31 */         changeProps.put(Integer.valueOf(3), appId);
/* 32 */         changeProps.put(Integer.valueOf(4), appText);
/*    */       }
/* 34 */       new MMH_OnRoleAppearanceChanged(((AppOrTitleChangeArg)this.arg).roleId, 0, changeProps).execute();
/*    */     }
/* 36 */     else if (((AppOrTitleChangeArg)this.arg).changeType == 1)
/*    */     {
/* 38 */       ActiveInfo title = TitleInterface.getActiveTitilId(roleid);
/* 39 */       if ((title != null) && (title.getActiveId() > 0))
/*    */       {
/* 41 */         changeProps.put(Integer.valueOf(2), Integer.valueOf(title.getActiveId()));
/*    */       }
/* 43 */       new MMH_OnRoleAppearanceChanged(((AppOrTitleChangeArg)this.arg).roleId, 1, changeProps).execute();
/*    */     }
/*    */     
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnAppOrTitleChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */