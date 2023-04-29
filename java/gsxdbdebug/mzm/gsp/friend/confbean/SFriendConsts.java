/*     */ package mzm.gsp.friend.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SFriendConsts
/*     */ {
/*  13 */   private static volatile SFriendConsts oldInstance = null;
/*     */   
/*  15 */   private static SFriendConsts instance = new SFriendConsts();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SFriendConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SFriendConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public int friendCountMax = 100;
/*  32 */   public int applyCountMax = 100;
/*  33 */   public int applyTimeMax = 72;
/*  34 */   public int valuePerbattle = 1;
/*  35 */   public int maxQinMiDu = 100000;
/*  36 */   public int validateWordsMax = 10;
/*  37 */   public int blackMax = 20;
/*  38 */   public int addFriendChatId = 0;
/*  39 */   public int recommandNum = 4;
/*  40 */   public int recomandLevelNum = 2;
/*  41 */   public int recomandLevel = 5;
/*  42 */   public int addFriendLvSet = 20;
/*     */   public int refuseBanDetermineDay;
/*     */   public int refuseBanThreshold;
/*     */   public int refuseBanHour;
/*     */   public int refuseBanDescriptionId;
/*     */   public int addFriendMaxLvDiffWithServer;
/*     */   public int ignoreGrcFriendLoginTimeThreshold;
/*     */   public int minLevelWarnAddFriendAutoBan;
/*     */   public int refuseCountWarnAddFriendAutoBan;
/*     */   public int friendRemarkNameMaxLength;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  55 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  60 */     String path = dir + "mzm.gsp.friend.confbean.SFriendConsts.xml";
/*     */     try
/*     */     {
/*  63 */       SAXReader reader = new SAXReader();
/*  64 */       org.dom4j.Document doc = reader.read(new File(path));
/*  65 */       Element root = doc.getRootElement();
/*  66 */       Map<String, Element> data = new java.util.HashMap();
/*  67 */       java.util.List<?> nodeList = root.elements();
/*  68 */       int len = nodeList.size();
/*  69 */       for (int i = 0; i < len; i++)
/*     */       {
/*  71 */         Element element = (Element)nodeList.get(i);
/*  72 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  75 */           String name = element.attributeValue("name");
/*  76 */           if (data.put(name, element) != null)
/*  77 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  80 */       this.friendCountMax = Integer.valueOf(((Element)data.get("friendCountMax")).attributeValue("value")).intValue();
/*  81 */       this.applyCountMax = Integer.valueOf(((Element)data.get("applyCountMax")).attributeValue("value")).intValue();
/*  82 */       this.applyTimeMax = Integer.valueOf(((Element)data.get("applyTimeMax")).attributeValue("value")).intValue();
/*  83 */       this.valuePerbattle = Integer.valueOf(((Element)data.get("valuePerbattle")).attributeValue("value")).intValue();
/*  84 */       this.maxQinMiDu = Integer.valueOf(((Element)data.get("maxQinMiDu")).attributeValue("value")).intValue();
/*  85 */       this.validateWordsMax = Integer.valueOf(((Element)data.get("validateWordsMax")).attributeValue("value")).intValue();
/*  86 */       this.blackMax = Integer.valueOf(((Element)data.get("blackMax")).attributeValue("value")).intValue();
/*  87 */       this.addFriendChatId = Integer.valueOf(((Element)data.get("addFriendChatId")).attributeValue("value")).intValue();
/*  88 */       this.recommandNum = Integer.valueOf(((Element)data.get("recommandNum")).attributeValue("value")).intValue();
/*  89 */       this.recomandLevelNum = Integer.valueOf(((Element)data.get("recomandLevelNum")).attributeValue("value")).intValue();
/*  90 */       this.recomandLevel = Integer.valueOf(((Element)data.get("recomandLevel")).attributeValue("value")).intValue();
/*  91 */       this.addFriendLvSet = Integer.valueOf(((Element)data.get("addFriendLvSet")).attributeValue("value")).intValue();
/*  92 */       this.refuseBanDetermineDay = Integer.valueOf(((Element)data.get("refuseBanDetermineDay")).attributeValue("value")).intValue();
/*  93 */       this.refuseBanThreshold = Integer.valueOf(((Element)data.get("refuseBanThreshold")).attributeValue("value")).intValue();
/*  94 */       this.refuseBanHour = Integer.valueOf(((Element)data.get("refuseBanHour")).attributeValue("value")).intValue();
/*  95 */       this.refuseBanDescriptionId = Integer.valueOf(((Element)data.get("refuseBanDescriptionId")).attributeValue("value")).intValue();
/*  96 */       this.addFriendMaxLvDiffWithServer = Integer.valueOf(((Element)data.get("addFriendMaxLvDiffWithServer")).attributeValue("value")).intValue();
/*  97 */       this.ignoreGrcFriendLoginTimeThreshold = Integer.valueOf(((Element)data.get("ignoreGrcFriendLoginTimeThreshold")).attributeValue("value")).intValue();
/*  98 */       this.minLevelWarnAddFriendAutoBan = Integer.valueOf(((Element)data.get("minLevelWarnAddFriendAutoBan")).attributeValue("value")).intValue();
/*  99 */       this.refuseCountWarnAddFriendAutoBan = Integer.valueOf(((Element)data.get("refuseCountWarnAddFriendAutoBan")).attributeValue("value")).intValue();
/* 100 */       this.friendRemarkNameMaxLength = Integer.valueOf(((Element)data.get("friendRemarkNameMaxLength")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 104 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 109 */     String path = dir + "mzm.gsp.friend.confbean.SFriendConsts.xml";
/*     */     try
/*     */     {
/* 112 */       SAXReader reader = new SAXReader();
/* 113 */       org.dom4j.Document doc = reader.read(new File(path));
/* 114 */       Element root = doc.getRootElement();
/* 115 */       Map<String, Element> data = new java.util.HashMap();
/* 116 */       java.util.List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element element = (Element)nodeList.get(i);
/* 121 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 124 */           String name = element.attributeValue("name");
/* 125 */           if (data.put(name, element) != null)
/* 126 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 129 */       this.friendCountMax = Integer.valueOf(((Element)data.get("friendCountMax")).attributeValue("value")).intValue();
/* 130 */       this.applyCountMax = Integer.valueOf(((Element)data.get("applyCountMax")).attributeValue("value")).intValue();
/* 131 */       this.applyTimeMax = Integer.valueOf(((Element)data.get("applyTimeMax")).attributeValue("value")).intValue();
/* 132 */       this.valuePerbattle = Integer.valueOf(((Element)data.get("valuePerbattle")).attributeValue("value")).intValue();
/* 133 */       this.maxQinMiDu = Integer.valueOf(((Element)data.get("maxQinMiDu")).attributeValue("value")).intValue();
/* 134 */       this.validateWordsMax = Integer.valueOf(((Element)data.get("validateWordsMax")).attributeValue("value")).intValue();
/* 135 */       this.blackMax = Integer.valueOf(((Element)data.get("blackMax")).attributeValue("value")).intValue();
/* 136 */       this.addFriendChatId = Integer.valueOf(((Element)data.get("addFriendChatId")).attributeValue("value")).intValue();
/* 137 */       this.recommandNum = Integer.valueOf(((Element)data.get("recommandNum")).attributeValue("value")).intValue();
/* 138 */       this.recomandLevelNum = Integer.valueOf(((Element)data.get("recomandLevelNum")).attributeValue("value")).intValue();
/* 139 */       this.recomandLevel = Integer.valueOf(((Element)data.get("recomandLevel")).attributeValue("value")).intValue();
/* 140 */       this.addFriendLvSet = Integer.valueOf(((Element)data.get("addFriendLvSet")).attributeValue("value")).intValue();
/* 141 */       this.refuseBanDetermineDay = Integer.valueOf(((Element)data.get("refuseBanDetermineDay")).attributeValue("value")).intValue();
/* 142 */       this.refuseBanThreshold = Integer.valueOf(((Element)data.get("refuseBanThreshold")).attributeValue("value")).intValue();
/* 143 */       this.refuseBanHour = Integer.valueOf(((Element)data.get("refuseBanHour")).attributeValue("value")).intValue();
/* 144 */       this.refuseBanDescriptionId = Integer.valueOf(((Element)data.get("refuseBanDescriptionId")).attributeValue("value")).intValue();
/* 145 */       this.addFriendMaxLvDiffWithServer = Integer.valueOf(((Element)data.get("addFriendMaxLvDiffWithServer")).attributeValue("value")).intValue();
/* 146 */       this.ignoreGrcFriendLoginTimeThreshold = Integer.valueOf(((Element)data.get("ignoreGrcFriendLoginTimeThreshold")).attributeValue("value")).intValue();
/* 147 */       this.minLevelWarnAddFriendAutoBan = Integer.valueOf(((Element)data.get("minLevelWarnAddFriendAutoBan")).attributeValue("value")).intValue();
/* 148 */       this.refuseCountWarnAddFriendAutoBan = Integer.valueOf(((Element)data.get("refuseCountWarnAddFriendAutoBan")).attributeValue("value")).intValue();
/* 149 */       this.friendRemarkNameMaxLength = Integer.valueOf(((Element)data.get("friendRemarkNameMaxLength")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 157 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 160 */     String path = dir + "mzm.gsp.friend.confbean.SFriendConsts.bny";
/*     */     try
/*     */     {
/* 163 */       File file = new File(path);
/* 164 */       if (file.exists())
/*     */       {
/* 166 */         byte[] bytes = new byte['Ѐ'];
/* 167 */         FileInputStream fis = new FileInputStream(file);
/* 168 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 169 */         int len = 0;
/* 170 */         while ((len = fis.read(bytes)) > 0)
/* 171 */           baos.write(bytes, 0, len);
/* 172 */         fis.close();
/* 173 */         bytes = baos.toByteArray();
/* 174 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 175 */         this.friendCountMax = _os_.unmarshal_int();
/* 176 */         this.applyCountMax = _os_.unmarshal_int();
/* 177 */         this.applyTimeMax = _os_.unmarshal_int();
/* 178 */         this.valuePerbattle = _os_.unmarshal_int();
/* 179 */         this.maxQinMiDu = _os_.unmarshal_int();
/* 180 */         this.validateWordsMax = _os_.unmarshal_int();
/* 181 */         this.blackMax = _os_.unmarshal_int();
/* 182 */         this.addFriendChatId = _os_.unmarshal_int();
/* 183 */         this.recommandNum = _os_.unmarshal_int();
/* 184 */         this.recomandLevelNum = _os_.unmarshal_int();
/* 185 */         this.recomandLevel = _os_.unmarshal_int();
/* 186 */         this.addFriendLvSet = _os_.unmarshal_int();
/* 187 */         this.refuseBanDetermineDay = _os_.unmarshal_int();
/* 188 */         this.refuseBanThreshold = _os_.unmarshal_int();
/* 189 */         this.refuseBanHour = _os_.unmarshal_int();
/* 190 */         this.refuseBanDescriptionId = _os_.unmarshal_int();
/* 191 */         this.addFriendMaxLvDiffWithServer = _os_.unmarshal_int();
/* 192 */         this.ignoreGrcFriendLoginTimeThreshold = _os_.unmarshal_int();
/* 193 */         this.minLevelWarnAddFriendAutoBan = _os_.unmarshal_int();
/* 194 */         this.refuseCountWarnAddFriendAutoBan = _os_.unmarshal_int();
/* 195 */         this.friendRemarkNameMaxLength = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 200 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 206 */     String path = dir + "mzm.gsp.friend.confbean.SFriendConsts.bny";
/*     */     try
/*     */     {
/* 209 */       File file = new File(path);
/* 210 */       if (file.exists())
/*     */       {
/* 212 */         byte[] bytes = new byte['Ѐ'];
/* 213 */         FileInputStream fis = new FileInputStream(file);
/* 214 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 215 */         int len = 0;
/* 216 */         while ((len = fis.read(bytes)) > 0)
/* 217 */           baos.write(bytes, 0, len);
/* 218 */         fis.close();
/* 219 */         bytes = baos.toByteArray();
/* 220 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 221 */         this.friendCountMax = _os_.unmarshal_int();
/* 222 */         this.applyCountMax = _os_.unmarshal_int();
/* 223 */         this.applyTimeMax = _os_.unmarshal_int();
/* 224 */         this.valuePerbattle = _os_.unmarshal_int();
/* 225 */         this.maxQinMiDu = _os_.unmarshal_int();
/* 226 */         this.validateWordsMax = _os_.unmarshal_int();
/* 227 */         this.blackMax = _os_.unmarshal_int();
/* 228 */         this.addFriendChatId = _os_.unmarshal_int();
/* 229 */         this.recommandNum = _os_.unmarshal_int();
/* 230 */         this.recomandLevelNum = _os_.unmarshal_int();
/* 231 */         this.recomandLevel = _os_.unmarshal_int();
/* 232 */         this.addFriendLvSet = _os_.unmarshal_int();
/* 233 */         this.refuseBanDetermineDay = _os_.unmarshal_int();
/* 234 */         this.refuseBanThreshold = _os_.unmarshal_int();
/* 235 */         this.refuseBanHour = _os_.unmarshal_int();
/* 236 */         this.refuseBanDescriptionId = _os_.unmarshal_int();
/* 237 */         this.addFriendMaxLvDiffWithServer = _os_.unmarshal_int();
/* 238 */         this.ignoreGrcFriendLoginTimeThreshold = _os_.unmarshal_int();
/* 239 */         this.minLevelWarnAddFriendAutoBan = _os_.unmarshal_int();
/* 240 */         this.refuseCountWarnAddFriendAutoBan = _os_.unmarshal_int();
/* 241 */         this.friendRemarkNameMaxLength = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SFriendConsts newInstance)
/*     */   {
/* 252 */     oldInstance = instance;
/* 253 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 258 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\confbean\SFriendConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */