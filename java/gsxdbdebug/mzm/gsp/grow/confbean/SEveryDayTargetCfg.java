/*     */ package mzm.gsp.grow.confbean;
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
/*     */ public class SEveryDayTargetCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SEveryDayTargetCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SEveryDayTargetCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templateName;
/*     */   public int targetType;
/*     */   public String targetDes;
/*     */   public int levelLow;
/*     */   public int levelUp;
/*     */   public int activityId;
/*     */   public int num;
/*     */   public int awardId;
/*     */   public int rank;
/*     */   public int weight;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.templateName = rootElement.attributeValue("templateName");
/*  34 */     this.targetType = Integer.valueOf(rootElement.attributeValue("targetType")).intValue();
/*  35 */     this.targetDes = rootElement.attributeValue("targetDes");
/*  36 */     this.levelLow = Integer.valueOf(rootElement.attributeValue("levelLow")).intValue();
/*  37 */     this.levelUp = Integer.valueOf(rootElement.attributeValue("levelUp")).intValue();
/*  38 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*  39 */     this.num = Integer.valueOf(rootElement.attributeValue("num")).intValue();
/*  40 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  41 */     this.rank = Integer.valueOf(rootElement.attributeValue("rank")).intValue();
/*  42 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.id);
/*  48 */     _os_.marshal(this.templateName, "UTF-8");
/*  49 */     _os_.marshal(this.targetType);
/*  50 */     _os_.marshal(this.targetDes, "UTF-8");
/*  51 */     _os_.marshal(this.levelLow);
/*  52 */     _os_.marshal(this.levelUp);
/*  53 */     _os_.marshal(this.activityId);
/*  54 */     _os_.marshal(this.num);
/*  55 */     _os_.marshal(this.awardId);
/*  56 */     _os_.marshal(this.rank);
/*  57 */     _os_.marshal(this.weight);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.id = _os_.unmarshal_int();
/*  64 */     this.templateName = _os_.unmarshal_String("UTF-8");
/*  65 */     this.targetType = _os_.unmarshal_int();
/*  66 */     this.targetDes = _os_.unmarshal_String("UTF-8");
/*  67 */     this.levelLow = _os_.unmarshal_int();
/*  68 */     this.levelUp = _os_.unmarshal_int();
/*  69 */     this.activityId = _os_.unmarshal_int();
/*  70 */     this.num = _os_.unmarshal_int();
/*  71 */     this.awardId = _os_.unmarshal_int();
/*  72 */     this.rank = _os_.unmarshal_int();
/*  73 */     this.weight = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.grow.confbean.SEveryDayTargetCfg.xml";
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
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.SEveryDayTargetCfg"))
/*     */         {
/*     */ 
/*  95 */           SEveryDayTargetCfg obj = new SEveryDayTargetCfg();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SEveryDayTargetCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.grow.confbean.SEveryDayTargetCfg.xml";
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
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.grow.confbean.SEveryDayTargetCfg"))
/*     */         {
/*     */ 
/* 124 */           SEveryDayTargetCfg obj = new SEveryDayTargetCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.id);
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
/* 140 */     String path = dir + "mzm.gsp.grow.confbean.SEveryDayTargetCfg.bny";
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
/* 167 */           SEveryDayTargetCfg _v_ = new SEveryDayTargetCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, SEveryDayTargetCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.grow.confbean.SEveryDayTargetCfg.bny";
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
/* 214 */           SEveryDayTargetCfg _v_ = new SEveryDayTargetCfg();
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
/*     */   public static SEveryDayTargetCfg getOld(int key)
/*     */   {
/* 235 */     return (SEveryDayTargetCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SEveryDayTargetCfg get(int key)
/*     */   {
/* 240 */     return (SEveryDayTargetCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEveryDayTargetCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEveryDayTargetCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SEveryDayTargetCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\confbean\SEveryDayTargetCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */