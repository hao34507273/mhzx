/*    */ package mzm.gsp.activity4.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FlowerParadeMapCfg implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int pathId;
/*    */   public int mapId;
/* 11 */   public ArrayList<FlowerParadeRestPos> restPosList = new ArrayList();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.pathId = Integer.valueOf(rootElement.attributeValue("pathId")).intValue();
/* 16 */     this.mapId = Integer.valueOf(rootElement.attributeValue("mapId")).intValue();
/*    */     
/* 18 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "restPosList");
/* 19 */     if (collectionElement == null)
/*    */     {
/* 21 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 24 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 25 */     int _len = _nodeList.size();
/* 26 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 28 */       Element elem = (Element)_nodeList.get(i);
/* 29 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.activity4.confbean.FlowerParadeRestPos"))
/*    */       {
/*    */         FlowerParadeRestPos _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 36 */           _v_ = new FlowerParadeRestPos();
/* 37 */           _v_.loadFromXml(elem);
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 44 */         this.restPosList.add(_v_);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 51 */     _os_.marshal(this.pathId);
/* 52 */     _os_.marshal(this.mapId);
/* 53 */     _os_.compact_uint32(this.restPosList.size());
/* 54 */     for (FlowerParadeRestPos _v_ : this.restPosList)
/*    */     {
/* 56 */       _os_.marshal(_v_);
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 63 */     this.pathId = _os_.unmarshal_int();
/* 64 */     this.mapId = _os_.unmarshal_int();
/* 65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 68 */       FlowerParadeRestPos _v_ = new FlowerParadeRestPos();
/* 69 */       _v_.unmarshal(_os_);
/* 70 */       this.restPosList.add(_v_);
/*    */     }
/* 72 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\FlowerParadeMapCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */