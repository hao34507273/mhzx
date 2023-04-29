/*    */ package mzm.gsp.grow.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class STDayTargetData implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*  9 */   public ArrayList<Integer> cfgIds = new ArrayList();
/*    */   
/*    */   public int weightSum;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "cfgIds");
/* 16 */     if (collectionElement == null)
/*    */     {
/* 18 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 21 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 22 */     int _len = _nodeList.size();
/* 23 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 25 */       Element elem = (Element)_nodeList.get(i);
/* 26 */       if (elem.getName().equalsIgnoreCase("int"))
/*    */       {
/*    */         int _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 33 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 40 */         this.cfgIds.add(Integer.valueOf(_v_));
/*    */       }
/*    */     }
/* 43 */     this.weightSum = Integer.valueOf(rootElement.attributeValue("weightSum")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 48 */     _os_.compact_uint32(this.cfgIds.size());
/* 49 */     for (Integer _v_ : this.cfgIds)
/*    */     {
/* 51 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 53 */     _os_.marshal(this.weightSum);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 62 */       int _v_ = _os_.unmarshal_int();
/* 63 */       this.cfgIds.add(Integer.valueOf(_v_));
/*    */     }
/* 65 */     this.weightSum = _os_.unmarshal_int();
/* 66 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\confbean\STDayTargetData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */