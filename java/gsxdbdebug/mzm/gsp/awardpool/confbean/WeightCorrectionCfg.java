/*     */ package mzm.gsp.awardpool.confbean;
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
/*     */ public class WeightCorrectionCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, WeightCorrectionCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, WeightCorrectionCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public int count1;
/*     */   public int weight1;
/*     */   public int count2;
/*     */   public int weight2;
/*     */   public int count3;
/*     */   public int weight3;
/*     */   public int count4;
/*     */   public int weight4;
/*     */   public int count5;
/*     */   public int weight5;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  33 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  34 */     this.templatename = rootElement.attributeValue("templatename");
/*  35 */     this.count1 = Integer.valueOf(rootElement.attributeValue("count1")).intValue();
/*  36 */     this.weight1 = Integer.valueOf(rootElement.attributeValue("weight1")).intValue();
/*  37 */     this.count2 = Integer.valueOf(rootElement.attributeValue("count2")).intValue();
/*  38 */     this.weight2 = Integer.valueOf(rootElement.attributeValue("weight2")).intValue();
/*  39 */     this.count3 = Integer.valueOf(rootElement.attributeValue("count3")).intValue();
/*  40 */     this.weight3 = Integer.valueOf(rootElement.attributeValue("weight3")).intValue();
/*  41 */     this.count4 = Integer.valueOf(rootElement.attributeValue("count4")).intValue();
/*  42 */     this.weight4 = Integer.valueOf(rootElement.attributeValue("weight4")).intValue();
/*  43 */     this.count5 = Integer.valueOf(rootElement.attributeValue("count5")).intValue();
/*  44 */     this.weight5 = Integer.valueOf(rootElement.attributeValue("weight5")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  49 */     _os_.marshal(this.id);
/*  50 */     _os_.marshal(this.templatename, "UTF-8");
/*  51 */     _os_.marshal(this.count1);
/*  52 */     _os_.marshal(this.weight1);
/*  53 */     _os_.marshal(this.count2);
/*  54 */     _os_.marshal(this.weight2);
/*  55 */     _os_.marshal(this.count3);
/*  56 */     _os_.marshal(this.weight3);
/*  57 */     _os_.marshal(this.count4);
/*  58 */     _os_.marshal(this.weight4);
/*  59 */     _os_.marshal(this.count5);
/*  60 */     _os_.marshal(this.weight5);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  66 */     this.id = _os_.unmarshal_int();
/*  67 */     this.templatename = _os_.unmarshal_String("UTF-8");
/*  68 */     this.count1 = _os_.unmarshal_int();
/*  69 */     this.weight1 = _os_.unmarshal_int();
/*  70 */     this.count2 = _os_.unmarshal_int();
/*  71 */     this.weight2 = _os_.unmarshal_int();
/*  72 */     this.count3 = _os_.unmarshal_int();
/*  73 */     this.weight3 = _os_.unmarshal_int();
/*  74 */     this.count4 = _os_.unmarshal_int();
/*  75 */     this.weight4 = _os_.unmarshal_int();
/*  76 */     this.count5 = _os_.unmarshal_int();
/*  77 */     this.weight5 = _os_.unmarshal_int();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  83 */     String path = dir + "mzm.gsp.awardpool.confbean.WeightCorrectionCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  87 */       all = new java.util.HashMap();
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       List<?> nodeList = root.elements();
/*  92 */       int len = nodeList.size();
/*  93 */       for (int i = 0; i < len; i++)
/*     */       {
/*  95 */         Element elem = (Element)nodeList.get(i);
/*  96 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.awardpool.confbean.WeightCorrectionCfg"))
/*     */         {
/*     */ 
/*  99 */           WeightCorrectionCfg obj = new WeightCorrectionCfg();
/* 100 */           obj.loadFromXml(elem);
/* 101 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 102 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 107 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, WeightCorrectionCfg> all)
/*     */   {
/* 113 */     String path = dir + "mzm.gsp.awardpool.confbean.WeightCorrectionCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 117 */       SAXReader reader = new SAXReader();
/* 118 */       org.dom4j.Document doc = reader.read(new File(path));
/* 119 */       Element root = doc.getRootElement();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element elem = (Element)nodeList.get(i);
/* 125 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.awardpool.confbean.WeightCorrectionCfg"))
/*     */         {
/*     */ 
/* 128 */           WeightCorrectionCfg obj = new WeightCorrectionCfg();
/* 129 */           obj.loadFromXml(elem);
/* 130 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 131 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 142 */     all = new java.util.HashMap();
/*     */     
/* 144 */     String path = dir + "mzm.gsp.awardpool.confbean.WeightCorrectionCfg.bny";
/*     */     try
/*     */     {
/* 147 */       File file = new File(path);
/* 148 */       if (file.exists())
/*     */       {
/* 150 */         byte[] bytes = new byte['Ѐ'];
/* 151 */         FileInputStream fis = new FileInputStream(file);
/* 152 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 153 */         int len = 0;
/* 154 */         while ((len = fis.read(bytes)) > 0)
/* 155 */           baos.write(bytes, 0, len);
/* 156 */         fis.close();
/* 157 */         bytes = baos.toByteArray();
/* 158 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 159 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 161 */           _os_.unmarshal_int();
/* 162 */           _os_.unmarshal_int();
/* 163 */           _os_.unmarshal_int();
/*     */         }
/* 165 */         _os_.unmarshal_int();
/* 166 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 169 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 171 */           WeightCorrectionCfg _v_ = new WeightCorrectionCfg();
/* 172 */           _v_.unmarshal(_os_);
/* 173 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 179 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, WeightCorrectionCfg> all)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.awardpool.confbean.WeightCorrectionCfg.bny";
/*     */     try
/*     */     {
/* 194 */       File file = new File(path);
/* 195 */       if (file.exists())
/*     */       {
/* 197 */         byte[] bytes = new byte['Ѐ'];
/* 198 */         FileInputStream fis = new FileInputStream(file);
/* 199 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 200 */         int len = 0;
/* 201 */         while ((len = fis.read(bytes)) > 0)
/* 202 */           baos.write(bytes, 0, len);
/* 203 */         fis.close();
/* 204 */         bytes = baos.toByteArray();
/* 205 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/*     */         }
/* 212 */         _os_.unmarshal_int();
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 216 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 218 */           WeightCorrectionCfg _v_ = new WeightCorrectionCfg();
/* 219 */           _v_.unmarshal(_os_);
/* 220 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 221 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 226 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static WeightCorrectionCfg getOld(int key)
/*     */   {
/* 239 */     return (WeightCorrectionCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static WeightCorrectionCfg get(int key)
/*     */   {
/* 244 */     return (WeightCorrectionCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, WeightCorrectionCfg> getOldAll()
/*     */   {
/* 249 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, WeightCorrectionCfg> getAll()
/*     */   {
/* 254 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, WeightCorrectionCfg> newAll)
/*     */   {
/* 259 */     oldAll = all;
/* 260 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 265 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\confbean\WeightCorrectionCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */