/*     */ package mzm.gsp.indiana.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.indiana.confbean.SIndianaAwardInfo;
/*     */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*     */ import mzm.gsp.indiana.confbean.SIndianaTurnInfo;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IndianaAwardInfo;
/*     */ import xbean.IndianaAwardRoleInfo;
/*     */ import xbean.IndianaInfo;
/*     */ import xbean.IndianaTurnInfo;
/*     */ import xdb.Table;
/*     */ import xtable.Indiana_infos;
/*     */ 
/*     */ public class IndianaMergeModule implements MergeModule
/*     */ {
/*     */   public java.util.List<Table> getHandleTables()
/*     */   {
/*  27 */     return java.util.Arrays.asList(new Table[] { Indiana_infos.getTable(), xtable.Indiana_number_infos.getTable(), xtable.Role_indiana_infos.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  34 */     for (Iterator i$ = SIndianaCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  36 */       if (!new PMerge(activityCfgid).call())
/*     */       {
/*  38 */         return false;
/*     */       }
/*     */     }
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   class PMerge extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final int activityCfgid;
/*     */     
/*     */     public PMerge(int activityCfgid)
/*     */     {
/*  50 */       this.activityCfgid = activityCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  56 */       SIndianaCfg cfg = SIndianaCfg.get(this.activityCfgid);
/*  57 */       if (cfg == null)
/*     */       {
/*  59 */         MergeMain.logger().error(String.format("[indiana]IndianaMergeModule.PMerge.processImp@param error|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*  62 */         return false;
/*     */       }
/*     */       
/*  65 */       long mainZoneid = MergeMain.getMainZoneid();
/*  66 */       long viceZoneid = MergeMain.getViceZoneid();
/*  67 */       long mainKey = GameServerInfoManager.toGlobalId(this.activityCfgid, mainZoneid);
/*  68 */       long viceKey = GameServerInfoManager.toGlobalId(this.activityCfgid, viceZoneid);
/*     */       
/*  70 */       HashSet<Long> keys = new HashSet();
/*  71 */       keys.add(Long.valueOf(mainKey));
/*  72 */       keys.add(Long.valueOf(viceKey));
/*  73 */       lock(Indiana_infos.getTable(), keys);
/*     */       
/*  75 */       IndianaInfo xMainIndianaInfo = Indiana_infos.get(Long.valueOf(mainKey));
/*  76 */       IndianaInfo xViceIndianaInfo = Indiana_infos.get(Long.valueOf(viceKey));
/*     */       
/*     */ 
/*  79 */       if ((xMainIndianaInfo == null) && (xViceIndianaInfo == null))
/*     */       {
/*  81 */         MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@main server and vice server have no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*     */ 
/*  85 */         return true;
/*     */       }
/*     */       
/*  88 */       if ((xMainIndianaInfo != null) && (xViceIndianaInfo == null))
/*     */       {
/*  90 */         MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@vice server has no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*     */ 
/*  94 */         return true;
/*     */       }
/*     */       
/*  97 */       if ((xMainIndianaInfo == null) && (xViceIndianaInfo != null))
/*     */       {
/*  99 */         Indiana_infos.insert(Long.valueOf(mainKey), xViceIndianaInfo.copy());
/* 100 */         Indiana_infos.remove(Long.valueOf(viceKey));
/* 101 */         MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@main server has no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*     */ 
/* 105 */         return true;
/*     */       }
/*     */       
/* 108 */       Indiana_infos.remove(Long.valueOf(viceKey));
/* 109 */       for (int turn = 1; turn <= cfg.turn_infos.size(); turn++)
/*     */       {
/* 111 */         SIndianaTurnInfo turnInfo = (SIndianaTurnInfo)cfg.turn_infos.get(Integer.valueOf(turn));
/* 112 */         if (turnInfo == null)
/*     */         {
/* 114 */           MergeMain.logger().error(String.format("[indiana]IndianaMergeModule.PMerge.processImp@param error|activity_cfg_id=%d|turn=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn) }));
/*     */           
/*     */ 
/*     */ 
/* 118 */           return false;
/*     */         }
/*     */         
/* 121 */         IndianaTurnInfo xMainIndianaTurnInfo = (IndianaTurnInfo)xMainIndianaInfo.getTurn_infos().get(Integer.valueOf(turn));
/* 122 */         IndianaTurnInfo xViceIndianaTurnInfo = (IndianaTurnInfo)xViceIndianaInfo.getTurn_infos().get(Integer.valueOf(turn));
/*     */         
/*     */ 
/* 125 */         if ((xMainIndianaTurnInfo == null) && (xViceIndianaTurnInfo == null))
/*     */         {
/* 127 */           MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@main server and vice server have no turn data|activity_cfg_id=%d|turn=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 134 */         else if ((xMainIndianaTurnInfo != null) && (xViceIndianaTurnInfo == null))
/*     */         {
/* 136 */           MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@vice server has no turn data|activity_cfg_id=%d|turn=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 143 */         else if ((xMainIndianaTurnInfo == null) && (xViceIndianaTurnInfo != null))
/*     */         {
/* 145 */           xMainIndianaInfo.getTurn_infos().put(Integer.valueOf(turn), xViceIndianaTurnInfo.copy());
/* 146 */           MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@main server has no turn data|activity_cfg_id=%d|turn=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 153 */           for (int sortid = 1; sortid <= turnInfo.award_infos.size(); sortid++)
/*     */           {
/* 155 */             SIndianaAwardInfo awardInfo = (SIndianaAwardInfo)turnInfo.award_infos.get(Integer.valueOf(sortid));
/* 156 */             if (awardInfo == null)
/*     */             {
/* 158 */               MergeMain.logger().error(String.format("[indiana]IndianaMergeModule.PMerge.processImp@param error|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid) }));
/*     */               
/*     */ 
/*     */ 
/* 162 */               return false;
/*     */             }
/* 164 */             IndianaAwardInfo xMainIndianaAwardInfo = (IndianaAwardInfo)xMainIndianaTurnInfo.getAward_infos().get(Integer.valueOf(sortid));
/* 165 */             IndianaAwardInfo xViceIndianaAwardInfo = (IndianaAwardInfo)xViceIndianaTurnInfo.getAward_infos().get(Integer.valueOf(sortid));
/*     */             
/*     */ 
/* 168 */             if ((xMainIndianaAwardInfo == null) && (xViceIndianaAwardInfo == null))
/*     */             {
/* 170 */               MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@main server and vice server have no award data|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/* 177 */             else if ((xMainIndianaAwardInfo != null) && (xViceIndianaAwardInfo == null))
/*     */             {
/* 179 */               MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@vice server has no award data|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             }
/* 186 */             else if ((xMainIndianaAwardInfo == null) && (xViceIndianaAwardInfo != null))
/*     */             {
/* 188 */               xMainIndianaTurnInfo.getAward_infos().put(Integer.valueOf(sortid), xViceIndianaAwardInfo.copy());
/* 189 */               MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@vice server has no award data|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid) }));
/*     */ 
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/* 196 */               if (xViceIndianaAwardInfo.getAttend_role_num_timestamp() > xMainIndianaAwardInfo.getAttend_role_num_timestamp())
/*     */               {
/* 198 */                 xMainIndianaAwardInfo.setAttend_role_num(xViceIndianaAwardInfo.getAttend_role_num());
/* 199 */                 xMainIndianaAwardInfo.setAttend_role_num_timestamp(xViceIndianaAwardInfo.getAttend_role_num_timestamp());
/*     */               }
/* 201 */               if (xViceIndianaAwardInfo.getGot_award_number())
/*     */               {
/* 203 */                 xMainIndianaAwardInfo.setGot_award_number(true);
/*     */               }
/* 205 */               for (Map.Entry<Integer, IndianaAwardRoleInfo> entry : xMainIndianaAwardInfo.getAward_number_infos().entrySet())
/*     */               {
/* 207 */                 int number = ((Integer)entry.getKey()).intValue();
/* 208 */                 IndianaAwardRoleInfo xMainIndianaAwardRoleInfo = (IndianaAwardRoleInfo)entry.getValue();
/* 209 */                 IndianaAwardRoleInfo xViceIndianaAwardRoleInfo = (IndianaAwardRoleInfo)xViceIndianaAwardInfo.getAward_number_infos().remove(Integer.valueOf(number));
/*     */                 
/* 211 */                 if (xViceIndianaAwardRoleInfo == null)
/*     */                 {
/* 213 */                   MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@vice server has no award role info data|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d|roleid=%d|award_state=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid), Integer.valueOf(number), Long.valueOf(xMainIndianaAwardRoleInfo.getRoleid()), Integer.valueOf(xMainIndianaAwardRoleInfo.getAward_state()) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 }
/* 220 */                 else if (((xMainIndianaAwardRoleInfo.getAward_state() == 0) || (xMainIndianaAwardRoleInfo.getAward_state() == 1)) && ((xViceIndianaAwardRoleInfo.getAward_state() == 0) || (xViceIndianaAwardRoleInfo.getAward_state() == 1)))
/*     */                 {
/*     */ 
/* 223 */                   if (xViceIndianaAwardRoleInfo.getAward_state() == 1)
/*     */                   {
/* 225 */                     xMainIndianaAwardRoleInfo.setAward_state(xViceIndianaAwardRoleInfo.getAward_state());
/* 226 */                     xMainIndianaAwardRoleInfo.setRoleid(xViceIndianaAwardRoleInfo.getRoleid());
/* 227 */                     xMainIndianaAwardRoleInfo.setRole_name(xViceIndianaAwardRoleInfo.getRole_name());
/*     */                   }
/* 229 */                   MergeMain.logger().error(String.format("[indiana]IndianaMergeModule.PMerge.processImp@award role info data error|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d|main_award_state=%d|vice_award_state=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid), Integer.valueOf(number), Integer.valueOf(xMainIndianaAwardRoleInfo.getAward_state()), Integer.valueOf(xViceIndianaAwardRoleInfo.getAward_state()) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 }
/* 237 */                 else if (((xMainIndianaAwardRoleInfo.getAward_state() == 0) || (xMainIndianaAwardRoleInfo.getAward_state() == 1)) && (xViceIndianaAwardRoleInfo.getAward_state() == 2))
/*     */                 {
/*     */ 
/* 240 */                   MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@award role is in main server|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid), Integer.valueOf(number) }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 }
/* 246 */                 else if (((xViceIndianaAwardRoleInfo.getAward_state() == 0) || (xViceIndianaAwardRoleInfo.getAward_state() == 1)) && (xMainIndianaAwardRoleInfo.getAward_state() == 2))
/*     */                 {
/*     */ 
/* 249 */                   xMainIndianaAwardRoleInfo.setAward_state(xViceIndianaAwardRoleInfo.getAward_state());
/* 250 */                   xMainIndianaAwardRoleInfo.setRoleid(xViceIndianaAwardRoleInfo.getRoleid());
/* 251 */                   xMainIndianaAwardRoleInfo.setRole_name(xViceIndianaAwardRoleInfo.getRole_name());
/*     */                   
/* 253 */                   MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@award role is in vice server|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid), Integer.valueOf(number) }));
/*     */ 
/*     */                 }
/*     */                 else
/*     */                 {
/*     */ 
/* 259 */                   if ((xMainIndianaAwardRoleInfo.getRoleid() <= 0L) && (xViceIndianaAwardRoleInfo.getRoleid() > 0L))
/*     */                   {
/* 261 */                     xMainIndianaAwardRoleInfo.setRoleid(xViceIndianaAwardRoleInfo.getRoleid());
/*     */                   }
/* 263 */                   if (((xMainIndianaAwardRoleInfo.getRole_name() == null) || (xMainIndianaAwardRoleInfo.getRole_name().isEmpty())) && (xViceIndianaAwardRoleInfo.getRole_name() != null) && (!xViceIndianaAwardRoleInfo.getRole_name().isEmpty()))
/*     */                   {
/*     */ 
/* 266 */                     xMainIndianaAwardRoleInfo.setRole_name(xViceIndianaAwardRoleInfo.getRole_name());
/*     */                   }
/* 268 */                   MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@award role is in other server|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid), Integer.valueOf(number) }));
/*     */                 }
/*     */               }
/*     */               
/*     */ 
/* 273 */               for (Map.Entry<Integer, IndianaAwardRoleInfo> entry : xViceIndianaAwardInfo.getAward_number_infos().entrySet())
/*     */               {
/* 275 */                 int number = ((Integer)entry.getKey()).intValue();
/* 276 */                 IndianaAwardRoleInfo xViceIndianaAwardRoleInfo = (IndianaAwardRoleInfo)entry.getValue();
/* 277 */                 xMainIndianaAwardInfo.getAward_number_infos().put(Integer.valueOf(number), xViceIndianaAwardRoleInfo.copy());
/* 278 */                 MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@main server has no award role info data|activity_cfg_id=%d|turn=%d|sortid=%d|number=%d|roleid=%d|award_state=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid), Integer.valueOf(number), Long.valueOf(xViceIndianaAwardRoleInfo.getRoleid()), Integer.valueOf(xViceIndianaAwardRoleInfo.getAward_state()) }));
/*     */               }
/*     */               
/*     */ 
/*     */ 
/*     */ 
/* 284 */               MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@main server and vice server have award data|activity_cfg_id=%d|turn=%d|sortid=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid) }));
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 289 */           MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@main server and vice server have turn data|activity_cfg_id=%d|turn=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(turn) }));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 294 */       MergeMain.logger().info(String.format("[indiana]IndianaMergeModule.PMerge.processImp@main server and vice server have data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 298 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\IndianaMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */