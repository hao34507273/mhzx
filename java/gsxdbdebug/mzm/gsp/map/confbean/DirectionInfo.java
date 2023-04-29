/*    */ package mzm.gsp.map.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class DirectionInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int width;
/*    */   public int height;
/*    */   public int offseX;
/*    */   public int offseY;
/*    */   public int countX;
/*    */   public int countY;
/* 15 */   public ArrayList<Integer> cells = new ArrayList();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 19 */     this.width = Integer.valueOf(rootElement.attributeValue("width")).intValue();
/* 20 */     this.height = Integer.valueOf(rootElement.attributeValue("height")).intValue();
/* 21 */     this.offseX = Integer.valueOf(rootElement.attributeValue("offseX")).intValue();
/* 22 */     this.offseY = Integer.valueOf(rootElement.attributeValue("offseY")).intValue();
/* 23 */     this.countX = Integer.valueOf(rootElement.attributeValue("countX")).intValue();
/* 24 */     this.countY = Integer.valueOf(rootElement.attributeValue("countY")).intValue();
/*    */     
/* 26 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "cells");
/* 27 */     if (collectionElement == null)
/*    */     {
/* 29 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 32 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 33 */     int _len = _nodeList.size();
/* 34 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 36 */       Element elem = (Element)_nodeList.get(i);
/* 37 */       if (elem.getName().equalsIgnoreCase("int"))
/*    */       {
/*    */         int _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 44 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 51 */         this.cells.add(Integer.valueOf(_v_));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 58 */     _os_.marshal(this.width);
/* 59 */     _os_.marshal(this.height);
/* 60 */     _os_.marshal(this.offseX);
/* 61 */     _os_.marshal(this.offseY);
/* 62 */     _os_.marshal(this.countX);
/* 63 */     _os_.marshal(this.countY);
/* 64 */     _os_.compact_uint32(this.cells.size());
/* 65 */     for (Integer _v_ : this.cells)
/*    */     {
/* 67 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 74 */     this.width = _os_.unmarshal_int();
/* 75 */     this.height = _os_.unmarshal_int();
/* 76 */     this.offseX = _os_.unmarshal_int();
/* 77 */     this.offseY = _os_.unmarshal_int();
/* 78 */     this.countX = _os_.unmarshal_int();
/* 79 */     this.countY = _os_.unmarshal_int();
/* 80 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 83 */       int _v_ = _os_.unmarshal_int();
/* 84 */       this.cells.add(Integer.valueOf(_v_));
/*    */     }
/* 86 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\DirectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */