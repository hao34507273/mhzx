/*     */ package mzm.gsp.npc.confbean;
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
/*     */ public class STempNpc implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STempNpc> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STempNpc> all = null;
/*     */   
/*     */   public int id;
/*     */   public String npcName;
/*     */   public String miniMapName;
/*     */   public String npcTile;
/*     */   public int npcType;
/*     */   public int npcIconId;
/*     */   public boolean isInAir;
/*     */   public boolean isAutoTurning;
/*     */   public boolean isVisible;
/*     */   public boolean canSearch;
/*     */   public boolean canTeamMemberOpenDialog;
/*     */   public int refreshTime;
/*  30 */   public ArrayList<Integer> npcServiceTradeList = new ArrayList();
/*  31 */   public ArrayList<String> autoTalkList = new ArrayList();
/*  32 */   public ArrayList<String> defaultTalkList = new ArrayList();
/*     */   public int npcState;
/*     */   public int autoAudioId;
/*     */   public int defaultAudioId;
/*     */   public int dyeMode;
/*     */   public int outlookid;
/*     */   public int controllerId;
/*     */   public int monsterModelTableId;
/*     */   public int miniMapNameColor;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  44 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  45 */     this.npcName = rootElement.attributeValue("npcName");
/*  46 */     this.miniMapName = rootElement.attributeValue("miniMapName");
/*  47 */     this.npcTile = rootElement.attributeValue("npcTile");
/*  48 */     this.npcType = Integer.valueOf(rootElement.attributeValue("npcType")).intValue();
/*  49 */     this.npcIconId = Integer.valueOf(rootElement.attributeValue("npcIconId")).intValue();
/*  50 */     this.isInAir = Boolean.valueOf(rootElement.attributeValue("isInAir")).booleanValue();
/*  51 */     this.isAutoTurning = Boolean.valueOf(rootElement.attributeValue("isAutoTurning")).booleanValue();
/*  52 */     this.isVisible = Boolean.valueOf(rootElement.attributeValue("isVisible")).booleanValue();
/*  53 */     this.canSearch = Boolean.valueOf(rootElement.attributeValue("canSearch")).booleanValue();
/*  54 */     this.canTeamMemberOpenDialog = Boolean.valueOf(rootElement.attributeValue("canTeamMemberOpenDialog")).booleanValue();
/*  55 */     this.refreshTime = Integer.valueOf(rootElement.attributeValue("refreshTime")).intValue();
/*     */     
/*  57 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "npcServiceTradeList");
/*  58 */     if (collectionElement == null)
/*     */     {
/*  60 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  63 */     List<?> _nodeList = collectionElement.elements();
/*  64 */     int _len = _nodeList.size();
/*  65 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  67 */       Element elem = (Element)_nodeList.get(i);
/*  68 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  75 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  82 */         this.npcServiceTradeList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  86 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "autoTalkList");
/*  87 */     if (collectionElement == null)
/*     */     {
/*  89 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  92 */     List<?> _nodeList = collectionElement.elements();
/*  93 */     int _len = _nodeList.size();
/*  94 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  96 */       Element elem = (Element)_nodeList.get(i);
/*  97 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 104 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 111 */         this.autoTalkList.add(_v_);
/*     */       }
/*     */     }
/*     */     
/* 115 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "defaultTalkList");
/* 116 */     if (collectionElement == null)
/*     */     {
/* 118 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 121 */     List<?> _nodeList = collectionElement.elements();
/* 122 */     int _len = _nodeList.size();
/* 123 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 125 */       Element elem = (Element)_nodeList.get(i);
/* 126 */       if (elem.getName().equalsIgnoreCase("string"))
/*     */       {
/*     */         String _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 133 */           _v_ = elem.getText();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 140 */         this.defaultTalkList.add(_v_);
/*     */       }
/*     */     }
/* 143 */     this.npcState = Integer.valueOf(rootElement.attributeValue("npcState")).intValue();
/* 144 */     this.autoAudioId = Integer.valueOf(rootElement.attributeValue("autoAudioId")).intValue();
/* 145 */     this.defaultAudioId = Integer.valueOf(rootElement.attributeValue("defaultAudioId")).intValue();
/* 146 */     this.dyeMode = Integer.valueOf(rootElement.attributeValue("dyeMode")).intValue();
/* 147 */     this.outlookid = Integer.valueOf(rootElement.attributeValue("outlookid")).intValue();
/* 148 */     this.controllerId = Integer.valueOf(rootElement.attributeValue("controllerId")).intValue();
/* 149 */     this.monsterModelTableId = Integer.valueOf(rootElement.attributeValue("monsterModelTableId")).intValue();
/* 150 */     this.miniMapNameColor = Integer.valueOf(rootElement.attributeValue("miniMapNameColor")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 155 */     _os_.marshal(this.id);
/* 156 */     _os_.marshal(this.npcName, "UTF-8");
/* 157 */     _os_.marshal(this.miniMapName, "UTF-8");
/* 158 */     _os_.marshal(this.npcTile, "UTF-8");
/* 159 */     _os_.marshal(this.npcType);
/* 160 */     _os_.marshal(this.npcIconId);
/* 161 */     _os_.marshal(this.isInAir);
/* 162 */     _os_.marshal(this.isAutoTurning);
/* 163 */     _os_.marshal(this.isVisible);
/* 164 */     _os_.marshal(this.canSearch);
/* 165 */     _os_.marshal(this.canTeamMemberOpenDialog);
/* 166 */     _os_.marshal(this.refreshTime);
/* 167 */     _os_.compact_uint32(this.npcServiceTradeList.size());
/* 168 */     for (Integer _v_ : this.npcServiceTradeList)
/*     */     {
/* 170 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 172 */     _os_.compact_uint32(this.autoTalkList.size());
/* 173 */     for (String _v_ : this.autoTalkList)
/*     */     {
/* 175 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/* 177 */     _os_.compact_uint32(this.defaultTalkList.size());
/* 178 */     for (String _v_ : this.defaultTalkList)
/*     */     {
/* 180 */       _os_.marshal(_v_, "UTF-8");
/*     */     }
/* 182 */     _os_.marshal(this.npcState);
/* 183 */     _os_.marshal(this.autoAudioId);
/* 184 */     _os_.marshal(this.defaultAudioId);
/* 185 */     _os_.marshal(this.dyeMode);
/* 186 */     _os_.marshal(this.outlookid);
/* 187 */     _os_.marshal(this.controllerId);
/* 188 */     _os_.marshal(this.monsterModelTableId);
/* 189 */     _os_.marshal(this.miniMapNameColor);
/* 190 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 195 */     this.id = _os_.unmarshal_int();
/* 196 */     this.npcName = _os_.unmarshal_String("UTF-8");
/* 197 */     this.miniMapName = _os_.unmarshal_String("UTF-8");
/* 198 */     this.npcTile = _os_.unmarshal_String("UTF-8");
/* 199 */     this.npcType = _os_.unmarshal_int();
/* 200 */     this.npcIconId = _os_.unmarshal_int();
/* 201 */     this.isInAir = _os_.unmarshal_boolean();
/* 202 */     this.isAutoTurning = _os_.unmarshal_boolean();
/* 203 */     this.isVisible = _os_.unmarshal_boolean();
/* 204 */     this.canSearch = _os_.unmarshal_boolean();
/* 205 */     this.canTeamMemberOpenDialog = _os_.unmarshal_boolean();
/* 206 */     this.refreshTime = _os_.unmarshal_int();
/* 207 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 210 */       int _v_ = _os_.unmarshal_int();
/* 211 */       this.npcServiceTradeList.add(Integer.valueOf(_v_));
/*     */     }
/* 213 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 216 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 217 */       this.autoTalkList.add(_v_);
/*     */     }
/* 219 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 222 */       String _v_ = _os_.unmarshal_String("UTF-8");
/* 223 */       this.defaultTalkList.add(_v_);
/*     */     }
/* 225 */     this.npcState = _os_.unmarshal_int();
/* 226 */     this.autoAudioId = _os_.unmarshal_int();
/* 227 */     this.defaultAudioId = _os_.unmarshal_int();
/* 228 */     this.dyeMode = _os_.unmarshal_int();
/* 229 */     this.outlookid = _os_.unmarshal_int();
/* 230 */     this.controllerId = _os_.unmarshal_int();
/* 231 */     this.monsterModelTableId = _os_.unmarshal_int();
/* 232 */     this.miniMapNameColor = _os_.unmarshal_int();
/* 233 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 238 */     String path = dir + "mzm.gsp.npc.confbean.STempNpc.xml";
/*     */     
/*     */     try
/*     */     {
/* 242 */       all = new java.util.HashMap();
/* 243 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 244 */       org.dom4j.Document doc = reader.read(new File(path));
/* 245 */       Element root = doc.getRootElement();
/* 246 */       List<?> nodeList = root.elements();
/* 247 */       int len = nodeList.size();
/* 248 */       for (int i = 0; i < len; i++)
/*     */       {
/* 250 */         Element elem = (Element)nodeList.get(i);
/* 251 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.npc.confbean.STempNpc"))
/*     */         {
/*     */ 
/* 254 */           STempNpc obj = new STempNpc();
/* 255 */           obj.loadFromXml(elem);
/* 256 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 257 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 262 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STempNpc> all)
/*     */   {
/* 268 */     String path = dir + "mzm.gsp.npc.confbean.STempNpc.xml";
/*     */     
/*     */     try
/*     */     {
/* 272 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 273 */       org.dom4j.Document doc = reader.read(new File(path));
/* 274 */       Element root = doc.getRootElement();
/* 275 */       List<?> nodeList = root.elements();
/* 276 */       int len = nodeList.size();
/* 277 */       for (int i = 0; i < len; i++)
/*     */       {
/* 279 */         Element elem = (Element)nodeList.get(i);
/* 280 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.npc.confbean.STempNpc"))
/*     */         {
/*     */ 
/* 283 */           STempNpc obj = new STempNpc();
/* 284 */           obj.loadFromXml(elem);
/* 285 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 286 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 291 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 297 */     all = new java.util.HashMap();
/*     */     
/* 299 */     String path = dir + "mzm.gsp.npc.confbean.STempNpc.bny";
/*     */     try
/*     */     {
/* 302 */       File file = new File(path);
/* 303 */       if (file.exists())
/*     */       {
/* 305 */         byte[] bytes = new byte['Ѐ'];
/* 306 */         FileInputStream fis = new FileInputStream(file);
/* 307 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 308 */         int len = 0;
/* 309 */         while ((len = fis.read(bytes)) > 0)
/* 310 */           baos.write(bytes, 0, len);
/* 311 */         fis.close();
/* 312 */         bytes = baos.toByteArray();
/* 313 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 314 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 316 */           _os_.unmarshal_int();
/* 317 */           _os_.unmarshal_int();
/* 318 */           _os_.unmarshal_int();
/*     */         }
/* 320 */         _os_.unmarshal_int();
/* 321 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 324 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 326 */           STempNpc _v_ = new STempNpc();
/* 327 */           _v_.unmarshal(_os_);
/* 328 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 329 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 334 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 339 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STempNpc> all)
/*     */   {
/* 346 */     String path = dir + "mzm.gsp.npc.confbean.STempNpc.bny";
/*     */     try
/*     */     {
/* 349 */       File file = new File(path);
/* 350 */       if (file.exists())
/*     */       {
/* 352 */         byte[] bytes = new byte['Ѐ'];
/* 353 */         FileInputStream fis = new FileInputStream(file);
/* 354 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 355 */         int len = 0;
/* 356 */         while ((len = fis.read(bytes)) > 0)
/* 357 */           baos.write(bytes, 0, len);
/* 358 */         fis.close();
/* 359 */         bytes = baos.toByteArray();
/* 360 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 361 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 363 */           _os_.unmarshal_int();
/* 364 */           _os_.unmarshal_int();
/* 365 */           _os_.unmarshal_int();
/*     */         }
/* 367 */         _os_.unmarshal_int();
/* 368 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 371 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 373 */           STempNpc _v_ = new STempNpc();
/* 374 */           _v_.unmarshal(_os_);
/* 375 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 376 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 381 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 386 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STempNpc getOld(int key)
/*     */   {
/* 394 */     return (STempNpc)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STempNpc get(int key)
/*     */   {
/* 399 */     return (STempNpc)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STempNpc> getOldAll()
/*     */   {
/* 404 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STempNpc> getAll()
/*     */   {
/* 409 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STempNpc> newAll)
/*     */   {
/* 414 */     oldAll = all;
/* 415 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 420 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\confbean\STempNpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */