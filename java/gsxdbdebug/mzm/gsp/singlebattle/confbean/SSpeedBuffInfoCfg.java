/*     */ package mzm.gsp.singlebattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SSpeedBuffInfoCfg extends SBuffInfoCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SSpeedBuffInfoCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SSpeedBuffInfoCfg> all = null;
/*     */   
/*     */ 
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  22 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  23 */     this.buff_cfg_id = Integer.valueOf(rootElement.attributeValue("buff_cfg_id")).intValue();
/*  24 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  29 */     _os_.marshal(this.id);
/*  30 */     _os_.marshal(this.buff_cfg_id);
/*  31 */     _os_.marshal(this.type);
/*  32 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  37 */     this.id = _os_.unmarshal_int();
/*  38 */     this.buff_cfg_id = _os_.unmarshal_int();
/*  39 */     this.type = _os_.unmarshal_int();
/*  40 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  45 */     String path = dir + "mzm.gsp.singlebattle.confbean.SSpeedBuffInfoCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  49 */       all = new java.util.HashMap();
/*  50 */       SAXReader reader = new SAXReader();
/*  51 */       org.dom4j.Document doc = reader.read(new File(path));
/*  52 */       Element root = doc.getRootElement();
/*  53 */       List<?> nodeList = root.elements();
/*  54 */       int len = nodeList.size();
/*  55 */       for (int i = 0; i < len; i++)
/*     */       {
/*  57 */         Element elem = (Element)nodeList.get(i);
/*  58 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.singlebattle.confbean.SSpeedBuffInfoCfg"))
/*     */         {
/*     */ 
/*  61 */           SSpeedBuffInfoCfg obj = new SSpeedBuffInfoCfg();
/*  62 */           obj.loadFromXml(elem);
/*  63 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  64 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  69 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSpeedBuffInfoCfg> all)
/*     */   {
/*  75 */     String path = dir + "mzm.gsp.singlebattle.confbean.SSpeedBuffInfoCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  79 */       SAXReader reader = new SAXReader();
/*  80 */       org.dom4j.Document doc = reader.read(new File(path));
/*  81 */       Element root = doc.getRootElement();
/*  82 */       List<?> nodeList = root.elements();
/*  83 */       int len = nodeList.size();
/*  84 */       for (int i = 0; i < len; i++)
/*     */       {
/*  86 */         Element elem = (Element)nodeList.get(i);
/*  87 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.singlebattle.confbean.SSpeedBuffInfoCfg"))
/*     */         {
/*     */ 
/*  90 */           SSpeedBuffInfoCfg obj = new SSpeedBuffInfoCfg();
/*  91 */           obj.loadFromXml(elem);
/*  92 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  93 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  98 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 104 */     all = new java.util.HashMap();
/*     */     
/* 106 */     String path = dir + "mzm.gsp.singlebattle.confbean.SSpeedBuffInfoCfg.bny";
/*     */     try
/*     */     {
/* 109 */       File file = new File(path);
/* 110 */       if (file.exists())
/*     */       {
/* 112 */         byte[] bytes = new byte['Ѐ'];
/* 113 */         FileInputStream fis = new FileInputStream(file);
/* 114 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 115 */         int len = 0;
/* 116 */         while ((len = fis.read(bytes)) > 0)
/* 117 */           baos.write(bytes, 0, len);
/* 118 */         fis.close();
/* 119 */         bytes = baos.toByteArray();
/* 120 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 121 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 123 */           _os_.unmarshal_int();
/* 124 */           _os_.unmarshal_int();
/* 125 */           _os_.unmarshal_int();
/*     */         }
/* 127 */         _os_.unmarshal_int();
/* 128 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 131 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 133 */           SSpeedBuffInfoCfg _v_ = new SSpeedBuffInfoCfg();
/* 134 */           _v_.unmarshal(_os_);
/* 135 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 136 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 141 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 146 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSpeedBuffInfoCfg> all)
/*     */   {
/* 153 */     String path = dir + "mzm.gsp.singlebattle.confbean.SSpeedBuffInfoCfg.bny";
/*     */     try
/*     */     {
/* 156 */       File file = new File(path);
/* 157 */       if (file.exists())
/*     */       {
/* 159 */         byte[] bytes = new byte['Ѐ'];
/* 160 */         FileInputStream fis = new FileInputStream(file);
/* 161 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 162 */         int len = 0;
/* 163 */         while ((len = fis.read(bytes)) > 0)
/* 164 */           baos.write(bytes, 0, len);
/* 165 */         fis.close();
/* 166 */         bytes = baos.toByteArray();
/* 167 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 168 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/* 172 */           _os_.unmarshal_int();
/*     */         }
/* 174 */         _os_.unmarshal_int();
/* 175 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 178 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 180 */           SSpeedBuffInfoCfg _v_ = new SSpeedBuffInfoCfg();
/* 181 */           _v_.unmarshal(_os_);
/* 182 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 183 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 188 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 193 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 199 */     for (Map.Entry<Integer, SSpeedBuffInfoCfg> entry : all.entrySet())
/*     */     {
/* 201 */       if (SBuffInfoCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 203 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 207 */       SBuffInfoCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SSpeedBuffInfoCfg> all, Map<Integer, SBuffInfoCfg> parent)
/*     */   {
/* 214 */     for (Map.Entry<Integer, SSpeedBuffInfoCfg> entry : all.entrySet())
/*     */     {
/* 216 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 218 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 222 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SSpeedBuffInfoCfg getOld(int key)
/*     */   {
/* 229 */     return (SSpeedBuffInfoCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSpeedBuffInfoCfg get(int key)
/*     */   {
/* 234 */     return (SSpeedBuffInfoCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSpeedBuffInfoCfg> getOldAllSelf()
/*     */   {
/* 239 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSpeedBuffInfoCfg> getAllSelf()
/*     */   {
/* 244 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSpeedBuffInfoCfg> newAll)
/*     */   {
/* 249 */     oldAll = all;
/* 250 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 255 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\confbean\SSpeedBuffInfoCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */