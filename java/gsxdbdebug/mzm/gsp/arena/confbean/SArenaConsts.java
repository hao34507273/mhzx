/*     */ package mzm.gsp.arena.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SArenaConsts
/*     */ {
/*  13 */   private static volatile SArenaConsts oldInstance = null;
/*     */   
/*  15 */   private static SArenaConsts instance = new SArenaConsts();
/*     */   public int Activityid;
/*     */   public int ControllerIn;
/*     */   public int ActivityMap;
/*     */   public int LeaveMap;
/*     */   public int PrepareAward;
/*     */   
/*     */   public static SArenaConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SArenaConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int PrepareAwardMinutes;
/*     */   
/*     */   public int InitScore;
/*     */   
/*     */   public int InitActionPoint;
/*     */   
/*     */   public int DeductActionPointWhenLose;
/*     */   
/*     */   public int WinAward;
/*     */   public int LoseAward;
/*  42 */   public java.util.ArrayList<SWinTimesAward> WinTimesAwardList = new java.util.ArrayList();
/*     */   public int ELO_K;
/*     */   public int ChartPageSize;
/*     */   public int ChartCapacity;
/*     */   public int MatchInterval;
/*     */   public int TopNumber;
/*     */   public int TopAppellation;
/*     */   public int TopMail;
/*     */   public int WinCampAward;
/*     */   public int PrepareStageMinutes;
/*     */   public int Match1StageMinutes;
/*     */   public int ShutdownMatchBeforeEndMinutes;
/*     */   public int EarlyEndMail;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  58 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  63 */     String path = dir + "mzm.gsp.arena.confbean.SArenaConsts.xml";
/*     */     try
/*     */     {
/*  66 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  67 */       org.dom4j.Document doc = reader.read(new File(path));
/*  68 */       Element root = doc.getRootElement();
/*  69 */       Map<String, Element> data = new java.util.HashMap();
/*  70 */       List<?> nodeList = root.elements();
/*  71 */       int len = nodeList.size();
/*  72 */       for (int i = 0; i < len; i++)
/*     */       {
/*  74 */         Element element = (Element)nodeList.get(i);
/*  75 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  78 */           String name = element.attributeValue("name");
/*  79 */           if (data.put(name, element) != null)
/*  80 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  83 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/*  84 */       this.ControllerIn = Integer.valueOf(((Element)data.get("ControllerIn")).attributeValue("value")).intValue();
/*  85 */       this.ActivityMap = Integer.valueOf(((Element)data.get("ActivityMap")).attributeValue("value")).intValue();
/*  86 */       this.LeaveMap = Integer.valueOf(((Element)data.get("LeaveMap")).attributeValue("value")).intValue();
/*  87 */       this.PrepareAward = Integer.valueOf(((Element)data.get("PrepareAward")).attributeValue("value")).intValue();
/*  88 */       this.PrepareAwardMinutes = Integer.valueOf(((Element)data.get("PrepareAwardMinutes")).attributeValue("value")).intValue();
/*  89 */       this.InitScore = Integer.valueOf(((Element)data.get("InitScore")).attributeValue("value")).intValue();
/*  90 */       this.InitActionPoint = Integer.valueOf(((Element)data.get("InitActionPoint")).attributeValue("value")).intValue();
/*  91 */       this.DeductActionPointWhenLose = Integer.valueOf(((Element)data.get("DeductActionPointWhenLose")).attributeValue("value")).intValue();
/*  92 */       this.WinAward = Integer.valueOf(((Element)data.get("WinAward")).attributeValue("value")).intValue();
/*  93 */       this.LoseAward = Integer.valueOf(((Element)data.get("LoseAward")).attributeValue("value")).intValue();
/*     */       
/*  95 */       Element collectionElement = (Element)data.get("WinTimesAwardList");
/*  96 */       if (collectionElement == null)
/*     */       {
/*  98 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 101 */       List<?> _nodeList = collectionElement.elements();
/* 102 */       int _len = _nodeList.size();
/* 103 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 105 */         Element elem = (Element)_nodeList.get(i);
/* 106 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.arena.confbean.SWinTimesAward"))
/*     */         {
/*     */           SWinTimesAward _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 113 */             _v_ = new SWinTimesAward();
/* 114 */             _v_.loadFromXml(elem);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 121 */           this.WinTimesAwardList.add(_v_);
/*     */         }
/*     */       }
/* 124 */       this.ELO_K = Integer.valueOf(((Element)data.get("ELO_K")).attributeValue("value")).intValue();
/* 125 */       this.ChartPageSize = Integer.valueOf(((Element)data.get("ChartPageSize")).attributeValue("value")).intValue();
/* 126 */       this.ChartCapacity = Integer.valueOf(((Element)data.get("ChartCapacity")).attributeValue("value")).intValue();
/* 127 */       this.MatchInterval = Integer.valueOf(((Element)data.get("MatchInterval")).attributeValue("value")).intValue();
/* 128 */       this.TopNumber = Integer.valueOf(((Element)data.get("TopNumber")).attributeValue("value")).intValue();
/* 129 */       this.TopAppellation = Integer.valueOf(((Element)data.get("TopAppellation")).attributeValue("value")).intValue();
/* 130 */       this.TopMail = Integer.valueOf(((Element)data.get("TopMail")).attributeValue("value")).intValue();
/* 131 */       this.WinCampAward = Integer.valueOf(((Element)data.get("WinCampAward")).attributeValue("value")).intValue();
/* 132 */       this.PrepareStageMinutes = Integer.valueOf(((Element)data.get("PrepareStageMinutes")).attributeValue("value")).intValue();
/* 133 */       this.Match1StageMinutes = Integer.valueOf(((Element)data.get("Match1StageMinutes")).attributeValue("value")).intValue();
/* 134 */       this.ShutdownMatchBeforeEndMinutes = Integer.valueOf(((Element)data.get("ShutdownMatchBeforeEndMinutes")).attributeValue("value")).intValue();
/* 135 */       this.EarlyEndMail = Integer.valueOf(((Element)data.get("EarlyEndMail")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 139 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 144 */     String path = dir + "mzm.gsp.arena.confbean.SArenaConsts.xml";
/*     */     try
/*     */     {
/* 147 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 148 */       org.dom4j.Document doc = reader.read(new File(path));
/* 149 */       Element root = doc.getRootElement();
/* 150 */       Map<String, Element> data = new java.util.HashMap();
/* 151 */       List<?> nodeList = root.elements();
/* 152 */       int len = nodeList.size();
/* 153 */       for (int i = 0; i < len; i++)
/*     */       {
/* 155 */         Element element = (Element)nodeList.get(i);
/* 156 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 159 */           String name = element.attributeValue("name");
/* 160 */           if (data.put(name, element) != null)
/* 161 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 164 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/* 165 */       this.ControllerIn = Integer.valueOf(((Element)data.get("ControllerIn")).attributeValue("value")).intValue();
/* 166 */       this.ActivityMap = Integer.valueOf(((Element)data.get("ActivityMap")).attributeValue("value")).intValue();
/* 167 */       this.LeaveMap = Integer.valueOf(((Element)data.get("LeaveMap")).attributeValue("value")).intValue();
/* 168 */       this.PrepareAward = Integer.valueOf(((Element)data.get("PrepareAward")).attributeValue("value")).intValue();
/* 169 */       this.PrepareAwardMinutes = Integer.valueOf(((Element)data.get("PrepareAwardMinutes")).attributeValue("value")).intValue();
/* 170 */       this.InitScore = Integer.valueOf(((Element)data.get("InitScore")).attributeValue("value")).intValue();
/* 171 */       this.InitActionPoint = Integer.valueOf(((Element)data.get("InitActionPoint")).attributeValue("value")).intValue();
/* 172 */       this.DeductActionPointWhenLose = Integer.valueOf(((Element)data.get("DeductActionPointWhenLose")).attributeValue("value")).intValue();
/* 173 */       this.WinAward = Integer.valueOf(((Element)data.get("WinAward")).attributeValue("value")).intValue();
/* 174 */       this.LoseAward = Integer.valueOf(((Element)data.get("LoseAward")).attributeValue("value")).intValue();
/*     */       
/* 176 */       Element collectionElement = (Element)data.get("WinTimesAwardList");
/* 177 */       if (collectionElement == null)
/*     */       {
/* 179 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 182 */       List<?> _nodeList = collectionElement.elements();
/* 183 */       int _len = _nodeList.size();
/* 184 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 186 */         Element elem = (Element)_nodeList.get(i);
/* 187 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.arena.confbean.SWinTimesAward"))
/*     */         {
/*     */           SWinTimesAward _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 194 */             _v_ = new SWinTimesAward();
/* 195 */             _v_.loadFromXml(elem);
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 202 */           this.WinTimesAwardList.add(_v_);
/*     */         }
/*     */       }
/* 205 */       this.ELO_K = Integer.valueOf(((Element)data.get("ELO_K")).attributeValue("value")).intValue();
/* 206 */       this.ChartPageSize = Integer.valueOf(((Element)data.get("ChartPageSize")).attributeValue("value")).intValue();
/* 207 */       this.ChartCapacity = Integer.valueOf(((Element)data.get("ChartCapacity")).attributeValue("value")).intValue();
/* 208 */       this.MatchInterval = Integer.valueOf(((Element)data.get("MatchInterval")).attributeValue("value")).intValue();
/* 209 */       this.TopNumber = Integer.valueOf(((Element)data.get("TopNumber")).attributeValue("value")).intValue();
/* 210 */       this.TopAppellation = Integer.valueOf(((Element)data.get("TopAppellation")).attributeValue("value")).intValue();
/* 211 */       this.TopMail = Integer.valueOf(((Element)data.get("TopMail")).attributeValue("value")).intValue();
/* 212 */       this.WinCampAward = Integer.valueOf(((Element)data.get("WinCampAward")).attributeValue("value")).intValue();
/* 213 */       this.PrepareStageMinutes = Integer.valueOf(((Element)data.get("PrepareStageMinutes")).attributeValue("value")).intValue();
/* 214 */       this.Match1StageMinutes = Integer.valueOf(((Element)data.get("Match1StageMinutes")).attributeValue("value")).intValue();
/* 215 */       this.ShutdownMatchBeforeEndMinutes = Integer.valueOf(((Element)data.get("ShutdownMatchBeforeEndMinutes")).attributeValue("value")).intValue();
/* 216 */       this.EarlyEndMail = Integer.valueOf(((Element)data.get("EarlyEndMail")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 220 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 224 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 227 */     String path = dir + "mzm.gsp.arena.confbean.SArenaConsts.bny";
/*     */     try
/*     */     {
/* 230 */       File file = new File(path);
/* 231 */       if (file.exists())
/*     */       {
/* 233 */         byte[] bytes = new byte['Ѐ'];
/* 234 */         FileInputStream fis = new FileInputStream(file);
/* 235 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 236 */         int len = 0;
/* 237 */         while ((len = fis.read(bytes)) > 0)
/* 238 */           baos.write(bytes, 0, len);
/* 239 */         fis.close();
/* 240 */         bytes = baos.toByteArray();
/* 241 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 242 */         this.Activityid = _os_.unmarshal_int();
/* 243 */         this.ControllerIn = _os_.unmarshal_int();
/* 244 */         this.ActivityMap = _os_.unmarshal_int();
/* 245 */         this.LeaveMap = _os_.unmarshal_int();
/* 246 */         this.PrepareAward = _os_.unmarshal_int();
/* 247 */         this.PrepareAwardMinutes = _os_.unmarshal_int();
/* 248 */         this.InitScore = _os_.unmarshal_int();
/* 249 */         this.InitActionPoint = _os_.unmarshal_int();
/* 250 */         this.DeductActionPointWhenLose = _os_.unmarshal_int();
/* 251 */         this.WinAward = _os_.unmarshal_int();
/* 252 */         this.LoseAward = _os_.unmarshal_int();
/* 253 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 256 */           SWinTimesAward _v_ = new SWinTimesAward();
/* 257 */           _v_.unmarshal(_os_);
/* 258 */           this.WinTimesAwardList.add(_v_);
/*     */         }
/* 260 */         this.ELO_K = _os_.unmarshal_int();
/* 261 */         this.ChartPageSize = _os_.unmarshal_int();
/* 262 */         this.ChartCapacity = _os_.unmarshal_int();
/* 263 */         this.MatchInterval = _os_.unmarshal_int();
/* 264 */         this.TopNumber = _os_.unmarshal_int();
/* 265 */         this.TopAppellation = _os_.unmarshal_int();
/* 266 */         this.TopMail = _os_.unmarshal_int();
/* 267 */         this.WinCampAward = _os_.unmarshal_int();
/* 268 */         this.PrepareStageMinutes = _os_.unmarshal_int();
/* 269 */         this.Match1StageMinutes = _os_.unmarshal_int();
/* 270 */         this.ShutdownMatchBeforeEndMinutes = _os_.unmarshal_int();
/* 271 */         this.EarlyEndMail = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 276 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 282 */     String path = dir + "mzm.gsp.arena.confbean.SArenaConsts.bny";
/*     */     try
/*     */     {
/* 285 */       File file = new File(path);
/* 286 */       if (file.exists())
/*     */       {
/* 288 */         byte[] bytes = new byte['Ѐ'];
/* 289 */         FileInputStream fis = new FileInputStream(file);
/* 290 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 291 */         int len = 0;
/* 292 */         while ((len = fis.read(bytes)) > 0)
/* 293 */           baos.write(bytes, 0, len);
/* 294 */         fis.close();
/* 295 */         bytes = baos.toByteArray();
/* 296 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 297 */         this.Activityid = _os_.unmarshal_int();
/* 298 */         this.ControllerIn = _os_.unmarshal_int();
/* 299 */         this.ActivityMap = _os_.unmarshal_int();
/* 300 */         this.LeaveMap = _os_.unmarshal_int();
/* 301 */         this.PrepareAward = _os_.unmarshal_int();
/* 302 */         this.PrepareAwardMinutes = _os_.unmarshal_int();
/* 303 */         this.InitScore = _os_.unmarshal_int();
/* 304 */         this.InitActionPoint = _os_.unmarshal_int();
/* 305 */         this.DeductActionPointWhenLose = _os_.unmarshal_int();
/* 306 */         this.WinAward = _os_.unmarshal_int();
/* 307 */         this.LoseAward = _os_.unmarshal_int();
/* 308 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 311 */           SWinTimesAward _v_ = new SWinTimesAward();
/* 312 */           _v_.unmarshal(_os_);
/* 313 */           this.WinTimesAwardList.add(_v_);
/*     */         }
/* 315 */         this.ELO_K = _os_.unmarshal_int();
/* 316 */         this.ChartPageSize = _os_.unmarshal_int();
/* 317 */         this.ChartCapacity = _os_.unmarshal_int();
/* 318 */         this.MatchInterval = _os_.unmarshal_int();
/* 319 */         this.TopNumber = _os_.unmarshal_int();
/* 320 */         this.TopAppellation = _os_.unmarshal_int();
/* 321 */         this.TopMail = _os_.unmarshal_int();
/* 322 */         this.WinCampAward = _os_.unmarshal_int();
/* 323 */         this.PrepareStageMinutes = _os_.unmarshal_int();
/* 324 */         this.Match1StageMinutes = _os_.unmarshal_int();
/* 325 */         this.ShutdownMatchBeforeEndMinutes = _os_.unmarshal_int();
/* 326 */         this.EarlyEndMail = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 331 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SArenaConsts newInstance)
/*     */   {
/* 337 */     oldInstance = instance;
/* 338 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 343 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\confbean\SArenaConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */