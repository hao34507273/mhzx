/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class RememberSkillManager
/*     */ {
/*     */   public static void init()
/*     */   {
/*     */     try
/*     */     {
/*  14 */       Statement stmt = Xdb.getInstance().getConf().getConnection().createStatement();
/*  15 */       String sql = " CREATE TABLE IF NOT EXISTS pet2rememberskill(id INT UNSIGNED NOT NULL AUTO_INCREMENT primary  key,\n                     petid BIGINT(11) NOT NULL, \n                     skillid int(11) NOT NULL); ";
/*     */       
/*     */ 
/*  18 */       stmt.execute(sql);
/*  19 */       stmt.close();
/*     */     }
/*     */     catch (SQLException e) {
/*  22 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static java.util.ArrayList<Integer> getRemberSkillIds(long petId) {
/*  27 */     java.util.ArrayList<Integer> skills = new java.util.ArrayList();
/*     */     try {
/*  29 */       Statement stmt = Xdb.getInstance().getConf().getConnection().createStatement();
/*  30 */       String sql = "SELECT * from pet2rememberskill where petid=" + petId;
/*  31 */       ResultSet rs = stmt.executeQuery(sql);
/*  32 */       while (rs.next()) {
/*  33 */         skills.add(Integer.valueOf(rs.getInt("skillid")));
/*     */       }
/*  35 */       stmt.close();
/*     */     }
/*     */     catch (SQLException e) {
/*  38 */       e.printStackTrace();
/*     */     }
/*  40 */     return skills;
/*     */   }
/*     */   
/*     */   public static int getRememberSkillCount(long petId) {
/*  44 */     int count = 1;
/*     */     try {
/*  46 */       Statement stmt = Xdb.getInstance().getConf().getConnection().createStatement();
/*  47 */       String sql = "SELECT count(*) from pet2rememberskill where petid=" + petId;
/*  48 */       ResultSet rs = stmt.executeQuery(sql);
/*  49 */       if (rs.next()) {
/*  50 */         count = rs.getInt(1) + 1;
/*     */       }
/*  52 */       stmt.close();
/*     */     } catch (SQLException e) {
/*  54 */       e.printStackTrace();
/*     */     }
/*  56 */     return count;
/*     */   }
/*     */   
/*     */   public static boolean isRememberSkill(long petId, int skillId) {
/*  60 */     boolean result = false;
/*     */     try {
/*  62 */       int count = 0;
/*  63 */       Statement stmt = Xdb.getInstance().getConf().getConnection().createStatement();
/*  64 */       String sql = "SELECT count(*) from pet2rememberskill where petid=" + petId + " and skillid=" + skillId;
/*  65 */       ResultSet rs = stmt.executeQuery(sql);
/*  66 */       if (rs.next()) {
/*  67 */         count = rs.getInt(1);
/*     */       }
/*  69 */       stmt.close();
/*  70 */       result = count > 0;
/*     */     } catch (SQLException e) {
/*  72 */       e.printStackTrace();
/*     */     }
/*  74 */     return result;
/*     */   }
/*     */   
/*  77 */   public static boolean remeoveSkill(long petId, int skillId) { boolean result = false;
/*     */     try {
/*  79 */       Statement stmt = Xdb.getInstance().getConf().getConnection().createStatement();
/*  80 */       String sql = "delete from pet2rememberskill where petid=" + petId + " and skillid=" + skillId;
/*  81 */       result = stmt.execute(sql);
/*  82 */       stmt.close();
/*     */     } catch (SQLException e) {
/*  84 */       e.printStackTrace();
/*     */     }
/*  86 */     return result;
/*     */   }
/*     */   
/*  89 */   public static boolean remeoveAllSkill(long petId) { boolean result = false;
/*     */     try {
/*  91 */       Statement stmt = Xdb.getInstance().getConf().getConnection().createStatement();
/*  92 */       String sql = "delete from pet2rememberskill where petid=" + petId;
/*  93 */       result = stmt.execute(sql);
/*  94 */       stmt.close();
/*     */     } catch (SQLException e) {
/*  96 */       e.printStackTrace();
/*     */     }
/*  98 */     return result;
/*     */   }
/*     */   
/* 101 */   public static boolean addRememberSkill(long petId, int skillId) { if (!isRememberSkill(petId, skillId)) {
/* 102 */       boolean result = false;
/*     */       try {
/* 104 */         Statement stmt = Xdb.getInstance().getConf().getConnection().createStatement();
/* 105 */         String sql = "insert into pet2rememberskill(petid,skillid) values(" + petId + "," + skillId + ")";
/* 106 */         result = stmt.execute(sql);
/* 107 */         stmt.close();
/*     */       } catch (SQLException e) {
/* 109 */         e.printStackTrace();
/*     */       }
/* 111 */       return result;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\RememberSkillManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */