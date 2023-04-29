/*     */ package mzm.gsp.axe.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SAxeAvtivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAxeAvtivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAxeAvtivityCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int baodi_trigger_times;
/*     */   public int lock_trigger_interval_in_day;
/*     */   public int unlock_cost_type;
/*     */   public int unlock_cost_num;
/*  24 */   public HashMap<Integer, SAxeSectionInfo> section_infos = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  29 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  30 */     this.baodi_trigger_times = Integer.valueOf(rootElement.attributeValue("baodi_trigger_times")).intValue();
/*  31 */     this.lock_trigger_interval_in_day = Integer.valueOf(rootElement.attributeValue("lock_trigger_interval_in_day")).intValue();
/*  32 */     this.unlock_cost_type = Integer.valueOf(rootElement.attributeValue("unlock_cost_type")).intValue();
/*  33 */     this.unlock_cost_num = Integer.valueOf(rootElement.attributeValue("unlock_cost_num")).intValue();
/*     */     
/*  35 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "section_infos");
/*  36 */     if (mapTypeElement == null)
/*     */     {
/*  38 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  41 */     List<?> entryNodeList = mapTypeElement.elements();
/*  42 */     int entryLen = entryNodeList.size();
/*  43 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  45 */       Element entryElement = (Element)entryNodeList.get(i);
/*  46 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  51 */         Element keyElem = null;
/*  52 */         Element valueElem = null;
/*     */         
/*  54 */         List<?> _nodeList = entryElement.elements();
/*  55 */         int _len = _nodeList.size();
/*  56 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  58 */           Element elem = (Element)_nodeList.get(j);
/*  59 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  61 */             keyElem = elem;
/*     */           }
/*  63 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.axe.confbean.SAxeSectionInfo")))
/*     */           {
/*  65 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  69 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  71 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SAxeSectionInfo _v_;
/*     */         try
/*     */         {
/*  78 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  79 */           _v_ = new SAxeSectionInfo();
/*  80 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  87 */         this.section_infos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  94 */     _os_.marshal(this.activity_cfg_id);
/*  95 */     _os_.marshal(this.moduleid);
/*  96 */     _os_.marshal(this.baodi_trigger_times);
/*  97 */     _os_.marshal(this.lock_trigger_interval_in_day);
/*  98 */     _os_.marshal(this.unlock_cost_type);
/*  99 */     _os_.marshal(this.unlock_cost_num);
/* 100 */     _os_.compact_uint32(this.section_infos.size());
/* 101 */     for (java.util.Map.Entry<Integer, SAxeSectionInfo> _e_ : this.section_infos.entrySet())
/*     */     {
/* 103 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 104 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 106 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 111 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 112 */     this.moduleid = _os_.unmarshal_int();
/* 113 */     this.baodi_trigger_times = _os_.unmarshal_int();
/* 114 */     this.lock_trigger_interval_in_day = _os_.unmarshal_int();
/* 115 */     this.unlock_cost_type = _os_.unmarshal_int();
/* 116 */     this.unlock_cost_num = _os_.unmarshal_int();
/* 117 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 120 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 122 */       SAxeSectionInfo _v_ = new SAxeSectionInfo();
/* 123 */       _v_.unmarshal(_os_);
/* 124 */       this.section_infos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 126 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 131 */     String path = dir + "mzm.gsp.axe.confbean.SAxeAvtivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 135 */       all = new HashMap();
/* 136 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 137 */       org.dom4j.Document doc = reader.read(new File(path));
/* 138 */       Element root = doc.getRootElement();
/* 139 */       List<?> nodeList = root.elements();
/* 140 */       int len = nodeList.size();
/* 141 */       for (int i = 0; i < len; i++)
/*     */       {
/* 143 */         Element elem = (Element)nodeList.get(i);
/* 144 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.axe.confbean.SAxeAvtivityCfg"))
/*     */         {
/*     */ 
/* 147 */           SAxeAvtivityCfg obj = new SAxeAvtivityCfg();
/* 148 */           obj.loadFromXml(elem);
/* 149 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 150 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 155 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAxeAvtivityCfg> all)
/*     */   {
/* 161 */     String path = dir + "mzm.gsp.axe.confbean.SAxeAvtivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 165 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 166 */       org.dom4j.Document doc = reader.read(new File(path));
/* 167 */       Element root = doc.getRootElement();
/* 168 */       List<?> nodeList = root.elements();
/* 169 */       int len = nodeList.size();
/* 170 */       for (int i = 0; i < len; i++)
/*     */       {
/* 172 */         Element elem = (Element)nodeList.get(i);
/* 173 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.axe.confbean.SAxeAvtivityCfg"))
/*     */         {
/*     */ 
/* 176 */           SAxeAvtivityCfg obj = new SAxeAvtivityCfg();
/* 177 */           obj.loadFromXml(elem);
/* 178 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 179 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 190 */     all = new HashMap();
/*     */     
/* 192 */     String path = dir + "mzm.gsp.axe.confbean.SAxeAvtivityCfg.bny";
/*     */     try
/*     */     {
/* 195 */       File file = new File(path);
/* 196 */       if (file.exists())
/*     */       {
/* 198 */         byte[] bytes = new byte['Ѐ'];
/* 199 */         FileInputStream fis = new FileInputStream(file);
/* 200 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 201 */         int len = 0;
/* 202 */         while ((len = fis.read(bytes)) > 0)
/* 203 */           baos.write(bytes, 0, len);
/* 204 */         fis.close();
/* 205 */         bytes = baos.toByteArray();
/* 206 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 207 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/* 211 */           _os_.unmarshal_int();
/*     */         }
/* 213 */         _os_.unmarshal_int();
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 217 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 219 */           SAxeAvtivityCfg _v_ = new SAxeAvtivityCfg();
/* 220 */           _v_.unmarshal(_os_);
/* 221 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 222 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 227 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 232 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAxeAvtivityCfg> all)
/*     */   {
/* 239 */     String path = dir + "mzm.gsp.axe.confbean.SAxeAvtivityCfg.bny";
/*     */     try
/*     */     {
/* 242 */       File file = new File(path);
/* 243 */       if (file.exists())
/*     */       {
/* 245 */         byte[] bytes = new byte['Ѐ'];
/* 246 */         FileInputStream fis = new FileInputStream(file);
/* 247 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 248 */         int len = 0;
/* 249 */         while ((len = fis.read(bytes)) > 0)
/* 250 */           baos.write(bytes, 0, len);
/* 251 */         fis.close();
/* 252 */         bytes = baos.toByteArray();
/* 253 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 254 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 256 */           _os_.unmarshal_int();
/* 257 */           _os_.unmarshal_int();
/* 258 */           _os_.unmarshal_int();
/*     */         }
/* 260 */         _os_.unmarshal_int();
/* 261 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 264 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 266 */           SAxeAvtivityCfg _v_ = new SAxeAvtivityCfg();
/* 267 */           _v_.unmarshal(_os_);
/* 268 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 269 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 274 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 279 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAxeAvtivityCfg getOld(int key)
/*     */   {
/* 287 */     return (SAxeAvtivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAxeAvtivityCfg get(int key)
/*     */   {
/* 292 */     return (SAxeAvtivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAxeAvtivityCfg> getOldAll()
/*     */   {
/* 297 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAxeAvtivityCfg> getAll()
/*     */   {
/* 302 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAxeAvtivityCfg> newAll)
/*     */   {
/* 307 */     oldAll = all;
/* 308 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 313 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\confbean\SAxeAvtivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */