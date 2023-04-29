/*    */ package mzm.gsp.children.fashion;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.children.confbean.SFashionCfg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ChildInfo;
/*    */ import xtable.Children;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FashionInterface
/*    */ {
/*    */   public static void onWearFashion(long roleid, long childid, int oldFashionCfgid, int newFashionCfgid)
/*    */   {
/* 20 */     ChildInfo xChildInfo = Children.get(Long.valueOf(childid));
/* 21 */     if (xChildInfo == null)
/*    */     {
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     if (xChildInfo.getHome_state() == 0)
/*    */     {
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     SFashionCfg fashionCfg = SFashionCfg.get(newFashionCfgid);
/* 32 */     if (fashionCfg == null)
/*    */     {
/* 34 */       GameServer.logger().error(String.format("[childfashion]FashionInterface.onWearFashion@fashion cfg is null|roleid=%d|childid=%d|new_fashion_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid), Integer.valueOf(newFashionCfgid) }));
/*    */       
/*    */ 
/*    */ 
/* 38 */       return;
/*    */     }
/* 40 */     if (xChildInfo.getChild_period() != fashionCfg.phase)
/*    */     {
/* 42 */       return;
/*    */     }
/*    */     
/* 45 */     Map<Integer, Integer> integerExtraInfoEntries = new HashMap();
/* 46 */     integerExtraInfoEntries.put(Integer.valueOf(705), Integer.valueOf(fashionCfg.changeFashionCfgid));
/* 47 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_CHILDREN, childid, integerExtraInfoEntries, null, null, null, null);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void onUndressFashion(long roleid, long childid, int fashionCfgid)
/*    */   {
/* 56 */     ChildInfo xChildInfo = Children.get(Long.valueOf(childid));
/* 57 */     if (xChildInfo == null)
/*    */     {
/* 59 */       return;
/*    */     }
/*    */     
/* 62 */     if (xChildInfo.getHome_state() == 0)
/*    */     {
/* 64 */       return;
/*    */     }
/*    */     
/* 67 */     SFashionCfg fashionCfg = SFashionCfg.get(fashionCfgid);
/* 68 */     if (fashionCfg == null)
/*    */     {
/* 70 */       GameServer.logger().error(String.format("[childfashion]FashionInterface.onUndressFashion@fashion cfg is null|roleid=%d|childid=%d|fashion_cfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid), Integer.valueOf(fashionCfgid) }));
/*    */       
/*    */ 
/*    */ 
/* 74 */       return;
/*    */     }
/* 76 */     if (xChildInfo.getChild_period() != fashionCfg.phase)
/*    */     {
/* 78 */       return;
/*    */     }
/*    */     
/* 81 */     Map<Integer, Integer> integerExtraInfoEntries = new HashMap();
/* 82 */     integerExtraInfoEntries.put(Integer.valueOf(705), Integer.valueOf(0));
/* 83 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_CHILDREN, childid, integerExtraInfoEntries, null, null, null, null);
/*    */   }
/*    */   
/*    */ 
/*    */   public static void onHomeWorldDestory(List<Long> roles)
/*    */   {
/* 89 */     if (roles == null)
/*    */     {
/* 91 */       return;
/*    */     }
/* 93 */     if (roles.isEmpty())
/*    */     {
/* 95 */       return;
/*    */     }
/* 97 */     FashionManager.onHomeWorldDestory(roles);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fashion\FashionInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */