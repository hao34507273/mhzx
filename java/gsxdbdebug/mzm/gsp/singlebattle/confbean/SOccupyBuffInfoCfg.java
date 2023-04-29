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
/*     */ public class SOccupyBuffInfoCfg extends SBuffInfoCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SOccupyBuffInfoCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SOccupyBuffInfoCfg> all = null;
/*     */   
/*     */   public int occupy_cost_time_in_second;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  24 */     this.buff_cfg_id = Integer.valueOf(rootElement.attributeValue("buff_cfg_id")).intValue();
/*  25 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  26 */     this.occupy_cost_time_in_second = Integer.valueOf(rootElement.attributeValue("occupy_cost_time_in_second")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  31 */     _os_.marshal(this.id);
/*  32 */     _os_.marshal(this.buff_cfg_id);
/*  33 */     _os_.marshal(this.type);
/*  34 */     _os_.marshal(this.occupy_cost_time_in_second);
/*  35 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  40 */     this.id = _os_.unmarshal_int();
/*  41 */     this.buff_cfg_id = _os_.unmarshal_int();
/*  42 */     this.type = _os_.unmarshal_int();
/*  43 */     this.occupy_cost_time_in_second = _os_.unmarshal_int();
/*  44 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  49 */     String path = dir + "mzm.gsp.singlebattle.confbean.SOccupyBuffInfoCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  53 */       all = new java.util.HashMap();
/*  54 */       SAXReader reader = new SAXReader();
/*  55 */       org.dom4j.Document doc = reader.read(new File(path));
/*  56 */       Element root = doc.getRootElement();
/*  57 */       List<?> nodeList = root.elements();
/*  58 */       int len = nodeList.size();
/*  59 */       for (int i = 0; i < len; i++)
/*     */       {
/*  61 */         Element elem = (Element)nodeList.get(i);
/*  62 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.singlebattle.confbean.SOccupyBuffInfoCfg"))
/*     */         {
/*     */ 
/*  65 */           SOccupyBuffInfoCfg obj = new SOccupyBuffInfoCfg();
/*  66 */           obj.loadFromXml(elem);
/*  67 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  68 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  73 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SOccupyBuffInfoCfg> all)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.singlebattle.confbean.SOccupyBuffInfoCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       SAXReader reader = new SAXReader();
/*  84 */       org.dom4j.Document doc = reader.read(new File(path));
/*  85 */       Element root = doc.getRootElement();
/*  86 */       List<?> nodeList = root.elements();
/*  87 */       int len = nodeList.size();
/*  88 */       for (int i = 0; i < len; i++)
/*     */       {
/*  90 */         Element elem = (Element)nodeList.get(i);
/*  91 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.singlebattle.confbean.SOccupyBuffInfoCfg"))
/*     */         {
/*     */ 
/*  94 */           SOccupyBuffInfoCfg obj = new SOccupyBuffInfoCfg();
/*  95 */           obj.loadFromXml(elem);
/*  96 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  97 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 102 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 108 */     all = new java.util.HashMap();
/*     */     
/* 110 */     String path = dir + "mzm.gsp.singlebattle.confbean.SOccupyBuffInfoCfg.bny";
/*     */     try
/*     */     {
/* 113 */       File file = new File(path);
/* 114 */       if (file.exists())
/*     */       {
/* 116 */         byte[] bytes = new byte['Ѐ'];
/* 117 */         FileInputStream fis = new FileInputStream(file);
/* 118 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 119 */         int len = 0;
/* 120 */         while ((len = fis.read(bytes)) > 0)
/* 121 */           baos.write(bytes, 0, len);
/* 122 */         fis.close();
/* 123 */         bytes = baos.toByteArray();
/* 124 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 125 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 127 */           _os_.unmarshal_int();
/* 128 */           _os_.unmarshal_int();
/* 129 */           _os_.unmarshal_int();
/*     */         }
/* 131 */         _os_.unmarshal_int();
/* 132 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 135 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 137 */           SOccupyBuffInfoCfg _v_ = new SOccupyBuffInfoCfg();
/* 138 */           _v_.unmarshal(_os_);
/* 139 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 140 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 145 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 150 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SOccupyBuffInfoCfg> all)
/*     */   {
/* 157 */     String path = dir + "mzm.gsp.singlebattle.confbean.SOccupyBuffInfoCfg.bny";
/*     */     try
/*     */     {
/* 160 */       File file = new File(path);
/* 161 */       if (file.exists())
/*     */       {
/* 163 */         byte[] bytes = new byte['Ѐ'];
/* 164 */         FileInputStream fis = new FileInputStream(file);
/* 165 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 166 */         int len = 0;
/* 167 */         while ((len = fis.read(bytes)) > 0)
/* 168 */           baos.write(bytes, 0, len);
/* 169 */         fis.close();
/* 170 */         bytes = baos.toByteArray();
/* 171 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 172 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/* 176 */           _os_.unmarshal_int();
/*     */         }
/* 178 */         _os_.unmarshal_int();
/* 179 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 182 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 184 */           SOccupyBuffInfoCfg _v_ = new SOccupyBuffInfoCfg();
/* 185 */           _v_.unmarshal(_os_);
/* 186 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 187 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 192 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 197 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 203 */     for (Map.Entry<Integer, SOccupyBuffInfoCfg> entry : all.entrySet())
/*     */     {
/* 205 */       if (SBuffInfoCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 207 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 211 */       SBuffInfoCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SOccupyBuffInfoCfg> all, Map<Integer, SBuffInfoCfg> parent)
/*     */   {
/* 218 */     for (Map.Entry<Integer, SOccupyBuffInfoCfg> entry : all.entrySet())
/*     */     {
/* 220 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 222 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 226 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SOccupyBuffInfoCfg getOld(int key)
/*     */   {
/* 233 */     return (SOccupyBuffInfoCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SOccupyBuffInfoCfg get(int key)
/*     */   {
/* 238 */     return (SOccupyBuffInfoCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOccupyBuffInfoCfg> getOldAllSelf()
/*     */   {
/* 243 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOccupyBuffInfoCfg> getAllSelf()
/*     */   {
/* 248 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SOccupyBuffInfoCfg> newAll)
/*     */   {
/* 253 */     oldAll = all;
/* 254 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 259 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\confbean\SOccupyBuffInfoCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */