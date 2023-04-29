/*    */ package mzm.gsp.foolsday.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.buff.confbean.STBuffCfg;
/*    */ import mzm.gsp.foolsday.confbean.FoolsDayConsts;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.item.main.ItemOperateResult;
/*    */ import mzm.gsp.item.main.ItemStoreEnum;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Item;
/*    */ 
/*    */ 
/*    */ public class PAddChestByIdip
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int buffid;
/*    */   
/*    */   public PAddChestByIdip(long roleid, int activityCfgid, int buffid)
/*    */   {
/* 30 */     this.roleid = roleid;
/* 31 */     this.activityCfgid = activityCfgid;
/* 32 */     this.buffid = buffid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 38 */     if ((ActivityInterface.getActivityCfg(this.activityCfgid) == null) || (ActivityInterface.getActivityCfg(this.activityCfgid).activityLogicType != 78))
/*    */     {
/*    */ 
/*    */ 
/* 42 */       StringBuilder sb = new StringBuilder();
/* 43 */       sb.append(String.format("[foolsday]PAddChestByIdip.processImp@activity cfg id error|roleid=%d|activity_cfg_id=%d|buffid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.buffid) }));
/*    */       
/*    */ 
/* 46 */       FoolsDayManager.logger.info(sb.toString());
/* 47 */       return false;
/*    */     }
/* 49 */     if (STBuffCfg.get(this.buffid) == null)
/*    */     {
/*    */ 
/* 52 */       StringBuilder sb = new StringBuilder();
/* 53 */       sb.append(String.format("[foolsday]PAddChestByIdip.processImp@buff id error|roleid=%d|activity_cfg_id=%d|buffid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.buffid) }));
/*    */       
/*    */ 
/* 56 */       FoolsDayManager.logger.info(sb.toString());
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     Map<Integer, Integer> extraMap = new HashMap();
/* 61 */     extraMap.put(Integer.valueOf(ItemStoreEnum.MAKER_ID_HIGH.getStoreType()), Integer.valueOf(CommonUtils.getLongHigh(this.roleid)));
/* 62 */     extraMap.put(Integer.valueOf(ItemStoreEnum.MAKER_ID_LOW.getStoreType()), Integer.valueOf(CommonUtils.getLongLow(this.roleid)));
/* 63 */     extraMap.put(Integer.valueOf(ItemStoreEnum.BUFF_ID.getStoreType()), Integer.valueOf(this.buffid));
/* 64 */     extraMap.put(Integer.valueOf(ItemStoreEnum.ACTIVITY_CFG_ID.getStoreType()), Integer.valueOf(this.activityCfgid));
/* 65 */     List<Item> xItems = ItemInterface.createXItem(FoolsDayConsts.getInstance().CHEST_ITEM_CFG_ID, 1, extraMap, false);
/*    */     
/* 67 */     ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleid, xItems, new TLogArg(LogReason.FOOLS_DAY_ADD_ITEM_BY_IDIP, this.activityCfgid));
/*    */     
/* 69 */     if (!itemOperateResult.success())
/*    */     {
/*    */ 
/* 72 */       StringBuilder sb = new StringBuilder();
/* 73 */       sb.append(String.format("[foolsday]PAddChestByIdip.processImp@bag is full|roleid=%d|activity_cfg_id=%d|buffid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.buffid) }));
/*    */       
/* 75 */       FoolsDayManager.logger.info(sb.toString());
/* 76 */       return false;
/*    */     }
/*    */     
/* 79 */     StringBuilder sb = new StringBuilder();
/* 80 */     sb.append(String.format("[foolsday]PAddChestByIdip.processImp@add chest by idip success|roleid=%d|activity_cfg_id=%d|buffid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.buffid) }));
/*    */     
/*    */ 
/* 83 */     FoolsDayManager.logger.info(sb.toString());
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\PAddChestByIdip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */