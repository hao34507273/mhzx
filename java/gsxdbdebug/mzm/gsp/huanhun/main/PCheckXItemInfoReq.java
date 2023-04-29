/*     */ package mzm.gsp.huanhun.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*     */ import mzm.gsp.huanhun.SCheckXItemInfoRep;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HanhunInfo;
/*     */ import xbean.ItemInfo;
/*     */ import xtable.Role2huanhun;
/*     */ 
/*     */ public class PCheckXItemInfoReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long roleIdChecked;
/*     */   private final int itemindex;
/*     */   
/*     */   public PCheckXItemInfoReq(long roleId, long roleIdChecked, int itemindex)
/*     */   {
/*  23 */     this.roleId = roleId;
/*  24 */     this.roleIdChecked = roleIdChecked;
/*  25 */     this.itemindex = itemindex;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!HuanhunManager.isHunOpen(this.roleId))
/*     */     {
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     HanhunInfo xHunInfo = Role2huanhun.select(Long.valueOf(this.roleIdChecked));
/*  38 */     if (xHunInfo == null)
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(this.roleId);
/*  45 */     if (roleLevel < getCanHelpOtherLevel())
/*     */     {
/*  47 */       HuanhunManager.sendNormalResult(21, this.roleId, new String[0]);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (!isCanCheck(xHunInfo))
/*     */     {
/*  53 */       HuanhunManager.sendNormalResult(10, this.roleId, new String[0]);
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     SCheckXItemInfoRep sCheckInfo = new SCheckXItemInfoRep();
/*  58 */     sCheckInfo.iteminfos.putAll(HuanhunManager.fillItemInfosBean(xHunInfo));
/*  59 */     sCheckInfo.itemindex = this.itemindex;
/*  60 */     sCheckInfo.roleidchecked = this.roleIdChecked;
/*     */     
/*  62 */     OnlineManager.getInstance().send(this.roleId, sCheckInfo);
/*     */     
/*  64 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isCanCheck(HanhunInfo xHunInfo)
/*     */   {
/*  73 */     if (!TaskInterface.isHaveGraphId(this.roleIdChecked, HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID))
/*     */     {
/*  75 */       GameServer.logger().info(String.format("[hun]PCheckXItemInfoReq.isCanCheck@not have graph!|roleId=%d|index=%d", new Object[] { Long.valueOf(this.roleIdChecked), Integer.valueOf(this.itemindex) }));
/*     */       
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     if (xHunInfo.getStatus() == 2)
/*     */     {
/*  84 */       GameServer.logger().info(String.format("[hun]PCheckXItemInfoReq.isCanCheck@hun finished!|roleId=%d|index=%d", new Object[] { Long.valueOf(this.roleIdChecked), Integer.valueOf(this.itemindex) }));
/*     */       
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     if (((ItemInfo)xHunInfo.getIteminfos().get(Integer.valueOf(this.itemindex))).getTaskstate())
/*     */     {
/*  93 */       GameServer.logger().info(String.format("[hun]PCheckXItemInfoReq.isCanCheck@box full!|roleId=%d|index=%d", new Object[] { Long.valueOf(this.roleIdChecked), Integer.valueOf(this.itemindex) }));
/*     */       
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   private int getCanHelpOtherLevel()
/*     */   {
/* 103 */     return HuanHunMiShuConsts.getInstance().HELP_OTHER_LEVEL_LESS;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PCheckXItemInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */