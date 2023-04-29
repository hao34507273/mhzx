/*    */ package mzm.gsp.foolsday.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.foolsday.SSynFoolsDayInfo;
/*    */ import mzm.gsp.foolsday.SSynOpenChestMakerids;
/*    */ import mzm.gsp.foolsday.confbean.FoolsDayConsts;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FoolsDayInfo;
/*    */ import xbean.RoleFoolsDayInfo;
/*    */ 
/*    */ public class PGM_ClearFoolsDay extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_ClearFoolsDay(long gmRoleid, long roleid)
/*    */   {
/* 21 */     this.gmRoleid = gmRoleid;
/* 22 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     RoleFoolsDayInfo xRoleFoolsDayInfo = xtable.Role_fools_day_infos.get(Long.valueOf(this.roleid));
/* 29 */     if (xRoleFoolsDayInfo == null)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("清空愚人节数据失败!", new Object[0]));
/* 32 */       return false;
/*    */     }
/* 34 */     FoolsDayInfo xFoolsDayInfo = (FoolsDayInfo)xRoleFoolsDayInfo.getFools_day_infos().get(Integer.valueOf(FoolsDayConsts.getInstance().ACTIVITY_CFG_ID));
/*    */     
/* 36 */     if (xFoolsDayInfo == null)
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("清空愚人节数据失败!", new Object[0]));
/* 39 */       return false;
/*    */     }
/* 41 */     xFoolsDayInfo.setMake_chest_num(0);
/* 42 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 43 */     xFoolsDayInfo.getOpen_chest_maker_ids().clear();
/* 44 */     xFoolsDayInfo.setOpen_chest_maker_ids_timestamp(now);
/*    */     
/* 46 */     SSynFoolsDayInfo sSynFoolsDayInfo = new SSynFoolsDayInfo();
/* 47 */     sSynFoolsDayInfo.make_chest_num = xFoolsDayInfo.getMake_chest_num();
/* 48 */     sSynFoolsDayInfo.alternative_buff_cfg_ids.addAll(xFoolsDayInfo.getAlternative_buff_cfg_ids());
/* 49 */     sSynFoolsDayInfo.refresh_time = xFoolsDayInfo.getRefresh_time();
/* 50 */     sSynFoolsDayInfo.point = xFoolsDayInfo.getPoint();
/* 51 */     sSynFoolsDayInfo.has_get_title_award = (xFoolsDayInfo.getHas_get_title_award() ? 1 : 0);
/* 52 */     OnlineManager.getInstance().send(this.roleid, sSynFoolsDayInfo);
/*    */     
/* 54 */     SSynOpenChestMakerids sSynOpenChestMakerids = new SSynOpenChestMakerids();
/* 55 */     sSynOpenChestMakerids.activity_cfg_id = FoolsDayConsts.getInstance().ACTIVITY_CFG_ID;
/* 56 */     sSynOpenChestMakerids.open_chest_maker_ids.addAll(xFoolsDayInfo.getOpen_chest_maker_ids());
/* 57 */     OnlineManager.getInstance().send(this.roleid, sSynOpenChestMakerids);
/*    */     
/* 59 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("清空愚人节数据成功！", new Object[0]));
/* 60 */     StringBuilder sb = new StringBuilder();
/* 61 */     sb.append(String.format("[foolsday]PGM_ClearFoolsDay.processImp@gm clear fools day success|roleid=%d|make_chest_num=%d|alternative_buff_cfg_ids=%s|refresh_time=%d|point=%d|has_get_title_award=%b|open_chest_maker_ids=%s", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xFoolsDayInfo.getMake_chest_num()), xFoolsDayInfo.getAlternative_buff_cfg_ids().toString(), Integer.valueOf(xFoolsDayInfo.getRefresh_time()), Integer.valueOf(xFoolsDayInfo.getPoint()), Boolean.valueOf(xFoolsDayInfo.getHas_get_title_award()), xFoolsDayInfo.getOpen_chest_maker_ids().toString() }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 66 */     FoolsDayManager.logger.info(sb.toString());
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\PGM_ClearFoolsDay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */