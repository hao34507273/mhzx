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
/*     */ public class RedGiftActivityConst
/*     */ {
/*  13 */   private static volatile RedGiftActivityConst oldInstance = null;
/*     */   
/*  15 */   private static RedGiftActivityConst instance = new RedGiftActivityConst();
/*     */   public int activityId;
/*     */   public int activityBroadcastTime;
/*     */   public int activityStartRate;
/*     */   public int activityBroadcastTimeInterval;
/*     */   public int commonRewardId;
/*     */   
/*     */   public static RedGiftActivityConst getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static RedGiftActivityConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int topRewardId;
/*     */   
/*     */   public int commonRewardRate;
/*     */   
/*     */   public int topRewardRate;
/*     */   
/*     */   public int nullRewardRate;
/*     */   
/*     */   public int endGetRedgiftTime;
/*     */   
/*     */   public int serverEndGetRedgiftTime;
/*     */   public int activityTime1;
/*     */   public int activityTime2;
/*     */   public int activityTime3;
/*     */   public int activityTime4;
/*     */   public int activityTime5;
/*     */   public int activityTime6;
/*     */   public int highStartRate;
/*     */   public int highStartRateId1;
/*     */   public int highStartRateId2;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  54 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  59 */     String path = dir + "mzm.gsp.activity.confbean.RedGiftActivityConst.xml";
/*     */     try
/*     */     {
/*  62 */       SAXReader reader = new SAXReader();
/*  63 */       org.dom4j.Document doc = reader.read(new File(path));
/*  64 */       Element root = doc.getRootElement();
/*  65 */       Map<String, Element> data = new java.util.HashMap();
/*  66 */       java.util.List<?> nodeList = root.elements();
/*  67 */       int len = nodeList.size();
/*  68 */       for (int i = 0; i < len; i++)
/*     */       {
/*  70 */         Element element = (Element)nodeList.get(i);
/*  71 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  74 */           String name = element.attributeValue("name");
/*  75 */           if (data.put(name, element) != null)
/*  76 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  79 */       this.activityId = Integer.valueOf(((Element)data.get("activityId")).attributeValue("value")).intValue();
/*  80 */       this.activityBroadcastTime = Integer.valueOf(((Element)data.get("activityBroadcastTime")).attributeValue("value")).intValue();
/*  81 */       this.activityStartRate = Integer.valueOf(((Element)data.get("activityStartRate")).attributeValue("value")).intValue();
/*  82 */       this.activityBroadcastTimeInterval = Integer.valueOf(((Element)data.get("activityBroadcastTimeInterval")).attributeValue("value")).intValue();
/*  83 */       this.commonRewardId = Integer.valueOf(((Element)data.get("commonRewardId")).attributeValue("value")).intValue();
/*  84 */       this.topRewardId = Integer.valueOf(((Element)data.get("topRewardId")).attributeValue("value")).intValue();
/*  85 */       this.commonRewardRate = Integer.valueOf(((Element)data.get("commonRewardRate")).attributeValue("value")).intValue();
/*  86 */       this.topRewardRate = Integer.valueOf(((Element)data.get("topRewardRate")).attributeValue("value")).intValue();
/*  87 */       this.nullRewardRate = Integer.valueOf(((Element)data.get("nullRewardRate")).attributeValue("value")).intValue();
/*  88 */       this.endGetRedgiftTime = Integer.valueOf(((Element)data.get("endGetRedgiftTime")).attributeValue("value")).intValue();
/*  89 */       this.serverEndGetRedgiftTime = Integer.valueOf(((Element)data.get("serverEndGetRedgiftTime")).attributeValue("value")).intValue();
/*  90 */       this.activityTime1 = Integer.valueOf(((Element)data.get("activityTime1")).attributeValue("value")).intValue();
/*  91 */       this.activityTime2 = Integer.valueOf(((Element)data.get("activityTime2")).attributeValue("value")).intValue();
/*  92 */       this.activityTime3 = Integer.valueOf(((Element)data.get("activityTime3")).attributeValue("value")).intValue();
/*  93 */       this.activityTime4 = Integer.valueOf(((Element)data.get("activityTime4")).attributeValue("value")).intValue();
/*  94 */       this.activityTime5 = Integer.valueOf(((Element)data.get("activityTime5")).attributeValue("value")).intValue();
/*  95 */       this.activityTime6 = Integer.valueOf(((Element)data.get("activityTime6")).attributeValue("value")).intValue();
/*  96 */       this.highStartRate = Integer.valueOf(((Element)data.get("highStartRate")).attributeValue("value")).intValue();
/*  97 */       this.highStartRateId1 = Integer.valueOf(((Element)data.get("highStartRateId1")).attributeValue("value")).intValue();
/*  98 */       this.highStartRateId2 = Integer.valueOf(((Element)data.get("highStartRateId2")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 102 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 107 */     String path = dir + "mzm.gsp.activity.confbean.RedGiftActivityConst.xml";
/*     */     try
/*     */     {
/* 110 */       SAXReader reader = new SAXReader();
/* 111 */       org.dom4j.Document doc = reader.read(new File(path));
/* 112 */       Element root = doc.getRootElement();
/* 113 */       Map<String, Element> data = new java.util.HashMap();
/* 114 */       java.util.List<?> nodeList = root.elements();
/* 115 */       int len = nodeList.size();
/* 116 */       for (int i = 0; i < len; i++)
/*     */       {
/* 118 */         Element element = (Element)nodeList.get(i);
/* 119 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 122 */           String name = element.attributeValue("name");
/* 123 */           if (data.put(name, element) != null)
/* 124 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 127 */       this.activityId = Integer.valueOf(((Element)data.get("activityId")).attributeValue("value")).intValue();
/* 128 */       this.activityBroadcastTime = Integer.valueOf(((Element)data.get("activityBroadcastTime")).attributeValue("value")).intValue();
/* 129 */       this.activityStartRate = Integer.valueOf(((Element)data.get("activityStartRate")).attributeValue("value")).intValue();
/* 130 */       this.activityBroadcastTimeInterval = Integer.valueOf(((Element)data.get("activityBroadcastTimeInterval")).attributeValue("value")).intValue();
/* 131 */       this.commonRewardId = Integer.valueOf(((Element)data.get("commonRewardId")).attributeValue("value")).intValue();
/* 132 */       this.topRewardId = Integer.valueOf(((Element)data.get("topRewardId")).attributeValue("value")).intValue();
/* 133 */       this.commonRewardRate = Integer.valueOf(((Element)data.get("commonRewardRate")).attributeValue("value")).intValue();
/* 134 */       this.topRewardRate = Integer.valueOf(((Element)data.get("topRewardRate")).attributeValue("value")).intValue();
/* 135 */       this.nullRewardRate = Integer.valueOf(((Element)data.get("nullRewardRate")).attributeValue("value")).intValue();
/* 136 */       this.endGetRedgiftTime = Integer.valueOf(((Element)data.get("endGetRedgiftTime")).attributeValue("value")).intValue();
/* 137 */       this.serverEndGetRedgiftTime = Integer.valueOf(((Element)data.get("serverEndGetRedgiftTime")).attributeValue("value")).intValue();
/* 138 */       this.activityTime1 = Integer.valueOf(((Element)data.get("activityTime1")).attributeValue("value")).intValue();
/* 139 */       this.activityTime2 = Integer.valueOf(((Element)data.get("activityTime2")).attributeValue("value")).intValue();
/* 140 */       this.activityTime3 = Integer.valueOf(((Element)data.get("activityTime3")).attributeValue("value")).intValue();
/* 141 */       this.activityTime4 = Integer.valueOf(((Element)data.get("activityTime4")).attributeValue("value")).intValue();
/* 142 */       this.activityTime5 = Integer.valueOf(((Element)data.get("activityTime5")).attributeValue("value")).intValue();
/* 143 */       this.activityTime6 = Integer.valueOf(((Element)data.get("activityTime6")).attributeValue("value")).intValue();
/* 144 */       this.highStartRate = Integer.valueOf(((Element)data.get("highStartRate")).attributeValue("value")).intValue();
/* 145 */       this.highStartRateId1 = Integer.valueOf(((Element)data.get("highStartRateId1")).attributeValue("value")).intValue();
/* 146 */       this.highStartRateId2 = Integer.valueOf(((Element)data.get("highStartRateId2")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 150 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 154 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 157 */     String path = dir + "mzm.gsp.activity.confbean.RedGiftActivityConst.bny";
/*     */     try
/*     */     {
/* 160 */       File file = new File(path);
/* 161 */       if (file.exists())
/*     */       {
/* 163 */         byte[] bytes = new byte['Ѐ'];
/* 164 */         FileInputStream fis = new FileInputStream(file);
/* 165 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 166 */         int len = 0;
/* 167 */         while ((len = fis.read(bytes)) > 0)
/* 168 */           baos.write(bytes, 0, len);
/* 169 */         fis.close();
/* 170 */         bytes = baos.toByteArray();
/* 171 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 172 */         this.activityId = _os_.unmarshal_int();
/* 173 */         this.activityBroadcastTime = _os_.unmarshal_int();
/* 174 */         this.activityStartRate = _os_.unmarshal_int();
/* 175 */         this.activityBroadcastTimeInterval = _os_.unmarshal_int();
/* 176 */         this.commonRewardId = _os_.unmarshal_int();
/* 177 */         this.topRewardId = _os_.unmarshal_int();
/* 178 */         this.commonRewardRate = _os_.unmarshal_int();
/* 179 */         this.topRewardRate = _os_.unmarshal_int();
/* 180 */         this.nullRewardRate = _os_.unmarshal_int();
/* 181 */         this.endGetRedgiftTime = _os_.unmarshal_int();
/* 182 */         this.serverEndGetRedgiftTime = _os_.unmarshal_int();
/* 183 */         this.activityTime1 = _os_.unmarshal_int();
/* 184 */         this.activityTime2 = _os_.unmarshal_int();
/* 185 */         this.activityTime3 = _os_.unmarshal_int();
/* 186 */         this.activityTime4 = _os_.unmarshal_int();
/* 187 */         this.activityTime5 = _os_.unmarshal_int();
/* 188 */         this.activityTime6 = _os_.unmarshal_int();
/* 189 */         this.highStartRate = _os_.unmarshal_int();
/* 190 */         this.highStartRateId1 = _os_.unmarshal_int();
/* 191 */         this.highStartRateId2 = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 202 */     String path = dir + "mzm.gsp.activity.confbean.RedGiftActivityConst.bny";
/*     */     try
/*     */     {
/* 205 */       File file = new File(path);
/* 206 */       if (file.exists())
/*     */       {
/* 208 */         byte[] bytes = new byte['Ѐ'];
/* 209 */         FileInputStream fis = new FileInputStream(file);
/* 210 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 211 */         int len = 0;
/* 212 */         while ((len = fis.read(bytes)) > 0)
/* 213 */           baos.write(bytes, 0, len);
/* 214 */         fis.close();
/* 215 */         bytes = baos.toByteArray();
/* 216 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 217 */         this.activityId = _os_.unmarshal_int();
/* 218 */         this.activityBroadcastTime = _os_.unmarshal_int();
/* 219 */         this.activityStartRate = _os_.unmarshal_int();
/* 220 */         this.activityBroadcastTimeInterval = _os_.unmarshal_int();
/* 221 */         this.commonRewardId = _os_.unmarshal_int();
/* 222 */         this.topRewardId = _os_.unmarshal_int();
/* 223 */         this.commonRewardRate = _os_.unmarshal_int();
/* 224 */         this.topRewardRate = _os_.unmarshal_int();
/* 225 */         this.nullRewardRate = _os_.unmarshal_int();
/* 226 */         this.endGetRedgiftTime = _os_.unmarshal_int();
/* 227 */         this.serverEndGetRedgiftTime = _os_.unmarshal_int();
/* 228 */         this.activityTime1 = _os_.unmarshal_int();
/* 229 */         this.activityTime2 = _os_.unmarshal_int();
/* 230 */         this.activityTime3 = _os_.unmarshal_int();
/* 231 */         this.activityTime4 = _os_.unmarshal_int();
/* 232 */         this.activityTime5 = _os_.unmarshal_int();
/* 233 */         this.activityTime6 = _os_.unmarshal_int();
/* 234 */         this.highStartRate = _os_.unmarshal_int();
/* 235 */         this.highStartRateId1 = _os_.unmarshal_int();
/* 236 */         this.highStartRateId2 = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 241 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(RedGiftActivityConst newInstance)
/*     */   {
/* 247 */     oldInstance = instance;
/* 248 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 253 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\RedGiftActivityConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */