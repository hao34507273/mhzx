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
/*     */ public class BountyConsts
/*     */ {
/*  13 */   private static volatile BountyConsts oldInstance = null;
/*     */   
/*  15 */   private static BountyConsts instance = new BountyConsts();
/*     */   public int ACTIVITYID;
/*     */   public int NPC_ID;
/*     */   public int TASK_GRAPH_ID_1;
/*     */   public int TASK_GRAPH_ID_2;
/*     */   public int TASK_GRAPH_ID_3;
/*     */   
/*     */   public static BountyConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static BountyConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int TASK_GRAPH_ID_4;
/*     */   
/*     */   public int GUIDE_GRAPH_ID;
/*     */   
/*     */   public int DAY_UPPER_LIMIT;
/*     */   
/*     */   public int FLUSH_ITEM_ID;
/*     */   
/*     */   public int STORE_EXCHANGE_RATE;
/*     */   
/*     */   public int BASE_AWARD_ID;
/*     */   public int ONE_AWARD_ID;
/*     */   public int TWO_AWARD_ID;
/*     */   public int THREE_AWARD_ID;
/*     */   public int FOUR_AWARD_ID;
/*     */   public int FIVE_AWARD_ID;
/*     */   public int REFRESH_ITEM_MAX;
/*     */   public int FREE_COUNT_MAX;
/*     */   public int FRIST_REFRESH_ITEM_MAX;
/*     */   public int FRIST_FREE_COUNT_MAX;
/*     */   public int FRIST_BAO_DI_COUNT;
/*     */   public int PROBABILITY_TIP_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  56 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  61 */     String path = dir + "mzm.gsp.activity.confbean.BountyConsts.xml";
/*     */     try
/*     */     {
/*  64 */       SAXReader reader = new SAXReader();
/*  65 */       org.dom4j.Document doc = reader.read(new File(path));
/*  66 */       Element root = doc.getRootElement();
/*  67 */       Map<String, Element> data = new java.util.HashMap();
/*  68 */       java.util.List<?> nodeList = root.elements();
/*  69 */       int len = nodeList.size();
/*  70 */       for (int i = 0; i < len; i++)
/*     */       {
/*  72 */         Element element = (Element)nodeList.get(i);
/*  73 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  76 */           String name = element.attributeValue("name");
/*  77 */           if (data.put(name, element) != null)
/*  78 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  81 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  82 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/*  83 */       this.TASK_GRAPH_ID_1 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_1")).attributeValue("value")).intValue();
/*  84 */       this.TASK_GRAPH_ID_2 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_2")).attributeValue("value")).intValue();
/*  85 */       this.TASK_GRAPH_ID_3 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_3")).attributeValue("value")).intValue();
/*  86 */       this.TASK_GRAPH_ID_4 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_4")).attributeValue("value")).intValue();
/*  87 */       this.GUIDE_GRAPH_ID = Integer.valueOf(((Element)data.get("GUIDE_GRAPH_ID")).attributeValue("value")).intValue();
/*  88 */       this.DAY_UPPER_LIMIT = Integer.valueOf(((Element)data.get("DAY_UPPER_LIMIT")).attributeValue("value")).intValue();
/*  89 */       this.FLUSH_ITEM_ID = Integer.valueOf(((Element)data.get("FLUSH_ITEM_ID")).attributeValue("value")).intValue();
/*  90 */       this.STORE_EXCHANGE_RATE = Integer.valueOf(((Element)data.get("STORE_EXCHANGE_RATE")).attributeValue("value")).intValue();
/*  91 */       this.BASE_AWARD_ID = Integer.valueOf(((Element)data.get("BASE_AWARD_ID")).attributeValue("value")).intValue();
/*  92 */       this.ONE_AWARD_ID = Integer.valueOf(((Element)data.get("ONE_AWARD_ID")).attributeValue("value")).intValue();
/*  93 */       this.TWO_AWARD_ID = Integer.valueOf(((Element)data.get("TWO_AWARD_ID")).attributeValue("value")).intValue();
/*  94 */       this.THREE_AWARD_ID = Integer.valueOf(((Element)data.get("THREE_AWARD_ID")).attributeValue("value")).intValue();
/*  95 */       this.FOUR_AWARD_ID = Integer.valueOf(((Element)data.get("FOUR_AWARD_ID")).attributeValue("value")).intValue();
/*  96 */       this.FIVE_AWARD_ID = Integer.valueOf(((Element)data.get("FIVE_AWARD_ID")).attributeValue("value")).intValue();
/*  97 */       this.REFRESH_ITEM_MAX = Integer.valueOf(((Element)data.get("REFRESH_ITEM_MAX")).attributeValue("value")).intValue();
/*  98 */       this.FREE_COUNT_MAX = Integer.valueOf(((Element)data.get("FREE_COUNT_MAX")).attributeValue("value")).intValue();
/*  99 */       this.FRIST_REFRESH_ITEM_MAX = Integer.valueOf(((Element)data.get("FRIST_REFRESH_ITEM_MAX")).attributeValue("value")).intValue();
/* 100 */       this.FRIST_FREE_COUNT_MAX = Integer.valueOf(((Element)data.get("FRIST_FREE_COUNT_MAX")).attributeValue("value")).intValue();
/* 101 */       this.FRIST_BAO_DI_COUNT = Integer.valueOf(((Element)data.get("FRIST_BAO_DI_COUNT")).attributeValue("value")).intValue();
/* 102 */       this.PROBABILITY_TIP_ID = Integer.valueOf(((Element)data.get("PROBABILITY_TIP_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 106 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 111 */     String path = dir + "mzm.gsp.activity.confbean.BountyConsts.xml";
/*     */     try
/*     */     {
/* 114 */       SAXReader reader = new SAXReader();
/* 115 */       org.dom4j.Document doc = reader.read(new File(path));
/* 116 */       Element root = doc.getRootElement();
/* 117 */       Map<String, Element> data = new java.util.HashMap();
/* 118 */       java.util.List<?> nodeList = root.elements();
/* 119 */       int len = nodeList.size();
/* 120 */       for (int i = 0; i < len; i++)
/*     */       {
/* 122 */         Element element = (Element)nodeList.get(i);
/* 123 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 126 */           String name = element.attributeValue("name");
/* 127 */           if (data.put(name, element) != null)
/* 128 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 131 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 132 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/* 133 */       this.TASK_GRAPH_ID_1 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_1")).attributeValue("value")).intValue();
/* 134 */       this.TASK_GRAPH_ID_2 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_2")).attributeValue("value")).intValue();
/* 135 */       this.TASK_GRAPH_ID_3 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_3")).attributeValue("value")).intValue();
/* 136 */       this.TASK_GRAPH_ID_4 = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID_4")).attributeValue("value")).intValue();
/* 137 */       this.GUIDE_GRAPH_ID = Integer.valueOf(((Element)data.get("GUIDE_GRAPH_ID")).attributeValue("value")).intValue();
/* 138 */       this.DAY_UPPER_LIMIT = Integer.valueOf(((Element)data.get("DAY_UPPER_LIMIT")).attributeValue("value")).intValue();
/* 139 */       this.FLUSH_ITEM_ID = Integer.valueOf(((Element)data.get("FLUSH_ITEM_ID")).attributeValue("value")).intValue();
/* 140 */       this.STORE_EXCHANGE_RATE = Integer.valueOf(((Element)data.get("STORE_EXCHANGE_RATE")).attributeValue("value")).intValue();
/* 141 */       this.BASE_AWARD_ID = Integer.valueOf(((Element)data.get("BASE_AWARD_ID")).attributeValue("value")).intValue();
/* 142 */       this.ONE_AWARD_ID = Integer.valueOf(((Element)data.get("ONE_AWARD_ID")).attributeValue("value")).intValue();
/* 143 */       this.TWO_AWARD_ID = Integer.valueOf(((Element)data.get("TWO_AWARD_ID")).attributeValue("value")).intValue();
/* 144 */       this.THREE_AWARD_ID = Integer.valueOf(((Element)data.get("THREE_AWARD_ID")).attributeValue("value")).intValue();
/* 145 */       this.FOUR_AWARD_ID = Integer.valueOf(((Element)data.get("FOUR_AWARD_ID")).attributeValue("value")).intValue();
/* 146 */       this.FIVE_AWARD_ID = Integer.valueOf(((Element)data.get("FIVE_AWARD_ID")).attributeValue("value")).intValue();
/* 147 */       this.REFRESH_ITEM_MAX = Integer.valueOf(((Element)data.get("REFRESH_ITEM_MAX")).attributeValue("value")).intValue();
/* 148 */       this.FREE_COUNT_MAX = Integer.valueOf(((Element)data.get("FREE_COUNT_MAX")).attributeValue("value")).intValue();
/* 149 */       this.FRIST_REFRESH_ITEM_MAX = Integer.valueOf(((Element)data.get("FRIST_REFRESH_ITEM_MAX")).attributeValue("value")).intValue();
/* 150 */       this.FRIST_FREE_COUNT_MAX = Integer.valueOf(((Element)data.get("FRIST_FREE_COUNT_MAX")).attributeValue("value")).intValue();
/* 151 */       this.FRIST_BAO_DI_COUNT = Integer.valueOf(((Element)data.get("FRIST_BAO_DI_COUNT")).attributeValue("value")).intValue();
/* 152 */       this.PROBABILITY_TIP_ID = Integer.valueOf(((Element)data.get("PROBABILITY_TIP_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 156 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 160 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 163 */     String path = dir + "mzm.gsp.activity.confbean.BountyConsts.bny";
/*     */     try
/*     */     {
/* 166 */       File file = new File(path);
/* 167 */       if (file.exists())
/*     */       {
/* 169 */         byte[] bytes = new byte['Ѐ'];
/* 170 */         FileInputStream fis = new FileInputStream(file);
/* 171 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 172 */         int len = 0;
/* 173 */         while ((len = fis.read(bytes)) > 0)
/* 174 */           baos.write(bytes, 0, len);
/* 175 */         fis.close();
/* 176 */         bytes = baos.toByteArray();
/* 177 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 178 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 179 */         this.NPC_ID = _os_.unmarshal_int();
/* 180 */         this.TASK_GRAPH_ID_1 = _os_.unmarshal_int();
/* 181 */         this.TASK_GRAPH_ID_2 = _os_.unmarshal_int();
/* 182 */         this.TASK_GRAPH_ID_3 = _os_.unmarshal_int();
/* 183 */         this.TASK_GRAPH_ID_4 = _os_.unmarshal_int();
/* 184 */         this.GUIDE_GRAPH_ID = _os_.unmarshal_int();
/* 185 */         this.DAY_UPPER_LIMIT = _os_.unmarshal_int();
/* 186 */         this.FLUSH_ITEM_ID = _os_.unmarshal_int();
/* 187 */         this.STORE_EXCHANGE_RATE = _os_.unmarshal_int();
/* 188 */         this.BASE_AWARD_ID = _os_.unmarshal_int();
/* 189 */         this.ONE_AWARD_ID = _os_.unmarshal_int();
/* 190 */         this.TWO_AWARD_ID = _os_.unmarshal_int();
/* 191 */         this.THREE_AWARD_ID = _os_.unmarshal_int();
/* 192 */         this.FOUR_AWARD_ID = _os_.unmarshal_int();
/* 193 */         this.FIVE_AWARD_ID = _os_.unmarshal_int();
/* 194 */         this.REFRESH_ITEM_MAX = _os_.unmarshal_int();
/* 195 */         this.FREE_COUNT_MAX = _os_.unmarshal_int();
/* 196 */         this.FRIST_REFRESH_ITEM_MAX = _os_.unmarshal_int();
/* 197 */         this.FRIST_FREE_COUNT_MAX = _os_.unmarshal_int();
/* 198 */         this.FRIST_BAO_DI_COUNT = _os_.unmarshal_int();
/* 199 */         this.PROBABILITY_TIP_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 204 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 210 */     String path = dir + "mzm.gsp.activity.confbean.BountyConsts.bny";
/*     */     try
/*     */     {
/* 213 */       File file = new File(path);
/* 214 */       if (file.exists())
/*     */       {
/* 216 */         byte[] bytes = new byte['Ѐ'];
/* 217 */         FileInputStream fis = new FileInputStream(file);
/* 218 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 219 */         int len = 0;
/* 220 */         while ((len = fis.read(bytes)) > 0)
/* 221 */           baos.write(bytes, 0, len);
/* 222 */         fis.close();
/* 223 */         bytes = baos.toByteArray();
/* 224 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 225 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 226 */         this.NPC_ID = _os_.unmarshal_int();
/* 227 */         this.TASK_GRAPH_ID_1 = _os_.unmarshal_int();
/* 228 */         this.TASK_GRAPH_ID_2 = _os_.unmarshal_int();
/* 229 */         this.TASK_GRAPH_ID_3 = _os_.unmarshal_int();
/* 230 */         this.TASK_GRAPH_ID_4 = _os_.unmarshal_int();
/* 231 */         this.GUIDE_GRAPH_ID = _os_.unmarshal_int();
/* 232 */         this.DAY_UPPER_LIMIT = _os_.unmarshal_int();
/* 233 */         this.FLUSH_ITEM_ID = _os_.unmarshal_int();
/* 234 */         this.STORE_EXCHANGE_RATE = _os_.unmarshal_int();
/* 235 */         this.BASE_AWARD_ID = _os_.unmarshal_int();
/* 236 */         this.ONE_AWARD_ID = _os_.unmarshal_int();
/* 237 */         this.TWO_AWARD_ID = _os_.unmarshal_int();
/* 238 */         this.THREE_AWARD_ID = _os_.unmarshal_int();
/* 239 */         this.FOUR_AWARD_ID = _os_.unmarshal_int();
/* 240 */         this.FIVE_AWARD_ID = _os_.unmarshal_int();
/* 241 */         this.REFRESH_ITEM_MAX = _os_.unmarshal_int();
/* 242 */         this.FREE_COUNT_MAX = _os_.unmarshal_int();
/* 243 */         this.FRIST_REFRESH_ITEM_MAX = _os_.unmarshal_int();
/* 244 */         this.FRIST_FREE_COUNT_MAX = _os_.unmarshal_int();
/* 245 */         this.FRIST_BAO_DI_COUNT = _os_.unmarshal_int();
/* 246 */         this.PROBABILITY_TIP_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 251 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(BountyConsts newInstance)
/*     */   {
/* 257 */     oldInstance = instance;
/* 258 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 263 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\BountyConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */