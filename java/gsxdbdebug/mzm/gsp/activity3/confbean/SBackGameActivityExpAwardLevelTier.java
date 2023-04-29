/*    */ package mzm.gsp.activity3.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SBackGameActivityExpAwardLevelTier implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int levelMin;
/*    */   public int levelMax;
/* 11 */   public HashMap<Integer, Integer> index2awardId = new HashMap();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/* 16 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/*    */     
/* 18 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "index2awardId");
/* 19 */     if (mapTypeElement == null)
/*    */     {
/* 21 */       throw new RuntimeException("map type element does not find");
/*    */     }
/*    */     
/* 24 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/* 25 */     int entryLen = entryNodeList.size();
/* 26 */     for (int i = 0; i < entryLen; i++)
/*    */     {
/* 28 */       Element entryElement = (Element)entryNodeList.get(i);
/* 29 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 34 */         Element keyElem = null;
/* 35 */         Element valueElem = null;
/*    */         
/* 37 */         java.util.List<?> _nodeList = entryElement.elements();
/* 38 */         int _len = _nodeList.size();
/* 39 */         for (int j = 0; j < _len; j++)
/*    */         {
/* 41 */           Element elem = (Element)_nodeList.get(j);
/* 42 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*    */           {
/* 44 */             keyElem = elem;
/*    */           }
/* 46 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*    */           {
/* 48 */             valueElem = elem;
/*    */           }
/*    */         }
/*    */         
/* 52 */         if ((keyElem == null) || (valueElem == null))
/*    */         {
/* 54 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*    */         }
/*    */         
/*    */         int _k_;
/*    */         int _v_;
/*    */         try
/*    */         {
/* 61 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 62 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 69 */         this.index2awardId.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 76 */     _os_.marshal(this.levelMin);
/* 77 */     _os_.marshal(this.levelMax);
/* 78 */     _os_.compact_uint32(this.index2awardId.size());
/* 79 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.index2awardId.entrySet())
/*    */     {
/* 81 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 82 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 84 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 89 */     this.levelMin = _os_.unmarshal_int();
/* 90 */     this.levelMax = _os_.unmarshal_int();
/* 91 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 94 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 96 */       int _v_ = _os_.unmarshal_int();
/* 97 */       this.index2awardId.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 99 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\SBackGameActivityExpAwardLevelTier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */