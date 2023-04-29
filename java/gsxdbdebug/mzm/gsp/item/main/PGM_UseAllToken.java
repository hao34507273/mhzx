/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activitypointexchange.main.PGM_ModifyDaiBi;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.pet.main.PGM_addPetPoint;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.PGM_addPoint;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Item;
/*     */ import xdb.Procedure;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGM_UseAllToken
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int itemid;
/*     */   private final int num;
/*     */   private final int TokenType;
/*     */   private final int Tokennum;
/*     */   
/*     */   public PGM_UseAllToken(long roleid, int itemid, int num, int TokenType, int Tokennum)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.itemid = itemid;
/*  36 */     this.TokenType = TokenType;
/*  37 */     this.num = num;
/*  38 */     this.Tokennum = Tokennum;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception {
/*  42 */     RoleItemBag bag = ItemManager.getBag(this.roleid, 340600000);
/*  43 */     Map<Integer, Item> items = bag.getItems();
/*  44 */     int count = 0;
/*  45 */     List<Integer> del = new ArrayList();
/*  46 */     Iterator var5 = items.entrySet().iterator();
/*     */     
/*  48 */     while (var5.hasNext()) {
/*  49 */       Map.Entry<Integer, Item> itemEntry = (Map.Entry)var5.next();
/*  50 */       Item item = (Item)itemEntry.getValue();
/*  51 */       if (item.getCfgid() == this.itemid) {
/*  52 */         int itemNumber = item.getNumber();
/*  53 */         int d = this.num - count;
/*  54 */         if (d <= 0) {
/*     */           break;
/*     */         }
/*     */         
/*  58 */         if (d >= itemNumber) {
/*  59 */           del.add(itemEntry.getKey());
/*  60 */           count += itemNumber;
/*     */         } else {
/*  62 */           Set<Long> uuidSet = item.getUuid();
/*  63 */           Long[] uuids = (Long[])(Long[])uuidSet.toArray(new Long[0]);
/*     */           
/*  65 */           for (int i = 0; i < d; i++) {
/*  66 */             uuidSet.remove(uuids[i]);
/*     */           }
/*     */           
/*  69 */           item.setNumber(itemNumber - d);
/*  70 */           count += d;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  75 */     var5 = del.iterator();
/*     */     
/*  77 */     while (var5.hasNext()) {
/*  78 */       Integer i = (Integer)var5.next();
/*  79 */       items.remove(i);
/*     */     }
/*     */     
/*  82 */     int Token = count * this.Tokennum;
/*  83 */     if (this.TokenType != 0) {
/*  84 */       if (this.TokenType == 88) {
/*  85 */         Procedure.execute(new PGM_addPetPoint(Token, this.roleid, PetInterface.getFightPetId(this.roleid), Token));
/*     */         
/*  87 */         BulletinInterface.sendNotice("玩家" + RoleInterface.getName(this.roleid) + "通过道具迅速的批量使用了宠物属性点道具获得了:" + Token + "点属性点~！");
/*     */       } else {
/*  89 */         Procedure.execute(new PGM_ModifyDaiBi(this.roleid, this.roleid, this.TokenType, Token));
/*     */       }
/*     */     }
/*     */     else {
/*  93 */       if (Token == 0)
/*     */       {
/*  95 */         return false;
/*     */       }
/*     */       
/*  98 */       Procedure.execute(new PGM_addPoint(this.roleid, Token));
/*  99 */       BulletinInterface.sendNotice("玩家" + RoleInterface.getName(this.roleid) + "通过道具迅速的批量使用了人物属性点道具获得了:" + Token + "点属性点~！");
/*     */     }
/*     */     
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_UseAllToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */