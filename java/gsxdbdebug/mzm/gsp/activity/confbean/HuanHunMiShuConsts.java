/*     */ package mzm.gsp.activity.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class HuanHunMiShuConsts
/*     */ {
/*  13 */   private static volatile HuanHunMiShuConsts oldInstance = null;
/*     */   
/*  15 */   private static HuanHunMiShuConsts instance = new HuanHunMiShuConsts();
/*     */   public int ACTIVITYID;
/*     */   public int NPC_ID;
/*     */   public int TASK_TIME_LIMIT;
/*     */   public int TASK_GRAPH_ID;
/*     */   
/*     */   public static HuanHunMiShuConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static HuanHunMiShuConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int GUIDE_GRAPH_ID;
/*     */   
/*     */   public int AWARD_ITEM_ID;
/*     */   
/*     */   public int AWARD_ITEM_NUM;
/*     */   
/*     */   public int FLUSH_TIME;
/*     */   
/*     */   public double XIULIAN_RATE_LOW;
/*     */   public double XIULIAN_RATE_HIGH;
/*     */   public int NEED_SILVER_PER_XIULIAN;
/*     */   public int XIULIAN_PER_ITEM_LOW;
/*     */   public int FULL_BOX_NUM_BEFORE_SEEK_HRLP;
/*     */   public int SEEK_HELP_NUM;
/*     */   public int HELP_OTHER_NUM;
/*     */   public int HELP_OTHER_GANG_AWARD_ID;
/*     */   public int COOK_LIANYAO_AWARD_RANK;
/*     */   public int HELP_OTHER_LEVEL_LESS;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  52 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  57 */     String path = dir + "mzm.gsp.activity.confbean.HuanHunMiShuConsts.xml";
/*     */     try
/*     */     {
/*  60 */       SAXReader reader = new SAXReader();
/*  61 */       org.dom4j.Document doc = reader.read(new File(path));
/*  62 */       Element root = doc.getRootElement();
/*  63 */       Map<String, Element> data = new java.util.HashMap();
/*  64 */       java.util.List<?> nodeList = root.elements();
/*  65 */       int len = nodeList.size();
/*  66 */       for (int i = 0; i < len; i++)
/*     */       {
/*  68 */         Element element = (Element)nodeList.get(i);
/*  69 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  72 */           String name = element.attributeValue("name");
/*  73 */           if (data.put(name, element) != null)
/*  74 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  77 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  78 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/*  79 */       this.TASK_TIME_LIMIT = Integer.valueOf(((Element)data.get("TASK_TIME_LIMIT")).attributeValue("value")).intValue();
/*  80 */       this.TASK_GRAPH_ID = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID")).attributeValue("value")).intValue();
/*  81 */       this.GUIDE_GRAPH_ID = Integer.valueOf(((Element)data.get("GUIDE_GRAPH_ID")).attributeValue("value")).intValue();
/*  82 */       this.AWARD_ITEM_ID = Integer.valueOf(((Element)data.get("AWARD_ITEM_ID")).attributeValue("value")).intValue();
/*  83 */       this.AWARD_ITEM_NUM = Integer.valueOf(((Element)data.get("AWARD_ITEM_NUM")).attributeValue("value")).intValue();
/*  84 */       this.FLUSH_TIME = Integer.valueOf(((Element)data.get("FLUSH_TIME")).attributeValue("value")).intValue();
/*  85 */       this.XIULIAN_RATE_LOW = Double.valueOf(((Element)data.get("XIULIAN_RATE_LOW")).attributeValue("value")).doubleValue();
/*  86 */       this.XIULIAN_RATE_HIGH = Double.valueOf(((Element)data.get("XIULIAN_RATE_HIGH")).attributeValue("value")).doubleValue();
/*  87 */       this.NEED_SILVER_PER_XIULIAN = Integer.valueOf(((Element)data.get("NEED_SILVER_PER_XIULIAN")).attributeValue("value")).intValue();
/*  88 */       this.XIULIAN_PER_ITEM_LOW = Integer.valueOf(((Element)data.get("XIULIAN_PER_ITEM_LOW")).attributeValue("value")).intValue();
/*  89 */       this.FULL_BOX_NUM_BEFORE_SEEK_HRLP = Integer.valueOf(((Element)data.get("FULL_BOX_NUM_BEFORE_SEEK_HRLP")).attributeValue("value")).intValue();
/*  90 */       this.SEEK_HELP_NUM = Integer.valueOf(((Element)data.get("SEEK_HELP_NUM")).attributeValue("value")).intValue();
/*  91 */       this.HELP_OTHER_NUM = Integer.valueOf(((Element)data.get("HELP_OTHER_NUM")).attributeValue("value")).intValue();
/*  92 */       this.HELP_OTHER_GANG_AWARD_ID = Integer.valueOf(((Element)data.get("HELP_OTHER_GANG_AWARD_ID")).attributeValue("value")).intValue();
/*  93 */       this.COOK_LIANYAO_AWARD_RANK = Integer.valueOf(((Element)data.get("COOK_LIANYAO_AWARD_RANK")).attributeValue("value")).intValue();
/*  94 */       this.HELP_OTHER_LEVEL_LESS = Integer.valueOf(((Element)data.get("HELP_OTHER_LEVEL_LESS")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  98 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 103 */     String path = dir + "mzm.gsp.activity.confbean.HuanHunMiShuConsts.xml";
/*     */     try
/*     */     {
/* 106 */       SAXReader reader = new SAXReader();
/* 107 */       org.dom4j.Document doc = reader.read(new File(path));
/* 108 */       Element root = doc.getRootElement();
/* 109 */       Map<String, Element> data = new java.util.HashMap();
/* 110 */       java.util.List<?> nodeList = root.elements();
/* 111 */       int len = nodeList.size();
/* 112 */       for (int i = 0; i < len; i++)
/*     */       {
/* 114 */         Element element = (Element)nodeList.get(i);
/* 115 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 118 */           String name = element.attributeValue("name");
/* 119 */           if (data.put(name, element) != null)
/* 120 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 123 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 124 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/* 125 */       this.TASK_TIME_LIMIT = Integer.valueOf(((Element)data.get("TASK_TIME_LIMIT")).attributeValue("value")).intValue();
/* 126 */       this.TASK_GRAPH_ID = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID")).attributeValue("value")).intValue();
/* 127 */       this.GUIDE_GRAPH_ID = Integer.valueOf(((Element)data.get("GUIDE_GRAPH_ID")).attributeValue("value")).intValue();
/* 128 */       this.AWARD_ITEM_ID = Integer.valueOf(((Element)data.get("AWARD_ITEM_ID")).attributeValue("value")).intValue();
/* 129 */       this.AWARD_ITEM_NUM = Integer.valueOf(((Element)data.get("AWARD_ITEM_NUM")).attributeValue("value")).intValue();
/* 130 */       this.FLUSH_TIME = Integer.valueOf(((Element)data.get("FLUSH_TIME")).attributeValue("value")).intValue();
/* 131 */       this.XIULIAN_RATE_LOW = Double.valueOf(((Element)data.get("XIULIAN_RATE_LOW")).attributeValue("value")).doubleValue();
/* 132 */       this.XIULIAN_RATE_HIGH = Double.valueOf(((Element)data.get("XIULIAN_RATE_HIGH")).attributeValue("value")).doubleValue();
/* 133 */       this.NEED_SILVER_PER_XIULIAN = Integer.valueOf(((Element)data.get("NEED_SILVER_PER_XIULIAN")).attributeValue("value")).intValue();
/* 134 */       this.XIULIAN_PER_ITEM_LOW = Integer.valueOf(((Element)data.get("XIULIAN_PER_ITEM_LOW")).attributeValue("value")).intValue();
/* 135 */       this.FULL_BOX_NUM_BEFORE_SEEK_HRLP = Integer.valueOf(((Element)data.get("FULL_BOX_NUM_BEFORE_SEEK_HRLP")).attributeValue("value")).intValue();
/* 136 */       this.SEEK_HELP_NUM = Integer.valueOf(((Element)data.get("SEEK_HELP_NUM")).attributeValue("value")).intValue();
/* 137 */       this.HELP_OTHER_NUM = Integer.valueOf(((Element)data.get("HELP_OTHER_NUM")).attributeValue("value")).intValue();
/* 138 */       this.HELP_OTHER_GANG_AWARD_ID = Integer.valueOf(((Element)data.get("HELP_OTHER_GANG_AWARD_ID")).attributeValue("value")).intValue();
/* 139 */       this.COOK_LIANYAO_AWARD_RANK = Integer.valueOf(((Element)data.get("COOK_LIANYAO_AWARD_RANK")).attributeValue("value")).intValue();
/* 140 */       this.HELP_OTHER_LEVEL_LESS = Integer.valueOf(((Element)data.get("HELP_OTHER_LEVEL_LESS")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 148 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 151 */     String path = dir + "mzm.gsp.activity.confbean.HuanHunMiShuConsts.bny";
/*     */     try
/*     */     {
/* 154 */       File file = new File(path);
/* 155 */       if (file.exists())
/*     */       {
/* 157 */         byte[] bytes = new byte['Ѐ'];
/* 158 */         FileInputStream fis = new FileInputStream(file);
/* 159 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 160 */         int len = 0;
/* 161 */         while ((len = fis.read(bytes)) > 0)
/* 162 */           baos.write(bytes, 0, len);
/* 163 */         fis.close();
/* 164 */         bytes = baos.toByteArray();
/* 165 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 166 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 167 */         this.NPC_ID = _os_.unmarshal_int();
/* 168 */         this.TASK_TIME_LIMIT = _os_.unmarshal_int();
/* 169 */         this.TASK_GRAPH_ID = _os_.unmarshal_int();
/* 170 */         this.GUIDE_GRAPH_ID = _os_.unmarshal_int();
/* 171 */         this.AWARD_ITEM_ID = _os_.unmarshal_int();
/* 172 */         this.AWARD_ITEM_NUM = _os_.unmarshal_int();
/* 173 */         this.FLUSH_TIME = _os_.unmarshal_int();
/* 174 */         this.XIULIAN_RATE_LOW = _os_.unmarshal_float();
/* 175 */         this.XIULIAN_RATE_HIGH = _os_.unmarshal_float();
/* 176 */         this.NEED_SILVER_PER_XIULIAN = _os_.unmarshal_int();
/* 177 */         this.XIULIAN_PER_ITEM_LOW = _os_.unmarshal_int();
/* 178 */         this.FULL_BOX_NUM_BEFORE_SEEK_HRLP = _os_.unmarshal_int();
/* 179 */         this.SEEK_HELP_NUM = _os_.unmarshal_int();
/* 180 */         this.HELP_OTHER_NUM = _os_.unmarshal_int();
/* 181 */         this.HELP_OTHER_GANG_AWARD_ID = _os_.unmarshal_int();
/* 182 */         this.COOK_LIANYAO_AWARD_RANK = _os_.unmarshal_int();
/* 183 */         this.HELP_OTHER_LEVEL_LESS = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 194 */     String path = dir + "mzm.gsp.activity.confbean.HuanHunMiShuConsts.bny";
/*     */     try
/*     */     {
/* 197 */       File file = new File(path);
/* 198 */       if (file.exists())
/*     */       {
/* 200 */         byte[] bytes = new byte['Ѐ'];
/* 201 */         FileInputStream fis = new FileInputStream(file);
/* 202 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 203 */         int len = 0;
/* 204 */         while ((len = fis.read(bytes)) > 0)
/* 205 */           baos.write(bytes, 0, len);
/* 206 */         fis.close();
/* 207 */         bytes = baos.toByteArray();
/* 208 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 209 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 210 */         this.NPC_ID = _os_.unmarshal_int();
/* 211 */         this.TASK_TIME_LIMIT = _os_.unmarshal_int();
/* 212 */         this.TASK_GRAPH_ID = _os_.unmarshal_int();
/* 213 */         this.GUIDE_GRAPH_ID = _os_.unmarshal_int();
/* 214 */         this.AWARD_ITEM_ID = _os_.unmarshal_int();
/* 215 */         this.AWARD_ITEM_NUM = _os_.unmarshal_int();
/* 216 */         this.FLUSH_TIME = _os_.unmarshal_int();
/* 217 */         this.XIULIAN_RATE_LOW = _os_.unmarshal_float();
/* 218 */         this.XIULIAN_RATE_HIGH = _os_.unmarshal_float();
/* 219 */         this.NEED_SILVER_PER_XIULIAN = _os_.unmarshal_int();
/* 220 */         this.XIULIAN_PER_ITEM_LOW = _os_.unmarshal_int();
/* 221 */         this.FULL_BOX_NUM_BEFORE_SEEK_HRLP = _os_.unmarshal_int();
/* 222 */         this.SEEK_HELP_NUM = _os_.unmarshal_int();
/* 223 */         this.HELP_OTHER_NUM = _os_.unmarshal_int();
/* 224 */         this.HELP_OTHER_GANG_AWARD_ID = _os_.unmarshal_int();
/* 225 */         this.COOK_LIANYAO_AWARD_RANK = _os_.unmarshal_int();
/* 226 */         this.HELP_OTHER_LEVEL_LESS = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(HuanHunMiShuConsts newInstance)
/*     */   {
/* 237 */     oldInstance = instance;
/* 238 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 243 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\HuanHunMiShuConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */