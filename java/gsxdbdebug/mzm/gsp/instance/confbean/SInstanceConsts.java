/*     */ package mzm.gsp.instance.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SInstanceConsts
/*     */ {
/*  13 */   private static volatile SInstanceConsts oldInstance = null;
/*     */   
/*  15 */   private static SInstanceConsts instance = new SInstanceConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SInstanceConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SInstanceConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int SINGLE_INSTANCE_FAIL_TIMES = 2;
/*  32 */   public int SINGLG_GUIDE_GRAPHID = 0;
/*     */   public int SAO_DAO_ITEM_ID;
/*  34 */   public int FINISH_TIME_CAN_SAO_DANG = 10;
/*  35 */   public int WAIT_TEAM_MEMBER_TIME = 20;
/*  36 */   public int ROLL_ITEM_SECOND = 10;
/*  37 */   public int SINGLE_INSTANCE_LEAVE_TIMER = 10;
/*  38 */   public int MULTI_INSTANCE_LEAVE_TIMER = 30;
/*  39 */   public int INSTANCE_HERO_VALUE = 2;
/*  40 */   public int SINGLE_INSTANCE_ACTIVITY_TYPE_ID = 1;
/*  41 */   public int INSTANCE_FIGHT_LOGOFF_DELAY = 15;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  45 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  50 */     String path = dir + "mzm.gsp.instance.confbean.SInstanceConsts.xml";
/*     */     try
/*     */     {
/*  53 */       SAXReader reader = new SAXReader();
/*  54 */       org.dom4j.Document doc = reader.read(new File(path));
/*  55 */       Element root = doc.getRootElement();
/*  56 */       Map<String, Element> data = new java.util.HashMap();
/*  57 */       java.util.List<?> nodeList = root.elements();
/*  58 */       int len = nodeList.size();
/*  59 */       for (int i = 0; i < len; i++)
/*     */       {
/*  61 */         Element element = (Element)nodeList.get(i);
/*  62 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  65 */           String name = element.attributeValue("name");
/*  66 */           if (data.put(name, element) != null)
/*  67 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  70 */       this.SINGLE_INSTANCE_FAIL_TIMES = Integer.valueOf(((Element)data.get("SINGLE_INSTANCE_FAIL_TIMES")).attributeValue("value")).intValue();
/*  71 */       this.SINGLG_GUIDE_GRAPHID = Integer.valueOf(((Element)data.get("SINGLG_GUIDE_GRAPHID")).attributeValue("value")).intValue();
/*  72 */       this.SAO_DAO_ITEM_ID = Integer.valueOf(((Element)data.get("SAO_DAO_ITEM_ID")).attributeValue("value")).intValue();
/*  73 */       this.FINISH_TIME_CAN_SAO_DANG = Integer.valueOf(((Element)data.get("FINISH_TIME_CAN_SAO_DANG")).attributeValue("value")).intValue();
/*  74 */       this.WAIT_TEAM_MEMBER_TIME = Integer.valueOf(((Element)data.get("WAIT_TEAM_MEMBER_TIME")).attributeValue("value")).intValue();
/*  75 */       this.ROLL_ITEM_SECOND = Integer.valueOf(((Element)data.get("ROLL_ITEM_SECOND")).attributeValue("value")).intValue();
/*  76 */       this.SINGLE_INSTANCE_LEAVE_TIMER = Integer.valueOf(((Element)data.get("SINGLE_INSTANCE_LEAVE_TIMER")).attributeValue("value")).intValue();
/*  77 */       this.MULTI_INSTANCE_LEAVE_TIMER = Integer.valueOf(((Element)data.get("MULTI_INSTANCE_LEAVE_TIMER")).attributeValue("value")).intValue();
/*  78 */       this.INSTANCE_HERO_VALUE = Integer.valueOf(((Element)data.get("INSTANCE_HERO_VALUE")).attributeValue("value")).intValue();
/*  79 */       this.SINGLE_INSTANCE_ACTIVITY_TYPE_ID = Integer.valueOf(((Element)data.get("SINGLE_INSTANCE_ACTIVITY_TYPE_ID")).attributeValue("value")).intValue();
/*  80 */       this.INSTANCE_FIGHT_LOGOFF_DELAY = Integer.valueOf(((Element)data.get("INSTANCE_FIGHT_LOGOFF_DELAY")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  84 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  89 */     String path = dir + "mzm.gsp.instance.confbean.SInstanceConsts.xml";
/*     */     try
/*     */     {
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       Map<String, Element> data = new java.util.HashMap();
/*  96 */       java.util.List<?> nodeList = root.elements();
/*  97 */       int len = nodeList.size();
/*  98 */       for (int i = 0; i < len; i++)
/*     */       {
/* 100 */         Element element = (Element)nodeList.get(i);
/* 101 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 104 */           String name = element.attributeValue("name");
/* 105 */           if (data.put(name, element) != null)
/* 106 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 109 */       this.SINGLE_INSTANCE_FAIL_TIMES = Integer.valueOf(((Element)data.get("SINGLE_INSTANCE_FAIL_TIMES")).attributeValue("value")).intValue();
/* 110 */       this.SINGLG_GUIDE_GRAPHID = Integer.valueOf(((Element)data.get("SINGLG_GUIDE_GRAPHID")).attributeValue("value")).intValue();
/* 111 */       this.SAO_DAO_ITEM_ID = Integer.valueOf(((Element)data.get("SAO_DAO_ITEM_ID")).attributeValue("value")).intValue();
/* 112 */       this.FINISH_TIME_CAN_SAO_DANG = Integer.valueOf(((Element)data.get("FINISH_TIME_CAN_SAO_DANG")).attributeValue("value")).intValue();
/* 113 */       this.WAIT_TEAM_MEMBER_TIME = Integer.valueOf(((Element)data.get("WAIT_TEAM_MEMBER_TIME")).attributeValue("value")).intValue();
/* 114 */       this.ROLL_ITEM_SECOND = Integer.valueOf(((Element)data.get("ROLL_ITEM_SECOND")).attributeValue("value")).intValue();
/* 115 */       this.SINGLE_INSTANCE_LEAVE_TIMER = Integer.valueOf(((Element)data.get("SINGLE_INSTANCE_LEAVE_TIMER")).attributeValue("value")).intValue();
/* 116 */       this.MULTI_INSTANCE_LEAVE_TIMER = Integer.valueOf(((Element)data.get("MULTI_INSTANCE_LEAVE_TIMER")).attributeValue("value")).intValue();
/* 117 */       this.INSTANCE_HERO_VALUE = Integer.valueOf(((Element)data.get("INSTANCE_HERO_VALUE")).attributeValue("value")).intValue();
/* 118 */       this.SINGLE_INSTANCE_ACTIVITY_TYPE_ID = Integer.valueOf(((Element)data.get("SINGLE_INSTANCE_ACTIVITY_TYPE_ID")).attributeValue("value")).intValue();
/* 119 */       this.INSTANCE_FIGHT_LOGOFF_DELAY = Integer.valueOf(((Element)data.get("INSTANCE_FIGHT_LOGOFF_DELAY")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 123 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 127 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 130 */     String path = dir + "mzm.gsp.instance.confbean.SInstanceConsts.bny";
/*     */     try
/*     */     {
/* 133 */       File file = new File(path);
/* 134 */       if (file.exists())
/*     */       {
/* 136 */         byte[] bytes = new byte['Ѐ'];
/* 137 */         FileInputStream fis = new FileInputStream(file);
/* 138 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 139 */         int len = 0;
/* 140 */         while ((len = fis.read(bytes)) > 0)
/* 141 */           baos.write(bytes, 0, len);
/* 142 */         fis.close();
/* 143 */         bytes = baos.toByteArray();
/* 144 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 145 */         this.SINGLE_INSTANCE_FAIL_TIMES = _os_.unmarshal_int();
/* 146 */         this.SINGLG_GUIDE_GRAPHID = _os_.unmarshal_int();
/* 147 */         this.SAO_DAO_ITEM_ID = _os_.unmarshal_int();
/* 148 */         this.FINISH_TIME_CAN_SAO_DANG = _os_.unmarshal_int();
/* 149 */         this.WAIT_TEAM_MEMBER_TIME = _os_.unmarshal_int();
/* 150 */         this.ROLL_ITEM_SECOND = _os_.unmarshal_int();
/* 151 */         this.SINGLE_INSTANCE_LEAVE_TIMER = _os_.unmarshal_int();
/* 152 */         this.MULTI_INSTANCE_LEAVE_TIMER = _os_.unmarshal_int();
/* 153 */         this.INSTANCE_HERO_VALUE = _os_.unmarshal_int();
/* 154 */         this.SINGLE_INSTANCE_ACTIVITY_TYPE_ID = _os_.unmarshal_int();
/* 155 */         this.INSTANCE_FIGHT_LOGOFF_DELAY = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 166 */     String path = dir + "mzm.gsp.instance.confbean.SInstanceConsts.bny";
/*     */     try
/*     */     {
/* 169 */       File file = new File(path);
/* 170 */       if (file.exists())
/*     */       {
/* 172 */         byte[] bytes = new byte['Ѐ'];
/* 173 */         FileInputStream fis = new FileInputStream(file);
/* 174 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 175 */         int len = 0;
/* 176 */         while ((len = fis.read(bytes)) > 0)
/* 177 */           baos.write(bytes, 0, len);
/* 178 */         fis.close();
/* 179 */         bytes = baos.toByteArray();
/* 180 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 181 */         this.SINGLE_INSTANCE_FAIL_TIMES = _os_.unmarshal_int();
/* 182 */         this.SINGLG_GUIDE_GRAPHID = _os_.unmarshal_int();
/* 183 */         this.SAO_DAO_ITEM_ID = _os_.unmarshal_int();
/* 184 */         this.FINISH_TIME_CAN_SAO_DANG = _os_.unmarshal_int();
/* 185 */         this.WAIT_TEAM_MEMBER_TIME = _os_.unmarshal_int();
/* 186 */         this.ROLL_ITEM_SECOND = _os_.unmarshal_int();
/* 187 */         this.SINGLE_INSTANCE_LEAVE_TIMER = _os_.unmarshal_int();
/* 188 */         this.MULTI_INSTANCE_LEAVE_TIMER = _os_.unmarshal_int();
/* 189 */         this.INSTANCE_HERO_VALUE = _os_.unmarshal_int();
/* 190 */         this.SINGLE_INSTANCE_ACTIVITY_TYPE_ID = _os_.unmarshal_int();
/* 191 */         this.INSTANCE_FIGHT_LOGOFF_DELAY = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SInstanceConsts newInstance)
/*     */   {
/* 202 */     oldInstance = instance;
/* 203 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 208 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\confbean\SInstanceConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */