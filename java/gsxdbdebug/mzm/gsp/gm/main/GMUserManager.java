/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Gm;
/*    */ 
/*    */ public class GMUserManager
/*    */ {
/* 14 */   private static GMUserManager instance = new GMUserManager();
/*    */   
/*    */   static GMUserManager getInstance() {
/* 17 */     return instance;
/*    */   }
/*    */   
/* 20 */   private final List<String> gmUserIDs = new ArrayList();
/*    */   
/*    */   void init(String path) {
/* 23 */     loadGMUserFile(path);
/* 24 */     addGMUser();
/*    */   }
/*    */   
/*    */   private void loadGMUserFile(String path) {
/*    */     try {
/* 29 */       BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
/*    */       
/*    */       String gmUserID;
/* 32 */       while ((gmUserID = reader.readLine()) != null) {
/* 33 */         gmUserID = gmUserID.trim();
/* 34 */         this.gmUserIDs.add(gmUserID);
/* 35 */         GameServer.logger().info("添加gm账号id：" + gmUserID);
/*    */       }
/* 37 */       reader.close();
/*    */     }
/*    */     catch (Exception e) {
/* 40 */       throw new RuntimeException("加载gm账号文件失败！", e);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private void addGMUser()
/*    */   {
/* 47 */     new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 51 */         lock(Gm.getTable(), GMUserManager.this.gmUserIDs);
/*    */         
/* 53 */         for (String userid : GMUserManager.this.gmUserIDs) {
/* 54 */           if (Gm.get(userid) == null)
/*    */           {
/*    */ 
/* 57 */             xbean.GMInfo xGMInfo = xbean.Pod.newGMInfo();
/* 58 */             Gm.insert(userid, xGMInfo);
/*    */           }
/*    */         }
/* 61 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\GMUserManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */