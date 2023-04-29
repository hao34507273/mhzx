/*     */ package mzm.gsp.pvc.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.List;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class PVCRobotCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int levelMax;
/*     */   public int levelMin;
/*     */   public int gender;
/*     */   public int roleRobotid;
/*  13 */   public java.util.ArrayList<Integer> petRobotids = new java.util.ArrayList();
/*     */   public int partnerRobotCount;
/*  15 */   public java.util.HashMap<Integer, Integer> partnerRandomMap = new java.util.HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  19 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/*  20 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/*  21 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/*  22 */     this.roleRobotid = Integer.valueOf(rootElement.attributeValue("roleRobotid")).intValue();
/*     */     
/*  24 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "petRobotids");
/*  25 */     if (collectionElement == null)
/*     */     {
/*  27 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  30 */     List<?> _nodeList = collectionElement.elements();
/*  31 */     int _len = _nodeList.size();
/*  32 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  34 */       Element elem = (Element)_nodeList.get(i);
/*  35 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  42 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  49 */         this.petRobotids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  52 */     this.partnerRobotCount = Integer.valueOf(rootElement.attributeValue("partnerRobotCount")).intValue();
/*     */     
/*  54 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "partnerRandomMap");
/*  55 */     if (mapTypeElement == null)
/*     */     {
/*  57 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  60 */     List<?> entryNodeList = mapTypeElement.elements();
/*  61 */     int entryLen = entryNodeList.size();
/*  62 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  64 */       Element entryElement = (Element)entryNodeList.get(i);
/*  65 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  70 */         Element keyElem = null;
/*  71 */         Element valueElem = null;
/*     */         
/*  73 */         List<?> _nodeList = entryElement.elements();
/*  74 */         int _len = _nodeList.size();
/*  75 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  77 */           Element elem = (Element)_nodeList.get(j);
/*  78 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  80 */             keyElem = elem;
/*     */           }
/*  82 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  84 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  88 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  90 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  97 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  98 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 105 */         this.partnerRandomMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 112 */     _os_.marshal(this.levelMax);
/* 113 */     _os_.marshal(this.levelMin);
/* 114 */     _os_.marshal(this.gender);
/* 115 */     _os_.marshal(this.roleRobotid);
/* 116 */     _os_.compact_uint32(this.petRobotids.size());
/* 117 */     for (Integer _v_ : this.petRobotids)
/*     */     {
/* 119 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 121 */     _os_.marshal(this.partnerRobotCount);
/* 122 */     _os_.compact_uint32(this.partnerRandomMap.size());
/* 123 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.partnerRandomMap.entrySet())
/*     */     {
/* 125 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 126 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 128 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 133 */     this.levelMax = _os_.unmarshal_int();
/* 134 */     this.levelMin = _os_.unmarshal_int();
/* 135 */     this.gender = _os_.unmarshal_int();
/* 136 */     this.roleRobotid = _os_.unmarshal_int();
/* 137 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 140 */       int _v_ = _os_.unmarshal_int();
/* 141 */       this.petRobotids.add(Integer.valueOf(_v_));
/*     */     }
/* 143 */     this.partnerRobotCount = _os_.unmarshal_int();
/* 144 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 147 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 149 */       int _v_ = _os_.unmarshal_int();
/* 150 */       this.partnerRandomMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 152 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pvc\confbean\PVCRobotCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */