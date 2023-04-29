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
/*     */ public class SGangRaceConsts
/*     */ {
/*  13 */   private static volatile SGangRaceConsts oldInstance = null;
/*     */   
/*  15 */   private static SGangRaceConsts instance = new SGangRaceConsts();
/*     */   public int activity;
/*     */   public int npcid;
/*     */   public int voteTime;
/*     */   public int runTime;
/*     */   public int winAwardId;
/*     */   public int FailAwardId;
/*     */   
/*  23 */   public static SGangRaceConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static SGangRaceConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int winGoldRate;
/*     */   
/*     */   public int FailGoldRate;
/*     */   
/*     */   public int ExpAwardId;
/*     */   
/*     */   public int ExpSpanTime;
/*     */   
/*     */   public int ExpContinueTime;
/*     */   
/*     */   public int NpcControlId;
/*     */   
/*     */   public int npcid1;
/*     */   public int npcid2;
/*     */   public int npcid3;
/*     */   public int npcid4;
/*     */   public int npcid5;
/*     */   public int raceCount;
/*     */   public int winnerGoldRate;
/*     */   public int winnerMaxGold;
/*     */   public int mailFail1;
/*     */   public int mailWin1;
/*     */   public int mailFail2;
/*     */   public int mailWin2;
/*     */   public int mailWinner;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  59 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  64 */     String path = dir + "mzm.gsp.activity.confbean.SGangRaceConsts.xml";
/*     */     try
/*     */     {
/*  67 */       SAXReader reader = new SAXReader();
/*  68 */       org.dom4j.Document doc = reader.read(new File(path));
/*  69 */       Element root = doc.getRootElement();
/*  70 */       Map<String, Element> data = new java.util.HashMap();
/*  71 */       java.util.List<?> nodeList = root.elements();
/*  72 */       int len = nodeList.size();
/*  73 */       for (int i = 0; i < len; i++)
/*     */       {
/*  75 */         Element element = (Element)nodeList.get(i);
/*  76 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  79 */           String name = element.attributeValue("name");
/*  80 */           if (data.put(name, element) != null)
/*  81 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  84 */       this.activity = Integer.valueOf(((Element)data.get("activity")).attributeValue("value")).intValue();
/*  85 */       this.npcid = Integer.valueOf(((Element)data.get("npcid")).attributeValue("value")).intValue();
/*  86 */       this.voteTime = Integer.valueOf(((Element)data.get("voteTime")).attributeValue("value")).intValue();
/*  87 */       this.runTime = Integer.valueOf(((Element)data.get("runTime")).attributeValue("value")).intValue();
/*  88 */       this.winAwardId = Integer.valueOf(((Element)data.get("winAwardId")).attributeValue("value")).intValue();
/*  89 */       this.FailAwardId = Integer.valueOf(((Element)data.get("FailAwardId")).attributeValue("value")).intValue();
/*  90 */       this.winGoldRate = Integer.valueOf(((Element)data.get("winGoldRate")).attributeValue("value")).intValue();
/*  91 */       this.FailGoldRate = Integer.valueOf(((Element)data.get("FailGoldRate")).attributeValue("value")).intValue();
/*  92 */       this.ExpAwardId = Integer.valueOf(((Element)data.get("ExpAwardId")).attributeValue("value")).intValue();
/*  93 */       this.ExpSpanTime = Integer.valueOf(((Element)data.get("ExpSpanTime")).attributeValue("value")).intValue();
/*  94 */       this.ExpContinueTime = Integer.valueOf(((Element)data.get("ExpContinueTime")).attributeValue("value")).intValue();
/*  95 */       this.NpcControlId = Integer.valueOf(((Element)data.get("NpcControlId")).attributeValue("value")).intValue();
/*  96 */       this.npcid1 = Integer.valueOf(((Element)data.get("npcid1")).attributeValue("value")).intValue();
/*  97 */       this.npcid2 = Integer.valueOf(((Element)data.get("npcid2")).attributeValue("value")).intValue();
/*  98 */       this.npcid3 = Integer.valueOf(((Element)data.get("npcid3")).attributeValue("value")).intValue();
/*  99 */       this.npcid4 = Integer.valueOf(((Element)data.get("npcid4")).attributeValue("value")).intValue();
/* 100 */       this.npcid5 = Integer.valueOf(((Element)data.get("npcid5")).attributeValue("value")).intValue();
/* 101 */       this.raceCount = Integer.valueOf(((Element)data.get("raceCount")).attributeValue("value")).intValue();
/* 102 */       this.winnerGoldRate = Integer.valueOf(((Element)data.get("winnerGoldRate")).attributeValue("value")).intValue();
/* 103 */       this.winnerMaxGold = Integer.valueOf(((Element)data.get("winnerMaxGold")).attributeValue("value")).intValue();
/* 104 */       this.mailFail1 = Integer.valueOf(((Element)data.get("mailFail1")).attributeValue("value")).intValue();
/* 105 */       this.mailWin1 = Integer.valueOf(((Element)data.get("mailWin1")).attributeValue("value")).intValue();
/* 106 */       this.mailFail2 = Integer.valueOf(((Element)data.get("mailFail2")).attributeValue("value")).intValue();
/* 107 */       this.mailWin2 = Integer.valueOf(((Element)data.get("mailWin2")).attributeValue("value")).intValue();
/* 108 */       this.mailWinner = Integer.valueOf(((Element)data.get("mailWinner")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 112 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 117 */     String path = dir + "mzm.gsp.activity.confbean.SGangRaceConsts.xml";
/*     */     try
/*     */     {
/* 120 */       SAXReader reader = new SAXReader();
/* 121 */       org.dom4j.Document doc = reader.read(new File(path));
/* 122 */       Element root = doc.getRootElement();
/* 123 */       Map<String, Element> data = new java.util.HashMap();
/* 124 */       java.util.List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element element = (Element)nodeList.get(i);
/* 129 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 132 */           String name = element.attributeValue("name");
/* 133 */           if (data.put(name, element) != null)
/* 134 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 137 */       this.activity = Integer.valueOf(((Element)data.get("activity")).attributeValue("value")).intValue();
/* 138 */       this.npcid = Integer.valueOf(((Element)data.get("npcid")).attributeValue("value")).intValue();
/* 139 */       this.voteTime = Integer.valueOf(((Element)data.get("voteTime")).attributeValue("value")).intValue();
/* 140 */       this.runTime = Integer.valueOf(((Element)data.get("runTime")).attributeValue("value")).intValue();
/* 141 */       this.winAwardId = Integer.valueOf(((Element)data.get("winAwardId")).attributeValue("value")).intValue();
/* 142 */       this.FailAwardId = Integer.valueOf(((Element)data.get("FailAwardId")).attributeValue("value")).intValue();
/* 143 */       this.winGoldRate = Integer.valueOf(((Element)data.get("winGoldRate")).attributeValue("value")).intValue();
/* 144 */       this.FailGoldRate = Integer.valueOf(((Element)data.get("FailGoldRate")).attributeValue("value")).intValue();
/* 145 */       this.ExpAwardId = Integer.valueOf(((Element)data.get("ExpAwardId")).attributeValue("value")).intValue();
/* 146 */       this.ExpSpanTime = Integer.valueOf(((Element)data.get("ExpSpanTime")).attributeValue("value")).intValue();
/* 147 */       this.ExpContinueTime = Integer.valueOf(((Element)data.get("ExpContinueTime")).attributeValue("value")).intValue();
/* 148 */       this.NpcControlId = Integer.valueOf(((Element)data.get("NpcControlId")).attributeValue("value")).intValue();
/* 149 */       this.npcid1 = Integer.valueOf(((Element)data.get("npcid1")).attributeValue("value")).intValue();
/* 150 */       this.npcid2 = Integer.valueOf(((Element)data.get("npcid2")).attributeValue("value")).intValue();
/* 151 */       this.npcid3 = Integer.valueOf(((Element)data.get("npcid3")).attributeValue("value")).intValue();
/* 152 */       this.npcid4 = Integer.valueOf(((Element)data.get("npcid4")).attributeValue("value")).intValue();
/* 153 */       this.npcid5 = Integer.valueOf(((Element)data.get("npcid5")).attributeValue("value")).intValue();
/* 154 */       this.raceCount = Integer.valueOf(((Element)data.get("raceCount")).attributeValue("value")).intValue();
/* 155 */       this.winnerGoldRate = Integer.valueOf(((Element)data.get("winnerGoldRate")).attributeValue("value")).intValue();
/* 156 */       this.winnerMaxGold = Integer.valueOf(((Element)data.get("winnerMaxGold")).attributeValue("value")).intValue();
/* 157 */       this.mailFail1 = Integer.valueOf(((Element)data.get("mailFail1")).attributeValue("value")).intValue();
/* 158 */       this.mailWin1 = Integer.valueOf(((Element)data.get("mailWin1")).attributeValue("value")).intValue();
/* 159 */       this.mailFail2 = Integer.valueOf(((Element)data.get("mailFail2")).attributeValue("value")).intValue();
/* 160 */       this.mailWin2 = Integer.valueOf(((Element)data.get("mailWin2")).attributeValue("value")).intValue();
/* 161 */       this.mailWinner = Integer.valueOf(((Element)data.get("mailWinner")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 165 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 169 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 172 */     String path = dir + "mzm.gsp.activity.confbean.SGangRaceConsts.bny";
/*     */     try
/*     */     {
/* 175 */       File file = new File(path);
/* 176 */       if (file.exists())
/*     */       {
/* 178 */         byte[] bytes = new byte['Ѐ'];
/* 179 */         FileInputStream fis = new FileInputStream(file);
/* 180 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 181 */         int len = 0;
/* 182 */         while ((len = fis.read(bytes)) > 0)
/* 183 */           baos.write(bytes, 0, len);
/* 184 */         fis.close();
/* 185 */         bytes = baos.toByteArray();
/* 186 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 187 */         this.activity = _os_.unmarshal_int();
/* 188 */         this.npcid = _os_.unmarshal_int();
/* 189 */         this.voteTime = _os_.unmarshal_int();
/* 190 */         this.runTime = _os_.unmarshal_int();
/* 191 */         this.winAwardId = _os_.unmarshal_int();
/* 192 */         this.FailAwardId = _os_.unmarshal_int();
/* 193 */         this.winGoldRate = _os_.unmarshal_int();
/* 194 */         this.FailGoldRate = _os_.unmarshal_int();
/* 195 */         this.ExpAwardId = _os_.unmarshal_int();
/* 196 */         this.ExpSpanTime = _os_.unmarshal_int();
/* 197 */         this.ExpContinueTime = _os_.unmarshal_int();
/* 198 */         this.NpcControlId = _os_.unmarshal_int();
/* 199 */         this.npcid1 = _os_.unmarshal_int();
/* 200 */         this.npcid2 = _os_.unmarshal_int();
/* 201 */         this.npcid3 = _os_.unmarshal_int();
/* 202 */         this.npcid4 = _os_.unmarshal_int();
/* 203 */         this.npcid5 = _os_.unmarshal_int();
/* 204 */         this.raceCount = _os_.unmarshal_int();
/* 205 */         this.winnerGoldRate = _os_.unmarshal_int();
/* 206 */         this.winnerMaxGold = _os_.unmarshal_int();
/* 207 */         this.mailFail1 = _os_.unmarshal_int();
/* 208 */         this.mailWin1 = _os_.unmarshal_int();
/* 209 */         this.mailFail2 = _os_.unmarshal_int();
/* 210 */         this.mailWin2 = _os_.unmarshal_int();
/* 211 */         this.mailWinner = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 216 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 222 */     String path = dir + "mzm.gsp.activity.confbean.SGangRaceConsts.bny";
/*     */     try
/*     */     {
/* 225 */       File file = new File(path);
/* 226 */       if (file.exists())
/*     */       {
/* 228 */         byte[] bytes = new byte['Ѐ'];
/* 229 */         FileInputStream fis = new FileInputStream(file);
/* 230 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 231 */         int len = 0;
/* 232 */         while ((len = fis.read(bytes)) > 0)
/* 233 */           baos.write(bytes, 0, len);
/* 234 */         fis.close();
/* 235 */         bytes = baos.toByteArray();
/* 236 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 237 */         this.activity = _os_.unmarshal_int();
/* 238 */         this.npcid = _os_.unmarshal_int();
/* 239 */         this.voteTime = _os_.unmarshal_int();
/* 240 */         this.runTime = _os_.unmarshal_int();
/* 241 */         this.winAwardId = _os_.unmarshal_int();
/* 242 */         this.FailAwardId = _os_.unmarshal_int();
/* 243 */         this.winGoldRate = _os_.unmarshal_int();
/* 244 */         this.FailGoldRate = _os_.unmarshal_int();
/* 245 */         this.ExpAwardId = _os_.unmarshal_int();
/* 246 */         this.ExpSpanTime = _os_.unmarshal_int();
/* 247 */         this.ExpContinueTime = _os_.unmarshal_int();
/* 248 */         this.NpcControlId = _os_.unmarshal_int();
/* 249 */         this.npcid1 = _os_.unmarshal_int();
/* 250 */         this.npcid2 = _os_.unmarshal_int();
/* 251 */         this.npcid3 = _os_.unmarshal_int();
/* 252 */         this.npcid4 = _os_.unmarshal_int();
/* 253 */         this.npcid5 = _os_.unmarshal_int();
/* 254 */         this.raceCount = _os_.unmarshal_int();
/* 255 */         this.winnerGoldRate = _os_.unmarshal_int();
/* 256 */         this.winnerMaxGold = _os_.unmarshal_int();
/* 257 */         this.mailFail1 = _os_.unmarshal_int();
/* 258 */         this.mailWin1 = _os_.unmarshal_int();
/* 259 */         this.mailFail2 = _os_.unmarshal_int();
/* 260 */         this.mailWin2 = _os_.unmarshal_int();
/* 261 */         this.mailWinner = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 266 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SGangRaceConsts newInstance)
/*     */   {
/* 272 */     oldInstance = instance;
/* 273 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 278 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\SGangRaceConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */