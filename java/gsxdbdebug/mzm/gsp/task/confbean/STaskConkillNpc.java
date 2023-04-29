/*     */ package mzm.gsp.task.confbean;
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
/*     */ public class STaskConkillNpc implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STaskConkillNpc> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STaskConkillNpc> all = null;
/*     */   
/*     */   public int id;
/*     */   public int contype;
/*     */   public int fixNPCId;
/*     */   public boolean joinBattleConfirm;
/*  22 */   public ArrayList<Integer> battleIDs = new ArrayList();
/*  23 */   public ArrayList<Integer> playerRanges = new ArrayList();
/*     */   public boolean onlineFirst;
/*     */   public int needPersonCount;
/*     */   public boolean allHaveTaskFight;
/*     */   public int pvcId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  32 */     this.contype = Integer.valueOf(rootElement.attributeValue("contype")).intValue();
/*  33 */     this.fixNPCId = Integer.valueOf(rootElement.attributeValue("fixNPCId")).intValue();
/*  34 */     this.joinBattleConfirm = Boolean.valueOf(rootElement.attributeValue("joinBattleConfirm")).booleanValue();
/*     */     
/*  36 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "battleIDs");
/*  37 */     if (collectionElement == null)
/*     */     {
/*  39 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  42 */     List<?> _nodeList = collectionElement.elements();
/*  43 */     int _len = _nodeList.size();
/*  44 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  46 */       Element elem = (Element)_nodeList.get(i);
/*  47 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  54 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  61 */         this.battleIDs.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  65 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "playerRanges");
/*  66 */     if (collectionElement == null)
/*     */     {
/*  68 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  71 */     List<?> _nodeList = collectionElement.elements();
/*  72 */     int _len = _nodeList.size();
/*  73 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  75 */       Element elem = (Element)_nodeList.get(i);
/*  76 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  83 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  90 */         this.playerRanges.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  93 */     this.onlineFirst = Boolean.valueOf(rootElement.attributeValue("onlineFirst")).booleanValue();
/*  94 */     this.needPersonCount = Integer.valueOf(rootElement.attributeValue("needPersonCount")).intValue();
/*  95 */     this.allHaveTaskFight = Boolean.valueOf(rootElement.attributeValue("allHaveTaskFight")).booleanValue();
/*  96 */     this.pvcId = Integer.valueOf(rootElement.attributeValue("pvcId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 101 */     _os_.marshal(this.id);
/* 102 */     _os_.marshal(this.contype);
/* 103 */     _os_.marshal(this.fixNPCId);
/* 104 */     _os_.marshal(this.joinBattleConfirm);
/* 105 */     _os_.compact_uint32(this.battleIDs.size());
/* 106 */     for (Integer _v_ : this.battleIDs)
/*     */     {
/* 108 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 110 */     _os_.compact_uint32(this.playerRanges.size());
/* 111 */     for (Integer _v_ : this.playerRanges)
/*     */     {
/* 113 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 115 */     _os_.marshal(this.onlineFirst);
/* 116 */     _os_.marshal(this.needPersonCount);
/* 117 */     _os_.marshal(this.allHaveTaskFight);
/* 118 */     _os_.marshal(this.pvcId);
/* 119 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 124 */     this.id = _os_.unmarshal_int();
/* 125 */     this.contype = _os_.unmarshal_int();
/* 126 */     this.fixNPCId = _os_.unmarshal_int();
/* 127 */     this.joinBattleConfirm = _os_.unmarshal_boolean();
/* 128 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 131 */       int _v_ = _os_.unmarshal_int();
/* 132 */       this.battleIDs.add(Integer.valueOf(_v_));
/*     */     }
/* 134 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 137 */       int _v_ = _os_.unmarshal_int();
/* 138 */       this.playerRanges.add(Integer.valueOf(_v_));
/*     */     }
/* 140 */     this.onlineFirst = _os_.unmarshal_boolean();
/* 141 */     this.needPersonCount = _os_.unmarshal_int();
/* 142 */     this.allHaveTaskFight = _os_.unmarshal_boolean();
/* 143 */     this.pvcId = _os_.unmarshal_int();
/* 144 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 149 */     String path = dir + "mzm.gsp.task.confbean.STaskConkillNpc.xml";
/*     */     
/*     */     try
/*     */     {
/* 153 */       all = new java.util.HashMap();
/* 154 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 155 */       org.dom4j.Document doc = reader.read(new File(path));
/* 156 */       Element root = doc.getRootElement();
/* 157 */       List<?> nodeList = root.elements();
/* 158 */       int len = nodeList.size();
/* 159 */       for (int i = 0; i < len; i++)
/*     */       {
/* 161 */         Element elem = (Element)nodeList.get(i);
/* 162 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.STaskConkillNpc"))
/*     */         {
/*     */ 
/* 165 */           STaskConkillNpc obj = new STaskConkillNpc();
/* 166 */           obj.loadFromXml(elem);
/* 167 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 168 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 173 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STaskConkillNpc> all)
/*     */   {
/* 179 */     String path = dir + "mzm.gsp.task.confbean.STaskConkillNpc.xml";
/*     */     
/*     */     try
/*     */     {
/* 183 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 184 */       org.dom4j.Document doc = reader.read(new File(path));
/* 185 */       Element root = doc.getRootElement();
/* 186 */       List<?> nodeList = root.elements();
/* 187 */       int len = nodeList.size();
/* 188 */       for (int i = 0; i < len; i++)
/*     */       {
/* 190 */         Element elem = (Element)nodeList.get(i);
/* 191 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.task.confbean.STaskConkillNpc"))
/*     */         {
/*     */ 
/* 194 */           STaskConkillNpc obj = new STaskConkillNpc();
/* 195 */           obj.loadFromXml(elem);
/* 196 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 197 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 202 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 208 */     all = new java.util.HashMap();
/*     */     
/* 210 */     String path = dir + "mzm.gsp.task.confbean.STaskConkillNpc.bny";
/*     */     try
/*     */     {
/* 213 */       File file = new File(path);
/* 214 */       if (file.exists())
/*     */       {
/* 216 */         byte[] bytes = new byte['Ѐ'];
/* 217 */         FileInputStream fis = new FileInputStream(file);
/* 218 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 219 */         int len = 0;
/* 220 */         while ((len = fis.read(bytes)) > 0)
/* 221 */           baos.write(bytes, 0, len);
/* 222 */         fis.close();
/* 223 */         bytes = baos.toByteArray();
/* 224 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 225 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 227 */           _os_.unmarshal_int();
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/*     */         }
/* 231 */         _os_.unmarshal_int();
/* 232 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 235 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 237 */           STaskConkillNpc _v_ = new STaskConkillNpc();
/* 238 */           _v_.unmarshal(_os_);
/* 239 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 240 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 245 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 250 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STaskConkillNpc> all)
/*     */   {
/* 257 */     String path = dir + "mzm.gsp.task.confbean.STaskConkillNpc.bny";
/*     */     try
/*     */     {
/* 260 */       File file = new File(path);
/* 261 */       if (file.exists())
/*     */       {
/* 263 */         byte[] bytes = new byte['Ѐ'];
/* 264 */         FileInputStream fis = new FileInputStream(file);
/* 265 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 266 */         int len = 0;
/* 267 */         while ((len = fis.read(bytes)) > 0)
/* 268 */           baos.write(bytes, 0, len);
/* 269 */         fis.close();
/* 270 */         bytes = baos.toByteArray();
/* 271 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 272 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 274 */           _os_.unmarshal_int();
/* 275 */           _os_.unmarshal_int();
/* 276 */           _os_.unmarshal_int();
/*     */         }
/* 278 */         _os_.unmarshal_int();
/* 279 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 282 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 284 */           STaskConkillNpc _v_ = new STaskConkillNpc();
/* 285 */           _v_.unmarshal(_os_);
/* 286 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 287 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 292 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 297 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STaskConkillNpc getOld(int key)
/*     */   {
/* 305 */     return (STaskConkillNpc)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STaskConkillNpc get(int key)
/*     */   {
/* 310 */     return (STaskConkillNpc)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STaskConkillNpc> getOldAll()
/*     */   {
/* 315 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STaskConkillNpc> getAll()
/*     */   {
/* 320 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STaskConkillNpc> newAll)
/*     */   {
/* 325 */     oldAll = all;
/* 326 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 331 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\confbean\STaskConkillNpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */