/*     */ package mzm.gsp.chat.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class ChatGiftConsts
/*     */ {
/*  13 */   private static volatile ChatGiftConsts oldInstance = null;
/*     */   
/*  15 */   private static ChatGiftConsts instance = new ChatGiftConsts();
/*     */   
/*     */   public int needActiviteValue;
/*     */   public int dayLimitNum;
/*     */   public int defaultNum;
/*     */   
/*     */   public static ChatGiftConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static ChatGiftConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int minNum;
/*     */   
/*     */   public int maxNum;
/*     */   
/*     */   public int strLimitNum;
/*     */   
/*     */   public int autoBackTime;
/*     */   public int autoBackMail;
/*     */   public int chatGiftSaveTime;
/*     */   public int chatGiftSaveNum;
/*     */   public int getMoneyMinLimit;
/*     */   public int getMoneyMaxLimit;
/*     */   public int gangChatGiftTips;
/*     */   public int gangDayGetNumLimt;
/*     */   public int groupDayGetNumLimt;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  49 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  54 */     String path = dir + "mzm.gsp.chat.confbean.ChatGiftConsts.xml";
/*     */     try
/*     */     {
/*  57 */       SAXReader reader = new SAXReader();
/*  58 */       org.dom4j.Document doc = reader.read(new File(path));
/*  59 */       Element root = doc.getRootElement();
/*  60 */       Map<String, Element> data = new java.util.HashMap();
/*  61 */       java.util.List<?> nodeList = root.elements();
/*  62 */       int len = nodeList.size();
/*  63 */       for (int i = 0; i < len; i++)
/*     */       {
/*  65 */         Element element = (Element)nodeList.get(i);
/*  66 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  69 */           String name = element.attributeValue("name");
/*  70 */           if (data.put(name, element) != null)
/*  71 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  74 */       this.needActiviteValue = Integer.valueOf(((Element)data.get("needActiviteValue")).attributeValue("value")).intValue();
/*  75 */       this.dayLimitNum = Integer.valueOf(((Element)data.get("dayLimitNum")).attributeValue("value")).intValue();
/*  76 */       this.defaultNum = Integer.valueOf(((Element)data.get("defaultNum")).attributeValue("value")).intValue();
/*  77 */       this.minNum = Integer.valueOf(((Element)data.get("minNum")).attributeValue("value")).intValue();
/*  78 */       this.maxNum = Integer.valueOf(((Element)data.get("maxNum")).attributeValue("value")).intValue();
/*  79 */       this.strLimitNum = Integer.valueOf(((Element)data.get("strLimitNum")).attributeValue("value")).intValue();
/*  80 */       this.autoBackTime = Integer.valueOf(((Element)data.get("autoBackTime")).attributeValue("value")).intValue();
/*  81 */       this.autoBackMail = Integer.valueOf(((Element)data.get("autoBackMail")).attributeValue("value")).intValue();
/*  82 */       this.chatGiftSaveTime = Integer.valueOf(((Element)data.get("chatGiftSaveTime")).attributeValue("value")).intValue();
/*  83 */       this.chatGiftSaveNum = Integer.valueOf(((Element)data.get("chatGiftSaveNum")).attributeValue("value")).intValue();
/*  84 */       this.getMoneyMinLimit = Integer.valueOf(((Element)data.get("getMoneyMinLimit")).attributeValue("value")).intValue();
/*  85 */       this.getMoneyMaxLimit = Integer.valueOf(((Element)data.get("getMoneyMaxLimit")).attributeValue("value")).intValue();
/*  86 */       this.gangChatGiftTips = Integer.valueOf(((Element)data.get("gangChatGiftTips")).attributeValue("value")).intValue();
/*  87 */       this.gangDayGetNumLimt = Integer.valueOf(((Element)data.get("gangDayGetNumLimt")).attributeValue("value")).intValue();
/*  88 */       this.groupDayGetNumLimt = Integer.valueOf(((Element)data.get("groupDayGetNumLimt")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  92 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  97 */     String path = dir + "mzm.gsp.chat.confbean.ChatGiftConsts.xml";
/*     */     try
/*     */     {
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       Map<String, Element> data = new java.util.HashMap();
/* 104 */       java.util.List<?> nodeList = root.elements();
/* 105 */       int len = nodeList.size();
/* 106 */       for (int i = 0; i < len; i++)
/*     */       {
/* 108 */         Element element = (Element)nodeList.get(i);
/* 109 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 112 */           String name = element.attributeValue("name");
/* 113 */           if (data.put(name, element) != null)
/* 114 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 117 */       this.needActiviteValue = Integer.valueOf(((Element)data.get("needActiviteValue")).attributeValue("value")).intValue();
/* 118 */       this.dayLimitNum = Integer.valueOf(((Element)data.get("dayLimitNum")).attributeValue("value")).intValue();
/* 119 */       this.defaultNum = Integer.valueOf(((Element)data.get("defaultNum")).attributeValue("value")).intValue();
/* 120 */       this.minNum = Integer.valueOf(((Element)data.get("minNum")).attributeValue("value")).intValue();
/* 121 */       this.maxNum = Integer.valueOf(((Element)data.get("maxNum")).attributeValue("value")).intValue();
/* 122 */       this.strLimitNum = Integer.valueOf(((Element)data.get("strLimitNum")).attributeValue("value")).intValue();
/* 123 */       this.autoBackTime = Integer.valueOf(((Element)data.get("autoBackTime")).attributeValue("value")).intValue();
/* 124 */       this.autoBackMail = Integer.valueOf(((Element)data.get("autoBackMail")).attributeValue("value")).intValue();
/* 125 */       this.chatGiftSaveTime = Integer.valueOf(((Element)data.get("chatGiftSaveTime")).attributeValue("value")).intValue();
/* 126 */       this.chatGiftSaveNum = Integer.valueOf(((Element)data.get("chatGiftSaveNum")).attributeValue("value")).intValue();
/* 127 */       this.getMoneyMinLimit = Integer.valueOf(((Element)data.get("getMoneyMinLimit")).attributeValue("value")).intValue();
/* 128 */       this.getMoneyMaxLimit = Integer.valueOf(((Element)data.get("getMoneyMaxLimit")).attributeValue("value")).intValue();
/* 129 */       this.gangChatGiftTips = Integer.valueOf(((Element)data.get("gangChatGiftTips")).attributeValue("value")).intValue();
/* 130 */       this.gangDayGetNumLimt = Integer.valueOf(((Element)data.get("gangDayGetNumLimt")).attributeValue("value")).intValue();
/* 131 */       this.groupDayGetNumLimt = Integer.valueOf(((Element)data.get("groupDayGetNumLimt")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 135 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 139 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 142 */     String path = dir + "mzm.gsp.chat.confbean.ChatGiftConsts.bny";
/*     */     try
/*     */     {
/* 145 */       File file = new File(path);
/* 146 */       if (file.exists())
/*     */       {
/* 148 */         byte[] bytes = new byte['Ѐ'];
/* 149 */         FileInputStream fis = new FileInputStream(file);
/* 150 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 151 */         int len = 0;
/* 152 */         while ((len = fis.read(bytes)) > 0)
/* 153 */           baos.write(bytes, 0, len);
/* 154 */         fis.close();
/* 155 */         bytes = baos.toByteArray();
/* 156 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 157 */         this.needActiviteValue = _os_.unmarshal_int();
/* 158 */         this.dayLimitNum = _os_.unmarshal_int();
/* 159 */         this.defaultNum = _os_.unmarshal_int();
/* 160 */         this.minNum = _os_.unmarshal_int();
/* 161 */         this.maxNum = _os_.unmarshal_int();
/* 162 */         this.strLimitNum = _os_.unmarshal_int();
/* 163 */         this.autoBackTime = _os_.unmarshal_int();
/* 164 */         this.autoBackMail = _os_.unmarshal_int();
/* 165 */         this.chatGiftSaveTime = _os_.unmarshal_int();
/* 166 */         this.chatGiftSaveNum = _os_.unmarshal_int();
/* 167 */         this.getMoneyMinLimit = _os_.unmarshal_int();
/* 168 */         this.getMoneyMaxLimit = _os_.unmarshal_int();
/* 169 */         this.gangChatGiftTips = _os_.unmarshal_int();
/* 170 */         this.gangDayGetNumLimt = _os_.unmarshal_int();
/* 171 */         this.groupDayGetNumLimt = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 182 */     String path = dir + "mzm.gsp.chat.confbean.ChatGiftConsts.bny";
/*     */     try
/*     */     {
/* 185 */       File file = new File(path);
/* 186 */       if (file.exists())
/*     */       {
/* 188 */         byte[] bytes = new byte['Ѐ'];
/* 189 */         FileInputStream fis = new FileInputStream(file);
/* 190 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 191 */         int len = 0;
/* 192 */         while ((len = fis.read(bytes)) > 0)
/* 193 */           baos.write(bytes, 0, len);
/* 194 */         fis.close();
/* 195 */         bytes = baos.toByteArray();
/* 196 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 197 */         this.needActiviteValue = _os_.unmarshal_int();
/* 198 */         this.dayLimitNum = _os_.unmarshal_int();
/* 199 */         this.defaultNum = _os_.unmarshal_int();
/* 200 */         this.minNum = _os_.unmarshal_int();
/* 201 */         this.maxNum = _os_.unmarshal_int();
/* 202 */         this.strLimitNum = _os_.unmarshal_int();
/* 203 */         this.autoBackTime = _os_.unmarshal_int();
/* 204 */         this.autoBackMail = _os_.unmarshal_int();
/* 205 */         this.chatGiftSaveTime = _os_.unmarshal_int();
/* 206 */         this.chatGiftSaveNum = _os_.unmarshal_int();
/* 207 */         this.getMoneyMinLimit = _os_.unmarshal_int();
/* 208 */         this.getMoneyMaxLimit = _os_.unmarshal_int();
/* 209 */         this.gangChatGiftTips = _os_.unmarshal_int();
/* 210 */         this.gangDayGetNumLimt = _os_.unmarshal_int();
/* 211 */         this.groupDayGetNumLimt = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 216 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(ChatGiftConsts newInstance)
/*     */   {
/* 222 */     oldInstance = instance;
/* 223 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 228 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\confbean\ChatGiftConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */