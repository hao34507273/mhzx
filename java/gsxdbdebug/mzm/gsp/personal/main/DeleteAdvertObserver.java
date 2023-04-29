/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.personal.event.DeleteAdvert;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import xbean.AdvertObserver;
/*    */ import xbean.PersonalInfo;
/*    */ import xtable.Advertobservers;
/*    */ 
/*    */ public class DeleteAdvertObserver extends Observer
/*    */ {
/*    */   private final int advertType;
/*    */   private final long roleId;
/*    */   private final long advertId;
/*    */   
/*    */   public DeleteAdvertObserver(int advertType, long roleId, long advertId, long intervalSeconds)
/*    */   {
/* 19 */     super(intervalSeconds);
/* 20 */     this.advertType = advertType;
/* 21 */     this.roleId = roleId;
/* 22 */     this.advertId = advertId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 28 */     new PDeleteAdvert(this.advertType, this.roleId, this.advertId).execute();
/* 29 */     return false;
/*    */   }
/*    */   
/*    */   private static class PDeleteAdvert extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final int advertType;
/*    */     private final long roleId;
/*    */     private final long advertId;
/*    */     
/*    */     public PDeleteAdvert(int advertType, long roleId, long advertId)
/*    */     {
/* 40 */       this.advertType = advertType;
/* 41 */       this.roleId = roleId;
/* 42 */       this.advertId = advertId;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 49 */       PersonalInfo xPersonalInfo = xtable.Role2personal.get(Long.valueOf(this.roleId));
/* 50 */       if (xPersonalInfo == null)
/*    */       {
/* 52 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 56 */       Long advertId = (Long)xPersonalInfo.getAdverts().get(Integer.valueOf(this.advertType));
/* 57 */       if (advertId == null)
/*    */       {
/*    */ 
/* 60 */         return false;
/*    */       }
/*    */       
/* 63 */       if (advertId.longValue() != this.advertId)
/*    */       {
/*    */ 
/* 66 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 70 */       xtable.Advert.remove(advertId);
/* 71 */       xPersonalInfo.getAdverts().remove(Integer.valueOf(this.advertType));
/*    */       
/* 73 */       AdvertObserver xAdvertObserver = Advertobservers.get(advertId);
/* 74 */       if (xAdvertObserver != null)
/*    */       {
/* 76 */         if (xAdvertObserver.getObserver() != null)
/*    */         {
/* 78 */           xAdvertObserver.getObserver().stopTimer();
/*    */         }
/*    */       }
/* 81 */       Advertobservers.remove(advertId);
/*    */       
/*    */ 
/* 84 */       int advertNum = xPersonalInfo.getAdverts().size();
/* 85 */       DeleteAdvert deleteAdvertEvent = new DeleteAdvert();
/* 86 */       deleteAdvertEvent.setSequential(true);
/* 87 */       TriggerEventsManger.getInstance().triggerEvent(deleteAdvertEvent, new mzm.gsp.personal.event.DeleteAdvertArg(this.advertType, this.roleId, advertId.longValue(), advertNum), mzm.gsp.role.main.RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 92 */       SNSManager.tlogDeleteAdvert(this.roleId, this.advertId, this.advertType, 1);
/*    */       
/* 94 */       mzm.gsp.GameServer.logger().info(String.format("[personal]PDeleteAdvert.processImp@delete advert success|roleid=%d|advert_type=%d|advertid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.advertType), advertId }));
/*    */       
/*    */ 
/*    */ 
/* 98 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\DeleteAdvertObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */