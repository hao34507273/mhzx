/*    */ package mzm.gsp.wing.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class STRanProInfos implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int weightSum;
/* 10 */   public HashMap<Integer, Integer> ranProInfos = new HashMap();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.weightSum = Integer.valueOf(rootElement.attributeValue("weightSum")).intValue();
/*    */     
/* 16 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "ranProInfos");
/* 17 */     if (mapTypeElement == null)
/*    */     {
/* 19 */       throw new RuntimeException("map type element does not find");
/*    */     }
/*    */     
/* 22 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/* 23 */     int entryLen = entryNodeList.size();
/* 24 */     for (int i = 0; i < entryLen; i++)
/*    */     {
/* 26 */       Element entryElement = (Element)entryNodeList.get(i);
/* 27 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 32 */         Element keyElem = null;
/* 33 */         Element valueElem = null;
/*    */         
/* 35 */         java.util.List<?> _nodeList = entryElement.elements();
/* 36 */         int _len = _nodeList.size();
/* 37 */         for (int j = 0; j < _len; j++)
/*    */         {
/* 39 */           Element elem = (Element)_nodeList.get(j);
/* 40 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*    */           {
/* 42 */             keyElem = elem;
/*    */           }
/* 44 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*    */           {
/* 46 */             valueElem = elem;
/*    */           }
/*    */         }
/*    */         
/* 50 */         if ((keyElem == null) || (valueElem == null))
/*    */         {
/* 52 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*    */         }
/*    */         
/*    */         int _k_;
/*    */         int _v_;
/*    */         try
/*    */         {
/* 59 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 60 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 67 */         this.ranProInfos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 74 */     _os_.marshal(this.weightSum);
/* 75 */     _os_.compact_uint32(this.ranProInfos.size());
/* 76 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.ranProInfos.entrySet())
/*    */     {
/* 78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 79 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 81 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 86 */     this.weightSum = _os_.unmarshal_int();
/* 87 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 90 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 92 */       int _v_ = _os_.unmarshal_int();
/* 93 */       this.ranProInfos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 95 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\confbean\STRanProInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */