/*     */ package mzm.gsp.map.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.List;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SMapVisibleMonster implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int cfgid;
/*     */   public int monsterType;
/*     */   public int mapCfgId;
/*     */   public int talkStop;
/*     */   public int num;
/*     */   public Loc location;
/*     */   public boolean isRandomInRange;
/*  16 */   public java.util.ArrayList<Integer> regions = new java.util.ArrayList();
/*     */   public int randomRegionProbBase;
/*  18 */   public java.util.TreeMap<Integer, Integer> randomRegions = new java.util.TreeMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  22 */     this.cfgid = Integer.valueOf(rootElement.attributeValue("cfgid")).intValue();
/*  23 */     this.monsterType = Integer.valueOf(rootElement.attributeValue("monsterType")).intValue();
/*  24 */     this.mapCfgId = Integer.valueOf(rootElement.attributeValue("mapCfgId")).intValue();
/*  25 */     this.talkStop = Integer.valueOf(rootElement.attributeValue("talkStop")).intValue();
/*  26 */     this.num = Integer.valueOf(rootElement.attributeValue("num")).intValue();
/*     */     
/*  28 */     Element beanElement = util.XmlHelper.getVariableElement(rootElement, "location");
/*  29 */     if (beanElement == null)
/*     */     {
/*  31 */       throw new RuntimeException("beanElement element does not find");
/*     */     }
/*     */     
/*  34 */     List<?> _nodeList = beanElement.elements();
/*  35 */     int _len = _nodeList.size();
/*  36 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  38 */       Element elem = (Element)_nodeList.get(i);
/*  39 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.Loc"))
/*     */       {
/*     */ 
/*     */         try
/*     */         {
/*     */ 
/*  45 */           this.location = new Loc();
/*  46 */           this.location.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e) {}
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  55 */     this.isRandomInRange = Boolean.valueOf(rootElement.attributeValue("isRandomInRange")).booleanValue();
/*     */     
/*  57 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "regions");
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
/*  82 */         this.regions.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  85 */     this.randomRegionProbBase = Integer.valueOf(rootElement.attributeValue("randomRegionProbBase")).intValue();
/*     */     
/*  87 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "randomRegions");
/*  88 */     if (mapTypeElement == null)
/*     */     {
/*  90 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  93 */     List<?> entryNodeList = mapTypeElement.elements();
/*  94 */     int entryLen = entryNodeList.size();
/*  95 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  97 */       Element entryElement = (Element)entryNodeList.get(i);
/*  98 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 103 */         Element keyElem = null;
/* 104 */         Element valueElem = null;
/*     */         
/* 106 */         List<?> _nodeList = entryElement.elements();
/* 107 */         int _len = _nodeList.size();
/* 108 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 110 */           Element elem = (Element)_nodeList.get(j);
/* 111 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 113 */             keyElem = elem;
/*     */           }
/* 115 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 117 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 121 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 123 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 130 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 131 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 138 */         this.randomRegions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 145 */     _os_.marshal(this.cfgid);
/* 146 */     _os_.marshal(this.monsterType);
/* 147 */     _os_.marshal(this.mapCfgId);
/* 148 */     _os_.marshal(this.talkStop);
/* 149 */     _os_.marshal(this.num);
/* 150 */     _os_.marshal(this.location);
/* 151 */     _os_.marshal(this.isRandomInRange);
/* 152 */     _os_.compact_uint32(this.regions.size());
/* 153 */     for (Integer _v_ : this.regions)
/*     */     {
/* 155 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 157 */     _os_.marshal(this.randomRegionProbBase);
/* 158 */     _os_.compact_uint32(this.randomRegions.size());
/* 159 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.randomRegions.entrySet())
/*     */     {
/* 161 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 162 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 164 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 169 */     this.cfgid = _os_.unmarshal_int();
/* 170 */     this.monsterType = _os_.unmarshal_int();
/* 171 */     this.mapCfgId = _os_.unmarshal_int();
/* 172 */     this.talkStop = _os_.unmarshal_int();
/* 173 */     this.num = _os_.unmarshal_int();
/* 174 */     this.location = new Loc();
/* 175 */     this.location.unmarshal(_os_);
/* 176 */     this.isRandomInRange = _os_.unmarshal_boolean();
/* 177 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 180 */       int _v_ = _os_.unmarshal_int();
/* 181 */       this.regions.add(Integer.valueOf(_v_));
/*     */     }
/* 183 */     this.randomRegionProbBase = _os_.unmarshal_int();
/* 184 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 187 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 189 */       int _v_ = _os_.unmarshal_int();
/* 190 */       this.randomRegions.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 192 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapVisibleMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */