/*    */ package mzm.gsp.partner.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class STPropPerLevel implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*  9 */   public HashMap<Integer, Double> pro2value = new HashMap();
/*    */   
/*    */ 
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "pro2value");
/* 15 */     if (mapTypeElement == null)
/*    */     {
/* 17 */       throw new RuntimeException("map type element does not find");
/*    */     }
/*    */     
/* 20 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/* 21 */     int entryLen = entryNodeList.size();
/* 22 */     for (int i = 0; i < entryLen; i++)
/*    */     {
/* 24 */       Element entryElement = (Element)entryNodeList.get(i);
/* 25 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 30 */         Element keyElem = null;
/* 31 */         Element valueElem = null;
/*    */         
/* 33 */         java.util.List<?> _nodeList = entryElement.elements();
/* 34 */         int _len = _nodeList.size();
/* 35 */         for (int j = 0; j < _len; j++)
/*    */         {
/* 37 */           Element elem = (Element)_nodeList.get(j);
/* 38 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*    */           {
/* 40 */             keyElem = elem;
/*    */           }
/* 42 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("float")))
/*    */           {
/* 44 */             valueElem = elem;
/*    */           }
/*    */         }
/*    */         
/* 48 */         if ((keyElem == null) || (valueElem == null))
/*    */         {
/* 50 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*    */         }
/*    */         
/*    */         int _k_;
/*    */         double _v_;
/*    */         try
/*    */         {
/* 57 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 58 */           _v_ = Double.valueOf(valueElem.getText()).doubleValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 65 */         this.pro2value.put(Integer.valueOf(_k_), Double.valueOf(_v_));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 72 */     _os_.compact_uint32(this.pro2value.size());
/* 73 */     for (java.util.Map.Entry<Integer, Double> _e_ : this.pro2value.entrySet())
/*    */     {
/* 75 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 76 */       _os_.marshal(((Double)_e_.getValue()).doubleValue());
/*    */     }
/* 78 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 83 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 86 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 88 */       double _v_ = _os_.unmarshal_float();
/* 89 */       this.pro2value.put(Integer.valueOf(_k_), Double.valueOf(_v_));
/*    */     }
/* 91 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\confbean\STPropPerLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */