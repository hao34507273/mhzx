/*    */ package mzm.gsp.feisheng.zhuxianjianzhen;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.feisheng.SLeaveZhuXianJianZhenActivityMapFail;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg;
/*    */ import mzm.gsp.feisheng.main.FeiShengManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FeiShengZhuXianJianZhenInfo;
/*    */ import xbean.RoleFeiShengZhuXianJianZhenInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.Role_fei_sheng_zhu_xian_jian_zhen_infos;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCLeaveZhuXianJianZhenActivityMap extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PCLeaveZhuXianJianZhenActivityMap(long roleid, int activityCfgid)
/*    */   {
/* 26 */     this.roleid = roleid;
/* 27 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(this.activityCfgid);
/* 34 */     if (cfg == null)
/*    */     {
/*    */ 
/* 37 */       onFail(-3, null);
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 43 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 45 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 47 */     if (!mzm.gsp.status.main.RoleStatusInterface.containsStatus(this.roleid, 959))
/*    */     {
/*    */ 
/* 50 */       onFail(-2, null);
/* 51 */       return false;
/*    */     }
/* 53 */     RoleFeiShengZhuXianJianZhenInfo xRoleFeiShengZhuXianJianZhenInfo = Role_fei_sheng_zhu_xian_jian_zhen_infos.get(Long.valueOf(this.roleid));
/* 54 */     if (xRoleFeiShengZhuXianJianZhenInfo == null)
/*    */     {
/*    */ 
/* 57 */       onFail(-6, null);
/* 58 */       return false;
/*    */     }
/* 60 */     FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo = (FeiShengZhuXianJianZhenInfo)xRoleFeiShengZhuXianJianZhenInfo.getFei_sheng_zhu_xian_jian_zhen_infos().get(Integer.valueOf(this.activityCfgid));
/*    */     
/* 62 */     if (xFeiShengZhuXianJianZhenInfo == null)
/*    */     {
/*    */ 
/* 65 */       onFail(-6, null);
/* 66 */       return false;
/*    */     }
/* 68 */     ZhuXianJianZhenActivityManager.onLeaveActivityMap(this.roleid, this.activityCfgid, xFeiShengZhuXianJianZhenInfo);
/* 69 */     return true;
/*    */   }
/*    */   
/*    */   private void onFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 74 */     StringBuilder sb = new StringBuilder();
/* 75 */     sb.append(String.format("[feisheng]PCLeaveZhuXianJianZhenActivityMap.processImp@leave zhu xian jian zhen activity map fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*    */     
/*    */ 
/* 78 */     if (extraInfo != null)
/*    */     {
/* 80 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */       {
/* 82 */         sb.append("|").append((String)entry.getKey());
/* 83 */         sb.append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/* 86 */     FeiShengManager.logger.info(sb.toString());
/* 87 */     if (res > 0)
/*    */     {
/* 89 */       SLeaveZhuXianJianZhenActivityMapFail protocol = new SLeaveZhuXianJianZhenActivityMapFail();
/* 90 */       protocol.res = res;
/* 91 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\PCLeaveZhuXianJianZhenActivityMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */