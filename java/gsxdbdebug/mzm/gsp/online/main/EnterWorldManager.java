/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import gnet.link.Onlines;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.map.CEnterWorld;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnterWorldManager
/*    */ {
/* 16 */   private static final EnterWorldManager instance = new EnterWorldManager();
/*    */   private Map<Long, EnterWorldWrapper> enterWorldMap;
/*    */   
/* 19 */   public static EnterWorldManager getInstance() { return instance; }
/*    */   
/*    */   private int excuteSize;
/*    */   public EnterWorldManager() {
/* 23 */     this.enterWorldMap = new OnlineRoleSizeExtendMap();
/*    */     
/* 25 */     this.excuteSize = 0;
/*    */   }
/*    */   
/*    */   public static final class EnterWorldWrapper {
/*    */     private final long roleid;
/*    */     private final CEnterWorld enterWorld;
/*    */     
/*    */     public EnterWorldWrapper(long roleid, CEnterWorld enterWorld) {
/* 33 */       this.roleid = roleid;
/* 34 */       this.enterWorld = enterWorld;
/*    */     }
/*    */     
/*    */     public long getRoleid() {
/* 38 */       return this.roleid;
/*    */     }
/*    */     
/*    */     public CEnterWorld getCEnterWorld() {
/* 42 */       return this.enterWorld;
/*    */     }
/*    */   }
/*    */   
/*    */   public void tryEnterWorld()
/*    */   {
/* 48 */     synchronized (this.enterWorldMap) {
/* 49 */       this.excuteSize = 0;
/* 50 */       Iterator<Map.Entry<Long, EnterWorldWrapper>> iterator = this.enterWorldMap.entrySet().iterator();
/* 51 */       while ((iterator.hasNext()) && 
/* 52 */         (this.excuteSize < LoginManager.getInstance().getIntervalLoginNum()))
/*    */       {
/*    */ 
/* 55 */         Map.Entry<Long, EnterWorldWrapper> entry = (Map.Entry)iterator.next();
/* 56 */         if (_tryEnterWorld((EnterWorldWrapper)entry.getValue())) {
/* 57 */           this.excuteSize += 1;
/*    */         }
/* 59 */         iterator.remove();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void add(EnterWorldWrapper enterWorldWrapper) {
/* 65 */     synchronized (this.enterWorldMap) {
/* 66 */       if (this.excuteSize >= LoginManager.getInstance().getIntervalLoginNum()) {
/* 67 */         this.enterWorldMap.put(Long.valueOf(enterWorldWrapper.getRoleid()), enterWorldWrapper);
/*    */       }
/* 69 */       else if (_tryEnterWorld(enterWorldWrapper)) {
/* 70 */         this.excuteSize += 1;
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private boolean _tryEnterWorld(EnterWorldWrapper enterWorldWrapper)
/*    */   {
/* 77 */     gnet.link.Role role = Onlines.getInstance().find(enterWorldWrapper.getCEnterWorld());
/* 78 */     if (role == null)
/*    */     {
/* 80 */       return false;
/*    */     }
/* 82 */     return mzm.gsp.Role.addRoleProcedure(role.getRoleid(), new PPlayerEnterworld(role.getRoleid()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\EnterWorldManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */