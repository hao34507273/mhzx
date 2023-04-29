/*     */ package mzm.gsp.feisheng.confbean;
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
/*     */ public class SFeiShengCommitPetActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFeiShengCommitPetActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFeiShengCommitPetActivityCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int moduleid;
/*     */   public int serverlevel;
/*     */   public int npc_id;
/*     */   public int npc_service_id;
/*     */   public int award_id;
/*  24 */   public HashMap<Integer, Integer> need_pets = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  29 */     this.moduleid = Integer.valueOf(rootElement.attributeValue("moduleid")).intValue();
/*  30 */     this.serverlevel = Integer.valueOf(rootElement.attributeValue("serverlevel")).intValue();
/*  31 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  32 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*  33 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*     */     
/*  35 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "need_pets");
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
/*  63 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
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
/*     */         int _v_;
/*     */         try
/*     */         {
/*  78 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  79 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  86 */         this.need_pets.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  93 */     _os_.marshal(this.activity_cfg_id);
/*  94 */     _os_.marshal(this.moduleid);
/*  95 */     _os_.marshal(this.serverlevel);
/*  96 */     _os_.marshal(this.npc_id);
/*  97 */     _os_.marshal(this.npc_service_id);
/*  98 */     _os_.marshal(this.award_id);
/*  99 */     _os_.compact_uint32(this.need_pets.size());
/* 100 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.need_pets.entrySet())
/*     */     {
/* 102 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 103 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 110 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 111 */     this.moduleid = _os_.unmarshal_int();
/* 112 */     this.serverlevel = _os_.unmarshal_int();
/* 113 */     this.npc_id = _os_.unmarshal_int();
/* 114 */     this.npc_service_id = _os_.unmarshal_int();
/* 115 */     this.award_id = _os_.unmarshal_int();
/* 116 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 119 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 121 */       int _v_ = _os_.unmarshal_int();
/* 122 */       this.need_pets.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 124 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 129 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengCommitPetActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 133 */       all = new HashMap();
/* 134 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 135 */       org.dom4j.Document doc = reader.read(new File(path));
/* 136 */       Element root = doc.getRootElement();
/* 137 */       List<?> nodeList = root.elements();
/* 138 */       int len = nodeList.size();
/* 139 */       for (int i = 0; i < len; i++)
/*     */       {
/* 141 */         Element elem = (Element)nodeList.get(i);
/* 142 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.SFeiShengCommitPetActivityCfg"))
/*     */         {
/*     */ 
/* 145 */           SFeiShengCommitPetActivityCfg obj = new SFeiShengCommitPetActivityCfg();
/* 146 */           obj.loadFromXml(elem);
/* 147 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 148 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFeiShengCommitPetActivityCfg> all)
/*     */   {
/* 159 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengCommitPetActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 163 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 164 */       org.dom4j.Document doc = reader.read(new File(path));
/* 165 */       Element root = doc.getRootElement();
/* 166 */       List<?> nodeList = root.elements();
/* 167 */       int len = nodeList.size();
/* 168 */       for (int i = 0; i < len; i++)
/*     */       {
/* 170 */         Element elem = (Element)nodeList.get(i);
/* 171 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.feisheng.confbean.SFeiShengCommitPetActivityCfg"))
/*     */         {
/*     */ 
/* 174 */           SFeiShengCommitPetActivityCfg obj = new SFeiShengCommitPetActivityCfg();
/* 175 */           obj.loadFromXml(elem);
/* 176 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 177 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 182 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 188 */     all = new HashMap();
/*     */     
/* 190 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengCommitPetActivityCfg.bny";
/*     */     try
/*     */     {
/* 193 */       File file = new File(path);
/* 194 */       if (file.exists())
/*     */       {
/* 196 */         byte[] bytes = new byte['Ѐ'];
/* 197 */         FileInputStream fis = new FileInputStream(file);
/* 198 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 199 */         int len = 0;
/* 200 */         while ((len = fis.read(bytes)) > 0)
/* 201 */           baos.write(bytes, 0, len);
/* 202 */         fis.close();
/* 203 */         bytes = baos.toByteArray();
/* 204 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 205 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 207 */           _os_.unmarshal_int();
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/*     */         }
/* 211 */         _os_.unmarshal_int();
/* 212 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 215 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 217 */           SFeiShengCommitPetActivityCfg _v_ = new SFeiShengCommitPetActivityCfg();
/* 218 */           _v_.unmarshal(_os_);
/* 219 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 220 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 225 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 230 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFeiShengCommitPetActivityCfg> all)
/*     */   {
/* 237 */     String path = dir + "mzm.gsp.feisheng.confbean.SFeiShengCommitPetActivityCfg.bny";
/*     */     try
/*     */     {
/* 240 */       File file = new File(path);
/* 241 */       if (file.exists())
/*     */       {
/* 243 */         byte[] bytes = new byte['Ѐ'];
/* 244 */         FileInputStream fis = new FileInputStream(file);
/* 245 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 246 */         int len = 0;
/* 247 */         while ((len = fis.read(bytes)) > 0)
/* 248 */           baos.write(bytes, 0, len);
/* 249 */         fis.close();
/* 250 */         bytes = baos.toByteArray();
/* 251 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 252 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 254 */           _os_.unmarshal_int();
/* 255 */           _os_.unmarshal_int();
/* 256 */           _os_.unmarshal_int();
/*     */         }
/* 258 */         _os_.unmarshal_int();
/* 259 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 262 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 264 */           SFeiShengCommitPetActivityCfg _v_ = new SFeiShengCommitPetActivityCfg();
/* 265 */           _v_.unmarshal(_os_);
/* 266 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 267 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 272 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 277 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFeiShengCommitPetActivityCfg getOld(int key)
/*     */   {
/* 285 */     return (SFeiShengCommitPetActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFeiShengCommitPetActivityCfg get(int key)
/*     */   {
/* 290 */     return (SFeiShengCommitPetActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFeiShengCommitPetActivityCfg> getOldAll()
/*     */   {
/* 295 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFeiShengCommitPetActivityCfg> getAll()
/*     */   {
/* 300 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFeiShengCommitPetActivityCfg> newAll)
/*     */   {
/* 305 */     oldAll = all;
/* 306 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 311 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\confbean\SFeiShengCommitPetActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */