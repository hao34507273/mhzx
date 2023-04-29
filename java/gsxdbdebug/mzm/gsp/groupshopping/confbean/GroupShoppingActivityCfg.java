/*     */ package mzm.gsp.groupshopping.confbean;
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
/*     */ public class GroupShoppingActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, GroupShoppingActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, GroupShoppingActivityCfg> all = null;
/*     */   
/*     */   public int activityId;
/*  19 */   public ArrayList<Integer> smallGroupItemCfgIds = new ArrayList();
/*  20 */   public ArrayList<Integer> bigGroupItemCfgIds = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/*     */     
/*  26 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "smallGroupItemCfgIds");
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
/*  51 */         this.smallGroupItemCfgIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  55 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "bigGroupItemCfgIds");
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
/*  66 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  73 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  80 */         this.bigGroupItemCfgIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  87 */     _os_.marshal(this.activityId);
/*  88 */     _os_.compact_uint32(this.smallGroupItemCfgIds.size());
/*  89 */     for (Integer _v_ : this.smallGroupItemCfgIds)
/*     */     {
/*  91 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  93 */     _os_.compact_uint32(this.bigGroupItemCfgIds.size());
/*  94 */     for (Integer _v_ : this.bigGroupItemCfgIds)
/*     */     {
/*  96 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  98 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 103 */     this.activityId = _os_.unmarshal_int();
/* 104 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 107 */       int _v_ = _os_.unmarshal_int();
/* 108 */       this.smallGroupItemCfgIds.add(Integer.valueOf(_v_));
/*     */     }
/* 110 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 113 */       int _v_ = _os_.unmarshal_int();
/* 114 */       this.bigGroupItemCfgIds.add(Integer.valueOf(_v_));
/*     */     }
/* 116 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg.xml";
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
/* 134 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg"))
/*     */         {
/*     */ 
/* 137 */           GroupShoppingActivityCfg obj = new GroupShoppingActivityCfg();
/* 138 */           obj.loadFromXml(elem);
/* 139 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 140 */             throw new RuntimeException("duplicate key : " + obj.activityId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 145 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, GroupShoppingActivityCfg> all)
/*     */   {
/* 151 */     String path = dir + "mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg.xml";
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
/* 163 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg"))
/*     */         {
/*     */ 
/* 166 */           GroupShoppingActivityCfg obj = new GroupShoppingActivityCfg();
/* 167 */           obj.loadFromXml(elem);
/* 168 */           if (all.put(Integer.valueOf(obj.activityId), obj) != null) {
/* 169 */             throw new RuntimeException("duplicate key : " + obj.activityId);
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
/* 182 */     String path = dir + "mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg.bny";
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
/* 209 */           GroupShoppingActivityCfg _v_ = new GroupShoppingActivityCfg();
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
/*     */   public static void reLoadBny(String dir, Map<Integer, GroupShoppingActivityCfg> all)
/*     */   {
/* 229 */     String path = dir + "mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg.bny";
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
/* 256 */           GroupShoppingActivityCfg _v_ = new GroupShoppingActivityCfg();
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
/*     */   public static GroupShoppingActivityCfg getOld(int key)
/*     */   {
/* 277 */     return (GroupShoppingActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static GroupShoppingActivityCfg get(int key)
/*     */   {
/* 282 */     return (GroupShoppingActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, GroupShoppingActivityCfg> getOldAll()
/*     */   {
/* 287 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, GroupShoppingActivityCfg> getAll()
/*     */   {
/* 292 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, GroupShoppingActivityCfg> newAll)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\confbean\GroupShoppingActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */