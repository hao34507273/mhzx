/*     */ package mzm.gsp.instance.confbean;
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
/*     */ public class SOperaInstanceCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SOperaInstanceCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SOperaInstanceCfg> all = null;
/*     */   
/*     */   public int instanceid;
/*     */   public int disType;
/*     */   public int confirmType;
/*     */   public int taskGraph;
/*  22 */   public java.util.ArrayList<Integer> awarditems = new java.util.ArrayList();
/*     */   public int awardpoolid;
/*     */   public int activityid;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.instanceid = Integer.valueOf(rootElement.attributeValue("instanceid")).intValue();
/*  29 */     this.disType = Integer.valueOf(rootElement.attributeValue("disType")).intValue();
/*  30 */     this.confirmType = Integer.valueOf(rootElement.attributeValue("confirmType")).intValue();
/*  31 */     this.taskGraph = Integer.valueOf(rootElement.attributeValue("taskGraph")).intValue();
/*     */     
/*  33 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "awarditems");
/*  34 */     if (collectionElement == null)
/*     */     {
/*  36 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  39 */     List<?> _nodeList = collectionElement.elements();
/*  40 */     int _len = _nodeList.size();
/*  41 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  43 */       Element elem = (Element)_nodeList.get(i);
/*  44 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  51 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.awarditems.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  61 */     this.awardpoolid = Integer.valueOf(rootElement.attributeValue("awardpoolid")).intValue();
/*  62 */     this.activityid = Integer.valueOf(rootElement.attributeValue("activityid")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _os_.marshal(this.instanceid);
/*  68 */     _os_.marshal(this.disType);
/*  69 */     _os_.marshal(this.confirmType);
/*  70 */     _os_.marshal(this.taskGraph);
/*  71 */     _os_.compact_uint32(this.awarditems.size());
/*  72 */     for (Integer _v_ : this.awarditems)
/*     */     {
/*  74 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  76 */     _os_.marshal(this.awardpoolid);
/*  77 */     _os_.marshal(this.activityid);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     this.instanceid = _os_.unmarshal_int();
/*  84 */     this.disType = _os_.unmarshal_int();
/*  85 */     this.confirmType = _os_.unmarshal_int();
/*  86 */     this.taskGraph = _os_.unmarshal_int();
/*  87 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  90 */       int _v_ = _os_.unmarshal_int();
/*  91 */       this.awarditems.add(Integer.valueOf(_v_));
/*     */     }
/*  93 */     this.awardpoolid = _os_.unmarshal_int();
/*  94 */     this.activityid = _os_.unmarshal_int();
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 100 */     String path = dir + "mzm.gsp.instance.confbean.SOperaInstanceCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 104 */       all = new java.util.HashMap();
/* 105 */       SAXReader reader = new SAXReader();
/* 106 */       org.dom4j.Document doc = reader.read(new File(path));
/* 107 */       Element root = doc.getRootElement();
/* 108 */       List<?> nodeList = root.elements();
/* 109 */       int len = nodeList.size();
/* 110 */       for (int i = 0; i < len; i++)
/*     */       {
/* 112 */         Element elem = (Element)nodeList.get(i);
/* 113 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.instance.confbean.SOperaInstanceCfg"))
/*     */         {
/*     */ 
/* 116 */           SOperaInstanceCfg obj = new SOperaInstanceCfg();
/* 117 */           obj.loadFromXml(elem);
/* 118 */           if (all.put(Integer.valueOf(obj.instanceid), obj) != null) {
/* 119 */             throw new RuntimeException("duplicate key : " + obj.instanceid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 124 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SOperaInstanceCfg> all)
/*     */   {
/* 130 */     String path = dir + "mzm.gsp.instance.confbean.SOperaInstanceCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 134 */       SAXReader reader = new SAXReader();
/* 135 */       org.dom4j.Document doc = reader.read(new File(path));
/* 136 */       Element root = doc.getRootElement();
/* 137 */       List<?> nodeList = root.elements();
/* 138 */       int len = nodeList.size();
/* 139 */       for (int i = 0; i < len; i++)
/*     */       {
/* 141 */         Element elem = (Element)nodeList.get(i);
/* 142 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.instance.confbean.SOperaInstanceCfg"))
/*     */         {
/*     */ 
/* 145 */           SOperaInstanceCfg obj = new SOperaInstanceCfg();
/* 146 */           obj.loadFromXml(elem);
/* 147 */           if (all.put(Integer.valueOf(obj.instanceid), obj) != null) {
/* 148 */             throw new RuntimeException("duplicate key : " + obj.instanceid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 153 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 159 */     all = new java.util.HashMap();
/*     */     
/* 161 */     String path = dir + "mzm.gsp.instance.confbean.SOperaInstanceCfg.bny";
/*     */     try
/*     */     {
/* 164 */       File file = new File(path);
/* 165 */       if (file.exists())
/*     */       {
/* 167 */         byte[] bytes = new byte['Ѐ'];
/* 168 */         FileInputStream fis = new FileInputStream(file);
/* 169 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 170 */         int len = 0;
/* 171 */         while ((len = fis.read(bytes)) > 0)
/* 172 */           baos.write(bytes, 0, len);
/* 173 */         fis.close();
/* 174 */         bytes = baos.toByteArray();
/* 175 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 176 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 178 */           _os_.unmarshal_int();
/* 179 */           _os_.unmarshal_int();
/* 180 */           _os_.unmarshal_int();
/*     */         }
/* 182 */         _os_.unmarshal_int();
/* 183 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 186 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 188 */           SOperaInstanceCfg _v_ = new SOperaInstanceCfg();
/* 189 */           _v_.unmarshal(_os_);
/* 190 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 191 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 196 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SOperaInstanceCfg> all)
/*     */   {
/* 208 */     String path = dir + "mzm.gsp.instance.confbean.SOperaInstanceCfg.bny";
/*     */     try
/*     */     {
/* 211 */       File file = new File(path);
/* 212 */       if (file.exists())
/*     */       {
/* 214 */         byte[] bytes = new byte['Ѐ'];
/* 215 */         FileInputStream fis = new FileInputStream(file);
/* 216 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 217 */         int len = 0;
/* 218 */         while ((len = fis.read(bytes)) > 0)
/* 219 */           baos.write(bytes, 0, len);
/* 220 */         fis.close();
/* 221 */         bytes = baos.toByteArray();
/* 222 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 223 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 225 */           _os_.unmarshal_int();
/* 226 */           _os_.unmarshal_int();
/* 227 */           _os_.unmarshal_int();
/*     */         }
/* 229 */         _os_.unmarshal_int();
/* 230 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 233 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 235 */           SOperaInstanceCfg _v_ = new SOperaInstanceCfg();
/* 236 */           _v_.unmarshal(_os_);
/* 237 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 238 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 243 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 248 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SOperaInstanceCfg getOld(int key)
/*     */   {
/* 256 */     return (SOperaInstanceCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SOperaInstanceCfg get(int key)
/*     */   {
/* 261 */     return (SOperaInstanceCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOperaInstanceCfg> getOldAll()
/*     */   {
/* 266 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOperaInstanceCfg> getAll()
/*     */   {
/* 271 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SOperaInstanceCfg> newAll)
/*     */   {
/* 276 */     oldAll = all;
/* 277 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 282 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\confbean\SOperaInstanceCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */