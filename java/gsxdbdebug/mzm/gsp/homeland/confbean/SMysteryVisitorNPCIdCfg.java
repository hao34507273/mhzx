/*     */ package mzm.gsp.homeland.confbean;
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
/*     */ public class SMysteryVisitorNPCIdCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMysteryVisitorNPCIdCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMysteryVisitorNPCIdCfg> all = null;
/*     */   
/*     */   public int npc_lib_id;
/*  19 */   public HashMap<Integer, Integer> npcids = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.npc_lib_id = Integer.valueOf(rootElement.attributeValue("npc_lib_id")).intValue();
/*     */     
/*  25 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "npcids");
/*  26 */     if (mapTypeElement == null)
/*     */     {
/*  28 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  31 */     List<?> entryNodeList = mapTypeElement.elements();
/*  32 */     int entryLen = entryNodeList.size();
/*  33 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  35 */       Element entryElement = (Element)entryNodeList.get(i);
/*  36 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  41 */         Element keyElem = null;
/*  42 */         Element valueElem = null;
/*     */         
/*  44 */         List<?> _nodeList = entryElement.elements();
/*  45 */         int _len = _nodeList.size();
/*  46 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  48 */           Element elem = (Element)_nodeList.get(j);
/*  49 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  51 */             keyElem = elem;
/*     */           }
/*  53 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  55 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  59 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  61 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  68 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  69 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  76 */         this.npcids.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  83 */     _os_.marshal(this.npc_lib_id);
/*  84 */     _os_.compact_uint32(this.npcids.size());
/*  85 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.npcids.entrySet())
/*     */     {
/*  87 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  88 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     this.npc_lib_id = _os_.unmarshal_int();
/*  96 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  99 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 101 */       int _v_ = _os_.unmarshal_int();
/* 102 */       this.npcids.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 104 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.homeland.confbean.SMysteryVisitorNPCIdCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 113 */       all = new HashMap();
/* 114 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 115 */       org.dom4j.Document doc = reader.read(new File(path));
/* 116 */       Element root = doc.getRootElement();
/* 117 */       List<?> nodeList = root.elements();
/* 118 */       int len = nodeList.size();
/* 119 */       for (int i = 0; i < len; i++)
/*     */       {
/* 121 */         Element elem = (Element)nodeList.get(i);
/* 122 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SMysteryVisitorNPCIdCfg"))
/*     */         {
/*     */ 
/* 125 */           SMysteryVisitorNPCIdCfg obj = new SMysteryVisitorNPCIdCfg();
/* 126 */           obj.loadFromXml(elem);
/* 127 */           if (all.put(Integer.valueOf(obj.npc_lib_id), obj) != null) {
/* 128 */             throw new RuntimeException("duplicate key : " + obj.npc_lib_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 133 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMysteryVisitorNPCIdCfg> all)
/*     */   {
/* 139 */     String path = dir + "mzm.gsp.homeland.confbean.SMysteryVisitorNPCIdCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 143 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 144 */       org.dom4j.Document doc = reader.read(new File(path));
/* 145 */       Element root = doc.getRootElement();
/* 146 */       List<?> nodeList = root.elements();
/* 147 */       int len = nodeList.size();
/* 148 */       for (int i = 0; i < len; i++)
/*     */       {
/* 150 */         Element elem = (Element)nodeList.get(i);
/* 151 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SMysteryVisitorNPCIdCfg"))
/*     */         {
/*     */ 
/* 154 */           SMysteryVisitorNPCIdCfg obj = new SMysteryVisitorNPCIdCfg();
/* 155 */           obj.loadFromXml(elem);
/* 156 */           if (all.put(Integer.valueOf(obj.npc_lib_id), obj) != null) {
/* 157 */             throw new RuntimeException("duplicate key : " + obj.npc_lib_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 162 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 168 */     all = new HashMap();
/*     */     
/* 170 */     String path = dir + "mzm.gsp.homeland.confbean.SMysteryVisitorNPCIdCfg.bny";
/*     */     try
/*     */     {
/* 173 */       File file = new File(path);
/* 174 */       if (file.exists())
/*     */       {
/* 176 */         byte[] bytes = new byte['Ѐ'];
/* 177 */         FileInputStream fis = new FileInputStream(file);
/* 178 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 179 */         int len = 0;
/* 180 */         while ((len = fis.read(bytes)) > 0)
/* 181 */           baos.write(bytes, 0, len);
/* 182 */         fis.close();
/* 183 */         bytes = baos.toByteArray();
/* 184 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 185 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 187 */           _os_.unmarshal_int();
/* 188 */           _os_.unmarshal_int();
/* 189 */           _os_.unmarshal_int();
/*     */         }
/* 191 */         _os_.unmarshal_int();
/* 192 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 195 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 197 */           SMysteryVisitorNPCIdCfg _v_ = new SMysteryVisitorNPCIdCfg();
/* 198 */           _v_.unmarshal(_os_);
/* 199 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 200 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 205 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 210 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMysteryVisitorNPCIdCfg> all)
/*     */   {
/* 217 */     String path = dir + "mzm.gsp.homeland.confbean.SMysteryVisitorNPCIdCfg.bny";
/*     */     try
/*     */     {
/* 220 */       File file = new File(path);
/* 221 */       if (file.exists())
/*     */       {
/* 223 */         byte[] bytes = new byte['Ѐ'];
/* 224 */         FileInputStream fis = new FileInputStream(file);
/* 225 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 226 */         int len = 0;
/* 227 */         while ((len = fis.read(bytes)) > 0)
/* 228 */           baos.write(bytes, 0, len);
/* 229 */         fis.close();
/* 230 */         bytes = baos.toByteArray();
/* 231 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 232 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 234 */           _os_.unmarshal_int();
/* 235 */           _os_.unmarshal_int();
/* 236 */           _os_.unmarshal_int();
/*     */         }
/* 238 */         _os_.unmarshal_int();
/* 239 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 242 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 244 */           SMysteryVisitorNPCIdCfg _v_ = new SMysteryVisitorNPCIdCfg();
/* 245 */           _v_.unmarshal(_os_);
/* 246 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 247 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 252 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 257 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMysteryVisitorNPCIdCfg getOld(int key)
/*     */   {
/* 265 */     return (SMysteryVisitorNPCIdCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMysteryVisitorNPCIdCfg get(int key)
/*     */   {
/* 270 */     return (SMysteryVisitorNPCIdCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMysteryVisitorNPCIdCfg> getOldAll()
/*     */   {
/* 275 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMysteryVisitorNPCIdCfg> getAll()
/*     */   {
/* 280 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMysteryVisitorNPCIdCfg> newAll)
/*     */   {
/* 285 */     oldAll = all;
/* 286 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 291 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\SMysteryVisitorNPCIdCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */