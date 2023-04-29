/*     */ package mzm.gsp.petmark.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SPetMarkConstants
/*     */ {
/*  13 */   private static volatile SPetMarkConstants oldInstance = null;
/*     */   
/*  15 */   private static SPetMarkConstants instance = new SPetMarkConstants();
/*     */   
/*     */   public int OPEN_LEVEL;
/*     */   public int DIFFRENT_MARK_EXP_REDUSE_RATIO;
/*     */   public int PET_MARK_MAX_LEVEL;
/*     */   
/*     */   public static SPetMarkConstants getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SPetMarkConstants getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int PET_MARK_MAX_CARRY_NUM;
/*     */   
/*     */   public int INIT_PET_MARK_SCORE1;
/*     */   
/*     */   public int LOTTERY_ANIMATION_DURATION1;
/*     */   
/*     */   public int LOTTERY_COST1;
/*     */   public int TEN_LOTTERY_COST1;
/*     */   public int LOTTERY_AWARD_POOL_TYPE_ID1;
/*     */   public int INIT_PET_MARK_SCORE2;
/*     */   public int LOTTERY_ANIMATION_DURATION2;
/*     */   public int LOTTERY_COST2;
/*     */   public int TEN_LOTTERY_COST2;
/*     */   public int LOTTERY_AWARD_POOL_TYPE_ID2;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  48 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  53 */     String path = dir + "mzm.gsp.petmark.confbean.SPetMarkConstants.xml";
/*     */     try
/*     */     {
/*  56 */       SAXReader reader = new SAXReader();
/*  57 */       org.dom4j.Document doc = reader.read(new File(path));
/*  58 */       Element root = doc.getRootElement();
/*  59 */       Map<String, Element> data = new java.util.HashMap();
/*  60 */       java.util.List<?> nodeList = root.elements();
/*  61 */       int len = nodeList.size();
/*  62 */       for (int i = 0; i < len; i++)
/*     */       {
/*  64 */         Element element = (Element)nodeList.get(i);
/*  65 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  68 */           String name = element.attributeValue("name");
/*  69 */           if (data.put(name, element) != null)
/*  70 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  73 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/*  74 */       this.DIFFRENT_MARK_EXP_REDUSE_RATIO = Integer.valueOf(((Element)data.get("DIFFRENT_MARK_EXP_REDUSE_RATIO")).attributeValue("value")).intValue();
/*  75 */       this.PET_MARK_MAX_LEVEL = Integer.valueOf(((Element)data.get("PET_MARK_MAX_LEVEL")).attributeValue("value")).intValue();
/*  76 */       this.PET_MARK_MAX_CARRY_NUM = Integer.valueOf(((Element)data.get("PET_MARK_MAX_CARRY_NUM")).attributeValue("value")).intValue();
/*  77 */       this.INIT_PET_MARK_SCORE1 = Integer.valueOf(((Element)data.get("INIT_PET_MARK_SCORE1")).attributeValue("value")).intValue();
/*  78 */       this.LOTTERY_ANIMATION_DURATION1 = Integer.valueOf(((Element)data.get("LOTTERY_ANIMATION_DURATION1")).attributeValue("value")).intValue();
/*  79 */       this.LOTTERY_COST1 = Integer.valueOf(((Element)data.get("LOTTERY_COST1")).attributeValue("value")).intValue();
/*  80 */       this.TEN_LOTTERY_COST1 = Integer.valueOf(((Element)data.get("TEN_LOTTERY_COST1")).attributeValue("value")).intValue();
/*  81 */       this.LOTTERY_AWARD_POOL_TYPE_ID1 = Integer.valueOf(((Element)data.get("LOTTERY_AWARD_POOL_TYPE_ID1")).attributeValue("value")).intValue();
/*  82 */       this.INIT_PET_MARK_SCORE2 = Integer.valueOf(((Element)data.get("INIT_PET_MARK_SCORE2")).attributeValue("value")).intValue();
/*  83 */       this.LOTTERY_ANIMATION_DURATION2 = Integer.valueOf(((Element)data.get("LOTTERY_ANIMATION_DURATION2")).attributeValue("value")).intValue();
/*  84 */       this.LOTTERY_COST2 = Integer.valueOf(((Element)data.get("LOTTERY_COST2")).attributeValue("value")).intValue();
/*  85 */       this.TEN_LOTTERY_COST2 = Integer.valueOf(((Element)data.get("TEN_LOTTERY_COST2")).attributeValue("value")).intValue();
/*  86 */       this.LOTTERY_AWARD_POOL_TYPE_ID2 = Integer.valueOf(((Element)data.get("LOTTERY_AWARD_POOL_TYPE_ID2")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  90 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  95 */     String path = dir + "mzm.gsp.petmark.confbean.SPetMarkConstants.xml";
/*     */     try
/*     */     {
/*  98 */       SAXReader reader = new SAXReader();
/*  99 */       org.dom4j.Document doc = reader.read(new File(path));
/* 100 */       Element root = doc.getRootElement();
/* 101 */       Map<String, Element> data = new java.util.HashMap();
/* 102 */       java.util.List<?> nodeList = root.elements();
/* 103 */       int len = nodeList.size();
/* 104 */       for (int i = 0; i < len; i++)
/*     */       {
/* 106 */         Element element = (Element)nodeList.get(i);
/* 107 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 110 */           String name = element.attributeValue("name");
/* 111 */           if (data.put(name, element) != null)
/* 112 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 115 */       this.OPEN_LEVEL = Integer.valueOf(((Element)data.get("OPEN_LEVEL")).attributeValue("value")).intValue();
/* 116 */       this.DIFFRENT_MARK_EXP_REDUSE_RATIO = Integer.valueOf(((Element)data.get("DIFFRENT_MARK_EXP_REDUSE_RATIO")).attributeValue("value")).intValue();
/* 117 */       this.PET_MARK_MAX_LEVEL = Integer.valueOf(((Element)data.get("PET_MARK_MAX_LEVEL")).attributeValue("value")).intValue();
/* 118 */       this.PET_MARK_MAX_CARRY_NUM = Integer.valueOf(((Element)data.get("PET_MARK_MAX_CARRY_NUM")).attributeValue("value")).intValue();
/* 119 */       this.INIT_PET_MARK_SCORE1 = Integer.valueOf(((Element)data.get("INIT_PET_MARK_SCORE1")).attributeValue("value")).intValue();
/* 120 */       this.LOTTERY_ANIMATION_DURATION1 = Integer.valueOf(((Element)data.get("LOTTERY_ANIMATION_DURATION1")).attributeValue("value")).intValue();
/* 121 */       this.LOTTERY_COST1 = Integer.valueOf(((Element)data.get("LOTTERY_COST1")).attributeValue("value")).intValue();
/* 122 */       this.TEN_LOTTERY_COST1 = Integer.valueOf(((Element)data.get("TEN_LOTTERY_COST1")).attributeValue("value")).intValue();
/* 123 */       this.LOTTERY_AWARD_POOL_TYPE_ID1 = Integer.valueOf(((Element)data.get("LOTTERY_AWARD_POOL_TYPE_ID1")).attributeValue("value")).intValue();
/* 124 */       this.INIT_PET_MARK_SCORE2 = Integer.valueOf(((Element)data.get("INIT_PET_MARK_SCORE2")).attributeValue("value")).intValue();
/* 125 */       this.LOTTERY_ANIMATION_DURATION2 = Integer.valueOf(((Element)data.get("LOTTERY_ANIMATION_DURATION2")).attributeValue("value")).intValue();
/* 126 */       this.LOTTERY_COST2 = Integer.valueOf(((Element)data.get("LOTTERY_COST2")).attributeValue("value")).intValue();
/* 127 */       this.TEN_LOTTERY_COST2 = Integer.valueOf(((Element)data.get("TEN_LOTTERY_COST2")).attributeValue("value")).intValue();
/* 128 */       this.LOTTERY_AWARD_POOL_TYPE_ID2 = Integer.valueOf(((Element)data.get("LOTTERY_AWARD_POOL_TYPE_ID2")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 136 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 139 */     String path = dir + "mzm.gsp.petmark.confbean.SPetMarkConstants.bny";
/*     */     try
/*     */     {
/* 142 */       File file = new File(path);
/* 143 */       if (file.exists())
/*     */       {
/* 145 */         byte[] bytes = new byte['Ѐ'];
/* 146 */         FileInputStream fis = new FileInputStream(file);
/* 147 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 148 */         int len = 0;
/* 149 */         while ((len = fis.read(bytes)) > 0)
/* 150 */           baos.write(bytes, 0, len);
/* 151 */         fis.close();
/* 152 */         bytes = baos.toByteArray();
/* 153 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 154 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 155 */         this.DIFFRENT_MARK_EXP_REDUSE_RATIO = _os_.unmarshal_int();
/* 156 */         this.PET_MARK_MAX_LEVEL = _os_.unmarshal_int();
/* 157 */         this.PET_MARK_MAX_CARRY_NUM = _os_.unmarshal_int();
/* 158 */         this.INIT_PET_MARK_SCORE1 = _os_.unmarshal_int();
/* 159 */         this.LOTTERY_ANIMATION_DURATION1 = _os_.unmarshal_int();
/* 160 */         this.LOTTERY_COST1 = _os_.unmarshal_int();
/* 161 */         this.TEN_LOTTERY_COST1 = _os_.unmarshal_int();
/* 162 */         this.LOTTERY_AWARD_POOL_TYPE_ID1 = _os_.unmarshal_int();
/* 163 */         this.INIT_PET_MARK_SCORE2 = _os_.unmarshal_int();
/* 164 */         this.LOTTERY_ANIMATION_DURATION2 = _os_.unmarshal_int();
/* 165 */         this.LOTTERY_COST2 = _os_.unmarshal_int();
/* 166 */         this.TEN_LOTTERY_COST2 = _os_.unmarshal_int();
/* 167 */         this.LOTTERY_AWARD_POOL_TYPE_ID2 = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 172 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.petmark.confbean.SPetMarkConstants.bny";
/*     */     try
/*     */     {
/* 181 */       File file = new File(path);
/* 182 */       if (file.exists())
/*     */       {
/* 184 */         byte[] bytes = new byte['Ѐ'];
/* 185 */         FileInputStream fis = new FileInputStream(file);
/* 186 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 187 */         int len = 0;
/* 188 */         while ((len = fis.read(bytes)) > 0)
/* 189 */           baos.write(bytes, 0, len);
/* 190 */         fis.close();
/* 191 */         bytes = baos.toByteArray();
/* 192 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 193 */         this.OPEN_LEVEL = _os_.unmarshal_int();
/* 194 */         this.DIFFRENT_MARK_EXP_REDUSE_RATIO = _os_.unmarshal_int();
/* 195 */         this.PET_MARK_MAX_LEVEL = _os_.unmarshal_int();
/* 196 */         this.PET_MARK_MAX_CARRY_NUM = _os_.unmarshal_int();
/* 197 */         this.INIT_PET_MARK_SCORE1 = _os_.unmarshal_int();
/* 198 */         this.LOTTERY_ANIMATION_DURATION1 = _os_.unmarshal_int();
/* 199 */         this.LOTTERY_COST1 = _os_.unmarshal_int();
/* 200 */         this.TEN_LOTTERY_COST1 = _os_.unmarshal_int();
/* 201 */         this.LOTTERY_AWARD_POOL_TYPE_ID1 = _os_.unmarshal_int();
/* 202 */         this.INIT_PET_MARK_SCORE2 = _os_.unmarshal_int();
/* 203 */         this.LOTTERY_ANIMATION_DURATION2 = _os_.unmarshal_int();
/* 204 */         this.LOTTERY_COST2 = _os_.unmarshal_int();
/* 205 */         this.TEN_LOTTERY_COST2 = _os_.unmarshal_int();
/* 206 */         this.LOTTERY_AWARD_POOL_TYPE_ID2 = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SPetMarkConstants newInstance)
/*     */   {
/* 217 */     oldInstance = instance;
/* 218 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 223 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\confbean\SPetMarkConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */