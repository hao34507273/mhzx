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
/*     */ public class SSurpriseActionCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSurpriseActionCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSurpriseActionCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int surpriseType;
/*     */   public int activityId;
/*     */   public int joinLevel;
/*     */   public int joinServerLevel;
/*     */   public int needServerLevelTime;
/*     */   public int actionId;
/*     */   public int refreshTime;
/*     */   public int mapId;
/*     */   public int positionX;
/*     */   public int positionY;
/*     */   public int redius;
/*     */   public int graphId;
/*     */   public int graphFinishCount;
/*     */   public String clue;
/*     */   public String titleDes;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  37 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  38 */     this.surpriseType = Integer.valueOf(rootElement.attributeValue("surpriseType")).intValue();
/*  39 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  40 */     this.joinLevel = Integer.valueOf(rootElement.attributeValue("joinLevel")).intValue();
/*  41 */     this.joinServerLevel = Integer.valueOf(rootElement.attributeValue("joinServerLevel")).intValue();
/*  42 */     this.needServerLevelTime = Integer.valueOf(rootElement.attributeValue("needServerLevelTime")).intValue();
/*  43 */     this.actionId = Integer.valueOf(rootElement.attributeValue("actionId")).intValue();
/*  44 */     this.refreshTime = Integer.valueOf(rootElement.attributeValue("refreshTime")).intValue();
/*  45 */     this.mapId = Integer.valueOf(rootElement.attributeValue("mapId")).intValue();
/*  46 */     this.positionX = Integer.valueOf(rootElement.attributeValue("positionX")).intValue();
/*  47 */     this.positionY = Integer.valueOf(rootElement.attributeValue("positionY")).intValue();
/*  48 */     this.redius = Integer.valueOf(rootElement.attributeValue("redius")).intValue();
/*  49 */     this.graphId = Integer.valueOf(rootElement.attributeValue("graphId")).intValue();
/*  50 */     this.graphFinishCount = Integer.valueOf(rootElement.attributeValue("graphFinishCount")).intValue();
/*  51 */     this.clue = rootElement.attributeValue("clue");
/*  52 */     this.titleDes = rootElement.attributeValue("titleDes");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  57 */     _os_.marshal(this.id);
/*  58 */     _os_.marshal(this.surpriseType);
/*  59 */     _os_.marshal(this.activityId);
/*  60 */     _os_.marshal(this.joinLevel);
/*  61 */     _os_.marshal(this.joinServerLevel);
/*  62 */     _os_.marshal(this.needServerLevelTime);
/*  63 */     _os_.marshal(this.actionId);
/*  64 */     _os_.marshal(this.refreshTime);
/*  65 */     _os_.marshal(this.mapId);
/*  66 */     _os_.marshal(this.positionX);
/*  67 */     _os_.marshal(this.positionY);
/*  68 */     _os_.marshal(this.redius);
/*  69 */     _os_.marshal(this.graphId);
/*  70 */     _os_.marshal(this.graphFinishCount);
/*  71 */     _os_.marshal(this.clue, "UTF-8");
/*  72 */     _os_.marshal(this.titleDes, "UTF-8");
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  78 */     this.id = _os_.unmarshal_int();
/*  79 */     this.surpriseType = _os_.unmarshal_int();
/*  80 */     this.activityId = _os_.unmarshal_int();
/*  81 */     this.joinLevel = _os_.unmarshal_int();
/*  82 */     this.joinServerLevel = _os_.unmarshal_int();
/*  83 */     this.needServerLevelTime = _os_.unmarshal_int();
/*  84 */     this.actionId = _os_.unmarshal_int();
/*  85 */     this.refreshTime = _os_.unmarshal_int();
/*  86 */     this.mapId = _os_.unmarshal_int();
/*  87 */     this.positionX = _os_.unmarshal_int();
/*  88 */     this.positionY = _os_.unmarshal_int();
/*  89 */     this.redius = _os_.unmarshal_int();
/*  90 */     this.graphId = _os_.unmarshal_int();
/*  91 */     this.graphFinishCount = _os_.unmarshal_int();
/*  92 */     this.clue = _os_.unmarshal_String("UTF-8");
/*  93 */     this.titleDes = _os_.unmarshal_String("UTF-8");
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  99 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseActionCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 103 */       all = new java.util.HashMap();
/* 104 */       SAXReader reader = new SAXReader();
/* 105 */       org.dom4j.Document doc = reader.read(new File(path));
/* 106 */       Element root = doc.getRootElement();
/* 107 */       List<?> nodeList = root.elements();
/* 108 */       int len = nodeList.size();
/* 109 */       for (int i = 0; i < len; i++)
/*     */       {
/* 111 */         Element elem = (Element)nodeList.get(i);
/* 112 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SSurpriseActionCfg"))
/*     */         {
/*     */ 
/* 115 */           SSurpriseActionCfg obj = new SSurpriseActionCfg();
/* 116 */           obj.loadFromXml(elem);
/* 117 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 118 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 123 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSurpriseActionCfg> all)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseActionCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 133 */       SAXReader reader = new SAXReader();
/* 134 */       org.dom4j.Document doc = reader.read(new File(path));
/* 135 */       Element root = doc.getRootElement();
/* 136 */       List<?> nodeList = root.elements();
/* 137 */       int len = nodeList.size();
/* 138 */       for (int i = 0; i < len; i++)
/*     */       {
/* 140 */         Element elem = (Element)nodeList.get(i);
/* 141 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SSurpriseActionCfg"))
/*     */         {
/*     */ 
/* 144 */           SSurpriseActionCfg obj = new SSurpriseActionCfg();
/* 145 */           obj.loadFromXml(elem);
/* 146 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 147 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 158 */     all = new java.util.HashMap();
/*     */     
/* 160 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseActionCfg.bny";
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
/* 175 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 177 */           _os_.unmarshal_int();
/* 178 */           _os_.unmarshal_int();
/* 179 */           _os_.unmarshal_int();
/*     */         }
/* 181 */         _os_.unmarshal_int();
/* 182 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 185 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 187 */           SSurpriseActionCfg _v_ = new SSurpriseActionCfg();
/* 188 */           _v_.unmarshal(_os_);
/* 189 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 190 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 195 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 200 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSurpriseActionCfg> all)
/*     */   {
/* 207 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseActionCfg.bny";
/*     */     try
/*     */     {
/* 210 */       File file = new File(path);
/* 211 */       if (file.exists())
/*     */       {
/* 213 */         byte[] bytes = new byte['Ѐ'];
/* 214 */         FileInputStream fis = new FileInputStream(file);
/* 215 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 216 */         int len = 0;
/* 217 */         while ((len = fis.read(bytes)) > 0)
/* 218 */           baos.write(bytes, 0, len);
/* 219 */         fis.close();
/* 220 */         bytes = baos.toByteArray();
/* 221 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 222 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 224 */           _os_.unmarshal_int();
/* 225 */           _os_.unmarshal_int();
/* 226 */           _os_.unmarshal_int();
/*     */         }
/* 228 */         _os_.unmarshal_int();
/* 229 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 232 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 234 */           SSurpriseActionCfg _v_ = new SSurpriseActionCfg();
/* 235 */           _v_.unmarshal(_os_);
/* 236 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 237 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 242 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 247 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SSurpriseActionCfg getOld(int key)
/*     */   {
/* 255 */     return (SSurpriseActionCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSurpriseActionCfg get(int key)
/*     */   {
/* 260 */     return (SSurpriseActionCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSurpriseActionCfg> getOldAll()
/*     */   {
/* 265 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSurpriseActionCfg> getAll()
/*     */   {
/* 270 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSurpriseActionCfg> newAll)
/*     */   {
/* 275 */     oldAll = all;
/* 276 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 281 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SSurpriseActionCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */