/*     */ package mzm.gsp.gang.confbean;
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
/*     */ public class SGangMiFangCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SGangMiFangCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SGangMiFangCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int yaoDianLevel;
/*     */   public int mustItemSiftId;
/*     */   public int otherItemSiftId;
/*     */   public int generLifeSkillId;
/*     */   public int successRate;
/*     */   public int weight;
/*     */   public int lowTime;
/*     */   public int maxTime;
/*     */   public int lowPersistTimeM;
/*     */   public int hightPersistTimeM;
/*     */   public int needBangGong;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.templatename = rootElement.attributeValue("templatename");
/*  36 */     this.yaoDianLevel = Integer.valueOf(rootElement.attributeValue("yaoDianLevel")).intValue();
/*  37 */     this.mustItemSiftId = Integer.valueOf(rootElement.attributeValue("mustItemSiftId")).intValue();
/*  38 */     this.otherItemSiftId = Integer.valueOf(rootElement.attributeValue("otherItemSiftId")).intValue();
/*  39 */     this.generLifeSkillId = Integer.valueOf(rootElement.attributeValue("generLifeSkillId")).intValue();
/*  40 */     this.successRate = Integer.valueOf(rootElement.attributeValue("successRate")).intValue();
/*  41 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/*  42 */     this.lowTime = Integer.valueOf(rootElement.attributeValue("lowTime")).intValue();
/*  43 */     this.maxTime = Integer.valueOf(rootElement.attributeValue("maxTime")).intValue();
/*  44 */     this.lowPersistTimeM = Integer.valueOf(rootElement.attributeValue("lowPersistTimeM")).intValue();
/*  45 */     this.hightPersistTimeM = Integer.valueOf(rootElement.attributeValue("hightPersistTimeM")).intValue();
/*  46 */     this.needBangGong = Integer.valueOf(rootElement.attributeValue("needBangGong")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  51 */     _os_.marshal(this.id);
/*  52 */     _os_.marshal(this.templatename, "UTF-8");
/*  53 */     _os_.marshal(this.yaoDianLevel);
/*  54 */     _os_.marshal(this.mustItemSiftId);
/*  55 */     _os_.marshal(this.otherItemSiftId);
/*  56 */     _os_.marshal(this.generLifeSkillId);
/*  57 */     _os_.marshal(this.successRate);
/*  58 */     _os_.marshal(this.weight);
/*  59 */     _os_.marshal(this.lowTime);
/*  60 */     _os_.marshal(this.maxTime);
/*  61 */     _os_.marshal(this.lowPersistTimeM);
/*  62 */     _os_.marshal(this.hightPersistTimeM);
/*  63 */     _os_.marshal(this.needBangGong);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.id = _os_.unmarshal_int();
/*  70 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  71 */     this.yaoDianLevel = _os_.unmarshal_int();
/*  72 */     this.mustItemSiftId = _os_.unmarshal_int();
/*  73 */     this.otherItemSiftId = _os_.unmarshal_int();
/*  74 */     this.generLifeSkillId = _os_.unmarshal_int();
/*  75 */     this.successRate = _os_.unmarshal_int();
/*  76 */     this.weight = _os_.unmarshal_int();
/*  77 */     this.lowTime = _os_.unmarshal_int();
/*  78 */     this.maxTime = _os_.unmarshal_int();
/*  79 */     this.lowPersistTimeM = _os_.unmarshal_int();
/*  80 */     this.hightPersistTimeM = _os_.unmarshal_int();
/*  81 */     this.needBangGong = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  87 */     String path = dir + "mzm.gsp.gang.confbean.SGangMiFangCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  91 */       all = new java.util.HashMap();
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       List<?> nodeList = root.elements();
/*  96 */       int len = nodeList.size();
/*  97 */       for (int i = 0; i < len; i++)
/*     */       {
/*  99 */         Element elem = (Element)nodeList.get(i);
/* 100 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gang.confbean.SGangMiFangCfg"))
/*     */         {
/*     */ 
/* 103 */           SGangMiFangCfg obj = new SGangMiFangCfg();
/* 104 */           obj.loadFromXml(elem);
/* 105 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 106 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 111 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SGangMiFangCfg> all)
/*     */   {
/* 117 */     String path = dir + "mzm.gsp.gang.confbean.SGangMiFangCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 121 */       SAXReader reader = new SAXReader();
/* 122 */       org.dom4j.Document doc = reader.read(new File(path));
/* 123 */       Element root = doc.getRootElement();
/* 124 */       List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gang.confbean.SGangMiFangCfg"))
/*     */         {
/*     */ 
/* 132 */           SGangMiFangCfg obj = new SGangMiFangCfg();
/* 133 */           obj.loadFromXml(elem);
/* 134 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 135 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 146 */     all = new java.util.HashMap();
/*     */     
/* 148 */     String path = dir + "mzm.gsp.gang.confbean.SGangMiFangCfg.bny";
/*     */     try
/*     */     {
/* 151 */       File file = new File(path);
/* 152 */       if (file.exists())
/*     */       {
/* 154 */         byte[] bytes = new byte['Ѐ'];
/* 155 */         FileInputStream fis = new FileInputStream(file);
/* 156 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 157 */         int len = 0;
/* 158 */         while ((len = fis.read(bytes)) > 0)
/* 159 */           baos.write(bytes, 0, len);
/* 160 */         fis.close();
/* 161 */         bytes = baos.toByteArray();
/* 162 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 163 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/* 167 */           _os_.unmarshal_int();
/*     */         }
/* 169 */         _os_.unmarshal_int();
/* 170 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 173 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 175 */           SGangMiFangCfg _v_ = new SGangMiFangCfg();
/* 176 */           _v_.unmarshal(_os_);
/* 177 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 178 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 183 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SGangMiFangCfg> all)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.gang.confbean.SGangMiFangCfg.bny";
/*     */     try
/*     */     {
/* 198 */       File file = new File(path);
/* 199 */       if (file.exists())
/*     */       {
/* 201 */         byte[] bytes = new byte['Ѐ'];
/* 202 */         FileInputStream fis = new FileInputStream(file);
/* 203 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 204 */         int len = 0;
/* 205 */         while ((len = fis.read(bytes)) > 0)
/* 206 */           baos.write(bytes, 0, len);
/* 207 */         fis.close();
/* 208 */         bytes = baos.toByteArray();
/* 209 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 210 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/*     */         }
/* 216 */         _os_.unmarshal_int();
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 220 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 222 */           SGangMiFangCfg _v_ = new SGangMiFangCfg();
/* 223 */           _v_.unmarshal(_os_);
/* 224 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 225 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 230 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 235 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SGangMiFangCfg getOld(int key)
/*     */   {
/* 243 */     return (SGangMiFangCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SGangMiFangCfg get(int key)
/*     */   {
/* 248 */     return (SGangMiFangCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGangMiFangCfg> getOldAll()
/*     */   {
/* 253 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGangMiFangCfg> getAll()
/*     */   {
/* 258 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SGangMiFangCfg> newAll)
/*     */   {
/* 263 */     oldAll = all;
/* 264 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 269 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\confbean\SGangMiFangCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */