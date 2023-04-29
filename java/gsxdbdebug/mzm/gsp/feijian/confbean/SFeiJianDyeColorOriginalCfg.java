/*     */ package mzm.gsp.feijian.confbean;
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
/*     */ public class SFeiJianDyeColorOriginalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFeiJianDyeColorOriginalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFeiJianDyeColorOriginalCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int fei_jian_cfg_id;
/*     */   public int color_cfg_Id;
/*     */   public int index;
/*     */   public int item_id;
/*     */   public int cost_item_type;
/*     */   public int item_count;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.fei_jian_cfg_id = Integer.valueOf(rootElement.attributeValue("fei_jian_cfg_id")).intValue();
/*  30 */     this.color_cfg_Id = Integer.valueOf(rootElement.attributeValue("color_cfg_Id")).intValue();
/*  31 */     this.index = Integer.valueOf(rootElement.attributeValue("index")).intValue();
/*  32 */     this.item_id = Integer.valueOf(rootElement.attributeValue("item_id")).intValue();
/*  33 */     this.cost_item_type = Integer.valueOf(rootElement.attributeValue("cost_item_type")).intValue();
/*  34 */     this.item_count = Integer.valueOf(rootElement.attributeValue("item_count")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  39 */     _os_.marshal(this.id);
/*  40 */     _os_.marshal(this.fei_jian_cfg_id);
/*  41 */     _os_.marshal(this.color_cfg_Id);
/*  42 */     _os_.marshal(this.index);
/*  43 */     _os_.marshal(this.item_id);
/*  44 */     _os_.marshal(this.cost_item_type);
/*  45 */     _os_.marshal(this.item_count);
/*  46 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  51 */     this.id = _os_.unmarshal_int();
/*  52 */     this.fei_jian_cfg_id = _os_.unmarshal_int();
/*  53 */     this.color_cfg_Id = _os_.unmarshal_int();
/*  54 */     this.index = _os_.unmarshal_int();
/*  55 */     this.item_id = _os_.unmarshal_int();
/*  56 */     this.cost_item_type = _os_.unmarshal_int();
/*  57 */     this.item_count = _os_.unmarshal_int();
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  63 */     String path = dir + "mzm.gsp.feijian.confbean.SFeiJianDyeColorOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  67 */       all = new java.util.HashMap();
/*  68 */       SAXReader reader = new SAXReader();
/*  69 */       org.dom4j.Document doc = reader.read(new File(path));
/*  70 */       Element root = doc.getRootElement();
/*  71 */       List<?> nodeList = root.elements();
/*  72 */       int len = nodeList.size();
/*  73 */       for (int i = 0; i < len; i++)
/*     */       {
/*  75 */         Element elem = (Element)nodeList.get(i);
/*  76 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feijian.confbean.SFeiJianDyeColorOriginalCfg"))
/*     */         {
/*     */ 
/*  79 */           SFeiJianDyeColorOriginalCfg obj = new SFeiJianDyeColorOriginalCfg();
/*  80 */           obj.loadFromXml(elem);
/*  81 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  82 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  87 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFeiJianDyeColorOriginalCfg> all)
/*     */   {
/*  93 */     String path = dir + "mzm.gsp.feijian.confbean.SFeiJianDyeColorOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  97 */       SAXReader reader = new SAXReader();
/*  98 */       org.dom4j.Document doc = reader.read(new File(path));
/*  99 */       Element root = doc.getRootElement();
/* 100 */       List<?> nodeList = root.elements();
/* 101 */       int len = nodeList.size();
/* 102 */       for (int i = 0; i < len; i++)
/*     */       {
/* 104 */         Element elem = (Element)nodeList.get(i);
/* 105 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feijian.confbean.SFeiJianDyeColorOriginalCfg"))
/*     */         {
/*     */ 
/* 108 */           SFeiJianDyeColorOriginalCfg obj = new SFeiJianDyeColorOriginalCfg();
/* 109 */           obj.loadFromXml(elem);
/* 110 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 111 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 116 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 122 */     all = new java.util.HashMap();
/*     */     
/* 124 */     String path = dir + "mzm.gsp.feijian.confbean.SFeiJianDyeColorOriginalCfg.bny";
/*     */     try
/*     */     {
/* 127 */       File file = new File(path);
/* 128 */       if (file.exists())
/*     */       {
/* 130 */         byte[] bytes = new byte['Ѐ'];
/* 131 */         FileInputStream fis = new FileInputStream(file);
/* 132 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 133 */         int len = 0;
/* 134 */         while ((len = fis.read(bytes)) > 0)
/* 135 */           baos.write(bytes, 0, len);
/* 136 */         fis.close();
/* 137 */         bytes = baos.toByteArray();
/* 138 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 139 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 141 */           _os_.unmarshal_int();
/* 142 */           _os_.unmarshal_int();
/* 143 */           _os_.unmarshal_int();
/*     */         }
/* 145 */         _os_.unmarshal_int();
/* 146 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 149 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 151 */           SFeiJianDyeColorOriginalCfg _v_ = new SFeiJianDyeColorOriginalCfg();
/* 152 */           _v_.unmarshal(_os_);
/* 153 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 154 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 159 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 164 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFeiJianDyeColorOriginalCfg> all)
/*     */   {
/* 171 */     String path = dir + "mzm.gsp.feijian.confbean.SFeiJianDyeColorOriginalCfg.bny";
/*     */     try
/*     */     {
/* 174 */       File file = new File(path);
/* 175 */       if (file.exists())
/*     */       {
/* 177 */         byte[] bytes = new byte['Ѐ'];
/* 178 */         FileInputStream fis = new FileInputStream(file);
/* 179 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 180 */         int len = 0;
/* 181 */         while ((len = fis.read(bytes)) > 0)
/* 182 */           baos.write(bytes, 0, len);
/* 183 */         fis.close();
/* 184 */         bytes = baos.toByteArray();
/* 185 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 188 */           _os_.unmarshal_int();
/* 189 */           _os_.unmarshal_int();
/* 190 */           _os_.unmarshal_int();
/*     */         }
/* 192 */         _os_.unmarshal_int();
/* 193 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 196 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 198 */           SFeiJianDyeColorOriginalCfg _v_ = new SFeiJianDyeColorOriginalCfg();
/* 199 */           _v_.unmarshal(_os_);
/* 200 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 201 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 206 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFeiJianDyeColorOriginalCfg getOld(int key)
/*     */   {
/* 219 */     return (SFeiJianDyeColorOriginalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFeiJianDyeColorOriginalCfg get(int key)
/*     */   {
/* 224 */     return (SFeiJianDyeColorOriginalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFeiJianDyeColorOriginalCfg> getOldAll()
/*     */   {
/* 229 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFeiJianDyeColorOriginalCfg> getAll()
/*     */   {
/* 234 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFeiJianDyeColorOriginalCfg> newAll)
/*     */   {
/* 239 */     oldAll = all;
/* 240 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 245 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feijian\confbean\SFeiJianDyeColorOriginalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */