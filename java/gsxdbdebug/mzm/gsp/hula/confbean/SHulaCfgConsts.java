/*     */ package mzm.gsp.hula.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SHulaCfgConsts
/*     */ {
/*  13 */   private static volatile SHulaCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static SHulaCfgConsts instance = new SHulaCfgConsts();
/*     */   public int ACTIVITY_ID;
/*     */   public int NPCID;
/*     */   public int NPC_SERVICE;
/*     */   public int PREPARE_MAP_ID;
/*     */   
/*     */   public static SHulaCfgConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SHulaCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int MAP_ID;
/*     */   
/*     */   public int PREPARE_MINUTES;
/*     */   
/*     */   public int EXP_RAIN_AWARD_ID;
/*     */   
/*     */   public int EXP_RAIN_INTERVAL_SECONDS;
/*     */   
/*     */   public int DOUDOU_STAY_MINUTES;
/*     */   public int DOUDOU_DELETE_MINUTES;
/*     */   public int KILL_POINT;
/*     */   public int KILL_AWARD_ID;
/*     */   public int CUT_POINT;
/*     */   public int MIN_DELETE_NUM;
/*     */   public int TOTAL_TURNS;
/*     */   public int MONSTER_COUNT_EVERY_TURN;
/*     */   public int DOUDOU_CAPACITY;
/*     */   public int NPC_CONTROLLER;
/*     */   public int EXIT_MAP_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  53 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  58 */     String path = dir + "mzm.gsp.hula.confbean.SHulaCfgConsts.xml";
/*     */     try
/*     */     {
/*  61 */       SAXReader reader = new SAXReader();
/*  62 */       org.dom4j.Document doc = reader.read(new File(path));
/*  63 */       Element root = doc.getRootElement();
/*  64 */       Map<String, Element> data = new java.util.HashMap();
/*  65 */       java.util.List<?> nodeList = root.elements();
/*  66 */       int len = nodeList.size();
/*  67 */       for (int i = 0; i < len; i++)
/*     */       {
/*  69 */         Element element = (Element)nodeList.get(i);
/*  70 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  73 */           String name = element.attributeValue("name");
/*  74 */           if (data.put(name, element) != null)
/*  75 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  78 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/*  79 */       this.NPCID = Integer.valueOf(((Element)data.get("NPCID")).attributeValue("value")).intValue();
/*  80 */       this.NPC_SERVICE = Integer.valueOf(((Element)data.get("NPC_SERVICE")).attributeValue("value")).intValue();
/*  81 */       this.PREPARE_MAP_ID = Integer.valueOf(((Element)data.get("PREPARE_MAP_ID")).attributeValue("value")).intValue();
/*  82 */       this.MAP_ID = Integer.valueOf(((Element)data.get("MAP_ID")).attributeValue("value")).intValue();
/*  83 */       this.PREPARE_MINUTES = Integer.valueOf(((Element)data.get("PREPARE_MINUTES")).attributeValue("value")).intValue();
/*  84 */       this.EXP_RAIN_AWARD_ID = Integer.valueOf(((Element)data.get("EXP_RAIN_AWARD_ID")).attributeValue("value")).intValue();
/*  85 */       this.EXP_RAIN_INTERVAL_SECONDS = Integer.valueOf(((Element)data.get("EXP_RAIN_INTERVAL_SECONDS")).attributeValue("value")).intValue();
/*  86 */       this.DOUDOU_STAY_MINUTES = Integer.valueOf(((Element)data.get("DOUDOU_STAY_MINUTES")).attributeValue("value")).intValue();
/*  87 */       this.DOUDOU_DELETE_MINUTES = Integer.valueOf(((Element)data.get("DOUDOU_DELETE_MINUTES")).attributeValue("value")).intValue();
/*  88 */       this.KILL_POINT = Integer.valueOf(((Element)data.get("KILL_POINT")).attributeValue("value")).intValue();
/*  89 */       this.KILL_AWARD_ID = Integer.valueOf(((Element)data.get("KILL_AWARD_ID")).attributeValue("value")).intValue();
/*  90 */       this.CUT_POINT = Integer.valueOf(((Element)data.get("CUT_POINT")).attributeValue("value")).intValue();
/*  91 */       this.MIN_DELETE_NUM = Integer.valueOf(((Element)data.get("MIN_DELETE_NUM")).attributeValue("value")).intValue();
/*  92 */       this.TOTAL_TURNS = Integer.valueOf(((Element)data.get("TOTAL_TURNS")).attributeValue("value")).intValue();
/*  93 */       this.MONSTER_COUNT_EVERY_TURN = Integer.valueOf(((Element)data.get("MONSTER_COUNT_EVERY_TURN")).attributeValue("value")).intValue();
/*  94 */       this.DOUDOU_CAPACITY = Integer.valueOf(((Element)data.get("DOUDOU_CAPACITY")).attributeValue("value")).intValue();
/*  95 */       this.NPC_CONTROLLER = Integer.valueOf(((Element)data.get("NPC_CONTROLLER")).attributeValue("value")).intValue();
/*  96 */       this.EXIT_MAP_ID = Integer.valueOf(((Element)data.get("EXIT_MAP_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 100 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/* 105 */     String path = dir + "mzm.gsp.hula.confbean.SHulaCfgConsts.xml";
/*     */     try
/*     */     {
/* 108 */       SAXReader reader = new SAXReader();
/* 109 */       org.dom4j.Document doc = reader.read(new File(path));
/* 110 */       Element root = doc.getRootElement();
/* 111 */       Map<String, Element> data = new java.util.HashMap();
/* 112 */       java.util.List<?> nodeList = root.elements();
/* 113 */       int len = nodeList.size();
/* 114 */       for (int i = 0; i < len; i++)
/*     */       {
/* 116 */         Element element = (Element)nodeList.get(i);
/* 117 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 120 */           String name = element.attributeValue("name");
/* 121 */           if (data.put(name, element) != null)
/* 122 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 125 */       this.ACTIVITY_ID = Integer.valueOf(((Element)data.get("ACTIVITY_ID")).attributeValue("value")).intValue();
/* 126 */       this.NPCID = Integer.valueOf(((Element)data.get("NPCID")).attributeValue("value")).intValue();
/* 127 */       this.NPC_SERVICE = Integer.valueOf(((Element)data.get("NPC_SERVICE")).attributeValue("value")).intValue();
/* 128 */       this.PREPARE_MAP_ID = Integer.valueOf(((Element)data.get("PREPARE_MAP_ID")).attributeValue("value")).intValue();
/* 129 */       this.MAP_ID = Integer.valueOf(((Element)data.get("MAP_ID")).attributeValue("value")).intValue();
/* 130 */       this.PREPARE_MINUTES = Integer.valueOf(((Element)data.get("PREPARE_MINUTES")).attributeValue("value")).intValue();
/* 131 */       this.EXP_RAIN_AWARD_ID = Integer.valueOf(((Element)data.get("EXP_RAIN_AWARD_ID")).attributeValue("value")).intValue();
/* 132 */       this.EXP_RAIN_INTERVAL_SECONDS = Integer.valueOf(((Element)data.get("EXP_RAIN_INTERVAL_SECONDS")).attributeValue("value")).intValue();
/* 133 */       this.DOUDOU_STAY_MINUTES = Integer.valueOf(((Element)data.get("DOUDOU_STAY_MINUTES")).attributeValue("value")).intValue();
/* 134 */       this.DOUDOU_DELETE_MINUTES = Integer.valueOf(((Element)data.get("DOUDOU_DELETE_MINUTES")).attributeValue("value")).intValue();
/* 135 */       this.KILL_POINT = Integer.valueOf(((Element)data.get("KILL_POINT")).attributeValue("value")).intValue();
/* 136 */       this.KILL_AWARD_ID = Integer.valueOf(((Element)data.get("KILL_AWARD_ID")).attributeValue("value")).intValue();
/* 137 */       this.CUT_POINT = Integer.valueOf(((Element)data.get("CUT_POINT")).attributeValue("value")).intValue();
/* 138 */       this.MIN_DELETE_NUM = Integer.valueOf(((Element)data.get("MIN_DELETE_NUM")).attributeValue("value")).intValue();
/* 139 */       this.TOTAL_TURNS = Integer.valueOf(((Element)data.get("TOTAL_TURNS")).attributeValue("value")).intValue();
/* 140 */       this.MONSTER_COUNT_EVERY_TURN = Integer.valueOf(((Element)data.get("MONSTER_COUNT_EVERY_TURN")).attributeValue("value")).intValue();
/* 141 */       this.DOUDOU_CAPACITY = Integer.valueOf(((Element)data.get("DOUDOU_CAPACITY")).attributeValue("value")).intValue();
/* 142 */       this.NPC_CONTROLLER = Integer.valueOf(((Element)data.get("NPC_CONTROLLER")).attributeValue("value")).intValue();
/* 143 */       this.EXIT_MAP_ID = Integer.valueOf(((Element)data.get("EXIT_MAP_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 147 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 151 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 154 */     String path = dir + "mzm.gsp.hula.confbean.SHulaCfgConsts.bny";
/*     */     try
/*     */     {
/* 157 */       File file = new File(path);
/* 158 */       if (file.exists())
/*     */       {
/* 160 */         byte[] bytes = new byte['Ѐ'];
/* 161 */         FileInputStream fis = new FileInputStream(file);
/* 162 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 163 */         int len = 0;
/* 164 */         while ((len = fis.read(bytes)) > 0)
/* 165 */           baos.write(bytes, 0, len);
/* 166 */         fis.close();
/* 167 */         bytes = baos.toByteArray();
/* 168 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 169 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 170 */         this.NPCID = _os_.unmarshal_int();
/* 171 */         this.NPC_SERVICE = _os_.unmarshal_int();
/* 172 */         this.PREPARE_MAP_ID = _os_.unmarshal_int();
/* 173 */         this.MAP_ID = _os_.unmarshal_int();
/* 174 */         this.PREPARE_MINUTES = _os_.unmarshal_int();
/* 175 */         this.EXP_RAIN_AWARD_ID = _os_.unmarshal_int();
/* 176 */         this.EXP_RAIN_INTERVAL_SECONDS = _os_.unmarshal_int();
/* 177 */         this.DOUDOU_STAY_MINUTES = _os_.unmarshal_int();
/* 178 */         this.DOUDOU_DELETE_MINUTES = _os_.unmarshal_int();
/* 179 */         this.KILL_POINT = _os_.unmarshal_int();
/* 180 */         this.KILL_AWARD_ID = _os_.unmarshal_int();
/* 181 */         this.CUT_POINT = _os_.unmarshal_int();
/* 182 */         this.MIN_DELETE_NUM = _os_.unmarshal_int();
/* 183 */         this.TOTAL_TURNS = _os_.unmarshal_int();
/* 184 */         this.MONSTER_COUNT_EVERY_TURN = _os_.unmarshal_int();
/* 185 */         this.DOUDOU_CAPACITY = _os_.unmarshal_int();
/* 186 */         this.NPC_CONTROLLER = _os_.unmarshal_int();
/* 187 */         this.EXIT_MAP_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 198 */     String path = dir + "mzm.gsp.hula.confbean.SHulaCfgConsts.bny";
/*     */     try
/*     */     {
/* 201 */       File file = new File(path);
/* 202 */       if (file.exists())
/*     */       {
/* 204 */         byte[] bytes = new byte['Ѐ'];
/* 205 */         FileInputStream fis = new FileInputStream(file);
/* 206 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 207 */         int len = 0;
/* 208 */         while ((len = fis.read(bytes)) > 0)
/* 209 */           baos.write(bytes, 0, len);
/* 210 */         fis.close();
/* 211 */         bytes = baos.toByteArray();
/* 212 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 213 */         this.ACTIVITY_ID = _os_.unmarshal_int();
/* 214 */         this.NPCID = _os_.unmarshal_int();
/* 215 */         this.NPC_SERVICE = _os_.unmarshal_int();
/* 216 */         this.PREPARE_MAP_ID = _os_.unmarshal_int();
/* 217 */         this.MAP_ID = _os_.unmarshal_int();
/* 218 */         this.PREPARE_MINUTES = _os_.unmarshal_int();
/* 219 */         this.EXP_RAIN_AWARD_ID = _os_.unmarshal_int();
/* 220 */         this.EXP_RAIN_INTERVAL_SECONDS = _os_.unmarshal_int();
/* 221 */         this.DOUDOU_STAY_MINUTES = _os_.unmarshal_int();
/* 222 */         this.DOUDOU_DELETE_MINUTES = _os_.unmarshal_int();
/* 223 */         this.KILL_POINT = _os_.unmarshal_int();
/* 224 */         this.KILL_AWARD_ID = _os_.unmarshal_int();
/* 225 */         this.CUT_POINT = _os_.unmarshal_int();
/* 226 */         this.MIN_DELETE_NUM = _os_.unmarshal_int();
/* 227 */         this.TOTAL_TURNS = _os_.unmarshal_int();
/* 228 */         this.MONSTER_COUNT_EVERY_TURN = _os_.unmarshal_int();
/* 229 */         this.DOUDOU_CAPACITY = _os_.unmarshal_int();
/* 230 */         this.NPC_CONTROLLER = _os_.unmarshal_int();
/* 231 */         this.EXIT_MAP_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 236 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SHulaCfgConsts newInstance)
/*     */   {
/* 242 */     oldInstance = instance;
/* 243 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 248 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\confbean\SHulaCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */