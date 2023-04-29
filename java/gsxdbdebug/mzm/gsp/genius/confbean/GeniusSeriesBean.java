/*    */ package mzm.gsp.genius.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class GeniusSeriesBean implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int id;
/*    */   public int defaultOpen;
/*    */   public String uiName;
/* 12 */   public ArrayList<Integer> genius = new ArrayList();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 17 */     this.defaultOpen = Integer.valueOf(rootElement.attributeValue("defaultOpen")).intValue();
/* 18 */     this.uiName = rootElement.attributeValue("uiName");
/*    */     
/* 20 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "genius");
/* 21 */     if (collectionElement == null)
/*    */     {
/* 23 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 26 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 27 */     int _len = _nodeList.size();
/* 28 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 30 */       Element elem = (Element)_nodeList.get(i);
/* 31 */       if (elem.getName().equalsIgnoreCase("int"))
/*    */       {
/*    */         int _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 38 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 45 */         this.genius.add(Integer.valueOf(_v_));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 52 */     _os_.marshal(this.id);
/* 53 */     _os_.marshal(this.defaultOpen);
/* 54 */     _os_.marshal(this.uiName, "UTF-8");
/* 55 */     _os_.compact_uint32(this.genius.size());
/* 56 */     for (Integer _v_ : this.genius)
/*    */     {
/* 58 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 65 */     this.id = _os_.unmarshal_int();
/* 66 */     this.defaultOpen = _os_.unmarshal_int();
/* 67 */     this.uiName = _os_.unmarshal_String("UTF-8");
/* 68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 71 */       int _v_ = _os_.unmarshal_int();
/* 72 */       this.genius.add(Integer.valueOf(_v_));
/*    */     }
/* 74 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\confbean\GeniusSeriesBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */