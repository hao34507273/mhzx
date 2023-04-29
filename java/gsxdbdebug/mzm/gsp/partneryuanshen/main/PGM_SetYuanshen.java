/*    */ package mzm.gsp.partneryuanshen.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.partneryuanshen.SSyncPartnerYuanshenInfo;
/*    */ import mzm.gsp.partneryuanshen.confbean.SPartnerYuanshenImproveBean;
/*    */ import mzm.gsp.partneryuanshen.confbean.SPartnerYuanshenImproveCfg;
/*    */ import mzm.gsp.partneryuanshen.event.PartnerYuanshenImproved;
/*    */ import mzm.gsp.partneryuanshen.event.PartnerYuanshenImprovedArg;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetYuanshen
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int position;
/*    */   private final int level;
/*    */   private final int propertyNum;
/*    */   
/*    */   public PGM_SetYuanshen(long gmRoleId, long roleId, int position, int level, int propertyNum)
/*    */   {
/* 29 */     this.gmRoleId = gmRoleId;
/* 30 */     this.roleId = roleId;
/* 31 */     this.position = position;
/* 32 */     this.level = level;
/* 33 */     this.propertyNum = propertyNum;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 40 */     if (PartnerYuanshenManager.isNotEnable())
/*    */     {
/* 42 */       return false;
/*    */     }
/* 44 */     SPartnerYuanshenImproveCfg cfg = SPartnerYuanshenImproveCfg.get(this.position);
/* 45 */     if (cfg == null)
/*    */     {
/* 47 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("无效的元神祭坛编号%d", new Object[] { Integer.valueOf(this.position) }));
/* 48 */       return false;
/*    */     }
/* 50 */     if (!cfg.level2bean.containsKey(Integer.valueOf(this.level)))
/*    */     {
/* 52 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("无效的等级%d", new Object[] { Integer.valueOf(this.level) }));
/* 53 */       return false;
/*    */     }
/* 55 */     if (this.propertyNum > ((SPartnerYuanshenImproveBean)cfg.level2bean.get(Integer.valueOf(this.level))).propertyTypes.size())
/*    */     {
/* 57 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("设置的已提升属性数量%d无效", new Object[] { Integer.valueOf(this.propertyNum) }));
/* 58 */       return false;
/*    */     }
/* 60 */     if ((this.level != 1) && (this.propertyNum == 0))
/*    */     {
/* 62 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "清除所有升级进度请设置 (level=1, propertyNum=0)");
/* 63 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 67 */     xbean.PartnerYuanshenPositionInfo xPartnerYuanshenPositionInfo = PartnerYuanshenManager.getOrCreatePartnerYuanshenPositionInfo(this.roleId, this.position);
/*    */     
/* 69 */     xPartnerYuanshenPositionInfo.setLevel(this.level);
/* 70 */     xPartnerYuanshenPositionInfo.setProperty_num(this.propertyNum);
/* 71 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("设置角色%d的仙侣元神升级进度成功", new Object[] { Long.valueOf(this.roleId) }));
/* 72 */     PartnerYuanshenImprovedArg arg = new PartnerYuanshenImprovedArg(this.roleId, this.position, xPartnerYuanshenPositionInfo.getAttached_partner_id(), xPartnerYuanshenPositionInfo.getLevel(), xPartnerYuanshenPositionInfo.getProperty_num());
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 77 */     TriggerEventsManger.getInstance().triggerEvent(new PartnerYuanshenImproved(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*    */     
/* 79 */     PartnerYuanshenLogger.info("PGM_SetYuanshen.processImp()@done|roleid=%d|position=%d|level=%d|property_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.position), Integer.valueOf(this.level), Integer.valueOf(this.propertyNum) });
/*    */     
/* 81 */     SSyncPartnerYuanshenInfo sSyncPartnerYuanshenInfo = new SSyncPartnerYuanshenInfo();
/* 82 */     Map<Integer, xbean.PartnerYuanshenPositionInfo> map = PartnerYuanshenManager.getPartnerYuanshenPositionInfoMap(this.roleId, true);
/*    */     
/* 84 */     if (map != null)
/*    */     {
/* 86 */       for (Map.Entry<Integer, xbean.PartnerYuanshenPositionInfo> entry : map.entrySet())
/*    */       {
/* 88 */         mzm.gsp.partneryuanshen.PartnerYuanshenPositionInfo info = new mzm.gsp.partneryuanshen.PartnerYuanshenPositionInfo();
/* 89 */         info.attached_partner_id = ((xbean.PartnerYuanshenPositionInfo)entry.getValue()).getAttached_partner_id();
/* 90 */         info.level = ((xbean.PartnerYuanshenPositionInfo)entry.getValue()).getLevel();
/* 91 */         info.property = ((xbean.PartnerYuanshenPositionInfo)entry.getValue()).getProperty_num();
/* 92 */         sSyncPartnerYuanshenInfo.position_info_map.put(entry.getKey(), info);
/*    */       }
/* 94 */       OnlineManager.getInstance().send(this.roleId, sSyncPartnerYuanshenInfo);
/*    */     }
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\main\PGM_SetYuanshen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */