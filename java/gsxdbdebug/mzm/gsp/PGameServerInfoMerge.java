/*     */ package mzm.gsp;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DisableProtocolInfo;
/*     */ import xbean.GameServerInfo;
/*     */ import xbean.ModuleFunSwitchInfo;
/*     */ import xbean.ModuleFunSwitches;
/*     */ import xtable.Gamesrv;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PGameServerInfoMerge
/*     */   extends LogicProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/* 198 */     long mainZoneid = MergeMain.getMainZoneid();
/* 199 */     long viceZoneid = MergeMain.getViceZoneid();
/* 200 */     lock(Gamesrv.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*     */     
/* 202 */     GameServerInfo xMainGameServerInfo = Gamesrv.get(Long.valueOf(mainZoneid));
/* 203 */     GameServerInfo xViceGameServerInfo = Gamesrv.get(Long.valueOf(viceZoneid));
/* 204 */     if ((xMainGameServerInfo == null) || (xViceGameServerInfo == null))
/*     */     {
/* 206 */       return false;
/*     */     }
/*     */     
/* 209 */     List<String> xMainZoneids = xMainGameServerInfo.getZoneids();
/* 210 */     List<String> xViceZoneids = xViceGameServerInfo.getZoneids();
/*     */     
/*     */ 
/* 213 */     if ((xMainZoneids.isEmpty()) || (xViceZoneids.isEmpty()))
/*     */     {
/* 215 */       MergeMain.logger().error(String.format("[gameserverinfo]PGameServerInfoMerge.processImp@main zoneids or vice zoneids is empty|main_zoneids=%s|vice_zoneids=%s", new Object[] { xMainZoneids, xViceZoneids }));
/*     */       
/*     */ 
/*     */ 
/* 219 */       return false;
/*     */     }
/* 221 */     if ((Integer.valueOf((String)xMainZoneids.get(0)).intValue() != mainZoneid) || (Integer.valueOf((String)xViceZoneids.get(0)).intValue() != viceZoneid))
/*     */     {
/* 223 */       MergeMain.logger().error(String.format("[gameserverinfo]PGameServerInfoMerge.processImp@main zoneid or vice zoneid errror|main_zoneids=%s|vice_zoneids=%s", new Object[] { xMainZoneids, xViceZoneids }));
/*     */       
/*     */ 
/*     */ 
/* 227 */       return false;
/*     */     }
/* 229 */     for (String zoneid : xViceZoneids)
/*     */     {
/* 231 */       if (xMainZoneids.contains(zoneid))
/*     */       {
/* 233 */         MergeMain.logger().error(String.format("[gameserverinfo]PGameServerInfoMerge.processImp@zoneid duplicate|main_zoneids=%s|vice_zoneids=%s", new Object[] { xMainZoneids, xViceZoneids }));
/*     */         
/*     */ 
/*     */ 
/* 237 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 242 */     xMainZoneids.addAll(xViceZoneids);
/*     */     
/*     */ 
/* 245 */     xMainGameServerInfo.setDb_version(Math.max(xMainGameServerInfo.getDb_version(), xViceGameServerInfo.getDb_version()));
/*     */     
/*     */ 
/* 248 */     if (xMainGameServerInfo.getGsxdb_jar_md5().equals(xViceGameServerInfo.getGsxdb_jar_md5()))
/*     */     {
/* 250 */       xMainGameServerInfo.getDisable_protocol_info().getProtocols().addAll(xViceGameServerInfo.getDisable_protocol_info().getProtocols());
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 255 */       xMainGameServerInfo.setGsxdb_jar_md5("");
/* 256 */       xMainGameServerInfo.getDisable_protocol_info().getProtocols().clear();
/*     */     }
/*     */     
/*     */ 
/* 260 */     xMainGameServerInfo.setCreate_role_num(xMainGameServerInfo.getCreate_role_num() + xViceGameServerInfo.getCreate_role_num());
/*     */     
/*     */ 
/*     */ 
/* 264 */     xMainGameServerInfo.setOpen_server_timestamp(Math.max(xMainGameServerInfo.getOpen_server_timestamp(), xViceGameServerInfo.getOpen_server_timestamp()));
/*     */     
/*     */ 
/*     */ 
/* 268 */     xMainGameServerInfo.setTime_offset(Math.max(xMainGameServerInfo.getTime_offset(), xViceGameServerInfo.getTime_offset()));
/*     */     
/*     */ 
/* 271 */     Map<Integer, ModuleFunSwitches> xMainModuleFunSwitchesMap = xMainGameServerInfo.getModule_fun_switches();
/* 272 */     Map<Integer, ModuleFunSwitches> xViceModuleFunSwitchesMap = xViceGameServerInfo.getModule_fun_switches();
/* 273 */     Set<Integer> modules = new HashSet(xMainModuleFunSwitchesMap.keySet());
/* 274 */     modules.addAll(xViceModuleFunSwitchesMap.keySet());
/* 275 */     for (Integer moduleid : modules)
/*     */     {
/* 277 */       ModuleFunSwitches xMainModuleFunSwitches = (ModuleFunSwitches)xMainModuleFunSwitchesMap.get(moduleid);
/* 278 */       ModuleFunSwitches xViceModuleFunSwitches = (ModuleFunSwitches)xViceModuleFunSwitchesMap.get(moduleid);
/* 279 */       if (xMainModuleFunSwitches == null)
/*     */       {
/* 281 */         xMainModuleFunSwitchesMap.put(moduleid, xViceModuleFunSwitches.toBean());
/*     */       }
/* 283 */       else if (xViceModuleFunSwitches != null)
/*     */       {
/* 285 */         xMainModuleFunSwitches.getFun_switch_init_infos().addAll(xViceModuleFunSwitches.getFun_switch_init_infos());
/*     */         
/* 287 */         xMainFunSwitchInfosMap = xMainModuleFunSwitches.getFun_switch_infos();
/* 288 */         xViceFunSwitchInfosMap = xViceModuleFunSwitches.getFun_switch_infos();
/* 289 */         Set<Integer> funids = new HashSet(xMainFunSwitchInfosMap.keySet());
/* 290 */         funids.addAll(xViceFunSwitchInfosMap.keySet());
/* 291 */         for (Integer funid : funids)
/*     */         {
/* 293 */           ModuleFunSwitchInfo xMainModuleFunSwitchInfo = (ModuleFunSwitchInfo)xMainFunSwitchInfosMap.get(funid);
/* 294 */           ModuleFunSwitchInfo xViceModuleFunSwitchInfo = (ModuleFunSwitchInfo)xViceFunSwitchInfosMap.get(funid);
/* 295 */           if (xMainModuleFunSwitchInfo == null)
/*     */           {
/* 297 */             xMainFunSwitchInfosMap.put(funid, xViceModuleFunSwitchInfo.toBean());
/*     */           }
/* 299 */           else if (xViceModuleFunSwitchInfo == null) {}
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     Map<Integer, ModuleFunSwitchInfo> xMainFunSwitchInfosMap;
/*     */     
/*     */     Map<Integer, ModuleFunSwitchInfo> xViceFunSwitchInfosMap;
/*     */     
/* 308 */     Gamesrv.remove(Long.valueOf(viceZoneid));
/*     */     
/* 310 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\PGameServerInfoMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */