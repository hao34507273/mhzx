/*     */ package mzm.gsp.menpaipvp.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SMenpaiPVPConsts
/*     */ {
/*  13 */   private static volatile SMenpaiPVPConsts oldInstance = null;
/*     */   
/*  15 */   private static SMenpaiPVPConsts instance = new SMenpaiPVPConsts();
/*     */   public int Activityid;
/*     */   public int ControllerIn;
/*     */   public int PrepareAward;
/*     */   public int PrepareAwardMinutes;
/*     */   public int WinAward;
/*     */   public int LoseAward;
/*     */   
/*  23 */   public static SMenpaiPVPConsts getOldInstance() { return oldInstance; }
/*     */   
/*     */ 
/*     */   public static SMenpaiPVPConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int LoseTimes;
/*     */   
/*     */   public int InitPoint;
/*     */   
/*     */   public int ELO_K;
/*     */   
/*     */   public int ChartPageSize;
/*     */   
/*     */   public int ChartCapacity;
/*     */   
/*     */   public int LeaveMap;
/*     */   public int MatchInterval;
/*  44 */   public java.util.ArrayList<Integer> TopMails = new java.util.ArrayList();
/*     */   public int PrepareStageMinutes;
/*     */   public int ShutdownMatchBeforeEndMinutes;
/*     */   public int ChampionBadge;
/*     */   public int FightTimesAward;
/*     */   public int AwardNeedFightTimes;
/*     */   public int DelayResultSeconds;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  54 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  59 */     String path = dir + "mzm.gsp.menpaipvp.confbean.SMenpaiPVPConsts.xml";
/*     */     try
/*     */     {
/*  62 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/*  63 */       org.dom4j.Document doc = reader.read(new File(path));
/*  64 */       Element root = doc.getRootElement();
/*  65 */       Map<String, Element> data = new java.util.HashMap();
/*  66 */       List<?> nodeList = root.elements();
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
/*  79 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/*  80 */       this.ControllerIn = Integer.valueOf(((Element)data.get("ControllerIn")).attributeValue("value")).intValue();
/*  81 */       this.PrepareAward = Integer.valueOf(((Element)data.get("PrepareAward")).attributeValue("value")).intValue();
/*  82 */       this.PrepareAwardMinutes = Integer.valueOf(((Element)data.get("PrepareAwardMinutes")).attributeValue("value")).intValue();
/*  83 */       this.WinAward = Integer.valueOf(((Element)data.get("WinAward")).attributeValue("value")).intValue();
/*  84 */       this.LoseAward = Integer.valueOf(((Element)data.get("LoseAward")).attributeValue("value")).intValue();
/*  85 */       this.LoseTimes = Integer.valueOf(((Element)data.get("LoseTimes")).attributeValue("value")).intValue();
/*  86 */       this.InitPoint = Integer.valueOf(((Element)data.get("InitPoint")).attributeValue("value")).intValue();
/*  87 */       this.ELO_K = Integer.valueOf(((Element)data.get("ELO_K")).attributeValue("value")).intValue();
/*  88 */       this.ChartPageSize = Integer.valueOf(((Element)data.get("ChartPageSize")).attributeValue("value")).intValue();
/*  89 */       this.ChartCapacity = Integer.valueOf(((Element)data.get("ChartCapacity")).attributeValue("value")).intValue();
/*  90 */       this.LeaveMap = Integer.valueOf(((Element)data.get("LeaveMap")).attributeValue("value")).intValue();
/*  91 */       this.MatchInterval = Integer.valueOf(((Element)data.get("MatchInterval")).attributeValue("value")).intValue();
/*     */       
/*  93 */       Element collectionElement = (Element)data.get("TopMails");
/*  94 */       if (collectionElement == null)
/*     */       {
/*  96 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/*  99 */       List<?> _nodeList = collectionElement.elements();
/* 100 */       int _len = _nodeList.size();
/* 101 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 103 */         Element elem = (Element)_nodeList.get(i);
/* 104 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 111 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 118 */           this.TopMails.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 121 */       this.PrepareStageMinutes = Integer.valueOf(((Element)data.get("PrepareStageMinutes")).attributeValue("value")).intValue();
/* 122 */       this.ShutdownMatchBeforeEndMinutes = Integer.valueOf(((Element)data.get("ShutdownMatchBeforeEndMinutes")).attributeValue("value")).intValue();
/* 123 */       this.ChampionBadge = Integer.valueOf(((Element)data.get("ChampionBadge")).attributeValue("value")).intValue();
/* 124 */       this.FightTimesAward = Integer.valueOf(((Element)data.get("FightTimesAward")).attributeValue("value")).intValue();
/* 125 */       this.AwardNeedFightTimes = Integer.valueOf(((Element)data.get("AwardNeedFightTimes")).attributeValue("value")).intValue();
/* 126 */       this.DelayResultSeconds = Integer.valueOf(((Element)data.get("DelayResultSeconds")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 130 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 135 */     String path = dir + "mzm.gsp.menpaipvp.confbean.SMenpaiPVPConsts.xml";
/*     */     try
/*     */     {
/* 138 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 139 */       org.dom4j.Document doc = reader.read(new File(path));
/* 140 */       Element root = doc.getRootElement();
/* 141 */       Map<String, Element> data = new java.util.HashMap();
/* 142 */       List<?> nodeList = root.elements();
/* 143 */       int len = nodeList.size();
/* 144 */       for (int i = 0; i < len; i++)
/*     */       {
/* 146 */         Element element = (Element)nodeList.get(i);
/* 147 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 150 */           String name = element.attributeValue("name");
/* 151 */           if (data.put(name, element) != null)
/* 152 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 155 */       this.Activityid = Integer.valueOf(((Element)data.get("Activityid")).attributeValue("value")).intValue();
/* 156 */       this.ControllerIn = Integer.valueOf(((Element)data.get("ControllerIn")).attributeValue("value")).intValue();
/* 157 */       this.PrepareAward = Integer.valueOf(((Element)data.get("PrepareAward")).attributeValue("value")).intValue();
/* 158 */       this.PrepareAwardMinutes = Integer.valueOf(((Element)data.get("PrepareAwardMinutes")).attributeValue("value")).intValue();
/* 159 */       this.WinAward = Integer.valueOf(((Element)data.get("WinAward")).attributeValue("value")).intValue();
/* 160 */       this.LoseAward = Integer.valueOf(((Element)data.get("LoseAward")).attributeValue("value")).intValue();
/* 161 */       this.LoseTimes = Integer.valueOf(((Element)data.get("LoseTimes")).attributeValue("value")).intValue();
/* 162 */       this.InitPoint = Integer.valueOf(((Element)data.get("InitPoint")).attributeValue("value")).intValue();
/* 163 */       this.ELO_K = Integer.valueOf(((Element)data.get("ELO_K")).attributeValue("value")).intValue();
/* 164 */       this.ChartPageSize = Integer.valueOf(((Element)data.get("ChartPageSize")).attributeValue("value")).intValue();
/* 165 */       this.ChartCapacity = Integer.valueOf(((Element)data.get("ChartCapacity")).attributeValue("value")).intValue();
/* 166 */       this.LeaveMap = Integer.valueOf(((Element)data.get("LeaveMap")).attributeValue("value")).intValue();
/* 167 */       this.MatchInterval = Integer.valueOf(((Element)data.get("MatchInterval")).attributeValue("value")).intValue();
/*     */       
/* 169 */       Element collectionElement = (Element)data.get("TopMails");
/* 170 */       if (collectionElement == null)
/*     */       {
/* 172 */         throw new RuntimeException("collection type element does not find");
/*     */       }
/*     */       
/* 175 */       List<?> _nodeList = collectionElement.elements();
/* 176 */       int _len = _nodeList.size();
/* 177 */       for (int i = 0; i < _len; i++)
/*     */       {
/* 179 */         Element elem = (Element)_nodeList.get(i);
/* 180 */         if (elem.getName().equalsIgnoreCase("int"))
/*     */         {
/*     */           int _v_;
/*     */           
/*     */ 
/*     */           try
/*     */           {
/* 187 */             _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/*     */             continue;
/*     */           }
/*     */           
/* 194 */           this.TopMails.add(Integer.valueOf(_v_));
/*     */         }
/*     */       }
/* 197 */       this.PrepareStageMinutes = Integer.valueOf(((Element)data.get("PrepareStageMinutes")).attributeValue("value")).intValue();
/* 198 */       this.ShutdownMatchBeforeEndMinutes = Integer.valueOf(((Element)data.get("ShutdownMatchBeforeEndMinutes")).attributeValue("value")).intValue();
/* 199 */       this.ChampionBadge = Integer.valueOf(((Element)data.get("ChampionBadge")).attributeValue("value")).intValue();
/* 200 */       this.FightTimesAward = Integer.valueOf(((Element)data.get("FightTimesAward")).attributeValue("value")).intValue();
/* 201 */       this.AwardNeedFightTimes = Integer.valueOf(((Element)data.get("AwardNeedFightTimes")).attributeValue("value")).intValue();
/* 202 */       this.DelayResultSeconds = Integer.valueOf(((Element)data.get("DelayResultSeconds")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 206 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 210 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 213 */     String path = dir + "mzm.gsp.menpaipvp.confbean.SMenpaiPVPConsts.bny";
/*     */     try
/*     */     {
/* 216 */       File file = new File(path);
/* 217 */       if (file.exists())
/*     */       {
/* 219 */         byte[] bytes = new byte['Ѐ'];
/* 220 */         FileInputStream fis = new FileInputStream(file);
/* 221 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 222 */         int len = 0;
/* 223 */         while ((len = fis.read(bytes)) > 0)
/* 224 */           baos.write(bytes, 0, len);
/* 225 */         fis.close();
/* 226 */         bytes = baos.toByteArray();
/* 227 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 228 */         this.Activityid = _os_.unmarshal_int();
/* 229 */         this.ControllerIn = _os_.unmarshal_int();
/* 230 */         this.PrepareAward = _os_.unmarshal_int();
/* 231 */         this.PrepareAwardMinutes = _os_.unmarshal_int();
/* 232 */         this.WinAward = _os_.unmarshal_int();
/* 233 */         this.LoseAward = _os_.unmarshal_int();
/* 234 */         this.LoseTimes = _os_.unmarshal_int();
/* 235 */         this.InitPoint = _os_.unmarshal_int();
/* 236 */         this.ELO_K = _os_.unmarshal_int();
/* 237 */         this.ChartPageSize = _os_.unmarshal_int();
/* 238 */         this.ChartCapacity = _os_.unmarshal_int();
/* 239 */         this.LeaveMap = _os_.unmarshal_int();
/* 240 */         this.MatchInterval = _os_.unmarshal_int();
/* 241 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 244 */           int _v_ = _os_.unmarshal_int();
/* 245 */           this.TopMails.add(Integer.valueOf(_v_));
/*     */         }
/* 247 */         this.PrepareStageMinutes = _os_.unmarshal_int();
/* 248 */         this.ShutdownMatchBeforeEndMinutes = _os_.unmarshal_int();
/* 249 */         this.ChampionBadge = _os_.unmarshal_int();
/* 250 */         this.FightTimesAward = _os_.unmarshal_int();
/* 251 */         this.AwardNeedFightTimes = _os_.unmarshal_int();
/* 252 */         this.DelayResultSeconds = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 257 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 263 */     String path = dir + "mzm.gsp.menpaipvp.confbean.SMenpaiPVPConsts.bny";
/*     */     try
/*     */     {
/* 266 */       File file = new File(path);
/* 267 */       if (file.exists())
/*     */       {
/* 269 */         byte[] bytes = new byte['Ѐ'];
/* 270 */         FileInputStream fis = new FileInputStream(file);
/* 271 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 272 */         int len = 0;
/* 273 */         while ((len = fis.read(bytes)) > 0)
/* 274 */           baos.write(bytes, 0, len);
/* 275 */         fis.close();
/* 276 */         bytes = baos.toByteArray();
/* 277 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 278 */         this.Activityid = _os_.unmarshal_int();
/* 279 */         this.ControllerIn = _os_.unmarshal_int();
/* 280 */         this.PrepareAward = _os_.unmarshal_int();
/* 281 */         this.PrepareAwardMinutes = _os_.unmarshal_int();
/* 282 */         this.WinAward = _os_.unmarshal_int();
/* 283 */         this.LoseAward = _os_.unmarshal_int();
/* 284 */         this.LoseTimes = _os_.unmarshal_int();
/* 285 */         this.InitPoint = _os_.unmarshal_int();
/* 286 */         this.ELO_K = _os_.unmarshal_int();
/* 287 */         this.ChartPageSize = _os_.unmarshal_int();
/* 288 */         this.ChartCapacity = _os_.unmarshal_int();
/* 289 */         this.LeaveMap = _os_.unmarshal_int();
/* 290 */         this.MatchInterval = _os_.unmarshal_int();
/* 291 */         for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */         {
/*     */ 
/* 294 */           int _v_ = _os_.unmarshal_int();
/* 295 */           this.TopMails.add(Integer.valueOf(_v_));
/*     */         }
/* 297 */         this.PrepareStageMinutes = _os_.unmarshal_int();
/* 298 */         this.ShutdownMatchBeforeEndMinutes = _os_.unmarshal_int();
/* 299 */         this.ChampionBadge = _os_.unmarshal_int();
/* 300 */         this.FightTimesAward = _os_.unmarshal_int();
/* 301 */         this.AwardNeedFightTimes = _os_.unmarshal_int();
/* 302 */         this.DelayResultSeconds = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 307 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SMenpaiPVPConsts newInstance)
/*     */   {
/* 313 */     oldInstance = instance;
/* 314 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 319 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\confbean\SMenpaiPVPConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */