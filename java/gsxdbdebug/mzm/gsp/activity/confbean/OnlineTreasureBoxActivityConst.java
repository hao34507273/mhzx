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
/*     */ public class OnlineTreasureBoxActivityConst
/*     */ {
/*  13 */   private static volatile OnlineTreasureBoxActivityConst oldInstance = null;
/*     */   
/*  15 */   private static OnlineTreasureBoxActivityConst instance = new OnlineTreasureBoxActivityConst();
/*     */   public int activityId;
/*     */   public int activityIntervalTime;
/*     */   public int activityBroadcastTime;
/*     */   public int activityBroadcastTimeInterval;
/*     */   public int activityAddExpAwardId;
/*     */   
/*     */   public static OnlineTreasureBoxActivityConst getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static OnlineTreasureBoxActivityConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int activityAddExpTime;
/*     */   
/*     */   public int activityAwardBuffId;
/*     */   
/*     */   public int boxAwardIntervalTime;
/*     */   
/*     */   public int boxAwardId;
/*     */   
/*     */   public int endGetAwardBoxTime;
/*     */   
/*     */   public int serverEndGetAwardBoxTime;
/*     */   public int AwardMailId;
/*     */   public int activityTime1;
/*     */   public int activityRate1;
/*     */   public int activityTime2;
/*     */   public int activityRate2;
/*     */   public int activityTime3;
/*     */   public int activityRate3;
/*     */   public int activityTime4;
/*     */   public int activityRate4;
/*     */   public int activityTime5;
/*     */   public int activityRate5;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  56 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  61 */     String path = dir + "mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst.xml";
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
/*  81 */       this.activityId = Integer.valueOf(((Element)data.get("activityId")).attributeValue("value")).intValue();
/*  82 */       this.activityIntervalTime = Integer.valueOf(((Element)data.get("activityIntervalTime")).attributeValue("value")).intValue();
/*  83 */       this.activityBroadcastTime = Integer.valueOf(((Element)data.get("activityBroadcastTime")).attributeValue("value")).intValue();
/*  84 */       this.activityBroadcastTimeInterval = Integer.valueOf(((Element)data.get("activityBroadcastTimeInterval")).attributeValue("value")).intValue();
/*  85 */       this.activityAddExpAwardId = Integer.valueOf(((Element)data.get("activityAddExpAwardId")).attributeValue("value")).intValue();
/*  86 */       this.activityAddExpTime = Integer.valueOf(((Element)data.get("activityAddExpTime")).attributeValue("value")).intValue();
/*  87 */       this.activityAwardBuffId = Integer.valueOf(((Element)data.get("activityAwardBuffId")).attributeValue("value")).intValue();
/*  88 */       this.boxAwardIntervalTime = Integer.valueOf(((Element)data.get("boxAwardIntervalTime")).attributeValue("value")).intValue();
/*  89 */       this.boxAwardId = Integer.valueOf(((Element)data.get("boxAwardId")).attributeValue("value")).intValue();
/*  90 */       this.endGetAwardBoxTime = Integer.valueOf(((Element)data.get("endGetAwardBoxTime")).attributeValue("value")).intValue();
/*  91 */       this.serverEndGetAwardBoxTime = Integer.valueOf(((Element)data.get("serverEndGetAwardBoxTime")).attributeValue("value")).intValue();
/*  92 */       this.AwardMailId = Integer.valueOf(((Element)data.get("AwardMailId")).attributeValue("value")).intValue();
/*  93 */       this.activityTime1 = Integer.valueOf(((Element)data.get("activityTime1")).attributeValue("value")).intValue();
/*  94 */       this.activityRate1 = Integer.valueOf(((Element)data.get("activityRate1")).attributeValue("value")).intValue();
/*  95 */       this.activityTime2 = Integer.valueOf(((Element)data.get("activityTime2")).attributeValue("value")).intValue();
/*  96 */       this.activityRate2 = Integer.valueOf(((Element)data.get("activityRate2")).attributeValue("value")).intValue();
/*  97 */       this.activityTime3 = Integer.valueOf(((Element)data.get("activityTime3")).attributeValue("value")).intValue();
/*  98 */       this.activityRate3 = Integer.valueOf(((Element)data.get("activityRate3")).attributeValue("value")).intValue();
/*  99 */       this.activityTime4 = Integer.valueOf(((Element)data.get("activityTime4")).attributeValue("value")).intValue();
/* 100 */       this.activityRate4 = Integer.valueOf(((Element)data.get("activityRate4")).attributeValue("value")).intValue();
/* 101 */       this.activityTime5 = Integer.valueOf(((Element)data.get("activityTime5")).attributeValue("value")).intValue();
/* 102 */       this.activityRate5 = Integer.valueOf(((Element)data.get("activityRate5")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 106 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 111 */     String path = dir + "mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst.xml";
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
/* 131 */       this.activityId = Integer.valueOf(((Element)data.get("activityId")).attributeValue("value")).intValue();
/* 132 */       this.activityIntervalTime = Integer.valueOf(((Element)data.get("activityIntervalTime")).attributeValue("value")).intValue();
/* 133 */       this.activityBroadcastTime = Integer.valueOf(((Element)data.get("activityBroadcastTime")).attributeValue("value")).intValue();
/* 134 */       this.activityBroadcastTimeInterval = Integer.valueOf(((Element)data.get("activityBroadcastTimeInterval")).attributeValue("value")).intValue();
/* 135 */       this.activityAddExpAwardId = Integer.valueOf(((Element)data.get("activityAddExpAwardId")).attributeValue("value")).intValue();
/* 136 */       this.activityAddExpTime = Integer.valueOf(((Element)data.get("activityAddExpTime")).attributeValue("value")).intValue();
/* 137 */       this.activityAwardBuffId = Integer.valueOf(((Element)data.get("activityAwardBuffId")).attributeValue("value")).intValue();
/* 138 */       this.boxAwardIntervalTime = Integer.valueOf(((Element)data.get("boxAwardIntervalTime")).attributeValue("value")).intValue();
/* 139 */       this.boxAwardId = Integer.valueOf(((Element)data.get("boxAwardId")).attributeValue("value")).intValue();
/* 140 */       this.endGetAwardBoxTime = Integer.valueOf(((Element)data.get("endGetAwardBoxTime")).attributeValue("value")).intValue();
/* 141 */       this.serverEndGetAwardBoxTime = Integer.valueOf(((Element)data.get("serverEndGetAwardBoxTime")).attributeValue("value")).intValue();
/* 142 */       this.AwardMailId = Integer.valueOf(((Element)data.get("AwardMailId")).attributeValue("value")).intValue();
/* 143 */       this.activityTime1 = Integer.valueOf(((Element)data.get("activityTime1")).attributeValue("value")).intValue();
/* 144 */       this.activityRate1 = Integer.valueOf(((Element)data.get("activityRate1")).attributeValue("value")).intValue();
/* 145 */       this.activityTime2 = Integer.valueOf(((Element)data.get("activityTime2")).attributeValue("value")).intValue();
/* 146 */       this.activityRate2 = Integer.valueOf(((Element)data.get("activityRate2")).attributeValue("value")).intValue();
/* 147 */       this.activityTime3 = Integer.valueOf(((Element)data.get("activityTime3")).attributeValue("value")).intValue();
/* 148 */       this.activityRate3 = Integer.valueOf(((Element)data.get("activityRate3")).attributeValue("value")).intValue();
/* 149 */       this.activityTime4 = Integer.valueOf(((Element)data.get("activityTime4")).attributeValue("value")).intValue();
/* 150 */       this.activityRate4 = Integer.valueOf(((Element)data.get("activityRate4")).attributeValue("value")).intValue();
/* 151 */       this.activityTime5 = Integer.valueOf(((Element)data.get("activityTime5")).attributeValue("value")).intValue();
/* 152 */       this.activityRate5 = Integer.valueOf(((Element)data.get("activityRate5")).attributeValue("value")).intValue();
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
/* 163 */     String path = dir + "mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst.bny";
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
/* 178 */         this.activityId = _os_.unmarshal_int();
/* 179 */         this.activityIntervalTime = _os_.unmarshal_int();
/* 180 */         this.activityBroadcastTime = _os_.unmarshal_int();
/* 181 */         this.activityBroadcastTimeInterval = _os_.unmarshal_int();
/* 182 */         this.activityAddExpAwardId = _os_.unmarshal_int();
/* 183 */         this.activityAddExpTime = _os_.unmarshal_int();
/* 184 */         this.activityAwardBuffId = _os_.unmarshal_int();
/* 185 */         this.boxAwardIntervalTime = _os_.unmarshal_int();
/* 186 */         this.boxAwardId = _os_.unmarshal_int();
/* 187 */         this.endGetAwardBoxTime = _os_.unmarshal_int();
/* 188 */         this.serverEndGetAwardBoxTime = _os_.unmarshal_int();
/* 189 */         this.AwardMailId = _os_.unmarshal_int();
/* 190 */         this.activityTime1 = _os_.unmarshal_int();
/* 191 */         this.activityRate1 = _os_.unmarshal_int();
/* 192 */         this.activityTime2 = _os_.unmarshal_int();
/* 193 */         this.activityRate2 = _os_.unmarshal_int();
/* 194 */         this.activityTime3 = _os_.unmarshal_int();
/* 195 */         this.activityRate3 = _os_.unmarshal_int();
/* 196 */         this.activityTime4 = _os_.unmarshal_int();
/* 197 */         this.activityRate4 = _os_.unmarshal_int();
/* 198 */         this.activityTime5 = _os_.unmarshal_int();
/* 199 */         this.activityRate5 = _os_.unmarshal_int();
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
/* 210 */     String path = dir + "mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst.bny";
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
/* 225 */         this.activityId = _os_.unmarshal_int();
/* 226 */         this.activityIntervalTime = _os_.unmarshal_int();
/* 227 */         this.activityBroadcastTime = _os_.unmarshal_int();
/* 228 */         this.activityBroadcastTimeInterval = _os_.unmarshal_int();
/* 229 */         this.activityAddExpAwardId = _os_.unmarshal_int();
/* 230 */         this.activityAddExpTime = _os_.unmarshal_int();
/* 231 */         this.activityAwardBuffId = _os_.unmarshal_int();
/* 232 */         this.boxAwardIntervalTime = _os_.unmarshal_int();
/* 233 */         this.boxAwardId = _os_.unmarshal_int();
/* 234 */         this.endGetAwardBoxTime = _os_.unmarshal_int();
/* 235 */         this.serverEndGetAwardBoxTime = _os_.unmarshal_int();
/* 236 */         this.AwardMailId = _os_.unmarshal_int();
/* 237 */         this.activityTime1 = _os_.unmarshal_int();
/* 238 */         this.activityRate1 = _os_.unmarshal_int();
/* 239 */         this.activityTime2 = _os_.unmarshal_int();
/* 240 */         this.activityRate2 = _os_.unmarshal_int();
/* 241 */         this.activityTime3 = _os_.unmarshal_int();
/* 242 */         this.activityRate3 = _os_.unmarshal_int();
/* 243 */         this.activityTime4 = _os_.unmarshal_int();
/* 244 */         this.activityRate4 = _os_.unmarshal_int();
/* 245 */         this.activityTime5 = _os_.unmarshal_int();
/* 246 */         this.activityRate5 = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 251 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(OnlineTreasureBoxActivityConst newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\OnlineTreasureBoxActivityConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */