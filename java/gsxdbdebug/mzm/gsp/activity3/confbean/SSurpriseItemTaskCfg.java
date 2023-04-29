/*     */ package mzm.gsp.activity3.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SSurpriseItemTaskCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSurpriseItemTaskCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSurpriseItemTaskCfg> all = null;
/*     */   
/*     */   public int serverId;
/*     */   public int surpriseType;
/*     */   public int activityId;
/*     */   public int joinLevel;
/*     */   public int joinServerLevel;
/*     */   public int needServerLevelTime;
/*     */   public int npcId;
/*     */   public int npcControllerId;
/*     */   public int graphId;
/*     */   public int finishCount;
/*     */   public boolean isTakeAway;
/*     */   public int itemConId;
/*     */   public int itemType;
/*     */   public String clue;
/*     */   public String titleDes;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  36 */     this.serverId = Integer.valueOf(rootElement.attributeValue("serverId")).intValue();
/*  37 */     this.surpriseType = Integer.valueOf(rootElement.attributeValue("surpriseType")).intValue();
/*  38 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  39 */     this.joinLevel = Integer.valueOf(rootElement.attributeValue("joinLevel")).intValue();
/*  40 */     this.joinServerLevel = Integer.valueOf(rootElement.attributeValue("joinServerLevel")).intValue();
/*  41 */     this.needServerLevelTime = Integer.valueOf(rootElement.attributeValue("needServerLevelTime")).intValue();
/*  42 */     this.npcId = Integer.valueOf(rootElement.attributeValue("npcId")).intValue();
/*  43 */     this.npcControllerId = Integer.valueOf(rootElement.attributeValue("npcControllerId")).intValue();
/*  44 */     this.graphId = Integer.valueOf(rootElement.attributeValue("graphId")).intValue();
/*  45 */     this.finishCount = Integer.valueOf(rootElement.attributeValue("finishCount")).intValue();
/*  46 */     this.isTakeAway = Boolean.valueOf(rootElement.attributeValue("isTakeAway")).booleanValue();
/*  47 */     this.itemConId = Integer.valueOf(rootElement.attributeValue("itemConId")).intValue();
/*  48 */     this.itemType = Integer.valueOf(rootElement.attributeValue("itemType")).intValue();
/*  49 */     this.clue = rootElement.attributeValue("clue");
/*  50 */     this.titleDes = rootElement.attributeValue("titleDes");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  55 */     _os_.marshal(this.serverId);
/*  56 */     _os_.marshal(this.surpriseType);
/*  57 */     _os_.marshal(this.activityId);
/*  58 */     _os_.marshal(this.joinLevel);
/*  59 */     _os_.marshal(this.joinServerLevel);
/*  60 */     _os_.marshal(this.needServerLevelTime);
/*  61 */     _os_.marshal(this.npcId);
/*  62 */     _os_.marshal(this.npcControllerId);
/*  63 */     _os_.marshal(this.graphId);
/*  64 */     _os_.marshal(this.finishCount);
/*  65 */     _os_.marshal(this.isTakeAway);
/*  66 */     _os_.marshal(this.itemConId);
/*  67 */     _os_.marshal(this.itemType);
/*  68 */     _os_.marshal(this.clue, "UTF-8");
/*  69 */     _os_.marshal(this.titleDes, "UTF-8");
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     this.serverId = _os_.unmarshal_int();
/*  76 */     this.surpriseType = _os_.unmarshal_int();
/*  77 */     this.activityId = _os_.unmarshal_int();
/*  78 */     this.joinLevel = _os_.unmarshal_int();
/*  79 */     this.joinServerLevel = _os_.unmarshal_int();
/*  80 */     this.needServerLevelTime = _os_.unmarshal_int();
/*  81 */     this.npcId = _os_.unmarshal_int();
/*  82 */     this.npcControllerId = _os_.unmarshal_int();
/*  83 */     this.graphId = _os_.unmarshal_int();
/*  84 */     this.finishCount = _os_.unmarshal_int();
/*  85 */     this.isTakeAway = _os_.unmarshal_boolean();
/*  86 */     this.itemConId = _os_.unmarshal_int();
/*  87 */     this.itemType = _os_.unmarshal_int();
/*  88 */     this.clue = _os_.unmarshal_String("UTF-8");
/*  89 */     this.titleDes = _os_.unmarshal_String("UTF-8");
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  95 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseItemTaskCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  99 */       all = new java.util.HashMap();
/* 100 */       SAXReader reader = new SAXReader();
/* 101 */       org.dom4j.Document doc = reader.read(new File(path));
/* 102 */       Element root = doc.getRootElement();
/* 103 */       List<?> nodeList = root.elements();
/* 104 */       int len = nodeList.size();
/* 105 */       for (int i = 0; i < len; i++)
/*     */       {
/* 107 */         Element elem = (Element)nodeList.get(i);
/* 108 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SSurpriseItemTaskCfg"))
/*     */         {
/*     */ 
/* 111 */           SSurpriseItemTaskCfg obj = new SSurpriseItemTaskCfg();
/* 112 */           obj.loadFromXml(elem);
/* 113 */           if (all.put(Integer.valueOf(obj.serverId), obj) != null) {
/* 114 */             throw new RuntimeException("duplicate key : " + obj.serverId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 119 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSurpriseItemTaskCfg> all)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseItemTaskCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       SAXReader reader = new SAXReader();
/* 130 */       org.dom4j.Document doc = reader.read(new File(path));
/* 131 */       Element root = doc.getRootElement();
/* 132 */       List<?> nodeList = root.elements();
/* 133 */       int len = nodeList.size();
/* 134 */       for (int i = 0; i < len; i++)
/*     */       {
/* 136 */         Element elem = (Element)nodeList.get(i);
/* 137 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SSurpriseItemTaskCfg"))
/*     */         {
/*     */ 
/* 140 */           SSurpriseItemTaskCfg obj = new SSurpriseItemTaskCfg();
/* 141 */           obj.loadFromXml(elem);
/* 142 */           if (all.put(Integer.valueOf(obj.serverId), obj) != null) {
/* 143 */             throw new RuntimeException("duplicate key : " + obj.serverId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 154 */     all = new java.util.HashMap();
/*     */     
/* 156 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseItemTaskCfg.bny";
/*     */     try
/*     */     {
/* 159 */       File file = new File(path);
/* 160 */       if (file.exists())
/*     */       {
/* 162 */         byte[] bytes = new byte['Ѐ'];
/* 163 */         FileInputStream fis = new FileInputStream(file);
/* 164 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 165 */         int len = 0;
/* 166 */         while ((len = fis.read(bytes)) > 0)
/* 167 */           baos.write(bytes, 0, len);
/* 168 */         fis.close();
/* 169 */         bytes = baos.toByteArray();
/* 170 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 171 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 173 */           _os_.unmarshal_int();
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/*     */         }
/* 177 */         _os_.unmarshal_int();
/* 178 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 181 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 183 */           SSurpriseItemTaskCfg _v_ = new SSurpriseItemTaskCfg();
/* 184 */           _v_.unmarshal(_os_);
/* 185 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 186 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 191 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSurpriseItemTaskCfg> all)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseItemTaskCfg.bny";
/*     */     try
/*     */     {
/* 206 */       File file = new File(path);
/* 207 */       if (file.exists())
/*     */       {
/* 209 */         byte[] bytes = new byte['Ѐ'];
/* 210 */         FileInputStream fis = new FileInputStream(file);
/* 211 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 212 */         int len = 0;
/* 213 */         while ((len = fis.read(bytes)) > 0)
/* 214 */           baos.write(bytes, 0, len);
/* 215 */         fis.close();
/* 216 */         bytes = baos.toByteArray();
/* 217 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/* 222 */           _os_.unmarshal_int();
/*     */         }
/* 224 */         _os_.unmarshal_int();
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 228 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 230 */           SSurpriseItemTaskCfg _v_ = new SSurpriseItemTaskCfg();
/* 231 */           _v_.unmarshal(_os_);
/* 232 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 233 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 238 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 243 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SSurpriseItemTaskCfg getOld(int key)
/*     */   {
/* 251 */     return (SSurpriseItemTaskCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSurpriseItemTaskCfg get(int key)
/*     */   {
/* 256 */     return (SSurpriseItemTaskCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSurpriseItemTaskCfg> getOldAll()
/*     */   {
/* 261 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSurpriseItemTaskCfg> getAll()
/*     */   {
/* 266 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSurpriseItemTaskCfg> newAll)
/*     */   {
/* 271 */     oldAll = all;
/* 272 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 277 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SSurpriseItemTaskCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */