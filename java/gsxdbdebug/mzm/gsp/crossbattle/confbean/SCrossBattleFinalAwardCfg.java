/*     */ package mzm.gsp.crossbattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SCrossBattleFinalAwardCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SCrossBattleFinalAwardCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SCrossBattleFinalAwardCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*  19 */   public ArrayList<Integer> award_id_list = new ArrayList();
/*  20 */   public ArrayList<String> mail_title_list = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*     */     
/*  26 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "award_id_list");
/*  27 */     if (collectionElement == null)
/*     */     {
/*  29 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  32 */     List<?> _nodeList = collectionElement.elements();
/*  33 */     int _len = _nodeList.size();
/*  34 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  36 */       Element elem = (Element)_nodeList.get(i);
/*  37 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  44 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  51 */         this.award_id_list.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  55 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "mail_title_list");
/*  56 */     if (collectionElement == null)
/*     */     {
/*  58 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  61 */     List<?> _nodeList = collectionElement.elements();
/*  62 */     int _len = _nodeList.size();
/*  63 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  65 */       Element elem = (Element)_nodeList.get(i);
/*  66 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  73 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  80 */         this.mail_title_list.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  87 */     _os_.marshal(this.activity_cfg_id);
/*  88 */     _os_.compact_uint32(this.award_id_list.size());
/*  89 */     for (Integer _v_ : this.award_id_list)
/*     */     {
/*  91 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  93 */     _os_.compact_uint32(this.mail_title_list.size());
/*  94 */     for (String _v_ : this.mail_title_list)
/*     */     {
/*  96 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 103 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 104 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 107 */       int _v_ = _os_.unmarshal_int();
/* 108 */       this.award_id_list.add(Integer.valueOf(_v_));
/*     */     }
/* 110 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 113 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 114 */       this.mail_title_list.add(_v_);
/*     */     }
/* 116 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalAwardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       all = new java.util.HashMap();
/* 126 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 127 */       org.dom4j.Document doc = reader.read(new File(path));
/* 128 */       Element root = doc.getRootElement();
/* 129 */       List<?> nodeList = root.elements();
/* 130 */       int len = nodeList.size();
/* 131 */       for (int i = 0; i < len; i++)
/*     */       {
/* 133 */         Element elem = (Element)nodeList.get(i);
/* 134 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleFinalAwardCfg"))
/*     */         {
/*     */ 
/* 137 */           SCrossBattleFinalAwardCfg obj = new SCrossBattleFinalAwardCfg();
/* 138 */           obj.loadFromXml(elem);
/* 139 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 140 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 145 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SCrossBattleFinalAwardCfg> all)
/*     */   {
/* 151 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalAwardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 155 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 156 */       org.dom4j.Document doc = reader.read(new File(path));
/* 157 */       Element root = doc.getRootElement();
/* 158 */       List<?> nodeList = root.elements();
/* 159 */       int len = nodeList.size();
/* 160 */       for (int i = 0; i < len; i++)
/*     */       {
/* 162 */         Element elem = (Element)nodeList.get(i);
/* 163 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.SCrossBattleFinalAwardCfg"))
/*     */         {
/*     */ 
/* 166 */           SCrossBattleFinalAwardCfg obj = new SCrossBattleFinalAwardCfg();
/* 167 */           obj.loadFromXml(elem);
/* 168 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 169 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 174 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 180 */     all = new java.util.HashMap();
/*     */     
/* 182 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalAwardCfg.bny";
/*     */     try
/*     */     {
/* 185 */       File file = new File(path);
/* 186 */       if (file.exists())
/*     */       {
/* 188 */         byte[] bytes = new byte['Ѐ'];
/* 189 */         FileInputStream fis = new FileInputStream(file);
/* 190 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 191 */         int len = 0;
/* 192 */         while ((len = fis.read(bytes)) > 0)
/* 193 */           baos.write(bytes, 0, len);
/* 194 */         fis.close();
/* 195 */         bytes = baos.toByteArray();
/* 196 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 197 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 199 */           _os_.unmarshal_int();
/* 200 */           _os_.unmarshal_int();
/* 201 */           _os_.unmarshal_int();
/*     */         }
/* 203 */         _os_.unmarshal_int();
/* 204 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 207 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 209 */           SCrossBattleFinalAwardCfg _v_ = new SCrossBattleFinalAwardCfg();
/* 210 */           _v_.unmarshal(_os_);
/* 211 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 212 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 217 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 222 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SCrossBattleFinalAwardCfg> all)
/*     */   {
/* 229 */     String path = dir + "mzm.gsp.crossbattle.confbean.SCrossBattleFinalAwardCfg.bny";
/*     */     try
/*     */     {
/* 232 */       File file = new File(path);
/* 233 */       if (file.exists())
/*     */       {
/* 235 */         byte[] bytes = new byte['Ѐ'];
/* 236 */         FileInputStream fis = new FileInputStream(file);
/* 237 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 238 */         int len = 0;
/* 239 */         while ((len = fis.read(bytes)) > 0)
/* 240 */           baos.write(bytes, 0, len);
/* 241 */         fis.close();
/* 242 */         bytes = baos.toByteArray();
/* 243 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 244 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 246 */           _os_.unmarshal_int();
/* 247 */           _os_.unmarshal_int();
/* 248 */           _os_.unmarshal_int();
/*     */         }
/* 250 */         _os_.unmarshal_int();
/* 251 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 254 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 256 */           SCrossBattleFinalAwardCfg _v_ = new SCrossBattleFinalAwardCfg();
/* 257 */           _v_.unmarshal(_os_);
/* 258 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 259 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 264 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 269 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SCrossBattleFinalAwardCfg getOld(int key)
/*     */   {
/* 277 */     return (SCrossBattleFinalAwardCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SCrossBattleFinalAwardCfg get(int key)
/*     */   {
/* 282 */     return (SCrossBattleFinalAwardCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleFinalAwardCfg> getOldAll()
/*     */   {
/* 287 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SCrossBattleFinalAwardCfg> getAll()
/*     */   {
/* 292 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SCrossBattleFinalAwardCfg> newAll)
/*     */   {
/* 297 */     oldAll = all;
/* 298 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 303 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\SCrossBattleFinalAwardCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */