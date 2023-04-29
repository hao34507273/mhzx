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
/*     */ public class SSurpriseAchievementCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSurpriseAchievementCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSurpriseAchievementCfg> all = null;
/*     */   
/*     */   public int achievementId;
/*     */   public int id;
/*     */   public int surpriseType;
/*     */   public int activityId;
/*     */   public int joinLevel;
/*     */   public int joinServerLevel;
/*     */   public int needServerLevelTime;
/*     */   public int graphId;
/*     */   public int graphFinishCount;
/*     */   public String clue;
/*     */   public String titleDes;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.achievementId = Integer.valueOf(rootElement.attributeValue("achievementId")).intValue();
/*  33 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  34 */     this.surpriseType = Integer.valueOf(rootElement.attributeValue("surpriseType")).intValue();
/*  35 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  36 */     this.joinLevel = Integer.valueOf(rootElement.attributeValue("joinLevel")).intValue();
/*  37 */     this.joinServerLevel = Integer.valueOf(rootElement.attributeValue("joinServerLevel")).intValue();
/*  38 */     this.needServerLevelTime = Integer.valueOf(rootElement.attributeValue("needServerLevelTime")).intValue();
/*  39 */     this.graphId = Integer.valueOf(rootElement.attributeValue("graphId")).intValue();
/*  40 */     this.graphFinishCount = Integer.valueOf(rootElement.attributeValue("graphFinishCount")).intValue();
/*  41 */     this.clue = rootElement.attributeValue("clue");
/*  42 */     this.titleDes = rootElement.attributeValue("titleDes");
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.achievementId);
/*  48 */     _os_.marshal(this.id);
/*  49 */     _os_.marshal(this.surpriseType);
/*  50 */     _os_.marshal(this.activityId);
/*  51 */     _os_.marshal(this.joinLevel);
/*  52 */     _os_.marshal(this.joinServerLevel);
/*  53 */     _os_.marshal(this.needServerLevelTime);
/*  54 */     _os_.marshal(this.graphId);
/*  55 */     _os_.marshal(this.graphFinishCount);
/*  56 */     _os_.marshal(this.clue, "UTF-8");
/*  57 */     _os_.marshal(this.titleDes, "UTF-8");
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.achievementId = _os_.unmarshal_int();
/*  64 */     this.id = _os_.unmarshal_int();
/*  65 */     this.surpriseType = _os_.unmarshal_int();
/*  66 */     this.activityId = _os_.unmarshal_int();
/*  67 */     this.joinLevel = _os_.unmarshal_int();
/*  68 */     this.joinServerLevel = _os_.unmarshal_int();
/*  69 */     this.needServerLevelTime = _os_.unmarshal_int();
/*  70 */     this.graphId = _os_.unmarshal_int();
/*  71 */     this.graphFinishCount = _os_.unmarshal_int();
/*  72 */     this.clue = _os_.unmarshal_String("UTF-8");
/*  73 */     this.titleDes = _os_.unmarshal_String("UTF-8");
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseAchievementCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       all = new java.util.HashMap();
/*  84 */       SAXReader reader = new SAXReader();
/*  85 */       org.dom4j.Document doc = reader.read(new File(path));
/*  86 */       Element root = doc.getRootElement();
/*  87 */       List<?> nodeList = root.elements();
/*  88 */       int len = nodeList.size();
/*  89 */       for (int i = 0; i < len; i++)
/*     */       {
/*  91 */         Element elem = (Element)nodeList.get(i);
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SSurpriseAchievementCfg"))
/*     */         {
/*     */ 
/*  95 */           SSurpriseAchievementCfg obj = new SSurpriseAchievementCfg();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.achievementId), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.achievementId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSurpriseAchievementCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseAchievementCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 113 */       SAXReader reader = new SAXReader();
/* 114 */       org.dom4j.Document doc = reader.read(new File(path));
/* 115 */       Element root = doc.getRootElement();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SSurpriseAchievementCfg"))
/*     */         {
/*     */ 
/* 124 */           SSurpriseAchievementCfg obj = new SSurpriseAchievementCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.achievementId), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.achievementId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 138 */     all = new java.util.HashMap();
/*     */     
/* 140 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseAchievementCfg.bny";
/*     */     try
/*     */     {
/* 143 */       File file = new File(path);
/* 144 */       if (file.exists())
/*     */       {
/* 146 */         byte[] bytes = new byte['Ѐ'];
/* 147 */         FileInputStream fis = new FileInputStream(file);
/* 148 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 149 */         int len = 0;
/* 150 */         while ((len = fis.read(bytes)) > 0)
/* 151 */           baos.write(bytes, 0, len);
/* 152 */         fis.close();
/* 153 */         bytes = baos.toByteArray();
/* 154 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 155 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 157 */           _os_.unmarshal_int();
/* 158 */           _os_.unmarshal_int();
/* 159 */           _os_.unmarshal_int();
/*     */         }
/* 161 */         _os_.unmarshal_int();
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 165 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 167 */           SSurpriseAchievementCfg _v_ = new SSurpriseAchievementCfg();
/* 168 */           _v_.unmarshal(_os_);
/* 169 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 170 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 175 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSurpriseAchievementCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.activity3.confbean.SSurpriseAchievementCfg.bny";
/*     */     try
/*     */     {
/* 190 */       File file = new File(path);
/* 191 */       if (file.exists())
/*     */       {
/* 193 */         byte[] bytes = new byte['Ѐ'];
/* 194 */         FileInputStream fis = new FileInputStream(file);
/* 195 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 196 */         int len = 0;
/* 197 */         while ((len = fis.read(bytes)) > 0)
/* 198 */           baos.write(bytes, 0, len);
/* 199 */         fis.close();
/* 200 */         bytes = baos.toByteArray();
/* 201 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/*     */         }
/* 208 */         _os_.unmarshal_int();
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 212 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 214 */           SSurpriseAchievementCfg _v_ = new SSurpriseAchievementCfg();
/* 215 */           _v_.unmarshal(_os_);
/* 216 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 217 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 222 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SSurpriseAchievementCfg getOld(int key)
/*     */   {
/* 235 */     return (SSurpriseAchievementCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSurpriseAchievementCfg get(int key)
/*     */   {
/* 240 */     return (SSurpriseAchievementCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSurpriseAchievementCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSurpriseAchievementCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSurpriseAchievementCfg> newAll)
/*     */   {
/* 255 */     oldAll = all;
/* 256 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 261 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SSurpriseAchievementCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */